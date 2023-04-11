package io.github.androidacademyglobal.ui.courses

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.aag.core.domain.OperationResult
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun CoursesListScreen(vm: CoursesViewModel = getViewModel()) {
    val allCourses = vm.allCourses.collectAsStateWithLifecycle()
    when (val result = allCourses.value) {
        is OperationResult.Success -> {
            println(result)
        }

        is OperationResult.Error -> {
            println(result.throwable.message)
        }

        else -> {
            // todo: implement loading and error
        }
    }
}
