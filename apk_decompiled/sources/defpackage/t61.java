package defpackage;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class t61 extends s61 {
    protected final JsonParser[] e;
    protected final boolean f;
    protected int g;
    protected boolean h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected t61(boolean z, JsonParser[] jsonParserArr) {
        super(jsonParserArr[0]);
        boolean z2 = false;
        this.f = z;
        if (z && this.d.b1()) {
            z2 = true;
        }
        this.h = z2;
        this.e = jsonParserArr;
        this.g = 1;
    }

    public static t61 x1(boolean z, JsonParser jsonParser, JsonParser jsonParser2) {
        boolean z2 = jsonParser instanceof t61;
        if (!z2 && !(jsonParser2 instanceof t61)) {
            return new t61(z, new JsonParser[]{jsonParser, jsonParser2});
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            ((t61) jsonParser).w1(arrayList);
        } else {
            arrayList.add(jsonParser);
        }
        if (jsonParser2 instanceof t61) {
            ((t61) jsonParser2).w1(arrayList);
        } else {
            arrayList.add(jsonParser2);
        }
        return new t61(z, (JsonParser[]) arrayList.toArray(new JsonParser[arrayList.size()]));
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        do {
            this.d.close();
        } while (z1());
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken n1() {
        JsonParser jsonParser = this.d;
        if (jsonParser == null) {
            return null;
        }
        if (this.h) {
            this.h = false;
            return jsonParser.D();
        }
        JsonToken jsonTokenN1 = jsonParser.n1();
        return jsonTokenN1 == null ? y1() : jsonTokenN1;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser v1() {
        if (this.d.D() != JsonToken.START_OBJECT && this.d.D() != JsonToken.START_ARRAY) {
            return this;
        }
        int i = 1;
        while (true) {
            JsonToken jsonTokenN1 = n1();
            if (jsonTokenN1 == null) {
                return this;
            }
            if (jsonTokenN1.isStructStart()) {
                i++;
            } else if (jsonTokenN1.isStructEnd() && (i = i - 1) == 0) {
                return this;
            }
        }
    }

    protected void w1(List list) {
        int length = this.e.length;
        for (int i = this.g - 1; i < length; i++) {
            JsonParser jsonParser = this.e[i];
            if (jsonParser instanceof t61) {
                ((t61) jsonParser).w1(list);
            } else {
                list.add(jsonParser);
            }
        }
    }

    protected JsonToken y1() {
        JsonToken jsonTokenN1;
        do {
            int i = this.g;
            JsonParser[] jsonParserArr = this.e;
            if (i >= jsonParserArr.length) {
                return null;
            }
            this.g = i + 1;
            JsonParser jsonParser = jsonParserArr[i];
            this.d = jsonParser;
            if (this.f && jsonParser.b1()) {
                return this.d.A0();
            }
            jsonTokenN1 = this.d.n1();
        } while (jsonTokenN1 == null);
        return jsonTokenN1;
    }

    protected boolean z1() {
        int i = this.g;
        JsonParser[] jsonParserArr = this.e;
        if (i >= jsonParserArr.length) {
            return false;
        }
        this.g = i + 1;
        this.d = jsonParserArr[i];
        return true;
    }
}
