package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import yqy.yichip.ota3genbandupgrade.R$id;
import yqy.yichip.ota3genbandupgrade.R$layout;

/* JADX INFO: loaded from: classes4.dex */
public class ba1 extends BaseAdapter {
    private Context a;
    private List b = new ArrayList();

    class a {
        TextView a;
        TextView b;
        TextView c;

        a() {
        }
    }

    public ba1(Context context) {
        this.a = context;
    }

    private boolean b(List list, hj0 hj0Var) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hj0 hj0Var2 = (hj0) it.next();
            if (TextUtils.equals(hj0Var2.a().getName(), hj0Var.a().getName()) && TextUtils.equals(hj0Var2.a().getAddress(), hj0Var.a().getAddress())) {
                return true;
            }
        }
        return false;
    }

    public void a(hj0 hj0Var) {
        List list = this.b;
        if (list == null || hj0Var == null) {
            return;
        }
        if (!b(list, hj0Var)) {
            this.b.add(hj0Var);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List list = this.b;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R$layout.layout_listview_device_item, (ViewGroup) null);
            aVar = new a();
            aVar.a = (TextView) view.findViewById(R$id.tv_device_name);
            aVar.b = (TextView) view.findViewById(R$id.tv_device_address);
            aVar.c = (TextView) view.findViewById(R$id.tv_device_rssi);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (((hj0) this.b.get(i)).a().getName() == null) {
            aVar.a.setText("NULL");
        } else {
            aVar.a.setText(((hj0) this.b.get(i)).a().getName());
        }
        aVar.b.setText(((hj0) this.b.get(i)).a().getAddress());
        aVar.c.setText(String.valueOf(((hj0) this.b.get(i)).b()));
        return view;
    }
}
