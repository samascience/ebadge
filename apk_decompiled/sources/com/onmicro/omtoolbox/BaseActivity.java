package com.onmicro.omtoolbox;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes3.dex */
public class BaseActivity extends AppCompatActivity {
    public void G() {
    }

    public boolean H() {
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (H()) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        ButterKnife.bind(this);
        if (H()) {
            EventBus.getDefault().register(this);
        }
        G();
    }
}
