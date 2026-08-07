package com.yanzhenjie.recyclerview.swipe;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.be3;
import defpackage.j23;
import defpackage.ly2;
import defpackage.ny2;
import defpackage.oy2;
import defpackage.py2;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SwipeMenuView extends LinearLayout implements View.OnClickListener {
    private RecyclerView.ViewHolder a;
    private py2 b;
    private oy2 c;
    private int d;

    public SwipeMenuView(Context context) {
        this(context, null);
    }

    private ImageView b(ny2 ny2Var) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(ny2Var.c());
        return imageView;
    }

    private TextView d(ny2 ny2Var) {
        TextView textView = new TextView(getContext());
        textView.setText(ny2Var.d());
        textView.setGravity(17);
        int iF = ny2Var.f();
        if (iF > 0) {
            textView.setTextSize(2, iF);
        }
        ColorStateList colorStateListH = ny2Var.h();
        if (colorStateListH != null) {
            textView.setTextColor(colorStateListH);
        }
        int iE = ny2Var.e();
        if (iE != 0) {
            j23.p(textView, iE);
        }
        Typeface typefaceG = ny2Var.g();
        if (typefaceG != null) {
            textView.setTypeface(typefaceG);
        }
        return textView;
    }

    public void a(RecyclerView.ViewHolder viewHolder) {
        this.a = viewHolder;
    }

    public void c(ly2 ly2Var, py2 py2Var, oy2 oy2Var, int i) {
        removeAllViews();
        this.b = py2Var;
        this.c = oy2Var;
        this.d = i;
        List listB = ly2Var.b();
        for (int i2 = 0; i2 < listB.size(); i2++) {
            ny2 ny2Var = (ny2) listB.get(i2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ny2Var.j(), ny2Var.b());
            layoutParams.weight = ny2Var.i();
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(i2);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(layoutParams);
            be3.t0(linearLayout, ny2Var.a());
            linearLayout.setOnClickListener(this);
            addView(linearLayout);
            d dVar = new d(this.d, i2, this.b, linearLayout);
            linearLayout.setTag(dVar);
            if (ny2Var.c() != null) {
                ImageView imageViewB = b(ny2Var);
                dVar.g = imageViewB;
                linearLayout.addView(imageViewB);
            }
            if (!TextUtils.isEmpty(ny2Var.d())) {
                TextView textViewD = d(ny2Var);
                dVar.f = textViewD;
                linearLayout.addView(textViewD);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.c == null || !this.b.a()) {
            return;
        }
        d dVar = (d) view.getTag();
        dVar.e = this.a.getAdapterPosition();
        this.c.a(dVar);
    }

    public SwipeMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
