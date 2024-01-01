package com.dimthomas.gpstracker.utils

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.Toast
import com.dimthomas.gpstracker.R
import com.dimthomas.gpstracker.databinding.SaveDialogBinding
import com.dimthomas.gpstracker.db.TrackItem

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

    fun showSaveDialog(context: Context, item: TrackItem?, listener: Listener) {
        val builder = AlertDialog.Builder(context)
        val binding = SaveDialogBinding.inflate(LayoutInflater.from(context), null, false)
        builder.setView(binding.root)
        val dialog = builder.create()
        binding.apply {

            val time = "${item?.time}"
            val velocity = "Speed: ${item?.velocity} km/h"
            val distance = "Distance: ${item?.distance} km"
            timeTv.text = time
            speedTv.text = velocity
            distanceTv.text = distance

            saveBtn.setOnClickListener {
                listener.onClick()
                dialog.dismiss()
            }
            cancelBtn.setOnClickListener {
                dialog.dismiss()
            }
        }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    interface Listener {
        fun onClick()
    }
}