# LottieTest
This crash occurred during the test phase of my application. When I use the EndAnimationListener the app crash with a StackOverflowException in BaseLottieAnimator (most of the time).
Here is the information if you need more information don't hesitate to ask me.


**Crash description:** 
The app just stops when the Lottie is displayed.
The crash occurs these devices:
1. Pixel / Pixel 3 / Pixel 4
2. Motorola Moto Z
3. Samsung S9
4. Huawei Mate 9
5. Nokia 1
6. Xperia XZ1 Compact

All of these devices are on armeabi-v7a structure (I think it's a part of the problem) 


**How to reproduce:**
You can find [HERE](https://github.com/MickaelCalatr/LottieTest) a project based on the same architecture my project (same activities, same fragments, same assets) 

In this repo, you can also find all of the traces of the crash in _Log Crash_ directory. The crash are sorted by devices. In each folder, you'll find the settings of the device (Android API, brand, model, processor model...) and the entire logcat.

To reproduce the crash just start the app using one of the configurations I listed in _Log crash_ directory.


**Library version tested:**
com.airbnb.android:lottie:3.4.0
com.airbnb.android:lottie:3.4.1


**Other information:**
appcompat: androidx
minSdkVersion 24
targetSdkVersion 29
compileSdkVersion = 29


**Logcat:**
```
6-07 09:45:33.236: E/MonitoringInstr(10123): Exception encountered by: Thread[main,5,main]. Dumping thread state to outputs and pining for the fjords.
06-07 09:45:33.236: E/MonitoringInstr(10123): java.lang.StackOverflowError: stack size 8MB
06-07 09:45:33.236: E/MonitoringInstr(10123): 	at com.airbnb.lottie.utils.BaseLottieAnimator.notifyEnd(BaseLottieAnimator.java:71)
06-07 09:45:33.236: E/MonitoringInstr(10123): 	at com.airbnb.lottie.utils.LottieValueAnimator.endAnimation(LottieValueAnimator.java:217)
06-07 09:45:33.236: E/MonitoringInstr(10123): 	at com.airbnb.lottie.LottieDrawable.playAnimation(LottieDrawable.java:424)
06-07 09:45:33.236: E/MonitoringInstr(10123): 	at com.airbnb.lottie.LottieAnimationView.playAnimation(LottieAnimationView.java:550)
06-07 09:45:33.236: E/MonitoringInstr(10123): 	at com.antarticstudio.catify.utils.ViewUtilsKt$displayLoading$2.onAnimationEnd(ViewUtils.kt:33)
06-07 09:45:33.236: E/MonitoringInstr(10123): 	at com.airbnb.lottie.utils.BaseLottieAnimator.notifyEnd(BaseLottieAnimator.java:75)
06-07 09:45:33.236: E/MonitoringInstr(10123): 	at com.airbnb.lottie.utils.LottieValueAnimator.endAnimation(LottieValueAnimator.java:217)
06-07 09:45:33.236: E/MonitoringInstr(10123): 	at com.airbnb.lottie.LottieDrawable.playAnimation(LottieDrawable.java:424)
06-07 09:45:33.236: E/MonitoringInstr(10123): 	at com.airbnb.lottie.LottieAnimationView.playAnimation(LottieAnimationView.java:550)
```


