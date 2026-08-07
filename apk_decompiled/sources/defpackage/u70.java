package defpackage;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class u70 implements yx0 {
    protected DecimalFormat a;
    protected int b;

    public u70(int i) {
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

    @Override // defpackage.yx0
    public String a(float f, yd ydVar) {
        return this.a.format(f);
    }

    public int b() {
        return this.b;
    }
}
