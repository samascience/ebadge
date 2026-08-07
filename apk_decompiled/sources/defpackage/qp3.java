package defpackage;

import android.location.OnNmeaMessageListener;

/* JADX INFO: loaded from: classes.dex */
class qp3 implements OnNmeaMessageListener {
    final /* synthetic */ mp3 a;

    qp3(mp3 mp3Var) {
        this.a = mp3Var;
    }

    @Override // android.location.OnNmeaMessageListener
    public void onNmeaMessage(String str, long j) {
        if (this.a.y != null) {
            this.a.y.sendMessage(this.a.y.obtainMessage(5, str));
        }
    }
}
