package com.baji.protocol.service;

import com.baji.protocol.model.ErrorCode;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes.dex */
public abstract class AckResult {

    public static final class Rejected extends AckResult {
        private final ErrorCode errorCode;
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Rejected(ErrorCode errorCode, String str) {
            super(null);
            p31.f(errorCode, "errorCode");
            p31.f(str, "message");
            this.errorCode = errorCode;
            this.message = str;
        }

        public static /* synthetic */ Rejected copy$default(Rejected rejected, ErrorCode errorCode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                errorCode = rejected.errorCode;
            }
            if ((i & 2) != 0) {
                str = rejected.message;
            }
            return rejected.copy(errorCode, str);
        }

        public final ErrorCode component1() {
            return this.errorCode;
        }

        public final String component2() {
            return this.message;
        }

        public final Rejected copy(ErrorCode errorCode, String str) {
            p31.f(errorCode, "errorCode");
            p31.f(str, "message");
            return new Rejected(errorCode, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Rejected)) {
                return false;
            }
            Rejected rejected = (Rejected) obj;
            return this.errorCode == rejected.errorCode && p31.a(this.message, rejected.message);
        }

        public final ErrorCode getErrorCode() {
            return this.errorCode;
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return (this.errorCode.hashCode() * 31) + this.message.hashCode();
        }

        public String toString() {
            return "Rejected(errorCode=" + this.errorCode + ", message=" + this.message + ')';
        }
    }

    public static final class Success extends AckResult {
        public static final Success INSTANCE = new Success();

        private Success() {
            super(null);
        }
    }

    public static final class Timeout extends AckResult {
        public static final Timeout INSTANCE = new Timeout();

        private Timeout() {
            super(null);
        }
    }

    public /* synthetic */ AckResult(y70 y70Var) {
        this();
    }

    private AckResult() {
    }
}
