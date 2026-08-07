package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class k3 extends j3 {
    private static final SparseIntArray Z;
    private final LinearLayout X;
    private long Y;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        Z = sparseIntArray;
        sparseIntArray.put(R.id.device_top_container, 2);
        sparseIntArray.put(R.id.single_picture_push, 3);
        sparseIntArray.put(R.id.video_push, 4);
        sparseIntArray.put(R.id.simultaneous_translation, 5);
        sparseIntArray.put(R.id.cv_friends_list, 6);
        sparseIntArray.put(R.id.tv_friends_list, 7);
        sparseIntArray.put(R.id.tv_function, 8);
        sparseIntArray.put(R.id.cv_msg_push, 9);
        sparseIntArray.put(R.id.cv_find_device, 10);
        sparseIntArray.put(R.id.cv_common_contacts, 11);
        sparseIntArray.put(R.id.cv_online_upgrade, 12);
        sparseIntArray.put(R.id.cv_device_reset, 13);
        sparseIntArray.put(R.id.cv_protocol_debug, 14);
        sparseIntArray.put(R.id.cv_about, 15);
        sparseIntArray.put(R.id.cv_manual, 16);
        sparseIntArray.put(R.id.cv_remote_photo, 17);
        sparseIntArray.put(R.id.cv_device_manual, 18);
        sparseIntArray.put(R.id.cv_faq_manual, 19);
    }

    public k3(w50 w50Var, View view) {
        this(w50Var, view, ViewDataBinding.s(w50Var, view, 20, null, Z));
    }

    public void K() {
        synchronized (this) {
            this.Y = 1L;
        }
        z();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void h() {
        synchronized (this) {
            this.Y = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean o() {
        synchronized (this) {
            try {
                return this.Y != 0;
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
    private k3(w50 w50Var, View view, Object[] objArr) {
        CardView cardView = (CardView) objArr[15];
        CardView cardView2 = (CardView) objArr[11];
        CardView cardView3 = (CardView) objArr[18];
        CardView cardView4 = (CardView) objArr[13];
        CardView cardView5 = (CardView) objArr[19];
        CardView cardView6 = (CardView) objArr[10];
        CardView cardView7 = (CardView) objArr[6];
        CardView cardView8 = (CardView) objArr[16];
        CardView cardView9 = (CardView) objArr[9];
        CardView cardView10 = (CardView) objArr[12];
        CardView cardView11 = (CardView) objArr[14];
        CardView cardView12 = (CardView) objArr[17];
        Object obj = objArr[2];
        super(w50Var, view, 0, cardView, cardView2, cardView3, cardView4, cardView5, cardView6, cardView7, cardView8, cardView9, cardView10, cardView11, cardView12, obj != null ? v11.bind((View) obj) : null, (ImageView) objArr[5], (ImageView) objArr[3], (LinearLayout) objArr[0], (TextView) objArr[7], (TextView) objArr[8], (ImageView) objArr[4]);
        this.Y = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.X = linearLayout;
        linearLayout.setTag(null);
        this.T.setTag(null);
        B(view);
        K();
    }
}
