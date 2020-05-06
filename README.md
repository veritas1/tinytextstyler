# Tiny Text Styler
[ ![Download](https://api.bintray.com/packages/veritas1/Android/tiny-text-styler/images/download.svg) ](https://bintray.com/veritas1/Android/tiny-text-styler/_latestVersion)

Easily add style to your string resources, with dynamic argument support :)

## Gradle
`implementation 'dev.markcharles:tiny-text-styler:0.1.0'`

## Usage
`textView.text = context.getStyledText(R.string.my_string, textStyler)`

`private val textStyler = object : DefaultTextStyler() {}`

## Convert string resources using annotations
#### Before
```
<string name="demo">The quick brown fox jumped over the lazy dog %1$d %2$s.</string>
```

#### After
```
<string name="demo">The quick <annotation color="#80614e" style="bold|underline" abs_size="32">brown</annotation> fox <annotation style="strike|bold_italic">jumped</annotation> <annotation rel_size="0.5">over</annotation> the lazy <annotation click="dog">dog</annotation> <annotation arg="%1$d">%1$d</annotation> <annotation arg="%2$s">%2$s</annotation>.</string>
```

## Screenshots
![alt text](images/screenshot.png)
