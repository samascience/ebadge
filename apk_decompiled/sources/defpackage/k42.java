package defpackage;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import yqy.yichip.ota3genbandupgrade.R$id;
import yqy.yichip.ota3genbandupgrade.R$layout;
import yqy.yichip.ota3genbandupgrade.R$string;

/* JADX INFO: loaded from: classes4.dex */
public class k42 {
    private Context a;
    private PopupWindow b;
    private String c;
    private String[] d = null;

    class a implements AdapterView.OnItemClickListener {
        final /* synthetic */ av1 a;

        a(av1 av1Var) {
            this.a = av1Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            String str = k42.this.c + k42.this.d[i];
            av1 av1Var = this.a;
            if (av1Var != null) {
                av1Var.a(str);
            }
            Log.d("PopSelectLocalFile", "选择了本地升级文件的路径：" + str);
            k42.this.d();
        }
    }

    class b implements FileFilter {
        b() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().endsWith(".dat");
        }
    }

    class c implements Comparator {
        c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            if (file.lastModified() < file2.lastModified()) {
                return 1;
            }
            return file.lastModified() == file2.lastModified() ? 0 : -1;
        }
    }

    public k42(Context context, av1 av1Var) {
        this.a = context;
        View viewInflate = View.inflate(context, R$layout.layout_pop_select_local_file, null);
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_local_file_folder);
        this.b = new PopupWindow(viewInflate, -1, -1, true);
        ListView listView = (ListView) viewInflate.findViewById(R$id.lv_file_name);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.ll_local_file_list_null);
        this.c = dm3.b;
        textView.setText(context.getString(R$string.f103) + ":" + this.c);
        e(this.c);
        String[] strArr = this.d;
        if (strArr == null || strArr.length == 0) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
            listView.setAdapter((ListAdapter) new ArrayAdapter(context, R.layout.simple_list_item_1, this.d));
        }
        listView.setOnItemClickListener(new a(av1Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        PopupWindow popupWindow = this.b;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    private void e(String str) {
        if (!ym0.c(str)) {
            Log.d("PopSelectLocalFile", "目录不存在：" + str);
            return;
        }
        Log.d("PopSelectLocalFile", "目录已存在：" + str);
        File file = new File(str);
        if (file.length() > 0) {
            List listAsList = Arrays.asList(file.listFiles(new b()));
            Collections.sort(listAsList, new c());
            this.d = new String[listAsList.size()];
            for (int i = 0; i < listAsList.size(); i++) {
                this.d[i] = ((File) listAsList.get(i)).getName();
            }
        }
    }

    public void f() {
        PopupWindow popupWindow = this.b;
        if (popupWindow == null) {
            return;
        }
        popupWindow.showAtLocation(((Activity) this.a).getWindow().getDecorView(), 17, 0, 0);
    }
}
