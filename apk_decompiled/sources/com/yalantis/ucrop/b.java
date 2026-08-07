package com.yalantis.ucrop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.luck.picture.lib.R$anim;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private final Intent a = new Intent();
    private final Bundle b;

    public static class a {
        private final Bundle a = new Bundle();

        public void A(int i) {
            if (i != 0) {
                this.a.putInt("com.yalantis.ucrop.navBarColor", i);
            }
        }

        public void B(String str) {
            this.a.putString("com.yalantis.ucrop.RenameCropFileName", str);
        }

        public void C(int i) {
            this.a.putInt("com.yalantis.ucrop.activityOrientation", i);
        }

        public void D(boolean z) {
            this.a.putBoolean("com.yalantis.ucrop.rotate", z);
        }

        public void E(boolean z) {
            this.a.putBoolean("com.yalantis.ucrop.scale", z);
        }

        public void F(boolean z) {
            this.a.putBoolean("com.yalantis.ucrop.ShowCropFrame", z);
        }

        public void G(boolean z) {
            this.a.putBoolean("com.yalantis.ucrop.ShowCropGrid", z);
        }

        public void H(int i) {
            this.a.putInt("com.yalantis.ucrop.StatusBarColor", i);
        }

        public void I(int i) {
            this.a.putInt("com.yalantis.ucrop.ToolbarColor", i);
        }

        public void J(String str) {
            this.a.putString("com.yalantis.ucrop.UcropToolbarTitleText", str);
        }

        public void K(int i) {
            this.a.putInt("com.yalantis.ucrop.UcropToolbarWidgetColor", i);
        }

        public void L(float f, float f2) {
            this.a.putFloat("com.yalantis.ucrop.AspectRatioX", f);
            this.a.putFloat("com.yalantis.ucrop.AspectRatioY", f2);
        }

        public void M(int i, int i2) {
            this.a.putInt("com.yalantis.ucrop.MaxSizeX", i);
            this.a.putInt("com.yalantis.ucrop.MaxSizeY", i2);
        }

        public Bundle a() {
            return this.a;
        }

        public void b(boolean z) {
            this.a.putBoolean("com.yalantis.ucrop.isCamera", z);
        }

        public void c(boolean z) {
            this.a.putBoolean(".isMultipleAnimation", z);
        }

        public void d(boolean z) {
            this.a.putBoolean("com.yalantis.ucrop.skip_multiple_crop", z);
        }

        public void e(boolean z) {
            this.a.putBoolean("com.yalantis.ucrop.openWhiteStatusBar", z);
        }

        public void f(boolean z) {
            this.a.putBoolean("com.yalantis.ucrop.isWithVideoImage", z);
        }

        public void g(int i, int i2, int i3) {
            this.a.putIntArray("com.yalantis.ucrop.AllowedGestures", new int[]{i, i2, i3});
        }

        public void h(boolean z) {
            this.a.putBoolean("com.yalantis.ucrop.CircleDimmedLayer", z);
        }

        public void i(int i) {
            if (i > 0) {
                this.a.putInt("com.yalantis.ucrop.CircleStrokeWidth", i);
            }
        }

        public void j(Bitmap.CompressFormat compressFormat) {
            this.a.putString("com.yalantis.ucrop.CompressionFormatName", compressFormat.name());
        }

        public void k(int i) {
            this.a.putInt("com.yalantis.ucrop.CompressionQuality", i);
        }

        public void l(boolean z) {
            this.a.putBoolean("com.yalantis.ucrop.DragSmoothToCenter", z);
        }

        public void m(int i) {
            this.a.putInt("com.yalantis.ucrop.WindowAnimation", i);
        }

        public void n(ArrayList arrayList) {
            this.a.putParcelableArrayList("com.yalantis.ucrop.cuts", arrayList);
        }

        public void o(int i) {
            if (i != 0) {
                this.a.putInt("com.yalantis.ucrop.DimmedLayerBorderColor", i);
            }
        }

        public void p(int i) {
            this.a.putInt("com.yalantis.ucrop.DimmedLayerColor", i);
        }

        public void q(boolean z) {
            this.a.putBoolean("com.yalantis.ucrop.DragCropFrame", z);
        }

        public void r(boolean z) {
            this.a.putBoolean("com.yalantis.ucrop.EditorImage", z);
        }

        public void s(boolean z) {
            this.a.putBoolean("com.yalantis.ucrop.FreeStyleCrop", z);
        }

        public void t(int i) {
            this.a.putInt("com.yalantis.ucrop.FreeStyleCropMode", i);
        }

        public void u(boolean z) {
            this.a.putBoolean("com.yalantis.ucrop.HideBottomControls", z);
        }

        public void v(int i) {
            this.a.putInt("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", i);
        }

        public void w(int i) {
            this.a.putInt("com.yalantis.ucrop.InputImageHeight", i);
        }

        public void x(int i) {
            this.a.putInt("com.yalantis.ucrop.InputImageWidth", i);
        }

        public void y(int i) {
            this.a.putInt("com.yalantis.ucrop.MaxBitmapSize", i);
        }

        public void z(float f) {
            this.a.putFloat("com.yalantis.ucrop.MaxScaleMultiplier", f);
        }
    }

    private b(Uri uri, Uri uri2) {
        Bundle bundle = new Bundle();
        this.b = bundle;
        bundle.putParcelable("com.yalantis.ucrop.InputUri", uri);
        bundle.putParcelable("com.yalantis.ucrop.OutputUri", uri2);
    }

    public static ArrayList c(Intent intent) {
        return intent.getParcelableArrayListExtra("com.yalantis.ucrop.OutputUriList");
    }

    public static Uri d(Intent intent) {
        return (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
    }

    public static b e(Uri uri, Uri uri2) {
        return new b(uri, uri2);
    }

    public Intent a(Context context) {
        this.a.setClass(context, UCropActivity.class);
        this.a.putExtras(this.b);
        return this.a;
    }

    public Intent b(Context context) {
        this.a.setClass(context, PictureMultiCuttingActivity.class);
        this.a.putExtras(this.b);
        return this.a;
    }

    public void f(Activity activity, int i) {
        activity.startActivityForResult(a(activity), i);
    }

    public void g(Activity activity, int i, int i2) {
        activity.startActivityForResult(a(activity), i);
        activity.overridePendingTransition(i2, R$anim.ucrop_anim_fade_in);
    }

    public void h(AppCompatActivity appCompatActivity) {
        i(appCompatActivity, 69);
    }

    public void i(AppCompatActivity appCompatActivity, int i) {
        appCompatActivity.startActivityForResult(a(appCompatActivity), i);
    }

    public void j(Activity activity, int i) {
        if (i != 0) {
            g(activity, 69, i);
        } else {
            f(activity, 69);
        }
    }

    public void k(Activity activity, int i) {
        if (i != 0) {
            m(activity, 609, i);
        } else {
            l(activity, 609);
        }
    }

    public void l(Activity activity, int i) {
        activity.startActivityForResult(b(activity), i);
    }

    public void m(Activity activity, int i, int i2) {
        activity.startActivityForResult(b(activity), i);
        activity.overridePendingTransition(i2, R$anim.ucrop_anim_fade_in);
    }

    public b n(a aVar) {
        this.b.putAll(aVar.a());
        return this;
    }
}
