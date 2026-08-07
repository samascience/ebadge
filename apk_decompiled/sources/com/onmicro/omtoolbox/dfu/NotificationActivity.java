package com.onmicro.omtoolbox.dfu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.onmicro.omtoolbox.MainActivity;

/* JADX INFO: loaded from: classes3.dex */
public class NotificationActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isTaskRoot()) {
            Intent intent = new Intent(this, (Class<?>) MainActivity.class);
            intent.addFlags(268435456);
            Intent intent2 = new Intent(this, (Class<?>) DfuActivity.class);
            if (getIntent() != null && getIntent().getExtras() != null) {
                intent2.putExtras(getIntent().getExtras());
            }
            startActivities(new Intent[]{intent, intent2});
        }
        finish();
    }
}
