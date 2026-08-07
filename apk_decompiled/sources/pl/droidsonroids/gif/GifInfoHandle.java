package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.view.Surface;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
final class GifInfoHandle {
    private volatile long a;

    static {
        g.b();
    }

    GifInfoHandle() {
    }

    private static native void bindSurface(long j, Surface surface, long[] jArr);

    static native int createTempNativeFileDescriptor() throws GifIOException;

    static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z) throws GifIOException;

    private static native void free(long j);

    private static native long getAllocationByteCount(long j);

    private static native int getCurrentFrameIndex(long j);

    private static native int getCurrentLoop(long j);

    private static native int getCurrentPosition(long j);

    private static native int getDuration(long j);

    private static native int getHeight(long j);

    private static native int getLoopCount(long j);

    private static native long getMetadataByteCount(long j);

    private static native int getNativeErrorCode(long j);

    private static native int getNumberOfFrames(long j);

    private static native long[] getSavedState(long j);

    private static native int getWidth(long j);

    private static native boolean isOpaque(long j);

    private static int k(FileDescriptor fileDescriptor, boolean z) throws ErrnoException {
        try {
            int iCreateTempNativeFileDescriptor = createTempNativeFileDescriptor();
            Os.dup2(fileDescriptor, iCreateTempNativeFileDescriptor);
            return iCreateTempNativeFileDescriptor;
        } finally {
            if (z) {
                Os.close(fileDescriptor);
            }
        }
    }

    static native long openByteArray(byte[] bArr) throws GifIOException;

    static native long openDirectByteBuffer(ByteBuffer byteBuffer) throws GifIOException;

    static native long openFile(String str) throws GifIOException;

    static native long openNativeFileDescriptor(int i, long j) throws GifIOException;

    static native long openStream(InputStream inputStream) throws GifIOException;

    private static native void postUnbindSurface(long j);

    private static long q(FileDescriptor fileDescriptor, long j, boolean z) throws GifIOException {
        int iK;
        if (Build.VERSION.SDK_INT > 27) {
            try {
                iK = k(fileDescriptor, z);
            } catch (Exception e) {
                throw new GifIOException(GifError.OPEN_FAILED.errorCode, e.getMessage());
            }
        } else {
            iK = extractNativeFileDescriptor(fileDescriptor, z);
        }
        return openNativeFileDescriptor(iK, j);
    }

    static GifInfoHandle r(ContentResolver contentResolver, Uri uri) throws IOException {
        if ("file".equals(uri.getScheme())) {
            return new GifInfoHandle(uri.getPath());
        }
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            return new GifInfoHandle(assetFileDescriptorOpenAssetFileDescriptor);
        }
        throw new IOException("Could not open AssetFileDescriptor for " + uri);
    }

    private static native long renderFrame(long j, Bitmap bitmap);

    private static native boolean reset(long j);

    private static native long restoreRemainder(long j);

    private static native int restoreSavedState(long j, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j);

    private static native void seekToTime(long j, int i, Bitmap bitmap);

    private static native void setLoopCount(long j, char c);

    private static native void setOptions(long j, char c, boolean z);

    private static native void setSpeedFactor(long j, float f);

    void A(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("Loop count of range <0, 65535>");
        }
        synchronized (this) {
            setLoopCount(this.a, (char) i);
        }
    }

    void B(char c, boolean z) {
        setOptions(this.a, c, z);
    }

    void C(float f) {
        if (f <= 0.0f || Float.isNaN(f)) {
            throw new IllegalArgumentException("Speed factor is not positive");
        }
        if (f < 4.656613E-10f) {
            f = 4.656613E-10f;
        }
        synchronized (this) {
            setSpeedFactor(this.a, f);
        }
    }

    void a(Surface surface, long[] jArr) {
        bindSurface(this.a, surface, jArr);
    }

    synchronized long b() {
        return getAllocationByteCount(this.a);
    }

    synchronized int c() {
        return getCurrentFrameIndex(this.a);
    }

    synchronized int d() {
        return getCurrentLoop(this.a);
    }

    synchronized int e() {
        return getCurrentPosition(this.a);
    }

    synchronized int f() {
        return getDuration(this.a);
    }

    protected void finalize() throws Throwable {
        try {
            t();
        } finally {
            super.finalize();
        }
    }

    synchronized int g() {
        return getHeight(this.a);
    }

    synchronized int h() {
        return getLoopCount(this.a);
    }

    synchronized long i() {
        return getMetadataByteCount(this.a);
    }

    synchronized int j() {
        return getNativeErrorCode(this.a);
    }

    synchronized int l() {
        return getNumberOfFrames(this.a);
    }

    synchronized long[] m() {
        return getSavedState(this.a);
    }

    synchronized int n() {
        return getWidth(this.a);
    }

    synchronized boolean o() {
        return isOpaque(this.a);
    }

    synchronized boolean p() {
        return this.a == 0;
    }

    synchronized void s() {
        postUnbindSurface(this.a);
    }

    synchronized void t() {
        free(this.a);
        this.a = 0L;
    }

    synchronized long u(Bitmap bitmap) {
        return renderFrame(this.a, bitmap);
    }

    synchronized boolean v() {
        return reset(this.a);
    }

    synchronized long w() {
        return restoreRemainder(this.a);
    }

    synchronized int x(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.a, jArr, bitmap);
    }

    synchronized void y() {
        saveRemainder(this.a);
    }

    synchronized void z(int i, Bitmap bitmap) {
        seekToTime(this.a, i, bitmap);
    }

    GifInfoHandle(FileDescriptor fileDescriptor) {
        this.a = q(fileDescriptor, 0L, true);
    }

    GifInfoHandle(byte[] bArr) {
        this.a = openByteArray(bArr);
    }

    GifInfoHandle(ByteBuffer byteBuffer) {
        this.a = openDirectByteBuffer(byteBuffer);
    }

    GifInfoHandle(String str) {
        this.a = openFile(str);
    }

    GifInfoHandle(InputStream inputStream) {
        if (inputStream.markSupported()) {
            this.a = openStream(inputStream);
            return;
        }
        throw new IllegalArgumentException("InputStream does not support marking");
    }

    GifInfoHandle(AssetFileDescriptor assetFileDescriptor) {
        try {
            this.a = q(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), false);
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }
}
