package xfkj.fitpro.activity.ota.utils;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import defpackage.wd3;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

/* JADX INFO: loaded from: classes4.dex */
public class ViewBindingHelper {
    public static <VB extends wd3> VB onCreateViewBinding(Object obj, LayoutInflater layoutInflater) {
        return (VB) onCreateViewBinding(obj, layoutInflater, null, false);
    }

    public static <VB extends wd3> VB onCreateViewBinding(Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        try {
            return (VB) ((Class) ((ParameterizedType) obj.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getMethod("inflate", LayoutInflater.class, ViewGroup.class, Boolean.TYPE).invoke(null, layoutInflater, viewGroup, Boolean.valueOf(z));
        } catch (ClassCastException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
