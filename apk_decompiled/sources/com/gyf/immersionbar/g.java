package com.gyf.immersionbar;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes3.dex */
abstract class g {

    static class a {
        public boolean a = false;
        public boolean b = false;
        public NavigationBarType c;

        a() {
        }

        public String toString() {
            return "GestureBean{isGesture=" + this.a + ", checkNavigation=" + this.b + ", type=" + this.c + '}';
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x007b A[PHI: r1 r2
      0x007b: PHI (r1v15 com.gyf.immersionbar.NavigationBarType) = (r1v13 com.gyf.immersionbar.NavigationBarType), (r1v26 com.gyf.immersionbar.NavigationBarType) binds: [B:69:0x00d4, B:39:0x0079] A[DONT_GENERATE, DONT_INLINE]
      0x007b: PHI (r2v14 int) = (r2v13 int), (r2v27 int) binds: [B:69:0x00d4, B:39:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:47:0x008e A[PHI: r1 r2
      0x008e: PHI (r1v4 com.gyf.immersionbar.NavigationBarType) = 
      (r1v2 com.gyf.immersionbar.NavigationBarType)
      (r1v13 com.gyf.immersionbar.NavigationBarType)
      (r1v16 com.gyf.immersionbar.NavigationBarType)
      (r1v17 com.gyf.immersionbar.NavigationBarType)
      (r1v19 com.gyf.immersionbar.NavigationBarType)
      (r1v21 com.gyf.immersionbar.NavigationBarType)
      (r1v26 com.gyf.immersionbar.NavigationBarType)
     binds: [B:78:0x00f0, B:69:0x00d4, B:63:0x00bc, B:61:0x00b7, B:56:0x00a7, B:46:0x008c, B:39:0x0079] A[DONT_GENERATE, DONT_INLINE]
      0x008e: PHI (r2v5 int) = (r2v3 int), (r2v13 int), (r2v18 int), (r2v18 int), (r2v22 int), (r2v29 int), (r2v27 int) binds: [B:78:0x00f0, B:69:0x00d4, B:63:0x00bc, B:61:0x00b7, B:56:0x00a7, B:46:0x008c, B:39:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x010c  */
    public static a a(Context context) {
        int i;
        boolean z;
        boolean z2;
        a aVar = new a();
        if (context != null && context.getContentResolver() != null) {
            ContentResolver contentResolver = context.getContentResolver();
            NavigationBarType navigationBarType = NavigationBarType.UNKNOWN;
            boolean z3 = false;
            boolean z4 = true;
            if (OSUtils.isHuaWei() || OSUtils.isEMUI()) {
                i = !OSUtils.isEMUI3_x() ? Settings.Global.getInt(contentResolver, "navigationbar_is_min", -1) : Settings.System.getInt(contentResolver, "navigationbar_is_min", -1);
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i == 1) {
                    navigationBarType = NavigationBarType.GESTURES;
                    z = false;
                    z2 = true;
                }
                z = false;
                z2 = false;
            } else if (OSUtils.isXiaoMi() || OSUtils.isMIUI()) {
                i = Settings.Global.getInt(contentResolver, "force_fsg_nav_bar", -1);
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i == 1) {
                    navigationBarType = NavigationBarType.GESTURES;
                    if (Settings.Global.getInt(contentResolver, "hide_gesture_line", -1) != 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = true;
                }
                z = false;
                z2 = false;
            } else if (OSUtils.isVivo() || OSUtils.isFuntouchOrOriginOs()) {
                i = Settings.Secure.getInt(contentResolver, "navigation_gesture_on", -1);
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else {
                    if (i == 1) {
                        navigationBarType = NavigationBarType.GESTURES_THREE_STAGE;
                    } else if (i == 2) {
                        navigationBarType = NavigationBarType.GESTURES;
                    }
                    z = false;
                    z2 = true;
                }
                z = false;
                z2 = false;
            } else if (OSUtils.isOppo() || OSUtils.isColorOs()) {
                i = Settings.Secure.getInt(contentResolver, "hide_navigationbar_enable", -1);
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i == 1 || i == 2 || i == 3) {
                    navigationBarType = NavigationBarType.GESTURES;
                    z = false;
                    z2 = true;
                }
                z = false;
                z2 = false;
            } else if (OSUtils.isSamsung()) {
                i = Settings.Global.getInt(contentResolver, "navigation_bar_gesture_while_hidden", -1);
                if (i != -1) {
                    if (i == 0) {
                        navigationBarType = NavigationBarType.CLASSIC;
                    } else if (i == 1) {
                        navigationBarType = Settings.Global.getInt(contentResolver, "navigation_bar_gesture_detail_type", 1) == 1 ? NavigationBarType.GESTURES : NavigationBarType.GESTURES_THREE_STAGE;
                        if (Settings.Global.getInt(contentResolver, "navigation_bar_gesture_hint", 1) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        z2 = true;
                    }
                    z = false;
                    z2 = false;
                } else {
                    i = Settings.Global.getInt(contentResolver, "navigationbar_hide_bar_enabled", -1);
                    if (i == 0) {
                        navigationBarType = NavigationBarType.CLASSIC;
                    } else if (i == 1) {
                        navigationBarType = NavigationBarType.GESTURES;
                        z = false;
                        z2 = true;
                    }
                    z = false;
                    z2 = false;
                }
            } else {
                z = false;
                z2 = false;
                i = -1;
            }
            if (i != -1) {
                z4 = z;
                z3 = z2;
            } else {
                int i2 = Settings.Secure.getInt(contentResolver, "navigation_mode", -1);
                if (i2 == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i2 == 1) {
                    navigationBarType = NavigationBarType.DOUBLE;
                } else if (i2 == 2) {
                    navigationBarType = NavigationBarType.GESTURES;
                    z3 = true;
                } else {
                    z4 = z;
                    z3 = z2;
                }
                z4 = z;
            }
            aVar.a = z3;
            aVar.b = z4;
            aVar.c = navigationBarType;
        }
        return aVar;
    }
}
