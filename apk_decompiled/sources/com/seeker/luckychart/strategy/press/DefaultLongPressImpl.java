package com.seeker.luckychart.strategy.press;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.seeker.luckychart.provider.ChartProvider;

/* JADX INFO: loaded from: classes.dex */
public class DefaultLongPressImpl implements LongPress, Handler.Callback {
    private ChartProvider chartProvider;
    private Handler handler = new Handler(Looper.getMainLooper(), this);

    private DefaultLongPressImpl(ChartProvider chartProvider) {
        this.chartProvider = chartProvider;
    }

    public static DefaultLongPressImpl create(ChartProvider chartProvider) {
        return new DefaultLongPressImpl(chartProvider);
    }

    @Override // com.seeker.luckychart.strategy.press.LongPress
    public void finish(MotionEvent motionEvent) {
        this.handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        this.handler.sendEmptyMessageDelayed(0, 50L);
        return true;
    }

    @Override // com.seeker.luckychart.strategy.press.LongPress
    public void longPressed(MotionEvent motionEvent) {
        this.handler.sendEmptyMessageDelayed(0, 50L);
    }
}
