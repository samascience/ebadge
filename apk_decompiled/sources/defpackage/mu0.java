package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.e;
import com.legend.smartwatch.electronicbadge.android.R;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
public class mu0 implements k01 {
    private static mu0 a;

    class a extends o50 {
        final /* synthetic */ dv1 d;
        final /* synthetic */ SubsamplingScaleImageView e;
        final /* synthetic */ ImageView f;

        a(dv1 dv1Var, SubsamplingScaleImageView subsamplingScaleImageView, ImageView imageView) {
            this.d = dv1Var;
            this.e = subsamplingScaleImageView;
            this.f = imageView;
        }

        @Override // defpackage.o50, defpackage.j03
        public void e(Drawable drawable) {
            super.e(drawable);
            dv1 dv1Var = this.d;
            if (dv1Var != null) {
                dv1Var.b();
            }
        }

        @Override // defpackage.o50, defpackage.j03
        public void f(Drawable drawable) {
            super.f(drawable);
            dv1 dv1Var = this.d;
            if (dv1Var != null) {
                dv1Var.a();
            }
        }

        @Override // defpackage.j03
        public void h(Drawable drawable) {
        }

        @Override // defpackage.j03
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, l53 l53Var) {
            dv1 dv1Var = this.d;
            if (dv1Var != null) {
                dv1Var.b();
            }
            boolean zI = gi1.i(bitmap.getWidth(), bitmap.getHeight());
            this.e.setVisibility(zI ? 0 : 8);
            this.f.setVisibility(zI ? 8 : 0);
            if (!zI) {
                this.f.setImageBitmap(bitmap);
                return;
            }
            this.e.setQuickScaleEnabled(true);
            this.e.setZoomEnabled(true);
            this.e.setDoubleTapZoomDuration(100);
            this.e.setMinimumScaleType(2);
            this.e.setDoubleTapZoomDpi(2);
            this.e.E0(com.luck.picture.lib.widget.longimage.a.b(bitmap), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
        }
    }

    class b extends ki {
        final /* synthetic */ Context i;
        final /* synthetic */ ImageView j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ImageView imageView, Context context, ImageView imageView2) {
            super(imageView);
            this.i = context;
            this.j = imageView2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.ki, defpackage.e11
        /* JADX INFO: renamed from: q */
        public void o(Bitmap bitmap) {
            gi2 gi2VarA = hi2.a(this.i.getResources(), bitmap);
            gi2VarA.e(8.0f);
            this.j.setImageDrawable(gi2VarA);
        }
    }

    private mu0() {
    }

    public static mu0 e() {
        if (a == null) {
            synchronized (mu0.class) {
                try {
                    if (a == null) {
                        a = new mu0();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    @Override // defpackage.k01
    public void a(Context context, String str, ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView, dv1 dv1Var) {
        if (o01.a(context)) {
            com.bumptech.glide.a.u(context).j().z0(str).r0(new a(dv1Var, subsamplingScaleImageView, imageView));
        }
    }

    @Override // defpackage.k01
    public void b(Context context, String str, ImageView imageView) {
        if (o01.a(context)) {
            ((e) ((e) ((e) ((e) com.bumptech.glide.a.u(context).j().z0(str).T(Opcodes.GETFIELD, Opcodes.GETFIELD)).c()).c0(0.5f)).U(R.drawable.picture_image_placeholder)).r0(new b(imageView, context, imageView));
        }
    }

    @Override // defpackage.k01
    public void c(Context context, String str, ImageView imageView) {
        if (o01.a(context)) {
            com.bumptech.glide.a.u(context).r(str).u0(imageView);
        }
    }

    @Override // defpackage.k01
    public void d(Context context, String str, ImageView imageView) {
        if (o01.a(context)) {
            ((e) ((e) ((e) com.bumptech.glide.a.u(context).r(str).T(200, 200)).c()).U(R.drawable.picture_image_placeholder)).u0(imageView);
        }
    }
}
