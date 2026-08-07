package defpackage;

import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.x;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ru {
    private final Object a = new Object();
    private final Map b = new LinkedHashMap();
    private final Set c = new HashSet();

    public LinkedHashSet a() {
        LinkedHashSet linkedHashSet;
        synchronized (this.a) {
            linkedHashSet = new LinkedHashSet(this.b.values());
        }
        return linkedHashSet;
    }

    public void b(ut utVar) {
        synchronized (this.a) {
            try {
                for (String str : utVar.a()) {
                    x.a("CameraRepository", "Added camera: " + str);
                    this.b.put(str, utVar.b(str));
                }
            } catch (CameraUnavailableException e) {
                throw new InitializationException(e);
            }
        }
    }
}
