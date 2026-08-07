package com.ldf.calendar.view;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import com.ldf.calendar.component.CalendarAttr$CalendarType;
import com.ldf.calendar.model.CalendarDate;
import defpackage.dy0;
import defpackage.ku1;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
public class Calendar extends View {
    private int a;
    private int b;
    private float c;
    private float d;
    private float e;

    public CalendarAttr$CalendarType getCalendarType() {
        throw null;
    }

    public int getCellHeight() {
        return this.a;
    }

    public CalendarDate getFirstDate() {
        throw null;
    }

    public CalendarDate getLastDate() {
        throw null;
    }

    public CalendarDate getSeedDate() {
        throw null;
    }

    public int getSelectedRowIndex() {
        throw null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        throw null;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a = i2 / 6;
        this.b = i / 7;
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.d = motionEvent.getX();
            this.e = motionEvent.getY();
        } else if (action == 1) {
            float x = motionEvent.getX() - this.d;
            float y = motionEvent.getY() - this.e;
            if (Math.abs(x) < this.c && Math.abs(y) < this.c) {
                throw null;
            }
        }
        return true;
    }

    public void setDayRenderer(dy0 dy0Var) {
        throw null;
    }

    public void setOnAdapterSelectListener(ku1 ku1Var) {
    }

    public void setSelectedRowIndex(int i) {
        throw null;
    }
}
