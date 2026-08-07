package lombok.eclipse.handlers;

import lombok.ConfigurationKeys;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.experimental.UtilityClass;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Clinit;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/eclipse/handlers/HandleUtilityClass.SCL.lombok */
@HandlerPriority(-4096)
public class HandleUtilityClass extends EclipseAnnotationHandler<UtilityClass> {
    private static final char[][] JAVA_LANG_UNSUPPORTED_OPERATION_EXCEPTION = {TypeConstants.JAVA, TypeConstants.LANG, "UnsupportedOperationException".toCharArray()};
    private static final char[] UNSUPPORTED_MESSAGE = "This is a utility class and cannot be instantiated".toCharArray();
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind() {
        int[] iArr = $SWITCH_TABLE$lombok$core$AST$Kind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AST.Kind.valuesCustom().length];
        try {
            iArr2[AST.Kind.ANNOTATION.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[AST.Kind.ARGUMENT.ordinal()] = 7;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[AST.Kind.COMPILATION_UNIT.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[AST.Kind.FIELD.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[AST.Kind.INITIALIZER.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[AST.Kind.LOCAL.ordinal()] = 8;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[AST.Kind.METHOD.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[AST.Kind.STATEMENT.ordinal()] = 9;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[AST.Kind.TYPE.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[AST.Kind.TYPE_USE.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        $SWITCH_TABLE$lombok$core$AST$Kind = iArr2;
        return iArr2;
    }

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<UtilityClass> annotation, Annotation ast, EclipseNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.UTILITY_CLASS_FLAG_USAGE, "@UtilityClass");
        EclipseNode typeNode = annotationNode.up();
        if (checkLegality(typeNode, annotationNode)) {
            changeModifiersAndGenerateConstructor(annotationNode.up(), annotationNode);
        }
    }

    /* JADX WARN: Switch 'out' block B:7:0x0011 for B:8:0x0024 already processed. Defaulting to fallback option. */
    private static boolean checkLegality(EclipseNode typeNode, EclipseNode errorNode) {
        if (!EclipseHandlerUtil.isClass(typeNode)) {
            errorNode.addError("@UtilityClass is only supported on a class.");
            return false;
        }
        EclipseNode typeWalk = typeNode;
        do {
            typeWalk = typeWalk.up();
            switch ($SWITCH_TABLE$lombok$core$AST$Kind()[typeWalk.getKind().ordinal()]) {
                case 1:
                    return true;
                case 2:
                    break;
                default:
                    errorNode.addError("@UtilityClass cannot be placed on a method local or anonymous inner class, or any class nested in such a class.");
                    return false;
            }
        } while ((typeWalk.get().modifiers & 25096) != 0);
        if (typeWalk.up().getKind() == AST.Kind.COMPILATION_UNIT) {
            return true;
        }
        errorNode.addError("@UtilityClass automatically makes the class static, however, this class cannot be made static.");
        return false;
    }

    private void changeModifiersAndGenerateConstructor(EclipseNode typeNode, EclipseNode annotationNode) {
        TypeDeclaration classDecl = typeNode.get();
        boolean makeConstructor = true;
        classDecl.modifiers |= 16;
        boolean requiresClInit = false;
        boolean alreadyHasClinit = false;
        boolean markStatic = typeNode.up().getKind() != AST.Kind.COMPILATION_UNIT;
        if (markStatic && typeNode.up().getKind() == AST.Kind.TYPE) {
            TypeDeclaration typeDecl = typeNode.up().get();
            if ((typeDecl.modifiers & 8704) != 0) {
                markStatic = false;
            }
        }
        if (markStatic) {
            classDecl.modifiers |= 8;
        }
        for (EclipseNode element : typeNode.down()) {
            if (element.getKind() == AST.Kind.FIELD) {
                FieldDeclaration fieldDecl = element.get();
                if ((fieldDecl.modifiers & 8) == 0) {
                    requiresClInit = true;
                    fieldDecl.modifiers |= 8;
                }
            } else if (element.getKind() == AST.Kind.METHOD) {
                AbstractMethodDeclaration amd = element.get();
                if (amd instanceof ConstructorDeclaration) {
                    ConstructorDeclaration constrDecl = element.get();
                    if (EclipseHandlerUtil.getGeneratedBy(constrDecl) == null && (constrDecl.bits & 128) == 0) {
                        element.addError("@UtilityClasses cannot have declared constructors.");
                        makeConstructor = false;
                    }
                } else if (amd instanceof MethodDeclaration) {
                    amd.modifiers |= 8;
                } else if (amd instanceof Clinit) {
                    alreadyHasClinit = true;
                }
            } else if (element.getKind() == AST.Kind.TYPE) {
                element.get().modifiers |= 8;
            }
        }
        if (makeConstructor) {
            createPrivateDefaultConstructor(typeNode, annotationNode);
        }
        if (!requiresClInit || alreadyHasClinit) {
            return;
        }
        classDecl.addClinit();
    }

    private void createPrivateDefaultConstructor(EclipseNode typeNode, EclipseNode sourceNode) {
        ASTNode source = sourceNode.get();
        TypeDeclaration typeDeclaration = typeNode.get();
        ConstructorDeclaration constructor = new ConstructorDeclaration(typeNode.top().get().compilationResult);
        constructor.modifiers = 2;
        constructor.selector = typeDeclaration.name;
        constructor.constructorCall = new ExplicitConstructorCall(1);
        constructor.thrownExceptions = null;
        constructor.typeParameters = null;
        constructor.bits |= 8388608;
        constructor.arguments = null;
        long[] ps = new long[JAVA_LANG_UNSUPPORTED_OPERATION_EXCEPTION.length];
        AllocationExpression exception = new AllocationExpression();
        exception.type = new QualifiedTypeReference(JAVA_LANG_UNSUPPORTED_OPERATION_EXCEPTION, ps);
        exception.arguments = new Expression[]{new StringLiteral(UNSUPPORTED_MESSAGE, 0, 0, 0)};
        constructor.statements = new Statement[]{new ThrowStatement(exception, 0, 0)};
        constructor.traverse(new SetGeneratedByVisitor(source), typeDeclaration.scope);
        EclipseHandlerUtil.injectMethod(typeNode, constructor);
    }
}
