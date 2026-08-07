package xfkj.fitpro.view.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.g;
import com.blankj.utilcode.util.n;
import com.blankj.utilcode.util.s;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.e33;
import defpackage.fz;
import defpackage.ml2;
import defpackage.pg;
import defpackage.rz1;
import defpackage.t70;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class CashLogDialogFragment extends BaseDialogFragment {
    RecyclerView r;
    TextView s;
    a t;
    List u;
    List v = new ArrayList();
    private String w = rz1.e();

    public class a extends t70 {
        public a(List list) {
            super(list);
        }

        @Override // defpackage.t70
        public pg c(View view, int i) {
            return CashLogDialogFragment.this.new b(view);
        }

        @Override // defpackage.t70
        public int e(int i) {
            return R.layout.item_crash_log;
        }
    }

    public class b extends pg {
        TextView c;
        CheckBox d;

        public b(View view) {
            super(view);
            this.c = (TextView) view.findViewById(R.id.tv_file_name);
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.cx);
            this.d = checkBox;
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: vw
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.a.d(compoundButton, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(CompoundButton compoundButton, boolean z) {
            File file = (File) CashLogDialogFragment.this.u.get(getAbsoluteAdapterPosition());
            if (z) {
                CashLogDialogFragment.this.v.add(file);
            } else {
                CashLogDialogFragment.this.v.remove(file);
            }
        }

        @Override // defpackage.pg
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(File file, int i) {
            this.c.setText(file.getName());
        }
    }

    private void U(View view) {
        view.findViewById(R.id.btn_share).setOnClickListener(new View.OnClickListener() { // from class: uw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.W(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean V(View view) {
        if (!fz.b(this.v)) {
            ToastUtils.u("文件不存在");
            return false;
        }
        Iterator it = this.v.iterator();
        while (it.hasNext()) {
            g.e((File) it.next());
        }
        ToastUtils.u("删除成功");
        y();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        X();
    }

    @Override // xfkj.fitpro.view.dialog.BaseDialogFragment
    protected BaseDialogFragment.a N() {
        return new BaseDialogFragment.a().i(true).k(17).l(ml2.a() - 40);
    }

    @Override // xfkj.fitpro.view.dialog.BaseDialogFragment
    public void O(Bundle bundle, View view) {
        List listS = g.s(this.w);
        this.u = listS;
        a aVar = new a(listS);
        this.t = aVar;
        this.r.setAdapter(aVar);
        this.r.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.s.setOnLongClickListener(new View.OnLongClickListener() { // from class: tw
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return this.a.V(view2);
            }
        });
        U(view);
    }

    @Override // xfkj.fitpro.view.dialog.BaseDialogFragment
    public int P() {
        return R.layout.fragment_cash_log_dialog;
    }

    @Override // xfkj.fitpro.view.dialog.BaseDialogFragment
    protected void R(View view) {
        super.R(view);
        this.r = (RecyclerView) view.findViewById(R.id.list);
        this.s = (TextView) view.findViewById(R.id.tv_delete);
    }

    public void X() {
        try {
            Y();
            y();
        } catch (IOException e) {
            ToastUtils.u(e.toString());
        }
    }

    public void Y() {
        String str = rz1.j() + "compress";
        g.b(str);
        g.j(str);
        if (fz.a(this.v)) {
            ToastUtils.u("分享文件不存在");
            return;
        }
        File file = new File(str + File.separator + e33.f() + ".zip");
        Intent intent = new Intent("android.intent.action.SEND");
        s.f(this.v, file);
        intent.putExtra("android.intent.extra.STREAM", n.b(file));
        intent.addFlags(1);
        intent.setType("application/vnd.ms-excel");
        intent.setFlags(268435456);
        intent.addFlags(1);
        startActivity(Intent.createChooser(intent, "分享文件"));
    }
}
