package lombok;

/* JADX INFO: loaded from: classes4.dex */
public enum AccessLevel {
    PUBLIC,
    MODULE,
    PROTECTED,
    PACKAGE,
    PRIVATE,
    NONE;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static AccessLevel[] valuesCustom() {
        AccessLevel[] accessLevelArrValuesCustom = values();
        int length = accessLevelArrValuesCustom.length;
        AccessLevel[] accessLevelArr = new AccessLevel[length];
        System.arraycopy(accessLevelArrValuesCustom, 0, accessLevelArr, 0, length);
        return accessLevelArr;
    }
}
