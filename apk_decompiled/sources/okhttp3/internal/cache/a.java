package okhttp3.internal.cache;

import defpackage.y70;
import java.io.Closeable;
import java.io.Flushable;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements Closeable, Flushable {
    public static final C0153a a = new C0153a(null);
    public static final String b = "journal";
    public static final String c = "journal.tmp";
    public static final String d = "journal.bkp";
    public static final String e = "libcore.io.DiskLruCache";
    public static final String f = "1";
    public static final long g = -1;
    public static final Regex h = new Regex("[a-z0-9_-]{1,120}");
    public static final String i = "CLEAN";
    public static final String j = "DIRTY";
    public static final String k = "REMOVE";
    public static final String l = "READ";

    /* JADX INFO: renamed from: okhttp3.internal.cache.a$a, reason: collision with other inner class name */
    public static final class C0153a {
        public /* synthetic */ C0153a(y70 y70Var) {
            this();
        }

        private C0153a() {
        }
    }

    public final class b {
    }

    public static final /* synthetic */ void n(a aVar, boolean z) {
        throw null;
    }
}
