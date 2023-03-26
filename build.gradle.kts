buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.VERSION}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${Kotlin.VERSION}")
    }
}