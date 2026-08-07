package xfkj.fitpro.model.sever.reponse;

/* JADX INFO: loaded from: classes4.dex */
public class QueryDataReponse {
    private String area;
    private String avatar;
    private int best_steps;
    private String birthday;
    private String city;
    private String country_code;
    private String created_at;
    private Long dbId;
    String devid;
    private int distance_unit;
    private String email;
    private int height;
    private int height_unit;
    private long id;
    private int like_num;
    private String mobile;
    private String name;
    private String nickname;
    private String province;
    private int ranked;
    private int sex;
    private String sign;
    private int sit_remind;
    private int social_source;
    private int source;
    private int status;
    private int step_days;
    private int target_sleep;
    private int target_steps;
    private int tomato_num;
    private int total_setps;
    private int type;
    private String updated_at;
    private String uuid;
    private int weight;
    private int weight_unit;

    public QueryDataReponse(Long l, long j, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, String str7, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, String str8, String str9, String str10, String str11, int i12, String str12, int i13, int i14, int i15, int i16, int i17, int i18, String str13, String str14, int i19, String str15) {
        this.dbId = l;
        this.id = j;
        this.uuid = str;
        this.type = i;
        this.name = str2;
        this.nickname = str3;
        this.sign = str4;
        this.mobile = str5;
        this.email = str6;
        this.sex = i2;
        this.birthday = str7;
        this.height = i3;
        this.weight = i4;
        this.target_steps = i5;
        this.target_sleep = i6;
        this.sit_remind = i7;
        this.source = i8;
        this.distance_unit = i9;
        this.weight_unit = i10;
        this.height_unit = i11;
        this.avatar = str8;
        this.city = str9;
        this.area = str10;
        this.province = str11;
        this.status = i12;
        this.country_code = str12;
        this.social_source = i13;
        this.tomato_num = i14;
        this.like_num = i15;
        this.best_steps = i16;
        this.total_setps = i17;
        this.step_days = i18;
        this.created_at = str13;
        this.updated_at = str14;
        this.ranked = i19;
        this.devid = str15;
    }

    public String getArea() {
        return this.area;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int getBest_steps() {
        return this.best_steps;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry_code() {
        return this.country_code;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public Long getDbId() {
        return this.dbId;
    }

    public String getDevid() {
        return this.devid;
    }

    public int getDistance_unit() {
        return this.distance_unit;
    }

    public String getEmail() {
        return this.email;
    }

    public int getHeight() {
        return this.height;
    }

    public int getHeight_unit() {
        return this.height_unit;
    }

    public long getId() {
        return this.id;
    }

    public int getLike_num() {
        return this.like_num;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getName() {
        return this.name;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getProvince() {
        return this.province;
    }

    public int getRanked() {
        return this.ranked;
    }

    public int getSex() {
        return this.sex;
    }

    public String getSign() {
        return this.sign;
    }

    public int getSit_remind() {
        return this.sit_remind;
    }

    public int getSocial_source() {
        return this.social_source;
    }

    public int getSource() {
        return this.source;
    }

    public int getStatus() {
        return this.status;
    }

    public int getStep_days() {
        return this.step_days;
    }

    public int getTarget_sleep() {
        return this.target_sleep;
    }

    public int getTarget_steps() {
        return this.target_steps;
    }

    public int getTomato_num() {
        return this.tomato_num;
    }

    public int getTotal_setps() {
        return this.total_setps;
    }

    public int getType() {
        return this.type;
    }

    public String getUpdated_at() {
        return this.updated_at;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getWeight_unit() {
        return this.weight_unit;
    }

    public void setArea(String str) {
        this.area = str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setBest_steps(int i) {
        this.best_steps = i;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry_code(String str) {
        this.country_code = str;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public void setDbId(Long l) {
        this.dbId = l;
    }

    public void setDevid(String str) {
        this.devid = str;
    }

    public void setDistance_unit(int i) {
        this.distance_unit = i;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setHeight_unit(int i) {
        this.height_unit = i;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setLike_num(int i) {
        this.like_num = i;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setRanked(int i) {
        this.ranked = i;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setSit_remind(int i) {
        this.sit_remind = i;
    }

    public void setSocial_source(int i) {
        this.social_source = i;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setStep_days(int i) {
        this.step_days = i;
    }

    public void setTarget_sleep(int i) {
        this.target_sleep = i;
    }

    public void setTarget_steps(int i) {
        this.target_steps = i;
    }

    public void setTomato_num(int i) {
        this.tomato_num = i;
    }

    public void setTotal_setps(int i) {
        this.total_setps = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUpdated_at(String str) {
        this.updated_at = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setWeight(int i) {
        this.weight = i;
    }

    public void setWeight_unit(int i) {
        this.weight_unit = i;
    }

    public String toString() {
        return "QueryDataReponse{dbId=" + this.dbId + ", id=" + this.id + ", uuid='" + this.uuid + "', type=" + this.type + ", name='" + this.name + "', nickname='" + this.nickname + "', sign='" + this.sign + "', mobile='" + this.mobile + "', email='" + this.email + "', sex=" + this.sex + ", birthday='" + this.birthday + "', height=" + this.height + ", weight=" + this.weight + ", target_steps=" + this.target_steps + ", target_sleep=" + this.target_sleep + ", sit_remind=" + this.sit_remind + ", source=" + this.source + ", distance_unit=" + this.distance_unit + ", weight_unit=" + this.weight_unit + ", height_unit=" + this.height_unit + ", avatar='" + this.avatar + "', city='" + this.city + "', area='" + this.area + "', province='" + this.province + "', status=" + this.status + ", country_code='" + this.country_code + "', social_source=" + this.social_source + ", tomato_num=" + this.tomato_num + ", like_num=" + this.like_num + ", best_steps=" + this.best_steps + ", total_setps=" + this.total_setps + ", step_days=" + this.step_days + ", created_at='" + this.created_at + "', updated_at='" + this.updated_at + "', ranked=" + this.ranked + ", devid='" + this.devid + "'}";
    }

    public QueryDataReponse() {
    }
}
