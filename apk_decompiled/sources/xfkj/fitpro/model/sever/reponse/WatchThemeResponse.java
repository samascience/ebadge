package xfkj.fitpro.model.sever.reponse;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.reflect.TypeToken;
import defpackage.qv0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class WatchThemeResponse implements Parcelable {
    public static final Parcelable.Creator<WatchThemeResponse> CREATOR = new Parcelable.Creator<WatchThemeResponse>() { // from class: xfkj.fitpro.model.sever.reponse.WatchThemeResponse.1
        @Override // android.os.Parcelable.Creator
        public WatchThemeResponse createFromParcel(Parcel parcel) {
            return new WatchThemeResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public WatchThemeResponse[] newArray(int i) {
            return new WatchThemeResponse[i];
        }
    };
    private BinFileBean binFile;
    private boolean editable;
    private BinFileBean fontFile;
    private long id;
    private List<MaterialListBean> materialList;
    boolean original;
    private boolean sizeAlign;
    private String version;

    public class CustomObject implements Serializable {
        private static final long serialVersionUID = 1234567891011188L;

        public CustomObject() {
        }
    }

    public WatchThemeResponse() {
    }

    public static List<WatchThemeResponse> arrayWatchThemeResponseFromData(String str) {
        return (List) new qv0().fromJson(str, new TypeToken<ArrayList<WatchThemeResponse>>() { // from class: xfkj.fitpro.model.sever.reponse.WatchThemeResponse.2
        }.getType());
    }

    public static WatchThemeResponse objectFromData(String str) {
        return (WatchThemeResponse) new qv0().fromJson(str, WatchThemeResponse.class);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BinFileBean getBinFile() {
        return this.binFile;
    }

    public BinFileBean getFontFile() {
        return this.fontFile;
    }

    public long getId() {
        return this.id;
    }

    public List<MaterialListBean> getMaterialList() {
        return this.materialList;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isEditable() {
        return this.editable;
    }

    public boolean isOriginal() {
        return this.original;
    }

    public boolean isSizeAlign() {
        return this.sizeAlign;
    }

    public void setBinFile(BinFileBean binFileBean) {
        this.binFile = binFileBean;
    }

    public void setEditable(boolean z) {
        this.editable = z;
    }

    public void setFontFile(BinFileBean binFileBean) {
        this.fontFile = binFileBean;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setMaterialList(List<MaterialListBean> list) {
        this.materialList = list;
    }

    public void setOriginal(boolean z) {
        this.original = z;
    }

    public void setSizeAlign(boolean z) {
        this.sizeAlign = z;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "WatchThemeResponse{id=" + this.id + ", original=" + this.original + ", materialList=" + this.materialList + ", version='" + this.version + "', binFile=" + this.binFile + ", fontFile=" + this.fontFile + ", editable=" + this.editable + ", sizeAlign=" + this.sizeAlign + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeByte(this.original ? (byte) 1 : (byte) 0);
        parcel.writeString(this.version);
        parcel.writeSerializable(this.binFile);
        parcel.writeSerializable(this.fontFile);
        parcel.writeList(this.materialList);
        parcel.writeByte(this.editable ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.sizeAlign ? (byte) 1 : (byte) 0);
    }

    protected WatchThemeResponse(Parcel parcel) {
        this.id = parcel.readLong();
        this.original = parcel.readByte() != 0;
        this.version = parcel.readString();
        this.binFile = (BinFileBean) parcel.readSerializable();
        this.fontFile = (BinFileBean) parcel.readSerializable();
        ArrayList arrayList = new ArrayList();
        this.materialList = arrayList;
        parcel.readList(arrayList, CustomObject.class.getClassLoader());
        this.editable = parcel.readByte() != 0;
        this.sizeAlign = parcel.readByte() != 0;
    }

    public static WatchThemeResponse objectFromData(String str, String str2) {
        try {
            return (WatchThemeResponse) new qv0().fromJson(new JSONObject(str).getString(str), WatchThemeResponse.class);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<WatchThemeResponse> arrayWatchThemeResponseFromData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (List) new qv0().fromJson(jSONObject.getString(str), new TypeToken<ArrayList<WatchThemeResponse>>() { // from class: xfkj.fitpro.model.sever.reponse.WatchThemeResponse.3
            }.getType());
        } catch (JSONException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
