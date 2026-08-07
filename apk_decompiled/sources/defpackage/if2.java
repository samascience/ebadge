package defpackage;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;

/* JADX INFO: loaded from: classes.dex */
public interface if2 {
    boolean onLoadFailed(GlideException glideException, Object obj, j03 j03Var, boolean z);

    boolean onResourceReady(Object obj, Object obj2, j03 j03Var, DataSource dataSource, boolean z);
}
