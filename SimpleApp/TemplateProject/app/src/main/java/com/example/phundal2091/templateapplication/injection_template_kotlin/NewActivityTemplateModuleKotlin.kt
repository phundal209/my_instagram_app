package com.example.phundal2091.templateapplication.injection_template_kotlin

import android.app.Activity
import com.example.phundal2091.templateapplication.injection.annotations.PerActivity
import com.example.phundal2091.templateapplication.injection_template_java.INewActivityTemplatePresenter
import com.example.phundal2091.templateapplication.injection_template_java.NewActivityTemplatePresenter
import com.example.phundal2091.templateapplication.injection_template_java.NewActivityTemplateView
import dagger.Module
import dagger.Provides

/**
 * Created by phundal2091 on 11/18/16.
 */
@Module
class NewActivityTemplateModuleKotlin {

    private val activity: Activity

    constructor(activity: Activity) {
        this.activity = activity
    }


    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    internal fun activity(): Activity {
        return activity
    }

    @Provides
    internal fun providesNewActivityTemplatePresenter(): INewActivityTemplatePresenterKotlin {
        return NewKActivityTemplatePresenterKotlin(activity, NewActivityTemplateViewKotlin())
    }
}