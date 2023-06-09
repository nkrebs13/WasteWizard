object AppVersions {
    const val MIN = 26
    const val TARGET = 33
    const val COMPILE = 33
}

object Kotlin {
    const val VERSION = "1.8.10"
    const val SERIALIZATION = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1"
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
}

object Networking {
    const val VERSION_KTOR = "2.2.4"
    const val KTOR_CORE = "io.ktor:ktor-client-core:$VERSION_KTOR"
    const val KTOR_CLIENT = "io.ktor:ktor-client-okhttp:$VERSION_KTOR"
    const val KTOR_CONTENT_NEGOTIATION = "io.ktor:ktor-client-content-negotiation:$VERSION_KTOR"
    const val KTOR_SERIALIZATION = "io.ktor:ktor-serialization-kotlinx-json:$VERSION_KTOR"
}

object AndroidX {
    const val CORE = "androidx.core:core-ktx:1.9.0"

    const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"

    const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:1.7.0"

    const val VERSION_COMPOSE = "1.4.0"
    const val VERSION_COMPOSE_COMPILER = "1.4.4"
    const val COMPOSE_UI = "androidx.compose.ui:ui:$VERSION_COMPOSE"
    const val COMPOSE_UI_PREVIEW = "androidx.compose.ui:ui-tooling-preview:$VERSION_COMPOSE"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:$VERSION_COMPOSE"
    // should be debug dependency only
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:$VERSION_COMPOSE"
    // should be debug dependency only
    const val COMPOSE_UI_TEST_MANIFEST = "androidx.compose.ui:ui-tooling:$VERSION_COMPOSE"

    const val VERSION_ROOM = "2.5.0"
    const val ROOM_RUNTIME = "androidx.room:room-runtime:$VERSION_ROOM"
    const val ROOM_KTX = "androidx.room:room-ktx:$VERSION_ROOM"
    const val ROOM_COMPILER = "androidx.room:room-compiler:$VERSION_ROOM"

    const val VERSION_NAVIGATION = "2.5.3"
    const val NAVIGATION = "androidx.navigation:navigation-compose:$VERSION_NAVIGATION"
}

object Koin {
    const val CORE = "io.insert-koin:koin-android:3.3.3"
    const val COMPOSE = "io.insert-koin:koin-androidx-compose:3.4.2"
}

object Testing {
    const val JUNIT = "junit:junit:4.13.2"
    const val JUNIT_EXT = "androidx.test.ext:junit:1.1.5"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:3.5.1"
    const val JUNIT_UI_COMPOSE = "androidx.compose.ui:ui-test-junit4:${AndroidX.VERSION_COMPOSE}"
}