package com.ittianyu.bottomnavigationviewex;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Menu;
import androidx.appcompat.widget.e0;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import defpackage.e43;
import defpackage.o23;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"RestrictedApi"})
public class BottomNavigationViewInner extends BottomNavigationView {
    private boolean a;
    private BottomNavigationMenuView b;
    private BottomNavigationItemView[] c;

    public BottomNavigationViewInner(Context context) {
        this(context, null);
    }

    private Object b(Class cls, Object obj, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public BottomNavigationViewInner a() {
        getBottomNavigationMenuView().setIconTintList(null);
        return this;
    }

    public BottomNavigationItemView[] getBottomNavigationItemViews() {
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.c;
        if (bottomNavigationItemViewArr != null) {
            return bottomNavigationItemViewArr;
        }
        BottomNavigationMenuView bottomNavigationMenuView = getBottomNavigationMenuView();
        BottomNavigationItemView[] bottomNavigationItemViewArr2 = (BottomNavigationItemView[]) b(bottomNavigationMenuView.getClass(), bottomNavigationMenuView, "buttons");
        this.c = bottomNavigationItemViewArr2;
        return bottomNavigationItemViewArr2;
    }

    public BottomNavigationMenuView getBottomNavigationMenuView() {
        if (this.b == null) {
            this.b = (BottomNavigationMenuView) b(BottomNavigationView.class, this, "menuView");
        }
        return this.b;
    }

    public int getCurrentItem() {
        BottomNavigationItemView[] bottomNavigationItemViews = getBottomNavigationItemViews();
        Menu menu = getMenu();
        for (int i = 0; i < bottomNavigationItemViews.length; i++) {
            if (menu.getItem(i).isChecked()) {
                return i;
            }
        }
        return 0;
    }

    public int getItemCount() {
        BottomNavigationItemView[] bottomNavigationItemViews = getBottomNavigationItemViews();
        if (bottomNavigationItemViews == null) {
            return 0;
        }
        return bottomNavigationItemViews.length;
    }

    public int getItemHeight() {
        BottomNavigationMenuView bottomNavigationMenuView = getBottomNavigationMenuView();
        return ((Integer) b(bottomNavigationMenuView.getClass(), bottomNavigationMenuView, "itemHeight")).intValue();
    }

    public BottomNavigationView.c getOnNavigationItemSelectedListener() {
        e43.a(b(BottomNavigationView.class, this, "selectedListener"));
        return null;
    }

    @Override // com.google.android.material.bottomnavigation.BottomNavigationView
    public void setOnNavigationItemSelectedListener(BottomNavigationView.c cVar) {
        super.setOnNavigationItemSelectedListener(cVar);
    }

    public BottomNavigationViewInner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationViewInner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        e0 e0VarJ = o23.j(context, attributeSet, com.google.android.material.R$styleable.BottomNavigationView, i, com.google.android.material.R$style.Widget_Design_BottomNavigationView, com.google.android.material.R$styleable.BottomNavigationView_itemTextAppearanceInactive, com.google.android.material.R$styleable.BottomNavigationView_itemTextAppearanceActive);
        if (!e0VarJ.s(com.google.android.material.R$styleable.BottomNavigationView_itemIconTint)) {
            a();
        }
        e0VarJ.x();
    }
}
