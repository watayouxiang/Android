package com.watayouxiang.androidcode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class i01CanvasView extends View {

    // ===========================================================================================
    // 构造函数
    // ===========================================================================================

    public i01CanvasView(Context context) {
        this(context, null);
    }

    public i01CanvasView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context      创建实例
     * @param attrs        将自定义控件声明在布局文件中
     * @param defStyleAttr 样式
     */
    public i01CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setColor(Color.RED);
        // 绘制空心图形
        paint.setStyle(Paint.Style.STROKE);
        // 去除锯齿,毛刺
        // 开启这个功能,将会耗费系统资源
        paint.setAntiAlias(true);
    }

    // ===========================================================================================
    // 画布
    // ===========================================================================================

    // 画笔
    private Paint paint;

    // 头
    private PointF headerPoint = new PointF(240, 400);
    private int headerRadius = 200;
    // 眼睛
    private PointF eye1Point = new PointF(170, 330);
    private PointF eye2Point = new PointF(310, 330);
    private int eyeRadius = 60;
    // 丁字
    private PointF line1Start = new PointF(140, 250);
    private PointF line1End = new PointF(340, 250);
    private PointF line2Start = new PointF(240, 250);
    private PointF line2End = new PointF(240, 500);
    private PointF line3End = new PointF(150, 450);
    // 嘴巴
    private RectF mouth_rectF = new RectF(60, 300, 420, 550);
    private float mouth_startAngle = 380f;
    private float mouth_sweepAngle = 140f;
    // 左耳
    private Rect leftEar = new Rect(30, 300, 80, 500);
    // 点的坐标的集合{x0,y0,x1,y1,x2,y2...}
    private float[] pts = {10, 20, 30, 40, 50, 60};

    /**
     * 绘制阶段调用这个方法
     *
     * @param canvas 画布
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();

        modifyCoordinate(canvas);
        drawRobot(canvas);
        drawPoints(canvas);

        canvas.restore();
    }

    private void drawPoints(Canvas canvas) {
        //参数1:点的坐标的集合{x0,y0,x1,y1,x2,y2...}
        //参数2:从参数1对应集合中的哪个点作为起始点,作为起始点的点为横坐标,后面依次顺延
        //参数3:需要使用集合中的几个元素
        //参数4:画笔
        canvas.drawPoints(pts, 0, pts.length, paint);
    }

    /**
     * 修改坐标系
     *
     * @param canvas
     */
    private void modifyCoordinate(Canvas canvas) {
        //平移
        //实际是对坐标系的平移
        canvas.translate(200, 0);
        //旋转
        //实际是对坐标系的旋转
        canvas.rotate(-45);
        //缩放
        //实际是对坐标系的缩放
        canvas.scale(0.2f, 0.2f);
    }

    /**
     * 画机器人
     *
     * @param canvas
     */
    private void drawRobot(Canvas canvas) {
        //头
        //参数1,2:圆心的x,y坐标
        //参数3:radius,圆的半径
        //参数4:画笔
        canvas.drawCircle(headerPoint.x, headerPoint.y, headerRadius, paint);
        //双眼
        canvas.drawCircle(eye1Point.x, eye1Point.y, eyeRadius, paint);
        canvas.drawCircle(eye2Point.x, eye2Point.y, eyeRadius, paint);

        //丁字轮廓
        //参数1,2:线段的起始点
        //参数3,4:线段的终点
        //参数5:画笔
        canvas.drawLine(line1Start.x, line1Start.y, line1End.x, line1End.y, paint);
        canvas.drawLine(line2Start.x, line2Start.y, line2End.x, line2End.y, paint);
        canvas.drawLine(line2End.x, line2End.y, line3End.x, line3End.y, paint);

        //嘴巴
        //参数1:RectF:矩形,是圆弧所在圆的外接矩形
        //参数2:弧的起始角度
        //参数3:弧的弧度
        //参数4:如果为true,则为扇形,否则为弧形
        //参数5:画笔
        canvas.drawArc(mouth_rectF, mouth_startAngle, mouth_sweepAngle, false, paint);

        //左耳
        //参数1:绘制的矩形
        //参数2:画笔
        canvas.drawRect(leftEar, paint);
    }
}
