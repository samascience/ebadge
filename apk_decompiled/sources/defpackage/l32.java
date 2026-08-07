package defpackage;

import android.graphics.ColorFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.graphics.BlendModeCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R$color;
import com.luck.picture.lib.R$id;
import com.luck.picture.lib.R$layout;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class l32 extends RecyclerView.Adapter {
    private List a = new ArrayList();
    private final PictureSelectionConfig b;
    private a c;

    public interface a {
        void a(int i, LocalMedia localMedia, View view);
    }

    static class b extends RecyclerView.ViewHolder {
        ImageView a;
        ImageView b;
        ImageView c;
        View d;

        public b(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R$id.ivImage);
            this.b = (ImageView) view.findViewById(R$id.ivPlay);
            this.c = (ImageView) view.findViewById(R$id.ivEditor);
            this.d = view.findViewById(R$id.viewBorder);
            PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        }
    }

    public l32(PictureSelectionConfig pictureSelectionConfig) {
        this.b = pictureSelectionConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(b bVar, int i, View view) {
        if (this.c == null || bVar.getAbsoluteAdapterPosition() < 0) {
            return;
        }
        this.c.a(bVar.getAbsoluteAdapterPosition(), e(i), view);
    }

    public void d(LocalMedia localMedia) {
        this.a.clear();
        this.a.add(localMedia);
        notifyDataSetChanged();
    }

    public LocalMedia e(int i) {
        if (this.a.size() > 0) {
            return (LocalMedia) this.a.get(i);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final b bVar, final int i) {
        k01 k01Var;
        LocalMedia localMediaE = e(i);
        ColorFilter colorFilterA = bk.a(q30.c(bVar.itemView.getContext(), localMediaE.B() ? R$color.picture_color_half_white : R$color.picture_color_transparent), BlendModeCompat.SRC_ATOP);
        if (localMediaE.v() && localMediaE.B()) {
            bVar.d.setVisibility(0);
        } else {
            bVar.d.setVisibility(localMediaE.v() ? 0 : 8);
        }
        String strQ = localMediaE.q();
        if (!localMediaE.A() || TextUtils.isEmpty(localMediaE.i())) {
            bVar.c.setVisibility(8);
        } else {
            strQ = localMediaE.i();
            bVar.c.setVisibility(0);
        }
        bVar.a.setColorFilter(colorFilterA);
        if (this.b != null && (k01Var = PictureSelectionConfig.w1) != null) {
            k01Var.c(bVar.itemView.getContext(), strQ, bVar.a);
        }
        bVar.b.setVisibility(a22.n(localMediaE.n()) ? 0 : 8);
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: k32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.f(bVar, i, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.picture_wechat_preview_gallery, viewGroup, false));
    }

    public void i(LocalMedia localMedia) {
        if (this.a.size() > 0) {
            this.a.remove(localMedia);
            notifyDataSetChanged();
        }
    }

    public void j(a aVar) {
        this.c = aVar;
    }

    public void k(List list, boolean z) {
        if (list != null) {
            if (z) {
                this.a.clear();
                this.a.addAll(list);
            } else {
                this.a = list;
            }
            notifyDataSetChanged();
        }
    }
}
