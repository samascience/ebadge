package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.legend.smartwatch.app.base.acitivity.BaseActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import defpackage.cr2;
import defpackage.da1;
import defpackage.dg;
import defpackage.ea1;
import defpackage.h4;
import defpackage.k83;
import defpackage.p31;
import defpackage.pr0;
import defpackage.y70;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SelectLanguageActivity;

/* JADX INFO: loaded from: classes4.dex */
public final class SelectLanguageActivity extends BaseActivity<h4> {
    public static final a o = new a(null);
    private final da1 k;
    private final List l;
    private final List m;
    private int n;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String string;
            String string2;
            if (charSequence == null || (string2 = charSequence.toString()) == null || (string = kotlin.text.i.O0(string2).toString()) == null) {
                string = Constants.STR_EMPTY;
            }
            SelectLanguageActivity.this.Z(string);
        }
    }

    public SelectLanguageActivity() {
        super(R.layout.activity_select_language);
        this.k = new da1();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(String str) {
        this.m.clear();
        if (str.length() == 0) {
            this.m.addAll(this.l);
        } else {
            for (ea1 ea1Var : this.l) {
                if (kotlin.text.i.K(ea1Var.a(), str, true) || kotlin.text.i.K(ea1Var.b(), str, true)) {
                    this.m.add(ea1Var);
                }
            }
        }
        this.k.j(this.m);
    }

    private final void a0() {
        List listI;
        cr2 cr2Var;
        String strC;
        this.l.clear();
        if (this.n == 1002) {
            String stringExtra = getIntent().getStringExtra("source_language");
            listI = (stringExtra == null || kotlin.text.i.Y(stringExtra) || (strC = (cr2Var = cr2.a).c(stringExtra)) == null) ? kotlin.collections.j.j() : cr2Var.j(strC);
        } else {
            listI = cr2.a.i();
        }
        Iterator it = listI.iterator();
        while (it.hasNext()) {
            ea1 ea1VarK = cr2.a.k((String) it.next());
            if (ea1VarK != null) {
                this.l.add(ea1VarK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 b0(SelectLanguageActivity selectLanguageActivity, ea1 ea1Var, int i, View view) {
        p31.f(ea1Var, "item");
        p31.f(view, "<unused var>");
        Intent intent = new Intent();
        intent.putExtra("selected_language", ea1Var.b());
        intent.putExtra("request_code", selectLanguageActivity.n);
        selectLanguageActivity.setResult(-1, intent);
        selectLanguageActivity.finish();
        return k83.a;
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void N(Bundle bundle) {
        super.N(bundle);
        setTitle(getString(R.string.simultaneous_translation_select_language));
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        super.initData(bundle);
        this.n = getIntent().getIntExtra("request_code", -1);
        a0();
        RecyclerView recyclerView = ((h4) I()).z;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(this.k);
        this.m.addAll(this.l);
        this.k.j(this.m);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initListener() {
        super.initListener();
        ((h4) I()).F.addTextChangedListener(new b());
        dg.a(this.k, new pr0() { // from class: lm2
            @Override // defpackage.pr0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SelectLanguageActivity.b0(this.a, (ea1) obj, ((Integer) obj2).intValue(), (View) obj3);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        finish();
        return true;
    }
}
