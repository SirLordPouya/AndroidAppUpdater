package com.pouyaheydari.appupdater

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.pouyaheydari.appupdater.adapters.DirectRecyclerAdapter
import com.pouyaheydari.appupdater.adapters.StoresRecyclerAdapter
import com.pouyaheydari.appupdater.core.pojo.DialogStates
import com.pouyaheydari.appupdater.core.pojo.Store.DIRECT_URL
import com.pouyaheydari.appupdater.core.pojo.StoreListItem
import com.pouyaheydari.appupdater.core.pojo.Theme
import com.pouyaheydari.appupdater.core.utils.getApk
import com.pouyaheydari.appupdater.core.utils.shouldShowStoresDivider
import com.pouyaheydari.appupdater.databinding.FragmentAppUpdaterDialogBinding
import com.pouyaheydari.appupdater.mapper.mapToSelectedTheme
import com.pouyaheydari.appupdater.pojo.UpdaterDialogData
import com.pouyaheydari.appupdater.pojo.UpdaterFragmentModel
import com.pouyaheydari.appupdater.pojo.UserSelectedTheme
import com.pouyaheydari.appupdater.pojo.UserSelectedTheme.DARK
import com.pouyaheydari.appupdater.pojo.UserSelectedTheme.LIGHT
import com.pouyaheydari.appupdater.utils.TypefaceHolder
import com.pouyaheydari.appupdater.utils.getDialogWidth
import com.pouyaheydari.appupdater.utils.parcelable
import com.pouyaheydari.appupdater.utils.putEnum
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import com.pouyaheydari.appupdater.core.R as coreR

private const val UPDATE_DIALOG_KEY = "UPDATE_DIALOG_KEY"
private const val UPDATE_DIALOG_TAG = "UPDATE_DIALOG_TAG"
private const val UPDATE_DIALOG_README_URL = "https://github.com/SirLordPouya/AndroidAppUpdater"

/**
 * Shows ForceUpdate Dialog Fragment
 */
class AppUpdaterDialog : DialogFragment() {
    private val viewModel: AppUpdaterViewModel by viewModels()

    private var appUpdaterDialogBinding: FragmentAppUpdaterDialogBinding? = null
    private val binding get() = appUpdaterDialogBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Getting data passed to the library
        val data = arguments?.parcelable(UPDATE_DIALOG_KEY) ?: UpdaterFragmentModel.EMPTY
        if (data == UpdaterFragmentModel.EMPTY || data.storeList.isEmpty()) {
            throw IllegalArgumentException("It seems you forgot to add any data to the updater dialog. Add the data as described in $UPDATE_DIALOG_README_URL")
        }
        setDialogBackground(mapToSelectedTheme(data.theme, requireContext()))
        isCancelable = data.isForceUpdate

