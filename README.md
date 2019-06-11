# NY-Times
NY-Times application example with RxJava,RxAndroid,MVVM,Dagger2

in this project I followed the mvvm architecture and the reactive programing rx java and rx

Screenshots
-----------

HomeScreen                 |  HomesScreen search
:-------------------------:|:-------------------------:
<img src="/images/img1.png" width="250">  |  <img src="/images/img2.png" width="250">

HomeScreen(filter)         |  Article screen
:-------------------------:|:-------------------------:
<img src="/images/img3.png" width="250">  |  <img src="/images/img4.png" width="250">




### What to do to start working with the project 
- [Android studio v3.+](https://developer.android.com/studio/)
- [Kotlin v1.3.+](https://kotlinlang.org/docs/reference/)

#### SDK version

 * target sdk 28
 * min version 21
 
 
### How i version my code 

```gradle
// i use this to link the app version code by the commit count and the version name by the commit number
def gitSha = 'git rev-parse --short HEAD'.execute().text.trim()
def gitCommitCount = 100 + Integer.parseInt('git rev-list --count HEAD'.execute().text.trim())



android {
   ...
    defaultConfig {
     ...
        versionCode gitCommitCount
        versionName gitSha
       ... 
      }
}

``` 

Create Build 
------------
```gradle
 ./gradlew clean
 // run test
 ./gradlew test 
 // assemble
 ./gradlew assemble 
```


Generate Signed Apk
-------------------

```jvm

apksigner sign --ks my-release-key.jks --out my-app-release.apk my-app-unsigned-aligned.apk


```
 

### Libs used in the app

   Android libs
   * [Appcompat support](https://developer.android.com/topic/libraries/support-library/revisions)
   * [Constraint Layout](https://developer.android.com/topic/libraries/support-library/revisions)
   * [Android Ktx](https://developer.android.com/kotlin/ktx) 
   * [Material design 2](https://material.io/develop/android/)
   * [Espresso test And JUnit test](https://developer.android.com/topic/libraries/support-library/revisions) 
   
   Other libs 
   * [RxJava & RxAndroid](https://github.com/ReactiveX/RxJava)
   * [Dagger2](https://github.com/google/dagger)
   * [Retrofit](https://square.github.io/retrofit/)
    

### Developed by 

   * [Ahmad najar](https://github.com/a-najar)


### License

```text

Copyright 2017 Ahmad najar

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```