package io.github.androidacademyglobal.ui.courses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.Course
import io.github.aag.core.domain.repositories.CourseRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CoursesViewModel(
    private val courseRepository: CourseRepository
) : ViewModel() {
    init {
        viewModelScope.launch {
            courseRepository.loadAllCourses()
        }
    }

    val allCourses: StateFlow<OperationResult<List<Course>>> =
        courseRepository.allCourses
}
