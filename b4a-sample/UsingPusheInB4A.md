# Basic4Android Sample for Pushe

This is a sample application (made by B4A), which is powered by [Pushe](http://pushe.co) push notification service.

You can see other samples:
* [Android Studio](https://github.com/ronashco/pushe-android-studio-sample)
* [Eclipse](https://github.com/ronashco/pushe-eclipse-sample)
* [Unity](https://github.com/ronashco/pushe-unity-sample)

To see our demo app or its wiki page you may take a look at:
* [Download app from Google Play](https://play.google.com/store/apps/details?id=co.ronash.pushesample)
* [Github Repository](https://github.com/ronashco/pushe-sample)

## Pushe Installation in a Basic4Android Project

You need add `Golgle Play Services` and `android-support-v4` to your project in order to use Pushe service.
###Add Google Play Services

1. Download [Google Play Services](http://static.pushe.co/useful-links/google-play-services/eclipse/google-play-services_lib.zip) library and extarct
2. Copy `Google-Play-Services.jar` from extracted folder and paste it into B4A `Additional Library` (it should be some where like: C:\Program Files\Anywhere Software\Basic4android\Libraries)

###Add Android-Support-V4.jar

1. Download [Android-Support-V4.jar](http://static.pushe.co/useful-links/android-support-v4.jar)
2. Copy downloaded file into `Additional Library` (it should be some where like: C:\Program Files\Anywhere Software\Basic4android\Libraries)

###Add Pushe library

1. Download [Pushe library](https://static.pushe.co/sdk/pushe-0.8.2-b4a.zip)
2. Copy `PusheWrapper.jar` and `PusheWrapper.xml` from extracted folder to `Additional Library`
3. Right click on Libreries Window in your B4A software and refresh libreries then select `Pushe-Wrapper`
4. In `Main` class add `Dim p1 As PusheLib` to `Sub Globals`
5. In `Main` class add `p1.initialize()` to `Activity Create`

###Adding Resources

Add (or change) below codes to your `Project Attributes` in your `Main` class:

`#AdditionalRes:  **REPLACE YOUR google play service library res folder PATH HERE**  , com.google.android.gms`

`#AdditionalRes:  **REPLACE YOUR library res folder PATH HERE** , co.ronash.pushe`

###Changes in AndroidManifest.xml

1. Add your application in your [Pushe Panel](http://pushe.co/panel/platform/application/add/) with the same package name as you defined in B4A `Build Configuration`
2. Download proper Manifest file from panel and add content to project's `AndroidManifest`. You can find it in: `Project>Manifest Editor`

###Run
Your project is ready to run. Go to `File` menu and select `Build & Run`

## More Info
For detailed documentations visit http://docs.pushe.co


## Support 
#### Email:
support [at] pushe.co
#### Phone:
+98-21-44668276 (8:00 to 17:00 Sat-Thu)
