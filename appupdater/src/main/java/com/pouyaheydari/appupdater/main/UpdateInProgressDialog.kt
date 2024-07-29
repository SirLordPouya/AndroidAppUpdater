package com.pouyaheydari.appupdater.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.WRAP_CONTENT
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.pouyaheydari.appupdater.main.databinding.FragmentUpdateInProgressDialogBinding
import com.pouyaheydari.appupdater.main.pojo.UserSelectedTheme
import com.pouyaheydari.appupdater.main.pojo.UserSelectedTheme.DARK
import com.pouyaheydari.appupdater.main.pojo.UserSelectedTheme.LIGHT
import com.pouyaheydari.appupdater.main.utils.TypefaceHolder
import com.pouyaheydari.appupdater.main.utils.getDialogWidth
import com.pouyaheydari.appupdater.main.utils.getEnum
import com.pouyaheydari.appupdater.directdownload.R as directDownloadR

const val THEME = "THEME"

/**
 * Dialog to show download in progress to user
 */
internal class UpdateInProgressDialog : DialogFragment() {
    private var _binding: FragmentUpdateInProgressDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentUpdateInProgressDialogBinding.inflate(inflater, container, false)
        val theme = arguments?.getEnum(THEME) ?: LIGHT
        setDialogBackground(theme)
        setTheme(theme)
        isCancelable = false
        return binding.root
    }

    private fun setDialogBackground(data: UserSelectedTheme) {
        val dialogBackground = when (data) {
            LIGHT -> R.drawable.dialog_background
            DARK -> R.drawable.update_in_progress_dialog_background_dark
        }

        // Set background for the dialog
        dialog?.window?.setBackgroundDrawable(
            ContextCompat.getDrawable(requireContext(), dialogBackground),
        )
    }

    private fun setTheme(data: UserSelectedTheme) {
        val textColor = when (data) {
            LIGHT -> directDownloadR.color.appupdater_text_colors
            DARK -> directDownloadR.color.appupdater_text_colors_dark
        }

        with(binding) {
            txtTitle.setTextColor(ContextCompat.getColor(requireContext(), textColor))
            txtDescription.setTextColor(ContextCompat.getColor(requireContext(), textColor))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTypeface()
    }

    private fun setTypeface() {
        val typeface = TypefaceHolder.typeface
        with(binding) {
            typeface?.let {
                txtTitle.typeface = it
                txtDescription.typeface = it
            }
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(getDialogWidth(), WRAP_CONTENT)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
