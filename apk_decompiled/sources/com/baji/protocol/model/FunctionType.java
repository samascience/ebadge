package com.baji.protocol.model;

import defpackage.vh0;
import defpackage.y70;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes.dex */
public enum FunctionType {
    BACKGROUND((byte) 1),
    STICKER((byte) 2),
    FONT((byte) 3),
    PREVIEW((byte) 4);

    private final byte value;
    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(y70 y70Var) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0017  */
        /* JADX WARN: Code duplicated, block: B:14:? A[RETURN, SYNTHETIC] */
        public final FunctionType fromValue(byte b) {
            for (FunctionType functionType : FunctionType.values()) {
                if (functionType.getValue() == b) {
                    if (functionType == null) {
                        return FunctionType.BACKGROUND;
                    }
                    return functionType;
                }
            }
            functionType = null;
            if (functionType == null) {
                return FunctionType.BACKGROUND;
            }
            return functionType;
        }

        private Companion() {
        }
    }

    FunctionType(byte b) {
        this.value = b;
    }

    public static vh0 getEntries() {
        return $ENTRIES;
    }

    public final byte getValue() {
        return this.value;
    }
}
