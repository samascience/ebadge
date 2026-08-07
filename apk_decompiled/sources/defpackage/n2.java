package defpackage;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class n2 {
    private final Object a;

    static class a extends AccessibilityNodeProvider {
        final n2 a;

        a(n2 n2Var) {
            this.a = n2Var;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            m2 m2VarB = this.a.b(i);
            if (m2VarB == null) {
                return null;
            }
            return m2VarB.P0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List findAccessibilityNodeInfosByText(String str, int i) {
            List listC = this.a.c(str, i);
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listC.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(((m2) listC.get(i2)).P0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            m2 m2VarD = this.a.d(i);
            if (m2VarD == null) {
                return null;
            }
            return m2VarD.P0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.a.f(i, i2, bundle);
        }
    }

    static class b extends a {
        b(n2 n2Var) {
            super(n2Var);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.a.a(i, m2.Q0(accessibilityNodeInfo), str, bundle);
        }
    }

    public n2() {
        this.a = new b(this);
    }

    public void a(int i, m2 m2Var, String str, Bundle bundle) {
    }

    public m2 b(int i) {
        return null;
    }

    public List c(String str, int i) {
        return null;
    }

    public m2 d(int i) {
        return null;
    }

    public Object e() {
        return this.a;
    }

    public boolean f(int i, int i2, Bundle bundle) {
        return false;
    }

    public n2(Object obj) {
        this.a = obj;
    }
}
