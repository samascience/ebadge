package com.baji.protocol.service;

import com.baji.protocol.model.TransferStatus;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes.dex */
public abstract class StatusResult {

    public static final class Failed extends StatusResult {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(String str) {
            super(null);
            p31.f(str, "message");
            this.message = str;
        }

        public static /* synthetic */ Failed copy$default(Failed failed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failed.message;
            }
            return failed.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final Failed copy(String str) {
            p31.f(str, "message");
            return new Failed(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failed) && p31.a(this.message, ((Failed) obj).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Failed(message=" + this.message + ')';
        }
    }

    public static final class Success extends StatusResult {
        private final TransferStatus status;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(TransferStatus transferStatus) {
            super(null);
            p31.f(transferStatus, "status");
            this.status = transferStatus;
        }

        public static /* synthetic */ Success copy$default(Success success, TransferStatus transferStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                transferStatus = success.status;
            }
            return success.copy(transferStatus);
        }

        public final TransferStatus component1() {
            return this.status;
        }

        public final Success copy(TransferStatus transferStatus) {
            p31.f(transferStatus, "status");
            return new Success(transferStatus);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && this.status == ((Success) obj).status;
        }

        public final TransferStatus getStatus() {
            return this.status;
        }

        public int hashCode() {
            return this.status.hashCode();
        }

        public String toString() {
            return "Success(status=" + this.status + ')';
        }
    }

    public static final class Timeout extends StatusResult {
        public static final Timeout INSTANCE = new Timeout();

        private Timeout() {
            super(null);
        }
    }

    public /* synthetic */ StatusResult(y70 y70Var) {
        this();
    }

    private StatusResult() {
    }
}
