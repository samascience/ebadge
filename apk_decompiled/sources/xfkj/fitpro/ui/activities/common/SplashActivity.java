package xfkj.fitpro.ui.activities.common;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.c;
import com.legend.smartwatch.app.base.acitivity.BaseActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.hg;
import defpackage.zm1;
import xfkj.fitpro.application.MyApplication;
import xfkj.fitpro.ui.activities.common.SplashActivity;

/* JADX INFO: loaded from: classes4.dex */
public class SplashActivity extends WelcomeActivity {

    class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            UserProtocolActivity.Z(((BaseActivity) SplashActivity.this).f, false);
        }
    }

    class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            UserProtocolActivity.Z(((BaseActivity) SplashActivity.this).f, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j0(androidx.appcompat.app.b bVar, View view) {
        bVar.dismiss();
        c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(androidx.appcompat.app.b bVar, View view) {
        zm1.Z();
        bVar.dismiss();
        ((MyApplication) hg.l()).z();
        m0();
    }

    private void m0() {
        a0(0);
    }

    public boolean i0() {
        return true;
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        super.initData(bundle);
        hg.i = 1;
        if (!i0()) {
            m0();
        } else if (zm1.E()) {
            m0();
        } else {
            l0();
        }
    }

    public void l0() {
        try {
            androidx.appcompat.app.b.a aVar = new androidx.appcompat.app.b.a(this.f);
            aVar.d(false);
            final androidx.appcompat.app.b bVarA = aVar.a();
            bVarA.show();
            bVarA.addContentView(LayoutInflater.from(this.f).inflate(R.layout.layout_dialog_permission, (ViewGroup) null), new LinearLayout.LayoutParams(-1, -1));
            TextView textView = (TextView) bVarA.findViewById(R.id.tv_content);
            String str = "《" + getString(R.string.user_protocol) + "》";
            String str2 = "《" + getString(R.string.private_protocol) + "》";
            SpannableString spannableString = new SpannableString(getString(R.string.permission_tips_content, str, str2));
            int iIndexOf = spannableString.toString().indexOf(str);
            spannableString.setSpan(new a(), iIndexOf, str.length() + iIndexOf, 17);
            int iIndexOf2 = spannableString.toString().indexOf(str2);
            spannableString.setSpan(new b(), iIndexOf2, str2.length() + iIndexOf2, 17);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            bVarA.findViewById(R.id.cancel_button).setOnClickListener(new View.OnClickListener() { // from class: ps2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SplashActivity.j0(bVarA, view);
                }
            });
            bVarA.findViewById(R.id.confirm_button).setOnClickListener(new View.OnClickListener() { // from class: qs2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.k0(bVarA, view);
                }
            });
            Window window = bVarA.getWindow();
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.95d);
            attributes.gravity = 17;
            window.setAttributes(attributes);
        } catch (Exception unused) {
            a0(0);
        }
    }
}
