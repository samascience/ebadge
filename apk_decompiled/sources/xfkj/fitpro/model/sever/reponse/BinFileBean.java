package xfkj.fitpro.model.sever.reponse;

import com.google.gson.reflect.TypeToken;
import defpackage.qv0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BinFileBean implements Serializable {
    private String name;
    private String size;
    private String url;

    public static List<BinFileBean> arrayBinFileBeanFromData(String str) {
        return (List) new qv0().fromJson(str, new TypeToken<ArrayList<BinFileBean>>() { // from class: xfkj.fitpro.model.sever.reponse.BinFileBean.1
        }.getType());
    }

    public static BinFileBean objectFromData(String str) {
        return (BinFileBean) new qv0().fromJson(str, BinFileBean.class);
    }

    public String getName() {
        return this.name;
    }

    public String getSize() {
        return this.size;
    }

    public String getUrl() {
        return this.url.replace("http://static.jusonsmart.com/", "https://res.jusonsmart.com/");
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "BinFileBean{name='" + this.name + "', url='" + this.url + "', size='" + this.size + "'}";
    }

    public static BinFileBean objectFromData(String str, String str2) {
        try {
            return (BinFileBean) new qv0().fromJson(new JSONObject(str).getString(str), BinFileBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<BinFileBean> arrayBinFileBeanFromData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (List) new qv0().fromJson(jSONObject.getString(str), new TypeToken<ArrayList<BinFileBean>>() { // from class: xfkj.fitpro.model.sever.reponse.BinFileBean.2
            }.getType());
        } catch (JSONException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