        appUpdaterDialogBinding = FragmentAppUpdaterDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setDialogBackground(theme: UserSelectedTheme) {
        val dialogBackground = when (theme) {
            LIGHT -> R.drawable.dialog_background
            DARK -> R.drawable.dialog_background_dark
        }
        dialog?.window?.setBackgroundDrawable(
            ContextCompat.getDrawable(requireContext(), dialogBackground),
        )
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(getDialogWidth(), WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // getData that user set's via constructor
        getData()
    }

    private fun subscribeToUpdateInProgressDialog(theme: UserSelectedTheme) {
        viewModel.screenState.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .distinctUntilChanged()
            .onEach {
                when (it) {
                    is DialogStates.DownloadApk -> getApk(it.apkUrl, requireActivity())
                    is DialogStates.OpenStore -> it.store?.showStore(requireContext())
                    DialogStates.HideUpdateInProgress -> hideUpdateInProgressDialog()
                    DialogStates.ShowUpdateInProgress -> showUpdateInProgressDialog(theme)
                    DialogStates.Empty -> hideUpdateInProgressDialog()
                }
            }.launchIn(lifecycleScope)
    }

    private fun getData() {
        val data = arguments?.parcelable(UPDATE_DIALOG_KEY) ?: UpdaterFragmentModel.EMPTY
        val title = data.title
        val description = data.description
        val list = data.storeList
        val theme = mapToSelectedTheme(data.theme, requireContext())
        setTheme(theme)
        val typeface = TypefaceHolder.typeface
        setTypeface(typeface)
        setUpProperties(title, description, list, theme, typeface)
        subscribeToUpdateInProgressDialog(theme)
    }

    private fun setTypeface(typeface: Typeface?) {
        typeface?.let {
            binding.txtTitle.typeface = it
            binding.txtDescription.typeface = it
            binding.txtOr.typeface = it
            binding.txtStore.typeface = it
        }
    }

    private fun setTheme(theme: UserSelectedTheme) {
        val textColor = when (theme) {
            LIGHT -> coreR.color.appupdater_text_colors
            DARK -> coreR.color.appupdater_text_colors_dark
        }
        with(binding) {
            txtTitle.setTextColor(getColor(requireContext(), textColor))
            txtDescription.setTextColor(getColor(requireContext(), textColor))
            txtOr.setTextColor(getColor(requireContext(), textColor))
            txtStore.setTextColor(getColor(requireContext(), textColor))
            leftOrLine.setBackgroundColor(getColor(requireContext(), textColor))
            rightOrLine.setBackgroundColor(getColor(requireContext(), textColor))
        }
    }

    private fun setUpProperties(
        title: String?,
        description: String?,
        list: List<StoreListItem>,
        theme: UserSelectedTheme,
        typeface: Typeface?,
    ) {
        binding.txtTitle.text = title
        binding.txtDescription.text = description

        val directLinks = list.filter { it.store == DIRECT_URL }
        val storeList = list.filterNot { it.store == DIRECT_URL }

        hideOrLayoutIfNeeded(shouldShowStoresDivider(directLinks, storeList))

        setUpBothRecyclers(directLinks, storeList, theme, typeface)
    }

    private fun setUpBothRecyclers(
        directDownloadList: List<StoreListItem>,
        storeList: List<StoreListItem>,
        theme: UserSelectedTheme,
        typeface: Typeface?,
    ) {
        if (directDownloadList.isNotEmpty()) {
            binding.recyclerDirect.adapter = DirectRecyclerAdapter(directDownloadList, typeface) { viewModel.onListListener(it) }
        }

        if (storeList.isNotEmpty()) {
            val spanCount = if (storeList.size > 1) 2 else 1
            binding.recyclerStores.layoutManager = GridLayoutManager(requireContext(), spanCount)
            binding.recyclerStores.adapter = StoresRecyclerAdapter(storeList, theme, typeface) { viewModel.onListListener(it) }
        }
    }

    private fun hideOrLayoutIfNeeded(storeAndDirectAvailable: Boolean) {
        binding.linearLayout.isVisible = storeAndDirectAvailable
    }

    private fun showUpdateInProgressDialog(theme: UserSelectedTheme) {
        if (parentFragmentManager.findFragmentByTag(UPDATE_DIALOG_TAG) == null && requireActivity().lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) {
            val fragment = UpdateInProgressDialog()
            val bundle = Bundle().apply {
                putEnum(THEME, theme)
            }
            fragment.arguments = bundle
            fragment.show(parentFragmentManager, UPDATE_DIALOG_TAG)
        }
    }

    private fun hideUpdateInProgressDialog() {
        if (parentFragmentManager.findFragmentByTag(UPDATE_DIALOG_TAG) != null && requireActivity().lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) {
            val dialog = parentFragmentManager.findFragmentByTag(UPDATE_DIALOG_TAG) as UpdateInProgressDialog
            dialog.dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        appUpdaterDialogBinding = null
    }

    companion object {
        /**
         * @param title Title of the dialog
         * @param description Description that is shown below the title
         * @param storeList List of all stores that user can update your app from (including [com.pouyaheydari.appupdater.core.pojo.Store.DIRECT_URL])
         * @param isForce Should the user be able to close the dialog?
         * @param typeface Typeface to be used in text views
         *
         * @return a new instance of [AppUpdaterDialog]
         */
        @Deprecated(
            message = "This function is deprecated and will be removed in the next version. Use getInstance with UpdaterDialogData input parameter instead.",
            replaceWith = ReplaceWith("this.getInstance(UpdaterDialogData())", "com.pouyaheydari.appupdater.pojo.UpdaterDialogData"),
        )
        fun getInstance(
            title: String,
            description: String,
            storeList: List<StoreListItem>,
            isForce: Boolean = false,
            typeface: Typeface? = null,
            theme: Theme = Theme.SYSTEM_DEFAULT,
        ): AppUpdaterDialog = getInstance(
            UpdaterDialogData(
                title = title,
                description = description,
                storeList = storeList,
                isForceUpdate = isForce,
                typeface = typeface,
                theme = theme,
            ),
        )

        /**
         * @param dialogData Data to be shown in the dialog
         *
         * @return a new instance of [AppUpdaterDialog]
         */
        fun getInstance(dialogData: UpdaterDialogData): AppUpdaterDialog = with(dialogData) {
            val fragment = AppUpdaterDialog()
            val data = UpdaterFragmentModel(title, description, storeList, !isForceUpdate, theme)

            TypefaceHolder.typeface = typeface
            // bundle to add data to our dialog
            val bundle = Bundle().apply { putParcelable(UPDATE_DIALOG_KEY, data) }
            fragment.arguments = bundle
            return fragment
        }
    }
}
