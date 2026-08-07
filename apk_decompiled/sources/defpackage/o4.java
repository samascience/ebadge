package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel;

/* JADX INFO: loaded from: classes4.dex */
public class o4 extends n4 {
    private static final SparseIntArray h0;
    private final LinearLayout f0;
    private long g0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        h0 = sparseIntArray;
        sparseIntArray.put(R.id.iv_video_push_back, 1);
        sparseIntArray.put(R.id.videoPushSwipeRefreshLayout, 2);
        sparseIntArray.put(R.id.preview_video_container, 3);
        sparseIntArray.put(R.id.iv_video_preview, 4);
        sparseIntArray.put(R.id.iv_video_preview_image, 5);
        sparseIntArray.put(R.id.video_crop_size, 6);
        sparseIntArray.put(R.id.btn_picture_video_upload, 7);
        sparseIntArray.put(R.id.device_remaining_space, 8);
        sparseIntArray.put(R.id.refresh_device_space, 9);
        sparseIntArray.put(R.id.rg_video_length, 10);
        sparseIntArray.put(R.id.rb_five_seconds, 11);
        sparseIntArray.put(R.id.rb_ten_seconds, 12);
        sparseIntArray.put(R.id.rb_fifteen_seconds, 13);
        sparseIntArray.put(R.id.rg_upload_quality, 14);
        sparseIntArray.put(R.id.rb_low_quality, 15);
        sparseIntArray.put(R.id.rb_medium_quality, 16);
        sparseIntArray.put(R.id.rb_high_quality, 17);
        sparseIntArray.put(R.id.tv_select_picture, 18);
        sparseIntArray.put(R.id.iv_video, 19);
        sparseIntArray.put(R.id.iv_select_gif, 20);
        sparseIntArray.put(R.id.tv_video_capture_duration, 21);
        sparseIntArray.put(R.id.video_trim_container, 22);
        sparseIntArray.put(R.id.frameRecyclerView, 23);
        sparseIntArray.put(R.id.handleLeft, 24);
        sparseIntArray.put(R.id.handleRight, 25);
        sparseIntArray.put(R.id.selectionOverlay, 26);
    }

    public o4(w50 w50Var, View view) {
        this(w50Var, view, ViewDataBinding.s(w50Var, view, 27, null, h0));
    }

    @Override // defpackage.n4
    public void K(VideoPushViewModel videoPushViewModel) {
        this.e0 = videoPushViewModel;
    }

    public void L() {
        synchronized (this) {
            this.g0 = 2L;
        }
        z();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void h() {
        synchronized (this) {
            this.g0 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean o() {
        synchronized (this) {
            try {
                return this.g0 != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean t(int i, Object obj, int i2) {
        return false;
    }

    private o4(w50 w50Var, View view, Object[] objArr) {
        super(w50Var, view, 0, (AppCompatButton) objArr[7], (TextView) objArr[8], (RecyclerView) objArr[23], (ImageView) objArr[24], (ImageView) objArr[25], (ImageView) objArr[20], (ImageView) objArr[19], (VideoView) objArr[4], (ImageView) objArr[5], (ImageView) objArr[1], (FrameLayout) objArr[3], (RadioButton) objArr[13], (RadioButton) objArr[11], (RadioButton) objArr[17], (RadioButton) objArr[15], (RadioButton) objArr[16], (RadioButton) objArr[12], (AppCompatButton) objArr[9], (RadioGroup) objArr[14], (RadioGroup) objArr[10], (View) objArr[26], (TextView) objArr[18], (TextView) objArr[21], (TextView) objArr[6], (SwipeRefreshLayout) objArr[2], (FrameLayout) objArr[22]);
        this.g0 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f0 = linearLayout;
        linearLayout.setTag(null);
        B(view);
        L();
    }
}
