package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.luck.picture.lib.R$string;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class qc1 extends cy0 {
    private static final String c = "qc1";
    private static final Uri d = MediaStore.Files.getContentUri("external");
    private static final String[] e = {"_id", "bucket_id", "bucket_display_name", "mime_type"};
    private static final String[] f = {"_id", "_data", "bucket_id", "bucket_display_name", "mime_type", "COUNT(*) AS count"};
    private static final String[] g = {"_id", "_data", "mime_type", "width", "height", "duration", "_size", "bucket_display_name", "_display_name", "bucket_id", "date_added"};
    private final Context a;
    private final PictureSelectionConfig b;

    class a extends PictureThreadUtils.d {
        final /* synthetic */ long f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;
        final /* synthetic */ wv1 j;

        a(long j, int i, int i2, int i3, wv1 wv1Var) {
            this.f = j;
            this.g = i;
            this.h = i2;
            this.i = i3;
            this.j = wv1Var;
        }

        /* JADX WARN: Code duplicated, block: B:45:0x0196 A[Catch: all -> 0x003e, Exception -> 0x0041, PHI: r3
          0x0196: PHI (r3v6 java.lang.String) = (r3v5 java.lang.String), (r3v10 java.lang.String), (r3v10 java.lang.String) binds: [B:35:0x0174, B:41:0x018d, B:43:0x0193] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {Exception -> 0x0041, blocks: (B:3:0x0003, B:5:0x000a, B:18:0x0098, B:20:0x00a4, B:21:0x0123, B:23:0x0131, B:24:0x0135, B:26:0x0147, B:28:0x0154, B:30:0x015e, B:82:0x0269, B:34:0x016e, B:36:0x0176, B:38:0x017c, B:40:0x0185, B:42:0x018f, B:39:0x0181, B:45:0x0196, B:47:0x01a0, B:50:0x01ab, B:52:0x01b5, B:55:0x01c0, B:57:0x01ef, B:61:0x0206, B:63:0x020c, B:65:0x0216, B:69:0x0228, B:71:0x0232, B:81:0x024e, B:86:0x027f, B:90:0x028a, B:11:0x0044, B:16:0x006f, B:15:0x004d), top: B:112:0x0003, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:57:0x01ef A[Catch: all -> 0x003e, Exception -> 0x0041, TryCatch #1 {Exception -> 0x0041, blocks: (B:3:0x0003, B:5:0x000a, B:18:0x0098, B:20:0x00a4, B:21:0x0123, B:23:0x0131, B:24:0x0135, B:26:0x0147, B:28:0x0154, B:30:0x015e, B:82:0x0269, B:34:0x016e, B:36:0x0176, B:38:0x017c, B:40:0x0185, B:42:0x018f, B:39:0x0181, B:45:0x0196, B:47:0x01a0, B:50:0x01ab, B:52:0x01b5, B:55:0x01c0, B:57:0x01ef, B:61:0x0206, B:63:0x020c, B:65:0x0216, B:69:0x0228, B:71:0x0232, B:81:0x024e, B:86:0x027f, B:90:0x028a, B:11:0x0044, B:16:0x006f, B:15:0x004d), top: B:112:0x0003, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:59:0x0202  */
        /* JADX WARN: Code duplicated, block: B:60:0x0204  */
        /* JADX WARN: Code duplicated, block: B:63:0x020c A[Catch: all -> 0x003e, Exception -> 0x0041, TryCatch #1 {Exception -> 0x0041, blocks: (B:3:0x0003, B:5:0x000a, B:18:0x0098, B:20:0x00a4, B:21:0x0123, B:23:0x0131, B:24:0x0135, B:26:0x0147, B:28:0x0154, B:30:0x015e, B:82:0x0269, B:34:0x016e, B:36:0x0176, B:38:0x017c, B:40:0x0185, B:42:0x018f, B:39:0x0181, B:45:0x0196, B:47:0x01a0, B:50:0x01ab, B:52:0x01b5, B:55:0x01c0, B:57:0x01ef, B:61:0x0206, B:63:0x020c, B:65:0x0216, B:69:0x0228, B:71:0x0232, B:81:0x024e, B:86:0x027f, B:90:0x028a, B:11:0x0044, B:16:0x006f, B:15:0x004d), top: B:112:0x0003, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:65:0x0216 A[Catch: all -> 0x003e, Exception -> 0x0041, TryCatch #1 {Exception -> 0x0041, blocks: (B:3:0x0003, B:5:0x000a, B:18:0x0098, B:20:0x00a4, B:21:0x0123, B:23:0x0131, B:24:0x0135, B:26:0x0147, B:28:0x0154, B:30:0x015e, B:82:0x0269, B:34:0x016e, B:36:0x0176, B:38:0x017c, B:40:0x0185, B:42:0x018f, B:39:0x0181, B:45:0x0196, B:47:0x01a0, B:50:0x01ab, B:52:0x01b5, B:55:0x01c0, B:57:0x01ef, B:61:0x0206, B:63:0x020c, B:65:0x0216, B:69:0x0228, B:71:0x0232, B:81:0x024e, B:86:0x027f, B:90:0x028a, B:11:0x0044, B:16:0x006f, B:15:0x004d), top: B:112:0x0003, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:67:0x0225  */
        /* JADX WARN: Code duplicated, block: B:68:0x0226  */
        /* JADX WARN: Code duplicated, block: B:71:0x0232 A[Catch: all -> 0x003e, Exception -> 0x0041, TryCatch #1 {Exception -> 0x0041, blocks: (B:3:0x0003, B:5:0x000a, B:18:0x0098, B:20:0x00a4, B:21:0x0123, B:23:0x0131, B:24:0x0135, B:26:0x0147, B:28:0x0154, B:30:0x015e, B:82:0x0269, B:34:0x016e, B:36:0x0176, B:38:0x017c, B:40:0x0185, B:42:0x018f, B:39:0x0181, B:45:0x0196, B:47:0x01a0, B:50:0x01ab, B:52:0x01b5, B:55:0x01c0, B:57:0x01ef, B:61:0x0206, B:63:0x020c, B:65:0x0216, B:69:0x0228, B:71:0x0232, B:81:0x024e, B:86:0x027f, B:90:0x028a, B:11:0x0044, B:16:0x006f, B:15:0x004d), top: B:112:0x0003, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:74:0x0240  */
        /* JADX WARN: Code duplicated, block: B:80:0x024c  */
        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public ph1 d() {
            String str;
            Cursor cursorQuery;
            long j;
            int i;
            long j2;
            int i2;
            int i3;
            int i4;
            Cursor cursor = null;
            try {
                try {
                    if (ol2.b()) {
                        cursorQuery = qc1.this.a.getContentResolver().query(qc1.d, qc1.g, gi1.a(qc1.this.z(this.f), qc1.this.A(this.f), this.g, (this.h - 1) * this.i), null);
                    } else {
                        if (this.h == -1) {
                            str = "_id DESC";
                        } else {
                            str = "_id DESC limit " + this.g + " offset " + ((this.h - 1) * this.i);
                        }
                        cursorQuery = qc1.this.a.getContentResolver().query(qc1.d, qc1.g, qc1.this.z(this.f), qc1.this.A(this.f), str);
                    }
                    cursor = cursorQuery;
                    if (cursor == null) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        return new ph1();
                    }
                    ArrayList arrayList = new ArrayList();
                    if (cursor.getCount() > 0) {
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(qc1.g[0]);
                        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow(qc1.g[1]);
                        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow(qc1.g[2]);
                        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow(qc1.g[3]);
                        int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow(qc1.g[4]);
                        int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow(qc1.g[5]);
                        int columnIndexOrThrow7 = cursor.getColumnIndexOrThrow(qc1.g[6]);
                        int columnIndexOrThrow8 = cursor.getColumnIndexOrThrow(qc1.g[7]);
                        int columnIndexOrThrow9 = cursor.getColumnIndexOrThrow(qc1.g[8]);
                        int columnIndexOrThrow10 = cursor.getColumnIndexOrThrow(qc1.g[9]);
                        int columnIndexOrThrow11 = cursor.getColumnIndexOrThrow(qc1.g[10]);
                        cursor.moveToFirst();
                        int i5 = columnIndexOrThrow2;
                        while (true) {
                            long j3 = cursor.getLong(columnIndexOrThrow);
                            String string = cursor.getString(columnIndexOrThrow3);
                            if (TextUtils.isEmpty(string)) {
                                string = a22.x();
                            }
                            String strA = string;
                            int i6 = i5;
                            int i7 = columnIndexOrThrow;
                            String string2 = cursor.getString(i6);
                            String strG = ol2.a() ? a22.g(j3, strA) : string2;
                            if (qc1.this.b.d1 && !s12.q(string2)) {
                                i2 = columnIndexOrThrow3;
                                i = columnIndexOrThrow4;
                                i3 = columnIndexOrThrow5;
                                i4 = columnIndexOrThrow6;
                            } else if (strA.endsWith("image/*")) {
                                strA = a22.h(strG) ? a22.a(string2) : a22.a(strG);
                                if (qc1.this.b.g0 || !a22.i(strA)) {
                                    if (qc1.this.b.h0) {
                                        int i8 = cursor.getInt(columnIndexOrThrow4);
                                        int i9 = cursor.getInt(columnIndexOrThrow5);
                                        j = cursor.getLong(columnIndexOrThrow6);
                                        int i10 = columnIndexOrThrow3;
                                        i = columnIndexOrThrow4;
                                        j2 = cursor.getLong(columnIndexOrThrow7);
                                        String string3 = cursor.getString(columnIndexOrThrow8);
                                        String string4 = cursor.getString(columnIndexOrThrow9);
                                        long j4 = cursor.getLong(columnIndexOrThrow10);
                                        i2 = i10;
                                        if (qc1.this.b.S > 0.0f) {
                                            i3 = columnIndexOrThrow5;
                                            if (j2 > qc1.this.b.S * 1048576.0f) {
                                                i4 = columnIndexOrThrow6;
                                            }
                                        } else {
                                            i3 = columnIndexOrThrow5;
                                        }
                                        if (a22.n(strA)) {
                                            if (qc1.this.b.I > 0) {
                                                i4 = columnIndexOrThrow6;
                                                if (j < qc1.this.b.I) {
                                                }
                                            } else {
                                                i4 = columnIndexOrThrow6;
                                            }
                                            if (qc1.this.b.H > 0) {
                                            }
                                        } else {
                                            i4 = columnIndexOrThrow6;
                                        }
                                        arrayList.add(LocalMedia.F(j3, strG, string2, string4, string3, j, qc1.this.b.a, strA, i8, i9, j2, j4, cursor.getLong(columnIndexOrThrow11)));
                                    } else {
                                        int i11 = cursor.getInt(columnIndexOrThrow4);
                                        int i12 = cursor.getInt(columnIndexOrThrow5);
                                        j = cursor.getLong(columnIndexOrThrow6);
                                        int i13 = columnIndexOrThrow3;
                                        i = columnIndexOrThrow4;
                                        j2 = cursor.getLong(columnIndexOrThrow7);
                                        String string5 = cursor.getString(columnIndexOrThrow8);
                                        String string6 = cursor.getString(columnIndexOrThrow9);
                                        long j5 = cursor.getLong(columnIndexOrThrow10);
                                        i2 = i13;
                                        if (qc1.this.b.S > 0.0f) {
                                            i3 = columnIndexOrThrow5;
                                            if (j2 > qc1.this.b.S * 1048576.0f) {
                                                i4 = columnIndexOrThrow6;
                                            }
                                        } else {
                                            i3 = columnIndexOrThrow5;
                                        }
                                        if (a22.n(strA)) {
                                            if (qc1.this.b.I > 0) {
                                                i4 = columnIndexOrThrow6;
                                                if (j < qc1.this.b.I) {
                                                }
                                            } else {
                                                i4 = columnIndexOrThrow6;
                                            }
                                            if (qc1.this.b.H > 0) {
                                            }
                                        } else {
                                            i4 = columnIndexOrThrow6;
                                        }
                                        arrayList.add(LocalMedia.F(j3, strG, string2, string6, string5, j, qc1.this.b.a, strA, i11, i12, j2, j5, cursor.getLong(columnIndexOrThrow11)));
                                    }
                                }
                                i2 = columnIndexOrThrow3;
                                i = columnIndexOrThrow4;
                                i3 = columnIndexOrThrow5;
                                i4 = columnIndexOrThrow6;
                            } else if ((qc1.this.b.h0 || !strA.startsWith(a22.z())) && (qc1.this.b.i0 || !strA.startsWith(a22.u()))) {
                                int i14 = cursor.getInt(columnIndexOrThrow4);
                                int i15 = cursor.getInt(columnIndexOrThrow5);
                                j = cursor.getLong(columnIndexOrThrow6);
                                int i16 = columnIndexOrThrow3;
                                i = columnIndexOrThrow4;
                                j2 = cursor.getLong(columnIndexOrThrow7);
                                String string7 = cursor.getString(columnIndexOrThrow8);
                                String string8 = cursor.getString(columnIndexOrThrow9);
                                long j6 = cursor.getLong(columnIndexOrThrow10);
                                i2 = i16;
                                if (qc1.this.b.S > 0.0f) {
                                    i3 = columnIndexOrThrow5;
                                    if (j2 > qc1.this.b.S * 1048576.0f) {
                                        i4 = columnIndexOrThrow6;
                                    }
                                } else {
                                    i3 = columnIndexOrThrow5;
                                }
                                if (a22.n(strA)) {
                                    if (qc1.this.b.I > 0) {
                                        i4 = columnIndexOrThrow6;
                                        if (j < qc1.this.b.I) {
                                        }
                                    } else {
                                        i4 = columnIndexOrThrow6;
                                    }
                                    if ((qc1.this.b.H > 0 || j <= qc1.this.b.H) && j != 0 && j2 > 0) {
                                    }
                                } else {
                                    i4 = columnIndexOrThrow6;
                                }
                                arrayList.add(LocalMedia.F(j3, strG, string2, string8, string7, j, qc1.this.b.a, strA, i14, i15, j2, j6, cursor.getLong(columnIndexOrThrow11)));
                            } else {
                                i2 = columnIndexOrThrow3;
                                i = columnIndexOrThrow4;
                                i3 = columnIndexOrThrow5;
                                i4 = columnIndexOrThrow6;
                            }
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            columnIndexOrThrow = i7;
                            i5 = i6;
                            columnIndexOrThrow4 = i;
                            columnIndexOrThrow3 = i2;
                            columnIndexOrThrow5 = i3;
                            columnIndexOrThrow6 = i4;
                        }
                    }
                    ph1 ph1Var = new ph1(cursor.getCount() > 0, arrayList);
                    if (!cursor.isClosed()) {
                        cursor.close();
                    }
                    return ph1Var;
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i(qc1.c, "loadMedia Page Data Error: " + e.getMessage());
                    ph1 ph1Var2 = new ph1();
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return ph1Var2;
                }
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(ph1 ph1Var) {
            PictureThreadUtils.e(PictureThreadUtils.j());
            wv1 wv1Var = this.j;
            if (wv1Var != null) {
                List arrayList = ph1Var.b;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                wv1Var.c(arrayList, this.h, ph1Var.a);
            }
        }
    }

    class b extends PictureThreadUtils.d {
        final /* synthetic */ wv1 f;

        b(wv1 wv1Var) {
            this.f = wv1Var;
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public LocalMediaFolder d() {
            return oj2.b(qc1.this.a, qc1.this.b.X0);
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

    class c extends PictureThreadUtils.d {
        final /* synthetic */ wv1 f;

        c(wv1 wv1Var) {
            this.f = wv1Var;
        }

        /* JADX WARN: Code duplicated, block: B:76:0x0258  */
        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public List d() throws Throwable {
            int iG;
            Cursor cursorQuery = qc1.this.a.getContentResolver().query(qc1.d, ol2.a() ? qc1.e : qc1.f, qc1.this.F(), qc1.this.G(), "_id DESC");
            try {
                if (cursorQuery != null) {
                    try {
                        int count = cursorQuery.getCount();
                        ArrayList arrayList = new ArrayList();
                        if (count > 0) {
                            try {
                                if (ol2.a()) {
                                    HashMap map = new HashMap();
                                    while (cursorQuery.moveToNext()) {
                                        long j = cursorQuery.getLong(cursorQuery.getColumnIndex("bucket_id"));
                                        Long l = (Long) map.get(Long.valueOf(j));
                                        map.put(Long.valueOf(j), l == null ? 1L : Long.valueOf(l.longValue() + 1));
                                    }
                                    if (cursorQuery.moveToFirst()) {
                                        HashSet hashSet = new HashSet();
                                        iG = 0;
                                        while (true) {
                                            long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("bucket_id"));
                                            if (!hashSet.contains(Long.valueOf(j2))) {
                                                LocalMediaFolder localMediaFolder = new LocalMediaFolder();
                                                localMediaFolder.m(j2);
                                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("bucket_display_name"));
                                                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("mime_type"));
                                                Long l2 = (Long) map.get(Long.valueOf(j2));
                                                long jLongValue = l2.longValue();
                                                long j3 = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
                                                localMediaFolder.x(string);
                                                localMediaFolder.v(db3.a(l2));
                                                localMediaFolder.s(a22.g(j3, string2));
                                                localMediaFolder.t(string2);
                                                arrayList.add(localMediaFolder);
                                                hashSet.add(Long.valueOf(j2));
                                                iG = (int) (((long) iG) + jLongValue);
                                            }
                                            if (!cursorQuery.moveToNext()) {
                                                break;
                                            }
                                            map = map;
                                        }
                                    } else {
                                        iG = 0;
                                    }
                                } else {
                                    cursorQuery.moveToFirst();
                                    int i = 0;
                                    do {
                                        LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
                                        long j4 = cursorQuery.getLong(cursorQuery.getColumnIndex("bucket_id"));
                                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("bucket_display_name"));
                                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("mime_type"));
                                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("count"));
                                        localMediaFolder2.m(j4);
                                        localMediaFolder2.s(cursorQuery.getString(cursorQuery.getColumnIndex("_data")));
                                        localMediaFolder2.x(string3);
                                        localMediaFolder2.t(string4);
                                        localMediaFolder2.v(i2);
                                        arrayList.add(localMediaFolder2);
                                        i += i2;
                                    } while (cursorQuery.moveToNext());
                                    iG = i;
                                }
                                LocalMediaFolder localMediaFolder3 = new LocalMediaFolder();
                                LocalMediaFolder localMediaFolderB = oj2.b(qc1.this.a, qc1.this.b.X0);
                                if (localMediaFolderB != null) {
                                    arrayList.add(localMediaFolderB);
                                    iG += localMediaFolderB.g();
                                    localMediaFolder3.r(localMediaFolderB.d());
                                    localMediaFolder3.s(localMediaFolderB.e());
                                    localMediaFolder3.t(localMediaFolderB.f());
                                } else if (cursorQuery.moveToFirst()) {
                                    localMediaFolder3.s(ol2.a() ? qc1.x(cursorQuery) : qc1.y(cursorQuery));
                                    localMediaFolder3.t(qc1.w(cursorQuery));
                                }
                                js2.e(arrayList);
                                localMediaFolder3.v(iG);
                                localMediaFolder3.o(true);
                                localMediaFolder3.m(-1L);
                                localMediaFolder3.x(qc1.this.b.a == a22.t() ? qc1.this.a.getString(R$string.picture_all_audio) : qc1.this.a.getString(R$string.picture_camera_roll));
                                localMediaFolder3.z(qc1.this.b.a);
                                localMediaFolder3.n(true);
                                arrayList.add(0, localMediaFolder3);
                                if (qc1.this.b.l1 && qc1.this.b.a == a22.s()) {
                                    qc1.this.O(arrayList);
                                }
                                if (!cursorQuery.isClosed()) {
                                    cursorQuery.close();
                                }
                                return arrayList;
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                Log.i(qc1.c, "loadAllMedia Data Error: " + e.getMessage());
                                if (!cursorQuery.isClosed()) {
                                    cursorQuery.close();
                                }
                                return new ArrayList();
                            } catch (Throwable th) {
                                th = th;
                                if (!cursorQuery.isClosed()) {
                                    cursorQuery.close();
                                }
                                throw th;
                            }
                        }
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } else if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return new ArrayList();
            } catch (Throwable th2) {
                th = th2;
            }
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

    public qc1(Context context, PictureSelectionConfig pictureSelectionConfig) {
        this.a = context;
        this.b = pictureSelectionConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] A(long j) {
        int i = this.b.a;
        if (i == 0) {
            return j == -1 ? new String[]{String.valueOf(1), String.valueOf(3)} : new String[]{String.valueOf(1), String.valueOf(3), db3.e(Long.valueOf(j))};
        }
        if (i == 1) {
            return K(1, j);
        }
        if (i == 2) {
            return K(3, j);
        }
        if (i != 3) {
            return null;
        }
        return K(2, j);
    }

    private static String B(long j, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str);
        sb.append(" OR ");
        sb.append("media_type");
        sb.append("=? AND ");
        sb.append(str2);
        sb.append(") AND ");
        if (j == -1) {
            sb.append(str3);
            return sb.toString();
        }
        sb.append("bucket_id");
        sb.append("=? AND ");
        sb.append(str3);
        return sb.toString();
    }

    private static String C(long j, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        if (j == -1) {
            sb.append(str);
            sb.append(") AND ");
            sb.append(str2);
            return sb.toString();
        }
        sb.append(str);
        sb.append(") AND ");
        sb.append("bucket_id");
        sb.append("=? AND ");
        sb.append(str2);
        return sb.toString();
    }

    private static String D(long j, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str);
        sb.append(" AND ");
        sb.append(str2);
        sb.append(") AND ");
        if (j == -1) {
            sb.append(str3);
            return sb.toString();
        }
        sb.append("bucket_id");
        sb.append("=? AND ");
        sb.append(str3);
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    /* JADX WARN: Code duplicated, block: B:38:0x008b  */
    private String E() {
        String str;
        HashSet<String> hashSet = this.b.J0;
        if (hashSet == null) {
            hashSet = new HashSet();
        }
        if (!TextUtils.isEmpty(this.b.o)) {
            hashSet.add(this.b.o);
        }
        StringBuilder sb = new StringBuilder();
        int i = -1;
        for (String str2 : hashSet) {
            if (!TextUtils.isEmpty(str2)) {
                if (this.b.a == a22.y()) {
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
                } else if (this.b.a == a22.w()) {
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
                } else if (this.b.a != a22.t() || (!str2.startsWith("video") && !str2.startsWith("image"))) {
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
        if (this.b.a != a22.y() && !this.b.g0 && !hashSet.contains(a22.v())) {
            sb.append(" AND (mime_type!='image/gif' AND mime_type!='image/*')");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F() {
        String strU = u();
        String strE = E();
        int i = this.b.a;
        if (i == 0) {
            return H(t(), strU, strE);
        }
        if (i == 1) {
            return J(strE, strU);
        }
        if (i == 2 || i == 3) {
            return M(strE, strU);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] G() {
        int i = this.b.a;
        if (i == 0) {
            return I();
        }
        if (i == 1) {
            return L(1);
        }
        if (i == 2) {
            return L(3);
        }
        if (i != 3) {
            return null;
        }
        return L(2);
    }

    private static String H(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str3);
        sb.append(" OR ");
        sb.append("media_type");
        sb.append("=? AND ");
        sb.append(str);
        sb.append(") AND ");
        sb.append(str2);
        if (ol2.a()) {
            return sb.toString();
        }
        sb.append(")");
        sb.append(" GROUP BY (bucket_id");
        return sb.toString();
    }

    private static String[] I() {
        return new String[]{String.valueOf(1), String.valueOf(3)};
    }

    private static String J(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (ol2.a()) {
            sb.append("media_type");
            sb.append("=?");
            sb.append(str);
            sb.append(" AND ");
            sb.append(str2);
            return sb.toString();
        }
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str);
        sb.append(") AND ");
        sb.append(str2);
        sb.append(")");
        sb.append(" GROUP BY (bucket_id");
        return sb.toString();
    }

    private static String[] K(int i, long j) {
        return j == -1 ? new String[]{String.valueOf(i)} : new String[]{String.valueOf(i), db3.e(Long.valueOf(j))};
    }

    private static String[] L(int i) {
        return new String[]{String.valueOf(i)};
    }

    private static String M(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (ol2.a()) {
            sb.append("media_type");
            sb.append("=?");
            sb.append(str);
            sb.append(" AND ");
            sb.append(str2);
            return sb.toString();
        }
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str);
        sb.append(") AND ");
        sb.append(str2);
        sb.append(")");
        sb.append(" GROUP BY (bucket_id");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(List list) throws Throwable {
        for (int i = 0; i < list.size(); i++) {
            LocalMediaFolder localMediaFolder = (LocalMediaFolder) list.get(i);
            if (localMediaFolder != null) {
                String strV = v(localMediaFolder.a());
                if (!TextUtils.isEmpty(strV)) {
                    localMediaFolder.s(strV);
                }
            }
        }
    }

    private String t() {
        PictureSelectionConfig pictureSelectionConfig = this.b;
        int i = pictureSelectionConfig.H;
        return String.format(Locale.CHINA, "%d <%s duration and duration <= %d", Long.valueOf(Math.max(0L, pictureSelectionConfig.I)), Math.max(0L, (long) this.b.I) == 0 ? Constants.STR_EMPTY : "=", Long.valueOf(i == 0 ? Long.MAX_VALUE : i));
    }

    private String u() {
        PictureSelectionConfig pictureSelectionConfig = this.b;
        long j = pictureSelectionConfig.T;
        if (j == 0) {
            j = Long.MAX_VALUE;
        }
        return String.format(Locale.CHINA, "%d <%s _size and _size <= %d", Long.valueOf(Math.max(0L, pictureSelectionConfig.U)), Math.max(0L, this.b.U) == 0 ? Constants.STR_EMPTY : "=", Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String w(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("mime_type"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String x(Cursor cursor) {
        return a22.g(cursor.getLong(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("mime_type")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String y(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("_data"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String z(long j) {
        String strT = t();
        String strU = u();
        String strE = E();
        int i = this.b.a;
        if (i == 0) {
            return B(j, strE, strT, strU);
        }
        if (i == 1) {
            return C(j, strE, strU);
        }
        if (i == 2 || i == 3) {
            return D(j, strE, strT, strU);
        }
        return null;
    }

    public void N(long j, int i, int i2, int i3, wv1 wv1Var) {
        PictureThreadUtils.h(new a(j, i2, i, i3, wv1Var));
    }

    @Override // defpackage.cy0
    public void a(wv1 wv1Var) {
        PictureThreadUtils.h(new c(wv1Var));
    }

    @Override // defpackage.cy0
    public void b(wv1 wv1Var) {
        PictureThreadUtils.h(new b(wv1Var));
    }

    @Override // defpackage.cy0
    public void c(long j, int i, int i2, wv1 wv1Var) {
        N(j, i, i2, this.b.b1, wv1Var);
    }

    @Override // defpackage.cy0
    public void d(long j, int i, wv1 wv1Var) {
        int i2 = this.b.b1;
        N(j, i, i2, i2, wv1Var);
    }

    public String v(long j) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        Cursor cursor2 = null;
        try {
            if (ol2.b()) {
                cursorQuery = this.a.getContentResolver().query(d, new String[]{"_id", "mime_type", "_data"}, gi1.a(z(j), A(j), 1, 0), null);
            } else {
                cursorQuery = this.a.getContentResolver().query(d, new String[]{"_id", "mime_type", "_data"}, z(j), A(j), "_id DESC limit 1 offset 0");
            }
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        if (!cursorQuery.moveToFirst()) {
                            if (!cursorQuery.isClosed()) {
                                cursorQuery.close();
                            }
                            return null;
                        }
                        String strG = ol2.a() ? a22.g(cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id")), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("mime_type"))) : cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        if (!cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                        return strG;
                    }
                } catch (Exception e2) {
                    cursor = cursorQuery;
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    cursor2 = cursorQuery;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
        return null;
    }
}
