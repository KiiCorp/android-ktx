ext {
    extra["compose_version"] = "1.2.0-rc01"
    extra["hilt_version"] = "2.40.1"
}
buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.1")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application").version("7.2.1").apply(false)
    id("com.android.library").version("7.2.1").apply(false)
    id("org.jetbrains.kotlin.android").version("1.6.21").apply(false)
}