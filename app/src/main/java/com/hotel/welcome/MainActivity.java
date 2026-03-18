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
        +".bl{bottom:24px;left:24px;border-width:0 0 1px 1px}.br{bottom:24px;right:24px;border-width:0 1px 1px 0}"
        +".clock{position:fixed;top:30px;left:50%;transform:translateX(-50%);font-family:'Cormorant Garamond',serif;font-size:20px;color:rgba(201,169,110,.5);letter-spacing:6px;z-index:10}"
        +".main{position:relative;z-index:5;height:100vh;display:flex;flex-direction:column;align-items:center;justify-content:center;text-align:center;padding:40px}"
        +".badge{display:flex;align-items:center;gap:14px;margin-bottom:36px;opacity:0;animation:fu 1s ease forwards .4s}"
        +".bl2{width:60px;height:1px;background:linear-gradient(90deg,transparent,var(--g))}"
        +".blr{background:linear-gradient(90deg,var(--g),transparent)}"
        +".bt{font-family:'Cormorant Garamond',serif;font-size:12px;letter-spacing:5px;color:var(--g);text-transform:uppercase}"
        +".war{font-family:'Tajawal',sans-serif;font-weight:300;font-size:clamp(22px,3.5vw,46px);color:var(--gl);letter-spacing:3px;opacity:0;animation:fu 1s ease forwards .7s;margin-bottom:6px}"
        +".wen{font-family:'Cormorant Garamond',serif;font-style:italic;font-size:clamp(14px,2vw,28px);color:rgba(201,169,110,.55);letter-spacing:7px;text-transform:uppercase;opacity:0;animation:fu 1s ease forwards .9s}"
        +".dv{display:flex;align-items:center;gap:16px;margin:26px 0;opacity:0;animation:fu 1s ease forwards 1s}"
        +".dl{flex:1;max-width:160px;height:1px;background:linear-gradient(90deg,transparent,var(--g),transparent)}"
        +".dd{width:8px;height:8px;background:var(--g);transform:rotate(45deg)}"
        +".gn{font-family:'Playfair Display','Tajawal',serif;font-size:clamp(38px,7vw,96px);font-weight:700;background:linear-gradient(135deg,var(--gl) 0%,var(--g) 40%,#fff8e7 60%,var(--g) 80%);-webkit-background-clip:text;-webkit-text-fill-color:transparent;background-size:200% 100%;opacity:0;animation:fu 1.2s ease forwards 1.2s,sh 4s ease-in-out infinite 2.5s;line-height:1.15}"
        +"@keyframes sh{0%,100%{background-position:0%}50%{background-position:100%}}"
        +".mar{font-family:'Tajawal',sans-serif;font-weight:300;font-size:clamp(14px,2vw,24px);color:rgba(245,240,232,.75);letter-spacing:2px;opacity:0;animation:fu 1s ease forwards 1.5s;margin-bottom:5px}"
        +".men{font-family:'Cormorant Garamond',serif;font-style:italic;font-size:clamp(12px,1.6vw,20px);color:rgba(201,169,110,.5);letter-spacing:3px;opacity:0;animation:fu 1s ease forwards 1.7s}"
        +".rb{margin-top:36px;display:inline-flex;align-items:center;gap:12px;border:1px solid rgba(201,169,110,.3);padding:9px 26px;position:relative;opacity:0;animation:fu 1s ease forwards 1.9s}"
        +".rb::before,.rb::after{content:'';position:absolute;width:5px;height:5px;border:1px solid var(--g);transform:rotate(45deg);background:var(--d)}"
        +".rb::before{top:-3px;left:-3px}.rb::after{bottom:-3px;right:-3px}"
        +".rl{font-family:'Tajawal',sans-serif;font-size:11px;color:rgba(201,169,110,.6);letter-spacing:2px}"
        +".rn{font-family:'Cormorant Garamond',serif;font-size:24px;font-weight:600;color:var(--g);letter-spacing:4px}"
        +".ren{font-family:'Cormorant Garamond',serif;font-style:italic;font-size:11px;color:rgba(201,169,110,.4);letter-spacing:3px}"
        +".bar{position:fixed;bottom:0;left:0;right:0;height:3px;background:linear-gradient(90deg,transparent,var(--g),var(--gl),var(--g),transparent);animation:gb 3s ease-in-out infinite}"
        +"@keyframes gb{0%,100%{opacity:.4}50%{opacity:1}}"
        +".loading{font-family:'Tajawal',sans-serif;font-size:18px;color:rgba(201,169,110,.5);letter-spacing:3px;animation:pu 1.5s ease-in-out infinite}"
        +"@keyframes pu{0%,100%{opacity:.3}50%{opacity:1}}"
        +"@keyframes fu{from{opacity:0;transform:translateY(26px)}to{opacity:1;transform:translateY(0)}}";
    static final String JS=
        "var bg=document.getElementById('bg');"
        +"for(var i=0;i<35;i++){var p=document.createElement('div');p.className='pt';"
        +"p.style.left=Math.random()*100+'%';p.style.animationDuration=(Math.random()*18+12)+'s';"
        +"p.style.animationDelay=(Math.random()*25)+'s';bg.appendChild(p);}"
        +"function tick(){var n=new Date(),h=String(n.getHours()).padStart(2,'0'),m=String(n.getMinutes()).padStart(2,'0');"
        +"document.getElementById('clk').textContent=h+' : '+m;}tick();setInterval(tick,30000);"
        +"var cur=null;"
        +"function fetchG(){return fetch(U+'/rest/v1/'+T+'?'+RC+'=eq.'+R+'&select='+NC+','+RC+'&limit=1',"
        +"{headers:{'apikey':K,'Authorization':'Bearer '+K}})"
        +".then(function(r){return r.json()})"
        +".then(function(d){return d&&d.length?d[0][NC]:null});}"
        +"function show(n){"
        +"var m=document.getElementById('main');"
        +"m.innerHTML="
        +"'<div class=\"badge\"><div class=\"bl2\"></div><div class=\"bt\">Welcome · أهلاً وسهلاً</div><div class=\"bl2 blr\"></div></div>'"
        +"+'<div class=\"war\">'+(n?'مرحباً بك يا':'الغرفة')+'</div>'"
        +"+'<div class=\"wen\">Welcome</div>'"
        +"+'<div class=\"dv\"><div class=\"dl\"></div><div class=\"dd\"></div><div class=\"dl\"></div></div>'"
        +"+'<div class=\"gn\">'+(n||'<span style=\"font-size:.45em;color:rgba(201,169,110,.3)\">لا يوجد نزيل حالياً</span>')+'</div>'"
        +"+(n?'<div class=\"mar\">نتمنى لك إقامة سعيدة</div><div class=\"men\">We wish you a pleasant stay</div>':'')"
        +"+'<div class=\"rb\"><div class=\"rl\">الغرفة</div><div class=\"rn\">'+R+'</div><div class=\"ren\">Room</div></div>';}"
        +"fetchG().then(function(n){cur=n;show(n);}).catch(function(){show(null);});"
        +"setInterval(function(){fetchG().then(function(n){if(n!==cur){cur=n;show(n);}}).catch(function(){});},60000);";
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|
            WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD|
            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|
            WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        hideNav();
        SharedPreferences p=getSharedPreferences(PREFS,MODE_PRIVATE);
        if(!p.getBoolean("ok",false)){startActivity(new Intent(this,SetupActivity.class));finish();return;}
        FrameLayout fl=new FrameLayout(this);fl.setBackgroundColor(Color.BLACK);setContentView(fl);
        wv=new WebView(this);wv.setBackgroundColor(Color.BLACK);
        WebSettings s=wv.getSettings();
        s.setJavaScriptEnabled(true);s.setDomStorageEnabled(true);
        s.setCacheMode(WebSettings.LOAD_NO_CACHE);
        s.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        s.setLoadWithOverviewMode(true);s.setUseWideViewPort(true);
        wv.setWebViewClient(new WebViewClient(){@Override public boolean shouldOverrideUrlLoading(WebView v,String u){return false;}});
        wv.setWebChromeClient(new WebChromeClient());
        fl.addView(wv,new FrameLayout.LayoutParams(-1,-1));
        String room=p.getString("room",""),url=p.getString("url",""),key=p.getString("key",""),
               tbl=p.getString("tbl","reservations"),nc=p.getString("nc","guest_name"),rc=p.getString("rc","room_number");
        wv.loadDataWithBaseURL("https://localhost/",buildHtml(room,url,key,tbl,nc,rc),"text/html","UTF-8",null);
    }
    void hideNav(){
        getWindow().getDecorView().setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
            View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    @Override public void onWindowFocusChanged(boolean f){super.onWindowFocusChanged(f);if(f)hideNav();}
    @Override public boolean onKeyDown(int k,KeyEvent e){
        if(k==KeyEvent.KEYCODE_BACK||k==KeyEvent.KEYCODE_HOME)return true;
        return super.onKeyDown(k,e);}
    @Override protected void onResume(){super.onResume();if(wv!=null)wv.onResume();}
    @Override protected void onPause(){super.onPause();if(wv!=null)wv.onPause();}
    String esc(String s){return s.replace("\\","\\\\").replace("'","\\'");}
    String buildHtml(String room,String url,String key,String tbl,String nc,String rc){
        return "<!DOCTYPE html><html lang='ar' dir='rtl'><head><meta charset='UTF-8'>"
        +"<meta name='viewport' content='width=device-width,initial-scale=1'>"
        +"<link href='https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&family=Tajawal:wght@300;400;700&family=Cormorant+Garamond:ital,wght@0,300;0,600;1,300&display=swap' rel='stylesheet'>"
        +"<style>"+CSS+"</style></head><body>"
        +"<div class='bg' id='bg'></div>"
        +"<div class='c tl'></div><div class='c tr'></div><div class='c bl'></div><div class='c br'></div>"
        +"<div class='clock' id='clk'>--:--</div>"
        +"<div class='main' id='main'><div class='loading'>جارٍ التحميل...</div></div>"
        +"<div class='bar'></div>"
        +"<script>var R='"+esc(room)+"',U='"+esc(url)+"',K='"+esc(key)+"',T='"+esc(tbl)+"',NC='"+esc(nc)+"',RC='"+esc(rc)+"';</script>"
        +"<script>"+JS+"</script></body></html>";}
}
