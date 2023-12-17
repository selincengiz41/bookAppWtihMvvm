# <p align="center"> Book App  📖 </p>


This application is developed for listing books.

<!-- Screenshots -->
## 📸 Screenshots
<p align="center">
  <img src="https://github.com/selincengiz41/bookAppWtihMvvm/assets/60012262/be4756cd-1417-40b5-80ae-cd5422bed2a0" width="130" height="300"/> 
  <img src="https://github.com/selincengiz41/bookAppWtihMvvm/assets/60012262/a3168c90-21e6-4ad0-a79d-c918ad882a59" width="130" height="300"/> 
  <img src="https://github.com/selincengiz41/bookAppWtihMvvm/assets/60012262/a7db925f-d758-42f4-8342-162f42bcbd85" width="130" height="300"/>
 



</p>



## :point_down: Structures 
- Lottie
- Navigation
- Retrofit
- Data Binding
- Hilt
- MVVM
- Glide
- SDP/SSP Library



## :pencil2: Dependency
```
    dependencies {

  // SSP-SDP library
    implementation 'com.intuit.ssp:ssp-android:1.1.0'
    implementation 'com.intuit.sdp:sdp-android:1.1.0'

    // Navigation
    implementation 'androidx.navigation:navigation-fragment-ktx:2.6.0'
    implementation 'androidx.navigation:navigation-ui-ktx:2.6.0'

    //Retrofit
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"

    //Glide
    implementation "com.github.bumptech.glide:glide:4.15.1"

    //Roundable Layout
    implementation 'com.github.zladnrms:RoundableLayout:1.1.4'

    //Lottie
    implementation 'com.airbnb.android:lottie:6.1.0'

    //Hilt
    implementation 'com.google.dagger:hilt-android:2.47'
    kapt 'com.google.dagger:hilt-compiler:2.47'


}
```

app build.gradle:

```
plugins {
 id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'kotlin-parcelize'
    id 'androidx.navigation.safeargs'
    //For the annotations
    id 'kotlin-kapt'
    id 'dagger.hilt.android.plugin'
}

buildFeatures {
      dataBinding = true
 }
```
project build.gradle:

```
plugins {
 id 'com.android.application' version '8.0.2' apply false
    id 'com.android.library' version '8.0.2' apply false
    id 'org.jetbrains.kotlin.android' version '1.8.20' apply false
    id 'androidx.navigation.safeargs.kotlin' version '2.5.1' apply false
    id 'com.google.dagger.hilt.android' version "2.44" apply false
}
```





