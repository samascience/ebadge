package xfkj.fitpro.model.sever.reponse;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Weather2Response {
    private List<ListDTO> list;
    private String loc;

    public static class ListDTO {
        private String condCodeDay;
        private String condCodeNight;
        private String condTextDay;
        private String condTextNight;
        private String day;
        private String humidity;
        private String precip;
        private String sunrise;
        private String sunset;
        private String tmpMax;
        private String tmpMin;
        private String uvIndex;
        private String vis;
        private String windSpeedDay;
        private String windSpeedNight;

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

        public String getDay() {
            return this.day;
        }

        public String getHumidity() {
            return this.humidity;
        }

        public String getPrecip() {
            return this.precip;
        }

        public String getSunrise() {
            return this.sunrise;
        }

        public String getSunset() {
            return this.sunset;
        }

        public String getTmpMax() {
            return this.tmpMax;
        }

        public String getTmpMin() {
            return this.tmpMin;
        }

        public String getUvIndex() {
            return this.uvIndex;
        }

        public String getVis() {
            return this.vis;
        }

        public String getWindSpeedDay() {
            return this.windSpeedDay;
        }

        public String getWindSpeedNight() {
            return this.windSpeedNight;
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

        public void setDay(String str) {
            this.day = str;
        }

        public void setHumidity(String str) {
            this.humidity = str;
        }

        public void setPrecip(String str) {
            this.precip = str;
        }

        public void setSunrise(String str) {
            this.sunrise = str;
        }

        public void setSunset(String str) {
            this.sunset = str;
        }

        public void setTmpMax(String str) {
            this.tmpMax = str;
        }

        public void setTmpMin(String str) {
            this.tmpMin = str;
        }

        public void setUvIndex(String str) {
            this.uvIndex = str;
        }

        public void setVis(String str) {
            this.vis = str;
        }

        public void setWindSpeedDay(String str) {
            this.windSpeedDay = str;
        }

        public void setWindSpeedNight(String str) {
            this.windSpeedNight = str;
        }

        public String toString() {
            return "ListDTO{day='" + this.day + "', tmpMin='" + this.tmpMin + "', tmpMax='" + this.tmpMax + "', condCodeDay='" + this.condCodeDay + "', condCodeNight='" + this.condCodeNight + "', condTextDay='" + this.condTextDay + "', condTextNight='" + this.condTextNight + "', sunrise='" + this.sunrise + "', sunset='" + this.sunset + "', windSpeedDay='" + this.windSpeedDay + "', windSpeedNight='" + this.windSpeedNight + "', precip='" + this.precip + "', uvIndex='" + this.uvIndex + "', humidity='" + this.humidity + "', vis='" + this.vis + "'}";
        }
    }

    public List<ListDTO> getList() {
        return this.list;
    }

    public String getLoc() {
        return this.loc;
    }

    public void setList(List<ListDTO> list) {
        this.list = list;
    }

    public void setLoc(String str) {
        this.loc = str;
    }

    public String toString() {
        return "Weather2Response{loc='" + this.loc + "', list=" + this.list + '}';
    }
}
