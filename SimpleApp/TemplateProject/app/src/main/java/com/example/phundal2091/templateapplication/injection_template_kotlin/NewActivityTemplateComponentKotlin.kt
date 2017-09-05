package com.example.phundal2091.templateapplication.injection_template_kotlin

import com.example.phundal2091.templateapplication.injection.AbstractActivityComponent
import com.example.phundal2091.templateapplication.injection.ApplicationComponent
import com.example.phundal2091.templateapplication.injection.DataModule
import com.example.phundal2091.templateapplication.injection.annotations.PerActivity
import com.example.phundal2091.templateapplication.injection_template_java.NewActivityTemplateActivity
import com.example.phundal2091.templateapplication.injection_template_java.NewActivityTemplateModule
import com.example.phundal2091.templateapplication.injection_template_java.NewActivityTemplateActivityKotlin
import dagger.Component

/**
 * Created by phundal2091 on 11/18/16.
 */
@PerActivity  // Subtypes of AbstractActivityComponent should be decorated with @PerActivity.
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(NewActivityTemplateModuleKotlin::class, DataModule::class))

interface NewActivityTemplateComponentKotlin : AbstractActivityComponent{
    fun inject(newActivityTemplateActivityKotlin: NewActivityTemplateActivityKotlin)
}