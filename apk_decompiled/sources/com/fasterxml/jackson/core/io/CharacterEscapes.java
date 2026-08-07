package com.fasterxml.jackson.core.io;

import defpackage.ex;
import defpackage.vm2;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class CharacterEscapes implements Serializable {
    public static final int ESCAPE_CUSTOM = -2;
    public static final int ESCAPE_NONE = 0;
    public static final int ESCAPE_STANDARD = -1;

    public static int[] standardAsciiEscapesForJSON() {
        int[] iArrE = ex.e();
        return Arrays.copyOf(iArrE, iArrE.length);
    }

    public abstract int[] getEscapeCodesForAscii();

    public abstract vm2 getEscapeSequence(int i);
}
