package lombok.installer.eclipse;

import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import lombok.installer.OsUtils;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/installer/eclipse/StandardProductDescriptor.SCL.lombok */
public class StandardProductDescriptor implements EclipseProductDescriptor {
    private static final String USER_HOME = System.getProperty("user.home", FileUtils.FILE_EXTENSION_SEPARATOR);
    private static final String[] BASE_WINDOWS_ROOTS = {"\\", "\\Program Files", "\\Program Files (x86)", "\\ProgramData\\Chocolatey\\lib"};
    private static final String[] WINDOWS_ROOTS = windowsRoots();
    private static final String[] MAC_ROOTS = {"/Applications", USER_HOME};
    private static final String[] UNIX_ROOTS = {USER_HOME};
    private final String productName;
    private final String windowsName;
    private final String unixName;
    private final String macAppName;
    private final List<String> executableNames;
    private final List<String> sourceDirsOnWindows;
    private final List<String> sourceDirsOnMac;
    private final List<String> sourceDirsOnUnix;
    private final String iniFileName;
    private final Pattern locationSelectors;
    private final String directoryName;
    private final URL ideIcon;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$installer$OsUtils$OS;

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$installer$OsUtils$OS() {
        int[] iArr = $SWITCH_TABLE$lombok$installer$OsUtils$OS;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[OsUtils.OS.valuesCustom().length];
        try {
            iArr2[OsUtils.OS.MAC_OS_X.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[OsUtils.OS.UNIX.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[OsUtils.OS.WINDOWS.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$lombok$installer$OsUtils$OS = iArr2;
        return iArr2;
    }

    public StandardProductDescriptor(String productName, String baseName, String directoryName, URL ideIcon, Collection<String> alternativeDirectoryNames) {
        this.productName = productName;
        this.windowsName = String.valueOf(baseName) + ".exe";
        this.unixName = baseName;
        this.macAppName = String.valueOf(baseName) + ".app";
        this.executableNames = executableNames(baseName);
        this.sourceDirsOnWindows = generateAlternatives(WINDOWS_ROOTS, "\\", alternativeDirectoryNames);
        this.sourceDirsOnMac = generateAlternatives(MAC_ROOTS, WatchConstant.FAT_FS_ROOT, alternativeDirectoryNames);
        this.sourceDirsOnUnix = generateAlternatives(UNIX_ROOTS, WatchConstant.FAT_FS_ROOT, alternativeDirectoryNames);
        this.iniFileName = String.valueOf(baseName) + ".ini";
        this.locationSelectors = getLocationSelectors(baseName);
        this.directoryName = directoryName.toLowerCase();
        this.ideIcon = ideIcon;
    }

    @Override // lombok.installer.eclipse.EclipseProductDescriptor
    public String getProductName() {
        return this.productName;
    }

    @Override // lombok.installer.eclipse.EclipseProductDescriptor
    public String getWindowsExecutableName() {
        return this.windowsName;
    }

    @Override // lombok.installer.eclipse.EclipseProductDescriptor
    public String getUnixAppName() {
        return this.unixName;
    }

    @Override // lombok.installer.eclipse.EclipseProductDescriptor
    public String getMacAppName() {
        return this.macAppName;
    }

    @Override // lombok.installer.eclipse.EclipseProductDescriptor
    public String getDirectoryName() {
        return this.directoryName;
    }

    @Override // lombok.installer.eclipse.EclipseProductDescriptor
    public List<String> getExecutableNames() {
        return this.executableNames;
    }

    @Override // lombok.installer.eclipse.EclipseProductDescriptor
    public List<String> getSourceDirsOnWindows() {
        return this.sourceDirsOnWindows;
    }

    @Override // lombok.installer.eclipse.EclipseProductDescriptor
    public List<String> getSourceDirsOnMac() {
        return this.sourceDirsOnMac;
    }

    @Override // lombok.installer.eclipse.EclipseProductDescriptor
    public List<String> getSourceDirsOnUnix() {
        return this.sourceDirsOnUnix;
    }

    @Override // lombok.installer.eclipse.EclipseProductDescriptor
    public String getIniFileName() {
        return this.iniFileName;
    }

    @Override // lombok.installer.eclipse.EclipseProductDescriptor
    public Pattern getLocationSelectors() {
        return this.locationSelectors;
    }

    @Override // lombok.installer.eclipse.EclipseProductDescriptor
    public URL getIdeIcon() {
        return this.ideIcon;
    }

    private static Pattern getLocationSelectors(String baseName) {
        return Pattern.compile(String.format(platformPattern(), baseName.toLowerCase()), 2);
    }

    private static String platformPattern() {
        switch ($SWITCH_TABLE$lombok$installer$OsUtils$OS()[OsUtils.getOS().ordinal()]) {
            case 1:
                return "^(%s|%<s\\.ini|%<s\\.app)$";
            case 2:
                return "^(%sc?\\.exe|%<s\\.ini)$";
            case 3:
            default:
                return "^(%s|%<s\\.ini)$";
        }
    }

    private static List<String> executableNames(String baseName) {
        String base = baseName.toLowerCase();
        return Collections.unmodifiableList(Arrays.asList(base, String.valueOf(base) + ".app", String.valueOf(base) + ".exe", String.valueOf(base) + "c.exe"));
    }

    private static List<String> generateAlternatives(String[] roots, String pathSeparator, Collection<String> alternatives) {
        List<String> result = new ArrayList<>();
        for (String root : roots) {
            result.add(concat(root, pathSeparator, Constants.STR_EMPTY));
            for (String alternative : alternatives) {
                result.add(concat(root, pathSeparator, alternative));
            }
        }
        return Collections.unmodifiableList(result);
    }

    private static String concat(String base, String pathSeparator, String alternative) {
        if (alternative.isEmpty()) {
            return base;
        }
        if (base.endsWith(pathSeparator)) {
            return String.valueOf(base) + alternative.replaceAll("[\\/]", "\\" + pathSeparator);
        }
        return String.valueOf(base) + pathSeparator + alternative.replaceAll("[\\/]", "\\" + pathSeparator);
    }

    private static String[] windowsRoots() {
        String localAppData = windowsLocalAppData();
        String[] out = new String[BASE_WINDOWS_ROOTS.length + (localAppData == null ? 1 : 2)];
        System.arraycopy(BASE_WINDOWS_ROOTS, 0, out, 0, BASE_WINDOWS_ROOTS.length);
        out[BASE_WINDOWS_ROOTS.length] = USER_HOME;
        if (localAppData != null) {
            out[BASE_WINDOWS_ROOTS.length + 1] = localAppData;
        }
        return out;
    }

    private static String windowsLocalAppData() {
        String localAppData = System.getenv("LOCALAPPDATA");
        File file = localAppData == null ? null : new File(localAppData);
        if (file != null && file.exists() && file.canRead() && file.isDirectory()) {
            return localAppData;
        }
        return null;
    }
}
