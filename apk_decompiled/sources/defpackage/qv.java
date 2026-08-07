package defpackage;

import androidx.camera.core.impl.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class qv {

    static final class a implements pv {
        final List a;

        a(List list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Cannot set an empty CaptureStage list.");
            }
            this.a = Collections.unmodifiableList(new ArrayList(list));
        }

        @Override // defpackage.pv
        public List a() {
            return this.a;
        }
    }

    static pv a(l... lVarArr) {
        return new a(Arrays.asList(lVarArr));
    }

    public static pv b() {
        return a(new l.a());
    }
}
