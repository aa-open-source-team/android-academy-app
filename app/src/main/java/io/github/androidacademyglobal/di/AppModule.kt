package io.github.androidacademyglobal.di

import io.github.androidacademyglobal.ui.courses.CoursesViewModel
import io.github.androidacademyglobal.ui.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::ProfileViewModel)
    viewModelOf(::CoursesViewModel)
}
