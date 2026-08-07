package xfkj.fitpro.ui.activities.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import com.legend.smartwatch.app.base.acitivity.BaseActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.fa1;
import defpackage.l4;
import defpackage.o7;

/* JADX INFO: loaded from: classes4.dex */
public class UserProtocolActivity extends BaseActivity<l4> {
    WebView k;
    View l;

    public UserProtocolActivity() {
        super(R.layout.activity_user_protocol);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(View view) {
        finish();
    }

    public static void Z(Context context, boolean z) {
        Intent intent = new Intent(context, (Class<?>) UserProtocolActivity.class);
        intent.putExtra("is_privacy", z);
        context.startActivity(intent);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public int H() {
        return R.color.white;
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void N(Bundle bundle) {
        super.N(bundle);
        this.k = (WebView) findViewById(R.id.webview);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        this.l = findViewById(R.id.user_protocol_title);
        if (!getIntent().getBooleanExtra("is_privacy", false)) {
            this.k.loadUrl(getString(R.string.user_protocol_url));
            setTitle(getString(R.string.user_protocol));
        } else {
            if (fa1.c()) {
                this.k.loadUrl(o7.a);
            } else {
                this.k.loadUrl(o7.b);
            }
            setTitle(getString(R.string.private_protocol));
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initListener() {
        ImageView imageView = (ImageView) this.l.findViewById(R.id.img_back);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ia3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.Y(view);
                }
            });
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.k.stopLoading();
        super.onDestroy();
    }
}
