plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.vincent.compose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.vincent.compose"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation (libs.material)
    //为了防止不必要的依赖冲突，0.0.3开始需要自行依赖google material库
//    implementation (libs.datetimepicker)//具体版本请看顶部jitpack标识，如0.6.3,仅支持androidx

    implementation (libs.common)
    implementation (libs.wheelpicker)

//    implementation ("com.google.android.material:material:1.1.0")
//    //为了防止不必要的依赖冲突，0.0.3开始需要自行依赖google material库
//    implementation ("com.github.loper7:DateTimePicker:0.6.3")//具体版本请看顶部jitpack标识，如0.6.3,仅支持androidx
//
//    implementation ("com.github.gzu-liyujiang.AndroidPicker:Common:4.1.14")
//    implementation ("com.github.gzu-liyujiang.AndroidPicker:WheelPicker:4.1.14")

}