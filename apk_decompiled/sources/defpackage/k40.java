package defpackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class k40 {
    private static final Map e = new HashMap();
    private final File a;
    private final Lock b;
    private final boolean c;
    private FileChannel d;

    public k40(String str, File file, boolean z) {
        File file2 = new File(file, str + ".lck");
        this.a = file2;
        this.b = a(file2.getAbsolutePath());
        this.c = z;
    }

    private static Lock a(String str) {
        Lock reentrantLock;
        Map map = e;
        synchronized (map) {
            try {
                reentrantLock = (Lock) map.get(str);
                if (reentrantLock == null) {
                    reentrantLock = new ReentrantLock();
                    map.put(str, reentrantLock);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return reentrantLock;
    }

    public void b() {
        this.b.lock();
        if (this.c) {
            try {
                FileChannel channel = new FileOutputStream(this.a).getChannel();
                this.d = channel;
                channel.lock();
            } catch (IOException e2) {
                throw new IllegalStateException("Unable to grab copy lock.", e2);
            }
        }
    }

    public void c() {
        FileChannel fileChannel = this.d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.b.unlock();
    }
}
