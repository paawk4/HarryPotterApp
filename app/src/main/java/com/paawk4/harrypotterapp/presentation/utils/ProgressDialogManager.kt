package com.paawk4.harrypotterapp.presentation.utils

import android.app.Dialog
import android.content.Context
import com.paawk4.harrypotterapp.R

object ProgressDialogManager {

    private lateinit var progressDialog: Dialog

    fun showProgressDialog(context: Context) {
        progressDialog = Dialog(context)
        progressDialog.setContentView(R.layout.progress_dialog)
        progressDialog.show()
    }

    fun hideProgressDialog() {
        progressDialog.dismiss()
    }
}