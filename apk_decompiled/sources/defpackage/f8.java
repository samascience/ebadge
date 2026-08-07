package defpackage;

import com.alibaba.dashscope.exception.NoApiKeyException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/* JADX INFO: loaded from: classes.dex */
public abstract class f8 {
    private static final hd1 a = ld1.k(f8.class);

    public static String a(String str) throws NoApiKeyException {
        if (str != null) {
            return str;
        }
        String str2 = i20.f;
        if (str2 != null) {
            return str2;
        }
        String str3 = System.getenv("DASHSCOPE_API_KEY");
        if (str3 != null) {
            return str3;
        }
        String str4 = System.getenv("DASHSCOPE_API_KEY_FILE_PATH");
        if (str4 == null || Files.notExists(Paths.get(str4, new String[0]), new LinkOption[0])) {
            Path pathResolve = Paths.get(System.getProperty("user.home"), new String[0]).resolve(".dashscope").resolve("api_key");
            if (!Files.notExists(pathResolve, new LinkOption[0])) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(pathResolve.toString()));
                    String strTrim = bufferedReader.readLine().trim();
                    bufferedReader.close();
                    return strTrim;
                } catch (Exception unused) {
                    throw new NoApiKeyException();
                }
            }
            str4 = null;
        }
        if (str4 == null) {
            throw new NoApiKeyException();
        }
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str4));
            String strTrim2 = bufferedReader2.readLine().trim();
            bufferedReader2.close();
            return strTrim2;
        } catch (Exception unused2) {
            throw new NoApiKeyException();
        }
    }
}
