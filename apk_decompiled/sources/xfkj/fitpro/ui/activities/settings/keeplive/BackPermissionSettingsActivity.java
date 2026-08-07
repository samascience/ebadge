package xfkj.fitpro.ui.activities.settings.keeplive;

import android.os.Bundle;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.legend.smartwatch.app.base.acitivity.BaseActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.a3;
import defpackage.db0;
import defpackage.og;
import java.util.ArrayList;
import xfkj.fitpro.ui.activities.settings.keeplive.fragment.AutoStartFragment;
import xfkj.fitpro.ui.activities.settings.keeplive.fragment.NotifiPermFragment;
import xfkj.fitpro.ui.activities.settings.keeplive.fragment.SaveBatteryFragment;

/* JADX INFO: loaded from: classes4.dex */
public class BackPermissionSettingsActivity extends BaseActivity<a3> {
    TextView k;
    TabLayout l;
    ViewPager m;
    private og n;
    private String[] o;

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void N(Bundle bundle) {
        this.k = (TextView) findViewById(R.id.tv_device_factory_name);
        this.l = (TabLayout) findViewById(R.id.tabLayout);
        this.m = (ViewPager) findViewById(R.id.viewPager);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        setTitle(getString(R.string.system_perm_settings));
        ArrayList arrayList = new ArrayList();
        arrayList.add(AutoStartFragment.J());
        arrayList.add(NotifiPermFragment.L());
        arrayList.add(SaveBatteryFragment.J());
        this.k.setText(db0.a());
        og ogVar = new og(getSupportFragmentManager(), arrayList);
        this.n = ogVar;
        this.m.setAdapter(ogVar);
        this.o = getResources().getStringArray(R.array.keep_live_permission_app_arrays);
        TabLayout tabLayout = this.l;
        tabLayout.h(tabLayout.D().r(this.o[0]));
        TabLayout tabLayout2 = this.l;
        tabLayout2.h(tabLayout2.D().r(this.o[1]));
        TabLayout tabLayout3 = this.l;
        tabLayout3.h(tabLayout3.D().r(this.o[2]));
        this.l.setupWithViewPager(this.m);
        this.l.A(0).r(this.o[0]);
        this.l.A(1).r(this.o[1]);
        this.l.A(2).r(this.o[2]);
        this.l.setTabIndicatorFullWidth(false);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initListener() {
    }
}
