package io.github.androidacademyglobal.di

import io.github.androidacademyglobal.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ProfileViewModel() }
}
