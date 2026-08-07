package lombok.core.configuration;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/core/configuration/CapitalizationStrategy.SCL.lombok */
public enum CapitalizationStrategy {
    BASIC { // from class: lombok.core.configuration.CapitalizationStrategy.1
        @Override // lombok.core.configuration.CapitalizationStrategy
        public String capitalize(String in) {
            if (in.length() == 0) {
                return in;
            }
            char first = in.charAt(0);
            if (!Character.isLowerCase(first)) {
                return in;
            }
            boolean useUpperCase = in.length() > 2 && (Character.isTitleCase(in.charAt(1)) || Character.isUpperCase(in.charAt(1)));
            return String.valueOf(useUpperCase ? Character.toUpperCase(first) : Character.toTitleCase(first)) + in.substring(1);
        }
    },
    BEANSPEC { // from class: lombok.core.configuration.CapitalizationStrategy.2
        @Override // lombok.core.configuration.CapitalizationStrategy
        public String capitalize(String in) {
            if (in.length() == 0) {
                return in;
            }
            char first = in.charAt(0);
            if (!Character.isLowerCase(first) || (in.length() > 1 && Character.isUpperCase(in.charAt(1)))) {
                return in;
            }
            boolean useUpperCase = in.length() > 2 && Character.isTitleCase(in.charAt(1));
            return String.valueOf(useUpperCase ? Character.toUpperCase(first) : Character.toTitleCase(first)) + in.substring(1);
        }
    };

    public abstract String capitalize(String str);

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static CapitalizationStrategy[] valuesCustom() {
        CapitalizationStrategy[] capitalizationStrategyArrValuesCustom = values();
        int length = capitalizationStrategyArrValuesCustom.length;
        CapitalizationStrategy[] capitalizationStrategyArr = new CapitalizationStrategy[length];
        System.arraycopy(capitalizationStrategyArrValuesCustom, 0, capitalizationStrategyArr, 0, length);
        return capitalizationStrategyArr;
    }

    /* synthetic */ CapitalizationStrategy(CapitalizationStrategy capitalizationStrategy) {
        this();
    }

    public static CapitalizationStrategy defaultValue() {
        return BASIC;
    }
}
