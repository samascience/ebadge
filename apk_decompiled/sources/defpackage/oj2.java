package defpackage;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class oj2 {

    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.isDirectory();
        }
    }

    public static List a(Context context, String str) {
        File[] fileArrListFiles;
        long jA;
        int iB;
        int i;
        int iW;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        if (!file.exists() || (fileArrListFiles = file.listFiles(new a())) == null) {
            return arrayList;
        }
        for (File file2 : fileArrListFiles) {
            String absolutePath = file2.getAbsolutePath();
            long length = file2.length();
            String strF = a22.f(context, Uri.fromFile(file2));
            String name = file2.getParentFile() != null ? file2.getParentFile().getName() : Constants.STR_EMPTY;
            long jC = db3.c(Integer.valueOf(name.hashCode()));
            long jLastModified = file2.lastModified() / 1000;
            if (a22.n(strF)) {
                qh1 qh1VarH = gi1.h(context, absolutePath);
                int iC = qh1VarH.c();
                int iB2 = qh1VarH.b();
                jA = qh1VarH.a();
                iW = a22.y();
                i = iC;
                iB = iB2;
            } else {
                qh1 qh1VarG = gi1.g(context, absolutePath);
                int iC2 = qh1VarG.c();
                jA = 0;
                iB = qh1VarG.b();
                i = iC2;
                iW = a22.w();
            }
            LocalMedia localMediaF = LocalMedia.F(jLastModified, absolutePath, absolutePath, file2.getName(), name, jA, iW, strF, i, iB, length, jC, jLastModified);
            localMediaF.H(ol2.a() ? absolutePath : null);
            arrayList.add(localMediaF);
        }
        return arrayList;
    }

    public static LocalMediaFolder b(Context context, String str) {
        List listA = a(context, str);
        if (listA == null || listA.size() <= 0) {
            return null;
        }
        js2.f(listA);
        LocalMedia localMedia = (LocalMedia) listA.get(0);
        LocalMediaFolder localMediaFolder = new LocalMediaFolder();
        localMediaFolder.x(localMedia.p());
        localMediaFolder.s(localMedia.q());
        localMediaFolder.t(localMedia.n());
        localMediaFolder.m(localMedia.b());
        localMediaFolder.v(listA.size());
        localMediaFolder.r(listA);
        return localMediaFolder;
    }
}
