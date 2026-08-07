package lombok;

/* JADX INFO: loaded from: classes4.dex */
public enum EqualsAndHashCode$CacheStrategy {
    NEVER,
    LAZY;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EqualsAndHashCode$CacheStrategy[] valuesCustom() {
        EqualsAndHashCode$CacheStrategy[] equalsAndHashCode$CacheStrategyArrValuesCustom = values();
        int length = equalsAndHashCode$CacheStrategyArrValuesCustom.length;
        EqualsAndHashCode$CacheStrategy[] equalsAndHashCode$CacheStrategyArr = new EqualsAndHashCode$CacheStrategy[length];
        System.arraycopy(equalsAndHashCode$CacheStrategyArrValuesCustom, 0, equalsAndHashCode$CacheStrategyArr, 0, length);
        return equalsAndHashCode$CacheStrategyArr;
    }
}
