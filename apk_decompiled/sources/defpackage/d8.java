package defpackage;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class d8 {
    public static ApiException a(Status status) {
        return status.J0() ? new ResolvableApiException(status) : new ApiException(status);
    }
}
