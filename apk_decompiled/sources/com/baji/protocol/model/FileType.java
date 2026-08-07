package com.baji.protocol.model;

import defpackage.vh0;
import defpackage.y70;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes.dex */
public enum FileType {
    IMAGE((byte) 1),
    VIDEO((byte) 2),
    ANIMATION((byte) 3),
    MULTI_FILE((byte) -1);

    private final byte value;
    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(y70 y70Var) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0017  */
        /* JADX WARN: Code duplicated, block: B:14:? A[RETURN, SYNTHETIC] */
        public final FileType fromValue(byte b) {
            for (FileType fileType : FileType.values()) {
                if (fileType.getValue() == b) {
                    if (fileType == null) {
                        return FileType.IMAGE;
                    }
                    return fileType;
                }
            }
            fileType = null;
            if (fileType == null) {
                return FileType.IMAGE;
            }
            return fileType;
        }

        private Companion() {
        }
    }

    FileType(byte b) {
        this.value = b;
    }

    public static vh0 getEntries() {
        return $ENTRIES;
    }

    public final byte getValue() {
        return this.value;
    }
}
