package com.tenmeter.smlibrary.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class SMGameListBannerParent implements Parcelable {
    public static final Parcelable.Creator<SMGameListBannerParent> CREATOR = new Parcelable.Creator<SMGameListBannerParent>() { // from class: com.tenmeter.smlibrary.entity.SMGameListBannerParent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SMGameListBannerParent createFromParcel(Parcel parcel) {
            return new SMGameListBannerParent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SMGameListBannerParent[] newArray(int i) {
            return new SMGameListBannerParent[i];
        }
    };
    private String bannerImage;
    private String bannerName;
    private String bannerTitle;
    private int bannerType;
    private int bannerWeight;
    private String comp;
    private String createdTime;
    private SMGameInfo game;
    private int gameId;
    private String gameName;
    private int id;
    private String language;
    private String lastUpdatedTime;

    public SMGameListBannerParent() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBannerImage() {
        return this.bannerImage;
    }

    public String getBannerName() {
        return this.bannerName;
    }

    public String getBannerTitle() {
        return this.bannerTitle;
    }

    public int getBannerType() {
        return this.bannerType;
    }

    public int getBannerWeight() {
        return this.bannerWeight;
    }

    public String getComp() {
        return this.comp;
    }

    public String getCreatedTime() {
        return this.createdTime;
    }

    public SMGameInfo getGame() {
        return this.game;
    }

    public int getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public int getId() {
        return this.id;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    public void setBannerImage(String str) {
        this.bannerImage = str;
    }

    public void setBannerName(String str) {
        this.bannerName = str;
    }

    public void setBannerTitle(String str) {
        this.bannerTitle = str;
    }

    public void setBannerType(int i) {
        this.bannerType = i;
    }

    public void setBannerWeight(int i) {
        this.bannerWeight = i;
    }

    public void setComp(String str) {
        this.comp = str;
    }

    public void setCreatedTime(String str) {
        this.createdTime = str;
    }

    public void setGame(SMGameInfo sMGameInfo) {
        this.game = sMGameInfo;
    }

    public void setGameId(int i) {
        this.gameId = i;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLastUpdatedTime(String str) {
        this.lastUpdatedTime = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bannerImage);
        parcel.writeString(this.bannerName);
        parcel.writeString(this.bannerTitle);
        parcel.writeInt(this.bannerType);
        parcel.writeInt(this.bannerWeight);
        parcel.writeString(this.comp);
        parcel.writeString(this.createdTime);
        parcel.writeParcelable(this.game, i);
        parcel.writeInt(this.gameId);
        parcel.writeString(this.gameName);
        parcel.writeInt(this.id);
        parcel.writeString(this.language);
        parcel.writeString(this.lastUpdatedTime);
    }

    protected SMGameListBannerParent(Parcel parcel) {
        this.bannerImage = parcel.readString();
        this.bannerName = parcel.readString();
        this.bannerTitle = parcel.readString();
        this.bannerType = parcel.readInt();
        this.bannerWeight = parcel.readInt();
        this.comp = parcel.readString();
        this.createdTime = parcel.readString();
        this.game = (SMGameInfo) parcel.readParcelable(SMGameInfo.class.getClassLoader());
        this.gameId = parcel.readInt();
        this.gameName = parcel.readString();
        this.id = parcel.readInt();
        this.language = parcel.readString();
        this.lastUpdatedTime = parcel.readString();
    }
}
