package androidx.camera.camera2;

import android.content.Context;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.camera2.internal.j;
import androidx.camera.camera2.internal.k1;
import androidx.camera.camera2.internal.m1;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.k;
import defpackage.st;
import defpackage.ut;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class Camera2Config {

    public static final class DefaultProvider implements k.b {
        @Override // androidx.camera.core.k.b
        public k getCameraXConfig() {
            return Camera2Config.c();
        }
    }

    public static k c() {
        ut.a aVar = new ut.a() { // from class: ur
            @Override // ut.a
            public final ut a(Context context, wu wuVar, tu tuVar, long j) {
                return new j(context, wuVar, tuVar, j);
            }
        };
        st.a aVar2 = new st.a() { // from class: vr
            @Override // st.a
            public final st a(Context context, Object obj, Set set) {
                return Camera2Config.d(context, obj, set);
            }
        };
        return new k.a().c(aVar).d(aVar2).g(new UseCaseConfigFactory.b() { // from class: wr
            @Override // androidx.camera.core.impl.UseCaseConfigFactory.b
            public final UseCaseConfigFactory a(Context context) {
                return Camera2Config.e(context);
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ st d(Context context, Object obj, Set set) throws InitializationException {
        try {
            return new k1(context, obj, set);
        } catch (CameraUnavailableException e) {
            throw new InitializationException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UseCaseConfigFactory e(Context context) {
        return new m1(context);
    }
}
