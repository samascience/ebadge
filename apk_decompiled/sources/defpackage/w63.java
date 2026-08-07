package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class w63 {
    private static final hd1 b = ld1.k(w63.class);
    private final Map a = new HashMap();

    public synchronized Class a(String str) {
        Class cls = (Class) this.a.get(str);
        if (cls != null) {
            return cls;
        }
        b.warn("There is no class definition corresponding to the " + str + ";ensure that the corresponding class is registered before the list.You can register with ToolBase.registerTool(toolType, TheTool.class)");
        return null;
    }

    public synchronized void b(String str, Class cls) {
        if (!this.a.containsKey(str)) {
            this.a.put(str, cls);
        }
    }
}
