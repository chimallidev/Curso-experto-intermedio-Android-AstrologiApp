import org.gradle.api.JavaVersion.VERSION_1_8

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.chimallidigital.astrologiapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.chimallidigital.astrologiapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.chimallidigital.astrologiapp.CustomTestRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable= false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            resValue("string", "chimalliname", "AstrologiAPP")

            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
            signingConfig = signingConfigs.getByName("debug")
        }
        getByName("debug"){
            isDebuggable= true
            resValue("string", "chimalliname", "[DEBUG] AstrologiAPP")
            buildConfigField("String", "BASE_URL", "\"https://newastro-debug.vercel.app/\"")
        }
    }
    compileOptions {
        sourceCompatibility = VERSION_1_8
        targetCompatibility = VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding= true
        buildConfig= true
    }
    kotlin{
        jvmToolchain(21)
    }





dependencies {

    val navVersion="2.7.1"
    val daggerVersion= "2.50"
    val retroVersion= "2.9.0"
    val cameraVersion="1.2.3"



    //navComponent
    implementation ("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation ("androidx.navigation:navigation-ui-ktx:$navVersion")

    //DaggerHilt
    implementation ("com.google.dagger:hilt-android:$daggerVersion")
    kapt ("com.google.dagger:hilt-compiler:$daggerVersion")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retroVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retroVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    //Camera X
    implementation("androidx.camera:camera-core:${cameraVersion}")
    implementation("androidx.camera:camera-camera2:${cameraVersion}")
    implementation("androidx.camera:camera-lifecycle:${cameraVersion}")
    implementation("androidx.camera:camera-view:${cameraVersion}")
    implementation("androidx.camera:camera-extensions:${cameraVersion}")


    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //UnitTesting
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
    testImplementation("io.mockk:mockk:1.12.3")

    //UITesting
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:3.5.1")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.4.0")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.50")
    androidTestImplementation("androidx.fragment:fragment-testing:1.6.1")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.50")
}}

