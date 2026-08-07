package com.iwellfitness.urllib;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class WebViewActivity extends AppCompatActivity {
    private final Set<String> internalDomainWhitelist = new HashSet(Arrays.asList("iwellfitness.com", "adsplus.cn"));
    private WebView webView;

    private void initWebView() {
        this.webView = getWebView();
        CookieManager.getInstance().setAcceptThirdPartyCookies(this.webView, true);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.iwellfitness.urllib.WebViewActivity.1
            private boolean isDomainMatchingWhitelist(String str) {
                if (str == null) {
                    return false;
                }
                for (String str2 : WebViewActivity.this.internalDomainWhitelist) {
                    if (str.equals(str2)) {
                        return true;
                    }
                    if (str.endsWith(FileUtils.FILE_EXTENSION_SEPARATOR + str2)) {
                        return true;
                    }
                }
                return false;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                if (webResourceRequest.getUrl().getHost() == null && webResourceRequest.getUrl().getScheme() == null) {
                    return false;
                }
                if (!webResourceRequest.getUrl().getScheme().equals("http") && !webResourceRequest.getUrl().getScheme().equals("https")) {
                    try {
                        WebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", webResourceRequest.getUrl()));
                    } catch (ActivityNotFoundException unused) {
                        Log.d("TAG", "Failed to load URL with scheme:" + webResourceRequest.getUrl().getScheme());
                    }
                    return true;
                }
                String host = webResourceRequest.getUrl().getHost();
                if (isDomainMatchingWhitelist(host)) {
                    return false;
                }
                try {
                    if (new URI(webView.getUrl()).toURL().getHost().equals(host)) {
                        return false;
                    }
                    new CustomTabsIntent.Builder().build().launchUrl(WebViewActivity.this, webResourceRequest.getUrl());
                    return true;
                } catch (MalformedURLException | URISyntaxException unused2) {
                    return false;
                }
            }
        });
        this.webView.loadUrl(getUrl());
    }

    protected abstract int getLayoutId();

    public abstract String getUrl();

    public abstract WebView getWebView();

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void initViews();

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutId());
        initViews();
        initListener();
        initData();
        initWebView();
    }
}
