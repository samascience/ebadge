package defpackage;

import android.media.MediaMuxer;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class r7 {
    public static MediaMuxer a(FileDescriptor fileDescriptor, int i) throws IOException {
        return new MediaMuxer(fileDescriptor, i);
    }
}
