package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.luck.picture.lib.R$attr;
import com.luck.picture.lib.R$string;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import com.yalantis.ucrop.b;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t73 {
    public static b.a a(Context context) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        PictureSelectionConfig pictureSelectionConfigC = PictureSelectionConfig.c();
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        int iB = 0;
        if (pictureCropParameterStyle != null) {
            i4 = pictureCropParameterStyle.e;
            z = pictureCropParameterStyle.a;
            i = pictureCropParameterStyle.b;
            if (i == 0) {
                i = 0;
            }
            i2 = pictureCropParameterStyle.c;
            if (i2 == 0) {
                i2 = 0;
            }
            i3 = pictureCropParameterStyle.d;
            if (i3 != 0) {
                iB = i3;
            }
        } else {
            boolean zA = pictureSelectionConfigC.M0;
            if (!zA) {
                zA = cb.a(context, R$attr.picture_statusFontColor);
            }
            z = zA;
            int iB2 = pictureSelectionConfigC.R0;
            if (iB2 == 0) {
                iB2 = cb.b(context, R$attr.picture_crop_toolbar_bg);
            }
            i = iB2;
            int iB3 = pictureSelectionConfigC.S0;
            if (iB3 == 0) {
                iB3 = cb.b(context, R$attr.picture_crop_status_color);
            }
            i2 = iB3;
            i3 = pictureSelectionConfigC.T0;
            if (i3 != 0) {
                i4 = 0;
                iB = i3;
            } else {
                iB = cb.b(context, R$attr.picture_crop_title_color);
                i4 = 0;
            }
        }
        b.a aVar = pictureSelectionConfigC.H0;
        if (aVar == null) {
            aVar = new b.a();
            aVar.h(pictureSelectionConfigC.r0);
            aVar.p(pictureSelectionConfigC.s0);
            aVar.F(pictureSelectionConfigC.w0);
            aVar.G(pictureSelectionConfigC.x0);
            aVar.u(pictureSelectionConfigC.y0);
            aVar.k(pictureSelectionConfigC.G);
            aVar.s(pictureSelectionConfigC.p0);
            aVar.L(pictureSelectionConfigC.N, pictureSelectionConfigC.O);
            int i6 = pictureSelectionConfigC.P;
            if (i6 > 0 && (i5 = pictureSelectionConfigC.Q) > 0) {
                aVar.M(i6, i5);
            }
        }
        aVar.e(z);
        aVar.I(i);
        aVar.H(i2);
        aVar.K(iB);
        aVar.B(pictureSelectionConfigC.n);
        aVar.C(pictureSelectionConfigC.p);
        aVar.b(pictureSelectionConfigC.b);
        aVar.f(pictureSelectionConfigC.G0);
        aVar.c(pictureSelectionConfigC.W);
        aVar.A(i4);
        aVar.o(pictureSelectionConfigC.t0);
        aVar.i(pictureSelectionConfigC.u0);
        aVar.q(pictureSelectionConfigC.E0);
        aVar.E(pictureSelectionConfigC.A0);
        aVar.D(pictureSelectionConfigC.z0);
        aVar.t(pictureSelectionConfigC.v0);
        aVar.l(pictureSelectionConfigC.q0);
        aVar.d(pictureSelectionConfigC.X);
        aVar.m(PictureSelectionConfig.v1.f);
        if (!TextUtils.isEmpty(pictureSelectionConfigC.m1)) {
            aVar.j(Bitmap.CompressFormat.valueOf(pictureSelectionConfigC.m1));
        }
        return aVar;
    }

    public static void b(Activity activity, String str, String str2, int i, int i2) {
        String str3;
        if (wc0.a()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            p33.b(activity.getApplicationContext(), activity.getString(R$string.picture_not_crop_data));
            return;
        }
        PictureSelectionConfig pictureSelectionConfigC = PictureSelectionConfig.c();
        boolean zL = a22.l(str);
        String strReplace = str2.replace("image/", FileUtils.FILE_EXTENSION_SEPARATOR);
        String strK = s12.k(activity.getApplicationContext());
        if (TextUtils.isEmpty(pictureSelectionConfigC.n)) {
            str3 = y60.d("IMG_CROP_") + strReplace;
        } else {
            str3 = pictureSelectionConfigC.n;
        }
        File file = new File(strK, str3);
        Uri uriFromFile = (zL || a22.h(str)) ? Uri.parse(str) : Uri.fromFile(new File(str));
        b.a aVarA = a(activity);
        aVarA.x(i);
        aVarA.w(i2);
        b.e(uriFromFile, Uri.fromFile(file)).n(aVarA).j(activity, PictureSelectionConfig.v1.e);
    }

    public static void c(Activity activity, ArrayList arrayList) {
        if (wc0.a()) {
            return;
        }
        if (arrayList == null || arrayList.size() == 0) {
            p33.b(activity.getApplicationContext(), activity.getString(R$string.picture_not_crop_data));
            return;
        }
        PictureSelectionConfig pictureSelectionConfigC = PictureSelectionConfig.c();
        b.a aVarA = a(activity);
        aVarA.n(arrayList);
        int size = arrayList.size();
        int i = 0;
        if (pictureSelectionConfigC.a == a22.s() && pictureSelectionConfigC.G0) {
            if (a22.n(size > 0 ? ((LocalMedia) arrayList.get(0)).n() : Constants.STR_EMPTY)) {
                for (int i2 = 0; i2 < size; i2++) {
                    LocalMedia localMedia = (LocalMedia) arrayList.get(i2);
                    if (localMedia != null && a22.m(localMedia.n())) {
                        i = i2;
                        break;
                    }
                }
            }
        }
        if (i < size) {
            LocalMedia localMedia2 = (LocalMedia) arrayList.get(i);
            aVarA.x(localMedia2.u());
            aVarA.w(localMedia2.l());
            Uri uriFromFile = (a22.l(localMedia2.q()) || a22.h(localMedia2.q())) ? Uri.parse(localMedia2.q()) : Uri.fromFile(new File(localMedia2.q()));
            String strReplace = localMedia2.n().replace("image/", FileUtils.FILE_EXTENSION_SEPARATOR);
            b.e(uriFromFile, Uri.fromFile(new File(s12.k(activity), TextUtils.isEmpty(pictureSelectionConfigC.n) ? y60.d("IMG_CROP_") + strReplace : (pictureSelectionConfigC.b || size == 1) ? pictureSelectionConfigC.n : sv2.c(pictureSelectionConfigC.n)))).n(aVarA).k(activity, PictureSelectionConfig.v1.e);
        }
    }

    public static void d(Activity activity, String str, String str2, int i, int i2) {
        String str3;
        if (wc0.a()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            p33.b(activity.getApplicationContext(), activity.getString(R$string.picture_not_crop_data));
            return;
        }
        PictureSelectionConfig pictureSelectionConfigC = PictureSelectionConfig.c();
        boolean zL = a22.l(str);
        String strReplace = str2.replace("image/", FileUtils.FILE_EXTENSION_SEPARATOR);
        String strK = s12.k(activity.getApplicationContext());
        if (TextUtils.isEmpty(pictureSelectionConfigC.n)) {
            str3 = y60.d("IMG_CROP_") + strReplace;
        } else {
            str3 = pictureSelectionConfigC.n;
        }
        File file = new File(strK, str3);
        Uri uriFromFile = (zL || a22.h(str)) ? Uri.parse(str) : Uri.fromFile(new File(str));
        b.a aVarA = a(activity);
        aVarA.x(i);
        aVarA.w(i2);
        aVarA.u(false);
        aVarA.r(true);
        aVarA.J(activity.getString(R$string.picture_editor));
        b.e(uriFromFile, Uri.fromFile(file)).n(aVarA).j(activity, PictureSelectionConfig.v1.e);
    }
}
