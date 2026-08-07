package junit.framework;

import defpackage.a41;
import defpackage.ni2;
import defpackage.oi2;
import defpackage.p13;
import defpackage.q13;
import defpackage.r13;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;

/* JADX INFO: loaded from: classes4.dex */
public class JUnit4TestAdapterCache extends HashMap<Description, p13> {
    private static final JUnit4TestAdapterCache fInstance = new JUnit4TestAdapterCache();
    private static final long serialVersionUID = 1;

    class a extends ni2 {
        a(q13 q13Var) {
        }
    }

    public static JUnit4TestAdapterCache getDefault() {
        return fInstance;
    }

    public p13 asTest(Description description) {
        if (description.isSuite()) {
            return createTest(description);
        }
        if (!containsKey(description)) {
            put(description, createTest(description));
        }
        return get(description);
    }

    public List<p13> asTestList(Description description) {
        if (description.isTest()) {
            return Arrays.asList(asTest(description));
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            arrayList.add(asTest(it.next()));
        }
        return arrayList;
    }

    p13 createTest(Description description) {
        if (description.isTest()) {
            return new junit.framework.a(description);
        }
        r13 r13Var = new r13(description.getDisplayName());
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            r13Var.a(asTest(it.next()));
        }
        return r13Var;
    }

    public oi2 getNotifier(q13 q13Var, a41 a41Var) {
        oi2 oi2Var = new oi2();
        oi2Var.a(new a(q13Var));
        return oi2Var;
    }
}
