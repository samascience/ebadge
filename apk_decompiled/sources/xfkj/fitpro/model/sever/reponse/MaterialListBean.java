package xfkj.fitpro.model.sever.reponse;

import com.google.gson.reflect.TypeToken;
import defpackage.qv0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MaterialListBean implements Serializable {
    private String name;
    private String size;
    private String url;

    public static List<MaterialListBean> arrayMaterialListBeanFromData(String str) {
        return (List) new qv0().fromJson(str, new TypeToken<ArrayList<MaterialListBean>>() { // from class: xfkj.fitpro.model.sever.reponse.MaterialListBean.1
        }.getType());
    }

    public static MaterialListBean objectFromData(String str) {
        return (MaterialListBean) new qv0().fromJson(str, MaterialListBean.class);
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

    public boolean isGifOfPreview() {
        return getName().toLowerCase(Locale.ROOT).contains("gif");
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
        return "MaterialListBean{name='" + this.name + "', url='" + this.url + "', size='" + this.size + "'}";
    }

    public static MaterialListBean objectFromData(String str, String str2) {
        try {
            return (MaterialListBean) new qv0().fromJson(new JSONObject(str).getString(str), MaterialListBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<MaterialListBean> arrayMaterialListBeanFromData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (List) new qv0().fromJson(jSONObject.getString(str), new TypeToken<ArrayList<MaterialListBean>>() { // from class: xfkj.fitpro.model.sever.reponse.MaterialListBean.2
            }.getType());
        } catch (JSONException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
