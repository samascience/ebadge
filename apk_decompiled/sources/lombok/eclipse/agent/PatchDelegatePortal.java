package lombok.eclipse.agent;

import java.lang.reflect.Method;
import lombok.permit.Permit;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/eclipse/agent/PatchDelegatePortal.SCL.lombok */
public class PatchDelegatePortal {
    static final String CLASS_SCOPE = "org.eclipse.jdt.internal.compiler.lookup.ClassScope";
    static final String I_JAVA_ELEMENT_ARRAY = "[Lorg.eclipse.jdt.core.IJavaElement;";
    static final String SOURCE_TYPE_ELEMENT_INFO = "org.eclipse.jdt.internal.core.SourceTypeElementInfo";

    public static boolean handleDelegateForType(Object classScope) {
        Boolean v = (Boolean) Permit.invokeSneaky(Reflection.problemHandleDelegate, Reflection.handleDelegateForType, null, classScope);
        if (v == null) {
            return false;
        }
        return v.booleanValue();
    }

    public static Object[] addGeneratedDelegateMethods(Object returnValue, Object javaElement) {
        return (Object[]) Permit.invokeSneaky(Reflection.problemAddGeneratedDelegateMethods, Reflection.addGeneratedDelegateMethods, null, returnValue, javaElement);
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/eclipse/agent/PatchDelegatePortal$Reflection.SCL.lombok */
    private static final class Reflection {
        public static final Method handleDelegateForType;
        public static final Method addGeneratedDelegateMethods;
        public static final Throwable problemHandleDelegate;
        public static final Throwable problemAddGeneratedDelegateMethods;

        private Reflection() {
        }

        static {
            Method m = null;
            Method n = null;
            Throwable problemHandleDelegate_ = null;
            Throwable problemAddGeneratedDelegateMethods_ = null;
            try {
                m = Permit.getMethod(PatchDelegate.class, "handleDelegateForType", Class.forName(PatchDelegatePortal.CLASS_SCOPE));
            } catch (Throwable t) {
                problemHandleDelegate_ = t;
            }
            handleDelegateForType = m;
            problemHandleDelegate = problemHandleDelegate_;
            try {
                n = Permit.getMethod(PatchDelegate.class, "addGeneratedDelegateMethods", Object[].class, Object.class);
            } catch (Throwable t2) {
                problemAddGeneratedDelegateMethods_ = t2;
            }
            addGeneratedDelegateMethods = n;
            problemAddGeneratedDelegateMethods = problemAddGeneratedDelegateMethods_;
        }
    }
}
