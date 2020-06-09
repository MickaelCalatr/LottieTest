package com.antarticstudio.lottietestcrash.dependencies

import com.antarticstudio.lottietestcrash.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val remoteViewModelModule: Module = module {
    viewModel { MainViewModel(get()) }
}

