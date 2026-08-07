package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import defpackage.h71;
import defpackage.s51;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class b implements Iterator, Closeable {
    protected static final b i = new b(null, null, null, null, false, null);
    protected final JavaType a;
    protected final DeserializationContext b;
    protected final s51 c;
    protected final JsonParser d;
    protected final h71 e;
    protected final Object f;
    protected final boolean g;
    protected int h;

    protected b(JavaType javaType, JsonParser jsonParser, DeserializationContext deserializationContext, s51 s51Var, boolean z, Object obj) {
        this.a = javaType;
        this.d = jsonParser;
        this.b = deserializationContext;
        this.c = s51Var;
        this.g = z;
        if (obj == null) {
            this.f = null;
        } else {
            this.f = obj;
        }
        if (jsonParser == null) {
            this.e = null;
            this.h = 0;
            return;
        }
        h71 h71VarP0 = jsonParser.P0();
        if (z && jsonParser.i1()) {
            jsonParser.y();
        } else {
            JsonToken jsonTokenD = jsonParser.D();
            if (jsonTokenD == JsonToken.START_OBJECT || jsonTokenD == JsonToken.START_ARRAY) {
                h71VarP0 = h71VarP0.e();
            }
        }
        this.e = h71VarP0;
        this.h = 2;
    }

    public boolean C() {
        JsonToken jsonTokenN1;
        int i2 = this.h;
        if (i2 == 0) {
            return false;
        }
        if (i2 == 1) {
            w();
        } else if (i2 != 2) {
            return true;
        }
        JsonParser jsonParser = this.d;
        if (jsonParser == null) {
            return false;
        }
        if (jsonParser.D() != null || ((jsonTokenN1 = this.d.n1()) != null && jsonTokenN1 != JsonToken.END_ARRAY)) {
            this.h = 3;
            return true;
        }
        this.h = 0;
        if (this.g) {
            this.d.close();
        }
        return false;
    }

    public Object D() {
        Object objDeserialize;
        int i2 = this.h;
        if (i2 == 0) {
            return y();
        }
        int i3 = 2;
        i3 = 1;
        if ((i2 == i3 || i2 == i3) && !C()) {
            return y();
        }
        try {
            Object obj = this.f;
            if (obj == null) {
                objDeserialize = this.c.deserialize(this.d, this.b);
            } else {
                this.c.deserialize(this.d, this.b, obj);
                objDeserialize = this.f;
            }
            return objDeserialize;
        } finally {
            this.h = i3;
            this.d.y();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.h != 0) {
            this.h = 0;
            JsonParser jsonParser = this.d;
            if (jsonParser != null) {
                jsonParser.close();
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        try {
            return C();
        } catch (JsonMappingException e) {
            return ((Boolean) u(e)).booleanValue();
        } catch (IOException e2) {
            return ((Boolean) n(e2)).booleanValue();
        }
    }

    protected Object n(IOException iOException) {
        throw new RuntimeException(iOException.getMessage(), iOException);
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            return D();
        } catch (JsonMappingException e) {
            return u(e);
        } catch (IOException e2) {
            return n(e2);
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    protected Object u(JsonMappingException jsonMappingException) {
        throw new RuntimeJsonMappingException(jsonMappingException.getMessage(), jsonMappingException);
    }

    protected void w() {
        JsonParser jsonParser = this.d;
        if (jsonParser.P0() == this.e) {
            return;
        }
        while (true) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            if (jsonTokenN1 == JsonToken.END_ARRAY || jsonTokenN1 == JsonToken.END_OBJECT) {
                if (jsonParser.P0() == this.e) {
                    jsonParser.y();
                    return;
                }
            } else if (jsonTokenN1 == JsonToken.START_ARRAY || jsonTokenN1 == JsonToken.START_OBJECT) {
                jsonParser.v1();
            } else if (jsonTokenN1 == null) {
                return;
            }
        }
    }

    protected Object y() {
        throw new NoSuchElementException();
    }
}
