package com.watayouxiang.androidcode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class Test01Path extends View {

	private Paint paint;
	private Path path;

	public Test01Path(Context context) {
		this(context,null);
	}

	public Test01Path(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}

	public Test01Path(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init() {
		paint = new Paint();
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.STROKE);
		path = new Path();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		testPath();

		//利用画布绘制path

		path.moveTo(100,100);
		//绘制贝塞尔曲线
		//三个关键点:
		//1,起始点
		//2,终点
		//3,控制点:control point
		path.quadTo(200,400,100,300);
		path.quadTo(200,400,60,500);
		path.lineTo(100,300);
		path.lineTo(100,100);

		canvas.drawPath(path,paint);
	}

	private void testPath() {
		//将path移动到绘制的起始点
		path.moveTo(200,200);
		//以moveTo之后的点为起始点,以参数1,2为终点绘制一条线段
		path.lineTo(100,200);
		path.lineTo(100,300);
		path.lineTo(200,300);
		//闭合路径
		path.close();
	}
}
