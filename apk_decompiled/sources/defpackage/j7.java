package defpackage;

import javax.annotation.processing.AbstractProcessor;

/* JADX INFO: loaded from: classes4.dex */
public class j7 extends AbstractProcessor {
    private final AbstractProcessor a = a();

    private static AbstractProcessor a() {
        try {
            return (AbstractProcessor) lf1.a().loadClass("lombok.core.AnnotationProcessor").getDeclaredConstructor(null).newInstance(null);
        } catch (Throwable th) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw new RuntimeException(th);
        }
    }
}
