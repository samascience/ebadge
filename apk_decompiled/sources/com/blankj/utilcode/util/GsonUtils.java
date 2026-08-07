package com.blankj.utilcode.util;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import defpackage.qv0;
import defpackage.rv0;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class GsonUtils {
    private static final Map<String, qv0> GSONS = new ConcurrentHashMap();
    private static final String KEY_DEFAULT = "defaultGson";
    private static final String KEY_DELEGATE = "delegateGson";
    private static final String KEY_LOG_UTILS = "logUtilsGson";

    private GsonUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static qv0 createGson() {
        return new rv0().f().d().c();
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        return (T) fromJson(getGson(), str, (Class) cls);
    }

    public static Type getArrayType(Type type) {
        return TypeToken.getArray(type).getType();
    }

    public static qv0 getGson(String str) {
        return GSONS.get(str);
    }

    static qv0 getGson4LogUtils() {
        Map<String, qv0> map = GSONS;
        qv0 qv0Var = map.get(KEY_LOG_UTILS);
        if (qv0Var != null) {
            return qv0Var;
        }
        qv0 qv0VarC = new rv0().j().f().c();
        map.put(KEY_LOG_UTILS, qv0VarC);
        return qv0VarC;
    }

    public static Type getListType(Type type) {
        return TypeToken.getParameterized(List.class, type).getType();
    }

    public static Type getMapType(Type type, Type type2) {
        return TypeToken.getParameterized(Map.class, type, type2).getType();
    }

    public static Type getSetType(Type type) {
        return TypeToken.getParameterized(Set.class, type).getType();
    }

    public static Type getType(Type type, Type... typeArr) {
        return TypeToken.getParameterized(type, typeArr).getType();
    }

    public static void setGson(String str, qv0 qv0Var) {
        if (TextUtils.isEmpty(str) || qv0Var == null) {
            return;
        }
        GSONS.put(str, qv0Var);
    }

    public static void setGsonDelegate(qv0 qv0Var) {
        if (qv0Var == null) {
            return;
        }
        GSONS.put(KEY_DELEGATE, qv0Var);
    }

    public static String toJson(Object obj) {
        return toJson(getGson(), obj);
    }

    public static <T> T fromJson(String str, Type type) {
        return (T) fromJson(getGson(), str, type);
    }

    public static qv0 getGson() {
        Map<String, qv0> map = GSONS;
        qv0 qv0Var = map.get(KEY_DELEGATE);
        if (qv0Var != null) {
            return qv0Var;
        }
        qv0 qv0Var2 = map.get(KEY_DEFAULT);
        if (qv0Var2 != null) {
            return qv0Var2;
        }
        qv0 qv0VarCreateGson = createGson();
        map.put(KEY_DEFAULT, qv0VarCreateGson);
        return qv0VarCreateGson;
    }

    public static String toJson(Object obj, Type type) {
        return toJson(getGson(), obj, type);
    }

    public static <T> T fromJson(Reader reader, Class<T> cls) {
        return (T) fromJson(getGson(), reader, (Class) cls);
    }

    public static String toJson(qv0 qv0Var, Object obj) {
        return qv0Var.toJson(obj);
    }

    public static <T> T fromJson(Reader reader, Type type) {
        return (T) fromJson(getGson(), reader, type);
    }

    public static String toJson(qv0 qv0Var, Object obj, Type type) {
        return qv0Var.toJson(obj, type);
    }

    public static <T> T fromJson(qv0 qv0Var, String str, Class<T> cls) {
        return (T) qv0Var.fromJson(str, (Class) cls);
    }

    public static <T> T fromJson(qv0 qv0Var, String str, Type type) {
        return (T) qv0Var.fromJson(str, type);
    }

    public static <T> T fromJson(qv0 qv0Var, Reader reader, Class<T> cls) {
        return (T) qv0Var.fromJson(reader, (Class) cls);
    }

    public static <T> T fromJson(qv0 qv0Var, Reader reader, Type type) {
        return (T) qv0Var.fromJson(reader, type);
    }
}
