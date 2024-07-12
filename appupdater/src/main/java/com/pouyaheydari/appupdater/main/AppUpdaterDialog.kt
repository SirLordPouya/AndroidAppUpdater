package com.pouyaheydari.appupdater.main

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
import com.pouyaheydari.appupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.appupdater.directdownload.utils.getApk
import com.pouyaheydari.appupdater.main.adapters.DirectRecyclerAdapter
import com.pouyaheydari.appupdater.main.adapters.StoresRecyclerAdapter
import com.pouyaheydari.appupdater.main.databinding.FragmentAppUpdaterDialogBinding
import com.pouyaheydari.appupdater.main.mapper.mapToSelectedTheme
import com.pouyaheydari.appupdater.main.pojo.DialogStates
import com.pouyaheydari.appupdater.main.pojo.UpdaterDialogData
import com.pouyaheydari.appupdater.main.pojo.UpdaterFragmentModel
import com.pouyaheydari.appupdater.main.pojo.UserSelectedTheme
import com.pouyaheydari.appupdater.main.pojo.UserSelectedTheme.DARK
import com.pouyaheydari.appupdater.main.pojo.UserSelectedTheme.LIGHT
import com.pouyaheydari.appupdater.main.utils.ErrorCallbackHolder
import com.pouyaheydari.appupdater.main.utils.TypefaceHolder
import com.pouyaheydari.appupdater.main.utils.getDialogWidth
import com.pouyaheydari.appupdater.main.utils.parcelable
import com.pouyaheydari.appupdater.main.utils.putEnum
import com.pouyaheydari.appupdater.store.domain.AppStoreCallback
import com.pouyaheydari.appupdater.store.domain.StoreListItem
import com.pouyaheydari.appupdater.store.domain.showAppInSelectedStore
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import com.pouyaheydari.appupdater.directdownload.R as directDownloadR

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
                    is DialogStates.DownloadApk -> getApk(it.apkUrl, requireActivity()) {
                        viewModel.onDownloadStarted()
                    }

                    is DialogStates.OpenStore -> showAppInSelectedStore(context, it.store) { storeCallback ->
                        onStoreCallback(storeCallback)
                    }

                    is DialogStates.ExecuteErrorCallback -> {
                        ErrorCallbackHolder.callback?.invoke(it.storeName)
                        viewModel.onErrorCallbackCalled()
                    }

                    DialogStates.HideUpdateInProgress -> hideUpdateInProgressDialog()
                    DialogStates.ShowUpdateInProgress -> showUpdateInProgressDialog(theme)
                    DialogStates.Empty -> hideUpdateInProgressDialog()
                }
            }.launchIn(lifecycleScope)
    }

    private fun onStoreCallback(storeCallback: AppStoreCallback) {
        when (storeCallback) {
            is AppStoreCallback.Failure -> viewModel.onErrorWhileOpeningStore(storeCallback.store)
            is AppStoreCallback.Success -> viewModel.onStoreOpened()
        }
    }

    private fun getData() {
        val data = arguments?.parcelable(UPDATE_DIALOG_KEY) ?: UpdaterFragmentModel.EMPTY
        val title = data.title
        val description = data.description
        val storeList = data.storeList
        val directDownloadList = data.directDownloadList
        val theme = mapToSelectedTheme(data.theme, requireContext())
        setTheme(theme)
        val typeface = TypefaceHolder.typeface
        setTypeface(typeface)
        setUpProperties(title, description, storeList, directDownloadList, theme, typeface)
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
            LIGHT -> directDownloadR.color.appupdater_text_colors
            DARK -> directDownloadR.color.appupdater_text_colors_dark
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
        storeList: List<StoreListItem>,
        directDownloadList: List<DirectDownloadListItem>,
        theme: UserSelectedTheme,
        typeface: Typeface?,
    ) {
        binding.txtTitle.text = title
        binding.txtDescription.text = description

        hideOrLayoutIfNeeded(shouldShowStoresDivider(directDownloadList, storeList))

        setUpBothRecyclers(directDownloadList, storeList, theme, typeface)
    }

    private fun shouldShowStoresDivider(directDownloadList: List<DirectDownloadListItem>, storeList: List<StoreListItem>): Boolean =
        directDownloadList.isNotEmpty() && storeList.isNotEmpty()

    private fun setUpBothRecyclers(
        directDownloadList: List<DirectDownloadListItem>,
        storeList: List<StoreListItem>,
        theme: UserSelectedTheme,
        typeface: Typeface?,
    ) {
        if (directDownloadList.isNotEmpty()) {
            binding.recyclerDirect.adapter = DirectRecyclerAdapter(directDownloadList, typeface) { viewModel.onDirectDownloadLinkClicked(it) }
        }

        if (storeList.isNotEmpty()) {
            val spanCount = if (storeList.size > 1) 2 else 1
            binding.recyclerStores.layoutManager = GridLayoutManager(requireContext(), spanCount)
            binding.recyclerStores.adapter = StoresRecyclerAdapter(storeList, theme, typeface) { viewModel.onStoreClicked(it) }
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
         * @param dialogData Data to be shown in the dialog
         *
         * @return a new instance of [AppUpdaterDialog]
         */
        fun getInstance(dialogData: UpdaterDialogData): AppUpdaterDialog = with(dialogData) {
            val fragment = AppUpdaterDialog()
            val data = UpdaterFragmentModel(title, description, storeList, directDownloadList, !isForceUpdate, theme)

            TypefaceHolder.typeface = typeface
            ErrorCallbackHolder.callback = errorWhileOpeningStoreCallback
            // bundle to add data to our dialog
            val bundle = Bundle().apply { putParcelable(UPDATE_DIALOG_KEY, data) }
            fragment.arguments = bundle
            return fragment
        }
    }
}