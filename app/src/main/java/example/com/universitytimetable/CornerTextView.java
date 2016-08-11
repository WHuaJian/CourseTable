package example.com.universitytimetable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.TextView;

/**
 * Created by weihuajian on 16/5/26.
 */
public class CornerTextView extends TextView {

    private int mBgColor = 0; //背景颜色
    private int mCornerSize = 0; //圆角大小

    public CornerTextView(Context context, int bgColor, int cornerSize) {
        super(context);
        mBgColor = bgColor;
        mCornerSize = cornerSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(mBgColor);
        paint.setAlpha(180);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight()), mCornerSize, mCornerSize, paint);

        super.onDraw(canvas);
    }
}
