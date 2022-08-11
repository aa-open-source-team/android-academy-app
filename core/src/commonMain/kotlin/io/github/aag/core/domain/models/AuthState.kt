package io.github.aag.core.domain.models

enum class AuthState {
    INITIAL,
    AUTHORIZED,
    GUEST,
    UNAUTHORIZED,
    LOADING,
    EXCEPTION,
}
