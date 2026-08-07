package xfkj.fitpro.activity.ota.base;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.c;
import com.blankj.utilcode.util.j;
import com.tencent.connect.common.Constants;
import defpackage.pb0;
import defpackage.wd3;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import xfkj.fitpro.activity.ota.utils.EventBusUtils;
import xfkj.fitpro.activity.ota.utils.ViewBindingHelper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NewBaseActivity<T extends wd3> extends AppCompatActivity {
    public T binding;
    private InputMethodManager imm;
    protected InputMethodManager inputMethodManager;
    protected Context mContext;
    protected ProgressDialog mProgressDialog;
    protected String TAG = getClass().getSimpleName();
    protected boolean isActive = true;
    private Toast mToast = null;
    private boolean isImmersionBar = true;
    protected Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: xfkj.fitpro.activity.ota.base.NewBaseActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            NewBaseActivity.this.handleMsg(message);
            if (NewBaseActivity.this.mDelayWhats.contains(Integer.valueOf(message.what))) {
                NewBaseActivity.this.mDelayWhats.remove(Integer.valueOf(message.what));
            }
        }
    };
    private List<Integer> mDelayWhats = new ArrayList();

    public void back(View view) {
        hideSoftKeyBoard();
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        hideSoftKeyBoard();
    }

    public int getLayoutId() {
        return 0;
    }

    protected void handleMsg(Message message) {
    }

    public void hideProgress() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public void hideSoftKeyBoard() {
        InputMethodManager inputMethodManager;
        View currentFocus = getCurrentFocus();
        if (this.imm == null) {
            this.imm = (InputMethodManager) getSystemService("input_method");
        }
        if (currentFocus == null || (inputMethodManager = this.imm) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
    }

    public abstract void initData(Bundle bundle);

    public abstract void initListener();

    protected void initViews() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        if (!isTaskRoot()) {
            Intent intent = getIntent();
            String action = intent.getAction();
            if (intent.hasCategory("android.intent.category.LAUNCHER") && action.equals("android.intent.action.MAIN")) {
                finish();
                return;
            }
        }
        if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
            T t = (T) ViewBindingHelper.onCreateViewBinding(this, getLayoutInflater());
            this.binding = t;
            if (t != null) {
                setContentView(t.getRoot());
            }
        } else {
            setContentView(getLayoutId());
        }
        setTitle(Constants.STR_EMPTY);
        initViews();
        initData(bundle);
        initListener();
        this.mToast = Toast.makeText(this, Constants.STR_EMPTY, 0);
        this.inputMethodManager = (InputMethodManager) getSystemService("input_method");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        pb0.a();
        stopAllTimeOut();
        this.imm = null;
    }

    public void onMessageEvent(Object obj) {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvents(Object obj) {
        onMessageEvent(obj);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Toast toast = this.mToast;
        if (toast != null) {
            toast.cancel();
            this.mToast = null;
        }
        hideSoftKeyBoard();
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @SuppressLint({"ShowToast"})
    public void onResume() {
        super.onResume();
        if (this.mToast == null) {
            this.mToast = Toast.makeText(this, Constants.STR_EMPTY, 0);
        }
        if (this.isActive) {
            return;
        }
        this.isActive = true;
        j.t(this.TAG, "进入前台");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        EventBusUtils.register(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        EventBusUtils.unregister(this);
        hideProgress();
        this.mProgressDialog = null;
        if (c.k()) {
            return;
        }
        this.isActive = false;
        j.t(this.TAG, "进入后台");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        j.t("memory -- info -->", i + Constants.STR_EMPTY);
    }

    protected void startTimeOut(int i, long j) {
        this.mDelayWhats.add(Integer.valueOf(i));
        this.mHandler.sendEmptyMessageDelayed(i, j);
    }

    protected void stopAllTimeOut() {
        if (this.mDelayWhats.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.mDelayWhats.iterator();
        while (it.hasNext()) {
            stopTimeOut(it.next().intValue());
        }
    }

    protected void stopTimeOut(int i) {
        this.mDelayWhats.remove(Integer.valueOf(i));
        this.mHandler.removeMessages(i);
    }
}
