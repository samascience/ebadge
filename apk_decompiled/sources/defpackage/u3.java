package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class u3 extends t3 {
    private static final SparseIntArray V;
    private final LinearLayout T;
    private long U;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        V = sparseIntArray;
        sparseIntArray.put(R.id.iv_picture_push_back, 1);
        sparseIntArray.put(R.id.picturePushSwipeRefreshLayout, 2);
        sparseIntArray.put(R.id.root, 3);
        sparseIntArray.put(R.id.preview_picture_container, 4);
        sparseIntArray.put(R.id.iv_preview_picture, 5);
        sparseIntArray.put(R.id.iv_sticker_overlay, 6);
        sparseIntArray.put(R.id.iv_border_overlay, 7);
        sparseIntArray.put(R.id.picture_size, 8);
        sparseIntArray.put(R.id.btn_picture_push_upload, 9);
        sparseIntArray.put(R.id.picture_device_remaining_space, 10);
        sparseIntArray.put(R.id.picture_refresh_device_space, 11);
        sparseIntArray.put(R.id.tv_select_picture, 12);
        sparseIntArray.put(R.id.iv_photograph, 13);
        sparseIntArray.put(R.id.iv_select_photos, 14);
        sparseIntArray.put(R.id.allStylesRecycler, 15);
    }

    public u3(w50 w50Var, View view) {
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

    private u3(w50 w50Var, View view, Object[] objArr) {
        super(w50Var, view, 0, (RecyclerView) objArr[15], (AppCompatButton) objArr[9], (ImageView) objArr[7], (ImageView) objArr[13], (ImageView) objArr[1], (ImageView) objArr[5], (ImageView) objArr[14], (ImageView) objArr[6], (TextView) objArr[10], (SwipeRefreshLayout) objArr[2], (AppCompatButton) objArr[11], (TextView) objArr[8], (FrameLayout) objArr[4], (LinearLayout) objArr[3], (TextView) objArr[12]);
        this.U = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.T = linearLayout;
        linearLayout.setTag(null);
        B(view);
        K();
    }
}
