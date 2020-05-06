package dev.markcharles.tinytextstyler

import android.text.style.CharacterStyle

interface TinyTextStyler {
    fun getCharacterStyle(key: String, value: String): CharacterStyle?

    companion object {

        const val KEY_ARGUMENT = "arg"

        const val KEY_STYLE = "style"
        const val KEY_CLICK = "click"
        const val KEY_BACKGROUND_COLOR = "bg_color"
        const val KEY_COLOR = "color"
        const val KEY_ABSOLUTE_SIZE = "abs_size"
        const val KEY_RELATIVE_SIZE = "rel_size"

        const val VALUE_BOLD = "bold"
        const val VALUE_ITALIC = "italic"
        const val VALUE_STRIKE = "strike"
        const val VALUE_UNDERLINE = "underline"

        const val VALUE_BLUE = "blue"
        const val VALUE_GREEN = "green"
        const val VALUE_RED = "red"
        const val VALUE_YELLOW = "yellow"
        const val VALUE_BLACK = "black"
        const val VALUE_WHITE = "white"
        const val VALUE_CYAN = "cyan"
        const val VALUE_GRAY = "gray"
    }
}