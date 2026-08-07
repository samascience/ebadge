package defpackage;

import com.github.mikephil.charting.charts.CombinedChart;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class qz extends o60 {
    protected List g;
    protected WeakReference h;
    protected List i;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CombinedChart.DrawOrder.values().length];
            a = iArr;
            try {
                iArr[CombinedChart.DrawOrder.BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CombinedChart.DrawOrder.BUBBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CombinedChart.DrawOrder.LINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CombinedChart.DrawOrder.CANDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[CombinedChart.DrawOrder.SCATTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public qz(CombinedChart combinedChart, hx hxVar, ue3 ue3Var) {
        super(hxVar, ue3Var);
        this.g = new ArrayList(5);
        this.i = new ArrayList();
        this.h = new WeakReference(combinedChart);
        b();
    }

    @Override // defpackage.o60
    public void a() {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((o60) it.next()).a();
        }
    }

    public void b() {
        this.g.clear();
        CombinedChart combinedChart = (CombinedChart) this.h.get();
        if (combinedChart == null) {
            return;
        }
        for (CombinedChart.DrawOrder drawOrder : combinedChart.getDrawOrder()) {
            int i = a.a[drawOrder.ordinal()];
            if (i == 1) {
                combinedChart.getBarData();
            } else if (i == 2) {
                combinedChart.getBubbleData();
            } else if (i == 3) {
                combinedChart.getLineData();
            } else if (i == 4) {
                combinedChart.getCandleData();
            } else if (i == 5) {
                combinedChart.getScatterData();
            }
        }
    }
}
