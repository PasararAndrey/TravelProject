// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()

    }
    dependencies {
        classpath(BuildPlugins.kotlinGradle)
        classpath(BuildPlugins.androidGradle)
        classpath(BuildPlugins.hilt)
        classpath(BuildPlugins.navigationSafe)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}




tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}