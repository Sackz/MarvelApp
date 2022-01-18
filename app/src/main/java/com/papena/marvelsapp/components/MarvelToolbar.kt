package com.papena.marvelsapp.components

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import com.papena.marvelsapp.R

enum class MarvelToolbarType{
    NO_TOOLBAR, HOME, DETAIL
}
class MarvelToolbar: Toolbar {
    private lateinit var title: TextView
    private lateinit var btnBack: AppCompatImageView
    private lateinit var btnRight: AppCompatImageView

    constructor(context: Context): super(context){
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet): super(context,attrs){
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context,attrs, defStyleAttr){
        initView(context)
    }

    private fun initView(context: Context){
        inflate(context, R.layout.marvel_toolbar, this)
        setupUi()
    }

    fun setupUi(){
        title = findViewById(R.id.toolbar_title)
        btnBack = findViewById(R.id.toolbar_back_button)
        btnRight = findViewById(R.id.toolbar_right_button)
    }

    fun initToolbar(type: MarvelToolbarType,onClick: () -> Unit){
        when(type){
            MarvelToolbarType.HOME -> {
                hideBackBtn()
                showRightBtn(onClick)
            }
            MarvelToolbarType.DETAIL ->{
                showBackBtn(onClick)
                hideRightBtn()
            }
        }

    }

    fun hideBackBtn(){
        btnBack.isVisible = false
    }

    fun showBackBtn(onClick: () -> Unit){
        btnBack.isVisible = true
        btnBack.setOnClickListener {
            onClick.invoke()
        }
    }

    fun hideRightBtn(){
        btnRight.isVisible = false
    }

    fun showRightBtn(onClick: () -> Unit){
        btnRight.isVisible = true
        btnRight.setOnClickListener {
            onClick.invoke()
        }
    }

    fun setToolbarTitle(title: String){
        this.title.isVisible = true
        this.title.text = title
    }

}