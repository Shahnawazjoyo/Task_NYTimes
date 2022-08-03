package com.shahnawaz.nytimes.di.component

import com.shahnawaz.nytimes.di.modules.ApiModule
import com.shahnawaz.nytimes.model.MostViewedService
import com.shahnawaz.nytimes.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: MostViewedService)

    fun inject(viewModel: ListViewModel)

}