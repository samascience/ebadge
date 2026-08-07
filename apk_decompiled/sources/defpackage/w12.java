package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.BlendModeCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R$anim;
import com.luck.picture.lib.R$attr;
import com.luck.picture.lib.R$color;
import com.luck.picture.lib.R$drawable;
import com.luck.picture.lib.R$id;
import com.luck.picture.lib.R$layout;
import com.luck.picture.lib.R$string;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class w12 extends RecyclerView.Adapter {
    private final Context a;
    private boolean b;
    private sv1 c;
    private List d = new ArrayList();
    private List e = new ArrayList();
    private final PictureSelectionConfig f;

    class a implements View.OnClickListener {
        final /* synthetic */ d12 a;

        a(d12 d12Var) {
            this.a = d12Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    public class b extends RecyclerView.ViewHolder {
        TextView a;

        public b(View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R$id.tvCamera);
            this.a = textView;
            PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
            textView.setText(w12.this.f.a == a22.t() ? w12.this.a.getString(R$string.picture_tape) : w12.this.a.getString(R$string.picture_take_picture));
        }
    }

    public static class c extends RecyclerView.ViewHolder {
        ImageView a;
        ImageView b;
        TextView c;
        TextView d;
        TextView e;
        TextView f;
        View g;
        View h;

        public c(View view) {
            super(view);
            this.g = view;
            this.a = (ImageView) view.findViewById(R$id.ivPicture);
            this.c = (TextView) view.findViewById(R$id.tvCheck);
            this.h = view.findViewById(R$id.btnCheck);
            this.d = (TextView) view.findViewById(R$id.tv_duration);
            this.e = (TextView) view.findViewById(R$id.tv_image_mime_type);
            this.f = (TextView) view.findViewById(R$id.tv_long_chart);
            this.b = (ImageView) view.findViewById(R$id.ivEditor);
            PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
            this.c.setBackground(cb.d(view.getContext(), R$attr.picture_checked_style, R$drawable.picture_checkbox_selector));
        }
    }

    public w12(Context context, PictureSelectionConfig pictureSelectionConfig) {
        this.a = context;
        this.f = pictureSelectionConfig;
        this.b = pictureSelectionConfig.f0;
    }

    private void B(String str) {
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        d12 d12Var = new d12(this.a, R$layout.picture_prompt_dialog);
        TextView textView = (TextView) d12Var.findViewById(R$id.btnOk);
        ((TextView) d12Var.findViewById(R$id.tv_content)).setText(str);
        textView.setOnClickListener(new a(d12Var));
        d12Var.show();
    }

    private void C() {
        List list = this.e;
        if (list == null || list.size() <= 0) {
            return;
        }
        notifyItemChanged(((LocalMedia) this.e.get(0)).k);
        this.e.clear();
    }

    private void D() {
        if (this.f.m0) {
            int size = this.e.size();
            int i = 0;
            while (i < size) {
                LocalMedia localMedia = (LocalMedia) this.e.get(i);
                i++;
                localMedia.f0(i);
                notifyItemChanged(localMedia.k);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:130:0x02a5  */
    private void j(c cVar, LocalMedia localMedia) {
        PictureSelectionConfig pictureSelectionConfig;
        int i;
        boolean zIsSelected = cVar.c.isSelected();
        int size = this.e.size();
        boolean z = false;
        String strN = size > 0 ? ((LocalMedia) this.e.get(0)).n() : Constants.STR_EMPTY;
        if (this.f.G0) {
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (a22.n(((LocalMedia) this.e.get(i3)).n())) {
                    i2++;
                }
            }
            if (a22.n(localMedia.n())) {
                PictureSelectionConfig pictureSelectionConfig2 = this.f;
                int i4 = pictureSelectionConfig2.y;
                if (i4 <= 0) {
                    B(this.a.getString(R$string.picture_rule));
                    return;
                }
                int i5 = pictureSelectionConfig2.w;
                if (size >= i5 && !zIsSelected) {
                    B(this.a.getString(R$string.picture_message_max_num, Integer.valueOf(i5)));
                    return;
                }
                if (i2 >= i4 && !zIsSelected) {
                    B(sv2.b(this.a, localMedia.n(), this.f.y));
                    return;
                }
                if (!zIsSelected && pictureSelectionConfig2.I > 0) {
                    long jK = localMedia.k();
                    int i6 = this.f.I;
                    if (jK < i6) {
                        B(this.a.getString(R$string.picture_choose_min_seconds, Integer.valueOf(i6 / 1000)));
                        return;
                    }
                }
                if (!zIsSelected && this.f.H > 0) {
                    long jK2 = localMedia.k();
                    int i7 = this.f.H;
                    if (jK2 > i7) {
                        B(this.a.getString(R$string.picture_choose_max_seconds, Integer.valueOf(i7 / 1000)));
                        return;
                    }
                }
            } else {
                int i8 = this.f.w;
                if (size >= i8 && !zIsSelected) {
                    B(this.a.getString(R$string.picture_message_max_num, Integer.valueOf(i8)));
                    return;
                }
            }
        } else {
            if (!TextUtils.isEmpty(strN) && !a22.p(strN, localMedia.n())) {
                B(this.a.getString(R$string.picture_rule));
                return;
            }
            if (!a22.n(strN) || (i = (pictureSelectionConfig = this.f).y) <= 0) {
                int i9 = this.f.w;
                if (size >= i9 && !zIsSelected) {
                    B(sv2.b(this.a, strN, i9));
                    return;
                }
                if (a22.n(localMedia.n())) {
                    if (!zIsSelected && this.f.I > 0) {
                        long jK3 = localMedia.k();
                        int i10 = this.f.I;
                        if (jK3 < i10) {
                            B(this.a.getString(R$string.picture_choose_min_seconds, Integer.valueOf(i10 / 1000)));
                            return;
                        }
                    }
                    if (!zIsSelected && this.f.H > 0) {
                        long jK4 = localMedia.k();
                        int i11 = this.f.H;
                        if (jK4 > i11) {
                            B(this.a.getString(R$string.picture_choose_max_seconds, Integer.valueOf(i11 / 1000)));
                            return;
                        }
                    }
                }
            } else {
                if (size >= i && !zIsSelected) {
                    B(sv2.b(this.a, strN, i));
                    return;
                }
                if (!zIsSelected && pictureSelectionConfig.I > 0) {
                    long jK5 = localMedia.k();
                    int i12 = this.f.I;
                    if (jK5 < i12) {
                        B(this.a.getString(R$string.picture_choose_min_seconds, Integer.valueOf(i12 / 1000)));
                        return;
                    }
                }
                if (!zIsSelected && this.f.H > 0) {
                    long jK6 = localMedia.k();
                    int i13 = this.f.H;
                    if (jK6 > i13) {
                        B(this.a.getString(R$string.picture_choose_max_seconds, Integer.valueOf(i13 / 1000)));
                        return;
                    }
                }
            }
        }
        if (zIsSelected) {
            for (int i14 = 0; i14 < size; i14++) {
                LocalMedia localMedia2 = (LocalMedia) this.e.get(i14);
                if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.q()) && (localMedia2.q().equals(localMedia.q()) || localMedia2.m() == localMedia.m())) {
                    this.e.remove(localMedia2);
                    D();
                    d6.a(cVar.a, this.f.a0);
                    break;
                }
            }
        } else {
            if (this.f.v == 1) {
                C();
            }
            this.e.add(localMedia);
            localMedia.f0(this.e.size());
            jg3.a().d();
            d6.c(cVar.a, this.f.a0);
            cVar.c.startAnimation(AnimationUtils.loadAnimation(this.a, R$anim.picture_anim_modal_in));
        }
        PictureSelectionConfig pictureSelectionConfig3 = this.f;
        if (pictureSelectionConfig3.e1) {
            if (pictureSelectionConfig3.a == a22.s()) {
                PictureSelectionConfig pictureSelectionConfig4 = this.f;
                if (!pictureSelectionConfig4.G0 || pictureSelectionConfig4.y <= 0) {
                    if (!zIsSelected && o() == 1) {
                        z = true;
                    }
                    if (zIsSelected && o() == 0) {
                        z = true;
                    }
                } else {
                    z = o() >= this.f.w;
                    if (zIsSelected && o() == this.f.w - 1) {
                        z = true;
                    }
                }
            } else if (this.f.a != a22.y() || this.f.y <= 0) {
                if (!zIsSelected && o() == this.f.w) {
                    z = true;
                }
                if (zIsSelected && o() == this.f.w - 1) {
                    z = true;
                }
            } else {
                if (!zIsSelected && o() == this.f.y) {
                    z = true;
                }
                if (zIsSelected && o() == this.f.y - 1) {
                    z = true;
                }
            }
        }
        if (z) {
            notifyDataSetChanged();
        } else {
            notifyItemChanged(cVar.getAbsoluteAdapterPosition());
        }
        x(cVar, !zIsSelected);
        sv1 sv1Var = this.c;
        if (sv1Var != null) {
            sv1Var.f(this.e);
        }
    }

    private void k(c cVar, LocalMedia localMedia) {
        PictureSelectionConfig pictureSelectionConfig = this.f;
        if (pictureSelectionConfig.G0 && pictureSelectionConfig.y > 0) {
            if (o() < this.f.w) {
                localMedia.c0(false);
                return;
            }
            boolean zIsSelected = cVar.c.isSelected();
            cVar.a.setColorFilter(bk.a(zIsSelected ? q30.c(this.a, R$color.picture_color_80) : q30.c(this.a, R$color.picture_color_half_white), BlendModeCompat.SRC_ATOP));
            localMedia.c0(!zIsSelected);
            return;
        }
        LocalMedia localMedia2 = this.e.size() > 0 ? (LocalMedia) this.e.get(0) : null;
        if (localMedia2 == null) {
            localMedia.c0(false);
            return;
        }
        boolean zIsSelected2 = cVar.c.isSelected();
        if (this.f.a != a22.s()) {
            if (this.f.a != a22.y() || this.f.y <= 0) {
                if (!zIsSelected2 && o() == this.f.w) {
                    cVar.a.setColorFilter(bk.a(q30.c(this.a, R$color.picture_color_half_white), BlendModeCompat.SRC_ATOP));
                }
                localMedia.c0(!zIsSelected2 && o() == this.f.w);
                return;
            }
            if (!zIsSelected2 && o() == this.f.y) {
                cVar.a.setColorFilter(bk.a(q30.c(this.a, R$color.picture_color_half_white), BlendModeCompat.SRC_ATOP));
            }
            localMedia.c0(!zIsSelected2 && o() == this.f.y);
            return;
        }
        if (a22.m(localMedia2.n())) {
            if (!zIsSelected2 && !a22.m(localMedia.n())) {
                cVar.a.setColorFilter(bk.a(q30.c(this.a, a22.n(localMedia.n()) ? R$color.picture_color_half_white : R$color.picture_color_20), BlendModeCompat.SRC_ATOP));
            }
            localMedia.c0(a22.n(localMedia.n()));
            return;
        }
        if (a22.n(localMedia2.n())) {
            if (!zIsSelected2 && !a22.n(localMedia.n())) {
                cVar.a.setColorFilter(bk.a(q30.c(this.a, a22.m(localMedia.n()) ? R$color.picture_color_half_white : R$color.picture_color_20), BlendModeCompat.SRC_ATOP));
            }
            localMedia.c0(a22.m(localMedia.n()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(View view) {
        sv1 sv1Var = this.c;
        if (sv1Var != null) {
            sv1Var.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(LocalMedia localMedia, c cVar, String str, View view) {
        String strB;
        PictureSelectionConfig pictureSelectionConfig = this.f;
        if (pictureSelectionConfig.e1) {
            if (pictureSelectionConfig.G0) {
                int iO = o();
                boolean z = false;
                int i = 0;
                for (int i2 = 0; i2 < iO; i2++) {
                    if (a22.n(((LocalMedia) this.e.get(i2)).n())) {
                        i++;
                    }
                }
                if (a22.n(localMedia.n())) {
                    if (!cVar.c.isSelected() && i >= this.f.y) {
                        z = true;
                    }
                    strB = sv2.b(this.a, localMedia.n(), this.f.y);
                } else {
                    if (!cVar.c.isSelected() && iO >= this.f.w) {
                        z = true;
                    }
                    strB = sv2.b(this.a, localMedia.n(), this.f.w);
                }
                if (z) {
                    B(strB);
                    return;
                }
            } else if (!cVar.c.isSelected() && o() >= this.f.w) {
                B(sv2.b(this.a, localMedia.n(), this.f.w));
                return;
            }
        }
        String strS = localMedia.s();
        if (TextUtils.isEmpty(strS) || new File(strS).exists()) {
            j(cVar, localMedia);
        } else {
            Context context = this.a;
            p33.b(context, a22.A(context, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
    
        if (r4.v != 1) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void v(com.luck.picture.lib.entity.LocalMedia r3, java.lang.String r4, int r5, w12.c r6, android.view.View r7) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w12.v(com.luck.picture.lib.entity.LocalMedia, java.lang.String, int, w12$c, android.view.View):void");
    }

    private void w(c cVar, LocalMedia localMedia) {
        cVar.c.setText(Constants.STR_EMPTY);
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            LocalMedia localMedia2 = (LocalMedia) this.e.get(i);
            if (localMedia2.q().equals(localMedia.q()) || localMedia2.m() == localMedia.m()) {
                localMedia.f0(localMedia2.o());
                localMedia2.o0(localMedia.r());
                cVar.c.setText(db3.e(Integer.valueOf(localMedia.o())));
            }
        }
    }

    private void y(LocalMedia localMedia, LocalMedia localMedia2) {
        if (!localMedia.A() || localMedia2.A()) {
            return;
        }
        localMedia2.S(localMedia.z());
        localMedia2.T(localMedia.i());
        localMedia2.O(localMedia.e());
        localMedia2.N(localMedia.d());
        localMedia2.P(localMedia.f());
        localMedia2.Q(localMedia.g());
        localMedia2.R(localMedia.h());
        localMedia2.H(localMedia.a());
        localMedia2.X(localMedia.A());
    }

    public void A(boolean z) {
        this.b = z;
    }

    public void clear() {
        if (p() > 0) {
            this.d.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b ? this.d.size() + 1 : this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (this.b && i == 0) ? 1 : 2;
    }

    public void h(List list) {
        if (list == null) {
            list = new ArrayList();
        }
        this.d = list;
        notifyDataSetChanged();
    }

    public void i(List list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add((LocalMedia) list.get(i));
        }
        this.e = arrayList;
        if (this.f.c) {
            return;
        }
        D();
        sv1 sv1Var = this.c;
        if (sv1Var != null) {
            sv1Var.f(this.e);
        }
    }

    public List l() {
        List list = this.d;
        return list == null ? new ArrayList() : list;
    }

    public LocalMedia m(int i) {
        if (p() > 0) {
            return (LocalMedia) this.d.get(i);
        }
        return null;
    }

    public List n() {
        List list = this.e;
        return list == null ? new ArrayList() : list;
    }

    public int o() {
        List list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        Context context;
        int i2;
        if (getItemViewType(i) == 1) {
            ((b) viewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: t12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.t(view);
                }
            });
            return;
        }
        final c cVar = (c) viewHolder;
        final LocalMedia localMedia = (LocalMedia) this.d.get(this.b ? i - 1 : i);
        localMedia.k = cVar.getAbsoluteAdapterPosition();
        final String strN = localMedia.n();
        if (this.f.m0) {
            w(cVar, localMedia);
        }
        if (this.f.c) {
            cVar.c.setVisibility(8);
            cVar.h.setVisibility(8);
        } else {
            x(cVar, r(localMedia));
            cVar.c.setVisibility(0);
            cVar.h.setVisibility(0);
            if (this.f.e1) {
                k(cVar, localMedia);
            }
        }
        String strQ = localMedia.q();
        if (!localMedia.A() || TextUtils.isEmpty(localMedia.i())) {
            cVar.b.setVisibility(8);
        } else {
            cVar.b.setVisibility(0);
            strQ = localMedia.i();
        }
        boolean zI = a22.i(strN);
        boolean zR = a22.r(strN);
        boolean zJ = gi1.j(localMedia);
        if ((zI || zR) && !zJ) {
            cVar.e.setVisibility(0);
            TextView textView = cVar.e;
            if (zI) {
                context = this.a;
                i2 = R$string.picture_gif_tag;
            } else {
                context = this.a;
                i2 = R$string.picture_webp_tag;
            }
            textView.setText(context.getString(i2));
        } else {
            cVar.e.setVisibility(8);
        }
        if (a22.m(localMedia.n())) {
            if (localMedia.G == -1) {
                localMedia.H = zJ;
                localMedia.G = 0;
            }
            cVar.f.setVisibility(localMedia.H ? 0 : 8);
        } else {
            localMedia.G = -1;
            cVar.f.setVisibility(8);
        }
        boolean zN = a22.n(strN);
        if (zN || a22.k(strN)) {
            cVar.d.setVisibility(0);
            cVar.d.setText(y60.b(localMedia.k()));
            PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
            cVar.d.setCompoundDrawablesRelativeWithIntrinsicBounds(zN ? R$drawable.picture_icon_video : R$drawable.picture_icon_audio, 0, 0, 0);
        } else {
            cVar.d.setVisibility(8);
        }
        if (this.f.a == a22.t()) {
            cVar.a.setImageResource(R$drawable.picture_audio_placeholder);
        } else {
            k01 k01Var = PictureSelectionConfig.w1;
            if (k01Var != null) {
                k01Var.d(this.a, strQ, cVar.a);
            }
        }
        PictureSelectionConfig pictureSelectionConfig = this.f;
        if (pictureSelectionConfig.j0 || pictureSelectionConfig.k0 || pictureSelectionConfig.l0) {
            cVar.h.setOnClickListener(new View.OnClickListener() { // from class: u12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.u(localMedia, cVar, strN, view);
                }
            });
        }
        cVar.g.setOnClickListener(new View.OnClickListener() { // from class: v12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.v(localMedia, strN, i, cVar, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(LayoutInflater.from(this.a).inflate(R$layout.picture_item_camera, viewGroup, false)) : new c(LayoutInflater.from(this.a).inflate(R$layout.picture_image_grid_item, viewGroup, false));
    }

    public int p() {
        List list = this.d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public boolean q() {
        List list = this.d;
        return list == null || list.size() == 0;
    }

    public boolean r(LocalMedia localMedia) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            LocalMedia localMedia2 = (LocalMedia) this.e.get(i);
            if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.q()) && (TextUtils.equals(localMedia2.q(), localMedia.q()) || localMedia2.m() == localMedia.m())) {
                y(localMedia2, localMedia);
                return true;
            }
        }
        return false;
    }

    public boolean s() {
        return this.b;
    }

    public void x(c cVar, boolean z) {
        cVar.c.setSelected(z);
        cVar.a.setColorFilter(bk.a(z ? q30.c(this.a, R$color.picture_color_80) : q30.c(this.a, R$color.picture_color_20), BlendModeCompat.SRC_ATOP));
    }

    public void z(sv1 sv1Var) {
        this.c = sv1Var;
    }
}
