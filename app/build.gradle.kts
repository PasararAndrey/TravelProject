plugins {
    id(GradlePlugins.android)
    kotlin(GradlePlugins.kotlinAndroid)
    kotlin(GradlePlugins.kotlinKapt)
    id(GradlePlugins.navigationSafe)
    id(GradlePlugins.hilt)

}

android {
    compileSdk = Android.compileSdk

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode
        versionName = Android.versionName

        testInstrumentationRunner = AndroidJUnit.runner
    }

    buildTypes {
        getByName(BuildType.release) {
            isMinifyEnabled = BuildType.minifyRelease
            proguardFiles(BuildType.proguardRelease)
        }

//        release {
//            isMinifyEnabled = false
//            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
//        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    //core
    implementation(Libs.coreKtx)
    implementation(Libs.stdLib)

    //support
    implementation(Libs.appCompat)
    implementation(Libs.annotations)
    implementation(Libs.material)
    implementation(Libs.recyclerview)
    implementation(Libs.cardview)
    implementation(Libs.constraintlayout)
    implementation(Libs.viewPager2)
    implementation(Libs.imageSlider)

    //lifecycle
    implementation(Libs.lifecycleRuntimeKtx)
    implementation(Libs.lifecycleViewModelKtx)
    implementation(Libs.lifecycleLivedataKtx)
    implementation(Libs.lifecycleCompiler)

    // Navigation
    implementation(Libs.navigationRuntimeKtx)
    implementation(Libs.navigationFragmentKtx)
    implementation(Libs.navigationUiKtx)

    //Fragment
    implementation(Libs.fragmentKtx)

    //Dagger and Hilt
    implementation(Libs.hilt)
    kapt(Libs.hiltCompiler)

    //Glide
    implementation(Libs.glideRuntime)
    kapt(Libs.glideCompiler)

    testImplementation(Libs.jUnit)
    androidTestImplementation(Libs.androidJUNit)
    androidTestImplementation(Libs.espresso)

    // module
    implementation(project(Modules.domain)) {
        exclude("com.travelproject", "domain")
    }
    implementation(project(Modules.data)) {
        exclude("com.travelproject", "data")
    }


}

