package xfkj.fitpro.db.convert;

import com.google.gson.reflect.TypeToken;
import defpackage.qv0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class IntegerListConverter {
    private final qv0 gson = new qv0();

    public String convertToDatabaseValue(List<Integer> list) {
        return this.gson.toJson(list);
    }

    public List<Integer> convertToEntityProperty(String str) {
        return (List) this.gson.fromJson(str, new TypeToken<ArrayList<Integer>>() { // from class: xfkj.fitpro.db.convert.IntegerListConverter.1
        }.getType());
    }
}
