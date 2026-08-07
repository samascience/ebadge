package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.json.JsonMapper;
import defpackage.an2;
import defpackage.z63;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class a {
    private static final JsonMapper a;
    private static final ObjectWriter b;
    private static final ObjectWriter c;
    private static final ObjectReader d;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.node.a$a, reason: collision with other inner class name */
    static final class C0070a {
        private Iterator[] a;
        private int b;
        private int c;

        public Iterator a() {
            int i = this.b;
            if (i == 0) {
                return null;
            }
            Iterator[] itArr = this.a;
            int i2 = i - 1;
            this.b = i2;
            return itArr[i2];
        }

        public void b(Iterator it) {
            int i = this.b;
            int i2 = this.c;
            if (i < i2) {
                Iterator[] itArr = this.a;
                this.b = i + 1;
                itArr[i] = it;
                return;
            }
            if (this.a == null) {
                this.c = 10;
                this.a = new Iterator[10];
            } else {
                int iMin = i2 + Math.min(4000, Math.max(20, i2 >> 1));
                this.c = iMin;
                this.a = (Iterator[]) Arrays.copyOf(this.a, iMin);
            }
            Iterator[] itArr2 = this.a;
            int i3 = this.b;
            this.b = i3 + 1;
            itArr2[i3] = it;
        }
    }

    protected static class b extends com.fasterxml.jackson.databind.a.AbstractC0067a {
        protected final BaseJsonNode a;
        protected an2 b;

        public b(BaseJsonNode baseJsonNode) {
            this.a = baseJsonNode;
        }

        protected void a(JsonGenerator jsonGenerator, JsonNode jsonNode) {
            if (jsonNode instanceof ObjectNode) {
                jsonGenerator.u1(this, jsonNode.size());
                b(jsonGenerator, new C0070a(), jsonNode.fields());
            } else if (!(jsonNode instanceof ArrayNode)) {
                jsonNode.serialize(jsonGenerator, this.b);
            } else {
                jsonGenerator.r1(this, jsonNode.size());
                b(jsonGenerator, new C0070a(), jsonNode.elements());
            }
        }

        protected void b(JsonGenerator jsonGenerator, C0070a c0070a, Iterator it) {
            JsonNode jsonNode;
            while (true) {
                if (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof Map.Entry) {
                        Map.Entry entry = (Map.Entry) next;
                        jsonGenerator.V0((String) entry.getKey());
                        jsonNode = (JsonNode) entry.getValue();
                    } else {
                        jsonNode = (JsonNode) next;
                    }
                    if (jsonNode instanceof ObjectNode) {
                        c0070a.b(it);
                        it = jsonNode.fields();
                        jsonGenerator.u1(jsonNode, jsonNode.size());
                    } else if (jsonNode instanceof ArrayNode) {
                        c0070a.b(it);
                        it = jsonNode.elements();
                        jsonGenerator.r1(jsonNode, jsonNode.size());
                    } else {
                        jsonNode.serialize(jsonGenerator, this.b);
                    }
                } else {
                    if (jsonGenerator.g0().i()) {
                        jsonGenerator.R0();
                    } else {
                        jsonGenerator.S0();
                    }
                    it = c0070a.a();
                    if (it == null) {
                        return;
                    }
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.a
        public void serialize(JsonGenerator jsonGenerator, an2 an2Var) {
            this.b = an2Var;
            a(jsonGenerator, this.a);
        }

        @Override // com.fasterxml.jackson.databind.a
        public void serializeWithType(JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) {
            serialize(jsonGenerator, an2Var);
        }
    }

    static {
        JsonMapper jsonMapper = new JsonMapper();
        a = jsonMapper;
        b = jsonMapper.writer();
        c = jsonMapper.writer().withDefaultPrettyPrinter();
        d = jsonMapper.readerFor(JsonNode.class);
    }

    private static com.fasterxml.jackson.databind.a a(BaseJsonNode baseJsonNode) {
        return new b(baseJsonNode);
    }

    public static JsonNode b(byte[] bArr) {
        return (JsonNode) d.readValue(bArr);
    }

    public static String c(BaseJsonNode baseJsonNode) {
        try {
            return c.writeValueAsString(a(baseJsonNode));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String d(BaseJsonNode baseJsonNode) {
        try {
            return b.writeValueAsString(a(baseJsonNode));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] e(Object obj) {
        return a.writeValueAsBytes(obj);
    }
}
