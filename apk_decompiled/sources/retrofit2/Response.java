package retrofit2;

import defpackage.df2;
import defpackage.eh2;
import defpackage.fh2;
import defpackage.iw0;
import javax.annotation.Nullable;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes4.dex */
public final class Response<T> {

    @Nullable
    private final T body;

    @Nullable
    private final fh2 errorBody;
    private final eh2 rawResponse;

    private Response(eh2 eh2Var, @Nullable T t, @Nullable fh2 fh2Var) {
        this.rawResponse = eh2Var;
        this.body = t;
        this.errorBody = fh2Var;
    }

    public static <T> Response<T> error(int i, fh2 fh2Var) {
        if (i >= 400) {
            return error(fh2Var, new eh2.a().g(i).m("Response.error()").p(Protocol.HTTP_1_1).r(new df2.a().m("http://localhost/").b()).c());
        }
        throw new IllegalArgumentException("code < 400: " + i);
    }

    public static <T> Response<T> success(@Nullable T t) {
        return success(t, new eh2.a().g(200).m("OK").p(Protocol.HTTP_1_1).r(new df2.a().m("http://localhost/").b()).c());
    }

    @Nullable
    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.C();
    }

    @Nullable
    public fh2 errorBody() {
        return this.errorBody;
    }

    public iw0 headers() {
        return this.rawResponse.j0();
    }

    public boolean isSuccessful() {
        return this.rawResponse.k0();
    }

    public String message() {
        return this.rawResponse.m0();
    }

    public eh2 raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(@Nullable T t, iw0 iw0Var) {
        Utils.checkNotNull(iw0Var, "headers == null");
        return success(t, new eh2.a().g(200).m("OK").p(Protocol.HTTP_1_1).k(iw0Var).r(new df2.a().m("http://localhost/").b()).c());
    }

    public static <T> Response<T> error(fh2 fh2Var, eh2 eh2Var) {
        Utils.checkNotNull(fh2Var, "body == null");
        Utils.checkNotNull(eh2Var, "rawResponse == null");
        if (!eh2Var.k0()) {
            return new Response<>(eh2Var, null, fh2Var);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(@Nullable T t, eh2 eh2Var) {
        Utils.checkNotNull(eh2Var, "rawResponse == null");
        if (eh2Var.k0()) {
            return new Response<>(eh2Var, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
