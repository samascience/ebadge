package defpackage;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class jk3 {
    private static final String a = fd1.f("WrkDbPathHelper");
    private static final String[] b = {"-journal", "-shm", "-wal"};

    public static File a(Context context) {
        return c(context, "androidx.work.workdb");
    }

    public static File b(Context context) {
        return context.getDatabasePath("androidx.work.workdb");
    }

    private static File c(Context context, String str) {
        return new File(context.getNoBackupFilesDir(), str);
    }

    public static String d() {
        return "androidx.work.workdb";
    }

    public static void e(Context context) {
        if (b(context).exists()) {
            fd1.c().a(a, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
            Map mapF = f(context);
            for (File file : mapF.keySet()) {
                File file2 = (File) mapF.get(file);
                if (file.exists() && file2 != null) {
                    if (file2.exists()) {
                        fd1.c().h(a, String.format("Over-writing contents of %s", file2), new Throwable[0]);
                    }
                    fd1.c().a(a, file.renameTo(file2) ? String.format("Migrated %s to %s", file, file2) : String.format("Renaming %s to %s failed", file, file2), new Throwable[0]);
                }
            }
        }
    }

    public static Map f(Context context) {
        HashMap map = new HashMap();
        File fileB = b(context);
        File fileA = a(context);
        map.put(fileB, fileA);
        for (String str : b) {
            map.put(new File(fileB.getPath() + str), new File(fileA.getPath() + str));
        }
        return map;
    }
}
