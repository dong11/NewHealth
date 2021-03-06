package com.dong.huang.healthapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import com.dong.huang.healthapp.utils.DisplayUtil;

/**
 * Created by dong on 16/4/14.
 */
public class CircleBar extends View {

    private RectF mColorWheelRectangle = new RectF();// 圆圈的矩形范围
    private Paint mDefaultWheelPaint;// 绘制底部灰色圆圈的画笔
    private Paint mColorWheelPaint;// 绘制蓝色扇形的画笔
    private Paint textPaint;// 中间文字的画笔
    private Paint textPaint1;// 上下文字的画笔
    private float mColorWheelRadius;// 圆圈普通状态下的半径
    private float circleStrokeWidth;// 圆圈的线条粗细
    private int mText;// 中间文字内容
    private int mCount = 10;// 为了达到数字增加效果而添加的变量，他和mText其实代表一个意思
    private float mProgressAni;// 为了达到蓝色扇形增加效果而添加的变量，他和mProgress其实代表一个意思
    private float mProgress = 10;// 扇形弧度
    private int mTextSize;// 中间文字大小
    private int mTextSize1;// 上下文字大小
    private int mDistance;// 上下文字的距离
    private int mDistance1;//圆形离父布局的距离
    private int max = 10000;// 圆形所代表最大的数值
    BarAnimation anim;// 动画类


    public CircleBar(Context context) {
        this(context, null);
    }

    public CircleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        circleStrokeWidth = DisplayUtil.dip2px(getContext(), 20);// 圆圈的线条粗细
        mTextSize = DisplayUtil.sp2px(getContext(), 80);// 中间文字大小
        mTextSize1 = DisplayUtil.sp2px(getContext(), 25);// 上下文字大小
        mDistance = DisplayUtil.dip2px(getContext(), 60);// 文字间的距离
        mDistance1 = DisplayUtil.dip2px(getContext(), 20);//圆圈离父布局的距离

        // 绘制蓝色扇形的画笔
        mColorWheelPaint = new Paint();
        mColorWheelPaint.setAntiAlias(true);// 抗锯齿
        mColorWheelPaint.setColor(0xFF29a6f6);// 设置颜色
        mColorWheelPaint.setStyle(Paint.Style.STROKE);// 设置空心
        mColorWheelPaint.setStrokeCap(Paint.Cap.ROUND);//设置圆形画笔
        mColorWheelPaint.setStrokeWidth(circleStrokeWidth);// 设置圆圈粗细

        // 绘制底部灰色圆圈的画笔
        mDefaultWheelPaint = new Paint();
        mDefaultWheelPaint.setAntiAlias(true);
        mDefaultWheelPaint.setColor(0xFFeeefef);
        mDefaultWheelPaint.setStyle(Paint.Style.STROKE);
        mDefaultWheelPaint.setStrokeWidth(circleStrokeWidth);

        // 中间文字的画笔
        textPaint = new Paint(Paint.LINEAR_TEXT_FLAG);
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.parseColor("#6DCAEC"));
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setTextSize(mTextSize);

        // 上下文字的画笔
        textPaint1 = new Paint(Paint.LINEAR_TEXT_FLAG);
        textPaint1.setAntiAlias(true);
        textPaint1.setColor(Color.parseColor("#a1a3a6"));
        textPaint1.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint1.setTextAlign(Paint.Align.LEFT);
        textPaint1.setTextSize(mTextSize1);

        // 中间文字内容
        mText = 10;
        // 扇形弧度
        mProgress = 10;

        // 动画类
        anim = new BarAnimation();
        anim.setDuration(1000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int halfHeight = getHeight() / 2;
        int halfWidth = getWidth() / 2;
        int radius = halfHeight < halfWidth ? halfHeight : halfWidth;
        // 圆圈的矩形范围 绘制底部灰色圆圈的画笔
        canvas.drawCircle(halfWidth, halfHeight, radius - mDistance1,
                mDefaultWheelPaint);

        // mColorWheelRectangle是绘制蓝色扇形的画笔
        mColorWheelRectangle.top = halfHeight - radius + mDistance1;
        mColorWheelRectangle.bottom = halfHeight + radius - mDistance1;
        mColorWheelRectangle.left = halfWidth - radius + mDistance1;
        mColorWheelRectangle.right = halfWidth + radius - mDistance1;
        // 根据mProgressAni（角度）画扇形
        canvas.drawArc(mColorWheelRectangle, -90, mProgressAni, false,
                mColorWheelPaint);
        Rect bounds = new Rect();
        String middleText = "";// 中间的文字
        String upText = "";// 上面文字
        String downText = "";// 底部文字

        upText = "步数";
        downText = "目标:10000";
        middleText = String.valueOf(mCount);

        // 获得当前画笔绘制文本的宽和高
        textPaint.getTextBounds(middleText, 0, middleText.length(), bounds);
        // drawText各个属性的意思(文字,x坐标,y坐标,画笔)
        canvas.drawText(middleText, (mColorWheelRectangle.centerX())
                        - (textPaint.measureText(middleText) / 2),
                mColorWheelRectangle.centerY() + bounds.height() / 2, textPaint);
        textPaint1.getTextBounds(upText, 0, upText.length(), bounds);
        canvas.drawText(
                upText,
                (mColorWheelRectangle.centerX())
                        - (textPaint1.measureText(upText) / 2),
                mColorWheelRectangle.centerY() + bounds.height() / 2
                        - mDistance, textPaint1);
        textPaint1.getTextBounds(downText, 0, downText.length(), bounds);
        canvas.drawText(downText, (mColorWheelRectangle.centerX())
                        - (textPaint1.measureText(downText) / 2),
                mColorWheelRectangle.centerY() + bounds.height() / 2
                        + mDistance, textPaint1);
    }

    // 测量父布局的大小
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = getDefaultSize(getSuggestedMinimumHeight(),
                heightMeasureSpec);
        int width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        int min = Math.min(width, height);
        setMeasuredDimension(min, min);
        mColorWheelRadius = min - circleStrokeWidth;

        // set方法的参数意思：left,top,right,bottom
        mColorWheelRectangle.set(circleStrokeWidth,
                circleStrokeWidth, mColorWheelRadius,
                mColorWheelRadius);
    }

    // 设置圆圈的进度和圆圈所显示的第几个页面
    public void setProgress(int progress) {

        mProgress = (Float.valueOf(progress) / Float.valueOf(max)) * 360;
        mText = progress;
        this.mCount = progress;
        this.mProgressAni = (Float.valueOf(progress) / Float.valueOf(max)) * 360;

        this.postInvalidate();// 可以用子线程更新视图的方法调用。
    }

    /**
     * 继承animation的一个动画类
     */
    public class BarAnimation extends Animation {
        @Override
        protected void applyTransformation(float interpolatedTime,
                                           Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            if (interpolatedTime < 1.0f) {
                mProgressAni = interpolatedTime * mProgress;
                mCount = (int) (interpolatedTime * mText);
            } else {
                mProgressAni = mProgress;
                mCount = mText;
            }
            postInvalidate();

        }
    }
}
