package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.onmicro.omtoolbox.R$id;
import com.onmicro.omtoolbox.R$layout;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class as0 extends BaseAdapter {
    private Context a;
    private PackageManager b;
    private LayoutInflater c;
    private List d;

    private class b {
        private View a;
        private ImageView b;
        private TextView c;

        private b() {
        }
    }

    public as0(Context context) {
        this.a = context;
        this.c = LayoutInflater.from(context);
        this.b = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("com.onmicro.android.omtoolbox.LAUNCHER");
        this.d = this.b.queryIntentActivities(intent, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ResolveInfo resolveInfo, View view) {
        Intent intent = new Intent();
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
        intent.setFlags(65536);
        this.a.startActivity(intent);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list = this.d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.c.inflate(R$layout.grid_function_list, viewGroup, false);
            b bVar = new b();
            bVar.a = view;
            bVar.b = (ImageView) view.findViewById(R$id.icon);
            bVar.c = (TextView) view.findViewById(R$id.tv_label);
            view.setTag(bVar);
        }
        final ResolveInfo resolveInfo = (ResolveInfo) this.d.get(i);
        b bVar2 = (b) view.getTag();
        bVar2.b.setImageDrawable(resolveInfo.loadIcon(this.b));
        bVar2.c.setText(resolveInfo.loadLabel(this.b).toString());
        bVar2.a.setOnClickListener(new View.OnClickListener() { // from class: zr0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.b(resolveInfo, view2);
            }
        });
        return view;
    }
}
