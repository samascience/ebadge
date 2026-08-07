package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import defpackage.aa3;
import defpackage.ai;
import defpackage.ai1;
import defpackage.ap;
import defpackage.au0;
import defpackage.av2;
import defpackage.bu0;
import defpackage.ca3;
import defpackage.cd0;
import defpackage.cu0;
import defpackage.cz1;
import defpackage.da3;
import defpackage.di;
import defpackage.e43;
import defpackage.ei;
import defpackage.ei1;
import defpackage.ej0;
import defpackage.em0;
import defpackage.ep;
import defpackage.f11;
import defpackage.fi;
import defpackage.gp;
import defpackage.hi;
import defpackage.hp;
import defpackage.hu0;
import defpackage.ip;
import defpackage.j03;
import defpackage.ji1;
import defpackage.jp;
import defpackage.k92;
import defpackage.km0;
import defpackage.kp;
import defpackage.l83;
import defpackage.lx0;
import defpackage.n83;
import defpackage.na3;
import defpackage.nv2;
import defpackage.o83;
import defpackage.of2;
import defpackage.oi;
import defpackage.p60;
import defpackage.pf1;
import defpackage.rg2;
import defpackage.su0;
import defpackage.ug2;
import defpackage.v21;
import defpackage.v9;
import defpackage.wa;
import defpackage.wg2;
import defpackage.z10;
import defpackage.z42;
import defpackage.zg2;
import defpackage.zh1;
import defpackage.zt0;
import defpackage.zu2;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements ComponentCallbacks2 {
    private static volatile a l;
    private static volatile boolean m;
    private final h a;
    private final oi b;
    private final ji1 c;
    private final c d;
    private final Registry e;
    private final v9 f;
    private final com.bumptech.glide.manager.h g;
    private final z10 h;
    private final InterfaceC0057a j;
    private final List i = new ArrayList();
    private MemoryCategory k = MemoryCategory.NORMAL;

    /* JADX INFO: renamed from: com.bumptech.glide.a$a, reason: collision with other inner class name */
    public interface InterfaceC0057a {
        of2 a();
    }

    a(Context context, h hVar, ji1 ji1Var, oi oiVar, v9 v9Var, com.bumptech.glide.manager.h hVar2, z10 z10Var, int i, InterfaceC0057a interfaceC0057a, Map map, List list, d dVar) {
        ug2 epVar;
        ug2 dVar2;
        Registry registry;
        this.a = hVar;
        this.b = oiVar;
        this.f = v9Var;
        this.c = ji1Var;
        this.g = hVar2;
        this.h = z10Var;
        this.j = interfaceC0057a;
        Resources resources = context.getResources();
        Registry registry2 = new Registry();
        this.e = registry2;
        registry2.o(new DefaultImageHeaderParser());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 27) {
            registry2.o(new ej0());
        }
        List listG = registry2.g();
        jp jpVar = new jp(context, listG, oiVar, v9Var);
        ug2 ug2VarH = VideoDecoder.h(oiVar);
        com.bumptech.glide.load.resource.bitmap.a aVar = new com.bumptech.glide.load.resource.bitmap.a(registry2.g(), resources.getDisplayMetrics(), oiVar, v9Var);
        if (!dVar.a(b.C0058b.class) || i2 < 28) {
            epVar = new ep(aVar);
            dVar2 = new com.bumptech.glide.load.resource.bitmap.d(aVar, v9Var);
        } else {
            dVar2 = new v21();
            epVar = new gp();
        }
        wg2 wg2Var = new wg2(context);
        zg2.c cVar = new zg2.c(resources);
        zg2.d dVar3 = new zg2.d(resources);
        zg2.b bVar = new zg2.b(resources);
        zg2.a aVar2 = new zg2.a(resources);
        hi hiVar = new hi(v9Var);
        ai aiVar = new ai();
        bu0 bu0Var = new bu0();
        ContentResolver contentResolver = context.getContentResolver();
        registry2.a(ByteBuffer.class, new hp()).a(InputStream.class, new zu2(v9Var)).e("Bitmap", ByteBuffer.class, Bitmap.class, epVar).e("Bitmap", InputStream.class, Bitmap.class, dVar2);
        if (ParcelFileDescriptorRewinder.c()) {
            registry2.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new cz1(aVar));
        }
        registry2.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, ug2VarH).e("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.c(oiVar)).c(Bitmap.class, Bitmap.class, o83.a.a()).e("Bitmap", Bitmap.class, Bitmap.class, new l83()).b(Bitmap.class, hiVar).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new di(resources, epVar)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new di(resources, dVar2)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new di(resources, ug2VarH)).b(BitmapDrawable.class, new ei(oiVar, hiVar)).e("Gif", InputStream.class, au0.class, new av2(listG, jpVar, v9Var)).e("Gif", ByteBuffer.class, au0.class, jpVar).b(au0.class, new cu0()).c(zt0.class, zt0.class, o83.a.a()).e("Bitmap", zt0.class, Bitmap.class, new hu0(oiVar)).d(Uri.class, Drawable.class, wg2Var).d(Uri.class, Bitmap.class, new rg2(wg2Var, oiVar)).p(new kp.a()).c(File.class, ByteBuffer.class, new ip.b()).c(File.class, InputStream.class, new km0.e()).d(File.class, File.class, new em0()).c(File.class, ParcelFileDescriptor.class, new km0.b()).c(File.class, File.class, o83.a.a()).p(new com.bumptech.glide.load.data.c.a(v9Var));
        if (ParcelFileDescriptorRewinder.c()) {
            registry = registry2;
            registry.p(new ParcelFileDescriptorRewinder.a());
        } else {
            registry = registry2;
        }
        Class cls = Integer.TYPE;
        registry.c(cls, InputStream.class, cVar).c(cls, ParcelFileDescriptor.class, bVar).c(Integer.class, InputStream.class, cVar).c(Integer.class, ParcelFileDescriptor.class, bVar).c(Integer.class, Uri.class, dVar3).c(cls, AssetFileDescriptor.class, aVar2).c(Integer.class, AssetFileDescriptor.class, aVar2).c(cls, Uri.class, dVar3).c(String.class, InputStream.class, new p60.c()).c(Uri.class, InputStream.class, new p60.c()).c(String.class, InputStream.class, new nv2.c()).c(String.class, ParcelFileDescriptor.class, new nv2.b()).c(String.class, AssetFileDescriptor.class, new nv2.a()).c(Uri.class, InputStream.class, new wa.c(context.getAssets())).c(Uri.class, ParcelFileDescriptor.class, new wa.b(context.getAssets())).c(Uri.class, InputStream.class, new ai1.a(context)).c(Uri.class, InputStream.class, new ei1.a(context));
        if (i2 >= 29) {
            registry.c(Uri.class, InputStream.class, new k92.c(context));
            registry.c(Uri.class, ParcelFileDescriptor.class, new k92.b(context));
        }
        registry.c(Uri.class, InputStream.class, new aa3.d(contentResolver)).c(Uri.class, ParcelFileDescriptor.class, new aa3.b(contentResolver)).c(Uri.class, AssetFileDescriptor.class, new aa3.a(contentResolver)).c(Uri.class, InputStream.class, new da3.a()).c(URL.class, InputStream.class, new ca3.a()).c(Uri.class, File.class, new zh1.a(context)).c(su0.class, InputStream.class, new lx0.a()).c(byte[].class, ByteBuffer.class, new ap.a()).c(byte[].class, InputStream.class, new ap.d()).c(Uri.class, Uri.class, o83.a.a()).c(Drawable.class, Drawable.class, o83.a.a()).d(Drawable.class, Drawable.class, new n83()).q(Bitmap.class, BitmapDrawable.class, new fi(resources)).q(Bitmap.class, byte[].class, aiVar).q(Drawable.class, byte[].class, new cd0(oiVar, aiVar, bu0Var)).q(au0.class, byte[].class, bu0Var);
        ug2 ug2VarD = VideoDecoder.d(oiVar);
        registry.d(ByteBuffer.class, Bitmap.class, ug2VarD);
        registry.d(ByteBuffer.class, BitmapDrawable.class, new di(resources, ug2VarD));
        this.d = new c(context, v9Var, registry, new f11(), interfaceC0057a, map, list, hVar, dVar, i);
    }

    private static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (m) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        m = true;
        m(context, generatedAppGlideModule);
        m = false;
    }

    public static a c(Context context) {
        if (l == null) {
            GeneratedAppGlideModule generatedAppGlideModuleD = d(context.getApplicationContext());
            synchronized (a.class) {
                try {
                    if (l == null) {
                        a(context, generatedAppGlideModuleD);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return l;
    }

    private static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e) {
            q(e);
            return null;
        } catch (InstantiationException e2) {
            q(e2);
            return null;
        } catch (NoSuchMethodException e3) {
            q(e3);
            return null;
        } catch (InvocationTargetException e4) {
            q(e4);
            return null;
        }
    }

    private static com.bumptech.glide.manager.h l(Context context) {
        z42.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    private static void m(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new b(), generatedAppGlideModule);
    }

    private static void n(Context context, b bVar, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List listEmptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            listEmptyList = new pf1(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            generatedAppGlideModule.d();
            Iterator it = listEmptyList.iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator it2 = listEmptyList.iterator();
            if (it2.hasNext()) {
                e43.a(it2.next());
                new StringBuilder().append("Discovered GlideModule from manifest: ");
                throw null;
            }
        }
        bVar.b(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        Iterator it3 = listEmptyList.iterator();
        if (it3.hasNext()) {
            e43.a(it3.next());
            throw null;
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, bVar);
        }
        a aVarA = bVar.a(applicationContext);
        Iterator it4 = listEmptyList.iterator();
        if (it4.hasNext()) {
            e43.a(it4.next());
            try {
                Registry registry = aVarA.e;
                throw null;
            } catch (AbstractMethodError unused) {
                new StringBuilder().append("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
                throw null;
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, aVarA, aVarA.e);
        }
        applicationContext.registerComponentCallbacks(aVarA);
        l = aVarA;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static f t(Activity activity) {
        return l(activity).e(activity);
    }

    public static f u(Context context) {
        return l(context).f(context);
    }

    public static f v(FragmentActivity fragmentActivity) {
        return l(fragmentActivity).g(fragmentActivity);
    }

    public void b() {
        na3.a();
        this.c.b();
        this.b.b();
        this.f.b();
    }

    public v9 e() {
        return this.f;
    }

    public oi f() {
        return this.b;
    }

    z10 g() {
        return this.h;
    }

    public Context h() {
        return this.d.getBaseContext();
    }

    c i() {
        return this.d;
    }

    public Registry j() {
        return this.e;
    }

    public com.bumptech.glide.manager.h k() {
        return this.g;
    }

    void o(f fVar) {
        synchronized (this.i) {
            try {
                if (this.i.contains(fVar)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                this.i.add(fVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        r(i);
    }

    boolean p(j03 j03Var) {
        synchronized (this.i) {
            try {
                Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    if (((f) it.next()).y(j03Var)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void r(int i) {
        na3.a();
        synchronized (this.i) {
            try {
                Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    ((f) it.next()).onTrimMemory(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.c.a(i);
        this.b.a(i);
        this.f.a(i);
    }

    void s(f fVar) {
        synchronized (this.i) {
            try {
                if (!this.i.contains(fVar)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.i.remove(fVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
