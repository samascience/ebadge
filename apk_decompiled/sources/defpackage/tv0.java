package defpackage;

import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class tv0 {
    public static List a(int i, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(f());
        if (i == 0 || i == 1 || i == 3) {
            arrayList.addAll(h());
        }
        if (i == 1 || i == 3) {
            arrayList.addAll(e());
        }
        if (z) {
            arrayList.addAll(j());
        }
        if (z2 && i == 0) {
            arrayList.addAll(c());
        }
        if (i == 3) {
            arrayList.addAll(g());
        }
        return arrayList;
    }

    public static List b() {
        ArrayList arrayList = new ArrayList();
        xw2 xw2Var = new xw2();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        xw2Var.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var);
        xw2 xw2Var2 = new xw2();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        xw2Var2.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(xw2Var2);
        xw2 xw2Var3 = new xw2();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        xw2Var3.a(SurfaceConfig.a(configType, configSize2));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        xw2Var3.a(SurfaceConfig.a(configType3, configSize));
        arrayList.add(xw2Var3);
        xw2 xw2Var4 = new xw2();
        xw2Var4.a(SurfaceConfig.a(configType, configSize2));
        xw2Var4.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(xw2Var4);
        xw2 xw2Var5 = new xw2();
        xw2Var5.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var5.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(xw2Var5);
        xw2 xw2Var6 = new xw2();
        xw2Var6.a(SurfaceConfig.a(configType, configSize2));
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.RECORD;
        xw2Var6.a(SurfaceConfig.a(configType, configSize3));
        arrayList.add(xw2Var6);
        xw2 xw2Var7 = new xw2();
        xw2Var7.a(SurfaceConfig.a(configType, configSize2));
        xw2Var7.a(SurfaceConfig.a(configType, configSize3));
        xw2Var7.a(SurfaceConfig.a(configType2, configSize3));
        arrayList.add(xw2Var7);
        xw2 xw2Var8 = new xw2();
        xw2Var8.a(SurfaceConfig.a(configType, configSize2));
        xw2Var8.a(SurfaceConfig.a(configType, configSize3));
        xw2Var8.a(SurfaceConfig.a(configType3, configSize3));
        arrayList.add(xw2Var8);
        return arrayList;
    }

    public static List c() {
        ArrayList arrayList = new ArrayList();
        xw2 xw2Var = new xw2();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        xw2Var.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        xw2Var.a(SurfaceConfig.a(configType, configSize2));
        arrayList.add(xw2Var);
        xw2 xw2Var2 = new xw2();
        xw2Var2.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        xw2Var2.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(xw2Var2);
        xw2 xw2Var3 = new xw2();
        xw2Var3.a(SurfaceConfig.a(configType2, configSize));
        xw2Var3.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(xw2Var3);
        return arrayList;
    }

    public static List d() {
        ArrayList arrayList = new ArrayList();
        xw2 xw2Var = new xw2();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.s1440p;
        xw2Var.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var);
        xw2 xw2Var2 = new xw2();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.PRIV;
        xw2Var2.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(xw2Var2);
        xw2 xw2Var3 = new xw2();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        xw2Var3.a(SurfaceConfig.a(configType3, configSize));
        arrayList.add(xw2Var3);
        xw2 xw2Var4 = new xw2();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.s720p;
        xw2Var4.a(SurfaceConfig.a(configType, configSize2));
        xw2Var4.a(SurfaceConfig.a(configType3, configSize));
        arrayList.add(xw2Var4);
        xw2 xw2Var5 = new xw2();
        xw2Var5.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var5.a(SurfaceConfig.a(configType3, configSize));
        arrayList.add(xw2Var5);
        xw2 xw2Var6 = new xw2();
        xw2Var6.a(SurfaceConfig.a(configType, configSize2));
        xw2Var6.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var6);
        xw2 xw2Var7 = new xw2();
        xw2Var7.a(SurfaceConfig.a(configType, configSize2));
        xw2Var7.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(xw2Var7);
        xw2 xw2Var8 = new xw2();
        xw2Var8.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var8.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var8);
        xw2 xw2Var9 = new xw2();
        xw2Var9.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var9.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(xw2Var9);
        return arrayList;
    }

    public static List e() {
        ArrayList arrayList = new ArrayList();
        xw2 xw2Var = new xw2();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        xw2Var.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        xw2Var.a(SurfaceConfig.a(configType, configSize2));
        arrayList.add(xw2Var);
        xw2 xw2Var2 = new xw2();
        xw2Var2.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        xw2Var2.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(xw2Var2);
        xw2 xw2Var3 = new xw2();
        xw2Var3.a(SurfaceConfig.a(configType2, configSize));
        xw2Var3.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(xw2Var3);
        xw2 xw2Var4 = new xw2();
        xw2Var4.a(SurfaceConfig.a(configType, configSize));
        xw2Var4.a(SurfaceConfig.a(configType, configSize));
        xw2Var4.a(SurfaceConfig.a(SurfaceConfig.ConfigType.JPEG, configSize2));
        arrayList.add(xw2Var4);
        xw2 xw2Var5 = new xw2();
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.VGA;
        xw2Var5.a(SurfaceConfig.a(configType2, configSize3));
        xw2Var5.a(SurfaceConfig.a(configType, configSize));
        xw2Var5.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(xw2Var5);
        xw2 xw2Var6 = new xw2();
        xw2Var6.a(SurfaceConfig.a(configType2, configSize3));
        xw2Var6.a(SurfaceConfig.a(configType2, configSize));
        xw2Var6.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(xw2Var6);
        return arrayList;
    }

    public static List f() {
        ArrayList arrayList = new ArrayList();
        xw2 xw2Var = new xw2();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        xw2Var.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var);
        xw2 xw2Var2 = new xw2();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.JPEG;
        xw2Var2.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(xw2Var2);
        xw2 xw2Var3 = new xw2();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.YUV;
        xw2Var3.a(SurfaceConfig.a(configType3, configSize));
        arrayList.add(xw2Var3);
        xw2 xw2Var4 = new xw2();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        xw2Var4.a(SurfaceConfig.a(configType, configSize2));
        xw2Var4.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(xw2Var4);
        xw2 xw2Var5 = new xw2();
        xw2Var5.a(SurfaceConfig.a(configType3, configSize2));
        xw2Var5.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(xw2Var5);
        xw2 xw2Var6 = new xw2();
        xw2Var6.a(SurfaceConfig.a(configType, configSize2));
        xw2Var6.a(SurfaceConfig.a(configType, configSize2));
        arrayList.add(xw2Var6);
        xw2 xw2Var7 = new xw2();
        xw2Var7.a(SurfaceConfig.a(configType, configSize2));
        xw2Var7.a(SurfaceConfig.a(configType3, configSize2));
        arrayList.add(xw2Var7);
        xw2 xw2Var8 = new xw2();
        xw2Var8.a(SurfaceConfig.a(configType, configSize2));
        xw2Var8.a(SurfaceConfig.a(configType3, configSize2));
        xw2Var8.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(xw2Var8);
        return arrayList;
    }

    public static List g() {
        ArrayList arrayList = new ArrayList();
        xw2 xw2Var = new xw2();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        xw2Var.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.VGA;
        xw2Var.a(SurfaceConfig.a(configType, configSize2));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.MAXIMUM;
        xw2Var.a(SurfaceConfig.a(configType2, configSize3));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.RAW;
        xw2Var.a(SurfaceConfig.a(configType3, configSize3));
        arrayList.add(xw2Var);
        xw2 xw2Var2 = new xw2();
        xw2Var2.a(SurfaceConfig.a(configType, configSize));
        xw2Var2.a(SurfaceConfig.a(configType, configSize2));
        xw2Var2.a(SurfaceConfig.a(SurfaceConfig.ConfigType.JPEG, configSize3));
        xw2Var2.a(SurfaceConfig.a(configType3, configSize3));
        arrayList.add(xw2Var2);
        return arrayList;
    }

    public static List h() {
        ArrayList arrayList = new ArrayList();
        xw2 xw2Var = new xw2();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        xw2Var.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.RECORD;
        xw2Var.a(SurfaceConfig.a(configType, configSize2));
        arrayList.add(xw2Var);
        xw2 xw2Var2 = new xw2();
        xw2Var2.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        xw2Var2.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(xw2Var2);
        xw2 xw2Var3 = new xw2();
        xw2Var3.a(SurfaceConfig.a(configType2, configSize));
        xw2Var3.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(xw2Var3);
        xw2 xw2Var4 = new xw2();
        xw2Var4.a(SurfaceConfig.a(configType, configSize));
        xw2Var4.a(SurfaceConfig.a(configType, configSize2));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        xw2Var4.a(SurfaceConfig.a(configType3, configSize2));
        arrayList.add(xw2Var4);
        xw2 xw2Var5 = new xw2();
        xw2Var5.a(SurfaceConfig.a(configType, configSize));
        xw2Var5.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var5.a(SurfaceConfig.a(configType3, configSize2));
        arrayList.add(xw2Var5);
        xw2 xw2Var6 = new xw2();
        xw2Var6.a(SurfaceConfig.a(configType2, configSize));
        xw2Var6.a(SurfaceConfig.a(configType2, configSize));
        xw2Var6.a(SurfaceConfig.a(configType3, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(xw2Var6);
        return arrayList;
    }

    public static List i() {
        ArrayList arrayList = new ArrayList();
        xw2 xw2Var = new xw2();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.s1440p;
        xw2Var.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var);
        xw2 xw2Var2 = new xw2();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        xw2Var2.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(xw2Var2);
        xw2 xw2Var3 = new xw2();
        xw2Var3.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        xw2Var3.a(SurfaceConfig.a(configType3, configSize2));
        arrayList.add(xw2Var3);
        xw2 xw2Var4 = new xw2();
        xw2Var4.a(SurfaceConfig.a(configType2, configSize));
        xw2Var4.a(SurfaceConfig.a(configType3, configSize2));
        arrayList.add(xw2Var4);
        xw2 xw2Var5 = new xw2();
        xw2Var5.a(SurfaceConfig.a(configType, configSize));
        xw2Var5.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(xw2Var5);
        xw2 xw2Var6 = new xw2();
        xw2Var6.a(SurfaceConfig.a(configType2, configSize));
        xw2Var6.a(SurfaceConfig.a(configType2, configSize2));
        arrayList.add(xw2Var6);
        xw2 xw2Var7 = new xw2();
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.PREVIEW;
        xw2Var7.a(SurfaceConfig.a(configType, configSize3));
        xw2Var7.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var7);
        xw2 xw2Var8 = new xw2();
        xw2Var8.a(SurfaceConfig.a(configType2, configSize3));
        xw2Var8.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var8);
        xw2 xw2Var9 = new xw2();
        xw2Var9.a(SurfaceConfig.a(configType, configSize3));
        xw2Var9.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(xw2Var9);
        xw2 xw2Var10 = new xw2();
        xw2Var10.a(SurfaceConfig.a(configType2, configSize3));
        xw2Var10.a(SurfaceConfig.a(configType2, configSize));
        arrayList.add(xw2Var10);
        return arrayList;
    }

    public static List j() {
        ArrayList arrayList = new ArrayList();
        xw2 xw2Var = new xw2();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.RAW;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        xw2Var.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var);
        xw2 xw2Var2 = new xw2();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        xw2Var2.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var2.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var2);
        xw2 xw2Var3 = new xw2();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.YUV;
        xw2Var3.a(SurfaceConfig.a(configType3, configSize2));
        xw2Var3.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var3);
        xw2 xw2Var4 = new xw2();
        xw2Var4.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var4.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var4.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var4);
        xw2 xw2Var5 = new xw2();
        xw2Var5.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var5.a(SurfaceConfig.a(configType3, configSize2));
        xw2Var5.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var5);
        xw2 xw2Var6 = new xw2();
        xw2Var6.a(SurfaceConfig.a(configType3, configSize2));
        xw2Var6.a(SurfaceConfig.a(configType3, configSize2));
        xw2Var6.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var6);
        xw2 xw2Var7 = new xw2();
        xw2Var7.a(SurfaceConfig.a(configType2, configSize2));
        SurfaceConfig.ConfigType configType4 = SurfaceConfig.ConfigType.JPEG;
        xw2Var7.a(SurfaceConfig.a(configType4, configSize));
        xw2Var7.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var7);
        xw2 xw2Var8 = new xw2();
        xw2Var8.a(SurfaceConfig.a(configType3, configSize2));
        xw2Var8.a(SurfaceConfig.a(configType4, configSize));
        xw2Var8.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var8);
        return arrayList;
    }

    public static List k() {
        ArrayList arrayList = new ArrayList();
        xw2 xw2Var = new xw2();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.s1440p;
        xw2Var.a(SurfaceConfig.b(configType, configSize, 4L));
        arrayList.add(xw2Var);
        xw2 xw2Var2 = new xw2();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        xw2Var2.a(SurfaceConfig.b(configType2, configSize, 4L));
        arrayList.add(xw2Var2);
        xw2 xw2Var3 = new xw2();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.RECORD;
        xw2Var3.a(SurfaceConfig.b(configType, configSize2, 3L));
        arrayList.add(xw2Var3);
        xw2 xw2Var4 = new xw2();
        xw2Var4.a(SurfaceConfig.b(configType2, configSize2, 3L));
        arrayList.add(xw2Var4);
        xw2 xw2Var5 = new xw2();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.MAXIMUM;
        xw2Var5.a(SurfaceConfig.b(configType3, configSize3, 2L));
        arrayList.add(xw2Var5);
        xw2 xw2Var6 = new xw2();
        xw2Var6.a(SurfaceConfig.b(configType2, configSize3, 2L));
        arrayList.add(xw2Var6);
        xw2 xw2Var7 = new xw2();
        SurfaceConfig.ConfigSize configSize4 = SurfaceConfig.ConfigSize.PREVIEW;
        xw2Var7.a(SurfaceConfig.b(configType, configSize4, 1L));
        xw2Var7.a(SurfaceConfig.b(configType3, configSize3, 2L));
        arrayList.add(xw2Var7);
        xw2 xw2Var8 = new xw2();
        xw2Var8.a(SurfaceConfig.b(configType, configSize4, 1L));
        xw2Var8.a(SurfaceConfig.b(configType2, configSize3, 2L));
        arrayList.add(xw2Var8);
        xw2 xw2Var9 = new xw2();
        xw2Var9.a(SurfaceConfig.b(configType, configSize4, 1L));
        xw2Var9.a(SurfaceConfig.b(configType, configSize2, 3L));
        arrayList.add(xw2Var9);
        xw2 xw2Var10 = new xw2();
        xw2Var10.a(SurfaceConfig.b(configType, configSize4, 1L));
        xw2Var10.a(SurfaceConfig.b(configType2, configSize2, 3L));
        arrayList.add(xw2Var10);
        xw2 xw2Var11 = new xw2();
        xw2Var11.a(SurfaceConfig.b(configType, configSize4, 1L));
        xw2Var11.a(SurfaceConfig.b(configType2, configSize4, 1L));
        arrayList.add(xw2Var11);
        xw2 xw2Var12 = new xw2();
        xw2Var12.a(SurfaceConfig.b(configType, configSize4, 1L));
        xw2Var12.a(SurfaceConfig.b(configType, configSize2, 3L));
        xw2Var12.a(SurfaceConfig.b(configType3, configSize2, 2L));
        arrayList.add(xw2Var12);
        xw2 xw2Var13 = new xw2();
        xw2Var13.a(SurfaceConfig.b(configType, configSize4, 1L));
        xw2Var13.a(SurfaceConfig.b(configType2, configSize2, 3L));
        xw2Var13.a(SurfaceConfig.b(configType3, configSize2, 2L));
        arrayList.add(xw2Var13);
        xw2 xw2Var14 = new xw2();
        xw2Var14.a(SurfaceConfig.b(configType, configSize4, 1L));
        xw2Var14.a(SurfaceConfig.b(configType2, configSize4, 1L));
        xw2Var14.a(SurfaceConfig.b(configType3, configSize3, 2L));
        arrayList.add(xw2Var14);
        return arrayList;
    }

    public static List l() {
        ArrayList arrayList = new ArrayList();
        xw2 xw2Var = new xw2();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.JPEG_R;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        xw2Var.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var);
        xw2 xw2Var2 = new xw2();
        xw2Var2.a(SurfaceConfig.a(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        xw2Var2.a(SurfaceConfig.a(configType, configSize));
        arrayList.add(xw2Var2);
        return arrayList;
    }

    public static List m() {
        ArrayList arrayList = new ArrayList();
        xw2 xw2Var = new xw2();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.ULTRA_MAXIMUM;
        xw2Var.a(SurfaceConfig.a(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        xw2Var.a(SurfaceConfig.a(configType2, configSize2));
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.RECORD;
        xw2Var.a(SurfaceConfig.a(configType2, configSize3));
        arrayList.add(xw2Var);
        xw2 xw2Var2 = new xw2();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        xw2Var2.a(SurfaceConfig.a(configType3, configSize));
        xw2Var2.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var2.a(SurfaceConfig.a(configType2, configSize3));
        arrayList.add(xw2Var2);
        xw2 xw2Var3 = new xw2();
        SurfaceConfig.ConfigType configType4 = SurfaceConfig.ConfigType.RAW;
        xw2Var3.a(SurfaceConfig.a(configType4, configSize));
        xw2Var3.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var3.a(SurfaceConfig.a(configType2, configSize3));
        arrayList.add(xw2Var3);
        xw2 xw2Var4 = new xw2();
        xw2Var4.a(SurfaceConfig.a(configType, configSize));
        xw2Var4.a(SurfaceConfig.a(configType2, configSize2));
        SurfaceConfig.ConfigSize configSize4 = SurfaceConfig.ConfigSize.MAXIMUM;
        xw2Var4.a(SurfaceConfig.a(configType3, configSize4));
        arrayList.add(xw2Var4);
        xw2 xw2Var5 = new xw2();
        xw2Var5.a(SurfaceConfig.a(configType3, configSize));
        xw2Var5.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var5.a(SurfaceConfig.a(configType3, configSize4));
        arrayList.add(xw2Var5);
        xw2 xw2Var6 = new xw2();
        xw2Var6.a(SurfaceConfig.a(configType4, configSize));
        xw2Var6.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var6.a(SurfaceConfig.a(configType3, configSize4));
        arrayList.add(xw2Var6);
        xw2 xw2Var7 = new xw2();
        xw2Var7.a(SurfaceConfig.a(configType, configSize));
        xw2Var7.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var7.a(SurfaceConfig.a(configType, configSize4));
        arrayList.add(xw2Var7);
        xw2 xw2Var8 = new xw2();
        xw2Var8.a(SurfaceConfig.a(configType3, configSize));
        xw2Var8.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var8.a(SurfaceConfig.a(configType, configSize4));
        arrayList.add(xw2Var8);
        xw2 xw2Var9 = new xw2();
        xw2Var9.a(SurfaceConfig.a(configType4, configSize));
        xw2Var9.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var9.a(SurfaceConfig.a(configType, configSize4));
        arrayList.add(xw2Var9);
        xw2 xw2Var10 = new xw2();
        xw2Var10.a(SurfaceConfig.a(configType, configSize));
        xw2Var10.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var10.a(SurfaceConfig.a(configType4, configSize4));
        arrayList.add(xw2Var10);
        xw2 xw2Var11 = new xw2();
        xw2Var11.a(SurfaceConfig.a(configType3, configSize));
        xw2Var11.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var11.a(SurfaceConfig.a(configType4, configSize4));
        arrayList.add(xw2Var11);
        xw2 xw2Var12 = new xw2();
        xw2Var12.a(SurfaceConfig.a(configType4, configSize));
        xw2Var12.a(SurfaceConfig.a(configType2, configSize2));
        xw2Var12.a(SurfaceConfig.a(configType4, configSize4));
        arrayList.add(xw2Var12);
        return arrayList;
    }
}
