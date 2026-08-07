package defpackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.luck.picture.lib.R$id;
import com.luck.picture.lib.R$layout;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.tencent.connect.share.QzonePublish;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class i32 extends androidx.viewpager.widget.a {
    private final a d;
    private final PictureSelectionConfig e;
    private final int f;
    private final int g;
    private final List c = new ArrayList();
    private final SparseArray h = new SparseArray();

    public interface a {
        void d();
    }

    public i32(Context context, PictureSelectionConfig pictureSelectionConfig, a aVar) {
        this.e = pictureSelectionConfig;
        this.d = aVar;
        this.f = ll2.c(context);
        this.g = ll2.b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(LocalMedia localMedia, String str, ViewGroup viewGroup, View view) {
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isExternalPreviewVideo", true);
        bundle.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, str);
        intent.putExtras(bundle);
        b81.b(viewGroup.getContext(), bundle, 166);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(View view, float f, float f2) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(View view) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.d();
        }
    }

    private void y(Uri uri, SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.setQuickScaleEnabled(true);
        subsamplingScaleImageView.setZoomEnabled(true);
        subsamplingScaleImageView.setDoubleTapZoomDuration(100);
        subsamplingScaleImageView.setMinimumScaleType(2);
        subsamplingScaleImageView.setDoubleTapZoomDpi(2);
        subsamplingScaleImageView.E0(com.luck.picture.lib.widget.longimage.a.n(uri), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
    }

    public LocalMedia A(int i) {
        if (B() <= 0 || i >= B()) {
            return null;
        }
        return (LocalMedia) this.c.get(i);
    }

    public int B() {
        return this.c.size();
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        if (this.h.size() > 20) {
            this.h.remove(i);
        }
    }

    @Override // androidx.viewpager.widget.a
    public int d() {
        return this.c.size();
    }

    @Override // androidx.viewpager.widget.a
    public int e(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.a
    public Object h(final ViewGroup viewGroup, int i) {
        final String strC;
        View viewInflate = (View) this.h.get(i);
        if (viewInflate == null) {
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.picture_image_preview, viewGroup, false);
            this.h.put(i, viewInflate);
        }
        PhotoView photoView = (PhotoView) viewInflate.findViewById(R$id.preview_image);
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) viewInflate.findViewById(R$id.longImg);
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.iv_play);
        final LocalMedia localMediaA = A(i);
        if (this.e.n1) {
            float fMin = Math.min(localMediaA.u(), localMediaA.l());
            float fMax = Math.max(localMediaA.l(), localMediaA.u());
            if (fMin > 0.0f && fMax > 0.0f) {
                int iCeil = (int) Math.ceil((fMax * fMin) / fMin);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) photoView.getLayoutParams();
                layoutParams.width = this.f;
                int i2 = this.g;
                if (iCeil < i2) {
                    iCeil += i2;
                }
                layoutParams.height = iCeil;
                layoutParams.gravity = 17;
            }
        }
        String strN = localMediaA.n();
        if (!localMediaA.z() || localMediaA.x()) {
            strC = (localMediaA.x() || (localMediaA.z() && localMediaA.x())) ? localMediaA.c() : localMediaA.q();
        } else {
            strC = localMediaA.i();
        }
        boolean zI = a22.i(strN);
        int i3 = 8;
        imageView.setVisibility(a22.n(strN) ? 0 : 8);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: f32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i32.C(localMediaA, strC, viewGroup, view);
            }
        });
        boolean zJ = gi1.j(localMediaA);
        photoView.setVisibility((!zJ || zI) ? 0 : 8);
        photoView.setOnViewTapListener(new mw1() { // from class: g32
            @Override // defpackage.mw1
            public final void a(View view, float f, float f2) {
                this.a.D(view, f, f2);
            }
        });
        if (zJ && !zI) {
            i3 = 0;
        }
        subsamplingScaleImageView.setVisibility(i3);
        subsamplingScaleImageView.setOnClickListener(new View.OnClickListener() { // from class: h32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.E(view);
            }
        });
        k01 k01Var = PictureSelectionConfig.w1;
        if (k01Var != null) {
            if (zJ) {
                y(a22.h(strC) ? Uri.parse(strC) : Uri.fromFile(new File(strC)), subsamplingScaleImageView);
            } else {
                k01Var.c(viewInflate.getContext(), strC, photoView);
            }
        }
        viewGroup.addView(viewInflate, 0);
        return viewInflate;
    }

    @Override // androidx.viewpager.widget.a
    public boolean i(View view, Object obj) {
        return view == obj;
    }

    public void w(List list) {
        if (list != null) {
            this.c.clear();
            this.c.addAll(list);
        }
    }

    public void x() {
        this.h.clear();
    }

    public List z() {
        return this.c;
    }
}
