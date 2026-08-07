package xfkj.fitpro.db.bean;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BatteryCalculateParamsBean implements Comparable<BatteryCalculateParamsBean> {
    Long id;
    String mac;
    List<Integer> params;
    int version;

    public BatteryCalculateParamsBean(Long l, String str, int i, List<Integer> list) {
        this.id = l;
        this.mac = str;
        this.version = i;
        this.params = list;
    }

    private int compareWithNulls(String str, String str2) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }

    public Long getId() {
        return this.id;
    }

    public String getMac() {
        return this.mac;
    }

    public List<Integer> getParams() {
        return this.params;
    }

    public int getVersion() {
        return this.version;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setParams(List<Integer> list) {
        this.params = list;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public String toString() {
        return "BatteryCalculateParamsBean{id=" + this.id + ", mac='" + this.mac + "', version=" + this.version + ", params=" + this.params + '}';
    }

    @Override // java.lang.Comparable
    public int compareTo(BatteryCalculateParamsBean batteryCalculateParamsBean) {
        if (batteryCalculateParamsBean == null) {
            return 1;
        }
        int iCompareWithNulls = compareWithNulls(this.mac, batteryCalculateParamsBean.mac);
        if (iCompareWithNulls != 0) {
            return iCompareWithNulls;
        }
        int iCompare = Integer.compare(this.version, batteryCalculateParamsBean.version);
        if (iCompare != 0) {
            return iCompare;
        }
        List<Integer> list = this.params;
        List<Integer> list2 = batteryCalculateParamsBean.params;
        if (list == list2) {
            return 0;
        }
        if (list == null) {
            return -1;
        }
        if (list2 == null) {
            return 1;
        }
        int iCompare2 = Integer.compare(list.size(), batteryCalculateParamsBean.params.size());
        if (iCompare2 != 0) {
            return iCompare2;
        }
        for (int i = 0; i < this.params.size(); i++) {
            int iCompare3 = Integer.compare(this.params.get(i).intValue(), batteryCalculateParamsBean.params.get(i).intValue());
            if (iCompare3 != 0) {
                return iCompare3;
            }
        }
        return 0;
    }

    public BatteryCalculateParamsBean() {
    }
}
