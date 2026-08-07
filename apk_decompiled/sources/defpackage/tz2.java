package defpackage;

import android.database.Cursor;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class tz2 {
    public final String a;
    public final Map b;
    public final Set c;
    public final Set d;

    public static class a {
        public final String a;
        public final String b;
        public final int c;
        public final boolean d;
        public final int e;
        public final String f;
        private final int g;

        public a(String str, String str2, boolean z, int i, String str3, int i2) {
            this.a = str;
            this.b = str2;
            this.d = z;
            this.e = i;
            this.c = a(str2);
            this.f = str3;
            this.g = i2;
        }

        private static int a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.e != aVar.e || !this.a.equals(aVar.a) || this.d != aVar.d) {
                return false;
            }
            if (this.g == 1 && aVar.g == 2 && (str3 = this.f) != null && !str3.equals(aVar.f)) {
                return false;
            }
            if (this.g == 2 && aVar.g == 1 && (str2 = aVar.f) != null && !str2.equals(this.f)) {
                return false;
            }
            int i = this.g;
            return (i == 0 || i != aVar.g || ((str = this.f) == null ? aVar.f == null : str.equals(aVar.f))) && this.c == aVar.c;
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + this.c) * 31) + (this.d ? 1231 : 1237)) * 31) + this.e;
        }

        public String toString() {
            return "Column{name='" + this.a + "', type='" + this.b + "', affinity='" + this.c + "', notNull=" + this.d + ", primaryKeyPosition=" + this.e + ", defaultValue='" + this.f + "'}";
        }
    }

    public static class b {
        public final String a;
        public final String b;
        public final String c;
        public final List d;
        public final List e;

        public b(String str, String str2, String str3, List list, List list2) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = Collections.unmodifiableList(list);
            this.e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a.equals(bVar.a) && this.b.equals(bVar.b) && this.c.equals(bVar.c) && this.d.equals(bVar.d)) {
                return this.e.equals(bVar.e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.a + "', onDelete='" + this.b + "', onUpdate='" + this.c + "', columnNames=" + this.d + ", referenceColumnNames=" + this.e + '}';
        }
    }

    static class c implements Comparable {
        final int a;
        final int b;
        final String c;
        final String d;

        c(int i, int i2, String str, String str2) {
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            int i = this.a - cVar.a;
            return i == 0 ? this.b - cVar.b : i;
        }
    }

    public static class d {
        public final String a;
        public final boolean b;
        public final List c;

        public d(String str, boolean z, List list) {
            this.a = str;
            this.b = z;
            this.c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.b == dVar.b && this.c.equals(dVar.c)) {
                return this.a.startsWith("index_") ? dVar.a.startsWith("index_") : this.a.equals(dVar.a);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.a.startsWith("index_") ? -1184239155 : this.a.hashCode()) * 31) + (this.b ? 1 : 0)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.a + "', unique=" + this.b + ", columns=" + this.c + '}';
        }
    }

    public tz2(String str, Map map, Set set, Set set2) {
        this.a = str;
        this.b = Collections.unmodifiableMap(map);
        this.c = Collections.unmodifiableSet(set);
        this.d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public static tz2 a(ow2 ow2Var, String str) {
        return new tz2(str, b(ow2Var, str), d(ow2Var, str), f(ow2Var, str));
    }

    private static Map b(ow2 ow2Var, String str) {
        Cursor cursorW = ow2Var.W("PRAGMA table_info(`" + str + "`)");
        HashMap map = new HashMap();
        try {
            if (cursorW.getColumnCount() > 0) {
                int columnIndex = cursorW.getColumnIndex("name");
                int columnIndex2 = cursorW.getColumnIndex(SocialConstants.PARAM_TYPE);
                int columnIndex3 = cursorW.getColumnIndex("notnull");
                int columnIndex4 = cursorW.getColumnIndex("pk");
                int columnIndex5 = cursorW.getColumnIndex("dflt_value");
                while (cursorW.moveToNext()) {
                    String string = cursorW.getString(columnIndex);
                    map.put(string, new a(string, cursorW.getString(columnIndex2), cursorW.getInt(columnIndex3) != 0, cursorW.getInt(columnIndex4), cursorW.getString(columnIndex5), 2));
                }
            }
            return map;
        } finally {
            cursorW.close();
        }
    }

    private static List c(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex(Constants.FROM);
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Set d(ow2 ow2Var, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorW = ow2Var.W("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = cursorW.getColumnIndex("id");
            int columnIndex2 = cursorW.getColumnIndex("seq");
            int columnIndex3 = cursorW.getColumnIndex("table");
            int columnIndex4 = cursorW.getColumnIndex("on_delete");
            int columnIndex5 = cursorW.getColumnIndex("on_update");
            List<c> listC = c(cursorW);
            int count = cursorW.getCount();
            for (int i = 0; i < count; i++) {
                cursorW.moveToPosition(i);
                if (cursorW.getInt(columnIndex2) == 0) {
                    int i2 = cursorW.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c cVar : listC) {
                        if (cVar.a == i2) {
                            arrayList.add(cVar.c);
                            arrayList2.add(cVar.d);
                        }
                    }
                    hashSet.add(new b(cursorW.getString(columnIndex3), cursorW.getString(columnIndex4), cursorW.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            cursorW.close();
        }
    }

    private static d e(ow2 ow2Var, String str, boolean z) {
        Cursor cursorW = ow2Var.W("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorW.getColumnIndex("seqno");
            int columnIndex2 = cursorW.getColumnIndex("cid");
            int columnIndex3 = cursorW.getColumnIndex("name");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                TreeMap treeMap = new TreeMap();
                while (cursorW.moveToNext()) {
                    if (cursorW.getInt(columnIndex2) >= 0) {
                        treeMap.put(Integer.valueOf(cursorW.getInt(columnIndex)), cursorW.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                return new d(str, z, arrayList);
            }
            return null;
        } finally {
            cursorW.close();
        }
    }

    private static Set f(ow2 ow2Var, String str) {
        Cursor cursorW = ow2Var.W("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = cursorW.getColumnIndex("name");
            int columnIndex2 = cursorW.getColumnIndex("origin");
            int columnIndex3 = cursorW.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                HashSet hashSet = new HashSet();
                while (cursorW.moveToNext()) {
                    if ("c".equals(cursorW.getString(columnIndex2))) {
                        String string = cursorW.getString(columnIndex);
                        boolean z = true;
                        if (cursorW.getInt(columnIndex3) != 1) {
                            z = false;
                        }
                        d dVarE = e(ow2Var, string, z);
                        if (dVarE == null) {
                            cursorW.close();
                            return null;
                        }
                        hashSet.add(dVarE);
                    }
                }
                cursorW.close();
                return hashSet;
            }
            cursorW.close();
            return null;
        } catch (Throwable th) {
            cursorW.close();
            throw th;
        }
    }

    public boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        tz2 tz2Var = (tz2) obj;
        String str = this.a;
        if (str == null ? tz2Var.a != null : !str.equals(tz2Var.a)) {
            return false;
        }
        Map map = this.b;
        if (map == null ? tz2Var.b != null : !map.equals(tz2Var.b)) {
            return false;
        }
        Set set2 = this.c;
        if (set2 == null ? tz2Var.c != null : !set2.equals(tz2Var.c)) {
            return false;
        }
        Set set3 = this.d;
        if (set3 == null || (set = tz2Var.d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map map = this.b;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set set = this.c;
        return iHashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "TableInfo{name='" + this.a + "', columns=" + this.b + ", foreignKeys=" + this.c + ", indices=" + this.d + '}';
    }
}
