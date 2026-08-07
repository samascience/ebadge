package xfkj.fitpro.model.sever.reponse;

import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherResponse {
    private String cond_code;
    private String cond_txt;
    Date date;
    Long id;
    private String tmp;

    public WeatherResponse(Long l, String str, String str2, String str3, Date date) {
        Calendar.getInstance().getTime();
        this.id = l;
        this.tmp = str;
        this.cond_code = str2;
        this.cond_txt = str3;
        this.date = date;
    }

    public String getCond_code() {
        return this.cond_code;
    }

    public String getCond_txt() {
        return this.cond_txt;
    }

    public Date getDate() {
        return this.date;
    }

    public Long getId() {
        return this.id;
    }

    public String getTmp() {
        return this.tmp;
    }

    public void setCond_code(String str) {
        this.cond_code = str;
    }

    public void setCond_txt(String str) {
        this.cond_txt = str;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setTmp(String str) {
        this.tmp = str;
    }

    public String toString() {
        return "WeatherResponse{id=" + this.id + ", tmp='" + this.tmp + "', cond_code='" + this.cond_code + "', cond_txt='" + this.cond_txt + "', date=" + this.date + '}';
    }

    public WeatherResponse() {
        this.date = Calendar.getInstance().getTime();
    }
}
