package com.legend.mywatch.sdk.mywatchsdklib.android.event;

import defpackage.ng;
import defpackage.p31;
import defpackage.vh0;
import defpackage.y70;

/* JADX INFO: loaded from: classes3.dex */
public final class AIGlassesOtaStatusEvent extends ng {
    private final OtaStatus a;

    public enum OtaStatus {
        DOWNLOAD_FAILED((byte) 0, "OTA文件下载失败"),
        DOWNLOAD_COMPLETED((byte) 1, "OTA文件下载完成"),
        DOWNLOADING((byte) 2, "OTA文件下载中"),
        VERIFY_FAILED((byte) 3, "OTA校验失败");

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
            public final OtaStatus a(byte b) {
                for (OtaStatus otaStatus : OtaStatus.values()) {
                    if (otaStatus.getValue() == b) {
                        if (otaStatus == null) {
                            return OtaStatus.DOWNLOAD_FAILED;
                        }
                        return otaStatus;
                    }
                }
                otaStatus = null;
                if (otaStatus == null) {
                    return OtaStatus.DOWNLOAD_FAILED;
                }
                return otaStatus;
            }

            private a() {
            }
        }

        OtaStatus(byte b, String str) {
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

    public AIGlassesOtaStatusEvent(OtaStatus otaStatus) {
        p31.f(otaStatus, "status");
        this.a = otaStatus;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AIGlassesOtaStatusEvent) && this.a == ((AIGlassesOtaStatusEvent) obj).a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "AIGlassesOtaStatusEvent(status=" + this.a + ")";
    }

    public AIGlassesOtaStatusEvent(byte b) {
        this(OtaStatus.Companion.a(b));
    }
}
