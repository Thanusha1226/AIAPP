plugins {
    id("com.android.application")
}

android {
    namespace = "lk.portion.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "lk.portion.myapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    packaging{
        resources{
            excludes +="META-INF/INDEX.LIST"
            pickFirsts +="META-INF/DEPENDENCIES"
            pickFirsts +="META-INF/io.netty.versions.properties"
        }
    }
}


dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.google.cloud:google-cloud-dialogflow:4.1.6")

    // Add gRPC dependencies
    implementation("io.grpc:grpc-okhttp:1.53.0")
    implementation("io.grpc:grpc-protobuf:1.53.0")
    implementation("io.grpc:grpc-stub:1.53.0")
    implementation("io.grpc:grpc-auth:1.53.0")
    implementation("com.google.protobuf:protobuf-java:3.21.12")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.6.0")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:okhttp-tls:4.12.0")

    implementation("io.reactivex.rxjava3:rxjava:3.1.0")
    implementation("io.reactivex.rxjava3:rxandroid:3.0.0")
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1")

    implementation("androidx.webkit:webkit:1.8.0")
}
