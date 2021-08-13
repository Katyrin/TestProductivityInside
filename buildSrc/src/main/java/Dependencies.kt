import org.gradle.api.JavaVersion

object Config {
    const val applicationId = "com.katyrin.testproductivityinside"
    const val compileSdk = 30
    const val minSdk = 19
    const val targetSdk = 30
    val javaVersion = JavaVersion.VERSION_11
    const val jvmTarget = "11"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Modules {
    const val app = ":app"
    const val myLibrary = ":myLibrary"
}

object Versions {

    // Design
    const val appcompat = "1.3.1"
    const val material = "1.4.0"
    const val constraintLayout = "2.1.0"

    // Kotlin
    const val core = "1.6.0"

    // RxJava
    const val rxjava = "3.0.3"

    // Glide
    const val glide = "4.12.0"

    // Test
    const val jUnit = "4.13.2"
    const val testJUnit = "1.1.3"
    const val espressoCore = "3.4.0"
}


object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.core}"
}

object RxJava {
    const val rxjava = "io.reactivex.rxjava3:rxjava:${Versions.rxjava}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}

object TestImpl {
    const val junit = "junit:junit:${Versions.jUnit}"
    const val testJUnit = "androidx.test.ext:junit:${Versions.testJUnit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}