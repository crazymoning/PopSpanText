package cn.xzr.library.popspan;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import android.view.View;

/**
 * Created by xzr on 2017/10/23.
 */

public abstract class TouchableSpan extends CharacterStyle implements UpdateAppearance {

    private SpanPopWindow spanPopWindow;

    private static int sIdCounter = 0;

    private int mId = sIdCounter++;

    /**
     * Makes the text underlined and in the link color.
     */
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(ds.linkColor);
        ds.setUnderlineText(true);
    }

    /**
     * Get the unique ID for this span.
     *
     * @return The unique ID.
     * @hide
     */
    public int getId() {
        return mId;
    }

    public TouchableSpan(Context context,String text){
        spanPopWindow = new SpanPopWindow(context,text);
    }

    public void onActionDown(View widget,int x,int y){
        spanPopWindow.show(widget,x, y);
        onActionDown();
    }

    public void onActionUp(){
        spanPopWindow.dismiss();
    }

    public abstract void onActionDown();

}
