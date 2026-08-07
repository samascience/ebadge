package defpackage;

import android.content.Context;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface st {

    public interface a {
        st a(Context context, Object obj, Set set);
    }

    Pair a(int i, String str, List list, Map map, boolean z);

    SurfaceConfig b(int i, String str, int i2, Size size);
}
