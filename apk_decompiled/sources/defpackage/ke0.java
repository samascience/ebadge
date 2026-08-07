package defpackage;

import android.hardware.camera2.params.DynamicRangeProfiles;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class ke0 {
    private static final Map a;
    private static final Map b;

    static {
        HashMap map = new HashMap();
        a = map;
        HashMap map2 = new HashMap();
        b = map2;
        ie0 ie0Var = ie0.d;
        map.put(1L, ie0Var);
        map2.put(ie0Var, Collections.singletonList(1L));
        map.put(2L, ie0.f);
        map2.put((ie0) map.get(2L), Collections.singletonList(2L));
        ie0 ie0Var2 = ie0.g;
        map.put(4L, ie0Var2);
        map2.put(ie0Var2, Collections.singletonList(4L));
        ie0 ie0Var3 = ie0.h;
        map.put(8L, ie0Var3);
        map2.put(ie0Var3, Collections.singletonList(8L));
        List listAsList = Arrays.asList(64L, 128L, 16L, 32L);
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            a.put((Long) it.next(), ie0.i);
        }
        b.put(ie0.i, listAsList);
        List listAsList2 = Arrays.asList(Long.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID), Long.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH), 256L, 512L);
        Iterator it2 = listAsList2.iterator();
        while (it2.hasNext()) {
            a.put((Long) it2.next(), ie0.j);
        }
        b.put(ie0.j, listAsList2);
    }

    public static Long a(ie0 ie0Var, DynamicRangeProfiles dynamicRangeProfiles) {
        List<Long> list = (List) b.get(ie0Var);
        if (list == null) {
            return null;
        }
        Set supportedProfiles = dynamicRangeProfiles.getSupportedProfiles();
        for (Long l : list) {
            if (supportedProfiles.contains(l)) {
                return l;
            }
        }
        return null;
    }

    public static ie0 b(long j) {
        return (ie0) a.get(Long.valueOf(j));
    }
}
