package cn.xzr.popspantext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import cn.dream.ebag.popspantext.R;
import cn.xzr.library.popspan.TouchSpanTextView;
import cn.xzr.library.popspan.TouchableSpan;

public class MainActivity extends AppCompatActivity {

    TouchSpanTextView textView;

    SpannableString spannableString;

    String text = "When it rains with sunshine, I will be very excited, because I know I can see " +
            "the rainbow soon. The colorful rainbow always attracts me, and the color red is so " +
            "beautiful, which is my favorite color. When I am in red clothes, it makes me look " +
            "with vitality. As I am young, red can presents me. My mother always likes red color, " +
            "and she says I look good in red. ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        spannableString = new SpannableString(text);
        setSpans("rainbow","彩虹");
        setSpans("attracts","吸引");
        setSpans("red","红色");
        textView.setText(spannableString,TextView.BufferType.EDITABLE);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void setSpans(String en,String cn){
        int i = 0;
        while (i != -1){
            i = text.indexOf(en,i);
            if (i != -1){
                spannableString.setSpan(new TouchableSpan(this,cn) {
                    @Override
                    public void onActionDown() {

                    }
                },i,i+en.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                i = i+en.length();
            }
        }
    }

}
