package defpackage;

import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes4.dex */
public interface i40 {
    public static final a a = a.a;
    public static final i40 b = new a.C0131a();

    public static final class a {
        static final /* synthetic */ a a = new a();

        /* JADX INFO: renamed from: i40$a$a, reason: collision with other inner class name */
        private static final class C0131a implements i40 {
            @Override // defpackage.i40
            public void a(tx0 tx0Var, List list) {
                p31.f(tx0Var, SocialConstants.PARAM_URL);
                p31.f(list, "cookies");
            }

            @Override // defpackage.i40
            public List b(tx0 tx0Var) {
                p31.f(tx0Var, SocialConstants.PARAM_URL);
                return j.j();
            }
        }

        private a() {
        }
    }

    void a(tx0 tx0Var, List list);

    List b(tx0 tx0Var);
}
