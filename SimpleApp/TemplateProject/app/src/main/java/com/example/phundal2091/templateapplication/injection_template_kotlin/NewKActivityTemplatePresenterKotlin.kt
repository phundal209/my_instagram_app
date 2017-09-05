package com.example.phundal2091.templateapplication.injection_template_kotlin

import android.content.Context
import com.example.phundal2091.templateapplication.framework.Presenter
import com.example.phundal2091.templateapplication.injection_template_java.INewActivityTemplatePresenter
import com.example.phundal2091.templateapplication.injection_template_java.NewActivityTemplateView

/**
 * Created by phundal2091 on 11/18/16.
 */
class NewKActivityTemplatePresenterKotlin constructor(context: Context, viewKotlin: NewActivityTemplateViewKotlin) : Presenter<NewActivityTemplateViewKotlin, Any>(context, viewKotlin, false), INewActivityTemplatePresenterKotlin {

    override fun bindControls() {

    }

    override fun hide() {

    }

    override fun show() {

    }
}
