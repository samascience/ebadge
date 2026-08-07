package defpackage;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class t63 extends o63 {
    protected final MapperConfig c;
    protected final ConcurrentHashMap d;
    protected final Map e;
    protected final boolean f;

    protected t63(MapperConfig mapperConfig, JavaType javaType, ConcurrentHashMap concurrentHashMap, HashMap map) {
        super(javaType, mapperConfig.getTypeFactory());
        this.c = mapperConfig;
        this.d = concurrentHashMap;
        this.e = map;
        this.f = mapperConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES);
    }

    protected static String g(Class cls) {
        String name = cls.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf < 0 ? name : name.substring(iLastIndexOf + 1);
    }

    public static t63 i(MapperConfig mapperConfig, JavaType javaType, Collection collection, boolean z, boolean z2) {
        HashMap map;
        ConcurrentHashMap concurrentHashMap;
        if (z == z2) {
            throw new IllegalArgumentException();
        }
        if (z) {
            concurrentHashMap = new ConcurrentHashMap();
            map = null;
        } else {
            map = new HashMap();
            concurrentHashMap = new ConcurrentHashMap(4);
        }
        boolean zIsEnabled = mapperConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES);
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                NamedType namedType = (NamedType) it.next();
                Class<?> type = namedType.getType();
                String name = namedType.hasName() ? namedType.getName() : g(type);
                if (z) {
                    concurrentHashMap.put(type.getName(), name);
                }
                if (z2) {
                    if (zIsEnabled) {
                        name = name.toLowerCase();
                    }
                    JavaType javaType2 = (JavaType) map.get(name);
                    if (javaType2 == null || !type.isAssignableFrom(javaType2.getRawClass())) {
                        map.put(name, mapperConfig.constructType(type));
                    }
                }
            }
        }
        return new t63(mapperConfig, javaType, concurrentHashMap, map);
    }

    @Override // defpackage.n63
    public String a(Object obj) {
        return j(obj.getClass());
    }

    @Override // defpackage.n63
    public String b() {
        TreeSet treeSet = new TreeSet();
        for (Map.Entry entry : this.e.entrySet()) {
            if (((JavaType) entry.getValue()).isConcrete()) {
                treeSet.add(entry.getKey());
            }
        }
        return treeSet.toString();
    }

    @Override // defpackage.n63
    public JavaType d(t60 t60Var, String str) {
        return h(str);
    }

    @Override // defpackage.n63
    public String e(Object obj, Class cls) {
        return obj == null ? j(cls) : a(obj);
    }

    protected JavaType h(String str) {
        if (this.f) {
            str = str.toLowerCase();
        }
        return (JavaType) this.e.get(str);
    }

    protected String j(Class cls) {
        if (cls == null) {
            return null;
        }
        String name = cls.getName();
        String strG = (String) this.d.get(name);
        if (strG == null) {
            Class<?> rawClass = this.a.constructType(cls).getRawClass();
            if (this.c.isAnnotationProcessingEnabled()) {
                strG = this.c.getAnnotationIntrospector().findTypeName(this.c.introspectClassAnnotations(rawClass).t());
            }
            if (strG == null) {
                strG = g(rawClass);
            }
            this.d.put(name, strG);
        }
        return strG;
    }

    public String toString() {
        return String.format("[%s; id-to-type=%s]", getClass().getName(), this.e);
    }
}
