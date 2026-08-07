package defpackage;

import android.app.RemoteInput;

/* JADX INFO: loaded from: classes.dex */
public abstract class ve2 {

    static class a {
        public static RemoteInput a(ve2 ve2Var) {
            throw null;
        }
    }

    static RemoteInput a(ve2 ve2Var) {
        return a.a(ve2Var);
    }

    static RemoteInput[] b(ve2[] ve2VarArr) {
        if (ve2VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[ve2VarArr.length];
        for (int i = 0; i < ve2VarArr.length; i++) {
            ve2 ve2Var = ve2VarArr[i];
            remoteInputArr[i] = a(null);
        }
        return remoteInputArr;
    }
}
