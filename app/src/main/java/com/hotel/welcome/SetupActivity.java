package com.hotel.welcome;
import android.app.Activity;
import android.content.*;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.*;
import android.widget.*;
public class SetupActivity extends Activity {
    static final String PREFS="hotel_config";
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ScrollView sv=new ScrollView(this); sv.setBackgroundColor(0xff0a0a0f);
        LinearLayout ll=new LinearLayout(this); ll.setOrientation(LinearLayout.VERTICAL); ll.setPadding(80,60,80,60);
        addTitle(ll,"إعداد الشاشة — Screen Setup");
        EditText eRoom=field(ll,"رقم الغرفة — Room Number","101",false);
        EditText eUrl=field(ll,"Supabase URL","https://xxxx.supabase.co",false);
        EditText eKey=field(ll,"Supabase Anon Key","eyJ...",true);
        EditText eTbl=field(ll,"اسم الجدول — Table","reservations",false);
        EditText eNc=field(ll,"عمود الاسم — Name Column","guest_name",false);
        EditText eRc=field(ll,"عمود الغرفة — Room Column","room_number",false);
        SharedPreferences p=getSharedPreferences(PREFS,MODE_PRIVATE);
        eRoom.setText(p.getString("room",""));eUrl.setText(p.getString("url",""));
        eKey.setText(p.getString("key",""));eTbl.setText(p.getString("tbl","reservations"));
        eNc.setText(p.getString("nc","guest_name"));eRc.setText(p.getString("rc","room_number"));
        TextView err=new TextView(this);err.setTextColor(0xffe07070);err.setTextSize(13);ll.addView(err);
        Button btn=new Button(this);btn.setText("حفظ والبدء — Save & Start");
        btn.setBackgroundColor(0xffc9a96e);btn.setTextColor(0xff0a0a0f);btn.setTextSize(16);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(-1,-2);lp.setMargins(0,20,0,0);btn.setLayoutParams(lp);
        btn.setOnClickListener(v->{
            String room=eRoom.getText().toString().trim(),url=eUrl.getText().toString().trim(),
                   key=eKey.getText().toString().trim();
            if(room.isEmpty()||url.isEmpty()||key.isEmpty()){err.setText("⚠ يرجى ملء جميع الحقول");return;}
            p.edit().putString("room",room).putString("url",url).putString("key",key)
             .putString("tbl",eTbl.getText().toString().trim().isEmpty()?"reservations":eTbl.getText().toString().trim())
             .putString("nc",eNc.getText().toString().trim().isEmpty()?"guest_name":eNc.getText().toString().trim())
             .putString("rc",eRc.getText().toString().trim().isEmpty()?"room_number":eRc.getText().toString().trim())
             .putBoolean("ok",true).apply();
            startActivity(new Intent(this,MainActivity.class));finish();});
        ll.addView(btn);sv.addView(ll);setContentView(sv);
    }
    void addTitle(LinearLayout p,String t){TextView v=new TextView(this);v.setText(t);v.setTextColor(0xffc9a96e);v.setTextSize(20);v.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);v.setPadding(0,0,0,30);p.addView(v);}
    EditText field(LinearLayout p,String lbl,String hint,boolean pw){
        TextView l=new TextView(this);l.setText(lbl);l.setTextColor(0xffc9a96e);l.setTextSize(12);l.setPadding(0,14,0,4);p.addView(l);
        EditText e=new EditText(this);e.setHint(hint);e.setHintTextColor(0xff444444);e.setTextColor(Color.WHITE);
        e.setTextSize(15);e.setBackgroundColor(0xff1a1a24);e.setPadding(18,14,18,14);
        if(pw)e.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        else e.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        p.addView(e);return e;}
}
