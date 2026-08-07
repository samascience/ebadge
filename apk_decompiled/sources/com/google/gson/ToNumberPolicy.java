package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.MalformedJsonException;
import defpackage.a71;
import defpackage.n33;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes3.dex */
public enum ToNumberPolicy implements n33 {
    DOUBLE { // from class: com.google.gson.ToNumberPolicy.1
        @Override // com.google.gson.ToNumberPolicy, defpackage.n33
        public Double readNumber(a71 a71Var) throws IOException {
            return Double.valueOf(a71Var.y0());
        }
    },
    LAZILY_PARSED_NUMBER { // from class: com.google.gson.ToNumberPolicy.2
        @Override // com.google.gson.ToNumberPolicy, defpackage.n33
        public Number readNumber(a71 a71Var) throws IOException {
            return new LazilyParsedNumber(a71Var.K0());
        }
    },
    LONG_OR_DOUBLE { // from class: com.google.gson.ToNumberPolicy.3
        @Override // com.google.gson.ToNumberPolicy, defpackage.n33
        public Number readNumber(a71 a71Var) throws JsonParseException, IOException {
            String strK0 = a71Var.K0();
            try {
                try {
                    return Long.valueOf(Long.parseLong(strK0));
                } catch (NumberFormatException unused) {
                    Double dValueOf = Double.valueOf(strK0);
                    if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                        if (!a71Var.k0()) {
                            throw new MalformedJsonException("JSON forbids NaN and infinities: " + dValueOf + "; at path " + a71Var.g0());
                        }
                    }
                    return dValueOf;
                }
            } catch (NumberFormatException e) {
                throw new JsonParseException("Cannot parse " + strK0 + "; at path " + a71Var.g0(), e);
            }
        }
    },
    BIG_DECIMAL { // from class: com.google.gson.ToNumberPolicy.4
        @Override // com.google.gson.ToNumberPolicy, defpackage.n33
        public BigDecimal readNumber(a71 a71Var) throws IOException {
            String strK0 = a71Var.K0();
            try {
                return new BigDecimal(strK0);
            } catch (NumberFormatException e) {
                throw new JsonParseException("Cannot parse " + strK0 + "; at path " + a71Var.g0(), e);
            }
        }
    };

    @Override // defpackage.n33
    public abstract /* synthetic */ Number readNumber(a71 a71Var) throws IOException;
}
