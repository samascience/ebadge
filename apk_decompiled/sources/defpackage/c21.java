package defpackage;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public final class c21 extends TimerTask {
    private float a = 2.1474836E9f;
    private final float b;
    private final WheelView c;

    public c21(WheelView wheelView, float f) {
        this.c = wheelView;
        this.b = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.a == 2.1474836E9f) {
            if (Math.abs(this.b) > 2000.0f) {
                this.a = this.b <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.a = this.b;
            }
        }
        if (Math.abs(this.a) >= 0.0f && Math.abs(this.a) <= 20.0f) {
            this.c.a();
            this.c.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.a / 100.0f);
        WheelView wheelView = this.c;
        float f = i;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f);
        if (!this.c.h()) {
            float itemHeight = this.c.getItemHeight();
            float totalScrollY = (-this.c.getInitPosition()) * itemHeight;
            float itemsCount = ((this.c.getItemsCount() - 1) - this.c.getInitPosition()) * itemHeight;
            double d = ((double) itemHeight) * 0.25d;
            if (((double) this.c.getTotalScrollY()) - d < totalScrollY) {
                totalScrollY = this.c.getTotalScrollY() + f;
            } else if (((double) this.c.getTotalScrollY()) + d > itemsCount) {
                itemsCount = this.c.getTotalScrollY() + f;
            }
            if (this.c.getTotalScrollY() <= totalScrollY) {
                this.a = 40.0f;
                this.c.setTotalScrollY((int) totalScrollY);
            } else if (this.c.getTotalScrollY() >= itemsCount) {
                this.c.setTotalScrollY((int) itemsCount);
                this.a = -40.0f;
            }
        }
        float f2 = this.a;
        if (f2 < 0.0f) {
            this.a = f2 + 20.0f;
        } else {
            this.a = f2 - 20.0f;
        }
        this.c.getHandler().sendEmptyMessage(1000);
    }
}
