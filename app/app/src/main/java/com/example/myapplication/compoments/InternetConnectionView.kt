package com.example.myapplication.compoments

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.myapplication.BuildConfig
import com.example.myapplication.R
import kotlinx.android.synthetic.main.internet_connection_view.view.*

class InternetConnectionView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {
    init {
        LayoutInflater.from(context).inflate(R.layout.internet_connection_view, this, true)
        tvVersao.text =BuildConfig.VERSION_NAME
    }

    fun showInternetOn(){
        ivIcone.setImageDrawable(context.resources.getDrawable(R.drawable.ic_maxima_nuvem_conectado));
    }
    fun showInternetOf(){
        ivIcone.setImageDrawable(context.resources.getDrawable(R.drawable.ic_maxima_nuvem_desconectado));
    }
}