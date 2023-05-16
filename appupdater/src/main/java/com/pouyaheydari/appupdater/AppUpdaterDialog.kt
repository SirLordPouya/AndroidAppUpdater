package com.pouyaheydari.appupdater

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.LinearLayout.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.pouyaheydari.appupdater.adapters.DirectRecyclerAdapter
import com.pouyaheydari.appupdater.adapters.StoresRecyclerAdapter
import com.pouyaheydari.appupdater.core.pojo.DialogStates
import com.pouyaheydari.appupdater.core.pojo.Store.DIRECT_URL
import com.pouyaheydari.appupdater.core.pojo.StoreListItem
import com.pouyaheydari.appupdater.core.pojo.Theme
import com.pouyaheydari.appupdater.core.utils.getApk
import com.pouyaheydari.appupdater.core.utils.serializable
import com.pouyaheydari.appupdater.core.utils.shouldShowStoresDivider
import com.pouyaheydari.appupdater.databinding.FragmentAppUpdaterDialogBinding
import com.pouyaheydari.appupdater.mapper.mapToSelectedTheme
import com.pouyaheydari.appupdater.pojo.UpdaterFragmentModel
import com.pouyaheydari.appupdater.pojo.UserSelectedTheme
import com.pouyaheydari.appupdater.pojo.UserSelectedTheme.DARK
import com.pouyaheydari.appupdater.pojo.UserSelectedTheme.LIGHT
import com.pouyaheydari.appupdater.utils.TypefaceHolder
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

    private var _binding: FragmentAppUpdaterDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Getting data passed to the library
        val data = arguments?.serializable(UPDATE_DIALOG_KEY) ?: UpdaterFragmentModel.EMPTY
        if (data == UpdaterFragmentModel.EMPTY || data.storeLis.isEmpty()) {
            throw IllegalArgumentException("It seems you forgot to add any data to the updater dialog. Add the data as described in $UPDATE_DIALOG_README_URL")
        }
        setDialogBackground(mapToSelectedTheme(data.theme, requireContext()))
        isCancelable = data.isForceUpdate

        _binding = FragmentAppUpdaterDialogBinding.inflate(inflater, container, false)
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
        dialog?.window?.setLayout(MATCH_PARENT, WRAP_CONTENT)
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
                    is DialogStates.DownloadApk -> {
                        getApk(it.apkUrl, requireActivity())
                    }

                    DialogStates.HideUpdateInProgress -> hideUpdateInProgressDialog()
                    is DialogStates.OpenStore -> it.store?.showStore(requireContext())
                    DialogStates.ShowUpdateInProgress -> showUpdateInProgressDialog(theme)
                }
            }.launchIn(lifecycleScope)
    }

    private fun getData() {
        val data = arguments?.serializable(UPDATE_DIALOG_KEY) ?: UpdaterFragmentModel.EMPTY
        val title = data.title
        val description = data.description
        val list = data.storeLis
        val theme = mapToSelectedTheme(data.theme, requireContext())
        setTheme(theme)
        val typeface = TypefaceHolder.getTypeface()
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

    private fun setUpProperties(title: String?, description: String?, list: List<StoreListItem>, theme: UserSelectedTheme, typeface: Typeface?) {
        binding.txtTitle.text = title
        binding.txtDescription.text = description

        hideOrLayoutIfNeeded(shouldShowStoresDivider(list))

        setUpBothRecyclers(list, theme, typeface)
    }

    private fun setUpBothRecyclers(list: List<StoreListItem>, theme: UserSelectedTheme, typeface: Typeface?) {
        val directLinks = list.filter { it.store == DIRECT_URL }
        val storeLinks = list.filterNot { it.store == DIRECT_URL }

        if (directLinks.isNotEmpty()) {
            binding.recyclerDirect.adapter = DirectRecyclerAdapter(directLinks, typeface) { viewModel.onListListener(it) }
        }

        if (storeLinks.isNotEmpty()) {
            binding.recyclerStores.adapter = StoresRecyclerAdapter(storeLinks, theme, typeface) { viewModel.onListListener(it) }
        }
    }

    private fun hideOrLayoutIfNeeded(storeAndDirectAvailable: Boolean) {
        binding.linearLayout.isVisible = storeAndDirectAvailable
    }

    private fun showUpdateInProgressDialog(theme: UserSelectedTheme) {
        if (parentFragmentManager.findFragmentByTag(UPDATE_DIALOG_TAG) == null && requireActivity().lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) {
            val fragment = UpdateInProgressDialog()
            val bundle = Bundle()
            bundle.putSerializable(THEME, theme)
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
        _binding = null
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
        fun getInstance(
            title: String,
            description: String,
            storeList: List<StoreListItem>,
            isForce: Boolean = false,
            typeface: Typeface? = null,
            theme: Theme = Theme.LIGHT,
        ): AppUpdaterDialog {
            val fragment = AppUpdaterDialog()

            TypefaceHolder.setTypeface(typeface)
            // bundle to add data to our dialog
            val bundle = Bundle()
            val data = UpdaterFragmentModel(title, description, storeList, !isForce, theme)
            bundle.putSerializable(UPDATE_DIALOG_KEY, data)
            fragment.arguments = bundle
            return fragment
        }
    }
}
