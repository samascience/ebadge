package junit.framework;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class AssertionFailedError extends AssertionError {
    private static final long serialVersionUID = 1;

    public AssertionFailedError() {
    }

    private static String defaultString(String str) {
        return str == null ? Constants.STR_EMPTY : str;
    }

    public AssertionFailedError(String str) {
        super(defaultString(str));
    }
}
