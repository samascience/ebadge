package androidx.room;

import android.content.Context;
import android.util.Log;
import defpackage.k40;
import defpackage.ow2;
import defpackage.pw2;
import defpackage.q50;
import defpackage.zm0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes.dex */
class i implements pw2 {
    private final Context a;
    private final String b;
    private final File c;
    private final int d;
    private final pw2 e;
    private a f;
    private boolean g;

    i(Context context, String str, File file, int i, pw2 pw2Var) {
        this.a = context;
        this.b = str;
        this.c = file;
        this.d = i;
        this.e = pw2Var;
    }

    private void n(File file) throws IOException {
        ReadableByteChannel channel;
        if (this.b != null) {
            channel = Channels.newChannel(this.a.getAssets().open(this.b));
        } else {
            if (this.c == null) {
                throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
            }
            channel = new FileInputStream(this.c).getChannel();
        }
        File fileCreateTempFile = File.createTempFile("room-copy-helper", ".tmp", this.a.getCacheDir());
        fileCreateTempFile.deleteOnExit();
        zm0.a(channel, new FileOutputStream(fileCreateTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        if (fileCreateTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + fileCreateTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    private void w() {
        String databaseName = getDatabaseName();
        File databasePath = this.a.getDatabasePath(databaseName);
        a aVar = this.f;
        k40 k40Var = new k40(databaseName, this.a.getFilesDir(), aVar == null || aVar.j);
        try {
            k40Var.b();
            if (!databasePath.exists()) {
                try {
                    n(databasePath);
                    k40Var.c();
                    return;
                } catch (IOException e) {
                    throw new RuntimeException("Unable to copy database file.", e);
                }
            }
            if (this.f == null) {
                k40Var.c();
                return;
            }
            try {
                int iC = q50.c(databasePath);
                int i = this.d;
                if (iC == i) {
                    k40Var.c();
                    return;
                }
                if (this.f.a(iC, i)) {
                    k40Var.c();
                    return;
                }
                if (this.a.deleteDatabase(databaseName)) {
                    try {
                        n(databasePath);
                    } catch (IOException e2) {
                        Log.w("ROOM", "Unable to copy database file.", e2);
                    }
                } else {
                    Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                k40Var.c();
                return;
            } catch (IOException e3) {
                Log.w("ROOM", "Unable to read database version.", e3);
                k40Var.c();
                return;
            }
        } catch (Throwable th) {
            k40Var.c();
            throw th;
        }
        k40Var.c();
        throw th;
    }

    @Override // defpackage.pw2
    public synchronized ow2 U() {
        try {
            if (!this.g) {
                w();
                this.g = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.e.U();
    }

    @Override // defpackage.pw2, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.e.close();
        this.g = false;
    }

    @Override // defpackage.pw2
    public String getDatabaseName() {
        return this.e.getDatabaseName();
    }

    @Override // defpackage.pw2
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.e.setWriteAheadLoggingEnabled(z);
    }

    void u(a aVar) {
        this.f = aVar;
    }
}
