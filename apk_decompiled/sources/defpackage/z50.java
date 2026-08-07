package defpackage;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class z50 {
    protected final ObjectReader[] a;
    protected final MatchStrength b;
    protected final MatchStrength c;
    protected final int d;

    protected static class a extends m21.a {
        public a(InputStream inputStream, byte[] bArr) {
            super(inputStream, bArr);
        }

        public b d(ObjectReader objectReader, MatchStrength matchStrength) {
            InputStream inputStream = this.a;
            byte[] bArr = this.b;
            int i = this.c;
            return new b(inputStream, bArr, i, this.d - i, objectReader, matchStrength);
        }

        public a(byte[] bArr, int i, int i2) {
            super(bArr, i, i2);
        }
    }

    public static class b {
        protected final InputStream a;
        protected final byte[] b;
        protected final int c;
        protected final int d;
        protected final ObjectReader e;
        protected final MatchStrength f;

        protected b(InputStream inputStream, byte[] bArr, int i, int i2, ObjectReader objectReader, MatchStrength matchStrength) {
            this.a = inputStream;
            this.b = bArr;
            this.c = i;
            this.d = i2;
            this.e = objectReader;
            this.f = matchStrength;
        }

        public JsonParser a() {
            ObjectReader objectReader = this.e;
            if (objectReader == null) {
                return null;
            }
            JsonFactory factory = objectReader.getFactory();
            return this.a == null ? factory.createParser(this.b, this.c, this.d) : factory.createParser(b());
        }

        public InputStream b() {
            return this.a == null ? new ByteArrayInputStream(this.b, this.c, this.d) : new wi1(null, this.a, this.b, this.c, this.d);
        }

        public ObjectReader c() {
            return this.e;
        }

        public boolean d() {
            return this.e != null;
        }
    }

    public z50(ObjectReader... objectReaderArr) {
        this(objectReaderArr, MatchStrength.SOLID_MATCH, MatchStrength.WEAK_MATCH, 64);
    }

    private b a(a aVar) throws IOException {
        ObjectReader objectReader = null;
        MatchStrength matchStrength = null;
        for (ObjectReader objectReader2 : this.a) {
            aVar.c();
            MatchStrength matchStrengthHasFormat = objectReader2.getFactory().hasFormat(aVar);
            if (matchStrengthHasFormat != null && matchStrengthHasFormat.ordinal() >= this.c.ordinal() && (objectReader == null || matchStrength.ordinal() < matchStrengthHasFormat.ordinal())) {
                if (matchStrengthHasFormat.ordinal() >= this.b.ordinal()) {
                    objectReader = objectReader2;
                    matchStrength = matchStrengthHasFormat;
                    break;
                }
                objectReader = objectReader2;
                matchStrength = matchStrengthHasFormat;
            }
        }
        return aVar.d(objectReader, matchStrength);
    }

    public b b(InputStream inputStream) {
        return a(new a(inputStream, new byte[this.d]));
    }

    public b c(byte[] bArr, int i, int i2) {
        return a(new a(bArr, i, i2));
    }

    public z50 d(DeserializationConfig deserializationConfig) {
        int length = this.a.length;
        ObjectReader[] objectReaderArr = new ObjectReader[length];
        for (int i = 0; i < length; i++) {
            objectReaderArr[i] = this.a[i].with(deserializationConfig);
        }
        return new z50(objectReaderArr, this.b, this.c, this.d);
    }

    public z50 e(JavaType javaType) {
        int length = this.a.length;
        ObjectReader[] objectReaderArr = new ObjectReader[length];
        for (int i = 0; i < length; i++) {
            objectReaderArr[i] = this.a[i].forType(javaType);
        }
        return new z50(objectReaderArr, this.b, this.c, this.d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        ObjectReader[] objectReaderArr = this.a;
        int length = objectReaderArr.length;
        if (length > 0) {
            sb.append(objectReaderArr[0].getFactory().getFormatName());
            for (int i = 1; i < length; i++) {
                sb.append(", ");
                sb.append(this.a[i].getFactory().getFormatName());
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private z50(ObjectReader[] objectReaderArr, MatchStrength matchStrength, MatchStrength matchStrength2, int i) {
        this.a = objectReaderArr;
        this.b = matchStrength;
        this.c = matchStrength2;
        this.d = i;
    }
}
