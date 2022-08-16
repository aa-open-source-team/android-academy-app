package io.github.aag.core.domain.models

enum class City(override val itemName: String) : FilterItem {
    MOSCOW("Moscow"),
    MINSK("Minsk"),
    TEL_AVIV("Tel Aviv"),
    UNKNOWN("UNKNOWN");
}
