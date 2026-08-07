package com.seeker.luckychart.strategy.press;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.seeker.luckychart.charts.ECGChartView;
import com.seeker.luckychart.provider.ChartProvider;

/* JADX INFO: loaded from: classes.dex */
public class ECGLongPressImpl implements LongPress, Handler.Callback {
    private static final int LONGPRESSED = 1;
    private ChartProvider chartProvider;
    private ECGChartView chartView;
    private boolean gainUp = false;
    private Handler handler = new Handler(Looper.getMainLooper(), this);

    private ECGLongPressImpl(ChartProvider chartProvider) {
        this.chartProvider = chartProvider;
        this.chartView = (ECGChartView) chartProvider.getSelf();
    }

    public static ECGLongPressImpl create(ChartProvider chartProvider) {
        return new ECGLongPressImpl(chartProvider);
    }

    @Override // com.seeker.luckychart.strategy.press.LongPress
    public void finish(MotionEvent motionEvent) {
        this.handler.removeMessages(1);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        this.handler.sendEmptyMessageDelayed(1, 16L);
        if (this.gainUp) {
            this.chartView.gainUp();
        } else {
            this.chartView.gainDown();
        }
        return true;
    }

    @Override // com.seeker.luckychart.strategy.press.LongPress
    public void longPressed(MotionEvent motionEvent) {
        this.gainUp = motionEvent.getY() <= ((float) (this.chartProvider.getChartComputator().getChartHeight() / 2));
        this.handler.sendEmptyMessageDelayed(1, 16L);
    }
}
