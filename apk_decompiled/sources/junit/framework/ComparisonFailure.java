package junit.framework;

import defpackage.n00;

/* JADX INFO: loaded from: classes4.dex */
public class ComparisonFailure extends AssertionFailedError {
    private static final int MAX_CONTEXT_LENGTH = 20;
    private static final long serialVersionUID = 1;
    private String fActual;
    private String fExpected;

    public ComparisonFailure(String str, String str2, String str3) {
        super(str);
        this.fExpected = str2;
        this.fActual = str3;
    }

    public String getActual() {
        return this.fActual;
    }

    public String getExpected() {
        return this.fExpected;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return new n00(20, this.fExpected, this.fActual).b(super.getMessage());
    }
}
