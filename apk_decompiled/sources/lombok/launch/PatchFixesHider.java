package lombok.launch;

import android.os.IBinder;
import android.os.Parcel;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.pairip.licensecheck.LicenseActivity;
import defpackage.a1;
import defpackage.a13;
import defpackage.a22;
import defpackage.a23;
import defpackage.a52;
import defpackage.a60;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import lombok.eclipse.EcjAugments;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.adaptor.EclipseStarter;
import org.eclipse.jdt.core.IAnnotatable;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.core.SourceField;
import org.eclipse.jdt.internal.core.dom.rewrite.NodeRewriteEvent;
import org.eclipse.jdt.internal.core.dom.rewrite.RewriteEvent;
import org.eclipse.jdt.internal.core.dom.rewrite.TokenScanner;
import org.eclipse.jdt.internal.corext.refactoring.SearchResultGroup;
import org.eclipse.jdt.internal.corext.refactoring.structure.MemberVisibilityAdjustor;
import org.osgi.framework.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:Class50/lombok/launch/PatchFixesHider.SCL.lombok */
public final class PatchFixesHider {
    PatchFixesHider() {
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:Class50/lombok/launch/PatchFixesHider$Util.SCL.lombok */
    public static final class Util {
        private static ClassLoader shadowLoader;

        public static ClassLoader getShadowLoader() {
            if (shadowLoader == null) {
                try {
                    Class.forName("lombok.core.LombokNode");
                    shadowLoader = Util.class.getClassLoader();
                } catch (ClassNotFoundException unused) {
                    shadowLoader = Main.getShadowClassLoader();
                }
            }
            return shadowLoader;
        }

        public static Class<?> shadowLoadClass(String name) {
            try {
                return Class.forName(name, true, getShadowLoader());
            } catch (ClassNotFoundException e) {
                throw sneakyThrow(e);
            }
        }

        public static Method findMethod(Class<?> type, String name, Class<?>... clsArr) {
            try {
                return type.getDeclaredMethod(name, clsArr);
            } catch (NoSuchMethodException e) {
                throw sneakyThrow(e);
            }
        }

        public static Method findMethod(Class<?> type, String name, String... parameterTypes) {
            for (Method m : type.getDeclaredMethods()) {
                if (name.equals(m.getName()) && sameTypes(m.getParameterTypes(), parameterTypes)) {
                    return m;
                }
            }
            throw sneakyThrow(new NoSuchMethodException(String.valueOf(type.getName()) + "::" + name));
        }

        public static Method findMethodAnyArgs(Class<?> type, String name) {
            for (Method m : type.getDeclaredMethods()) {
                if (name.equals(m.getName())) {
                    return m;
                }
            }
            throw sneakyThrow(new NoSuchMethodException(String.valueOf(type.getName()) + "::" + name));
        }

        public static Object invokeMethod(Method method, Object... args) {
            try {
                return method.invoke(null, args);
            } catch (IllegalAccessException e) {
                throw sneakyThrow(e);
            } catch (InvocationTargetException e2) {
                throw sneakyThrow(e2.getCause());
            }
        }

        private static RuntimeException sneakyThrow(Throwable t) throws Throwable {
            if (t == null) {
                throw new NullPointerException("t");
            }
            sneakyThrow0(t);
            return null;
        }

        private static <T extends Throwable> void sneakyThrow0(Throwable t) throws Throwable {
            throw t;
        }

        private static boolean sameTypes(Class<?>[] clsArr, String[] typeNames) {
            if (clsArr.length != typeNames.length) {
                return false;
            }
            for (int i = 0; i < clsArr.length; i++) {
                if (!clsArr[i].getName().equals(typeNames[i])) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:Class50/lombok/launch/PatchFixesHider$LombokDeps.SCL.lombok */
    public static final class LombokDeps {
        public static final Method ADD_LOMBOK_NOTES = null;
        public static final Method POST_COMPILER_BYTES_STRING = null;
        public static final Method POST_COMPILER_OUTPUTSTREAM = null;
        public static final Method POST_COMPILER_BUFFEREDOUTPUTSTREAM_STRING_STRING = null;

        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:44)
            */
        public LombokDeps(java.lang.Long r3, long r4, java.lang.String r6, java.util.Date r7, int r8, java.lang.String r9, boolean r10) {
            /*
                r2 = this;
                r0 = r2
                super/*a82*/.run()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider.LombokDeps.<init>(java.lang.Long, long, java.lang.String, java.util.Date, int, java.lang.String, boolean):void");
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, void] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.reflect.Method, long] */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.reflect.Method, long] */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.reflect.Method, long] */
        /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.reflect.Method, long] */
        /* JADX INFO: renamed from: <init>, reason: not valid java name */
        static void m324init() {
            ?? M = a13.m("lombok.eclipse.agent.PatchFixesShadowLoaded");
            Class[] clsArr = {String.class, String.class};
            ADD_LOMBOK_NOTES = a1.insertOrReplace(M);
            Class[] clsArr2 = {byte[].class, String.class};
            POST_COMPILER_BYTES_STRING = a1.insertOrReplace(M);
            new Class[1][0] = OutputStream.class;
            POST_COMPILER_OUTPUTSTREAM = a1.insertOrReplace(M);
            Class[] clsArr3 = {BufferedOutputStream.class, String.class, String.class};
            POST_COMPILER_BUFFEREDOUTPUTSTREAM_STRING_STRING = a1.insertOrReplace(M);
        }

        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('origReturnValue' java.lang.String)]), block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0017: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('origReturnValue' java.lang.String)]) (LINE:178), block:B:4:0x0016 */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('key' java.lang.String)]), block:B:2:0x0000 */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String, java.util.Date] */
        public static Date getDate() {
            Date date;
            String origReturnValue;
            String key;
            try {
                return (String) Util.invokeMethod(ADD_LOMBOK_NOTES, origReturnValue, key);
            } catch (Throwable unused) {
                return date;
            }
        }

        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('bytes' byte[])]), block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('fileName' java.lang.String)]), block:B:2:0x0000 */
        /* JADX WARN: Type inference failed for: r0v2, types: [byte[], java.lang.String] */
        public static String getDateStrIndex() {
            byte[] bytes;
            String fileName;
            return (byte[]) Util.invokeMethod(POST_COMPILER_BYTES_STRING, bytes, fileName);
        }

        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('out' java.io.OutputStream)]), block:B:2:0x0000 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.io.OutputStream, java.lang.String] */
        public static String getDevid() throws IOException {
            OutputStream out;
            return (OutputStream) Util.invokeMethod(POST_COMPILER_OUTPUTSTREAM, out);
        }

        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('out' java.io.BufferedOutputStream)]), block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('path' java.lang.String)]), block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0011: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('name' java.lang.String)]), block:B:2:0x0000 */
        /* JADX WARN: Type inference failed for: r0v2, types: [int, java.io.BufferedOutputStream] */
        public static int getFlag() throws IOException {
            BufferedOutputStream out;
            String path;
            String name;
            return (BufferedOutputStream) Util.invokeMethod(POST_COMPILER_BUFFEREDOUTPUTSTREAM_STRING_STRING, out, path, name);
        }
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:Class50/lombok/launch/PatchFixesHider$Transform.SCL.lombok */
    public static final class Transform {
        private static Method TRANSFORM;
        private static Method TRANSFORM_SWAPPED;

        private static synchronized void init(ClassLoader prepend) {
            if (TRANSFORM != null) {
                return;
            }
            Main.prependClassLoader(prepend);
            Class<?> shadowed = Util.shadowLoadClass("lombok.eclipse.TransformEclipseAST");
            TRANSFORM = Util.findMethodAnyArgs(shadowed, "transform");
            TRANSFORM_SWAPPED = Util.findMethodAnyArgs(shadowed, "transform_swapped");
        }

        public static void transform(Object parser, Object ast) throws IOException {
            init(parser.getClass().getClassLoader());
            Util.invokeMethod(TRANSFORM, parser, ast);
        }

        public static void transform_swapped(Object ast, Object parser) throws IOException {
            init(parser.getClass().getClassLoader());
            Util.invokeMethod(TRANSFORM_SWAPPED, ast, parser);
        }
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:Class50/lombok/launch/PatchFixesHider$Delegate.SCL.lombok */
    public static final class Delegate {
        private static final Method HANDLE_DELEGATE_FOR_TYPE = null;
        private static final Method ADD_GENERATED_DELEGATE_METHODS = null;

        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:44)
            */
        public Delegate(java.lang.Object r3, java.lang.Object r4) {
            /*
                r2 = this;
                r0 = r2
                super/*a50*/.e(r2, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider.Delegate.setAndReturn(java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:44)
            */
        static void set(
        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r0v1, types: [void] */
        /* JADX WARN: Type inference failed for: r0v2, types: [a52, java.lang.Boolean, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, void] */
        public static void setFallbackSetter(SettableBeanProperty settableBeanProperty) {
            ?? r0 = (Boolean) a52.b(HANDLE_DELEGATE_FOR_TYPE, new Object[]{settableBeanProperty});
        }

        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('returnValue' java.lang.Object)]), block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('javaElement' java.lang.Object)]), block:B:2:0x0000 */
        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r0v1, types: [void] */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object[], java.lang.String] */
        public static String toString() {
            Object returnValue;
            Object javaElement;
            return (Object[]) a52.b(ADD_GENERATED_DELEGATE_METHODS, new Object[]{returnValue, javaElement});
        }
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:Class50/lombok/launch/PatchFixesHider$ValPortal.SCL.lombok */
    public static final class ValPortal {
        private static final Method COPY_INITIALIZATION_OF_FOR_EACH_ITERABLE;
        private static final Method COPY_INITIALIZATION_OF_LOCAL_DECLARATION;
        private static final Method ADD_FINAL_AND_VAL_ANNOTATION_TO_VARIABLE_DECLARATION_STATEMENT;
        private static final Method ADD_FINAL_AND_VAL_ANNOTATION_TO_SINGLE_VARIABLE_DECLARATION;

        static {
            Class<?> shadowed = Util.shadowLoadClass("lombok.eclipse.agent.PatchValEclipsePortal");
            COPY_INITIALIZATION_OF_FOR_EACH_ITERABLE = Util.findMethod(shadowed, "copyInitializationOfForEachIterable", (Class<?>[]) new Class[]{Object.class});
            COPY_INITIALIZATION_OF_LOCAL_DECLARATION = Util.findMethod(shadowed, "copyInitializationOfLocalDeclaration", (Class<?>[]) new Class[]{Object.class});
            ADD_FINAL_AND_VAL_ANNOTATION_TO_VARIABLE_DECLARATION_STATEMENT = Util.findMethod(shadowed, "addFinalAndValAnnotationToVariableDeclarationStatement", (Class<?>[]) new Class[]{Object.class, Object.class, Object.class});
            ADD_FINAL_AND_VAL_ANNOTATION_TO_SINGLE_VARIABLE_DECLARATION = Util.findMethod(shadowed, "addFinalAndValAnnotationToSingleVariableDeclaration", (Class<?>[]) new Class[]{Object.class, Object.class, Object.class});
        }

        public static void copyInitializationOfForEachIterable(Object parser) {
            Util.invokeMethod(COPY_INITIALIZATION_OF_FOR_EACH_ITERABLE, parser);
        }

        public static void copyInitializationOfLocalDeclaration(Object parser) {
            Util.invokeMethod(COPY_INITIALIZATION_OF_LOCAL_DECLARATION, parser);
        }

        public static void addFinalAndValAnnotationToVariableDeclarationStatement(Object converter, Object out, Object in) {
            Util.invokeMethod(ADD_FINAL_AND_VAL_ANNOTATION_TO_VARIABLE_DECLARATION_STATEMENT, converter, out, in);
        }

        public static void addFinalAndValAnnotationToSingleVariableDeclaration(Object converter, Object out, Object in) {
            Util.invokeMethod(ADD_FINAL_AND_VAL_ANNOTATION_TO_SINGLE_VARIABLE_DECLARATION, converter, out, in);
        }
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:Class50/lombok/launch/PatchFixesHider$Val.SCL.lombok */
    public static final class Val {
        private static final String BLOCK_SCOPE_SIG = "org.eclipse.jdt.internal.compiler.lookup.BlockScope";
        private static final String LOCAL_DECLARATION_SIG = "org.eclipse.jdt.internal.compiler.ast.LocalDeclaration";
        private static final String FOREACH_STATEMENT_SIG = "org.eclipse.jdt.internal.compiler.ast.ForeachStatement";
        private static final Method HANDLE_VAL_FOR_LOCAL_DECLARATION;
        private static final Method HANDLE_VAL_FOR_FOR_EACH;

        static {
            Class<?> shadowed = Util.shadowLoadClass("lombok.eclipse.agent.PatchVal");
            HANDLE_VAL_FOR_LOCAL_DECLARATION = Util.findMethod(shadowed, "handleValForLocalDeclaration", LOCAL_DECLARATION_SIG, BLOCK_SCOPE_SIG);
            HANDLE_VAL_FOR_FOR_EACH = Util.findMethod(shadowed, "handleValForForEach", FOREACH_STATEMENT_SIG, BLOCK_SCOPE_SIG);
        }

        public static boolean handleValForLocalDeclaration(Object local, Object scope) {
            return ((Boolean) Util.invokeMethod(HANDLE_VAL_FOR_LOCAL_DECLARATION, local, scope)).booleanValue();
        }

        public static boolean handleValForForEach(Object forEach, Object scope) {
            return ((Boolean) Util.invokeMethod(HANDLE_VAL_FOR_FOR_EACH, forEach, scope)).booleanValue();
        }

        public static TypeBinding skipResolveInitializerIfAlreadyCalled(Expression expr, BlockScope scope) {
            if (expr.resolvedType != null) {
                return expr.resolvedType;
            }
            try {
                return expr.resolveType(scope);
            } catch (ArrayIndexOutOfBoundsException unused) {
                return null;
            } catch (NullPointerException unused2) {
                return null;
            }
        }

        public static TypeBinding skipResolveInitializerIfAlreadyCalled2(Expression expr, BlockScope scope, LocalDeclaration decl) {
            if (decl != null && LocalDeclaration.class.equals(decl.getClass()) && expr.resolvedType != null) {
                return expr.resolvedType;
            }
            try {
                return expr.resolveType(scope);
            } catch (ArrayIndexOutOfBoundsException unused) {
                return null;
            } catch (NullPointerException unused2) {
                return null;
            }
        }
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:Class50/lombok/launch/PatchFixesHider$ExtensionMethod.SCL.lombok */
    public static final class ExtensionMethod {
        private static final String MESSAGE_SEND_SIG = "org.eclipse.jdt.internal.compiler.ast.MessageSend";
        private static final String TYPE_BINDING_SIG = "org.eclipse.jdt.internal.compiler.lookup.TypeBinding";
        private static final String SCOPE_SIG = "org.eclipse.jdt.internal.compiler.lookup.Scope";
        private static final String BLOCK_SCOPE_SIG = "org.eclipse.jdt.internal.compiler.lookup.BlockScope";
        private static final String TYPE_BINDINGS_SIG = "[Lorg.eclipse.jdt.internal.compiler.lookup.TypeBinding;";
        private static final String PROBLEM_REPORTER_SIG = "org.eclipse.jdt.internal.compiler.problem.ProblemReporter";
        private static final String METHOD_BINDING_SIG = "org.eclipse.jdt.internal.compiler.lookup.MethodBinding";
        private static final String AST_NODE_SIG = "org.eclipse.jdt.internal.compiler.ast.ASTNode";
        private static final Method RESOLVE_TYPE;
        private static final Method ERROR_NO_METHOD_FOR;
        private static final Method INVALID_METHOD;
        private static final Method INVALID_METHOD2;
        private static final Method NON_STATIC_ACCESS_TO_STATIC_METHOD;

        /* JADX WARN: Multi-variable type inference failed */
        public ExtensionMethod() {
            super(this);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [android.os.IBinder, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.reflect.Method, void] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.reflect.Method, void] */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.reflect.Method, void] */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.reflect.Method, void] */
        /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.reflect.Method, void] */
        static {
            ?? interfaceDescriptor = IBinder.getInterfaceDescriptor();
            String[] strArr = {TYPE_BINDING_SIG, MESSAGE_SEND_SIG, BLOCK_SCOPE_SIG};
            RESOLVE_TYPE = Parcel.writeStrongBinder(interfaceDescriptor);
            String[] strArr2 = {PROBLEM_REPORTER_SIG, MESSAGE_SEND_SIG, TYPE_BINDING_SIG, TYPE_BINDINGS_SIG};
            ERROR_NO_METHOD_FOR = Parcel.writeStrongBinder(interfaceDescriptor);
            String[] strArr3 = {PROBLEM_REPORTER_SIG, MESSAGE_SEND_SIG, METHOD_BINDING_SIG};
            INVALID_METHOD = Parcel.writeStrongBinder(interfaceDescriptor);
            String[] strArr4 = {PROBLEM_REPORTER_SIG, MESSAGE_SEND_SIG, METHOD_BINDING_SIG, SCOPE_SIG};
            INVALID_METHOD2 = Parcel.writeStrongBinder(interfaceDescriptor);
            String[] strArr5 = {PROBLEM_REPORTER_SIG, AST_NODE_SIG, METHOD_BINDING_SIG, MESSAGE_SEND_SIG};
            NON_STATIC_ACCESS_TO_STATIC_METHOD = Parcel.writeStrongBinder(interfaceDescriptor);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [int, java.lang.Object] */
        public static Object resolveType(Object resolvedType, Object methodCall, Object scope) {
            Method method = RESOLVE_TYPE;
            Object[] objArr = {resolvedType, methodCall, scope};
            return LicenseActivity.ActivityType.ordinal();
        }

        public static void errorNoMethodFor(Object problemReporter, Object messageSend, Object recType, Object params) {
            Method method = ERROR_NO_METHOD_FOR;
            Object[] objArr = {problemReporter, messageSend, recType, params};
            LicenseActivity.ActivityType.ordinal();
        }

        public static void invalidMethod(Object problemReporter, Object messageSend, Object method) {
            Method method2 = INVALID_METHOD;
            Object[] objArr = {problemReporter, messageSend, method};
            LicenseActivity.ActivityType.ordinal();
        }

        public static void invalidMethod(Object problemReporter, Object messageSend, Object method, Object scope) {
            Method method2 = INVALID_METHOD2;
            Object[] objArr = {problemReporter, messageSend, method, scope};
            LicenseActivity.ActivityType.ordinal();
        }

        public static void nonStaticAccessToStaticMethod(Object problemReporter, Object location, Object method, Object messageSend) {
            Method method2 = NON_STATIC_ACCESS_TO_STATIC_METHOD;
            Object[] objArr = {problemReporter, location, method, messageSend};
            LicenseActivity.ActivityType.ordinal();
        }
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:Class50/lombok/launch/PatchFixesHider$Javadoc.SCL.lombok */
    public static final class Javadoc {
        private static final Method GET_HTML;
        private static final Method PRINT_METHOD;

        /* JADX WARN: Multi-variable type inference failed */
        public Javadoc() {
            super/*a23*/.h(this);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [boolean, java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r0v5, types: [boolean, java.lang.reflect.Method] */
        static {
            String strD = a22.d("lombok.eclipse.agent.PatchJavadoc");
            Class[] clsArr = {String.class, Object.class};
            GET_HTML = a22.p(strD, "getHTMLContentFromSource");
            Class[] clsArr2 = {AbstractMethodDeclaration.class, Integer.class, StringBuffer.class, TypeDeclaration.class};
            PRINT_METHOD = a22.p(strD, "printMethod");
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r0v1, types: [void] */
        public static String getHTMLContentFromSource(String original, IJavaElement member) {
            Object[] objArr = {original, member};
            return (String) a23.m(GET_HTML);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r0v1, types: [void] */
        /* JADX WARN: Type inference failed for: r4v2, types: [void] */
        public static StringBuffer printMethod(AbstractMethodDeclaration methodDeclaration, int tab, StringBuffer output, TypeDeclaration type) {
            ?? r0 = PRINT_METHOD;
            Object[] objArr = {methodDeclaration, a60.run(), output, type};
            return (StringBuffer) a23.m(r0);
        }
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:Class50/lombok/launch/PatchFixesHider$PatchFixes.SCL.lombok */
    public static final class PatchFixes {
        public static final int ALREADY_PROCESSED_FLAG = 8388608;

        public static boolean isGenerated(ASTNode node) {
            boolean result = false;
            try {
                result = ((Boolean) node.getClass().getField("$isGenerated").get(node)).booleanValue();
                if (!result && node.getParent() != null && (node.getParent() instanceof QualifiedName)) {
                    result = isGenerated(node.getParent());
                }
            } catch (Exception unused) {
            }
            return result;
        }

        public static boolean isGenerated(org.eclipse.jdt.internal.compiler.ast.ASTNode node) {
            boolean result = false;
            try {
                result = node.getClass().getField("$generatedBy").get(node) != null;
            } catch (Exception unused) {
            }
            return result;
        }

        public static boolean isGenerated(IMember member) {
            boolean result = false;
            try {
                result = member.getNameRange().getLength() <= 0 || member.getNameRange().equals(member.getSourceRange());
            } catch (JavaModelException unused) {
            }
            return result;
        }

        public static boolean isBlockedVisitorAndGenerated(ASTNode node, ASTVisitor visitor) {
            if (visitor == null) {
                return false;
            }
            String className = visitor.getClass().getName();
            if ((className.startsWith("org.eclipse.jdt.internal.corext.fix") || className.startsWith("org.eclipse.jdt.internal.ui.fix") || className.startsWith("org.eclipse.jdt.ls.core.internal.semantictokens.SemanticTokensVisitor")) && !className.equals("org.eclipse.jdt.internal.corext.fix.VariableDeclarationFixCore$WrittenNamesFinder")) {
                return isGenerated(node);
            }
            return false;
        }

        public static boolean isListRewriteOnGeneratedNode(ListRewrite rewrite) {
            return isGenerated(rewrite.getParent());
        }

        public static boolean returnFalse(Object object) {
            return false;
        }

        public static boolean returnTrue(Object object) {
            return true;
        }

        public static List removeGeneratedNodes(List list) {
            try {
                List realNodes = new ArrayList(list.size());
                for (Object node : list) {
                    if (!isGenerated((ASTNode) node)) {
                        realNodes.add(node);
                    }
                }
                return realNodes;
            } catch (Exception unused) {
                return list;
            }
        }

        public static String getRealMethodDeclarationSource(String original, Object processor, MethodDeclaration declaration) throws Exception {
            if (!isGenerated((ASTNode) declaration)) {
                return original;
            }
            List<Annotation> annotations = new ArrayList<>();
            for (Object modifier : declaration.modifiers()) {
                if (modifier instanceof Annotation) {
                    Annotation annotation = (Annotation) modifier;
                    String qualifiedAnnotationName = annotation.resolveTypeBinding().getQualifiedName();
                    if (!"java.lang.Override".equals(qualifiedAnnotationName) && !"java.lang.SuppressWarnings".equals(qualifiedAnnotationName)) {
                        annotations.add(annotation);
                    }
                }
            }
            StringBuilder signature = new StringBuilder();
            addAnnotations(annotations, signature);
            try {
                if (((Boolean) processor.getClass().getDeclaredField("fPublic").get(processor)).booleanValue()) {
                    signature.append("public ");
                }
                if (((Boolean) processor.getClass().getDeclaredField("fAbstract").get(processor)).booleanValue()) {
                    signature.append("abstract ");
                }
            } catch (Throwable unused) {
            }
            signature.append(declaration.getReturnType2().toString()).append(" ").append(declaration.getName().getFullyQualifiedName()).append("(");
            boolean first = true;
            for (Object parameter : declaration.parameters()) {
                if (!first) {
                    signature.append(", ");
                }
                first = false;
                signature.append(parameter);
            }
            signature.append(");");
            return signature.toString();
        }

        public static void addAnnotations(List<Annotation> annotations, StringBuilder signature) {
            Iterator<Annotation> it = annotations.iterator();
            while (it.hasNext()) {
                SingleMemberAnnotation singleMemberAnnotation = (Annotation) it.next();
                List<String> values = new ArrayList<>();
                if (singleMemberAnnotation.isSingleMemberAnnotation()) {
                    SingleMemberAnnotation smAnn = singleMemberAnnotation;
                    values.add(smAnn.getValue().toString());
                } else if (singleMemberAnnotation.isNormalAnnotation()) {
                    NormalAnnotation normalAnn = (NormalAnnotation) singleMemberAnnotation;
                    for (Object value : normalAnn.values()) {
                        values.add(value.toString());
                    }
                }
                signature.append("@").append(singleMemberAnnotation.getTypeName().getFullyQualifiedName());
                if (!values.isEmpty()) {
                    signature.append("(");
                    boolean first = true;
                    for (String string : values) {
                        if (!first) {
                            signature.append(", ");
                        }
                        first = false;
                        signature.append(JsonFactory.DEFAULT_QUOTE_CHAR).append(string).append(JsonFactory.DEFAULT_QUOTE_CHAR);
                    }
                    signature.append(")");
                }
                signature.append(" ");
            }
        }

        public static MethodDeclaration getRealMethodDeclarationNode(MethodDeclaration original, IMethod sourceMethod, CompilationUnit cuUnit) throws JavaModelException {
            AbstractTypeDeclaration typeDeclaration;
            if (!isGenerated((ASTNode) original)) {
                return original;
            }
            Stack<IType> typeStack = new Stack<>();
            for (IType declaringType = sourceMethod.getDeclaringType(); declaringType != null; declaringType = declaringType.getDeclaringType()) {
                typeStack.push(declaringType);
            }
            IType rootType = typeStack.pop();
            AbstractTypeDeclaration abstractTypeDeclarationFindTypeDeclaration = findTypeDeclaration(rootType, cuUnit.types());
            while (true) {
                typeDeclaration = abstractTypeDeclarationFindTypeDeclaration;
                if (typeStack.isEmpty() || typeDeclaration == null) {
                    break;
                }
                abstractTypeDeclarationFindTypeDeclaration = findTypeDeclaration(typeStack.pop(), typeDeclaration.bodyDeclarations());
            }
            String targetMethodName = sourceMethod.getElementName();
            List<String> targetMethodParameterTypes = new ArrayList<>();
            for (String parameterType : sourceMethod.getParameterTypes()) {
                targetMethodParameterTypes.add(Signature.toString(parameterType));
            }
            if (typeStack.isEmpty() && typeDeclaration != null) {
                for (Object declaration : typeDeclaration.bodyDeclarations()) {
                    if (declaration instanceof MethodDeclaration) {
                        MethodDeclaration methodDeclaration = (MethodDeclaration) declaration;
                        if (methodDeclaration.getName().toString().equals(targetMethodName) && methodDeclaration.parameters().size() == targetMethodParameterTypes.size() && isGenerated((ASTNode) methodDeclaration)) {
                            boolean parameterTypesEquals = true;
                            for (int i = 0; i < methodDeclaration.parameters().size(); i++) {
                                SingleVariableDeclaration variableDeclaration = (SingleVariableDeclaration) methodDeclaration.parameters().get(i);
                                if (!variableDeclaration.getType().toString().equals(targetMethodParameterTypes.get(i))) {
                                    parameterTypesEquals = false;
                                    break;
                                }
                            }
                            if (parameterTypesEquals) {
                                return methodDeclaration;
                            }
                        }
                    }
                }
            }
            return original;
        }

        public static AbstractTypeDeclaration findTypeDeclaration(IType searchType, List<?> nodes) {
            for (Object object : nodes) {
                if (object instanceof AbstractTypeDeclaration) {
                    AbstractTypeDeclaration typeDeclaration = (AbstractTypeDeclaration) object;
                    if (typeDeclaration.getName().toString().equals(searchType.getElementName())) {
                        return typeDeclaration;
                    }
                }
            }
            return null;
        }

        public static int getSourceEndFixed(int sourceEnd, org.eclipse.jdt.internal.compiler.ast.ASTNode node) throws Exception {
            org.eclipse.jdt.internal.compiler.ast.ASTNode object;
            if (sourceEnd == -1 && (object = (org.eclipse.jdt.internal.compiler.ast.ASTNode) node.getClass().getField("$generatedBy").get(node)) != null) {
                return object.sourceEnd;
            }
            return sourceEnd;
        }

        public static int fixRetrieveStartingCatchPosition(int original, int start) {
            return original == -1 ? start : original;
        }

        public static int fixRetrieveIdentifierEndPosition(int original, int start, int end) {
            if (original != -1 && original >= start) {
                return original;
            }
            return end;
        }

        public static int fixRetrieveEllipsisStartPosition(int original, int end) {
            return original == -1 ? end : original;
        }

        public static int fixRetrieveStartBlockPosition(int original, int start) {
            return original == -1 ? start : original;
        }

        public static int fixRetrieveRightBraceOrSemiColonPosition(int original, int end) {
            return original == -1 ? end : original;
        }

        public static int fixRetrieveRightBraceOrSemiColonPosition(int retVal, AbstractMethodDeclaration amd) {
            if (retVal != -1 || amd == null) {
                return retVal;
            }
            boolean isGenerated = EcjAugments.ASTNode_generatedBy.get(amd) != null;
            if (isGenerated) {
                return amd.declarationSourceEnd;
            }
            return -1;
        }

        public static int fixRetrieveRightBraceOrSemiColonPosition(int retVal, FieldDeclaration fd) {
            if (retVal != -1 || fd == null) {
                return retVal;
            }
            boolean isGenerated = EcjAugments.ASTNode_generatedBy.get(fd) != null;
            if (isGenerated) {
                return fd.declarationSourceEnd;
            }
            return -1;
        }

        public static int fixRetrieveProperRightBracketPosition(int retVal, Type type) {
            if (retVal != -1 || type == null) {
                return retVal;
            }
            if (isGenerated((ASTNode) type)) {
                return (type.getStartPosition() + type.getLength()) - 1;
            }
            return -1;
        }

        public static boolean checkBit24(Object node) throws Exception {
            int bits = ((Integer) node.getClass().getField("bits").get(node)).intValue();
            return (bits & 8388608) != 0;
        }

        public static boolean skipRewritingGeneratedNodes(ASTNode node) throws Exception {
            return ((Boolean) node.getClass().getField("$isGenerated").get(node)).booleanValue();
        }

        public static void setIsGeneratedFlag(ASTNode domNode, org.eclipse.jdt.internal.compiler.ast.ASTNode internalNode) throws Exception {
            if (internalNode == null || domNode == null) {
                return;
            }
            boolean isGenerated = EcjAugments.ASTNode_generatedBy.get(internalNode) != null;
            if (isGenerated) {
                domNode.getClass().getField("$isGenerated").set(domNode, true);
            }
        }

        public static void setIsGeneratedFlagForName(Name name, Object internalNode) throws Exception {
            if (internalNode instanceof org.eclipse.jdt.internal.compiler.ast.ASTNode) {
                boolean isGenerated = EcjAugments.ASTNode_generatedBy.get((org.eclipse.jdt.internal.compiler.ast.ASTNode) internalNode) != null;
                if (isGenerated) {
                    name.getClass().getField("$isGenerated").set(name, true);
                }
            }
        }

        public static RewriteEvent[] listRewriteHandleGeneratedMethods(RewriteEvent parent) {
            RewriteEvent[] children = parent.getChildren();
            List<RewriteEvent> newChildren = new ArrayList<>();
            List<RewriteEvent> modifiedChildren = new ArrayList<>();
            for (RewriteEvent child : children) {
                boolean isGenerated = isGenerated((ASTNode) child.getOriginalValue());
                if (isGenerated) {
                    boolean isReplacedOrRemoved = child.getChangeKind() == 4 || child.getChangeKind() == 2;
                    boolean convertingFromMethod = child.getOriginalValue() instanceof MethodDeclaration;
                    if (isReplacedOrRemoved && convertingFromMethod && child.getNewValue() != null) {
                        modifiedChildren.add(new NodeRewriteEvent((Object) null, child.getNewValue()));
                    }
                } else {
                    newChildren.add(child);
                }
            }
            newChildren.addAll(modifiedChildren);
            return (RewriteEvent[]) newChildren.toArray(new RewriteEvent[0]);
        }

        public static int getTokenEndOffsetFixed(TokenScanner scanner, int token, int startOffset, Object domNode) throws CoreException {
            boolean isGenerated = false;
            try {
                isGenerated = ((Boolean) domNode.getClass().getField("$isGenerated").get(domNode)).booleanValue();
            } catch (Exception unused) {
            }
            if (isGenerated) {
                return -1;
            }
            return scanner.getTokenEndOffset(token, startOffset);
        }

        public static IMethod[] removeGeneratedMethods(IMethod[] methods) throws Exception {
            List<IMethod> result = new ArrayList<>();
            for (IMethod m : methods) {
                if (!isGenerated((IMember) m)) {
                    result.add(m);
                }
            }
            return result.size() == methods.length ? methods : (IMethod[]) result.toArray(new IMethod[0]);
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0038  */
        public static SearchMatch[] removeGenerated(SearchMatch[] returnValue) {
            List<SearchMatch> result = new ArrayList<>();
            for (SearchMatch searchResult : returnValue) {
                if (searchResult.getElement() instanceof IField) {
                    IField field = (IField) searchResult.getElement();
                    IAnnotation annotation = field.getAnnotation("Generated");
                    if (annotation == null) {
                        result.add(searchResult);
                    }
                } else {
                    result.add(searchResult);
                }
            }
            return (SearchMatch[]) result.toArray(new SearchMatch[0]);
        }

        public static SearchResultGroup[] createFakeSearchResult(SearchResultGroup[] returnValue, Object processor) throws Exception {
            Field declaredField;
            if ((returnValue == null || returnValue.length == 0) && (declaredField = processor.getClass().getDeclaredField("fField")) != null) {
                declaredField.setAccessible(true);
                SourceField fField = (SourceField) declaredField.get(processor);
                IAnnotation dataAnnotation = fField.getDeclaringType().getAnnotation("Data");
                if (dataAnnotation != null) {
                    return new SearchResultGroup[]{new SearchResultGroup((IResource) null, new SearchMatch[1])};
                }
            }
            return returnValue;
        }

        public static SimpleName[] removeGeneratedSimpleNames(SimpleName[] in) throws Exception {
            Field f = SimpleName.class.getField("$isGenerated");
            int count = 0;
            for (int i = 0; i < in.length; i++) {
                if (in[i] == null || !((Boolean) f.get(in[i])).booleanValue()) {
                    count++;
                }
            }
            if (count == in.length) {
                return in;
            }
            SimpleName[] newSimpleNames = new SimpleName[count];
            int count2 = 0;
            for (int i2 = 0; i2 < in.length; i2++) {
                if (in[i2] == null || !((Boolean) f.get(in[i2])).booleanValue()) {
                    int i3 = count2;
                    count2++;
                    newSimpleNames[i3] = in[i2];
                }
            }
            return newSimpleNames;
        }

        public static Name[] removeGeneratedNames(Name[] in) throws Exception {
            Field f = Name.class.getField("$isGenerated");
            int count = 0;
            for (int i = 0; i < in.length; i++) {
                if (in[i] == null || !((Boolean) f.get(in[i])).booleanValue()) {
                    count++;
                }
            }
            if (count == in.length) {
                return in;
            }
            Name[] newNames = new Name[count];
            int count2 = 0;
            for (int i2 = 0; i2 < in.length; i2++) {
                if (in[i2] == null || !((Boolean) f.get(in[i2])).booleanValue()) {
                    int i3 = count2;
                    count2++;
                    newNames[i3] = in[i2];
                }
            }
            return newNames;
        }

        public static org.eclipse.jdt.internal.compiler.ast.Annotation[] convertAnnotations(org.eclipse.jdt.internal.compiler.ast.Annotation[] out, IAnnotatable annotatable) {
            try {
                IAnnotation[] in = annotatable.getAnnotations();
                if (out == null) {
                    return null;
                }
                int toWrite = 0;
                for (int idx = 0; idx < out.length; idx++) {
                    String oName = new String(out[idx].type.getLastToken());
                    boolean found = false;
                    for (IAnnotation i : in) {
                        String name = i.getElementName();
                        int li = name.lastIndexOf(46);
                        if (li > -1) {
                            name = name.substring(li + 1);
                        }
                        if (name.equals(oName)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        toWrite++;
                    } else {
                        out[idx] = null;
                    }
                }
                org.eclipse.jdt.internal.compiler.ast.Annotation[] replace = out;
                if (toWrite < out.length) {
                    replace = new org.eclipse.jdt.internal.compiler.ast.Annotation[toWrite];
                    int idx2 = 0;
                    for (int i2 = 0; i2 < out.length; i2++) {
                        if (out[i2] != null) {
                            int i3 = idx2;
                            idx2++;
                            replace[i3] = out[i2];
                        }
                    }
                }
                return replace;
            } catch (Exception unused) {
                return out;
            }
        }

        public static String getRealNodeSource(String original, org.eclipse.jdt.internal.compiler.ast.ASTNode node) {
            return !isGenerated(node) ? original : node.toString();
        }

        public static String getRealNodeSource(String original, ASTNode node) throws Exception {
            return !isGenerated(node) ? original : node.toString();
        }

        public static boolean skipRewriteVisibility(MemberVisibilityAdjustor.IncomingMemberVisibilityAdjustment adjustment) {
            return isGenerated(adjustment.getMember());
        }
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:Class50/lombok/launch/PatchFixesHider$Tests.SCL.lombok */
    public static class Tests {
        public static Object getBundle(Object original, Class<?> c) {
            if (original != null) {
                return original;
            }
            CodeSource codeSource = c.getProtectionDomain().getCodeSource();
            if (codeSource == null) {
                return null;
            }
            String jar = codeSource.getLocation().getFile();
            String bundleName = jar.substring(jar.lastIndexOf(WatchConstant.FAT_FS_ROOT) + 1, jar.indexOf("_"));
            Bundle[] bundles = EclipseStarter.getSystemBundleContext().getBundles();
            for (Bundle bundle : bundles) {
                if (bundleName.equals(bundle.getSymbolicName())) {
                    return bundle;
                }
            }
            return null;
        }
    }
}
