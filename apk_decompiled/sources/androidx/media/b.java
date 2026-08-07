package androidx.media;

import android.content.Context;
import android.service.media.MediaBrowserService;

/* JADX INFO: loaded from: classes.dex */
abstract class b extends a.b {
    b(Context context, c cVar) {
        super(context, cVar);
    }

    @Override // android.service.media.MediaBrowserService
    public void onLoadItem(String str, MediaBrowserService.Result result) {
        ((c) this.a).b(str, new a.c(result));
    }
}
