package xfkj.fitpro.activity.ota;

import defpackage.rv0;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SdkMapInfo {
    private CursdkDTO cursdk;
    private List<MapDTO> map;

    public static class CursdkDTO {
        private String chip;
        private String vendor;
        private String version;

        public String getChip() {
            return this.chip;
        }

        public String getVendor() {
            return this.vendor;
        }

        public String getVersion() {
            return this.version;
        }

        public void setChip(String str) {
            this.chip = str;
        }

        public void setVendor(String str) {
            this.vendor = str;
        }

        public void setVersion(String str) {
            this.version = str;
        }

        public String toString() {
            return new rv0().c().toJson(this);
        }
    }

    public static class MapDTO {
        private String pakage;
        private String version;

        public String getPakage() {
            return this.pakage;
        }

        public String getVersion() {
            return this.version;
        }

        public void setPakage(String str) {
            this.pakage = str;
        }

        public void setVersion(String str) {
            this.version = str;
        }

        public String toString() {
            return new rv0().c().toJson(this);
        }
    }

    public CursdkDTO getCursdk() {
        return this.cursdk;
    }

    public List<MapDTO> getMap() {
        return this.map;
    }

    public void setCursdk(CursdkDTO cursdkDTO) {
        this.cursdk = cursdkDTO;
    }

    public void setMap(List<MapDTO> list) {
        this.map = list;
    }

    public String toString() {
        return new rv0().c().toJson(this);
    }
}
