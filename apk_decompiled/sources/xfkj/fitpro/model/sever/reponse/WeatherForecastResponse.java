package xfkj.fitpro.model.sever.reponse;

import defpackage.e33;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherForecastResponse {
    private String condCodeDay;
    private String condCodeNight;
    private String condTextDay;
    private String condTextNight;
    Date date;
    Long id;
    private String tmpMax;
    private String tmpMin;

    public WeatherForecastResponse(Long l, String str, String str2, String str3, String str4, String str5, String str6, Date date) {
        e33.e();
        this.id = l;
        this.tmpMin = str;
        this.tmpMax = str2;
        this.condCodeDay = str3;
        this.condCodeNight = str4;
        this.condTextDay = str5;
        this.condTextNight = str6;
        this.date = date;
    }

    public String getCondCodeDay() {
        return this.condCodeDay;
    }

    public String getCondCodeNight() {
        return this.condCodeNight;
    }

    public String getCondTextDay() {
        return this.condTextDay;
    }

    public String getCondTextNight() {
        return this.condTextNight;
    }

    public Date getDate() {
        return this.date;
    }

    public Long getId() {
        return this.id;
    }

    public String getTmpMax() {
        return this.tmpMax;
    }

    public String getTmpMin() {
        return this.tmpMin;
    }

    public void setCondCodeDay(String str) {
        this.condCodeDay = str;
    }

    public void setCondCodeNight(String str) {
        this.condCodeNight = str;
    }

    public void setCondTextDay(String str) {
        this.condTextDay = str;
    }

    public void setCondTextNight(String str) {
        this.condTextNight = str;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setTmpMax(String str) {
        this.tmpMax = str;
    }

    public void setTmpMin(String str) {
        this.tmpMin = str;
    }

    public String toString() {
        return "WeatherForecastResponse{tmpMin='" + this.tmpMin + "', tmpMax='" + this.tmpMax + "', condCodeDay='" + this.condCodeDay + "', condCodeNight='" + this.condCodeNight + "', condTextDay='" + this.condTextDay + "', condTextNight='" + this.condTextNight + "', date=" + this.date + '}';
    }

    public WeatherForecastResponse() {
        this.date = e33.e();
    }
}
