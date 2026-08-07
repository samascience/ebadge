package com.yalantis.ucrop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R$drawable;
import com.luck.picture.lib.R$id;
import com.luck.picture.lib.R$layout;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import defpackage.a22;
import defpackage.k01;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a extends RecyclerView.Adapter {
    private final List a;
    private b b;

    /* JADX INFO: renamed from: com.yalantis.ucrop.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0125a implements View.OnClickListener {
        final /* synthetic */ c a;

        ViewOnClickListenerC0125a(c cVar) {
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.b != null) {
                a.this.b.a(this.a.getAbsoluteAdapterPosition(), view);
            }
        }
    }

    public interface b {
        void a(int i, View view);
    }

    public static class c extends RecyclerView.ViewHolder {
        ImageView a;
        ImageView b;
        ImageView c;
        TextView d;

        public c(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R$id.iv_photo);
            this.c = (ImageView) view.findViewById(R$id.iv_video);
            this.b = (ImageView) view.findViewById(R$id.iv_dot);
            this.d = (TextView) view.findViewById(R$id.tv_gif);
        }
    }

    public a(List list) {
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i) {
        LocalMedia localMedia = (LocalMedia) this.a.get(i);
        String strQ = localMedia.q();
        if (localMedia.z()) {
            cVar.b.setVisibility(0);
            cVar.b.setImageResource(R$drawable.ucrop_oval_true);
        } else {
            cVar.b.setVisibility(4);
        }
        if (a22.n(localMedia.n())) {
            cVar.a.setVisibility(8);
            cVar.c.setVisibility(0);
            cVar.c.setImageResource(R$drawable.ucrop_ic_default_video);
            return;
        }
        cVar.a.setVisibility(0);
        cVar.c.setVisibility(8);
        cVar.d.setVisibility(a22.i(localMedia.n()) ? 0 : 8);
        k01 k01Var = PictureSelectionConfig.w1;
        if (k01Var != null) {
            k01Var.d(cVar.itemView.getContext(), strQ, cVar.a);
        }
        cVar.itemView.setOnClickListener(new ViewOnClickListenerC0125a(cVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.ucrop_picture_gf_adapter_edit_list, viewGroup, false));
    }

    public void f(b bVar) {
        this.b = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
