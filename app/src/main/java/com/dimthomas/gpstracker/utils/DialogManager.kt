package com.dimthomas.gpstracker.utils

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import com.dimthomas.gpstracker.R

object DialogManager {

    fun showLocEnabledDialog(context: Context, listener: Listener) {
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        dialog.setTitle(R.string.location_disabled)
        dialog.setMessage(context.getString(R.string.location_message))
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes") {
            _, _ -> listener.onClick()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No") {
            _, _ -> dialog.dismiss()
        }
        dialog.show()
    }

    interface Listener {
        fun onClick()
    }
}