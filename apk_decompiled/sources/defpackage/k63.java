package defpackage;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.fasterxml.classmate.AnnotationInclusion;
import com.fasterxml.classmate.MemberResolver;
import com.fasterxml.classmate.TypeResolver;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class k63 {
    protected static final Predicate e = new Predicate() { // from class: j63
        @Override // java.util.function.Predicate
        public final boolean test(Object obj) {
            return k63.b((Annotation) obj);
        }
    };
    private final TypeResolver a;
    private final MemberResolver b;
    private final AnnotationConfiguration c;
    private final boolean d;

    public k63(AnnotationConfiguration annotationConfiguration) {
        this(annotationConfiguration, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean b(Annotation annotation) {
        return false;
    }

    public k63(AnnotationConfiguration annotationConfiguration, vk2 vk2Var) {
        this(annotationConfiguration, vk2Var.a());
        if (annotationConfiguration instanceof AnnotationConfiguration.StdConfiguration) {
            Map mapB = vk2Var.b();
            final AnnotationConfiguration.StdConfiguration stdConfiguration = (AnnotationConfiguration.StdConfiguration) annotationConfiguration;
            Objects.requireNonNull(stdConfiguration);
            mapB.forEach(new BiConsumer() { // from class: i63
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    stdConfiguration.setInclusion((Class) obj, (AnnotationInclusion) obj2);
                }
            });
        }
    }

    private k63(AnnotationConfiguration annotationConfiguration, boolean z) {
        TypeResolver typeResolver = new TypeResolver();
        this.a = typeResolver;
        this.b = new MemberResolver(typeResolver);
        this.c = annotationConfiguration;
        this.d = z;
    }
}
