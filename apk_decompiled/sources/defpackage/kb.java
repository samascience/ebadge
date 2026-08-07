package defpackage;

import com.tencent.connect.common.Constants;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class kb {
    public static final List a = Collections.unmodifiableList(Arrays.asList(48000, 44100, 22050, 11025, 8000, 4800));

    public static abstract class a {
        a() {
        }

        abstract kb a();

        public final kb b() {
            kb kbVarA = a();
            int iC = kbVarA.c();
            String str = Constants.STR_EMPTY;
            if (iC == -1) {
                str = Constants.STR_EMPTY + " audioSource";
            }
            if (kbVarA.f() <= 0) {
                str = str + " sampleRate";
            }
            if (kbVarA.e() <= 0) {
                str = str + " channelCount";
            }
            if (kbVarA.b() == -1) {
                str = str + " audioFormat";
            }
            if (str.isEmpty()) {
                return kbVarA;
            }
            throw new IllegalArgumentException("Required settings missing or non-positive:" + str);
        }

        public abstract a c(int i);

        public abstract a d(int i);

        public abstract a e(int i);

        public abstract a f(int i);
    }

    kb() {
    }

    public static a a() {
        return new vc.b().d(-1).f(-1).e(-1).c(-1);
    }

    public abstract int b();

    public abstract int c();

    public int d() {
        return ac.f(b(), e());
    }

    public abstract int e();

    public abstract int f();
}
