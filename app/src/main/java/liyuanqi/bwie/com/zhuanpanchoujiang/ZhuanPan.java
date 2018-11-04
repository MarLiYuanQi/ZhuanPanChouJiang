package liyuanqi.bwie.com.zhuanpanchoujiang;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

/**
 * date:2018/11/4
 * author:理元旗(ynkj)
 * function:
 */

public class ZhuanPan extends View implements View.OnClickListener {
    private Paint mPaint;
    private Paint startpaint;
    private Boolean isStart=false;
    private String neitext="start";
    private RectF mRectF;
    private int mwidth;
    private int mpidding;
    private RotateAnimation mRotateAnimation;
    private String[] texts=new String[]{"苹果","橘子","香蕉","荔枝","榴莲","葡萄"};

    public int[] colors=new int[]{Color.parseColor("#8EE5EE"),Color.parseColor("#FFD700"),Color.parseColor("#8EE5EE"),Color.parseColor("#FFD700"),Color.parseColor("#8EE5EE"),Color.parseColor("#FFD700")};

    public ZhuanPan(Context context) {
        super(context);

    }

    public ZhuanPan(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mypind();
        myRotateAnimation();
        setOnClickListener(this);
    }

    public ZhuanPan(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);



    }
    private void myRotateAnimation() {
        mRotateAnimation=new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        mRotateAnimation.setRepeatCount(-1);
        mRotateAnimation.setFillAfter(true);
    }

    private void mypind() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(3);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(300,300);
        mwidth=getMeasuredWidth();
        mpidding=5;

        mRectF=new RectF(0,0,mwidth,mwidth);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(mwidth / 2, mwidth / 2, mwidth / 2 - mpidding, mPaint);
        mPaint.setStyle(Paint.Style.FILL);
        inithu(canvas);

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(mwidth / 2, mwidth / 2, 50, mPaint);


        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(24);
        Rect rect = new Rect();
        mPaint.getTextBounds(neitext, 0, neitext.length(), rect);
        int strWidth = rect.width();//文本的宽度
        int textHeight = rect.height();//文本的高度

        canvas.drawText(neitext, mwidth/2-25+25-strWidth/2,mwidth/2+textHeight/2,mPaint);
    }
    private void inithu(Canvas canvas) {
        for (int i=0;i<6;i++){
            mPaint.setColor(colors[i]);
            canvas.drawArc(mRectF,(i-1)*60+60,60,true,mPaint);
        }
        for (int i=0;i<6;i++){
            mPaint.setColor(Color.BLACK);
            Path path=new Path();
            path.addArc(mRectF,(i-1)*60+60,60);
            canvas.drawTextOnPath(texts[i],path,60,60,mPaint);
        }
    }



    @Override
    public void onClick(View v) {
        if (!isStart){
            isStart=true;
            mRotateAnimation.setDuration(1000);
            mRotateAnimation.setInterpolator(new LinearInterpolator());
            startAnimation(mRotateAnimation);
        }else {
            isStart=false;
            clearAnimation();
        }

    }
}
