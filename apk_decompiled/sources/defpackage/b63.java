package defpackage;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b63 implements s20, tg.a {
    private final String a;
    private final List b = new ArrayList();
    private final ShapeTrimPath.Type c;
    private final tg d;
    private final tg e;
    private final tg f;

    public b63(a aVar, ShapeTrimPath shapeTrimPath) {
        this.a = shapeTrimPath.c();
        this.c = shapeTrimPath.f();
        tg tgVarA = shapeTrimPath.e().a();
        this.d = tgVarA;
        tg tgVarA2 = shapeTrimPath.b().a();
        this.e = tgVarA2;
        tg tgVarA3 = shapeTrimPath.d().a();
        this.f = tgVarA3;
        aVar.i(tgVarA);
        aVar.i(tgVarA2);
        aVar.i(tgVarA3);
        tgVarA.a(this);
        tgVarA2.a(this);
        tgVarA3.a(this);
    }

    @Override // tg.a
    public void a() {
        for (int i = 0; i < this.b.size(); i++) {
            ((tg.a) this.b.get(i)).a();
        }
    }

    @Override // defpackage.s20
    public void b(List list, List list2) {
    }

    void e(tg.a aVar) {
        this.b.add(aVar);
    }

    public tg f() {
        return this.e;
    }

    public tg g() {
        return this.f;
    }

    public tg i() {
        return this.d;
    }

    ShapeTrimPath.Type j() {
        return this.c;
    }
}
