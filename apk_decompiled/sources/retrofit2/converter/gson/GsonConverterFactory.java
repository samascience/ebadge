package retrofit2.converter.gson;

import com.google.gson.reflect.TypeToken;
import defpackage.ff2;
import defpackage.fh2;
import defpackage.qv0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes4.dex */
public final class GsonConverterFactory extends Converter.Factory {
    private final qv0 gson;

    private GsonConverterFactory(qv0 qv0Var) {
        this.gson = qv0Var;
    }

    public static GsonConverterFactory create() {
        return create(new qv0());
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, ff2> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.gson, this.gson.g(TypeToken.get(type)));
    }

    @Override // retrofit2.Converter.Factory
    public Converter<fh2, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.gson, this.gson.g(TypeToken.get(type)));
    }

    public static GsonConverterFactory create(qv0 qv0Var) {
        if (qv0Var != null) {
            return new GsonConverterFactory(qv0Var);
        }
        throw new NullPointerException("gson == null");
    }
}
