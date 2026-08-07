package lombok.eclipse.agent;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.lang.reflect.Method;
import java.util.Map;
import lombok.eclipse.EcjAugments;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.permit.Permit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jdt.internal.core.SourceMethod;
import org.eclipse.jdt.internal.ui.text.javadoc.JavadocContentAccess2;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/eclipse/agent/PatchJavadoc.SCL.lombok */
public class PatchJavadoc {
    public static String getHTMLContentFromSource(String original, Object member) {
        if (original != null) {
            return original;
        }
        if (member instanceof SourceMethod) {
            SourceMethod sourceMethod = (SourceMethod) member;
            ICompilationUnit compilationUnit = sourceMethod.getCompilationUnit();
            if (compilationUnit instanceof CompilationUnit) {
                Map<String, String> docs = EcjAugments.CompilationUnit_javadoc.get((CompilationUnit) compilationUnit);
                if (docs == null) {
                    return null;
                }
                String signature = Signature.getSignature(sourceMethod);
                String rawJavadoc = docs.get(signature);
                if (rawJavadoc == null) {
                    return null;
                }
                return Reflection.javadoc2HTML((IMember) member, (IJavaElement) member, rawJavadoc);
            }
            return null;
        }
        return null;
    }

    public static StringBuffer printMethod(AbstractMethodDeclaration methodDeclaration, Integer tab, StringBuffer output, TypeDeclaration type) {
        Map<String, String> docs = EcjAugments.CompilationUnit_javadoc.get(methodDeclaration.compilationResult.compilationUnit);
        if (docs != null) {
            String signature = EclipseHandlerUtil.getSignature(type, methodDeclaration);
            String rawJavadoc = docs.get(signature);
            if (rawJavadoc != null) {
                for (String line : rawJavadoc.split("\r?\n")) {
                    ASTNode.printIndent(tab.intValue(), output).append(line).append("\n");
                }
            }
        }
        return methodDeclaration.print(tab.intValue(), output);
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/eclipse/agent/PatchJavadoc$Signature.SCL.lombok */
    private static class Signature {
        private Signature() {
        }

        static final String getSignature(SourceMethod sourceMethod) {
            StringBuilder sb = new StringBuilder();
            sb.append(sourceMethod.getParent().getElementName());
            sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            sb.append(sourceMethod.getElementName());
            sb.append("(");
            for (String type : sourceMethod.getParameterTypes()) {
                sb.append(org.eclipse.jdt.core.Signature.toString(type));
            }
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/eclipse/agent/PatchJavadoc$Reflection.SCL.lombok */
    private static class Reflection {
        private static final Method javadoc2HTML;
        private static final Method oldJavadoc2HTML;
        private static final Method lsJavadoc2HTML;

        private Reflection() {
        }

        static {
            Method a = null;
            Method b = null;
            Method c = null;
            try {
                a = Permit.getMethod(JavadocContentAccess2.class, "javadoc2HTML", IMember.class, IJavaElement.class, String.class);
            } catch (Throwable unused) {
            }
            try {
                b = Permit.getMethod(JavadocContentAccess2.class, "javadoc2HTML", IMember.class, String.class);
            } catch (Throwable unused2) {
            }
            try {
                c = Permit.getMethod(Class.forName("org.eclipse.jdt.ls.core.internal.javadoc.JavadocContentAccess2"), "javadoc2HTML", IMember.class, IJavaElement.class, String.class);
            } catch (Throwable unused3) {
            }
            javadoc2HTML = a;
            oldJavadoc2HTML = b;
            lsJavadoc2HTML = c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String javadoc2HTML(IMember member, IJavaElement element, String rawJavadoc) {
            if (javadoc2HTML != null) {
                try {
                    return (String) javadoc2HTML.invoke(null, member, element, rawJavadoc);
                } catch (Throwable unused) {
                    return null;
                }
            }
            if (lsJavadoc2HTML != null) {
                try {
                    return (String) lsJavadoc2HTML.invoke(null, member, element, rawJavadoc);
                } catch (Throwable unused2) {
                    return null;
                }
            }
            if (oldJavadoc2HTML != null) {
                try {
                    return (String) oldJavadoc2HTML.invoke(null, member, rawJavadoc);
                } catch (Throwable unused3) {
                    return null;
                }
            }
            return null;
        }
    }
}
