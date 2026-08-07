package defpackage;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

/* JADX INFO: loaded from: classes.dex */
public interface f40 {

    public static abstract class a implements f40 {
    }

    JavaType a(TypeFactory typeFactory);

    JavaType b(TypeFactory typeFactory);

    Object convert(Object obj);
}
