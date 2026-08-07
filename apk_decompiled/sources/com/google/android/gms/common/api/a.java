package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import defpackage.a52;
import defpackage.ky;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private final AbstractC0075a a;
    private final g b;
    private final String c;

    /* JADX INFO: renamed from: com.google.android.gms.common.api.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0075a extends e {
        public abstract f c(Context context, Looper looper, ky kyVar, Object obj, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c);
    }

    public interface b {
    }

    public static class c {
    }

    public interface d {

        /* JADX INFO: renamed from: com.google.android.gms.common.api.a$d$a, reason: collision with other inner class name */
        public interface InterfaceC0076a extends d {
        }
    }

    public static abstract class e {
        public List a(Object obj) {
            return Collections.emptyList();
        }

        public int b() {
            return Integer.MAX_VALUE;
        }
    }

    public interface f extends b {
        void disconnect();

        void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean f();

        void g(com.google.android.gms.common.internal.f fVar, Set set);

        String h();

        void i(com.google.android.gms.common.internal.b.c cVar);

        boolean isConnected();

        boolean isConnecting();

        void j(com.google.android.gms.common.internal.b.e eVar);

        boolean k();

        int l();

        Feature[] m();

        Intent n();

        boolean o();

        IBinder p();
    }

    public static final class g extends c {
    }

    public a(String str, AbstractC0075a abstractC0075a, g gVar) {
        a52.h(abstractC0075a, "Cannot construct an Api with a null ClientBuilder");
        a52.h(gVar, "Cannot construct an Api with a null ClientKey");
        this.c = str;
        this.a = abstractC0075a;
        this.b = gVar;
    }

    public final c a() {
        g gVar = this.b;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public final String b() {
        return this.c;
    }

    public final e c() {
        return this.a;
    }

    public final AbstractC0075a d() {
        a52.j(this.a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.a;
    }
}
