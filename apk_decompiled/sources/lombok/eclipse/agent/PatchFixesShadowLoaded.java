package lombok.eclipse.agent;

import com.jieli.jl_rcsp.constant.WatchConstant;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import lombok.core.DiagnosticsReceiver;
import lombok.core.PostCompiler;
import lombok.core.Version;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/eclipse/agent/PatchFixesShadowLoaded.SCL.lombok */
public class PatchFixesShadowLoaded {
    public static String addLombokNotesToEclipseAboutDialog(String origReturnValue, String key) {
        if ("aboutText".equals(key)) {
            return origReturnValue.contains(" is installed. https://projectlombok.org") ? origReturnValue : String.valueOf(origReturnValue) + "\n\nLombok " + Version.getFullVersion() + " is installed. https://projectlombok.org/";
        }
        return origReturnValue;
    }

    public static byte[] runPostCompiler(byte[] bytes, String fileName) {
        byte[] transformed = PostCompiler.applyTransformations(bytes, fileName, DiagnosticsReceiver.CONSOLE);
        return transformed == null ? bytes : transformed;
    }

    public static OutputStream runPostCompiler(OutputStream out) throws IOException {
        return PostCompiler.wrapOutputStream(out, "TEST", DiagnosticsReceiver.CONSOLE);
    }

    public static BufferedOutputStream runPostCompiler(BufferedOutputStream out, String path, String name) throws IOException {
        String fileName = String.valueOf(path) + WatchConstant.FAT_FS_ROOT + name;
        return new BufferedOutputStream(PostCompiler.wrapOutputStream(out, fileName, DiagnosticsReceiver.CONSOLE));
    }
}
