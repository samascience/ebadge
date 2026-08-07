package lombok.patcher;

import com.fasterxml.jackson.core.JsonPointer;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/patcher/ClassRootFinder.SCL.lombok */
public class ClassRootFinder {
    private static String urlDecode(String in, boolean forceUtf8) {
        String strName;
        if (forceUtf8) {
            strName = Constants.ENC_UTF_8;
        } else {
            try {
                strName = Charset.defaultCharset().name();
            } catch (UnsupportedEncodingException unused) {
                try {
                    return URLDecoder.decode(in, Constants.ENC_UTF_8);
                } catch (UnsupportedEncodingException unused2) {
                    return in;
                }
            }
        }
        return URLDecoder.decode(in, strName);
    }

    public static String findClassRootOfSelf() {
        return findClassRootOfClass(ClassRootFinder.class);
    }

    public static String findClassRootOfClass(Class<?> context) {
        String packageBase;
        String self;
        String name = context.getName();
        int idx = name.lastIndexOf(46);
        if (idx > -1) {
            packageBase = name.substring(0, idx);
            name = name.substring(idx + 1);
        } else {
            packageBase = Constants.STR_EMPTY;
        }
        URL selfURL = context.getResource(String.valueOf(name) + ".class");
        String self2 = selfURL.toString();
        if (self2.startsWith("file:/")) {
            String path = urlDecode(self2.substring(5), false);
            if (!new File(path).exists()) {
                path = urlDecode(self2.substring(5), true);
            }
            String suffix = WatchConstant.FAT_FS_ROOT + packageBase.replace('.', JsonPointer.SEPARATOR) + WatchConstant.FAT_FS_ROOT + name + ".class";
            if (!path.endsWith(suffix)) {
                throw new IllegalArgumentException("Unknown path structure: " + path);
            }
            self = path.substring(0, path.length() - suffix.length());
        } else if (self2.startsWith("jar:")) {
            int sep = self2.indexOf(33);
            if (sep == -1) {
                throw new IllegalArgumentException("No separator in jar protocol: " + self2);
            }
            String jarLoc = self2.substring(4, sep);
            if (!jarLoc.startsWith("file:/")) {
                throw new IllegalArgumentException("Unknown path structure: " + self2);
            }
            String path2 = urlDecode(jarLoc.substring(5), false);
            if (!new File(path2).exists()) {
                path2 = urlDecode(jarLoc.substring(5), true);
            }
            self = path2;
        } else {
            throw new IllegalArgumentException("Unknown protocol: " + self2);
        }
        if (self.isEmpty()) {
            self = WatchConstant.FAT_FS_ROOT;
        }
        return self;
    }

    public static void main(String[] args) {
        System.out.println(findClassRootOfSelf());
    }
}
