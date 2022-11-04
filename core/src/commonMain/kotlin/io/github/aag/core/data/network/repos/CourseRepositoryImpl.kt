package io.github.aag.core.data.network.repos

import io.github.aag.core.data.network.models.toCourse
import io.github.aag.core.data.network.sources.CoursesRemoteDataSource
import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.Course
import io.github.aag.core.domain.repositories.CourseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CourseRepositoryImpl(
    private val remoteDataSource: CoursesRemoteDataSource
) : CourseRepository {

    private val _allCourses =
        MutableStateFlow<OperationResult<List<Course>>>(OperationResult.Loading)

    override val allCourses: StateFlow<OperationResult<List<Course>>> =
        _allCourses.asStateFlow()

    override suspend fun loadAllCourses(): StateFlow<OperationResult<List<Course>>> {
        try {
            remoteDataSource.getAllCourses()
                .map { entity -> entity.toCourse() }
                .also { courses ->
                    _allCourses.value = OperationResult.Success(courses)
                }
        } catch (t: Throwable) {
            _allCourses.value = OperationResult.Error(t)
        }
        return _allCourses.asStateFlow()
    }


    override suspend fun <T> getFavouriteCourses(username: String): OperationResult<List<Course>> {
        TODO("Not yet implemented")
    }

    override suspend fun <T> updateCourse(course: Course): OperationResult<List<Course>> {
        TODO("Not yet implemented")
    }
}
