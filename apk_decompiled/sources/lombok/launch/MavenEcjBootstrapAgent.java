package lombok.launch;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.ProtectionDomain;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/launch/mavenEcjBootstrapAgent.jar:lombok/launch/MavenEcjBootstrapAgent.class */
public final class MavenEcjBootstrapAgent {
    private static final String MAVEN_COMPILER_TRIGGER_CLASS = "org/apache/maven/plugin/compiler/AbstractCompilerMojo";
    private static final String LOMBOK_URL_IDENTIFIER = "/org/projectlombok/lombok/";
    private static final String LOMBOK_AGENT_CLASS = "lombok.launch.Agent";
    private static final byte[] NOT_TRANSFORMED = null;

    private MavenEcjBootstrapAgent() {
    }

    public static void premain(final String agentArgs, final Instrumentation instrumentation) {
        instrumentation.addTransformer(new ClassFileTransformer() { // from class: lombok.launch.MavenEcjBootstrapAgent.1
            public byte[] transform(ClassLoader loader, String className, Class<?> cbr, ProtectionDomain pd, byte[] cfb) throws IllegalClassFormatException {
                if (MavenEcjBootstrapAgent.MAVEN_COMPILER_TRIGGER_CLASS.equals(className)) {
                    for (URL url : ((URLClassLoader) loader).getURLs()) {
                        if (url.getPath().contains(MavenEcjBootstrapAgent.LOMBOK_URL_IDENTIFIER)) {
                            try {
                                instrumentation.appendToSystemClassLoaderSearch(new JarFile(url.getPath()));
                                MavenEcjBootstrapAgent.class.getClassLoader().loadClass(MavenEcjBootstrapAgent.LOMBOK_AGENT_CLASS).getDeclaredMethod("premain", String.class, Instrumentation.class).invoke(null, agentArgs, instrumentation);
                                instrumentation.removeTransformer(this);
                                break;
                            } catch (Exception e) {
                                e.printStackTrace(System.err);
                            }
                        }
                    }
                }
                return MavenEcjBootstrapAgent.NOT_TRANSFORMED;
            }
        });
    }
}
