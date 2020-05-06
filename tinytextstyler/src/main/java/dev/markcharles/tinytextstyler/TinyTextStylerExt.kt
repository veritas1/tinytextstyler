package dev.markcharles.tinytextstyler

import android.content.Context
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.SpannedString
import android.text.style.CharacterStyle
import androidx.annotation.StringRes

fun Context.getStyledText(
    @StringRes resId: Int,
    textStyler: TinyTextStyler,
    vararg args: Any
): Spanned {

    val text = getText(resId) as SpannedString
    return SpannableStringBuilder(text).apply {
        getSpans(0, length, android.text.Annotation::class.java).apply {
            sortBy<android.text.Annotation, Boolean> { it.value == TinyTextStyler.KEY_ARGUMENT }
        }.forEach<android.text.Annotation> { annotation ->
            val start = getSpanStart(annotation)
            val end = getSpanEnd(annotation)

            when (annotation.key) {
                TinyTextStyler.KEY_ARGUMENT -> replace(
                    start,
                    end,
                    String.format(annotation.value, *args)
                )
                else -> {
                    annotation.value.split("|")
                        .mapNotNull { textStyler.getCharacterStyle(annotation.key, it) }
                        .forEach { applyStyle(it, start, end) }
                }
            }
        }
    }
}

private fun Spannable.applyStyle(
    characterStyle: CharacterStyle,
    start: Int = 0,
    end: Int = this.length
) {
    this.setSpan(
        characterStyle,
        start, end,
        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
    )
}