package io.github.aag.core.data.network.repos

import io.github.aag.core.data.network.models.CourseDTO
import io.github.aag.core.data.network.models.fromCourse
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

    override suspend fun loadAllCourses() {
        _allCourses.value = try {
            OperationResult.Success(
                remoteDataSource.getAllCourses()
                    .map(CourseDTO::toCourse)
            )
        } catch (t: Throwable) {
            OperationResult.Error(t)
        }
    }

    override suspend fun getFavouriteCourses(username: String): OperationResult<List<Course>> =
        try {
            OperationResult.Success(
                remoteDataSource.getFavoriteCourses()
                    .map(CourseDTO::toCourse)
            )
        } catch (t: Throwable) {
            OperationResult.Error(t)
        }

    override suspend fun updateCourse(course: Course): OperationResult<Course> =
        try {
            OperationResult.Success(
                remoteDataSource.updateCourse(fromCourse(course))
                    .toCourse()
            )
        } catch (t: Throwable) {
            OperationResult.Error(t)
        }

}
