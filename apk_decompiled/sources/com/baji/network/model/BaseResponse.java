package com.baji.network.model;

import defpackage.p31;
import defpackage.y70;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class BaseResponse<T> implements Serializable {
    private final T data;
    private final CommonErrorResponse error;
    private final boolean success;

    public BaseResponse(T t, boolean z, CommonErrorResponse commonErrorResponse) {
        this.data = t;
        this.success = z;
        this.error = commonErrorResponse;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseResponse copy$default(BaseResponse baseResponse, Object obj, boolean z, CommonErrorResponse commonErrorResponse, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = baseResponse.data;
        }
        if ((i & 2) != 0) {
            z = baseResponse.success;
        }
        if ((i & 4) != 0) {
            commonErrorResponse = baseResponse.error;
        }
        return baseResponse.copy(obj, z, commonErrorResponse);
    }

    public final T component1() {
        return this.data;
    }

    public final boolean component2() {
        return this.success;
    }

    public final CommonErrorResponse component3() {
        return this.error;
    }

    public final BaseResponse<T> copy(T t, boolean z, CommonErrorResponse commonErrorResponse) {
        return new BaseResponse<>(t, z, commonErrorResponse);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseResponse)) {
            return false;
        }
        BaseResponse baseResponse = (BaseResponse) obj;
        return p31.a(this.data, baseResponse.data) && this.success == baseResponse.success && p31.a(this.error, baseResponse.error);
    }

    public final T getData() {
        return this.data;
    }

    public final CommonErrorResponse getError() {
        return this.error;
    }

    public final CommonErrorResponse getErrorOrDefault() {
        CommonErrorResponse commonErrorResponse = this.error;
        return commonErrorResponse == null ? new CommonErrorResponse(0, null, 3, null) : commonErrorResponse;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        T t = this.data;
        int iHashCode = (((t == null ? 0 : t.hashCode()) * 31) + Boolean.hashCode(this.success)) * 31;
        CommonErrorResponse commonErrorResponse = this.error;
        return iHashCode + (commonErrorResponse != null ? commonErrorResponse.hashCode() : 0);
    }

    public final boolean isSuccess() {
        boolean z = this.success;
        if (z && this.data == null) {
            return false;
        }
        return z;
    }

    public String toString() {
        return "BaseResponse{data=" + this.data + ", success=" + this.success + ", error=" + this.error + '}';
    }

    public /* synthetic */ BaseResponse(Object obj, boolean z, CommonErrorResponse commonErrorResponse, int i, y70 y70Var) {
        this(obj, z, (i & 4) != 0 ? null : commonErrorResponse);
    }
}
