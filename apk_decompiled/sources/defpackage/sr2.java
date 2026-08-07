package defpackage;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public final class sr2 extends TimerTask {
    private int a = Integer.MAX_VALUE;
    private int b = 0;
    private int c;
    private final WheelView d;

    public sr2(WheelView wheelView, int i) {
        this.d = wheelView;
        this.c = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.a == Integer.MAX_VALUE) {
            this.a = this.c;
        }
        int i = this.a;
        int i2 = (int) (i * 0.1f);
        this.b = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.b = -1;
            } else {
                this.b = 1;
            }
        }
        if (Math.abs(i) <= 1) {
            this.d.a();
            this.d.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.d;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.b);
        if (!this.d.h()) {
            float itemHeight = this.d.getItemHeight();
            float f = (-this.d.getInitPosition()) * itemHeight;
            float itemsCount = ((this.d.getItemsCount() - 1) - this.d.getInitPosition()) * itemHeight;
            if (this.d.getTotalScrollY() <= f || this.d.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.d;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.b);
                this.d.a();
                this.d.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.d.getHandler().sendEmptyMessage(1000);
        this.a -= this.b;
    }
}
