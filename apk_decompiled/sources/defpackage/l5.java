package defpackage;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.e;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class l5 extends pg {
    ImageView c;
    TextView d;
    private k5.a e;
    private aw2 f;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StringBuilder sb = new StringBuilder();
            sb.append("点击样式项: ");
            sb.append(l5.this.f != null ? l5.this.f.e() : "null");
            Log.d("AllStylesHolder", sb.toString());
            if (l5.this.e == null || l5.this.f == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("点击事件处理失败 - listener: ");
                sb2.append(l5.this.e != null);
                sb2.append(", styleItem: ");
                sb2.append(l5.this.f != null);
                Log.w("AllStylesHolder", sb2.toString());
                return;
            }
            aw2 aw2Var = new aw2(l5.this.f.c(), l5.this.f.d(), l5.this.f.e(), !l5.this.f.k(), l5.this.f.g());
            Log.d("AllStylesHolder", "发送样式选择事件: " + aw2Var.e() + ", 选中: " + aw2Var.k());
            l5.this.e.a(aw2Var);
        }
    }

    public l5(View view, k5.a aVar) {
        super(view);
        this.c = (ImageView) view.findViewById(R.id.item_style_img);
        this.d = (TextView) view.findViewById(R.id.item_style_name);
        this.e = aVar;
        view.setOnClickListener(new a());
    }

    private String e(int i) {
        if (i == 1) {
            return "边框";
        }
        if (i != 2) {
            return i != 3 ? "样式" : "时间样式";
        }
        return "贴纸";
    }

    @Override // defpackage.pg
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void a(ys0 ys0Var, int i) {
        this.f = new aw2(ys0Var.a(), ys0Var.a(), e(ys0Var.c()), ys0Var.e(), ys0Var.c());
        if (ys0Var.a() != null) {
            this.d.setText(e(ys0Var.c()));
        }
        if (ys0Var.e()) {
            this.itemView.setAlpha(1.0f);
            this.itemView.setBackgroundResource(R.drawable.selected_background);
        } else {
            this.itemView.setAlpha(0.7f);
            this.itemView.setBackgroundResource(R.drawable.bg_square_gray);
        }
        if (!ys0Var.d()) {
            ((e) ((e) com.bumptech.glide.a.u(this.itemView.getContext()).r(ys0Var.a()).U(R.mipmap.eqt_watch)).h(R.mipmap.eqt_watch)).u0(this.c);
            return;
        }
        Integer numB = ys0Var.b();
        if (numB != null) {
            this.c.setImageResource(numB.intValue());
        }
    }
}
