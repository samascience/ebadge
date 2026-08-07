package androidx.camera.core;

import defpackage.ar0;
import defpackage.e43;
import defpackage.k83;
import defpackage.p31;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes.dex */
final class ImageCaptureExtKt$takePicture$4$2 extends Lambda implements ar0 {
    final /* synthetic */ Ref$ObjectRef<Object> $delegatingCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ImageCaptureExtKt$takePicture$4$2(Ref$ObjectRef<Object> ref$ObjectRef) {
        super(1);
        this.$delegatingCallback = ref$ObjectRef;
    }

    @Override // defpackage.ar0
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return k83.a;
    }

    public final void invoke(Throwable th) {
        Object obj = this.$delegatingCallback.element;
        if (obj == null) {
            p31.t("delegatingCallback");
        } else {
            e43.a(obj);
        }
        throw null;
    }
}
