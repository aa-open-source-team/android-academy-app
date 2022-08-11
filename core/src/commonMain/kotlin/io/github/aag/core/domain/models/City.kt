package io.github.aag.core.domain.models

enum class City(override val stringName: String) : Stringified {
    MOSCOW("MOSCOW"),
    MINSK("MINSK"),
    TEL_AVIV("TEL_AVIV"),
    UNKNOWN("UNKNOWN");
}
