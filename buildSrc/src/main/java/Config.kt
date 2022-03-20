object Versions {
    const val kotlin = "1.5.31"

    internal const val core = "1.6.0"
    internal const val appCompat = "1.3.1"
    internal const val material = "1.4.0"
    internal const val constraintlayout = "2.1.1"
    internal const val recyclerView = "1.2.1"
    internal const val cardview = "1.0.0"
    internal const val viewPager = "1.0.0"

    internal const val fragment = "1.3.6"
    internal const val lifecycle = "2.4.0-rc01"
    internal const val navigation = "2.4.0-alpha10"


    internal const val hilt = "2.38.1"
    internal const val glide = "4.12.0"


    internal const val pluginGradle = "7.0.2"
    internal const val annotation = "28.0.0"
    internal const val imageSlider = "0.1.0"

    internal const val retrofit = "2.9.0"
    internal const val retrofitConverter = "2.5.0"


    internal const val jUnitVersion = "4.13.2"
    internal const val espressoVersion = "3.4.0"
    internal const val androidJUNitVersion = "1.1.3"

    internal const val datastore = "1.0.0"

    internal const val loggingInterceptor = "4.9.1"

}

object Modules {
    const val domain = ":domain"
    const val data = ":data"
}

object Android {
    const val compileSdk = 31
    const val applicationId = "com.travelproject"
    const val minSdk = 23
    const val targetSdk = 31
    const val versionCode = 1
    const val versionName = "1.0"

}


object BuildType {
    const val release = "release"
    const val minifyRelease = false
    const val proguardRelease = "proguard-rules.pro"

}


object AndroidJUnit {
    const val runner = "androidx.test.runner.AndroidJUnitRunner"
}

object BuildPlugins {
    const val androidGradle = "com.android.tools.build:gradle:${Versions.pluginGradle}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val navigationSafe = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
}


object GradlePlugins {
    const val android = "com.android.application"
    const val hilt = "dagger.hilt.android.plugin"
    const val kotlin = "kotlin"
    const val kotlinAndroid = "android"
    const val kotlinKapt = "kapt"
    const val androidLib = "com.android.library"
    const val navigationSafe = "androidx.navigation.safeargs"
    const val navigationSafeKotlin = "androidx.navigation.safeargs.kotlin"
}

object Libs {


    //KTX
    const val coreKtx = "androidx.core:core-ktx:${Versions.core}"
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    //Support and ui libs
    const val annotations = "com.android.support:support-annotations:${Versions.annotation}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager}"
    const val imageSlider = "com.github.denzcoskun:ImageSlideshow:0.1.0"


    //Lifecycle
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLivedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"

    // Navigation
    const val navigationRuntimeKtx = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    //Fragment
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"

    //Dagger and Hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    //Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitConverter}"

    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    const val glideRuntime = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val datastorePreferences = "androidx.datastore:datastore-preferences:${Versions.datastore}"


    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val androidJUNit = "androidx.test.ext:junit:${Versions.androidJUNitVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
}



