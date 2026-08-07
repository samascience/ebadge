package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class z0 {
    protected final Map<Class<? extends y0>, r50> daoConfigMap = new HashMap();
    protected final r60 db;
    protected final int schemaVersion;

    public z0(r60 r60Var, int i) {
        this.db = r60Var;
        this.schemaVersion = i;
    }

    public r60 getDatabase() {
        return this.db;
    }

    public int getSchemaVersion() {
        return this.schemaVersion;
    }

    protected void registerDaoClass(Class<? extends y0> cls) {
        this.daoConfigMap.put(cls, new r50(this.db, cls));
    }
}
