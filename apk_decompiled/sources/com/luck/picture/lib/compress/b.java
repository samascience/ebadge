package com.luck.picture.lib.compress;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.tencent.connect.common.Constants;
import defpackage.a22;
import defpackage.dw1;
import defpackage.g10;
import defpackage.ol2;
import defpackage.sv2;
import defpackage.u21;
import defpackage.uu1;
import defpackage.w21;
import defpackage.x5;
import defpackage.y02;
import defpackage.y60;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private String a;
    private final String b;
    private final boolean c;
    private final boolean d;
    private final int e;
    private final uu1 f;
    private final List g;
    private final List h;
    private final List i;
    private int j;
    private final int k;
    private final int l;
    private final boolean m;

    class a extends PictureThreadUtils.d {
        final /* synthetic */ Iterator f;
        final /* synthetic */ Context g;

        a(Iterator it, Context context) {
            this.f = it;
            this.g = context;
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public List d() {
            String absolutePath;
            b.this.j = -1;
            while (true) {
                if (!this.f.hasNext()) {
                    return null;
                }
                try {
                    b.c(b.this);
                    w21 w21Var = (w21) this.f.next();
                    if (w21Var.d().x()) {
                        absolutePath = ((w21Var.d().z() || !new File(w21Var.d().c()).exists()) ? b.this.i(this.g, w21Var) : new File(w21Var.d().c())).getAbsolutePath();
                    } else if (a22.l(w21Var.d().q()) && TextUtils.isEmpty(w21Var.d().i())) {
                        absolutePath = w21Var.d().q();
                    } else {
                        absolutePath = (a22.n(w21Var.d().n()) ? new File(w21Var.c()) : b.this.i(this.g, w21Var)).getAbsolutePath();
                    }
                    if (b.this.i != null && b.this.i.size() > 0) {
                        LocalMedia localMedia = (LocalMedia) b.this.i.get(b.this.j);
                        boolean zL = a22.l(absolutePath);
                        boolean zN = a22.n(localMedia.n());
                        localMedia.M((zL || zN || TextUtils.isEmpty(absolutePath)) ? false : true);
                        if (zL || zN) {
                            absolutePath = null;
                        }
                        localMedia.L(absolutePath);
                        localMedia.H(ol2.a() ? localMedia.c() : null);
                        if (b.this.j == b.this.i.size() - 1) {
                            return b.this.i;
                        }
                        continue;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f.remove();
            }
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(List list) {
            PictureThreadUtils.e(PictureThreadUtils.j());
            if (b.this.f == null) {
                return;
            }
            if (list != null) {
                b.this.f.a(list);
            } else {
                b.this.f.onError(new Throwable("Failed to compress file"));
            }
        }
    }

    /* JADX INFO: renamed from: com.luck.picture.lib.compress.b$b, reason: collision with other inner class name */
    public static class C0100b {
        private final Context a;
        private String b;
        private String c;
        private boolean d;
        private boolean e;
        private int f;
        private boolean g;
        private uu1 i;
        private int m;
        private int h = 100;
        private final List k = new ArrayList();
        private List l = new ArrayList();
        private final List j = new ArrayList();

        /* JADX INFO: renamed from: com.luck.picture.lib.compress.b$b$a */
        class a extends u21 {
            final /* synthetic */ LocalMedia b;

            a(LocalMedia localMedia) {
                this.b = localMedia;
            }

            @Override // defpackage.u21
            public InputStream a() {
                if (a22.h(this.b.q()) && !this.b.z()) {
                    return this.b.E() ? new FileInputStream(this.b.a()) : y02.a(C0100b.this.a, Uri.parse(this.b.q()));
                }
                if (a22.l(this.b.q()) && TextUtils.isEmpty(this.b.i())) {
                    return null;
                }
                return new FileInputStream(this.b.z() ? this.b.i() : this.b.q());
            }

            @Override // defpackage.w21
            public String c() {
                if (this.b.z()) {
                    return this.b.i();
                }
                return this.b.E() ? this.b.a() : this.b.q();
            }

            @Override // defpackage.w21
            public LocalMedia d() {
                return this.b;
            }
        }

        C0100b(Context context) {
            this.a = context;
        }

        static /* synthetic */ dw1 k(C0100b c0100b) {
            c0100b.getClass();
            return null;
        }

        static /* synthetic */ g10 o(C0100b c0100b) {
            c0100b.getClass();
            return null;
        }

        private b p() {
            return new b(this, null);
        }

        private C0100b v(LocalMedia localMedia) {
            this.j.add(new a(localMedia));
            return this;
        }

        public C0100b A(String str) {
            this.c = str;
            return this;
        }

        public C0100b B(String str) {
            this.b = str;
            return this;
        }

        public List q() {
            return p().k(this.a);
        }

        public C0100b r(int i) {
            this.h = i;
            return this;
        }

        public C0100b s(boolean z) {
            this.g = z;
            return this;
        }

        public C0100b t(boolean z) {
            this.e = z;
            return this;
        }

        public void u() {
            p().o(this.a);
        }

        public C0100b w(List list) {
            this.l = list;
            this.m = list.size();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                v((LocalMedia) it.next());
            }
            return this;
        }

        public C0100b x(uu1 uu1Var) {
            this.i = uu1Var;
            return this;
        }

        public C0100b y(int i) {
            this.f = i;
            return this;
        }

        public C0100b z(boolean z) {
            this.d = z;
            return this;
        }
    }

    /* synthetic */ b(C0100b c0100b, a aVar) {
        this(c0100b);
    }

    static /* synthetic */ int c(b bVar) {
        int i = bVar.j;
        bVar.j = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File i(Context context, w21 w21Var) {
        try {
            return j(context, w21Var);
        } finally {
            w21Var.close();
        }
    }

    private File j(Context context, w21 w21Var) {
        String str;
        LocalMedia localMediaD = w21Var.d();
        String strI = localMediaD.z() ? localMediaD.i() : localMediaD.s();
        Checker checker = Checker.SINGLE;
        String strExtSuffix = checker.extSuffix(localMediaD.n());
        File fileM = m(context, w21Var, strExtSuffix);
        if (TextUtils.isEmpty(this.b)) {
            str = Constants.STR_EMPTY;
        } else {
            String strC = (this.d || this.l == 1) ? this.b : sv2.c(this.b);
            str = strC;
            fileM = n(context, strC);
        }
        if (fileM.exists()) {
            return fileM;
        }
        if (strExtSuffix.startsWith(".gif")) {
            if (!ol2.a()) {
                return new File(strI);
            }
            String strI2 = localMediaD.z() ? localMediaD.i() : x5.a(context, localMediaD.m(), w21Var.c(), localMediaD.u(), localMediaD.l(), localMediaD.n(), str);
            if (!TextUtils.isEmpty(strI2)) {
                strI = strI2;
            }
            return new File(strI);
        }
        if (checker.needCompressToLocalMedia(this.e, strI)) {
            return new com.luck.picture.lib.compress.a(context, w21Var, fileM, this.c, this.k, this.m).b();
        }
        if (!ol2.a()) {
            return new File(strI);
        }
        String strI3 = localMediaD.z() ? localMediaD.i() : x5.a(context, localMediaD.m(), w21Var.c(), localMediaD.u(), localMediaD.l(), localMediaD.n(), str);
        if (!TextUtils.isEmpty(strI3)) {
            strI = strI3;
        }
        return new File(strI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List k(Context context) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            w21 w21Var = (w21) it.next();
            if (w21Var.d() != null) {
                LocalMedia localMediaD = w21Var.d();
                if (localMediaD.x()) {
                    String absolutePath = ((localMediaD.z() || !new File(localMediaD.c()).exists()) ? i(context, w21Var) : new File(localMediaD.c())).getAbsolutePath();
                    localMediaD.M(true);
                    localMediaD.L(absolutePath);
                    localMediaD.H(ol2.a() ? absolutePath : null);
                    arrayList.add(localMediaD);
                } else {
                    boolean z = a22.l(localMediaD.q()) && TextUtils.isEmpty(localMediaD.i());
                    boolean zN = a22.n(localMediaD.n());
                    String absolutePath2 = ((z || zN) ? new File(localMediaD.q()) : i(context, w21Var)).getAbsolutePath();
                    boolean z2 = !TextUtils.isEmpty(absolutePath2) && a22.l(absolutePath2);
                    localMediaD.M((zN || z2) ? false : true);
                    if (zN || z2) {
                        absolutePath2 = null;
                    }
                    localMediaD.L(absolutePath2);
                    localMediaD.H(ol2.a() ? localMediaD.c() : null);
                    arrayList.add(localMediaD);
                }
                it.remove();
            }
        }
        return arrayList;
    }

    private static File l(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            if (Log.isLoggable("Luban", 6)) {
                Log.e("Luban", "default disk cache dir is null");
            }
            return null;
        }
        if (externalFilesDir.mkdirs() || (externalFilesDir.exists() && externalFilesDir.isDirectory())) {
            return externalFilesDir;
        }
        return null;
    }

    private File m(Context context, w21 w21Var, String str) {
        String string;
        File fileL;
        if (TextUtils.isEmpty(this.a) && (fileL = l(context)) != null) {
            this.a = fileL.getAbsolutePath();
        }
        try {
            LocalMedia localMediaD = w21Var.d();
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            if (localMediaD.z()) {
                String strD = y60.d("IMG_CMP_");
                sb.append(WatchConstant.FAT_FS_ROOT);
                sb.append(strD);
                if (TextUtils.isEmpty(str)) {
                    str = ".jpg";
                }
                sb.append(str);
                string = sb.toString();
            } else {
                String strA = sv2.a(localMediaD.m(), localMediaD.u(), localMediaD.l());
                sb.append("/IMG_CMP_");
                sb.append(strA);
                if (TextUtils.isEmpty(str)) {
                    str = ".jpg";
                }
                sb.append(str);
                string = sb.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            string = Constants.STR_EMPTY;
        }
        return new File(string);
    }

    private File n(Context context, String str) {
        if (TextUtils.isEmpty(this.a)) {
            File fileL = l(context);
            this.a = fileL != null ? fileL.getAbsolutePath() : Constants.STR_EMPTY;
        }
        return new File(this.a + WatchConstant.FAT_FS_ROOT + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Context context) {
        List list = this.g;
        if (list == null || this.h == null || (list.size() == 0 && this.f != null)) {
            this.f.onError(new NullPointerException("image file cannot be null"));
            return;
        }
        Iterator it = this.g.iterator();
        uu1 uu1Var = this.f;
        if (uu1Var != null) {
            uu1Var.onStart();
        }
        PictureThreadUtils.h(new a(it, context));
    }

    public static C0100b p(Context context) {
        return new C0100b(context);
    }

    private b(C0100b c0100b) {
        this.j = -1;
        this.h = c0100b.k;
        this.i = c0100b.l;
        this.l = c0100b.m;
        this.a = c0100b.b;
        this.b = c0100b.c;
        C0100b.k(c0100b);
        this.g = c0100b.j;
        this.f = c0100b.i;
        this.e = c0100b.h;
        C0100b.o(c0100b);
        this.k = c0100b.f;
        this.m = c0100b.g;
        this.c = c0100b.d;
        this.d = c0100b.e;
    }
}
