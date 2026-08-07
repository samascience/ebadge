package defpackage;

import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class js2 {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int c(LocalMediaFolder localMediaFolder, LocalMediaFolder localMediaFolder2) {
        if (localMediaFolder.d() == null || localMediaFolder2.d() == null) {
            return 0;
        }
        return Integer.compare(localMediaFolder2.g(), localMediaFolder.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int d(LocalMedia localMedia, LocalMedia localMedia2) {
        return Long.compare(localMedia2.j(), localMedia.j());
    }

    public static void e(List list) {
        Collections.sort(list, new Comparator() { // from class: hs2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return js2.c((LocalMediaFolder) obj, (LocalMediaFolder) obj2);
            }
        });
    }

    public static void f(List list) {
        Collections.sort(list, new Comparator() { // from class: is2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return js2.d((LocalMedia) obj, (LocalMedia) obj2);
            }
        });
    }
}
