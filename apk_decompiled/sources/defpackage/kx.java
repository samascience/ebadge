package defpackage;

import android.media.AudioRecord;

/* JADX INFO: loaded from: classes3.dex */
public abstract class kx {
    public static int a() {
        int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
        AudioRecord audioRecord = new AudioRecord(0, 44100, 16, 2, minBufferSize * 100);
        short[] sArr = new short[minBufferSize];
        try {
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != 3) {
                audioRecord.stop();
                audioRecord.release();
                return -1;
            }
            if (audioRecord.read(sArr, 0, minBufferSize) <= 0) {
                audioRecord.stop();
                audioRecord.release();
                return -2;
            }
            audioRecord.stop();
            audioRecord.release();
            return 1;
        } catch (Exception unused) {
            audioRecord.release();
            return -2;
        }
    }
}
