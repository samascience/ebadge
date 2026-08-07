package defpackage;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class y80 implements wy0 {
    protected DecimalFormat a;
    protected int b;

    public y80(int i) {
        a(i);
    }

    public void a(int i) {
        this.b = i;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            }
            stringBuffer.append("0");
        }
        this.a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }
}
