package defpackage;

import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import kotlin.text.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class hn0 extends gn0 {
    public static String b(File file) {
        p31.f(file, "<this>");
        String name = file.getName();
        p31.e(name, "getName(...)");
        return i.G0(name, '.', Constants.STR_EMPTY);
    }

    public static String c(File file) {
        p31.f(file, "<this>");
        String name = file.getName();
        p31.e(name, "getName(...)");
        return i.N0(name, FileUtils.FILE_EXTENSION_SEPARATOR, null, 2, null);
    }
}
