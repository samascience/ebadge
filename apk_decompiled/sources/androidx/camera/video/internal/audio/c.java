package androidx.camera.video.internal.audio;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;
import android.os.Build;
import androidx.camera.core.x;
import defpackage.ac;
import defpackage.b52;
import defpackage.kb;
import defpackage.p7;
import defpackage.q7;
import defpackage.s7;
import defpackage.t7;
import defpackage.va0;
import defpackage.zb;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class c implements AudioStream {
    private static final long m = TimeUnit.MILLISECONDS.toNanos(500);
    private AudioRecord a;
    private final kb b;
    private final int f;
    private final int g;
    private AudioStream.a h;
    private Executor i;
    private long j;
    private AudioManager.AudioRecordingCallback k;
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final AtomicReference e = new AtomicReference(null);
    private boolean l = false;

    class a extends AudioManager.AudioRecordingCallback {
        a() {
        }

        @Override // android.media.AudioManager.AudioRecordingCallback
        public void onRecordingConfigChanged(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AudioRecordingConfiguration audioRecordingConfiguration = (AudioRecordingConfiguration) it.next();
                if (q7.a(audioRecordingConfiguration) == c.this.a.getAudioSessionId()) {
                    c.this.m(s7.b(audioRecordingConfiguration));
                    return;
                }
            }
        }
    }

    public c(kb kbVar, Context context) throws AudioStream.AudioStreamException {
        if (!k(kbVar.f(), kbVar.e(), kbVar.b())) {
            throw new UnsupportedOperationException(String.format("The combination of sample rate %d, channel count %d and audio format %d is not supported.", Integer.valueOf(kbVar.f()), Integer.valueOf(kbVar.e()), Integer.valueOf(kbVar.b())));
        }
        this.b = kbVar;
        this.g = kbVar.d();
        int i = i(kbVar.f(), kbVar.e(), kbVar.b());
        b52.i(i > 0);
        int i2 = i * 2;
        this.f = i2;
        AudioRecord audioRecordG = g(i2, kbVar, context);
        this.a = audioRecordG;
        d(audioRecordG);
    }

    private static void d(AudioRecord audioRecord) throws AudioStream.AudioStreamException {
        if (audioRecord.getState() == 1) {
            return;
        }
        audioRecord.release();
        throw new AudioStream.AudioStreamException("Unable to initialize AudioRecord");
    }

    private void e() {
        b52.j(!this.c.get(), "AudioStream has been released.");
    }

    private void f() {
        b52.j(this.d.get(), "AudioStream has not been started.");
    }

    private static AudioRecord g(int i, kb kbVar, Context context) {
        int i2 = Build.VERSION.SDK_INT;
        AudioFormat audioFormatBuild = new AudioFormat.Builder().setSampleRate(kbVar.f()).setChannelMask(ac.b(kbVar.e())).setEncoding(kbVar.b()).build();
        AudioRecord.Builder builderB = p7.b();
        if (i2 >= 31 && context != null) {
            t7.c(builderB, context);
        }
        p7.d(builderB, kbVar.c());
        p7.c(builderB, audioFormatBuild);
        p7.e(builderB, i);
        return p7.a(builderB);
    }

    private long h() {
        long jC;
        if (this.l) {
            jC = -1;
        } else {
            AudioTimestamp audioTimestamp = new AudioTimestamp();
            if (q7.b(this.a, audioTimestamp, 0) == 0) {
                jC = ac.c(this.b.f(), this.j, audioTimestamp);
                if (Math.abs(jC - System.nanoTime()) > m) {
                    this.l = true;
                }
            } else {
                x.k("AudioStreamImpl", "Unable to get audio timestamp");
            }
            jC = -1;
        }
        return jC == -1 ? System.nanoTime() : jC;
    }

    private static int i(int i, int i2, int i3) {
        return AudioRecord.getMinBufferSize(i, ac.a(i2), i3);
    }

    private static boolean j() {
        return va0.a(zb.class) != null;
    }

    public static boolean k(int i, int i2, int i3) {
        return i > 0 && i2 > 0 && i(i, i2, i3) > 0;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void a(AudioStream.a aVar, Executor executor) {
        boolean z = true;
        b52.j(!this.d.get(), "AudioStream can not be started when setCallback.");
        e();
        if (aVar != null && executor == null) {
            z = false;
        }
        b52.b(z, "executor can't be null with non-null callback.");
        this.h = aVar;
        this.i = executor;
        if (Build.VERSION.SDK_INT >= 29) {
            AudioManager.AudioRecordingCallback audioRecordingCallback = this.k;
            if (audioRecordingCallback != null) {
                s7.d(this.a, audioRecordingCallback);
            }
            if (aVar == null) {
                return;
            }
            if (this.k == null) {
                this.k = new a();
            }
            s7.c(this.a, executor, this.k);
        }
    }

    void m(final boolean z) {
        Executor executor = this.i;
        final AudioStream.a aVar = this.h;
        if (executor == null || aVar == null || Objects.equals(this.e.getAndSet(Boolean.valueOf(z)), Boolean.valueOf(z))) {
            return;
        }
        executor.execute(new Runnable() { // from class: yb
            @Override // java.lang.Runnable
            public final void run() {
                aVar.a(z);
            }
        });
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public AudioStream.b read(ByteBuffer byteBuffer) {
        long jH;
        e();
        f();
        int i = this.a.read(byteBuffer, this.f);
        if (i > 0) {
            byteBuffer.limit(i);
            jH = h();
            this.j += ac.g(i, this.g);
        } else {
            jH = 0;
        }
        return AudioStream.b.c(i, jH);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void release() {
        AudioManager.AudioRecordingCallback audioRecordingCallback;
        if (this.c.getAndSet(true)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29 && (audioRecordingCallback = this.k) != null) {
            s7.d(this.a, audioRecordingCallback);
        }
        this.a.release();
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void start() throws AudioStream.AudioStreamException {
        e();
        if (this.d.getAndSet(true)) {
            return;
        }
        if (j()) {
            d(this.a);
        }
        this.a.startRecording();
        boolean z = false;
        if (this.a.getRecordingState() != 3) {
            this.d.set(false);
            throw new AudioStream.AudioStreamException("Unable to start AudioRecord with state: " + this.a.getRecordingState());
        }
        this.j = 0L;
        this.l = false;
        this.e.set(null);
        if (Build.VERSION.SDK_INT >= 29) {
            AudioRecordingConfiguration audioRecordingConfigurationA = s7.a(this.a);
            z = audioRecordingConfigurationA != null && s7.b(audioRecordingConfigurationA);
        }
        m(z);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void stop() {
        e();
        if (this.d.getAndSet(false)) {
            this.a.stop();
            if (this.a.getRecordingState() != 1) {
                x.k("AudioStreamImpl", "Failed to stop AudioRecord with state: " + this.a.getRecordingState());
            }
            if (j()) {
                this.a.release();
                this.a = g(this.f, this.b, null);
            }
        }
    }
}
