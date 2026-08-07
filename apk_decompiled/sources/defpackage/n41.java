package defpackage;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class n41 {

    private static class a implements f40 {
        private final JavaType a;
        private final int b;

        a(int i, JavaType javaType) {
            this.a = javaType;
            this.b = i;
        }

        private void c(int i) {
            if (i == 1) {
                return;
            }
            throw new IllegalArgumentException("Can not deserialize Singleton container from " + i + " entries");
        }

        @Override // defpackage.f40
        public JavaType a(TypeFactory typeFactory) {
            return this.a;
        }

        @Override // defpackage.f40
        public JavaType b(TypeFactory typeFactory) {
            return this.a;
        }

        @Override // defpackage.f40
        public Object convert(Object obj) {
            if (obj == null) {
                return null;
            }
            switch (this.b) {
                case 1:
                    Set set = (Set) obj;
                    c(set.size());
                    return Collections.singleton(set.iterator().next());
                case 2:
                    List list = (List) obj;
                    c(list.size());
                    return Collections.singletonList(list.get(0));
                case 3:
                    Map map = (Map) obj;
                    c(map.size());
                    Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
                    return Collections.singletonMap(entry.getKey(), entry.getValue());
                case 4:
                    return Collections.unmodifiableSet((Set) obj);
                case 5:
                    return Collections.unmodifiableList((List) obj);
                case 6:
                    return Collections.unmodifiableMap((Map) obj);
                case 7:
                    return Collections.synchronizedSet((Set) obj);
                case 8:
                    return Collections.synchronizedCollection((Collection) obj);
                case 9:
                    return Collections.synchronizedList((List) obj);
                case 10:
                    return Collections.synchronizedMap((Map) obj);
                default:
                    return obj;
            }
        }
    }

    private static String a(String str) {
        if (str.startsWith("Singleton")) {
            return str.substring(9);
        }
        return null;
    }

    private static String b(String str) {
        if (str.startsWith("Synchronized")) {
            return str.substring(12);
        }
        return null;
    }

    private static String c(String str) {
        if (str.startsWith("Unmodifiable")) {
            return str.substring(12);
        }
        return null;
    }

    private static String d(String str) {
        if (str.startsWith("java.util.Arrays$")) {
            return str.substring(17);
        }
        return null;
    }

    private static String e(String str) {
        if (str.startsWith("java.util.ImmutableCollections$")) {
            return str.substring(31);
        }
        return null;
    }

    private static String f(String str) {
        if (str.startsWith("java.util.Collections$")) {
            return str.substring(22);
        }
        return null;
    }

    static a g(int i, JavaType javaType, Class cls) {
        return new a(i, javaType.findSuperType(cls));
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008c  */
    public static s51 h(DeserializationContext deserializationContext, JavaType javaType) {
        a aVarG;
        String name = javaType.getRawClass().getName();
        if (!name.startsWith("java.util.")) {
            return null;
        }
        String strF = f(name);
        if (strF == null) {
            String strD = d(name);
            if (strD != null) {
                if (strD.contains("List")) {
                    return new StdDelegatingDeserializer(g(11, javaType, List.class));
                }
                return null;
            }
            String strE = e(name);
            if (strE != null) {
                if (strE.contains("List")) {
                    return new StdDelegatingDeserializer(g(11, javaType, List.class));
                }
                if (strE.contains("Set")) {
                    return new StdDelegatingDeserializer(g(4, javaType, Set.class));
                }
            }
            return null;
        }
        String strC = c(strF);
        if (strC == null) {
            String strA = a(strF);
            if (strA == null) {
                String strB = b(strF);
                if (strB == null) {
                    aVarG = null;
                } else if (strB.endsWith("Set")) {
                    aVarG = g(7, javaType, Set.class);
                } else if (strB.endsWith("List")) {
                    aVarG = g(9, javaType, List.class);
                } else if (strB.endsWith("Collection")) {
                    aVarG = g(8, javaType, Collection.class);
                } else {
                    aVarG = null;
                }
            } else if (strA.endsWith("Set")) {
                aVarG = g(1, javaType, Set.class);
            } else if (strA.endsWith("List")) {
                aVarG = g(2, javaType, List.class);
            } else {
                aVarG = null;
            }
        } else if (strC.endsWith("Set")) {
            aVarG = g(4, javaType, Set.class);
        } else if (strC.endsWith("List")) {
            aVarG = g(5, javaType, List.class);
        } else {
            aVarG = null;
        }
        if (aVarG == null) {
            return null;
        }
        return new StdDelegatingDeserializer(aVarG);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    public static s51 i(DeserializationContext deserializationContext, JavaType javaType) {
        a aVarG;
        String name = javaType.getRawClass().getName();
        String strF = f(name);
        if (strF != null) {
            String strC = c(strF);
            if (strC == null) {
                String strA = a(strF);
                if (strA == null) {
                    String strB = b(strF);
                    if (strB == null || !strB.contains("Map")) {
                        aVarG = null;
                    } else {
                        aVarG = g(10, javaType, Map.class);
                    }
                } else if (strA.contains("Map")) {
                    aVarG = g(3, javaType, Map.class);
                } else {
                    aVarG = null;
                }
            } else if (strC.contains("Map")) {
                aVarG = g(6, javaType, Map.class);
            } else {
                aVarG = null;
            }
        } else {
            String strE = e(name);
            if (strE == null || !strE.contains("Map")) {
                aVarG = null;
            } else {
                aVarG = g(6, javaType, Map.class);
            }
        }
        if (aVarG == null) {
            return null;
        }
        return new StdDelegatingDeserializer(aVarG);
    }
}
