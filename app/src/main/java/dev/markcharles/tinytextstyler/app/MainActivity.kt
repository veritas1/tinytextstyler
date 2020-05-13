package dev.markcharles.tinytextstyler.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.TypedValue
import android.view.View
import android.widget.Toast
import dev.markcharles.tinytextstyler.DefaultTextStyler
import dev.markcharles.tinytextstyler.getStyledText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val myStyler = object : DefaultTextStyler() {

        override fun getAbsoluteSize(value: String): Int {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value.toFloat(), resources.displayMetrics).toInt()
        }

        override fun getClickableSpan(value: String): ClickableSpan? {
            return when (value) {
                "dog" -> object : ClickableSpan() {
                    override fun onClick(widget: View) {
                        Toast.makeText(this@MainActivity, "Clicked dog text!", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
                else -> null
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jumpCount = 3
        val plural = resources.getQuantityString(R.plurals.times, 3)
        demo_no_style_example.apply {
            text = getString(R.string.demo, "Hewllo", jumpCount, plural)
        }
        demo_style_example.apply {
            text = getStyledText(R.string.demo, myStyler, "Hello", jumpCount, plural)
            movementMethod = LinkMovementMethod.getInstance()
        }
    }
}
