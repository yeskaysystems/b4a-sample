# Basic4Android Sample for Pushe

This is a sample application (made by B4A), which is powered by [Pushe](http://pushe.co) push notification service.

You can see other samples:
* [Android Studio](https://github.com/ronashco/pushe-android-studio-sample)
* [Eclipse](https://github.com/ronashco/pushe-eclipse-sample)
* [Unity](https://github.com/ronashco/pushe-unity-sample)

To see our demo app or its wiki page you may take a look at:
* [Download app from Google Play](https://play.google.com/store/apps/details?id=co.ronash.pushesample)
* [Github Repository](https://github.com/ronashco/pushe-sample)

## Using Pushe Sample Code for B4A

The project is organized in a way that you can use it with minimum efforts. To use this sample, follow these steps:

1. First download or clone the project on your computer
2. Go to `b4a-sample` folder and open the B4A project. 
3. Select `Tools -> configure Paths` from B4A menu bar and set `Additional Libraries` to `aditional-lib` folder which exists in the root of this project. Alternatively you can copy the content of this folder into your `aditional-lib` folder.
4. If you `DONT want` to send costum json with your notifications, remove `PusheJsonService` from project via `Project -> Remove Module` also remove below lines to your manifest by selecting `Project -> Manifest Editor`:
I
AddManifestText(<permission android:name="$PACKAGE$.permission.C2D_MESSAGE"            android:protectionLevel="signature" />)
AddPermission($PACKAGE$.permission.C2D_MESSAGE)
AddPermission(com.google.android.c2dm.permission.RECEIVE)
' Push Service Receiver Attribute
SetReceiverAttribute(PusheJsonService, android:permission,                 "com.google.android.c2dm.permission.SEND")
' Service Receiver Text
AddReceiverText(PusheJsonService,
<intent-filter>
<action android:name="com.google.android.c2dm.intent.RECEIVE" />
<category android:name="$PACKAGE$" />
</intent-filter>
<intent-filter>
<action android:name="com.google.android.c2dm.intent.REGISTRATION" />
<category android:name="$PACKAGE$" />
</intent-filter>)
5. Run the project.

## More Info
For detailed documentations visit http://docs.pushe.co


## Support 
#### Email:
support [at] pushe.co
#### Phone:
+98-21-44668276 (8:00 to 17:00 Sat-Thu)
