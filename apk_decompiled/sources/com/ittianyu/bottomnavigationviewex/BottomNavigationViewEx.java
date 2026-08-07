package com.ittianyu.bottomnavigationviewex;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/* JADX INFO: loaded from: classes3.dex */
public class BottomNavigationViewEx extends BottomNavigationViewInner {
    public BottomNavigationViewEx(Context context) {
        super(context);
    }

    @Override // com.ittianyu.bottomnavigationviewex.BottomNavigationViewInner
    public BottomNavigationViewInner a() {
        try {
            return super.a();
        } catch (Exception unused) {
            return this;
        }
    }

    @Override // com.ittianyu.bottomnavigationviewex.BottomNavigationViewInner
    public BottomNavigationItemView[] getBottomNavigationItemViews() {
        try {
            return super.getBottomNavigationItemViews();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.ittianyu.bottomnavigationviewex.BottomNavigationViewInner
    public BottomNavigationMenuView getBottomNavigationMenuView() {
        return super.getBottomNavigationMenuView();
    }

    @Override // com.ittianyu.bottomnavigationviewex.BottomNavigationViewInner
    public int getCurrentItem() {
        try {
            return super.getCurrentItem();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.ittianyu.bottomnavigationviewex.BottomNavigationViewInner
    public int getItemCount() {
        try {
            return super.getItemCount();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.ittianyu.bottomnavigationviewex.BottomNavigationViewInner
    public int getItemHeight() {
        try {
            return super.getItemHeight();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.ittianyu.bottomnavigationviewex.BottomNavigationViewInner
    public BottomNavigationView.c getOnNavigationItemSelectedListener() {
        try {
            super.getOnNavigationItemSelectedListener();
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // com.ittianyu.bottomnavigationviewex.BottomNavigationViewInner, com.google.android.material.bottomnavigation.BottomNavigationView
    public void setOnNavigationItemSelectedListener(BottomNavigationView.c cVar) {
        try {
            super.setOnNavigationItemSelectedListener(cVar);
        } catch (Exception unused) {
        }
    }

    public BottomNavigationViewEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BottomNavigationViewEx(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
