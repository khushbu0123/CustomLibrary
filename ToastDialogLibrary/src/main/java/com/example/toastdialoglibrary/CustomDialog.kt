package com.example.toastdialoglibrary

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView

class CustomDialog(context: Context) {
    private val dialog: Dialog = Dialog(context)

    init {
        val view: View = LayoutInflater.from(context).inflate(R.layout.custom_dialog, null)
        dialog.setContentView(view)
        dialog.setCancelable(false)
    }

    fun setTitle(title: String): CustomDialog {
        dialog.findViewById<TextView>(R.id.dialogTitle)?.text = title
        return this
    }

    fun setMessage(message: String): CustomDialog {
        dialog.findViewById<TextView>(R.id.dialogMessage)?.text = message
        return this
    }

    fun setButtonText(text: String, onClick: () -> Unit): CustomDialog {
        dialog.findViewById<Button>(R.id.dialogButton)?.apply {
            this.text = text
            this.setOnClickListener {
                onClick()
                dialog.dismiss()
            }
        }
        return this
    }

    fun show() {
        dialog.show()
    }

    fun dismiss() {
        dialog.dismiss()
    }
}
