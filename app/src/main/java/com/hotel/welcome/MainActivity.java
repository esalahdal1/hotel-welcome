package com.hotel.welcome;
import android.app.Activity;
import android.content.*;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.webkit.*;
import android.widget.FrameLayout;
public class MainActivity extends Activity {
    WebView wv;
    static final String PREFS="hotel_config";
    static final String CSS=
        ":root{--g:#c9a96e;--gl:#e8d5a3;--d:#0a0a0f;--c:#f5f0e8}"
        +"*{margin:0;padding:0;box-sizing:border-box}"
        +"body{background:var(--d);color:var(--c);font-family:'Tajawal',sans-serif;height:100vh;overflow:hidden}"
        +".bg{position:fixed;inset:0;background:radial-gradient(ellipse 80% 60% at 20% 50%,rgba(201,169,110,.13) 0%,transparent 60%),radial-gradient(ellipse 60% 80% at 80% 30%,rgba(201,169,110,.07) 0%,transparent 50%),linear-gradient(135deg,#0a0a0f,#12121a 40%,#0d0d18)}"
        +".pt{position:absolute;width:2px;height:2px;background:var(--g);border-radius:50%;opacity:0;animation:fp linear infinite}"
        +"@keyframes fp{0%{opacity:0;transform:translateY(100vh)}10%{opacity:.6}90%{opacity:.2}100%{opacity:0;transform:translateY(-10vh)}}"
        +".c{position:fixed;width:90px;height:90px;border-color:rgba(201,169,110,.4);border-style:solid;z-index:10}"
        +".tl{top:24px;left:24px;border-width:1px 0 0 1px}.tr{top:24px;right:24px;border-width:1px 1px 0 0}"
        +".bl{bottom:24px;left:24px;border-width:0 0​​​​​​​​​​​​​​​​
