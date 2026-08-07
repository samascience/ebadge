package org.slf4j.simple;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes4.dex */
class OutputChoice {
    final OutputChoiceType a;
    final PrintStream b;

    enum OutputChoiceType {
        SYS_OUT,
        CACHED_SYS_OUT,
        SYS_ERR,
        CACHED_SYS_ERR,
        FILE
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[OutputChoiceType.values().length];
            a = iArr;
            try {
                iArr[OutputChoiceType.SYS_OUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[OutputChoiceType.SYS_ERR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[OutputChoiceType.CACHED_SYS_ERR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[OutputChoiceType.CACHED_SYS_OUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[OutputChoiceType.FILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    OutputChoice(OutputChoiceType outputChoiceType) {
        if (outputChoiceType == OutputChoiceType.FILE) {
            throw new IllegalArgumentException();
        }
        this.a = outputChoiceType;
        if (outputChoiceType == OutputChoiceType.CACHED_SYS_OUT) {
            this.b = System.out;
        } else if (outputChoiceType == OutputChoiceType.CACHED_SYS_ERR) {
            this.b = System.err;
        } else {
            this.b = null;
        }
    }

    PrintStream a() {
        int i = a.a[this.a.ordinal()];
        if (i == 1) {
            return System.out;
        }
        if (i == 2) {
            return System.err;
        }
        if (i == 3 || i == 4 || i == 5) {
            return this.b;
        }
        throw new IllegalArgumentException();
    }

    OutputChoice(PrintStream printStream) {
        this.a = OutputChoiceType.FILE;
        this.b = printStream;
    }
}
