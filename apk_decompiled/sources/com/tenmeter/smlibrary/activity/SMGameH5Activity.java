package com.tenmeter.smlibrary.activity;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baji.network.config.NetworkConfig;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.listener.IDownloadLister;
import com.tenmeter.smlibrary.manager.CacheDirectoryManager;
import com.tenmeter.smlibrary.server.H5GameServer;
import com.tenmeter.smlibrary.utils.DownloadTask;
import com.tenmeter.smlibrary.utils.ExecutorUtil;
import com.tenmeter.smlibrary.utils.FileUtils;
import com.tenmeter.smlibrary.utils.KLog;
import com.tenmeter.smlibrary.utils.MD5;
import com.tenmeter.smlibrary.utils.PreferencesUtils;
import com.tenmeter.smlibrary.utils.SMGameClient;
import com.tenmeter.smlibrary.utils.Utils;
import com.tenmeter.smlibrary.utils.ZipUtils;
import defpackage.q30;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SMGameH5Activity extends Activity {
    private ImageView backImg;
    private Thread downLoadThread;
    private View loadingBg;
    private FrameLayout loadingLayout;
    private View loadingProgressBg;
    private View portraitLoadingBg;
    private FrameLayout portraitLoadingLayout;
    private View portraitLoadingProgressBg;
    private DownloadTask task;
    private TextView tv_data;
    private TextView tv_portraitProgress;
    private TextView tv_progress;
    private ImageView vv_loading_hulu;
    private ImageView vv_loading_hulu_portrait;
    private WebView wb_common;
    SMGameInfo game = null;
    H5GameServer myServer = null;
    private int oldProgress = 0;
    private int huluMarginLeft = 0;
    private int screenWidth = 0;

    /* JADX INFO: renamed from: com.tenmeter.smlibrary.activity.SMGameH5Activity$6, reason: invalid class name */
    class AnonymousClass6 implements IDownloadLister {
        AnonymousClass6() {
        }

        @Override // com.tenmeter.smlibrary.listener.IDownloadLister
        public void onError(final String str) {
            SMGameH5Activity.this.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.6.2
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(SMGameH5Activity.this, str, 1).show();
                }
            });
            KLog.i("onDownloadSuccess:....... ..................文件下载失败.............................." + str);
        }

        @Override // com.tenmeter.smlibrary.listener.IDownloadLister
        public void onFinish(String str) {
            SMGameH5Activity.this.changeProgress(100);
            if (SMGameH5Activity.this.game.getVertical() == 2) {
                SMGameH5Activity.this.tv_progress.setText("100%");
            } else {
                SMGameH5Activity.this.tv_portraitProgress.setText("100%");
            }
            KLog.i("onDownloadSuccess:....... ..................文件下载成功..............................");
            new Thread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.6.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ZipUtils.UnZipFolder(CacheDirectoryManager.getExternCacheFileRootPath(SMGameH5Activity.this) + "/h5-game-" + SMGameH5Activity.this.game.getGid() + "-" + MD5.getStringMD5(SMGameH5Activity.this.game.getResourceUrl()) + ".zip", CacheDirectoryManager.getExternCacheFileRootPath(SMGameH5Activity.this) + "/game" + SMGameH5Activity.this.game.getGid());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    SMGameH5Activity.this.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.6.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SMGameH5Activity.this.initSettings();
                            SMGameH5Activity sMGameH5Activity = SMGameH5Activity.this;
                            PreferencesUtils.setH5GameResourceURL(sMGameH5Activity, sMGameH5Activity.game.getGid(), MD5.getStringMD5(SMGameH5Activity.this.game.getResourceUrl()));
                        }
                    });
                }
            }).start();
        }

        @Override // com.tenmeter.smlibrary.listener.IDownloadLister
        public void onProgress(long j, int i) {
            SMGameH5Activity.this.changeProgress(i);
        }

        @Override // com.tenmeter.smlibrary.listener.IDownloadLister
        public void onStart() {
        }
    }

    private class MyWebViewClient extends WebViewClient {
        private MyWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeProgress(final int i) {
        runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.7
            @Override // java.lang.Runnable
            public void run() {
                if (i >= SMGameH5Activity.this.oldProgress) {
                    SMGameH5Activity.this.oldProgress = i;
                    if (SMGameH5Activity.this.game.getVertical() == 2) {
                        SMGameH5Activity.this.tv_progress.setText(i + "%");
                        SMGameH5Activity.this.loadingProgressBg.post(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                float dimensionPixelSize = (SMGameH5Activity.this.screenWidth - SMGameH5Activity.this.getResources().getDimensionPixelSize(R.dimen.sm_px_200)) / 100.0f;
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SMGameH5Activity.this.loadingProgressBg.getLayoutParams();
                                float dimensionPixelSize2 = SMGameH5Activity.this.getResources().getDimensionPixelSize(R.dimen.sm_px_26);
                                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                layoutParams.width = (int) (dimensionPixelSize2 + (i * dimensionPixelSize));
                                SMGameH5Activity.this.loadingProgressBg.setLayoutParams(layoutParams);
                                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) SMGameH5Activity.this.vv_loading_hulu.getLayoutParams();
                                float f = SMGameH5Activity.this.huluMarginLeft;
                                AnonymousClass7 anonymousClass8 = AnonymousClass7.this;
                                layoutParams2.leftMargin = (int) (f + (dimensionPixelSize * i));
                                SMGameH5Activity.this.vv_loading_hulu.setLayoutParams(layoutParams2);
                            }
                        });
                    } else {
                        SMGameH5Activity.this.tv_portraitProgress.setText(i + "%");
                        SMGameH5Activity.this.portraitLoadingBg.post(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.7.2
                            @Override // java.lang.Runnable
                            public void run() {
                                float dimensionPixelSize = (SMGameH5Activity.this.screenWidth - SMGameH5Activity.this.getResources().getDimensionPixelSize(R.dimen.sm_px_80)) / 100.0f;
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SMGameH5Activity.this.portraitLoadingProgressBg.getLayoutParams();
                                float dimensionPixelSize2 = SMGameH5Activity.this.getResources().getDimensionPixelSize(R.dimen.sm_px_26);
                                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                layoutParams.width = (int) (dimensionPixelSize2 + (i * dimensionPixelSize));
                                SMGameH5Activity.this.portraitLoadingProgressBg.setLayoutParams(layoutParams);
                                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) SMGameH5Activity.this.vv_loading_hulu_portrait.getLayoutParams();
                                float f = SMGameH5Activity.this.huluMarginLeft;
                                AnonymousClass7 anonymousClass8 = AnonymousClass7.this;
                                layoutParams2.leftMargin = (int) (f + (dimensionPixelSize * i));
                                SMGameH5Activity.this.vv_loading_hulu_portrait.setLayoutParams(layoutParams2);
                            }
                        });
                    }
                }
                KLog.i("progress:.......==" + i + "..................oneProgress*progress..............................oneProgress*progress==");
            }
        });
    }

    private boolean fixOrientation() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"JavascriptInterface"})
    public void initSettings() {
        this.wb_common.requestFocus(130);
        this.wb_common.setWebViewClient(new MyWebViewClient());
        this.wb_common.setWebChromeClient(new WebChromeClient() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.2
            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                try {
                    return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                } catch (Exception unused) {
                    return super.getDefaultVideoPoster();
                }
            }

            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                FrameLayout frameLayout = new FrameLayout(SMGameH5Activity.this);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                return frameLayout;
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                callback.invoke(str, true, false);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                if (i == 100) {
                    SMGameH5Activity.this.loadingLayout.postDelayed(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SMGameH5Activity.this.game.getVertical() == 2) {
                                SMGameH5Activity.this.loadingLayout.setVisibility(8);
                            } else {
                                SMGameH5Activity.this.portraitLoadingLayout.setVisibility(8);
                            }
                            SMGameH5Activity.this.backImg.setVisibility(8);
                        }
                    }, 5000L);
                }
            }
        });
        WebSettings settings = this.wb_common.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowFileAccess(true);
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        settings.setLoadWithOverviewMode(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(2);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setAppCacheMaxSize(NetworkConfig.DEFAULT_CACHE_SIZE);
        settings.setDatabaseEnabled(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setBlockNetworkImage(false);
        settings.setSavePassword(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(true);
        this.wb_common.addJavascriptInterface(this, "wjsb");
        this.wb_common.getSettings().setMixedContentMode(0);
        this.wb_common.loadUrl("http://127.0.0.1:4409/index.html");
    }

    private boolean isTranslucentOrFloating() {
        boolean zBooleanValue;
        Exception e;
        try {
            TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            zBooleanValue = ((Boolean) method.invoke(null, typedArrayObtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            zBooleanValue = false;
            e = e3;
        }
        return zBooleanValue;
    }

    private void onGlobalLayout(final boolean z) {
        this.backImg.setVisibility(0);
        if (this.game.getVertical() == 2) {
            this.loadingLayout.setVisibility(0);
            this.loadingLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (SMGameH5Activity.this.game.getVertical() == 2) {
                        SMGameH5Activity sMGameH5Activity = SMGameH5Activity.this;
                        sMGameH5Activity.screenWidth = sMGameH5Activity.loadingLayout.getWidth();
                        SMGameH5Activity sMGameH5Activity2 = SMGameH5Activity.this;
                        sMGameH5Activity2.huluMarginLeft = ((FrameLayout.LayoutParams) sMGameH5Activity2.vv_loading_hulu.getLayoutParams()).leftMargin;
                        SMGameH5Activity.this.vv_loading_hulu.setBackground(q30.e(SMGameH5Activity.this, R.drawable.anim_huluhan_run));
                        final Drawable background = SMGameH5Activity.this.vv_loading_hulu.getBackground();
                        ExecutorUtil.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SMGameH5Activity.this.vv_loading_hulu.post(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.3.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Drawable drawable = background;
                                        if (drawable instanceof AnimationDrawable) {
                                            ((AnimationDrawable) drawable).start();
                                        }
                                    }
                                });
                            }
                        });
                    }
                    if (z) {
                        SMGameH5Activity.this.processDownLoad();
                    } else {
                        SMGameH5Activity.this.processLoading();
                    }
                    SMGameH5Activity.this.loadingLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        } else {
            this.portraitLoadingLayout.setVisibility(0);
            this.portraitLoadingLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.4
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    SMGameH5Activity sMGameH5Activity = SMGameH5Activity.this;
                    sMGameH5Activity.screenWidth = sMGameH5Activity.portraitLoadingLayout.getWidth();
                    SMGameH5Activity.this.portraitLoadingLayout.setVisibility(0);
                    SMGameH5Activity sMGameH5Activity2 = SMGameH5Activity.this;
                    sMGameH5Activity2.huluMarginLeft = ((FrameLayout.LayoutParams) sMGameH5Activity2.vv_loading_hulu_portrait.getLayoutParams()).leftMargin;
                    SMGameH5Activity.this.vv_loading_hulu_portrait.setBackground(q30.e(SMGameH5Activity.this, R.drawable.anim_huluhan_run));
                    final Drawable background = SMGameH5Activity.this.vv_loading_hulu_portrait.getBackground();
                    ExecutorUtil.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SMGameH5Activity.this.vv_loading_hulu_portrait.post(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.4.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Drawable drawable = background;
                                    if (drawable instanceof AnimationDrawable) {
                                        ((AnimationDrawable) drawable).start();
                                    }
                                }
                            });
                        }
                    });
                    if (z) {
                        SMGameH5Activity.this.processDownLoad();
                    } else {
                        SMGameH5Activity.this.processLoading();
                    }
                    SMGameH5Activity.this.portraitLoadingLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDownLoad() {
        CacheDirectoryManager.getExternCacheFileRootPath(this);
        this.game.getGid();
        MD5.getStringMD5(this.game.getResourceUrl());
        FileUtils.delete(new File(CacheDirectoryManager.getExternCacheFileRootPath(this) + "/game" + this.game.getGid()));
        DownloadTask downloadTask = new DownloadTask(this.game.getResourceUrl(), CacheDirectoryManager.getExternCacheFileRootPath(this) + "/h5-game-" + this.game.getGid() + "-" + MD5.getStringMD5(this.game.getResourceUrl()) + ".zip", 20, new AnonymousClass6());
        this.task = downloadTask;
        downloadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processLoading() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 99);
        valueAnimatorOfInt.setDuration(2500L);
        valueAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SMGameH5Activity.this.changeProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.start();
    }

    private void processUpdate() {
        if (!Constants.STR_EMPTY.equals(PreferencesUtils.getH5GameResourceURL(this, this.game.getGid())) && !MD5.getStringMD5(this.game.getResourceUrl()).equals(PreferencesUtils.getH5GameResourceURL(this, this.game.getGid()))) {
            FileUtils.delete(new File(CacheDirectoryManager.getExternCacheFileRootPath(this) + "/h5-game-" + this.game.getGid() + "-" + PreferencesUtils.getH5GameResourceURL(this, this.game.getGid()) + ".zip"));
        }
        PreferencesUtils.setH5GameResourceURL(this, this.game.getGid(), Constants.STR_EMPTY);
        onGlobalLayout(true);
    }

    private void requestPermission() {
        SMGameClient.getInstance().comGameStart(this.game.getGid(), null);
        if (!MD5.getStringMD5(this.game.getResourceUrl()).equals(PreferencesUtils.getH5GameResourceURL(this, this.game.getGid()))) {
            processUpdate();
            return;
        }
        if (!FileUtils.isFolderExist(CacheDirectoryManager.getExternCacheFileRootPath(this) + "/game" + this.game.getGid())) {
            processUpdate();
        } else {
            initSettings();
            onGlobalLayout(false);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 1) {
            onBackPressed();
        }
        return true;
    }

    protected void hideBottomUIMenu() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.systemUiVisibility = 2050;
        window.setAttributes(attributes);
    }

    @JavascriptInterface
    public void jsCloseGSensor(int i) {
        if (SMGameClient.getInstance().getGameGSonsorListener() != null) {
            SMGameClient.getInstance().getGameGSonsorListener().closeGSensor(i);
        }
    }

    @JavascriptInterface
    public void jsCloseGame() {
        if (SMGameClient.getInstance().getGameGSonsorListener() != null) {
            SMGameClient.getInstance().getGameGSonsorListener().closeGame();
        }
        finish();
    }

    @JavascriptInterface
    public String jsGetGameInfo() {
        SMGameClient.getInstance().getUserInfo().getHeadImage();
        SMGameClient.getInstance().getUserInfo().getUserNickname();
        long uid = SMGameClient.getInstance().getUserInfo().getUid();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", SMGameClient.getInstance().getUserInfo().getUserToken());
            jSONObject.put("uid", uid + Constants.STR_EMPTY);
            jSONObject.put("gid", this.game.getGid());
            jSONObject.put("serverUrl", SMGameClient.baseUrl);
            jSONObject.put("joinRaceId", 0);
            jSONObject.put("otpToken", Constants.STR_EMPTY);
            jSONObject.put("roomId", 0);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String jsGetP1Data() {
        String headImage = SMGameClient.getInstance().getUserInfo().getHeadImage();
        String userNickname = SMGameClient.getInstance().getUserInfo().getUserNickname();
        return "{\"userId\":" + SMGameClient.getInstance().getUserInfo().getUid() + ",\"name\":\"" + userNickname + "\", \"head\":\"" + headImage + "\", \"mac\":\"\"}";
    }

    @JavascriptInterface
    public void jsHideLoading() {
    }

    @JavascriptInterface
    public void jsOpenGSensor(int i) {
        KLog.i("jsOpenGSensor+++++++++++++++++++++");
        if (SMGameClient.getInstance().getGameGSonsorListener() != null) {
            SMGameClient.getInstance().getGameGSonsorListener().openGSensor(i);
        }
    }

    @JavascriptInterface
    public void jsVirtualKeys(int i) {
        if (SMGameClient.getInstance().getGameGSonsorListener() != null) {
            SMGameClient.getInstance().getGameGSonsorListener().jsVirtualKeys(i);
        }
    }

    @JavascriptInterface
    public void jsloadingFinish() {
        this.loadingLayout.postDelayed(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.8
            @Override // java.lang.Runnable
            public void run() {
                if (SMGameH5Activity.this.game.getVertical() == 2) {
                    SMGameH5Activity.this.loadingLayout.setVisibility(8);
                } else {
                    SMGameH5Activity.this.portraitLoadingLayout.setVisibility(8);
                }
                SMGameH5Activity.this.backImg.setVisibility(8);
            }
        }, 100L);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (SMGameClient.getInstance().getGameGSonsorListener() != null) {
            SMGameClient.getInstance().getGameGSonsorListener().closeGame();
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (getIntent().getExtras().getParcelable("game") != null) {
            this.game = (SMGameInfo) getIntent().getExtras().getParcelable("game");
        } else {
            Toast.makeText(this, "game不能为null", 1).show();
            finish();
        }
        if (Build.VERSION.SDK_INT == 26 && isTranslucentOrFloating()) {
            KLog.i("onCreate fixOrientation when Oreo, result = " + fixOrientation());
        }
        super.onCreate(bundle);
        setRequestedOrientation(this.game.getVertical() == 2 ? 0 : 1);
        try {
            H5GameServer.WEB_ROOT = CacheDirectoryManager.getExternCacheFileRootPath(this) + "/game" + this.game.getGid();
            this.myServer = new H5GameServer(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Utils.setActivity(this);
        Utils.hideVirtualButton();
        getWindow().addFlags(128);
        hideBottomUIMenu();
        setContentView(R.layout.activity_sm_sdk_game_h5);
        this.wb_common = (WebView) findViewById(R.id.wb_common);
        this.tv_data = (TextView) findViewById(R.id.tv_data);
        this.tv_progress = (TextView) findViewById(R.id.tv_progress);
        this.tv_portraitProgress = (TextView) findViewById(R.id.tv_progress_portrait);
        this.loadingLayout = (FrameLayout) findViewById(R.id.fl_loading);
        this.portraitLoadingLayout = (FrameLayout) findViewById(R.id.fl_loading_portrait);
        this.loadingBg = findViewById(R.id.vv_loading_one);
        this.loadingProgressBg = findViewById(R.id.vv_loading_two);
        this.portraitLoadingBg = findViewById(R.id.vv_loading_one_portrait);
        this.portraitLoadingProgressBg = findViewById(R.id.vv_loading_two_portrait);
        this.vv_loading_hulu = (ImageView) findViewById(R.id.vv_loading_hulu);
        this.vv_loading_hulu_portrait = (ImageView) findViewById(R.id.vv_loading_hulu_portrait);
        ImageView imageView = (ImageView) findViewById(R.id.iv_cancel);
        this.backImg = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.activity.SMGameH5Activity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SMGameH5Activity.this.task != null) {
                    SMGameH5Activity.this.task.cancelDownload();
                }
                SMGameH5Activity.this.finish();
            }
        });
        SMGameClient.getInstance().setWebView(this.wb_common);
        SMGameClient.getInstance().setTextData(this.tv_data);
        requestPermission();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.downLoadThread != null) {
            this.downLoadThread = null;
        }
        DownloadTask downloadTask = this.task;
        if (downloadTask != null) {
            downloadTask.cancel(true);
            this.task = null;
        }
        SMGameClient.getInstance().setWebView(null);
        SMGameClient.getInstance().setTextData(null);
        this.wb_common.destroy();
        H5GameServer h5GameServer = this.myServer;
        if (h5GameServer != null) {
            h5GameServer.closeAllConnections();
            this.myServer = null;
            H5GameServer.WEB_ROOT = Constants.STR_EMPTY;
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.wb_common.onPause();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 2068) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
            KLog.e("request permission error");
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.wb_common.onResume();
    }

    @JavascriptInterface
    public void reqBeginGameStatus() {
        if (SMGameClient.getInstance().getGameStatusListener() != null) {
            SMGameClient.getInstance().getGameStatusListener().beginGame();
        }
    }

    @JavascriptInterface
    public void reqGameEndStatus(boolean z) {
        if (SMGameClient.getInstance().getGameStatusListener() != null) {
            SMGameClient.getInstance().getGameStatusListener().endGame(z);
        }
    }

    @JavascriptInterface
    public void reqPauseGameStatus() {
        if (SMGameClient.getInstance().getGameStatusListener() != null) {
            SMGameClient.getInstance().getGameStatusListener().pauseGame();
        }
    }

    @JavascriptInterface
    public void reqResumeGameStatus() {
        if (SMGameClient.getInstance().getGameStatusListener() != null) {
            SMGameClient.getInstance().getGameStatusListener().resumeGame();
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (Build.VERSION.SDK_INT == 26 && isTranslucentOrFloating()) {
            KLog.i("avoid calling setRequestedOrientation when Oreo.");
        } else {
            super.setRequestedOrientation(i);
        }
    }
}
