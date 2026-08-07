package retrofit2;

import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import defpackage.df2;
import defpackage.ff2;
import defpackage.fi1;
import defpackage.fo;
import defpackage.gm1;
import defpackage.gp0;
import defpackage.iw0;
import defpackage.ro;
import defpackage.tx0;
import java.io.EOFException;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class RequestBuilder {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private final tx0 baseUrl;

    @Nullable
    private ff2 body;

    @Nullable
    private fi1 contentType;

    @Nullable
    private gp0.a formBuilder;
    private final boolean hasBody;
    private final String method;

    @Nullable
    private gm1.a multipartBuilder;

    @Nullable
    private String relativeUrl;
    private final df2.a requestBuilder;

    @Nullable
    private tx0.a urlBuilder;

    private static class ContentTypeOverridingRequestBody extends ff2 {
        private final fi1 contentType;
        private final ff2 delegate;

        ContentTypeOverridingRequestBody(ff2 ff2Var, fi1 fi1Var) {
            this.delegate = ff2Var;
            this.contentType = fi1Var;
        }

        @Override // defpackage.ff2
        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        @Override // defpackage.ff2
        public fi1 contentType() {
            return this.contentType;
        }

        @Override // defpackage.ff2
        public void writeTo(ro roVar) throws IOException {
            this.delegate.writeTo(roVar);
        }
    }

    RequestBuilder(String str, tx0 tx0Var, @Nullable String str2, @Nullable iw0 iw0Var, @Nullable fi1 fi1Var, boolean z, boolean z2, boolean z3) {
        this.method = str;
        this.baseUrl = tx0Var;
        this.relativeUrl = str2;
        df2.a aVar = new df2.a();
        this.requestBuilder = aVar;
        this.contentType = fi1Var;
        this.hasBody = z;
        if (iw0Var != null) {
            aVar.h(iw0Var);
        }
        if (z2) {
            this.formBuilder = new gp0.a();
        } else if (z3) {
            gm1.a aVar2 = new gm1.a();
            this.multipartBuilder = aVar2;
            aVar2.f(gm1.k);
        }
    }

    private static String canonicalizeForPath(String str, boolean z) throws EOFException {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) != -1 || (!z && (iCodePointAt == 47 || iCodePointAt == 37))) {
                fo foVar = new fo();
                foVar.Y0(str, 0, iCharCount);
                canonicalizeForPath(foVar, str, iCharCount, length, z);
                return foVar.G0();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    void addFormField(String str, String str2, boolean z) {
        if (z) {
            this.formBuilder.b(str, str2);
        } else {
            this.formBuilder.a(str, str2);
        }
    }

    void addHeader(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.requestBuilder.a(str, str2);
            return;
        }
        fi1 fi1VarG = fi1.g(str2);
        if (fi1VarG != null) {
            this.contentType = fi1VarG;
            return;
        }
        throw new IllegalArgumentException("Malformed content type: " + str2);
    }

    void addPart(iw0 iw0Var, ff2 ff2Var) {
        this.multipartBuilder.c(iw0Var, ff2Var);
    }

    void addPathParam(String str, String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 == null) {
            throw new AssertionError();
        }
        this.relativeUrl = str3.replace("{" + str + "}", canonicalizeForPath(str2, z));
    }

    void addQueryParam(String str, @Nullable String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            tx0.a aVarK = this.baseUrl.k(str3);
            this.urlBuilder = aVarK;
            if (aVarK == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
            this.relativeUrl = null;
        }
        if (z) {
            this.urlBuilder.a(str, str2);
        } else {
            this.urlBuilder.b(str, str2);
        }
    }

    df2 build() {
        tx0 tx0VarQ;
        tx0.a aVar = this.urlBuilder;
        if (aVar != null) {
            tx0VarQ = aVar.c();
        } else {
            tx0VarQ = this.baseUrl.q(this.relativeUrl);
            if (tx0VarQ == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        ff2 contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            gp0.a aVar2 = this.formBuilder;
            if (aVar2 != null) {
                contentTypeOverridingRequestBody = aVar2.c();
            } else {
                gm1.a aVar3 = this.multipartBuilder;
                if (aVar3 != null) {
                    contentTypeOverridingRequestBody = aVar3.e();
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = ff2.create((fi1) null, new byte[0]);
                }
            }
        }
        fi1 fi1Var = this.contentType;
        if (fi1Var != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, fi1Var);
            } else {
                this.requestBuilder.a("Content-Type", fi1Var.toString());
            }
        }
        return this.requestBuilder.l(tx0VarQ).i(this.method, contentTypeOverridingRequestBody).b();
    }

    void setBody(ff2 ff2Var) {
        this.body = ff2Var;
    }

    void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }

    void addPart(gm1.c cVar) {
        this.multipartBuilder.d(cVar);
    }

    private static void canonicalizeForPath(fo foVar, String str, int i, int i2, boolean z) throws EOFException {
        fo foVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt >= 32 && iCodePointAt < 127 && PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) == -1 && (z || (iCodePointAt != 47 && iCodePointAt != 37))) {
                    foVar.Z0(iCodePointAt);
                } else {
                    if (foVar2 == null) {
                        foVar2 = new fo();
                    }
                    foVar2.Z0(iCodePointAt);
                    while (!foVar2.H()) {
                        byte b = foVar2.readByte();
                        foVar.I(37);
                        char[] cArr = HEX_DIGITS;
                        foVar.I(cArr[((b & 255) >> 4) & 15]);
                        foVar.I(cArr[b & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS]);
                    }
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }
}
