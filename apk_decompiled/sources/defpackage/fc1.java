package defpackage;

import android.os.Bundle;
import androidx.loader.content.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class fc1 {

    public interface a {
        void a(b bVar, Object obj);

        void b(b bVar);

        b onCreateLoader(int i, Bundle bundle);
    }

    public static fc1 b(db1 db1Var) {
        return new gc1(db1Var, ((ne3) db1Var).getViewModelStore());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract b c(int i, Bundle bundle, a aVar);

    public abstract void d();
}
