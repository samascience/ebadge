package com.yanzhenjie.recyclerview.swipe.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yanzhenjie.loading.LoadingView;
import com.yanzhenjie.recyclerview.swipe.R$color;
import com.yanzhenjie.recyclerview.swipe.R$id;
import com.yanzhenjie.recyclerview.swipe.R$layout;
import com.yanzhenjie.recyclerview.swipe.R$string;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import defpackage.q30;

/* JADX INFO: loaded from: classes.dex */
public class DefaultLoadMoreView extends LinearLayout implements SwipeMenuRecyclerView.f, View.OnClickListener {
    private LoadingView a;
    private TextView b;

    public DefaultLoadMoreView(Context context) {
        this(context, null);
    }

    @Override // com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView.f
    public void a(SwipeMenuRecyclerView.e eVar) {
        setVisibility(0);
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setText(R$string.recycler_swipe_click_load_more);
    }

    @Override // com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView.f
    public void b() {
        setVisibility(0);
        this.a.setVisibility(0);
        this.b.setVisibility(0);
        this.b.setText(R$string.recycler_swipe_load_more_message);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public DefaultLoadMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setGravity(17);
        setVisibility(8);
        setMinimumHeight((int) (((double) (getResources().getDisplayMetrics().density * 60.0f)) + 0.5d));
        View.inflate(getContext(), R$layout.recycler_swipe_view_load_more, this);
        this.a = (LoadingView) findViewById(R$id.loading_view);
        this.b = (TextView) findViewById(R$id.tv_load_more_message);
        this.a.a(q30.c(getContext(), R$color.recycler_swipe_color_loading_color1), q30.c(getContext(), R$color.recycler_swipe_color_loading_color2), q30.c(getContext(), R$color.recycler_swipe_color_loading_color3));
        setOnClickListener(this);
    }
}
