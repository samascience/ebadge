package defpackage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.a;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class kh {
    protected final JavaType a;

    protected kh(JavaType javaType) {
        this.a = javaType;
    }

    public JavaType A() {
        return this.a;
    }

    public abstract boolean B();

    public abstract Object C(boolean z);

    public boolean D() {
        return t().m();
    }

    public abstract AnnotatedMember a();

    public abstract AnnotatedMember b();

    public abstract List c();

    public abstract AnnotatedConstructor d();

    public abstract Class[] e();

    public abstract f40 f();

    public abstract JsonFormat.Value g(JsonFormat.Value value);

    public abstract Map h();

    public abstract AnnotatedMember i();

    public abstract AnnotatedMember j();

    public abstract AnnotatedMethod k();

    public abstract AnnotatedMethod l(String str, Class[] clsArr);

    public abstract Class m();

    public abstract q61.a n();

    public abstract List o();

    public abstract JsonInclude.Value p(JsonInclude.Value value);

    public abstract f40 q();

    public Class r() {
        return this.a.getRawClass();
    }

    public abstract l7 s();

    public abstract a t();

    public abstract List u();

    public abstract List v();

    public abstract List w();

    public abstract List x();

    public abstract Set y();

    public abstract lt1 z();
}
