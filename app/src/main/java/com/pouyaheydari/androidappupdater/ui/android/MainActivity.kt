package com.pouyaheydari.androidappupdater.ui.android

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.pouyaheydari.androidappupdater.R
import com.pouyaheydari.androidappupdater.store.model.Theme
import com.pouyaheydari.androidappupdater.ui.compose.ComposeSampleActivity
import com.pouyaheydari.androidappupdater.utils.getDSLList
import com.pouyaheydari.androidappupdater.utils.getNormalList
import com.pouyaheydari.appupdater.AppUpdaterDialog
import com.pouyaheydari.appupdater.dsl.updateDialogBuilder
import com.pouyaheydari.appupdater.pojo.UpdaterDialogData

private const val TAG = "showUpdateDialogTag"
private const val FONT_PATH = "fonts/vazir.ttf"

/**
 * Main activity of the sample application
 */
internal class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnKotlin).setOnClickListener {
            kotlinSample()
        }

        findViewById<Button>(R.id.btnDSL).setOnClickListener {
            dslSample()
        }

        findViewById<Button>(R.id.btnCompose).setOnClickListener {
            startActivity(Intent(this, ComposeSampleActivity::class.java))
        }
    }

    /**
     * To use the library like below,
     * you only need to add dependencies to:
     * core and dsl
     */
    private fun dslSample() {
        updateDialogBuilder {
            title = getString(R.string.library_title)
            description = getString(R.string.library_description)
            isForceUpdate = false
            typeface = Typeface.createFromAsset(assets, FONT_PATH)
            theme = Theme.SYSTEM_DEFAULT
            storeList = getDSLList(this@MainActivity)
        }.show(supportFragmentManager, TAG)
    }

    /**
     * To use the library like below,
     * you only need to add dependencies to:
     * core and appupdater
     */
    private fun kotlinSample() {
        //   make a list of stores
        val list = getNormalList(this)
        // creating update dialog
        AppUpdaterDialog.getInstance(
            UpdaterDialogData(
                title = getString(R.string.library_title),
                description = getString(R.string.library_description),
                storeList = list,
                isForceUpdate = false,
                typeface = Typeface.createFromAsset(assets, FONT_PATH),
                theme = Theme.LIGHT,
            ),
        ).show(supportFragmentManager, TAG)
    }
}
