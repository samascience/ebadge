package defpackage;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class zg2 implements rk1 {
    private final rk1 a;
    private final Resources b;

    public static final class a implements sk1 {
        private final Resources a;

        public a(Resources resources) {
            this.a = resources;
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new zg2(this.a, zl1Var.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements sk1 {
        private final Resources a;

        public b(Resources resources) {
            this.a = resources;
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new zg2(this.a, zl1Var.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements sk1 {
        private final Resources a;

        public c(Resources resources) {
            this.a = resources;
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new zg2(this.a, zl1Var.d(Uri.class, InputStream.class));
        }
    }

    public static class d implements sk1 {
        private final Resources a;

        public d(Resources resources) {
            this.a = resources;
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new zg2(this.a, o83.c());
        }
    }

    public zg2(Resources resources, rk1 rk1Var) {
        this.b = resources;
        this.a = rk1Var;
    }

    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.b.getResourcePackageName(num.intValue()) + JsonPointer.SEPARATOR + this.b.getResourceTypeName(num.intValue()) + JsonPointer.SEPARATOR + this.b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            return null;
        }
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public rk1.a b(Integer num, int i, int i2, rx1 rx1Var) {
        Uri uriD = d(num);
        if (uriD == null) {
            return null;
        }
        return this.a.b(uriD, i, i2, rx1Var);
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean a(Integer num) {
        return true;
    }
}
