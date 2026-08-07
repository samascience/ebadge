package xfkj.fitpro.model.sever.reponse;

import com.google.gson.reflect.TypeToken;
import defpackage.qv0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class WatchThemeDetailsResponse implements Serializable {
    String bgBinPath;
    private BinFileBean binFile;
    private BinFileBean fontFile;
    private int grade;
    private long id;
    private String mainModel;
    private List<MaterialListBean> materialList;
    private MaterialListBean materialZip;
    private List<String> mchModel;
    private int order;
    private boolean original;
    String previewImageOfWatchPath;
    String previewImgPath;
    String previewScaleImageOfWatchPath;
    long realUpgradeSize;
    private MaterialListBean resFile;
    private int screenType;
    private boolean sizeAlign;
    String watchThemeBinPath;
    String watchThemeConfigJson;
    boolean isShowBgColor = false;
    int bgColor = 0;

    public static List<WatchThemeDetailsResponse> arrayWatchThemeDetailsResponseFromData(String str) {
        return (List) new qv0().fromJson(str, new TypeToken<ArrayList<WatchThemeDetailsResponse>>() { // from class: xfkj.fitpro.model.sever.reponse.WatchThemeDetailsResponse.1
        }.getType());
    }

    public static WatchThemeDetailsResponse objectFromData(String str) {
        return (WatchThemeDetailsResponse) new qv0().fromJson(str, WatchThemeDetailsResponse.class);
    }

    public String getBgBinPath() {
        return this.bgBinPath;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public BinFileBean getBinFile() {
        return this.binFile;
    }

    public BinFileBean getFontFile() {
        return this.fontFile;
    }

    public int getGrade() {
        return this.grade;
    }

    public long getId() {
        return this.id;
    }

    public String getMainModel() {
        return this.mainModel;
    }

    public List<MaterialListBean> getMaterialList() {
        return this.materialList;
    }

    public MaterialListBean getMaterialZip() {
        return this.materialZip;
    }

    public List<String> getMchModel() {
        return this.mchModel;
    }

    public int getOrder() {
        return this.order;
    }

    public String getPreviewImageOfWatchPath() {
        return this.previewImageOfWatchPath;
    }

    public String getPreviewImgPath() {
        return this.previewImgPath;
    }

    public String getPreviewScaleImageOfWatchPath() {
        return this.previewScaleImageOfWatchPath;
    }

    public long getRealUpgradeSize() {
        return this.realUpgradeSize;
    }

    public MaterialListBean getResFile() {
        return this.resFile;
    }

    public int getScreenType() {
        return this.screenType;
    }

    public String getWatchThemeBinPath() {
        return this.watchThemeBinPath;
    }

    public String getWatchThemeConfigJson() {
        return this.watchThemeConfigJson;
    }

    public boolean isOriginal() {
        return this.original;
    }

    public boolean isShowBgColor() {
        return this.isShowBgColor;
    }

    public boolean isSizeAlign() {
        return this.sizeAlign;
    }

    public void setBgBinPath(String str) {
        this.bgBinPath = str;
    }

    public void setBgColor(int i) {
        this.bgColor = i;
    }

    public void setBinFile(BinFileBean binFileBean) {
        this.binFile = binFileBean;
    }

    public void setFontFile(BinFileBean binFileBean) {
        this.fontFile = binFileBean;
    }

    public void setGrade(int i) {
        this.grade = i;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setMainModel(String str) {
        this.mainModel = str;
    }

    public void setMaterialList(List<MaterialListBean> list) {
        this.materialList = list;
    }

    public void setMaterialZip(MaterialListBean materialListBean) {
        this.materialZip = materialListBean;
    }

    public void setMchModel(List<String> list) {
        this.mchModel = list;
    }

    public void setOrder(int i) {
        this.order = i;
    }

    public void setOriginal(boolean z) {
        this.original = z;
    }

    public void setPreviewImageOfWatchPath(String str) {
        this.previewImageOfWatchPath = str;
    }

    public void setPreviewImgPath(String str) {
        this.previewImgPath = str;
    }

    public void setPreviewScaleImageOfWatchPath(String str) {
        this.previewScaleImageOfWatchPath = str;
    }

    public void setRealUpgradeSize(long j) {
        this.realUpgradeSize = j;
    }

    public void setResFile(MaterialListBean materialListBean) {
        this.resFile = materialListBean;
    }

    public void setScreenType(int i) {
        this.screenType = i;
    }

    public void setShowBgColor(boolean z) {
        this.isShowBgColor = z;
    }

    public void setSizeAlign(boolean z) {
        this.sizeAlign = z;
    }

    public void setWatchThemeBinPath(String str) {
        this.watchThemeBinPath = str;
    }

    public void setWatchThemeConfigJson(String str) {
        this.watchThemeConfigJson = str;
    }

    public String toString() {
        return "WatchThemeDetailsResponse{id=" + this.id + ", mainModel='" + this.mainModel + "', grade=" + this.grade + ", screenType=" + this.screenType + ", binFile=" + this.binFile + ", fontFile=" + this.fontFile + ", materialZip=" + this.materialZip + ", original=" + this.original + ", order=" + this.order + ", mchModel=" + this.mchModel + ", materialList=" + this.materialList + ", resFile=" + this.resFile + ", previewImgPath='" + this.previewImgPath + "', watchThemeBinPath='" + this.watchThemeBinPath + "', bgBinPath='" + this.bgBinPath + "', isShowBgColor=" + this.isShowBgColor + ", bgColor=" + this.bgColor + ", previewImageOfWatchPath='" + this.previewImageOfWatchPath + "', previewScaleImageOfWatchPath='" + this.previewScaleImageOfWatchPath + "', watchThemeConfigJson='" + this.watchThemeConfigJson + "', realUpgradeSize=" + this.realUpgradeSize + ", sizeAlign=" + this.sizeAlign + '}';
    }

    public static WatchThemeDetailsResponse objectFromData(String str, String str2) {
        try {
            return (WatchThemeDetailsResponse) new qv0().fromJson(new JSONObject(str).getString(str), WatchThemeDetailsResponse.class);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<WatchThemeDetailsResponse> arrayWatchThemeDetailsResponseFromData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (List) new qv0().fromJson(jSONObject.getString(str), new TypeToken<ArrayList<WatchThemeDetailsResponse>>() { // from class: xfkj.fitpro.model.sever.reponse.WatchThemeDetailsResponse.2
            }.getType());
        } catch (JSONException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
