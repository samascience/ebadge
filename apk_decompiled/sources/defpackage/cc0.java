package defpackage;

import android.os.StrictMode;
import com.tencent.connect.common.Constants;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class cc0 implements Closeable {
    private final File a;
    private final File b;
    private final File c;
    private final File d;
    private final int e;
    private long f;
    private final int g;
    private Writer i;
    private int k;
    private long h = 0;
    private final LinkedHashMap j = new LinkedHashMap(0, 0.75f, true);
    private long l = 0;
    final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    private final Callable n = new a();

    class a implements Callable {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (cc0.this) {
                try {
                    if (cc0.this.i == null) {
                        return null;
                    }
                    cc0.this.N0();
                    if (cc0.this.F0()) {
                        cc0.this.K0();
                        cc0.this.k = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static final class b implements ThreadFactory {
        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public final class c {
        private final d a;
        private final boolean[] b;
        private boolean c;

        /* synthetic */ c(cc0 cc0Var, d dVar, a aVar) {
            this(dVar);
        }

        public void a() {
            cc0.this.j0(this, false);
        }

        public void b() {
            if (this.c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() {
            cc0.this.j0(this, true);
            this.c = true;
        }

        public File f(int i) {
            File fileK;
            synchronized (cc0.this) {
                try {
                    if (this.a.f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.a.e) {
                        this.b[i] = true;
                    }
                    fileK = this.a.k(i);
                    cc0.this.a.mkdirs();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return fileK;
        }

        private c(d dVar) {
            this.a = dVar;
            this.b = dVar.e ? null : new boolean[cc0.this.g];
        }
    }

    private final class d {
        private final String a;
        private final long[] b;
        File[] c;
        File[] d;
        private boolean e;
        private c f;
        private long g;

        /* synthetic */ d(cc0 cc0Var, String str, a aVar) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length != cc0.this.g) {
                throw m(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        public File j(int i) {
            return this.c[i];
        }

        public File k(int i) {
            return this.d[i];
        }

        public String l() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.a = str;
            this.b = new long[cc0.this.g];
            this.c = new File[cc0.this.g];
            this.d = new File[cc0.this.g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < cc0.this.g; i++) {
                sb.append(i);
                this.c[i] = new File(cc0.this.a, sb.toString());
                sb.append(".tmp");
                this.d[i] = new File(cc0.this.a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    public final class e {
        private final String a;
        private final long b;
        private final long[] c;
        private final File[] d;

        /* synthetic */ e(cc0 cc0Var, String str, long j, File[] fileArr, long[] jArr, a aVar) {
            this(str, j, fileArr, jArr);
        }

        public File a(int i) {
            return this.d[i];
        }

        private e(String str, long j, File[] fileArr, long[] jArr) {
            this.a = str;
            this.b = j;
            this.d = fileArr;
            this.c = jArr;
        }
    }

    private cc0(File file, int i, int i2, long j) {
        this.a = file;
        this.e = i;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.d = new File(file, "journal.bkp");
        this.g = i2;
        this.f = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F0() {
        int i = this.k;
        return i >= 2000 && i >= this.j.size();
    }

    public static cc0 G0(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                M0(file2, file3, false);
            }
        }
        cc0 cc0Var = new cc0(file, i, i2, j);
        if (cc0Var.b.exists()) {
            try {
                cc0Var.I0();
                cc0Var.H0();
                return cc0Var;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                cc0Var.k0();
            }
        }
        file.mkdirs();
        cc0 cc0Var2 = new cc0(file, i, i2, j);
        cc0Var2.K0();
        return cc0Var2;
    }

    private void H0() throws IOException {
        m0(this.c);
        Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int i = 0;
            if (dVar.f == null) {
                while (i < this.g) {
                    this.h += dVar.b[i];
                    i++;
                }
            } else {
                dVar.f = null;
                while (i < this.g) {
                    m0(dVar.j(i));
                    m0(dVar.k(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private void I0() {
        kv2 kv2Var = new kv2(new FileInputStream(this.b), ra3.a);
        try {
            String strY = kv2Var.y();
            String strY2 = kv2Var.y();
            String strY3 = kv2Var.y();
            String strY4 = kv2Var.y();
            String strY5 = kv2Var.y();
            if (!"libcore.io.DiskLruCache".equals(strY) || !"1".equals(strY2) || !Integer.toString(this.e).equals(strY3) || !Integer.toString(this.g).equals(strY4) || !Constants.STR_EMPTY.equals(strY5)) {
                throw new IOException("unexpected journal header: [" + strY + ", " + strY2 + ", " + strY4 + ", " + strY5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    J0(kv2Var.y());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (kv2Var.w()) {
                        K0();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), ra3.a));
                    }
                    ra3.a(kv2Var);
                    return;
                }
            }
        } catch (Throwable th) {
            ra3.a(kv2Var);
            throw th;
        }
    }

    private void J0(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        d dVar = (d) this.j.get(strSubstring);
        a aVar = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, aVar);
            this.j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.e = true;
            dVar.f = null;
            dVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f = new c(this, dVar, aVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void K0() {
        try {
            Writer writer = this.i;
            if (writer != null) {
                g0(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), ra3.a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.j.values()) {
                    if (dVar.f != null) {
                        bufferedWriter.write("DIRTY " + dVar.a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.a + dVar.l() + '\n');
                    }
                }
                g0(bufferedWriter);
                if (this.b.exists()) {
                    M0(this.b, this.d, true);
                }
                M0(this.c, this.b, false);
                this.d.delete();
                this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), ra3.a));
            } catch (Throwable th) {
                g0(bufferedWriter);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static void M0(File file, File file2, boolean z) throws IOException {
        if (z) {
            m0(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        while (this.h > this.f) {
            L0((String) ((Map.Entry) this.j.entrySet().iterator().next()).getKey());
        }
    }

    private void e0() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private static void g0(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j0(c cVar, boolean z) {
        d dVar = cVar.a;
        if (dVar.f != cVar) {
            throw new IllegalStateException();
        }
        if (z && !dVar.e) {
            for (int i = 0; i < this.g; i++) {
                if (!cVar.b[i]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!dVar.k(i).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.g; i2++) {
            File fileK = dVar.k(i2);
            if (!z) {
                m0(fileK);
            } else if (fileK.exists()) {
                File fileJ = dVar.j(i2);
                fileK.renameTo(fileJ);
                long j = dVar.b[i2];
                long length = fileJ.length();
                dVar.b[i2] = length;
                this.h = (this.h - j) + length;
            }
        }
        this.k++;
        dVar.f = null;
        if (dVar.e || z) {
            dVar.e = true;
            this.i.append((CharSequence) "CLEAN");
            this.i.append(' ');
            this.i.append((CharSequence) dVar.a);
            this.i.append((CharSequence) dVar.l());
            this.i.append('\n');
            if (z) {
                long j2 = this.l;
                this.l = 1 + j2;
                dVar.g = j2;
            }
        } else {
            this.j.remove(dVar.a);
            this.i.append((CharSequence) "REMOVE");
            this.i.append(' ');
            this.i.append((CharSequence) dVar.a);
            this.i.append('\n');
        }
        y0(this.i);
        if (this.h > this.f || F0()) {
            this.m.submit(this.n);
        }
    }

    private static void m0(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized c w0(String str, long j) {
        e0();
        d dVar = (d) this.j.get(str);
        a aVar = null;
        if (j != -1 && (dVar == null || dVar.g != j)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, aVar);
            this.j.put(str, dVar);
        } else if (dVar.f != null) {
            return null;
        }
        c cVar = new c(this, dVar, aVar);
        dVar.f = cVar;
        this.i.append((CharSequence) "DIRTY");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        y0(this.i);
        return cVar;
    }

    private static void y0(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public synchronized e A0(String str) {
        e0();
        d dVar = (d) this.j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.e) {
            return null;
        }
        for (File file : dVar.c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.k++;
        this.i.append((CharSequence) "READ");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        if (F0()) {
            this.m.submit(this.n);
        }
        return new e(this, str, dVar.g, dVar.c, dVar.b, null);
    }

    public synchronized boolean L0(String str) {
        try {
            e0();
            d dVar = (d) this.j.get(str);
            if (dVar != null && dVar.f == null) {
                for (int i = 0; i < this.g; i++) {
                    File fileJ = dVar.j(i);
                    if (fileJ.exists() && !fileJ.delete()) {
                        throw new IOException("failed to delete " + fileJ);
                    }
                    this.h -= dVar.b[i];
                    dVar.b[i] = 0;
                }
                this.k++;
                this.i.append((CharSequence) "REMOVE");
                this.i.append(' ');
                this.i.append((CharSequence) str);
                this.i.append('\n');
                this.j.remove(str);
                if (F0()) {
                    this.m.submit(this.n);
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.i == null) {
                return;
            }
            for (d dVar : new ArrayList(this.j.values())) {
                if (dVar.f != null) {
                    dVar.f.a();
                }
            }
            N0();
            g0(this.i);
            this.i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void k0() throws IOException {
        close();
        ra3.b(this.a);
    }

    public c t0(String str) {
        return w0(str, -1L);
    }
}
