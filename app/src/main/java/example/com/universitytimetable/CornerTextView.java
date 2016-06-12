package example.com.universitytimetable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
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
        super.onDraw(canvas);
        setCornerBg(this.getMeasuredWidth(), this.getMeasuredHeight(), this);
    }

    public void setCornerBg(int w, int h, View v) {
        Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmp);

        Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);
        paint.setAntiAlias(true);
        paint.setColor(mBgColor);
        paint.setAlpha(180);
        RectF rec = new RectF(0, 0, w, h);
        c.drawRoundRect(rec, mCornerSize, mCornerSize, paint);
        v.setBackground(new BitmapDrawable(getResources(), bmp));
    }
}
