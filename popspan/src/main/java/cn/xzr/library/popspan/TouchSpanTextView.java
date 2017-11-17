package cn.xzr.library.popspan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by xzr on 2017/10/23.
 */

@SuppressLint("AppCompatCustomView")
public class TouchSpanTextView extends TextView {

    public TouchSpanTextView(Context context) {
        super(context);
    }

    public TouchSpanTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchSpanTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    TouchableSpan[] link;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        CharSequence text = getText();

        if (text instanceof Spannable) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                link = new TouchableSpan[]{};
                int x= (int) event.getX();
                int y= (int) event.getY();

                x -= getTotalPaddingLeft();
                y -= getTotalPaddingTop();

                x += getScrollX();
                y += getScrollY();

                Layout layout = getLayout();
                int line = layout.getLineForVertical(y);
                int off = layout.getOffsetForHorizontal(line, x);
                link = ((Spannable)text).getSpans(off, off, TouchableSpan.class);
                if (link.length != 0) {
                    link[0].onActionDown(this, (int) (x+getX()), (int) (getY() - y+(line+1)*getTextSize()*2));
                    return true;
                }
            }else if (event.getAction() == MotionEvent.ACTION_UP){
                if (link.length != 0){
                    link[0].onActionUp();
                    return true;
                }
            }
        }
        return super.onTouchEvent(event);
    }

}
