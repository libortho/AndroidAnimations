# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:\Development\android-sdk-win/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}


-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-dontwarn okio.**

-dontwarn android.net.http.**
-keep class android.net.http.AndroidHttpClient

-dontwarn com.google.android.gms.**
-keep class com.google.android.gms.**

-keepclassmembers class com.improvedigital.mobile360sdk.core.JavascriptInterface {
    public *;
}

-dontwarn javax.xml.stream.events.**
-dontwarn org.simpleframework.xml.stream.**
-dontwarn org.xmlpull.v1.**
-keep class org.xmlpull.v1.** { *; }

-keep public class org.simpleframework.** { *; }
-keep class org.simpleframework.xml.** { *; }
-keep class org.simpleframework.xml.core.** { *; }
-keep class org.simpleframework.xml.util.** { *; }

-keep class com.improvedigital.mobile360sdk.vast.model.** { *; }
