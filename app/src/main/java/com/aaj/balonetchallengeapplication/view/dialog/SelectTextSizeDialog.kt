package com.aaj.balonetchallengeapplication.view.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.SeekBar
import androidx.lifecycle.MutableLiveData
import com.aaj.balonetchallengeapplication.databinding.DialogSelectTextSizeBinding
import com.aaj.balonetchallengeapplication.util.AppTextSizes
import com.aaj.balonetchallengeapplication.util.StaticParameters
import com.aaj.balonetchallengeapplication.util.getDiff


class SelectTextSizeDialog(
    val activity: Activity,
    val onSubmit: () -> Unit
) {
    val dialog: Dialog = Dialog(activity)
    val binding = DialogSelectTextSizeBinding.inflate(LayoutInflater.from(activity))
    val textSize: MutableLiveData<Int> by lazy { MutableLiveData((StaticParameters.appDefaultTextSize * 10).toInt()) }

    init {
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        binding.view = this
        dialog.setContentView(binding.root)
        binding.executePendingBindings()
    }

    fun show() {
        dialog.show()
    }

    fun close() {
        onSubmit.invoke()
        dialog.dismiss()
    }

    fun onValueChanged(seekBar: SeekBar?, progressValue: Int, fromUser: Boolean) {
        binding.textView.text = (progressValue / 10f).toString()
        StaticParameters.appDefaultTextSize = progressValue / 10f
        binding.title.setTextSize(
            TypedValue.COMPLEX_UNIT_SP,
            StaticParameters.appDefaultTextSize + AppTextSizes.NORMAL.getDiff()
        )
    }
}