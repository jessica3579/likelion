package com.example.androidproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CircleScoreView extends View {
    Paint paint;
    // 나중에 최근 성적 받아서  50 자리에 넣어야함..
    float progress = 0;

    public CircleScoreView(Context context) {
        super(context);
        init();
    }

    public CircleScoreView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleScoreView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        float centerX = getWidth() / 2f;
        float centerY = getHeight() / 2f;
        float stroke = paint.getStrokeWidth();
        float radius = Math.min(centerX, centerY) - stroke / 2;

        RectF rect = new RectF(
                centerX - radius,
                centerY - radius,
                centerX + radius,
                centerY + radius
        );

        // 회색 도넛
        paint.setColor(Color.GRAY);
        canvas.drawArc(rect, 0f, 360f, false, paint);

        // 파랑 도넛
        paint.setColor(Color.BLUE);
        canvas.drawArc(rect, -90f, progress, false, paint);


    }

    public void setProgress(int score){
        this.progress = (score / 100f) * 360;
        // 다시 그리기
        invalidate();
    }
}
