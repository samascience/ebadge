package defpackage;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class xp3 extends Thread {
    final /* synthetic */ pp3 a;

    xp3(pp3 pp3Var) {
        this.a = pp3Var;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.a.c(new File(fq3.E() + "/baidu/tempdata", "intime.dat"), "https://itsdata.map.baidu.com/long-conn-gps/sdk.php");
    }
}
