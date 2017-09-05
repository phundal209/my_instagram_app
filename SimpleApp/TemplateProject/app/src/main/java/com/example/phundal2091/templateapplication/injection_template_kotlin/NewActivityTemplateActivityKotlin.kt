package com.example.phundal2091.templateapplication.injection_template_java

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.example.phundal2091.templateapplication.TemplateApplication
import com.example.phundal2091.templateapplication.framework.ViewScreen
import com.example.phundal2091.templateapplication.injection.DataModule
import com.example.phundal2091.templateapplication.injection_template_kotlin.INewActivityTemplatePresenterKotlin
import com.example.phundal2091.templateapplication.injection_template_kotlin.NewActivityTemplateComponentKotlin
import com.example.phundal2091.templateapplication.injection_template_kotlin.NewActivityTemplateModuleKotlin


import javax.inject.Inject

class NewActivityTemplateActivityKotlin : AppCompatActivity() {

    @Inject
    internal var newActivityTemplatePresenterKotlin: INewActivityTemplatePresenterKotlin? = null

//    private var componentKotlin: NewActivityTemplateComponentKotlin? = null
//    internal fun component(): NewActivityTemplateComponentKotlin {
//        if (componentKotlin == null) {
//            componentKotlin = DaggerNewActivityTemplateComponentKotlin?.builder()
//                    .applicationComponent((application as TemplateApplication).component)
//                    .newActivityTemplateModuleKotlin(NewActivityTemplateModuleKotlin(this))
//                    // Todo: uncomment the following line if you need gfm api service or realm access injected
//                    .dataModule(DataModule(this))
//                    .build()
//        }
//        return componentKotlin!!
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        //todo: add actual layout reference to setContentView
//        //        setContentView(R.layout.activity_paged);
//
//        component().inject(this)
//
//        //do this after setContentView and pass in a reference to the inflated view
//        //  replace null with the new value
//        newActivityTemplatePresenterKotlin!!
//                .view
//                .withRootView<ViewScreen>(this.findViewById(android.R.id.content)!!.rootView)
//        newActivityTemplatePresenterKotlin!!
//                .bindControls()
//    }
}
