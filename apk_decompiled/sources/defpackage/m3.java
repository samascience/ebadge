package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.view.PulseWaveView;
import xfkj.fitpro.view.WaveView;

/* JADX INFO: loaded from: classes4.dex */
public class m3 extends l3 {
    private static final SparseIntArray V;
    private final RelativeLayout T;
    private long U;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        V = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        sparseIntArray.put(R.id.card_simultaneous_translation_languages2, 2);
        sparseIntArray.put(R.id.ts_source_language, 3);
        sparseIntArray.put(R.id.ts_transmission, 4);
        sparseIntArray.put(R.id.ts_target_language, 5);
        sparseIntArray.put(R.id.txtSimultaneousTranslationTips, 6);
        sparseIntArray.put(R.id.rvSimultaneousTranslation, 7);
        sparseIntArray.put(R.id.ll_simultaneous_translation_start, 8);
        sparseIntArray.put(R.id.btnSimultaneousTranslationStart, 9);
        sparseIntArray.put(R.id.rl_sound_wave, 10);
        sparseIntArray.put(R.id.waveView, 11);
        sparseIntArray.put(R.id.tv_ptt_hint, 12);
        sparseIntArray.put(R.id.ts_sound_reception, 13);
        sparseIntArray.put(R.id.ll_recording_dialog, 14);
        sparseIntArray.put(R.id.dialogPulseView, 15);
    }

    public m3(w50 w50Var, View view) {
        this(w50Var, view, ViewDataBinding.s(w50Var, view, 16, null, V));
    }

    public void K() {
        synchronized (this) {
            this.U = 1L;
        }
        z();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void h() {
        synchronized (this) {
            this.U = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean o() {
        synchronized (this) {
            try {
                return this.U != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean t(int i, Object obj, int i2) {
        return false;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private m3(w50 w50Var, View view, Object[] objArr) {
        ImageView imageView = (ImageView) objArr[9];
        CardView cardView = (CardView) objArr[2];
        PulseWaveView pulseWaveView = (PulseWaveView) objArr[15];
        LinearLayout linearLayout = (LinearLayout) objArr[14];
        LinearLayout linearLayout2 = (LinearLayout) objArr[8];
        RelativeLayout relativeLayout = (RelativeLayout) objArr[10];
        RecyclerView recyclerView = (RecyclerView) objArr[7];
        Object obj = objArr[1];
        super(w50Var, view, 0, imageView, cardView, pulseWaveView, linearLayout, linearLayout2, relativeLayout, recyclerView, obj != null ? x11.bind((View) obj) : null, (ImageView) objArr[13], (AppCompatTextView) objArr[3], (AppCompatTextView) objArr[5], (ImageView) objArr[4], (TextView) objArr[12], (TextView) objArr[6], (WaveView) objArr[11]);
        this.U = -1L;
        RelativeLayout relativeLayout2 = (RelativeLayout) objArr[0];
        this.T = relativeLayout2;
        relativeLayout2.setTag(null);
        B(view);
        K();
    }
}
