package xfkj.fitpro.model;

import com.google.gson.reflect.TypeToken;
import defpackage.qv0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class OTAUpgradeInfo {
    private DataBean data;
    private String error;
    private boolean success;

    public static class DataBean {
        private String api_url;
        private String appDownUrl4g;
        private String app_down_url;
        private String bundle_identifier;
        private String content;
        private String created_at;
        private String currentDownloadUrl;
        private String display_name;
        private Object faq_url;
        private int force;
        private int id;
        private String name;
        private int status;
        private int type;
        private String updated_at;
        private String version;
        private String version4g;
        private int version_code;

        public static List<DataBean> arrayDataBeanFromData(String str) {
            return (List) new qv0().fromJson(str, new TypeToken<ArrayList<DataBean>>() { // from class: xfkj.fitpro.model.OTAUpgradeInfo.DataBean.1
            }.getType());
        }

        public static DataBean objectFromData(String str) {
            return (DataBean) new qv0().fromJson(str, DataBean.class);
        }

        public String getApi_url() {
            return this.api_url;
        }

        public String getAppDownUrl4g() {
            return this.appDownUrl4g;
        }

        public String getApp_down_url() {
            return this.app_down_url;
        }

        public String getBundle_identifier() {
            return this.bundle_identifier;
        }

        public String getContent() {
            return this.content;
        }

        public String getCreated_at() {
            return this.created_at;
        }

        public String getCurrentDownloadUrl() {
            return this.currentDownloadUrl;
        }

        public String getDisplay_name() {
            return this.display_name;
        }

        public Object getFaq_url() {
            return this.faq_url;
        }

        public int getForce() {
            return this.force;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public int getStatus() {
            return this.status;
        }

        public int getType() {
            return this.type;
        }

        public String getUpdated_at() {
            return this.updated_at;
        }

        public String getVersion() {
            return this.version;
        }

        public String getVersion4g() {
            return this.version4g;
        }

        public int getVersion_code() {
            return this.version_code;
        }

        public void setApi_url(String str) {
            this.api_url = str;
        }

        public void setAppDownUrl4g(String str) {
            this.appDownUrl4g = str;
        }

        public void setApp_down_url(String str) {
            this.app_down_url = str;
        }

        public void setBundle_identifier(String str) {
            this.bundle_identifier = str;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setCreated_at(String str) {
            this.created_at = str;
        }

        public void setCurrentDownloadUrl(String str) {
            this.currentDownloadUrl = str;
        }

        public void setDisplay_name(String str) {
            this.display_name = str;
        }

        public void setFaq_url(Object obj) {
            this.faq_url = obj;
        }

        public void setForce(int i) {
            this.force = i;
        }

        public void setId(int i) {
            this.id = i;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public void setType(int i) {
            this.type = i;
        }

        public void setUpdated_at(String str) {
            this.updated_at = str;
        }

        public void setVersion(String str) {
            this.version = str;
        }

        public void setVersion4g(String str) {
            this.version4g = str;
        }

        public void setVersion_code(int i) {
            this.version_code = i;
        }

        public static DataBean objectFromData(String str, String str2) {
            try {
                return (DataBean) new qv0().fromJson(new JSONObject(str).getString(str), DataBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static List<DataBean> arrayDataBeanFromData(String str, String str2) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return (List) new qv0().fromJson(jSONObject.getString(str), new TypeToken<ArrayList<DataBean>>() { // from class: xfkj.fitpro.model.OTAUpgradeInfo.DataBean.2
                }.getType());
            } catch (JSONException e) {
                e.printStackTrace();
                return new ArrayList();
            }
        }
    }

    public static List<OTAUpgradeInfo> arrayOTAUpgradeInfoFromData(String str) {
        return (List) new qv0().fromJson(str, new TypeToken<ArrayList<OTAUpgradeInfo>>() { // from class: xfkj.fitpro.model.OTAUpgradeInfo.1
        }.getType());
    }

    public static OTAUpgradeInfo objectFromData(String str) {
        return (OTAUpgradeInfo) new qv0().fromJson(str, OTAUpgradeInfo.class);
    }

    public DataBean getData() {
        return this.data;
    }

    public String getError() {
        return this.error;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public static OTAUpgradeInfo objectFromData(String str, String str2) {
        try {
            return (OTAUpgradeInfo) new qv0().fromJson(new JSONObject(str).getString(str), OTAUpgradeInfo.class);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<OTAUpgradeInfo> arrayOTAUpgradeInfoFromData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (List) new qv0().fromJson(jSONObject.getString(str), new TypeToken<ArrayList<OTAUpgradeInfo>>() { // from class: xfkj.fitpro.model.OTAUpgradeInfo.2
            }.getType());
        } catch (JSONException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
