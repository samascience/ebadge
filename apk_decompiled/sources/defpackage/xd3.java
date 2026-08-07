package defpackage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

/* JADX INFO: loaded from: classes4.dex */
public abstract class xd3 {
    public static wd3 a(Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        try {
            return (wd3) ((Class) ((ParameterizedType) obj.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getMethod("inflate", LayoutInflater.class, ViewGroup.class, Boolean.TYPE).invoke(null, layoutInflater, viewGroup, Boolean.valueOf(z));
        } catch (ClassCastException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
