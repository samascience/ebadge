package lombok.eclipse.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.experimental.StandardException;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.ConditionalExpression;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleMemberAnnotation;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/eclipse/handlers/HandleStandardException.SCL.lombok */
public class HandleStandardException extends EclipseAnnotationHandler<StandardException> {
    private static final char[][] JAVA_BEANS_CONSTRUCTORPROPERTIES = {"java".toCharArray(), "beans".toCharArray(), "ConstructorProperties".toCharArray()};
    private static final char[] MESSAGE = "message".toCharArray();
    private static final char[] CAUSE = "cause".toCharArray();
    private static final char[] GET_MESSAGE = "getMessage".toCharArray();
    private static final char[] INIT_CAUSE = "initCause".toCharArray();

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<StandardException> annotation, Annotation ast, EclipseNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.STANDARD_EXCEPTION_FLAG_USAGE, "@StandardException");
        EclipseNode typeNode = annotationNode.up();
        if (!EclipseHandlerUtil.isClass(typeNode)) {
            annotationNode.addError("@StandardException is only supported on a class");
            return;
        }
        TypeDeclaration classDef = typeNode.get();
        if (classDef.superclass == null) {
            annotationNode.addError("@StandardException requires that you extend a Throwable type");
            return;
        }
        AccessLevel access = annotation.getInstance().access();
        generateNoArgsConstructor(typeNode, access, annotationNode);
        generateMsgOnlyConstructor(typeNode, access, annotationNode);
        generateCauseOnlyConstructor(typeNode, access, annotationNode);
        generateFullConstructor(typeNode, access, annotationNode);
    }

    private void generateNoArgsConstructor(EclipseNode typeNode, AccessLevel level, EclipseNode source) {
        if (hasConstructor(typeNode, new Class[0]) != EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) {
            return;
        }
        int pS = source.get().sourceStart;
        int pE = source.get().sourceEnd;
        ExplicitConstructorCall explicitCall = new ExplicitConstructorCall(3);
        explicitCall.arguments = new Expression[]{new NullLiteral(pS, pE), new NullLiteral(pS, pE)};
        ConstructorDeclaration constructor = createConstructor(level, typeNode, false, false, source, explicitCall, null);
        EclipseHandlerUtil.injectMethod(typeNode, constructor);
    }

    private void generateMsgOnlyConstructor(EclipseNode typeNode, AccessLevel level, EclipseNode source) {
        if (hasConstructor(typeNode, String.class) != EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) {
            return;
        }
        int pS = source.get().sourceStart;
        int pE = source.get().sourceEnd;
        long p = (((long) pS) << 32) | ((long) pE);
        ExplicitConstructorCall explicitCall = new ExplicitConstructorCall(3);
        explicitCall.arguments = new Expression[]{new SingleNameReference(MESSAGE, p), new NullLiteral(pS, pE)};
        ConstructorDeclaration constructor = createConstructor(level, typeNode, true, false, source, explicitCall, null);
        EclipseHandlerUtil.injectMethod(typeNode, constructor);
    }

    private void generateCauseOnlyConstructor(EclipseNode typeNode, AccessLevel level, EclipseNode source) {
        if (hasConstructor(typeNode, Throwable.class) != EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) {
            return;
        }
        int pS = source.get().sourceStart;
        int pE = source.get().sourceEnd;
        long p = (((long) pS) << 32) | ((long) pE);
        ExplicitConstructorCall explicitCall = new ExplicitConstructorCall(3);
        EqualExpression equalExpression = new EqualExpression(new SingleNameReference(CAUSE, p), new NullLiteral(pS, pE), 29);
        MessageSend causeDotGetMessage = new MessageSend();
        causeDotGetMessage.sourceStart = pS;
        causeDotGetMessage.sourceEnd = pE;
        causeDotGetMessage.receiver = new SingleNameReference(CAUSE, p);
        causeDotGetMessage.selector = GET_MESSAGE;
        Expression messageExpr = new ConditionalExpression(equalExpression, causeDotGetMessage, new NullLiteral(pS, pE));
        explicitCall.arguments = new Expression[]{messageExpr, new SingleNameReference(CAUSE, p)};
        ConstructorDeclaration constructor = createConstructor(level, typeNode, false, true, source, explicitCall, null);
        EclipseHandlerUtil.injectMethod(typeNode, constructor);
    }

    private void generateFullConstructor(EclipseNode typeNode, AccessLevel level, EclipseNode source) {
        if (hasConstructor(typeNode, String.class, Throwable.class) != EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) {
            return;
        }
        int pS = source.get().sourceStart;
        int pE = source.get().sourceEnd;
        long p = (((long) pS) << 32) | ((long) pE);
        ExplicitConstructorCall explicitCall = new ExplicitConstructorCall(2);
        explicitCall.arguments = new Expression[]{new SingleNameReference(MESSAGE, p)};
        EqualExpression equalExpression = new EqualExpression(new SingleNameReference(CAUSE, p), new NullLiteral(pS, pE), 29);
        MessageSend causeDotInitCause = new MessageSend();
        causeDotInitCause.sourceStart = pS;
        causeDotInitCause.sourceEnd = pE;
        causeDotInitCause.receiver = new SuperReference(pS, pE);
        causeDotInitCause.selector = INIT_CAUSE;
        causeDotInitCause.arguments = new Expression[]{new SingleNameReference(CAUSE, p)};
        IfStatement ifs = new IfStatement(equalExpression, causeDotInitCause, pS, pE);
        ConstructorDeclaration constructor = createConstructor(level, typeNode, true, true, source, explicitCall, ifs);
        EclipseHandlerUtil.injectMethod(typeNode, constructor);
    }

    public static EclipseHandlerUtil.MemberExistsResult hasConstructor(EclipseNode node, Class<?>... clsArr) {
        EclipseNode node2 = EclipseHandlerUtil.upToTypeNode(node);
        if (node2 != null && (node2.get() instanceof TypeDeclaration)) {
            TypeDeclaration typeDecl = node2.get();
            if (typeDecl.methods != null) {
                for (AbstractMethodDeclaration def : typeDecl.methods) {
                    if ((def instanceof ConstructorDeclaration) && (def.bits & 128) == 0 && paramsMatch(node2, def.arguments, clsArr)) {
                        return EclipseHandlerUtil.getGeneratedBy(def) == null ? EclipseHandlerUtil.MemberExistsResult.EXISTS_BY_USER : EclipseHandlerUtil.MemberExistsResult.EXISTS_BY_LOMBOK;
                    }
                }
            }
        }
        return EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS;
    }

    private static boolean paramsMatch(EclipseNode node, Argument[] a, Class<?>[] clsArr) {
        if (a == null) {
            return clsArr == null || clsArr.length == 0;
        }
        if (clsArr == null) {
            return a.length == 0;
        }
        if (a.length != clsArr.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (!EclipseHandlerUtil.typeMatches(clsArr[i], node, a[i].type)) {
                return false;
            }
        }
        return true;
    }

    public static Annotation[] createConstructorProperties(ASTNode source, boolean msgParam, boolean causeParam) {
        if (!msgParam && !causeParam) {
            return null;
        }
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (((long) pS) << 32) | ((long) pE);
        long[] poss = new long[3];
        Arrays.fill(poss, p);
        QualifiedTypeReference constructorPropertiesType = new QualifiedTypeReference(JAVA_BEANS_CONSTRUCTORPROPERTIES, poss);
        EclipseHandlerUtil.setGeneratedBy(constructorPropertiesType, source);
        Annotation singleMemberAnnotation = new SingleMemberAnnotation(constructorPropertiesType, pS);
        ((SingleMemberAnnotation) singleMemberAnnotation).declarationSourceEnd = pE;
        ArrayInitializer fieldNames = new ArrayInitializer();
        fieldNames.sourceStart = pS;
        fieldNames.sourceEnd = pE;
        fieldNames.expressions = new Expression[(msgParam && causeParam) ? 2 : 1];
        int ctr = 0;
        if (msgParam) {
            fieldNames.expressions[0] = new StringLiteral(MESSAGE, pS, pE, 0);
            EclipseHandlerUtil.setGeneratedBy(fieldNames.expressions[0], source);
            ctr = 0 + 1;
        }
        if (causeParam) {
            fieldNames.expressions[ctr] = new StringLiteral(CAUSE, pS, pE, 0);
            EclipseHandlerUtil.setGeneratedBy(fieldNames.expressions[ctr], source);
            int i = ctr + 1;
        }
        ((SingleMemberAnnotation) singleMemberAnnotation).memberValue = fieldNames;
        EclipseHandlerUtil.setGeneratedBy(singleMemberAnnotation, source);
        EclipseHandlerUtil.setGeneratedBy(((SingleMemberAnnotation) singleMemberAnnotation).memberValue, source);
        return new Annotation[]{singleMemberAnnotation};
    }

    public static ConstructorDeclaration createConstructor(AccessLevel level, EclipseNode typeNode, boolean msgParam, boolean causeParam, EclipseNode sourceNode, ExplicitConstructorCall explicitCall, Statement extra) {
        boolean addConstructorProperties;
        ASTNode source = sourceNode.get();
        TypeDeclaration typeDeclaration = typeNode.get();
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (((long) pS) << 32) | ((long) pE);
        if ((!msgParam && !causeParam) || isLocalType(typeNode)) {
            addConstructorProperties = false;
        } else {
            Boolean v = (Boolean) typeNode.getAst().readConfiguration(ConfigurationKeys.ANY_CONSTRUCTOR_ADD_CONSTRUCTOR_PROPERTIES);
            addConstructorProperties = v != null ? v.booleanValue() : Boolean.FALSE.equals(typeNode.getAst().readConfiguration(ConfigurationKeys.ANY_CONSTRUCTOR_SUPPRESS_CONSTRUCTOR_PROPERTIES));
        }
        ConstructorDeclaration constructor = new ConstructorDeclaration(typeNode.top().get().compilationResult);
        constructor.modifiers = EclipseHandlerUtil.toEclipseModifier(level);
        constructor.selector = typeDeclaration.name;
        constructor.thrownExceptions = null;
        constructor.typeParameters = null;
        constructor.bits |= 8388608;
        constructor.sourceStart = pS;
        constructor.declarationSourceStart = pS;
        constructor.bodyStart = pS;
        constructor.sourceEnd = pE;
        constructor.declarationSourceEnd = pE;
        constructor.bodyEnd = pE;
        constructor.arguments = null;
        List<Argument> params = new ArrayList<>();
        if (msgParam) {
            Argument parameter = new Argument(MESSAGE, p, new QualifiedTypeReference(TypeConstants.JAVA_LANG_STRING, new long[]{p, p, p}), 16);
            params.add(parameter);
        }
        if (causeParam) {
            Argument parameter2 = new Argument(CAUSE, p, new QualifiedTypeReference(TypeConstants.JAVA_LANG_THROWABLE, new long[]{p, p, p}), 16);
            params.add(parameter2);
        }
        explicitCall.sourceStart = pS;
        explicitCall.sourceEnd = pE;
        constructor.constructorCall = explicitCall;
        constructor.statements = extra != null ? new Statement[]{extra} : null;
        constructor.arguments = params.isEmpty() ? null : (Argument[]) params.toArray(new Argument[0]);
        Annotation[] constructorProperties = null;
        if (addConstructorProperties) {
            constructorProperties = createConstructorProperties(source, msgParam, causeParam);
        }
        constructor.annotations = EclipseHandlerUtil.copyAnnotations(source, constructorProperties);
        constructor.traverse(new SetGeneratedByVisitor(source), typeDeclaration.scope);
        return constructor;
    }

    public static boolean isLocalType(EclipseNode type) {
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
