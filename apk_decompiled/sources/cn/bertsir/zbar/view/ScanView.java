package cn.bertsir.zbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import cn.bertsir.zbar.Qr.Symbol;
import cn.bertsir.zbar.R$id;
import cn.bertsir.zbar.R$layout;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ScanView extends FrameLayout {
    private ScanLineView a;
    private FrameLayout b;
    private int c;
    private CornerView d;
    private CornerView e;
    private CornerView f;
    private CornerView g;
    private ArrayList h;
    private int i;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Symbol.cropWidth = ScanView.this.b.getWidth();
            Symbol.cropHeight = ScanView.this.b.getHeight();
        }
    }

    public ScanView(Context context) {
        super(context);
        this.c = 1;
        this.i = 3000;
        c(context);
    }

    private void c(Context context) {
        View viewInflate = View.inflate(context, R$layout.view_scan, this);
        this.d = (CornerView) viewInflate.findViewById(R$id.cnv_left_top);
        this.e = (CornerView) viewInflate.findViewById(R$id.cnv_left_bottom);
        this.f = (CornerView) viewInflate.findViewById(R$id.cnv_right_top);
        this.g = (CornerView) viewInflate.findViewById(R$id.cnv_right_bottom);
        ArrayList arrayList = new ArrayList();
        this.h = arrayList;
        arrayList.add(this.d);
        this.h.add(this.e);
        this.h.add(this.f);
        this.h.add(this.g);
        this.a = (ScanLineView) viewInflate.findViewById(R$id.iv_scan_line);
        this.b = (FrameLayout) viewInflate.findViewById(R$id.fl_scan);
        getViewWidthHeight();
    }

    public int b(int i) {
        return (int) (((double) (i * getContext().getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public void getViewWidthHeight() {
        this.b.post(new a());
    }

    public void setCornerColor(int i) {
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            ((CornerView) this.h.get(i2)).setColor(i);
        }
    }

    public void setCornerWidth(int i) {
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            ((CornerView) this.h.get(i2)).setLineWidth(i);
        }
    }

    public void setLineColor(int i) {
        this.a.setScancolor(i);
    }

    public void setLineSpeed(int i) {
        this.a.setScanAnimatorDuration(i);
    }

    public void setScanLineStyle(int i) {
        this.a.setScanStyle(i);
    }

    public void setType(int i) {
        this.c = i;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        int i2 = this.c;
        if (i2 == 1) {
            layoutParams.width = b(200);
            layoutParams.height = b(200);
        } else if (i2 == 2) {
            layoutParams.width = b(ChartCoordinateportAnimator.FAST_ANIMATION_DURATION);
            layoutParams.height = b(100);
        }
        this.b.setLayoutParams(layoutParams);
    }

    public ScanView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 1;
        this.i = 3000;
        c(context);
    }

    public ScanView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 1;
        this.i = 3000;
        c(context);
    }
}
