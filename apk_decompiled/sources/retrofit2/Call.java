package retrofit2;

import defpackage.df2;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    /* JADX INFO: renamed from: clone */
    Call<T> mo355clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    df2 request();
}
