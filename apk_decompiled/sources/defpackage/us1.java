package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.beken.beken_ota.R$id;
import com.beken.beken_ota.R$layout;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class us1 extends BaseAdapter {
    public static HashMap e;
    private final String a;
    private Context b;
    private LayoutInflater c;
    private HashMap d;

    public us1(Context context, HashMap map) {
        String simpleName = us1.class.getSimpleName();
        this.a = simpleName;
        this.b = context;
        this.d = map;
        this.c = LayoutInflater.from(context);
        b();
        Log.e(simpleName, "file size is " + this.d.size());
    }

    public String a() {
        for (int i = 0; i < this.d.size(); i++) {
            if (((Boolean) e.get(Integer.valueOf(i))).booleanValue()) {
                return ((im0) this.d.get(Integer.valueOf(i))).a();
            }
        }
        return null;
    }

    public void b() {
        e = new HashMap();
        for (int i = 0; i < this.d.size(); i++) {
            e.put(Integer.valueOf(i), Boolean.FALSE);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.d.get(Integer.valueOf(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        CheckBox checkBox;
        if (view != null) {
            checkBox = (CheckBox) view.getTag();
        } else {
            view = this.c.inflate(R$layout.listitem_files, (ViewGroup) null);
            checkBox = (CheckBox) view.findViewById(R$id.ota_file_item);
            view.setTag(checkBox);
        }
        checkBox.setText(((im0) this.d.get(Integer.valueOf(i))).a());
        checkBox.setChecked(((Boolean) e.get(Integer.valueOf(i))).booleanValue());
        return view;
    }
}
