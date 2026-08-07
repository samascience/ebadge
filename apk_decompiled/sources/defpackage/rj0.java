package defpackage;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class rj0 {
    private final JavaType a;
    private final b[] b;
    private final Map c;
    private final String[] d;
    private final q33[] e;

    public static class a {
        private final JavaType a;
        private final List b = new ArrayList();
        private final Map c = new HashMap();

        protected a(JavaType javaType) {
            this.a = javaType;
        }

        private void a(String str, Integer num) {
            Object obj = this.c.get(str);
            if (obj == null) {
                this.c.put(str, num);
                return;
            }
            if (obj instanceof List) {
                ((List) obj).add(num);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(obj);
            linkedList.add(num);
            this.c.put(str, linkedList);
        }

        public void b(SettableBeanProperty settableBeanProperty, m63 m63Var) {
            Integer numValueOf = Integer.valueOf(this.b.size());
            this.b.add(new b(settableBeanProperty, m63Var));
            a(settableBeanProperty.getName(), numValueOf);
            a(m63Var.getPropertyName(), numValueOf);
        }

        public rj0 c(BeanPropertyMap beanPropertyMap) {
            int size = this.b.size();
            b[] bVarArr = new b[size];
            for (int i = 0; i < size; i++) {
                b bVar = (b) this.b.get(i);
                SettableBeanProperty settableBeanPropertyFind = beanPropertyMap.find(bVar.d());
                if (settableBeanPropertyFind != null) {
                    bVar.g(settableBeanPropertyFind);
                }
                bVarArr[i] = bVar;
            }
            return new rj0(this.a, bVarArr, this.c, null, null);
        }
    }

    private static final class b {
        private final SettableBeanProperty a;
        private final m63 b;
        private final String c;
        private SettableBeanProperty d;

        public b(SettableBeanProperty settableBeanProperty, m63 m63Var) {
            this.a = settableBeanProperty;
            this.b = m63Var;
            this.c = m63Var.getPropertyName();
        }

        public String a() {
            Class defaultImpl = this.b.getDefaultImpl();
            if (defaultImpl == null) {
                return null;
            }
            return this.b.getTypeIdResolver().e(null, defaultImpl);
        }

        public SettableBeanProperty b() {
            return this.a;
        }

        public SettableBeanProperty c() {
            return this.d;
        }

        public String d() {
            return this.c;
        }

        public boolean e() {
            return this.b.hasDefaultImpl();
        }

        public boolean f(String str) {
            return str.equals(this.c);
        }

        public void g(SettableBeanProperty settableBeanProperty) {
            this.d = settableBeanProperty;
        }
    }

    protected rj0(JavaType javaType, b[] bVarArr, Map map, String[] strArr, q33[] q33VarArr) {
        this.a = javaType;
        this.b = bVarArr;
        this.c = map;
        this.d = strArr;
        this.e = q33VarArr;
    }

    private final boolean d(JsonParser jsonParser, DeserializationContext deserializationContext, String str, Object obj, String str2, int i) throws IOException {
        if (!this.b[i].f(str)) {
            return false;
        }
        if (obj == null || this.e[i] == null) {
            this.d[i] = str2;
            return true;
        }
        b(jsonParser, deserializationContext, obj, i, str2);
        this.e[i] = null;
        return true;
    }

    public static a e(JavaType javaType) {
        return new a(javaType);
    }

    protected final Object a(JsonParser jsonParser, DeserializationContext deserializationContext, int i, String str) {
        JsonParser jsonParserP1 = this.e[i].P1(jsonParser);
        if (jsonParserP1.n1() == JsonToken.VALUE_NULL) {
            return null;
        }
        q33 q33VarBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
        q33VarBufferForInputBuffering.p1();
        q33VarBufferForInputBuffering.w1(str);
        q33VarBufferForInputBuffering.R1(jsonParserP1);
        q33VarBufferForInputBuffering.R0();
        JsonParser jsonParserP2 = q33VarBufferForInputBuffering.P1(jsonParser);
        jsonParserP2.n1();
        return this.b[i].b().deserialize(jsonParserP2, deserializationContext);
    }

    protected final void b(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, int i, String str) throws IOException {
        if (str == null) {
            deserializationContext.reportInputMismatch(this.a, "Internal error in external Type Id handling: `null` type id passed", new Object[0]);
        }
        JsonParser jsonParserP1 = this.e[i].P1(jsonParser);
        if (jsonParserP1.n1() == JsonToken.VALUE_NULL) {
            this.b[i].b().set(obj, null);
            return;
        }
        q33 q33VarBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
        q33VarBufferForInputBuffering.p1();
        q33VarBufferForInputBuffering.w1(str);
        q33VarBufferForInputBuffering.R1(jsonParserP1);
        q33VarBufferForInputBuffering.R0();
        JsonParser jsonParserP2 = q33VarBufferForInputBuffering.P1(jsonParser);
        jsonParserP2.n1();
        this.b[i].b().deserializeAndSet(jsonParserP2, deserializationContext, obj);
    }

    protected final Object c(JsonParser jsonParser, DeserializationContext deserializationContext, int i, String str) {
        q33 q33VarBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
        q33VarBufferForInputBuffering.p1();
        q33VarBufferForInputBuffering.w1(str);
        q33VarBufferForInputBuffering.R0();
        JsonParser jsonParserP1 = q33VarBufferForInputBuffering.P1(jsonParser);
        jsonParserP1.n1();
        return this.b[i].b().deserialize(jsonParserP1, deserializationContext);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004b  */
    /* JADX WARN: Code duplicated, block: B:18:0x0052  */
    /* JADX WARN: Code duplicated, block: B:20:0x005a  */
    /* JADX WARN: Code duplicated, block: B:24:0x0089  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c0 A[SYNTHETIC] */
    public Object f(JsonParser jsonParser, DeserializationContext deserializationContext, com.fasterxml.jackson.databind.deser.impl.b bVar, PropertyBasedCreator propertyBasedCreator) throws IOException {
        String strA;
        SettableBeanProperty settableBeanPropertyB;
        SettableBeanProperty settableBeanPropertyC;
        Object obj;
        int length = this.b.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            String str = this.d[i];
            b bVar2 = this.b[i];
            if (str != null) {
                strA = str;
                if (this.e[i] != null) {
                    objArr[i] = a(jsonParser, deserializationContext, i, strA);
                } else {
                    if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY)) {
                        SettableBeanProperty settableBeanPropertyB2 = bVar2.b();
                        deserializationContext.reportPropertyInputMismatch(this.a, settableBeanPropertyB2.getName(), "Missing property '%s' for external type id '%s'", settableBeanPropertyB2.getName(), this.b[i].d());
                    }
                    objArr[i] = c(jsonParser, deserializationContext, i, strA);
                }
                settableBeanPropertyB = bVar2.b();
                if (settableBeanPropertyB.getCreatorIndex() >= 0) {
                    bVar.b(settableBeanPropertyB, objArr[i]);
                    settableBeanPropertyC = bVar2.c();
                    if (settableBeanPropertyC == null && settableBeanPropertyC.getCreatorIndex() >= 0) {
                        if (!settableBeanPropertyC.getType().hasRawClass(String.class)) {
                            obj = strA;
                            q33 q33VarBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
                            q33VarBufferForInputBuffering.w1(strA);
                            Object objDeserialize = settableBeanPropertyC.getValueDeserializer().deserialize(q33VarBufferForInputBuffering.Q1(), deserializationContext);
                            q33VarBufferForInputBuffering.close();
                            obj = objDeserialize;
                        }
                        obj = strA;
                        bVar.b(settableBeanPropertyC, obj);
                    }
                }
            } else {
                q33 q33Var = this.e[i];
                if (q33Var == null || q33Var.T1() == JsonToken.VALUE_NULL) {
                    strA = str;
                } else {
                    if (bVar2.e()) {
                        strA = str;
                        strA = bVar2.a();
                    } else {
                        strA = str;
                        deserializationContext.reportPropertyInputMismatch(this.a, bVar2.b().getName(), "Missing external type id property '%s'", bVar2.d());
                        strA = str;
                    }
                    strA = str;
                    if (this.e[i] != null) {
                        objArr[i] = a(jsonParser, deserializationContext, i, strA);
                    } else {
                        if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY)) {
                            SettableBeanProperty settableBeanPropertyB3 = bVar2.b();
                            deserializationContext.reportPropertyInputMismatch(this.a, settableBeanPropertyB3.getName(), "Missing property '%s' for external type id '%s'", settableBeanPropertyB3.getName(), this.b[i].d());
                        }
                        objArr[i] = c(jsonParser, deserializationContext, i, strA);
                    }
                    settableBeanPropertyB = bVar2.b();
                    if (settableBeanPropertyB.getCreatorIndex() >= 0) {
                        bVar.b(settableBeanPropertyB, objArr[i]);
                        settableBeanPropertyC = bVar2.c();
                        if (settableBeanPropertyC == null) {
                        }
                    }
                }
            }
        }
        Object objA = propertyBasedCreator.a(deserializationContext, bVar);
        for (int i2 = 0; i2 < length; i2++) {
            SettableBeanProperty settableBeanPropertyB4 = this.b[i2].b();
            if (settableBeanPropertyB4.getCreatorIndex() < 0) {
                settableBeanPropertyB4.set(objA, objArr[i2]);
            }
        }
        return objA;
    }

    public Object g(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        int length = this.b.length;
        for (int i = 0; i < length; i++) {
            String strA = this.d[i];
            b bVar = this.b[i];
            if (strA == null) {
                q33 q33Var = this.e[i];
                if (q33Var != null) {
                    if (q33Var.T1().isScalarValue()) {
                        JsonParser jsonParserP1 = q33Var.P1(jsonParser);
                        jsonParserP1.n1();
                        SettableBeanProperty settableBeanPropertyB = bVar.b();
                        Object objDeserializeIfNatural = m63.deserializeIfNatural(jsonParserP1, deserializationContext, settableBeanPropertyB.getType());
                        if (objDeserializeIfNatural != null) {
                            settableBeanPropertyB.set(obj, objDeserializeIfNatural);
                        }
                    }
                    if (bVar.e()) {
                        strA = bVar.a();
                        if (strA == null) {
                            deserializationContext.reportPropertyInputMismatch(this.a, bVar.b().getName(), "Invalid default type id for property '%s': `null` returned by TypeIdResolver", bVar.d());
                        }
                    } else {
                        deserializationContext.reportPropertyInputMismatch(this.a, bVar.b().getName(), "Missing external type id property '%s' (and no 'defaultImpl' specified)", bVar.d());
                    }
                }
            } else if (this.e[i] == null) {
                SettableBeanProperty settableBeanPropertyB2 = bVar.b();
                if (settableBeanPropertyB2.isRequired() || deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY)) {
                    deserializationContext.reportPropertyInputMismatch(obj.getClass(), settableBeanPropertyB2.getName(), "Missing property '%s' for external type id '%s'", settableBeanPropertyB2.getName(), bVar.d());
                }
                return obj;
            }
            b(jsonParser, deserializationContext, obj, i, strA);
        }
        return obj;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a3  */
    public boolean h(JsonParser jsonParser, DeserializationContext deserializationContext, String str, Object obj) throws IOException {
        Object obj2 = this.c.get(str);
        if (obj2 == null) {
            return false;
        }
        if (obj2 instanceof List) {
            Iterator it = ((List) obj2).iterator();
            Integer num = (Integer) it.next();
            if (this.b[num.intValue()].f(str)) {
                String strS0 = jsonParser.S0();
                jsonParser.v1();
                this.d[num.intValue()] = strS0;
                while (it.hasNext()) {
                    this.d[((Integer) it.next()).intValue()] = strS0;
                }
            } else {
                q33 q33VarBufferAsCopyOfValue = deserializationContext.bufferAsCopyOfValue(jsonParser);
                this.e[num.intValue()] = q33VarBufferAsCopyOfValue;
                while (it.hasNext()) {
                    this.e[((Integer) it.next()).intValue()] = q33VarBufferAsCopyOfValue;
                }
            }
            return true;
        }
        int iIntValue = ((Integer) obj2).intValue();
        if (this.b[iIntValue].f(str)) {
            this.d[iIntValue] = jsonParser.a1();
            jsonParser.v1();
            if (obj != null && this.e[iIntValue] != null) {
                String[] strArr = this.d;
                String str2 = strArr[iIntValue];
                strArr[iIntValue] = null;
                b(jsonParser, deserializationContext, obj, iIntValue, str2);
                this.e[iIntValue] = null;
            }
        } else {
            this.e[iIntValue] = deserializationContext.bufferAsCopyOfValue(jsonParser);
            if (obj != null && this.d[iIntValue] != null) {
                String[] strArr2 = this.d;
                String str3 = strArr2[iIntValue];
                strArr2[iIntValue] = null;
                b(jsonParser, deserializationContext, obj, iIntValue, str3);
                this.e[iIntValue] = null;
            }
        }
        return true;
    }

    public boolean i(JsonParser jsonParser, DeserializationContext deserializationContext, String str, Object obj) {
        Object obj2 = this.c.get(str);
        boolean z = false;
        if (obj2 == null) {
            return false;
        }
        String strS0 = jsonParser.S0();
        if (!(obj2 instanceof List)) {
            return d(jsonParser, deserializationContext, str, obj, strS0, ((Integer) obj2).intValue());
        }
        Iterator it = ((List) obj2).iterator();
        while (it.hasNext()) {
            if (d(jsonParser, deserializationContext, str, obj, strS0, ((Integer) it.next()).intValue())) {
                z = true;
            }
        }
        return z;
    }

    public rj0 j() {
        return new rj0(this);
    }

    protected rj0(rj0 rj0Var) {
        this.a = rj0Var.a;
        b[] bVarArr = rj0Var.b;
        this.b = bVarArr;
        this.c = rj0Var.c;
        int length = bVarArr.length;
        this.d = new String[length];
        this.e = new q33[length];
    }
}
