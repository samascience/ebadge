package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import android.util.Log;
import com.jieli.jl_rcsp.constant.WatchConstant;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class he1 {
    private static final Map a = new HashMap();

    static class a implements me1 {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // defpackage.me1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            he1.a.remove(this.a);
        }
    }

    static class b implements Callable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        b(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public oe1 call() {
            return he1.e(this.a, this.b);
        }
    }

    static class c implements Callable {
        final /* synthetic */ Context a;
        final /* synthetic */ int b;

        c(Context context, int i) {
            this.a = context;
            this.b = i;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public oe1 call() {
            return he1.m(this.a, this.b);
        }
    }

    static class d implements Callable {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ String b;

        d(JSONObject jSONObject, String str) {
            this.a = jSONObject;
            this.b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public oe1 call() {
            return he1.k(this.a, this.b);
        }
    }

    static class e implements Callable {
        final /* synthetic */ JsonReader a;
        final /* synthetic */ String b;

        e(JsonReader jsonReader, String str) {
            this.a = jsonReader;
            this.b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public oe1 call() {
            return he1.i(this.a, this.b);
        }
    }

    static class f implements Callable {
        final /* synthetic */ fe1 a;

        f(fe1 fe1Var) {
            this.a = fe1Var;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public oe1 call() {
            Log.d("Gabe", "call\treturning from cache");
            return new oe1(this.a);
        }
    }

    static class g implements me1 {
        final /* synthetic */ String a;

        g(String str) {
            this.a = str;
        }

        @Override // defpackage.me1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(fe1 fe1Var) {
            if (this.a != null) {
                ge1.b().c(this.a, fe1Var);
            }
            he1.a.remove(this.a);
        }
    }

    private static pe1 b(String str, Callable callable) {
        fe1 fe1VarA = ge1.b().a(str);
        if (fe1VarA != null) {
            return new pe1(new f(fe1VarA));
        }
        Map map = a;
        if (map.containsKey(str)) {
            return (pe1) map.get(str);
        }
        pe1 pe1Var = new pe1(callable);
        pe1Var.h(new g(str));
        pe1Var.g(new a(str));
        map.put(str, pe1Var);
        return pe1Var;
    }

    private static le1 c(fe1 fe1Var, String str) {
        for (le1 le1Var : fe1Var.i().values()) {
            if (le1Var.b().equals(str)) {
                return le1Var;
            }
        }
        return null;
    }

    public static pe1 d(Context context, String str) {
        return b(str, new b(context.getApplicationContext(), str));
    }

    public static oe1 e(Context context, String str) {
        try {
            String str2 = "asset_" + str;
            return str.endsWith(".zip") ? o(new ZipInputStream(context.getAssets().open(str)), str2) : f(context.getAssets().open(str), str2);
        } catch (IOException e2) {
            return new oe1((Throwable) e2);
        }
    }

    public static oe1 f(InputStream inputStream, String str) {
        return g(inputStream, str, true);
    }

    @Deprecated
    public static pe1 fromJson(JSONObject jSONObject, String str) {
        return b(str, new d(jSONObject, str));
    }

    private static oe1 g(InputStream inputStream, String str, boolean z) {
        try {
            return i(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                ya3.c(inputStream);
            }
        }
    }

    public static pe1 h(JsonReader jsonReader, String str) {
        return b(str, new e(jsonReader, str));
    }

    public static oe1 i(JsonReader jsonReader, String str) {
        try {
            fe1 fe1VarA = ie1.a(jsonReader);
            ge1.b().c(str, fe1VarA);
            return new oe1(fe1VarA);
        } catch (Exception e2) {
            return new oe1((Throwable) e2);
        }
    }

    public static oe1 j(String str, String str2) {
        return i(new JsonReader(new StringReader(str)), str2);
    }

    public static oe1 k(JSONObject jSONObject, String str) {
        return j(jSONObject.toString(), str);
    }

    public static pe1 l(Context context, int i) {
        return b(q(i), new c(context.getApplicationContext(), i));
    }

    public static oe1 m(Context context, int i) {
        try {
            return f(context.getResources().openRawResource(i), q(i));
        } catch (Resources.NotFoundException e2) {
            return new oe1((Throwable) e2);
        }
    }

    public static pe1 n(Context context, String str) {
        return wp1.b(context, str);
    }

    public static oe1 o(ZipInputStream zipInputStream, String str) {
        try {
            return p(zipInputStream, str);
        } finally {
            ya3.c(zipInputStream);
        }
    }

    private static oe1 p(ZipInputStream zipInputStream, String str) {
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            fe1 fe1Var = null;
            while (nextEntry != null) {
                if (nextEntry.getName().contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    fe1Var = (fe1) g(zipInputStream, str, false).b();
                } else if (nextEntry.getName().contains(".png")) {
                    String[] strArrSplit = nextEntry.getName().split(WatchConstant.FAT_FS_ROOT);
                    map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (fe1Var == null) {
                return new oe1((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                le1 le1VarC = c(fe1Var, (String) entry.getKey());
                if (le1VarC != null) {
                    le1VarC.d((Bitmap) entry.getValue());
                }
            }
            for (Map.Entry entry2 : fe1Var.i().entrySet()) {
                if (((le1) entry2.getValue()).a() == null) {
                    return new oe1((Throwable) new IllegalStateException("There is no image for " + ((le1) entry2.getValue()).b()));
                }
            }
            ge1.b().c(str, fe1Var);
            return new oe1(fe1Var);
        } catch (IOException e2) {
            return new oe1((Throwable) e2);
        }
    }

    private static String q(int i) {
        return "rawRes_" + i;
    }
}
