package xfkj.fitpro.db;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.blankj.utilcode.util.j;
import defpackage.h82;
import defpackage.mt2;
import defpackage.r50;
import defpackage.r60;
import defpackage.y0;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MigrationHelper {
    private static final String SQLITE_MASTER = "sqlite_master";
    private static final String SQLITE_TEMP_MASTER = "sqlite_temp_master";
    private static volatile MigrationHelper helper;

    private void createAllTables(r60 r60Var, boolean z, Class<? extends y0>... clsArr) {
        reflectMethod(r60Var, "createTable", z, clsArr);
        j.t("Create all table");
    }

    private void dropAllTables(r60 r60Var, boolean z, Class<? extends y0>... clsArr) {
        reflectMethod(r60Var, "dropTable", z, clsArr);
        j.t("Drop all table");
    }

    private void generateTempTables(r60 r60Var, Class<? extends y0>... clsArr) {
        for (Class<? extends y0> cls : clsArr) {
            r50 r50Var = new r50(r60Var, cls);
            String str = r50Var.b;
            if (isTableExists(r60Var, false, str)) {
                String strConcat = null;
                try {
                    strConcat = r50Var.b.concat("_TEMP");
                    r60Var.e("DROP TABLE IF EXISTS " + strConcat + ";");
                    r60Var.e("CREATE TEMPORARY TABLE " + strConcat + " AS SELECT * FROM " + str + ";");
                    StringBuilder sb = new StringBuilder();
                    sb.append("Table ");
                    sb.append(str);
                    sb.append("\n --Columns-->");
                    sb.append(getColumnsStr(r50Var));
                    j.t(sb.toString());
                    j.t("Generate temp table " + strConcat);
                } catch (SQLException e) {
                    j.t("Failed to generate temp table " + strConcat + "\n" + e);
                }
            } else {
                j.t("New Table " + str);
            }
        }
    }

    private static List<String> getColumns(r60 r60Var, String str) throws Throwable {
        Cursor cursor = null;
        listAsList = null;
        List<String> listAsList = null;
        cursor = null;
        try {
            try {
                Cursor cursorN = r60Var.n("SELECT * FROM " + str + " limit 0", null);
                if (cursorN != null) {
                    try {
                        if (cursorN.getColumnCount() > 0) {
                            listAsList = Arrays.asList(cursorN.getColumnNames());
                        }
                    } catch (Exception e) {
                        e = e;
                        cursor = cursorN;
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return new ArrayList();
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorN;
                        if (cursor != null) {
                            cursor.close();
                        }
                        new ArrayList();
                        throw th;
                    }
                }
                if (cursorN != null) {
                    cursorN.close();
                }
                return listAsList == null ? new ArrayList() : listAsList;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String getColumnsStr(r50 r50Var) {
        if (r50Var == null) {
            return "no columns";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            String[] strArr = r50Var.d;
            if (i >= strArr.length) {
                break;
            }
            sb.append(strArr[i]);
            sb.append(",");
            i++;
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static MigrationHelper getInstance() {
        if (helper == null) {
            synchronized (MigrationHelper.class) {
                try {
                    if (helper == null) {
                        helper = new MigrationHelper();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return helper;
    }

    private boolean isTableExists(r60 r60Var, boolean z, String str) {
        int i;
        if (r60Var == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorN = null;
        try {
            try {
                cursorN = r60Var.n("SELECT COUNT(*) FROM " + (z ? SQLITE_TEMP_MASTER : SQLITE_MASTER) + " WHERE type = ? AND name = ?", new String[]{"table", str});
                if (cursorN != null && cursorN.moveToFirst()) {
                    i = cursorN.getInt(0);
                    cursorN.close();
                    return i > 0;
                }
                if (cursorN != null) {
                    cursorN.close();
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorN != null) {
                    cursorN.close();
                }
                i = 0;
            }
        } catch (Throwable th) {
            if (cursorN != null) {
                cursorN.close();
            }
            throw th;
        }
    }

    private void reflectMethod(r60 r60Var, String str, boolean z, Class<? extends y0>... clsArr) {
        if (clsArr.length < 1) {
            return;
        }
        try {
            for (Class<? extends y0> cls : clsArr) {
                cls.getDeclaredMethod(str, r60.class, Boolean.TYPE).invoke(null, r60Var, Boolean.valueOf(z));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    private void restoreData(r60 r60Var, Class<? extends y0>... clsArr) throws Throwable {
        for (Class<? extends y0> cls : clsArr) {
            r50 r50Var = new r50(r60Var, cls);
            String str = r50Var.b;
            String strConcat = str.concat("_TEMP");
            if (isTableExists(r60Var, true, strConcat)) {
                try {
                    List<String> columns = getColumns(r60Var, strConcat);
                    ArrayList arrayList = new ArrayList(columns.size());
                    int i = 0;
                    while (true) {
                        h82[] h82VarArr = r50Var.c;
                        if (i >= h82VarArr.length) {
                            break;
                        }
                        String str2 = h82VarArr[i].e;
                        if (columns.contains(str2)) {
                            arrayList.add(str2);
                        }
                        i++;
                    }
                    if (arrayList.size() > 0) {
                        String strJoin = TextUtils.join(",", arrayList);
                        r60Var.e("INSERT INTO " + str + " (" + strJoin + ") SELECT " + strJoin + " FROM " + strConcat + ";");
                        StringBuilder sb = new StringBuilder();
                        sb.append("Restore data to ");
                        sb.append(str);
                        j.t(sb.toString());
                    }
                    r60Var.e("DROP TABLE " + strConcat);
                    j.t("Drop temp table " + strConcat);
                } catch (SQLException e) {
                    j.t("Failed to restore data from temp table " + strConcat + "\n" + e);
                }
            }
        }
    }

    public void migrate(SQLiteDatabase sQLiteDatabase, Class<? extends y0>... clsArr) throws Throwable {
        mt2 mt2Var = new mt2(sQLiteDatabase);
        j.t("The Old Database Version " + sQLiteDatabase.getVersion());
        j.t("Generate temp table start.");
        generateTempTables(mt2Var, clsArr);
        j.t("Generate temp table complete.");
        dropAllTables(mt2Var, true, clsArr);
        createAllTables(mt2Var, false, clsArr);
        j.t("Restore data start.");
        restoreData(mt2Var, clsArr);
        j.t("Restore data complete.");
    }
}
