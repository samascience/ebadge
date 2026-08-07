package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.lang.annotation.Annotation;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.delombok.LombokOptionsFactory;
import lombok.experimental.StandardException;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/javac/handlers/HandleStandardException.SCL.lombok */
public class HandleStandardException extends JavacAnnotationHandler<StandardException> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<StandardException> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.STANDARD_EXCEPTION_FLAG_USAGE, "@StandardException");
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) StandardException.class);
        JavacHandlerUtil.deleteImportFromCompilationUnit(annotationNode, "lombok.AccessLevel");
        JavacNode typeNode = annotationNode.up();
        if (!JavacHandlerUtil.isClass(typeNode)) {
            annotationNode.addError("@StandardException is only supported on a class");
            return;
        }
        JCTree extending = Javac.getExtendsClause(typeNode.get());
        if (extending == null) {
            annotationNode.addError("@StandardException requires that you extend a Throwable type");
            return;
        }
        AccessLevel access = annotation.getInstance().access();
        if (access == null) {
            access = AccessLevel.PUBLIC;
        }
        if (access == AccessLevel.NONE) {
            annotationNode.addError("AccessLevel.NONE is not valid here");
            access = AccessLevel.PUBLIC;
        }
        generateNoArgsConstructor(typeNode, access, annotationNode);
        generateMsgOnlyConstructor(typeNode, access, annotationNode);
        generateCauseOnlyConstructor(typeNode, access, annotationNode);
        generateFullConstructor(typeNode, access, annotationNode);
    }

    private void generateNoArgsConstructor(JavacNode typeNode, AccessLevel level, JavacNode source) {
        if (hasConstructor(typeNode, new Class[0]) != JavacHandlerUtil.MemberExistsResult.NOT_EXISTS) {
            return;
        }
        JavacTreeMaker maker = typeNode.getTreeMaker();
        List<JCTree.JCExpression> args = List.of(maker.Literal(Javac.CTC_BOT, null), maker.Literal(Javac.CTC_BOT, null));
        JCTree.JCMethodDecl constr = createConstructor(level, typeNode, false, false, source, List.of(maker.Exec(maker.Apply(List.nil(), maker.Ident(typeNode.toName("this")), args))));
        JavacHandlerUtil.injectMethod(typeNode, constr);
    }

    private void generateMsgOnlyConstructor(JavacNode typeNode, AccessLevel level, JavacNode source) {
        if (hasConstructor(typeNode, String.class) != JavacHandlerUtil.MemberExistsResult.NOT_EXISTS) {
            return;
        }
        JavacTreeMaker maker = typeNode.getTreeMaker();
        List<JCTree.JCExpression> args = List.of(maker.Ident(typeNode.toName("message")), maker.Literal(Javac.CTC_BOT, null));
        JCTree.JCMethodDecl constr = createConstructor(level, typeNode, true, false, source, List.of(maker.Exec(maker.Apply(List.nil(), maker.Ident(typeNode.toName("this")), args))));
        JavacHandlerUtil.injectMethod(typeNode, constr);
    }

    private void generateCauseOnlyConstructor(JavacNode typeNode, AccessLevel level, JavacNode source) {
        if (hasConstructor(typeNode, Throwable.class) != JavacHandlerUtil.MemberExistsResult.NOT_EXISTS) {
            return;
        }
        JavacTreeMaker maker = typeNode.getTreeMaker();
        Name causeName = typeNode.toName("cause");
        List<JCTree.JCExpression> args = List.of(maker.Conditional(maker.Binary(Javac.CTC_NOT_EQUAL, maker.Ident(causeName), maker.Literal(Javac.CTC_BOT, null)), maker.Apply(List.nil(), maker.Select(maker.Ident(causeName), typeNode.toName("getMessage")), List.nil()), maker.Literal(Javac.CTC_BOT, null)), maker.Ident(causeName));
        JCTree.JCMethodDecl constr = createConstructor(level, typeNode, false, true, source, List.of(maker.Exec(maker.Apply(List.nil(), maker.Ident(typeNode.toName("this")), args))));
        JavacHandlerUtil.injectMethod(typeNode, constr);
    }

    private void generateFullConstructor(JavacNode typeNode, AccessLevel level, JavacNode source) {
        if (hasConstructor(typeNode, String.class, Throwable.class) != JavacHandlerUtil.MemberExistsResult.NOT_EXISTS) {
            return;
        }
        JavacTreeMaker maker = typeNode.getTreeMaker();
        Name causeName = typeNode.toName("cause");
        Name superName = typeNode.toName("super");
        List<JCTree.JCExpression> args = List.of(maker.Ident(typeNode.toName("message")));
        JCTree.JCMethodDecl constr = createConstructor(level, typeNode, true, true, source, List.of(maker.Exec(maker.Apply(List.nil(), maker.Ident(superName), args)), maker.If(maker.Binary(Javac.CTC_NOT_EQUAL, maker.Ident(causeName), maker.Literal(Javac.CTC_BOT, null)), maker.Exec(maker.Apply(List.nil(), maker.Select(maker.Ident(superName), typeNode.toName("initCause")), List.of(maker.Ident(causeName)))), null)));
        JavacHandlerUtil.injectMethod(typeNode, constr);
    }

    private static JavacHandlerUtil.MemberExistsResult hasConstructor(JavacNode node, Class<?>... clsArr) {
        JavacNode node2 = JavacHandlerUtil.upToTypeNode(node);
        if (node2 != null && (node2.get() instanceof JCTree.JCClassDecl)) {
            for (JCTree.JCMethodDecl jCMethodDecl : node2.get().defs) {
                if (jCMethodDecl instanceof JCTree.JCMethodDecl) {
                    JCTree.JCMethodDecl md = jCMethodDecl;
                    if (md.name.contentEquals("<init>") && (md.mods.flags & 68719476736L) == 0 && paramsMatch(node2, md.params, clsArr)) {
                        return JavacHandlerUtil.getGeneratedBy(jCMethodDecl) == null ? JavacHandlerUtil.MemberExistsResult.EXISTS_BY_USER : JavacHandlerUtil.MemberExistsResult.EXISTS_BY_LOMBOK;
                    }
                }
            }
        }
        return JavacHandlerUtil.MemberExistsResult.NOT_EXISTS;
    }

    private static boolean paramsMatch(JavacNode node, List<JCTree.JCVariableDecl> a, Class<?>[] clsArr) {
        if (a == null) {
            return clsArr == null || clsArr.length == 0;
        }
        if (clsArr == null) {
            return a.size() == 0;
        }
        if (a.size() != clsArr.length) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            JCTree.JCVariableDecl param = (JCTree.JCVariableDecl) a.get(i);
            Class<?> c = clsArr[i];
            if (!JavacHandlerUtil.typeMatches(c, node, (JCTree) param.vartype)) {
                return false;
            }
        }
        return true;
    }

    private static void addConstructorProperties(JCTree.JCModifiers mods, JavacNode node, boolean msgParam, boolean causeParam) {
        if (msgParam || causeParam) {
            JavacTreeMaker maker = node.getTreeMaker();
            JCTree.JCExpression constructorPropertiesType = JavacHandlerUtil.chainDots(node, "java", "beans", "ConstructorProperties");
            ListBuffer<JCTree.JCExpression> fieldNames = new ListBuffer<>();
            if (msgParam) {
                fieldNames.append(maker.Literal("message"));
            }
            if (causeParam) {
                fieldNames.append(maker.Literal("cause"));
            }
            JCTree.JCAnnotation annotation = maker.Annotation(constructorPropertiesType, List.of(maker.NewArray(null, List.nil(), fieldNames.toList())));
            mods.annotations = mods.annotations.append(annotation);
        }
    }

    private static JCTree.JCMethodDecl createConstructor(AccessLevel level, JavacNode typeNode, boolean msgParam, boolean causeParam, JavacNode source, List<JCTree.JCStatement> statements) {
        boolean addConstructorProperties;
        JavacTreeMaker maker = typeNode.getTreeMaker();
        if ((!msgParam && !causeParam) || isLocalType(typeNode) || !LombokOptionsFactory.getDelombokOptions(typeNode.getContext()).getFormatPreferences().generateConstructorProperties()) {
            addConstructorProperties = false;
        } else {
            Boolean v = (Boolean) typeNode.getAst().readConfiguration(ConfigurationKeys.ANY_CONSTRUCTOR_ADD_CONSTRUCTOR_PROPERTIES);
            addConstructorProperties = v != null ? v.booleanValue() : Boolean.FALSE.equals(typeNode.getAst().readConfiguration(ConfigurationKeys.ANY_CONSTRUCTOR_SUPPRESS_CONSTRUCTOR_PROPERTIES));
        }
        ListBuffer<JCTree.JCVariableDecl> params = new ListBuffer<>();
        if (msgParam) {
            Name fieldName = typeNode.toName("message");
            long flags = JavacHandlerUtil.addFinalIfNeeded(8589934592L, typeNode.getContext());
            JCTree.JCExpression pType = JavacHandlerUtil.genJavaLangTypeRef(typeNode, "String");
            JCTree.JCVariableDecl param = maker.VarDef(maker.Modifiers(flags), fieldName, pType, null);
            params.append(param);
        }
        if (causeParam) {
            Name fieldName2 = typeNode.toName("cause");
            long flags2 = JavacHandlerUtil.addFinalIfNeeded(8589934592L, typeNode.getContext());
            JCTree.JCExpression pType2 = JavacHandlerUtil.genJavaLangTypeRef(typeNode, "Throwable");
            JCTree.JCVariableDecl param2 = maker.VarDef(maker.Modifiers(flags2), fieldName2, pType2, null);
            params.append(param2);
        }
        JCTree.JCModifiers mods = maker.Modifiers(JavacHandlerUtil.toJavacModifier(level), List.nil());
        if (addConstructorProperties) {
            addConstructorProperties(mods, typeNode, msgParam, causeParam);
        }
        return JavacHandlerUtil.recursiveSetGeneratedBy(maker.MethodDef(mods, typeNode.toName("<init>"), null, List.nil(), params.toList(), List.nil(), maker.Block(0L, statements), null), source);
    }

    public static boolean isLocalType(JavacNode type) {
        AST.Kind kind = type.up().getKind();
        if (kind == AST.Kind.COMPILATION_UNIT) {
            return false;
        }
        if (kind == AST.Kind.TYPE) {
            return isLocalType(type.up());
        }
        return true;
    }
}
