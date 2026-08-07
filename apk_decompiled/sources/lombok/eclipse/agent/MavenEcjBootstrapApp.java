package lombok.eclipse.agent;

import com.zwitserloot.cmdreader.CmdReader;
import com.zwitserloot.cmdreader.Description;
import com.zwitserloot.cmdreader.InvalidCommandLineException;
import com.zwitserloot.cmdreader.Shorthand;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import lombok.core.LombokApp;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/eclipse/agent/MavenEcjBootstrapApp.SCL.lombok */
public class MavenEcjBootstrapApp extends LombokApp {
    @Override // lombok.core.LombokApp
    public String getAppName() {
        return "createMavenECJBootstrap";
    }

    @Override // lombok.core.LombokApp
    public String getAppDescription() {
        return "Creates .mvn/jvm.config and .mvn/lombok-bootstrap.jar for\nuse with the ECJ compiler.";
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/eclipse/agent/MavenEcjBootstrapApp$CmdArgs.SCL.lombok */
    private static class CmdArgs {

        @Description("Overwrite existing files. Defaults to false.")
        @Shorthand({"w"})
        boolean overwrite = false;

        @Description("The root of a Maven project. Defaults to the current working directory.")
        @Shorthand({"o"})
        String output;

        @Description("Shows this help text")
        @Shorthand({"h", "?"})
        boolean help;

        private CmdArgs() {
        }
    }

    @Override // lombok.core.LombokApp
    public int runApp(List<String> rawArgs) throws Exception {
        CmdReader<CmdArgs> reader = CmdReader.of(CmdArgs.class);
        try {
            CmdArgs args = reader.make((String[]) rawArgs.toArray(new String[0]));
            if (args.help) {
                printHelp(reader, null, System.out);
                return 0;
            }
            return createBootstrap(args.output, args.overwrite);
        } catch (InvalidCommandLineException e) {
            printHelp(reader, e.getMessage(), System.err);
            return 1;
        }
    }

    private int createBootstrap(String root, boolean overwrite) {
        File mvn = new File(root, ".mvn");
        int result = 0;
        if (0 == 0) {
            result = makeMvn(mvn);
        }
        if (result == 0) {
            result = makeJvmConfig(mvn, overwrite);
        }
        if (result == 0) {
            result = makeJar(mvn, overwrite);
        }
        return result;
    }

    private int makeMvn(File mvn) {
        int result = 0;
        Exception err = null;
        try {
            if (!mvn.exists() && !mvn.mkdirs()) {
                result = 1;
            }
        } catch (Exception e) {
            result = 1;
            err = e;
        }
        if (result != 0) {
            System.err.println("Could not create " + mvn.getPath());
            if (err != null) {
                err.printStackTrace(System.err);
            }
        }
        return result;
    }

    private int makeJvmConfig(File mvn, boolean overwrite) {
        File jvmConfig = new File(mvn, "jvm.config");
        if (jvmConfig.exists() && !overwrite) {
            System.err.println(String.valueOf(canonical(jvmConfig)) + " exists but '-w' not specified.");
            return 1;
        }
        try {
            FileWriter writer = new FileWriter(jvmConfig);
            writer.write("-javaagent:.mvn/lombok-bootstrap.jar");
            writer.flush();
            writer.close();
            System.out.println("Successfully created: " + canonical(jvmConfig));
            return 0;
        } catch (Exception e) {
            System.err.println("Could not create: " + canonical(jvmConfig));
            e.printStackTrace(System.err);
            return 1;
        }
    }

    private int makeJar(File mvn, boolean overwrite) {
        File jar = new File(mvn, "lombok-bootstrap.jar");
        if (jar.exists() && !overwrite) {
            System.err.println(String.valueOf(canonical(jar)) + " but '-w' not specified.");
            return 1;
        }
        try {
            InputStream input = MavenEcjBootstrapApp.class.getResourceAsStream("/lombok/launch/mavenEcjBootstrapAgent.jar");
            FileOutputStream output = new FileOutputStream(jar);
            try {
                byte[] buffer = new byte[4096];
                while (true) {
                    int length = input.read(buffer);
                    if (length <= 0) {
                        output.flush();
                        output.close();
                        System.out.println("Successfully created: " + canonical(jar));
                        try {
                            return 0;
                        } catch (Exception unused) {
                            return 0;
                        }
                    }
                    output.write(buffer, 0, length);
                }
            } finally {
                try {
                    output.close();
                } catch (Exception unused2) {
                }
            }
        } catch (Exception e) {
            System.err.println("Could not create: " + canonical(jar));
            e.printStackTrace(System.err);
            return 1;
        }
    }

    private static String canonical(File out) {
        try {
            return out.getCanonicalPath();
        } catch (Exception unused) {
            return out.getAbsolutePath();
        }
    }

    private void printHelp(CmdReader<CmdArgs> reader, String message, PrintStream out) {
        if (message != null) {
            out.println(message);
            out.println("----------------------------");
        }
        out.println(reader.generateCommandLineHelp("java -jar lombok.jar createMavenECJBootstrap"));
    }
}
