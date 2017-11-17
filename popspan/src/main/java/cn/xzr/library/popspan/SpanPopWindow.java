package cn.xzr.library.popspan;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by xzr on 2017/11/17.
 */

public class SpanPopWindow{
    private PopupWindow popupWindow;

    private TextView mText;

    public SpanPopWindow(Context context){
        popupWindow = new PopupWindow(context);

        mText = new TextView(context);
        mText.setPadding(5,5,5,5);
        mText.setBackgroundColor(Color.argb(100,0,0,0));
        mText.setTextColor(Color.WHITE);
        mText.setTextSize(20);
        popupWindow.setContentView(mText);
    }

    public SpanPopWindow(Context context,String text){
        this(context);
        mText.setText(text);
    }

    public void setText(String text){
        if (mText != null){
            mText.setText(text);
        }
    }

    public void show(View view,int x,int y){
        if (mText != null && mText.length() > 0){
            popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.showAtLocation(view, Gravity.TOP|Gravity.START,x,y);
            popupWindow.setTouchable(false);
        }

    }

    public void dismiss(){
        popupWindow.dismiss();
    }

}
