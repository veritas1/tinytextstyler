package dev.markcharles.tinytextstyler

import android.graphics.Color
import android.graphics.Typeface
import android.text.style.*

abstract class DefaultTextStyler : TinyTextStyler {

    override fun getCharacterStyle(key: String, value: String): CharacterStyle? {
        return when (key) {
            TinyTextStyler.KEY_STYLE -> {
                when (value) {
                    TinyTextStyler.VALUE_NORMAL -> StyleSpan(Typeface.NORMAL)
                    TinyTextStyler.VALUE_BOLD -> StyleSpan(Typeface.BOLD)
                    TinyTextStyler.VALUE_ITALIC -> StyleSpan(Typeface.ITALIC)
                    TinyTextStyler.VALUE_BOLD_ITALIC -> StyleSpan(Typeface.BOLD_ITALIC)
                    TinyTextStyler.VALUE_STRIKE -> StrikethroughSpan()
                    TinyTextStyler.VALUE_UNDERLINE -> UnderlineSpan()
                    else -> null
                }

            }
            TinyTextStyler.KEY_CLICK -> getClickableSpan(value)
            TinyTextStyler.KEY_BACKGROUND_COLOR -> getBackgroundColor(value).let(::BackgroundColorSpan)
            TinyTextStyler.KEY_COLOR -> getForegroundColor(value).let(::ForegroundColorSpan)
            TinyTextStyler.KEY_ABSOLUTE_SIZE -> getAbsoluteSize(value).let(::AbsoluteSizeSpan)
            TinyTextStyler.KEY_RELATIVE_SIZE -> getRelativeSize(value).let(::RelativeSizeSpan)
            TinyTextStyler.KEY_TYPEFACE -> getTypeface(value)?.let(::CustomTypefaceSpan)
            else -> null
        }
    }

    open fun getAbsoluteSize(value: String): Int = value.toInt()

    open fun getRelativeSize(value: String): Float = value.toFloat()

    open fun getTypeface(value: String): Typeface? = null

    open fun getForegroundColor(value: String): Int = parseColor(value)

    open fun getBackgroundColor(value: String): Int = parseColor(value)

    open fun getClickableSpan(value: String): ClickableSpan? = null

    private fun parseColor(value: String): Int {
        return when (value) {
            TinyTextStyler.VALUE_GREEN -> Color.GREEN
            TinyTextStyler.VALUE_BLUE -> Color.BLUE
            TinyTextStyler.VALUE_YELLOW -> Color.YELLOW
            TinyTextStyler.VALUE_RED -> Color.RED
            TinyTextStyler.VALUE_GRAY -> Color.GRAY
            TinyTextStyler.VALUE_CYAN -> Color.CYAN
            TinyTextStyler.VALUE_WHITE -> Color.WHITE
            TinyTextStyler.VALUE_BLACK -> Color.BLACK
            else -> try {
                Color.parseColor(value)
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
                Color.BLACK
            }
        }
    }

}