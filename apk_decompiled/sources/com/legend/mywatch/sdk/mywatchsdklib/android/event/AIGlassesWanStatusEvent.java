package com.legend.mywatch.sdk.mywatchsdklib.android.event;

import defpackage.ng;
import defpackage.p31;
import defpackage.vh0;
import defpackage.y70;

/* JADX INFO: loaded from: classes3.dex */
public final class AIGlassesWanStatusEvent extends ng {
    private final WanConnectionStatus a;

    public enum WanConnectionStatus {
        NOT_CONNECTED((byte) 0, "未连接"),
        CONNECTED((byte) 1, "已连接"),
        CONNECTION_FAILED((byte) 2, "连接失败"),
        PASSWORD_ERROR((byte) 3, "密码错误");

        private final String description;
        private final byte value;
        private static final /* synthetic */ vh0 $ENTRIES = kotlin.enums.a.a(values());
        public static final a Companion = new a(null);

        public static final class a {
            public /* synthetic */ a(y70 y70Var) {
                this();
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0017  */
            /* JADX WARN: Code duplicated, block: B:14:? A[RETURN, SYNTHETIC] */
            public final WanConnectionStatus a(byte b) {
                for (WanConnectionStatus wanConnectionStatus : WanConnectionStatus.values()) {
                    if (wanConnectionStatus.getValue() == b) {
                        if (wanConnectionStatus == null) {
                            return WanConnectionStatus.NOT_CONNECTED;
                        }
                        return wanConnectionStatus;
                    }
                }
                wanConnectionStatus = null;
                if (wanConnectionStatus == null) {
                    return WanConnectionStatus.NOT_CONNECTED;
                }
                return wanConnectionStatus;
            }

            private a() {
            }
        }

        WanConnectionStatus(byte b, String str) {
            this.value = b;
            this.description = str;
        }

        public static vh0 getEntries() {
            return $ENTRIES;
        }

        public final String getDescription() {
            return this.description;
        }

        public final byte getValue() {
            return this.value;
        }
    }

    public AIGlassesWanStatusEvent(WanConnectionStatus wanConnectionStatus) {
        p31.f(wanConnectionStatus, "status");
        this.a = wanConnectionStatus;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AIGlassesWanStatusEvent) && this.a == ((AIGlassesWanStatusEvent) obj).a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "AIGlassesWanStatusEvent(status=" + this.a + ")";
    }
}
