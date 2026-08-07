package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.luck.picture.lib.R$string;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class pc1 extends cy0 {
    private static final Uri d = MediaStore.Files.getContentUri("external");
    private static final String[] e = {"_id", "_data", "mime_type", "width", "height", "duration", "_size", "bucket_display_name", "_display_name", "bucket_id", "date_added"};
    private final Context a;
    private final boolean b = ol2.a();
    private final PictureSelectionConfig c;

    class a extends PictureThreadUtils.d {
        final /* synthetic */ wv1 f;

        a(wv1 wv1Var) {
            this.f = wv1Var;
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public LocalMediaFolder d() {
            return oj2.b(pc1.this.a, pc1.this.c.X0);
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(LocalMediaFolder localMediaFolder) {
            PictureThreadUtils.e(PictureThreadUtils.j());
            wv1 wv1Var = this.f;
            if (wv1Var != null) {
                wv1Var.a(localMediaFolder);
            }
        }
    }

    class b extends PictureThreadUtils.d {
        final /* synthetic */ wv1 f;

        b(wv1 wv1Var) {
            this.f = wv1Var;
        }

        /* JADX WARN: Code duplicated, block: B:30:0x012c A[Catch: all -> 0x00d7, Exception -> 0x00da, PHI: r5
          0x012c: PHI (r5v7 java.lang.String) = (r5v6 java.lang.String), (r5v28 java.lang.String), (r5v28 java.lang.String) binds: [B:20:0x00fc, B:26:0x0115, B:28:0x011b] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x00da, blocks: (B:4:0x002d, B:6:0x003d, B:7:0x00c0, B:9:0x00ce, B:15:0x00dd, B:17:0x00eb, B:19:0x00f6, B:21:0x00fe, B:23:0x0104, B:25:0x010d, B:27:0x0117, B:67:0x023f, B:69:0x0245, B:71:0x0259, B:73:0x027f, B:75:0x0285, B:76:0x028d, B:77:0x0290, B:79:0x0296, B:81:0x02c5, B:83:0x02de, B:82:0x02d2, B:24:0x0109, B:30:0x012c, B:32:0x0136, B:35:0x0141, B:37:0x014b, B:40:0x0156, B:42:0x018e, B:46:0x01a6, B:48:0x01ac, B:50:0x01b6, B:54:0x01cb, B:56:0x01d5, B:66:0x01f2), top: B:99:0x002d, outer: #1 }] */
        /* JADX WARN: Code duplicated, block: B:42:0x018e A[Catch: all -> 0x00d7, Exception -> 0x00da, TryCatch #0 {Exception -> 0x00da, blocks: (B:4:0x002d, B:6:0x003d, B:7:0x00c0, B:9:0x00ce, B:15:0x00dd, B:17:0x00eb, B:19:0x00f6, B:21:0x00fe, B:23:0x0104, B:25:0x010d, B:27:0x0117, B:67:0x023f, B:69:0x0245, B:71:0x0259, B:73:0x027f, B:75:0x0285, B:76:0x028d, B:77:0x0290, B:79:0x0296, B:81:0x02c5, B:83:0x02de, B:82:0x02d2, B:24:0x0109, B:30:0x012c, B:32:0x0136, B:35:0x0141, B:37:0x014b, B:40:0x0156, B:42:0x018e, B:46:0x01a6, B:48:0x01ac, B:50:0x01b6, B:54:0x01cb, B:56:0x01d5, B:66:0x01f2), top: B:99:0x002d, outer: #1 }] */
        /* JADX WARN: Code duplicated, block: B:44:0x01a1  */
        /* JADX WARN: Code duplicated, block: B:45:0x01a4  */
        /* JADX WARN: Code duplicated, block: B:48:0x01ac A[Catch: all -> 0x00d7, Exception -> 0x00da, TryCatch #0 {Exception -> 0x00da, blocks: (B:4:0x002d, B:6:0x003d, B:7:0x00c0, B:9:0x00ce, B:15:0x00dd, B:17:0x00eb, B:19:0x00f6, B:21:0x00fe, B:23:0x0104, B:25:0x010d, B:27:0x0117, B:67:0x023f, B:69:0x0245, B:71:0x0259, B:73:0x027f, B:75:0x0285, B:76:0x028d, B:77:0x0290, B:79:0x0296, B:81:0x02c5, B:83:0x02de, B:82:0x02d2, B:24:0x0109, B:30:0x012c, B:32:0x0136, B:35:0x0141, B:37:0x014b, B:40:0x0156, B:42:0x018e, B:46:0x01a6, B:48:0x01ac, B:50:0x01b6, B:54:0x01cb, B:56:0x01d5, B:66:0x01f2), top: B:99:0x002d, outer: #1 }] */
        /* JADX WARN: Code duplicated, block: B:50:0x01b6 A[Catch: all -> 0x00d7, Exception -> 0x00da, TryCatch #0 {Exception -> 0x00da, blocks: (B:4:0x002d, B:6:0x003d, B:7:0x00c0, B:9:0x00ce, B:15:0x00dd, B:17:0x00eb, B:19:0x00f6, B:21:0x00fe, B:23:0x0104, B:25:0x010d, B:27:0x0117, B:67:0x023f, B:69:0x0245, B:71:0x0259, B:73:0x027f, B:75:0x0285, B:76:0x028d, B:77:0x0290, B:79:0x0296, B:81:0x02c5, B:83:0x02de, B:82:0x02d2, B:24:0x0109, B:30:0x012c, B:32:0x0136, B:35:0x0141, B:37:0x014b, B:40:0x0156, B:42:0x018e, B:46:0x01a6, B:48:0x01ac, B:50:0x01b6, B:54:0x01cb, B:56:0x01d5, B:66:0x01f2), top: B:99:0x002d, outer: #1 }] */
        /* JADX WARN: Code duplicated, block: B:52:0x01c6  */
        /* JADX WARN: Code duplicated, block: B:53:0x01c8  */
        /* JADX WARN: Code duplicated, block: B:56:0x01d5 A[Catch: all -> 0x00d7, Exception -> 0x00da, TryCatch #0 {Exception -> 0x00da, blocks: (B:4:0x002d, B:6:0x003d, B:7:0x00c0, B:9:0x00ce, B:15:0x00dd, B:17:0x00eb, B:19:0x00f6, B:21:0x00fe, B:23:0x0104, B:25:0x010d, B:27:0x0117, B:67:0x023f, B:69:0x0245, B:71:0x0259, B:73:0x027f, B:75:0x0285, B:76:0x028d, B:77:0x0290, B:79:0x0296, B:81:0x02c5, B:83:0x02de, B:82:0x02d2, B:24:0x0109, B:30:0x012c, B:32:0x0136, B:35:0x0141, B:37:0x014b, B:40:0x0156, B:42:0x018e, B:46:0x01a6, B:48:0x01ac, B:50:0x01b6, B:54:0x01cb, B:56:0x01d5, B:66:0x01f2), top: B:99:0x002d, outer: #1 }] */
        /* JADX WARN: Code duplicated, block: B:59:0x01e3  */
        /* JADX WARN: Code duplicated, block: B:65:0x01ef  */
        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public List d() {
            long j;
            int i;
            long j2;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            ArrayList arrayList;
            ArrayList arrayList2 = new ArrayList();
            Cursor cursorQuery = pc1.this.a.getContentResolver().query(pc1.d, pc1.e, pc1.this.q(), pc1.this.r(), "_id DESC");
            if (cursorQuery != null) {
                try {
                    try {
                        LocalMediaFolder localMediaFolder = new LocalMediaFolder();
                        ArrayList arrayList3 = new ArrayList();
                        if (cursorQuery.getCount() > 0) {
                            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow(pc1.e[0]);
                            int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow(pc1.e[1]);
                            int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow(pc1.e[2]);
                            int columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow(pc1.e[3]);
                            int columnIndexOrThrow5 = cursorQuery.getColumnIndexOrThrow(pc1.e[4]);
                            int columnIndexOrThrow6 = cursorQuery.getColumnIndexOrThrow(pc1.e[5]);
                            int columnIndexOrThrow7 = cursorQuery.getColumnIndexOrThrow(pc1.e[6]);
                            int columnIndexOrThrow8 = cursorQuery.getColumnIndexOrThrow(pc1.e[7]);
                            int columnIndexOrThrow9 = cursorQuery.getColumnIndexOrThrow(pc1.e[8]);
                            int columnIndexOrThrow10 = cursorQuery.getColumnIndexOrThrow(pc1.e[9]);
                            int columnIndexOrThrow11 = cursorQuery.getColumnIndexOrThrow(pc1.e[10]);
                            cursorQuery.moveToFirst();
                            int i8 = columnIndexOrThrow8;
                            int i9 = columnIndexOrThrow9;
                            while (true) {
                                long j3 = cursorQuery.getLong(columnIndexOrThrow);
                                String string = cursorQuery.getString(columnIndexOrThrow3);
                                if (TextUtils.isEmpty(string)) {
                                    string = a22.x();
                                }
                                int i10 = columnIndexOrThrow;
                                String strA = string;
                                String string2 = cursorQuery.getString(columnIndexOrThrow2);
                                int i11 = columnIndexOrThrow2;
                                String strG = pc1.this.b ? a22.g(j3, strA) : string2;
                                if (strA.endsWith("image/*")) {
                                    strA = a22.h(strG) ? a22.a(string2) : a22.a(strG);
                                    if (!pc1.this.c.g0 && a22.i(strA)) {
                                        i = columnIndexOrThrow4;
                                        i2 = columnIndexOrThrow5;
                                        i4 = i8;
                                        i7 = i9;
                                        arrayList = arrayList3;
                                        i6 = columnIndexOrThrow10;
                                        i3 = columnIndexOrThrow6;
                                    } else if (pc1.this.c.h0) {
                                        int i12 = cursorQuery.getInt(columnIndexOrThrow4);
                                        int i13 = cursorQuery.getInt(columnIndexOrThrow5);
                                        j = cursorQuery.getLong(columnIndexOrThrow6);
                                        i = columnIndexOrThrow4;
                                        j2 = cursorQuery.getLong(columnIndexOrThrow7);
                                        i2 = columnIndexOrThrow5;
                                        int i14 = i8;
                                        i3 = columnIndexOrThrow6;
                                        String string3 = cursorQuery.getString(i14);
                                        i4 = i14;
                                        i5 = i9;
                                        String string4 = cursorQuery.getString(i5);
                                        long j4 = cursorQuery.getLong(columnIndexOrThrow10);
                                        i6 = columnIndexOrThrow10;
                                        if (pc1.this.c.S > 0.0f) {
                                            i7 = i5;
                                            if (j2 > pc1.this.c.S * 1048576.0f) {
                                                arrayList = arrayList3;
                                            }
                                        } else {
                                            i7 = i5;
                                        }
                                        if (a22.n(strA)) {
                                            if (pc1.this.c.I > 0) {
                                                arrayList = arrayList3;
                                                if (j < pc1.this.c.I) {
                                                }
                                            } else {
                                                arrayList = arrayList3;
                                            }
                                            if (pc1.this.c.H > 0) {
                                            }
                                        } else {
                                            arrayList = arrayList3;
                                            strA = strA;
                                        }
                                        LocalMedia localMediaF = LocalMedia.F(j3, strG, string2, string4, string3, j, pc1.this.c.a, strA, i12, i13, j2, j4, cursorQuery.getLong(columnIndexOrThrow11));
                                        LocalMediaFolder localMediaFolderO = pc1.this.o(strG, strA, string3, arrayList2);
                                        localMediaFolderO.m(localMediaF.b());
                                        localMediaFolderO.d().add(localMediaF);
                                        localMediaFolderO.v(localMediaFolderO.g() + 1);
                                        localMediaFolderO.m(localMediaF.b());
                                        arrayList.add(localMediaF);
                                        localMediaFolder.v(localMediaFolder.g() + 1);
                                    } else {
                                        int i15 = cursorQuery.getInt(columnIndexOrThrow4);
                                        int i16 = cursorQuery.getInt(columnIndexOrThrow5);
                                        j = cursorQuery.getLong(columnIndexOrThrow6);
                                        i = columnIndexOrThrow4;
                                        j2 = cursorQuery.getLong(columnIndexOrThrow7);
                                        i2 = columnIndexOrThrow5;
                                        int i17 = i8;
                                        i3 = columnIndexOrThrow6;
                                        String string5 = cursorQuery.getString(i17);
                                        i4 = i17;
                                        i5 = i9;
                                        String string6 = cursorQuery.getString(i5);
                                        long j5 = cursorQuery.getLong(columnIndexOrThrow10);
                                        i6 = columnIndexOrThrow10;
                                        if (pc1.this.c.S > 0.0f) {
                                            i7 = i5;
                                            if (j2 > pc1.this.c.S * 1048576.0f) {
                                                arrayList = arrayList3;
                                            }
                                        } else {
                                            i7 = i5;
                                        }
                                        if (a22.n(strA)) {
                                            if (pc1.this.c.I > 0) {
                                                arrayList = arrayList3;
                                                if (j < pc1.this.c.I) {
                                                }
                                            } else {
                                                arrayList = arrayList3;
                                            }
                                            if (pc1.this.c.H > 0) {
                                            }
                                        } else {
                                            arrayList = arrayList3;
                                            strA = strA;
                                        }
                                        LocalMedia localMediaF2 = LocalMedia.F(j3, strG, string2, string6, string5, j, pc1.this.c.a, strA, i15, i16, j2, j5, cursorQuery.getLong(columnIndexOrThrow11));
                                        LocalMediaFolder localMediaFolderO2 = pc1.this.o(strG, strA, string5, arrayList2);
                                        localMediaFolderO2.m(localMediaF2.b());
                                        localMediaFolderO2.d().add(localMediaF2);
                                        localMediaFolderO2.v(localMediaFolderO2.g() + 1);
                                        localMediaFolderO2.m(localMediaF2.b());
                                        arrayList.add(localMediaF2);
                                        localMediaFolder.v(localMediaFolder.g() + 1);
                                    }
                                } else if ((pc1.this.c.h0 || !strA.startsWith(a22.z())) && (pc1.this.c.i0 || !strA.startsWith(a22.u()))) {
                                    int i18 = cursorQuery.getInt(columnIndexOrThrow4);
                                    int i19 = cursorQuery.getInt(columnIndexOrThrow5);
                                    j = cursorQuery.getLong(columnIndexOrThrow6);
                                    i = columnIndexOrThrow4;
                                    j2 = cursorQuery.getLong(columnIndexOrThrow7);
                                    i2 = columnIndexOrThrow5;
                                    int i110 = i8;
                                    i3 = columnIndexOrThrow6;
                                    String string7 = cursorQuery.getString(i110);
                                    i4 = i110;
                                    i5 = i9;
                                    String string8 = cursorQuery.getString(i5);
                                    long j6 = cursorQuery.getLong(columnIndexOrThrow10);
                                    i6 = columnIndexOrThrow10;
                                    if (pc1.this.c.S > 0.0f) {
                                        i7 = i5;
                                        if (j2 > pc1.this.c.S * 1048576.0f) {
                                            arrayList = arrayList3;
                                        }
                                    } else {
                                        i7 = i5;
                                    }
                                    if (a22.n(strA)) {
                                        if (pc1.this.c.I > 0) {
                                            arrayList = arrayList3;
                                            if (j < pc1.this.c.I) {
                                            }
                                        } else {
                                            arrayList = arrayList3;
                                        }
                                        if ((pc1.this.c.H > 0 || j <= pc1.this.c.H) && j != 0 && j2 > 0) {
                                        }
                                    } else {
                                        arrayList = arrayList3;
                                        strA = strA;
                                    }
                                    LocalMedia localMediaF3 = LocalMedia.F(j3, strG, string2, string8, string7, j, pc1.this.c.a, strA, i18, i19, j2, j6, cursorQuery.getLong(columnIndexOrThrow11));
                                    LocalMediaFolder localMediaFolderO3 = pc1.this.o(strG, strA, string7, arrayList2);
                                    localMediaFolderO3.m(localMediaF3.b());
                                    localMediaFolderO3.d().add(localMediaF3);
                                    localMediaFolderO3.v(localMediaFolderO3.g() + 1);
                                    localMediaFolderO3.m(localMediaF3.b());
                                    arrayList.add(localMediaF3);
                                    localMediaFolder.v(localMediaFolder.g() + 1);
                                } else {
                                    i = columnIndexOrThrow4;
                                    i2 = columnIndexOrThrow5;
                                    i4 = i8;
                                    i7 = i9;
                                    arrayList = arrayList3;
                                    i6 = columnIndexOrThrow10;
                                    i3 = columnIndexOrThrow6;
                                }
                                if (!cursorQuery.moveToNext()) {
                                    break;
                                }
                                arrayList3 = arrayList;
                                columnIndexOrThrow6 = i3;
                                columnIndexOrThrow10 = i6;
                                columnIndexOrThrow = i10;
                                columnIndexOrThrow2 = i11;
                                columnIndexOrThrow3 = columnIndexOrThrow3;
                                columnIndexOrThrow4 = i;
                                columnIndexOrThrow5 = i2;
                                i8 = i4;
                                i9 = i7;
                            }
                            LocalMediaFolder localMediaFolderB = oj2.b(pc1.this.a, pc1.this.c.X0);
                            if (localMediaFolderB != null) {
                                arrayList2.add(localMediaFolderB);
                                localMediaFolder.v(localMediaFolder.g() + localMediaFolderB.g());
                                localMediaFolder.r(localMediaFolderB.d());
                                arrayList.addAll(0, localMediaFolderB.d());
                                if (60 > localMediaFolderB.g()) {
                                    if (arrayList.size() > 60) {
                                        js2.f(arrayList.subList(0, 60));
                                    } else {
                                        js2.f(arrayList);
                                    }
                                }
                            }
                            if (arrayList.size() > 0) {
                                js2.e(arrayList2);
                                arrayList2.add(0, localMediaFolder);
                                localMediaFolder.s(((LocalMedia) arrayList.get(0)).q());
                                localMediaFolder.t(((LocalMedia) arrayList.get(0)).n());
                                localMediaFolder.x(pc1.this.c.a == a22.t() ? pc1.this.a.getString(R$string.picture_all_audio) : pc1.this.a.getString(R$string.picture_camera_roll));
                                localMediaFolder.m(-1L);
                                localMediaFolder.z(pc1.this.c.a);
                                localMediaFolder.n(true);
                                localMediaFolder.r(arrayList);
                            }
                        }
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (!cursorQuery.isClosed()) {
                        }
                        return arrayList2;
                    }
                } catch (Throwable th) {
                    if (!cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } else if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList2;
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(List list) {
            PictureThreadUtils.e(PictureThreadUtils.j());
            wv1 wv1Var = this.f;
            if (wv1Var != null) {
                wv1Var.b(list);
            }
        }
    }

    public pc1(Context context, PictureSelectionConfig pictureSelectionConfig) {
        this.a = context.getApplicationContext();
        this.c = pictureSelectionConfig;
    }

    private String m() {
        PictureSelectionConfig pictureSelectionConfig = this.c;
        int i = pictureSelectionConfig.H;
        return String.format(Locale.CHINA, "%d <%s duration and duration <= %d", Long.valueOf(Math.max(0L, pictureSelectionConfig.I)), Math.max(0L, (long) this.c.I) == 0 ? Constants.STR_EMPTY : "=", Long.valueOf(i == 0 ? Long.MAX_VALUE : i));
    }

    private String n() {
        PictureSelectionConfig pictureSelectionConfig = this.c;
        long j = pictureSelectionConfig.T;
        if (j == 0) {
            j = Long.MAX_VALUE;
        }
        return String.format(Locale.CHINA, "%d <%s _size and _size <= %d", Long.valueOf(Math.max(0L, pictureSelectionConfig.U)), Math.max(0L, this.c.U) == 0 ? Constants.STR_EMPTY : "=", Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalMediaFolder o(String str, String str2, String str3, List list) {
        if (!this.c.r1) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                LocalMediaFolder localMediaFolder = (LocalMediaFolder) it.next();
                String strH = localMediaFolder.h();
                if (!TextUtils.isEmpty(strH) && strH.equals(str3)) {
                    return localMediaFolder;
                }
            }
            LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
            localMediaFolder2.x(str3);
            localMediaFolder2.s(str);
            localMediaFolder2.t(str2);
            list.add(localMediaFolder2);
            return localMediaFolder2;
        }
        File parentFile = new File(str).getParentFile();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            LocalMediaFolder localMediaFolder3 = (LocalMediaFolder) it2.next();
            String strH2 = localMediaFolder3.h();
            if (!TextUtils.isEmpty(strH2) && parentFile != null && strH2.equals(parentFile.getName())) {
                return localMediaFolder3;
            }
        }
        LocalMediaFolder localMediaFolder4 = new LocalMediaFolder();
        localMediaFolder4.x(parentFile != null ? parentFile.getName() : Constants.STR_EMPTY);
        localMediaFolder4.s(str);
        localMediaFolder4.t(str2);
        list.add(localMediaFolder4);
        return localMediaFolder4;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    /* JADX WARN: Code duplicated, block: B:38:0x008b  */
    private String p() {
        String str;
        HashSet<String> hashSet = this.c.J0;
        if (hashSet == null) {
            hashSet = new HashSet();
        }
        if (!TextUtils.isEmpty(this.c.o)) {
            hashSet.add(this.c.o);
        }
        StringBuilder sb = new StringBuilder();
        int i = -1;
        for (String str2 : hashSet) {
            if (!TextUtils.isEmpty(str2)) {
                if (this.c.a == a22.y()) {
                    if (!str2.startsWith("image") && !str2.startsWith("audio")) {
                        i++;
                        if (i == 0) {
                            str = " AND ";
                        } else {
                            str = " OR ";
                        }
                        sb.append(str);
                        sb.append("mime_type");
                        sb.append("='");
                        sb.append(str2);
                        sb.append("'");
                    }
                } else if (this.c.a == a22.w()) {
                    if (!str2.startsWith("audio") && !str2.startsWith("video")) {
                        i++;
                        if (i == 0) {
                            str = " AND ";
                        } else {
                            str = " OR ";
                        }
                        sb.append(str);
                        sb.append("mime_type");
                        sb.append("='");
                        sb.append(str2);
                        sb.append("'");
                    }
                } else if (this.c.a != a22.t() || (!str2.startsWith("video") && !str2.startsWith("image"))) {
                    i++;
                    if (i == 0) {
                        str = " AND ";
                    } else {
                        str = " OR ";
                    }
                    sb.append(str);
                    sb.append("mime_type");
                    sb.append("='");
                    sb.append(str2);
                    sb.append("'");
                }
            }
        }
        if (this.c.a != a22.y() && !this.c.g0 && !hashSet.contains(a22.v())) {
            sb.append(" AND (mime_type!='image/gif' AND mime_type!='image/*')");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String q() {
        String strM = m();
        String strN = n();
        String strP = p();
        int i = this.c.a;
        if (i == 0) {
            return s(strM, strN, strP);
        }
        if (i == 1) {
            return u(strN, strP);
        }
        if (i == 2) {
            return w(strN, strP);
        }
        if (i != 3) {
            return null;
        }
        return w(strM, strP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] r() {
        int i = this.c.a;
        if (i == 0) {
            return t();
        }
        if (i == 1) {
            return v(1);
        }
        if (i == 2) {
            return v(3);
        }
        if (i != 3) {
            return null;
        }
        return v(2);
    }

    private static String s(String str, String str2, String str3) {
        return "(media_type=?" + str3 + " OR media_type=? AND " + str + ") AND " + str2;
    }

    private static String[] t() {
        return new String[]{String.valueOf(1), String.valueOf(3)};
    }

    private static String u(String str, String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    private static String[] v(int i) {
        return new String[]{String.valueOf(i)};
    }

    private static String w(String str, String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    @Override // defpackage.cy0
    public void a(wv1 wv1Var) {
        PictureThreadUtils.h(new b(wv1Var));
    }

    @Override // defpackage.cy0
    public void b(wv1 wv1Var) {
        PictureThreadUtils.h(new a(wv1Var));
    }
}
