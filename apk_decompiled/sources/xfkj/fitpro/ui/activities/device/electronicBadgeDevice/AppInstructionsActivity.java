package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.iwellfitness.urllib.WebViewActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes4.dex */
public class AppInstructionsActivity extends WebViewActivity {
    WebView a;
    TextView b;
    private String c;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(View view) {
        finish();
    }

    private void J() {
        this.b.setVisibility(0);
        this.a.setVisibility(8);
    }

    private void K() {
        this.b.setVisibility(8);
        this.a.setVisibility(0);
    }

    @Override // com.iwellfitness.urllib.WebViewActivity
    public int getLayoutId() {
        return R.layout.activity_app_instructions;
    }

    @Override // com.iwellfitness.urllib.WebViewActivity
    public String getUrl() {
        return this.c;
    }

    @Override // com.iwellfitness.urllib.WebViewActivity
    public WebView getWebView() {
        return this.a;
    }

    @Override // com.iwellfitness.urllib.WebViewActivity
    public void initData() {
        Intent intent = getIntent();
        this.c = intent.getStringExtra(SocialConstants.PARAM_URL);
        String stringExtra = intent.getStringExtra("title");
        if (stringExtra == null || stringExtra.isEmpty()) {
            setTitle(getString(R.string.instruction));
        } else {
            setTitle(stringExtra);
        }
        if (this.c != null) {
            K();
        } else {
            J();
        }
    }

    @Override // com.iwellfitness.urllib.WebViewActivity
    public void initListener() {
        ((ImageView) findViewById(R.id.app_instructions_title).findViewById(R.id.img_back)).setOnClickListener(new View.OnClickListener() { // from class: b9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.I(view);
            }
        });
    }

    @Override // com.iwellfitness.urllib.WebViewActivity
    protected void initViews() {
        this.a = (WebView) findViewById(R.id.app_instructions_webView);
        this.b = (TextView) findViewById(R.id.no_instructions_textView);
    }

    @Override // com.iwellfitness.urllib.WebViewActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initListener();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        WebView webView = this.a;
        if (webView != null) {
            webView.stopLoading();
            this.a.destroy();
        }
        super.onDestroy();
    }
}
