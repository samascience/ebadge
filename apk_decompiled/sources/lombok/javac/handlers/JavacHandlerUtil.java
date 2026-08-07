package lombok.javac.handlers;

import android.support.v4.media.session.PlaybackStateCompat;
import com.sun.source.tree.Tree;
import com.sun.tools.javac.code.Attribute;
import com.sun.tools.javac.code.BoundKind;
import com.sun.tools.javac.code.Scope;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.comp.Annotate;
import com.sun.tools.javac.comp.AttrContext;
import com.sun.tools.javac.comp.Enter;
import com.sun.tools.javac.comp.Env;
import com.sun.tools.javac.comp.MemberEnter;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeScanner;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import com.sun.tools.javac.util.Options;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.Data;
import lombok.Getter;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.CleanupTask;
import lombok.core.LombokImmutableList;
import lombok.core.TypeResolver;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.configuration.NullAnnotationLibrary;
import lombok.core.configuration.NullCheckExceptionType;
import lombok.core.configuration.TypeName;
import lombok.core.handlers.HandlerUtil;
import lombok.delombok.LombokOptionsFactory;
import lombok.experimental.Accessors;
import lombok.experimental.Tolerate;
import lombok.javac.Javac;
import lombok.javac.JavacAugments;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.permit.Permit;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/javac/handlers/JavacHandlerUtil.SCL.lombok */
public class JavacHandlerUtil {
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$AccessLevel;
    static final /* synthetic */ boolean $assertionsDisabled;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$sun$source$tree$Tree$Kind;

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/javac/handlers/JavacHandlerUtil$MemberExistsResult.SCL.lombok */
    public enum MemberExistsResult {
        NOT_EXISTS,
        EXISTS_BY_LOMBOK,
        EXISTS_BY_USER;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static MemberExistsResult[] valuesCustom() {
            MemberExistsResult[] memberExistsResultArrValuesCustom = values();
            int length = memberExistsResultArrValuesCustom.length;
            MemberExistsResult[] memberExistsResultArr = new MemberExistsResult[length];
            System.arraycopy(memberExistsResultArrValuesCustom, 0, memberExistsResultArr, 0, length);
            return memberExistsResultArr;
        }
    }

    static {
        $assertionsDisabled = !JavacHandlerUtil.class.desiredAssertionStatus();
    }

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

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$AccessLevel() {
        int[] iArr = $SWITCH_TABLE$lombok$AccessLevel;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AccessLevel.valuesCustom().length];
        try {
            iArr2[AccessLevel.MODULE.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[AccessLevel.NONE.ordinal()] = 6;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[AccessLevel.PACKAGE.ordinal()] = 4;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[AccessLevel.PRIVATE.ordinal()] = 5;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[AccessLevel.PROTECTED.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[AccessLevel.PUBLIC.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$lombok$AccessLevel = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$sun$source$tree$Tree$Kind() {
        int[] iArr = $SWITCH_TABLE$com$sun$source$tree$Tree$Kind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Tree.Kind.values().length];
        try {
            iArr2[Tree.Kind.AND.ordinal()] = 64;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Tree.Kind.AND_ASSIGNMENT.ordinal()] = 77;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Tree.Kind.ANNOTATION.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Tree.Kind.ARRAY_ACCESS.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[Tree.Kind.ARRAY_TYPE.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[Tree.Kind.ASSERT.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[Tree.Kind.ASSIGNMENT.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[Tree.Kind.BITWISE_COMPLEMENT.ordinal()] = 48;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[Tree.Kind.BLOCK.ordinal()] = 6;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[Tree.Kind.BOOLEAN_LITERAL.ordinal()] = 84;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[Tree.Kind.BREAK.ordinal()] = 7;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[Tree.Kind.CASE.ordinal()] = 8;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr2[Tree.Kind.CATCH.ordinal()] = 9;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr2[Tree.Kind.CHAR_LITERAL.ordinal()] = 85;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            iArr2[Tree.Kind.CLASS.ordinal()] = 10;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            iArr2[Tree.Kind.COMPILATION_UNIT.ordinal()] = 11;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            iArr2[Tree.Kind.CONDITIONAL_AND.ordinal()] = 67;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            iArr2[Tree.Kind.CONDITIONAL_EXPRESSION.ordinal()] = 12;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            iArr2[Tree.Kind.CONDITIONAL_OR.ordinal()] = 68;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            iArr2[Tree.Kind.CONTINUE.ordinal()] = 13;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            iArr2[Tree.Kind.DIVIDE.ordinal()] = 51;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            iArr2[Tree.Kind.DIVIDE_ASSIGNMENT.ordinal()] = 70;
        } catch (NoSuchFieldError unused22) {
        }
        try {
            iArr2[Tree.Kind.DOUBLE_LITERAL.ordinal()] = 83;
        } catch (NoSuchFieldError unused23) {
        }
        try {
            iArr2[Tree.Kind.DO_WHILE_LOOP.ordinal()] = 14;
        } catch (NoSuchFieldError unused24) {
        }
        try {
            iArr2[Tree.Kind.EMPTY_STATEMENT.ordinal()] = 32;
        } catch (NoSuchFieldError unused25) {
        }
        try {
            iArr2[Tree.Kind.ENHANCED_FOR_LOOP.ordinal()] = 15;
        } catch (NoSuchFieldError unused26) {
        }
        try {
            iArr2[Tree.Kind.EQUAL_TO.ordinal()] = 62;
        } catch (NoSuchFieldError unused27) {
        }
        try {
            iArr2[Tree.Kind.ERRONEOUS.ordinal()] = 91;
        } catch (NoSuchFieldError unused28) {
        }
        try {
            iArr2[Tree.Kind.EXPRESSION_STATEMENT.ordinal()] = 16;
        } catch (NoSuchFieldError unused29) {
        }
        try {
            iArr2[Tree.Kind.EXTENDS_WILDCARD.ordinal()] = 89;
        } catch (NoSuchFieldError unused30) {
        }
        try {
            iArr2[Tree.Kind.FLOAT_LITERAL.ordinal()] = 82;
        } catch (NoSuchFieldError unused31) {
        }
        try {
            iArr2[Tree.Kind.FOR_LOOP.ordinal()] = 18;
        } catch (NoSuchFieldError unused32) {
        }
        try {
            iArr2[Tree.Kind.GREATER_THAN.ordinal()] = 59;
        } catch (NoSuchFieldError unused33) {
        }
        try {
            iArr2[Tree.Kind.GREATER_THAN_EQUAL.ordinal()] = 61;
        } catch (NoSuchFieldError unused34) {
        }
        try {
            iArr2[Tree.Kind.IDENTIFIER.ordinal()] = 19;
        } catch (NoSuchFieldError unused35) {
        }
        try {
            iArr2[Tree.Kind.IF.ordinal()] = 20;
        } catch (NoSuchFieldError unused36) {
        }
        try {
            iArr2[Tree.Kind.IMPORT.ordinal()] = 21;
        } catch (NoSuchFieldError unused37) {
        }
        try {
            iArr2[Tree.Kind.INSTANCE_OF.ordinal()] = 22;
        } catch (NoSuchFieldError unused38) {
        }
        try {
            iArr2[Tree.Kind.INT_LITERAL.ordinal()] = 80;
        } catch (NoSuchFieldError unused39) {
        }
        try {
            iArr2[Tree.Kind.LABELED_STATEMENT.ordinal()] = 23;
        } catch (NoSuchFieldError unused40) {
        }
        try {
            iArr2[Tree.Kind.LEFT_SHIFT.ordinal()] = 55;
        } catch (NoSuchFieldError unused41) {
        }
        try {
            iArr2[Tree.Kind.LEFT_SHIFT_ASSIGNMENT.ordinal()] = 74;
        } catch (NoSuchFieldError unused42) {
        }
        try {
            iArr2[Tree.Kind.LESS_THAN.ordinal()] = 58;
        } catch (NoSuchFieldError unused43) {
        }
        try {
            iArr2[Tree.Kind.LESS_THAN_EQUAL.ordinal()] = 60;
        } catch (NoSuchFieldError unused44) {
        }
        try {
            iArr2[Tree.Kind.LOGICAL_COMPLEMENT.ordinal()] = 49;
        } catch (NoSuchFieldError unused45) {
        }
        try {
            iArr2[Tree.Kind.LONG_LITERAL.ordinal()] = 81;
        } catch (NoSuchFieldError unused46) {
        }
        try {
            iArr2[Tree.Kind.MEMBER_SELECT.ordinal()] = 17;
        } catch (NoSuchFieldError unused47) {
        }
        try {
            iArr2[Tree.Kind.METHOD.ordinal()] = 24;
        } catch (NoSuchFieldError unused48) {
        }
        try {
            iArr2[Tree.Kind.METHOD_INVOCATION.ordinal()] = 25;
        } catch (NoSuchFieldError unused49) {
        }
        try {
            iArr2[Tree.Kind.MINUS.ordinal()] = 54;
        } catch (NoSuchFieldError unused50) {
        }
        try {
            iArr2[Tree.Kind.MINUS_ASSIGNMENT.ordinal()] = 73;
        } catch (NoSuchFieldError unused51) {
        }
        try {
            iArr2[Tree.Kind.MODIFIERS.ordinal()] = 26;
        } catch (NoSuchFieldError unused52) {
        }
        try {
            iArr2[Tree.Kind.MULTIPLY.ordinal()] = 50;
        } catch (NoSuchFieldError unused53) {
        }
        try {
            iArr2[Tree.Kind.MULTIPLY_ASSIGNMENT.ordinal()] = 69;
        } catch (NoSuchFieldError unused54) {
        }
        try {
            iArr2[Tree.Kind.NEW_ARRAY.ordinal()] = 27;
        } catch (NoSuchFieldError unused55) {
        }
        try {
            iArr2[Tree.Kind.NEW_CLASS.ordinal()] = 28;
        } catch (NoSuchFieldError unused56) {
        }
        try {
            iArr2[Tree.Kind.NOT_EQUAL_TO.ordinal()] = 63;
        } catch (NoSuchFieldError unused57) {
        }
        try {
            iArr2[Tree.Kind.NULL_LITERAL.ordinal()] = 87;
        } catch (NoSuchFieldError unused58) {
        }
        try {
            iArr2[Tree.Kind.OR.ordinal()] = 66;
        } catch (NoSuchFieldError unused59) {
        }
        try {
            iArr2[Tree.Kind.OR_ASSIGNMENT.ordinal()] = 79;
        } catch (NoSuchFieldError unused60) {
        }
        try {
            iArr2[Tree.Kind.OTHER.ordinal()] = 92;
        } catch (NoSuchFieldError unused61) {
        }
        try {
            iArr2[Tree.Kind.PARAMETERIZED_TYPE.ordinal()] = 37;
        } catch (NoSuchFieldError unused62) {
        }
        try {
            iArr2[Tree.Kind.PARENTHESIZED.ordinal()] = 29;
        } catch (NoSuchFieldError unused63) {
        }
        try {
            iArr2[Tree.Kind.PLUS.ordinal()] = 53;
        } catch (NoSuchFieldError unused64) {
        }
        try {
            iArr2[Tree.Kind.PLUS_ASSIGNMENT.ordinal()] = 72;
        } catch (NoSuchFieldError unused65) {
        }
        try {
            iArr2[Tree.Kind.POSTFIX_DECREMENT.ordinal()] = 43;
        } catch (NoSuchFieldError unused66) {
        }
        try {
            iArr2[Tree.Kind.POSTFIX_INCREMENT.ordinal()] = 42;
        } catch (NoSuchFieldError unused67) {
        }
        try {
            iArr2[Tree.Kind.PREFIX_DECREMENT.ordinal()] = 45;
        } catch (NoSuchFieldError unused68) {
        }
        try {
            iArr2[Tree.Kind.PREFIX_INCREMENT.ordinal()] = 44;
        } catch (NoSuchFieldError unused69) {
        }
        try {
            iArr2[Tree.Kind.PRIMITIVE_TYPE.ordinal()] = 30;
        } catch (NoSuchFieldError unused70) {
        }
        try {
            iArr2[Tree.Kind.REMAINDER.ordinal()] = 52;
        } catch (NoSuchFieldError unused71) {
        }
        try {
            iArr2[Tree.Kind.REMAINDER_ASSIGNMENT.ordinal()] = 71;
        } catch (NoSuchFieldError unused72) {
        }
        try {
            iArr2[Tree.Kind.RETURN.ordinal()] = 31;
        } catch (NoSuchFieldError unused73) {
        }
        try {
            iArr2[Tree.Kind.RIGHT_SHIFT.ordinal()] = 56;
        } catch (NoSuchFieldError unused74) {
        }
        try {
            iArr2[Tree.Kind.RIGHT_SHIFT_ASSIGNMENT.ordinal()] = 75;
        } catch (NoSuchFieldError unused75) {
        }
        try {
            iArr2[Tree.Kind.STRING_LITERAL.ordinal()] = 86;
        } catch (NoSuchFieldError unused76) {
        }
        try {
            iArr2[Tree.Kind.SUPER_WILDCARD.ordinal()] = 90;
        } catch (NoSuchFieldError unused77) {
        }
        try {
            iArr2[Tree.Kind.SWITCH.ordinal()] = 33;
        } catch (NoSuchFieldError unused78) {
        }
        try {
            iArr2[Tree.Kind.SYNCHRONIZED.ordinal()] = 34;
        } catch (NoSuchFieldError unused79) {
        }
        try {
            iArr2[Tree.Kind.THROW.ordinal()] = 35;
        } catch (NoSuchFieldError unused80) {
        }
        try {
            iArr2[Tree.Kind.TRY.ordinal()] = 36;
        } catch (NoSuchFieldError unused81) {
        }
        try {
            iArr2[Tree.Kind.TYPE_CAST.ordinal()] = 38;
        } catch (NoSuchFieldError unused82) {
        }
        try {
            iArr2[Tree.Kind.TYPE_PARAMETER.ordinal()] = 39;
        } catch (NoSuchFieldError unused83) {
        }
        try {
            iArr2[Tree.Kind.UNARY_MINUS.ordinal()] = 47;
        } catch (NoSuchFieldError unused84) {
        }
        try {
            iArr2[Tree.Kind.UNARY_PLUS.ordinal()] = 46;
        } catch (NoSuchFieldError unused85) {
        }
        try {
            iArr2[Tree.Kind.UNBOUNDED_WILDCARD.ordinal()] = 88;
        } catch (NoSuchFieldError unused86) {
        }
        try {
            iArr2[Tree.Kind.UNSIGNED_RIGHT_SHIFT.ordinal()] = 57;
        } catch (NoSuchFieldError unused87) {
        }
        try {
            iArr2[Tree.Kind.UNSIGNED_RIGHT_SHIFT_ASSIGNMENT.ordinal()] = 76;
        } catch (NoSuchFieldError unused88) {
        }
        try {
            iArr2[Tree.Kind.VARIABLE.ordinal()] = 40;
        } catch (NoSuchFieldError unused89) {
        }
        try {
            iArr2[Tree.Kind.WHILE_LOOP.ordinal()] = 41;
        } catch (NoSuchFieldError unused90) {
        }
        try {
            iArr2[Tree.Kind.XOR.ordinal()] = 65;
        } catch (NoSuchFieldError unused91) {
        }
        try {
            iArr2[Tree.Kind.XOR_ASSIGNMENT.ordinal()] = 78;
        } catch (NoSuchFieldError unused92) {
        }
        $SWITCH_TABLE$com$sun$source$tree$Tree$Kind = iArr2;
        return iArr2;
    }

    private JavacHandlerUtil() {
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/javac/handlers/JavacHandlerUtil$MarkingScanner.SCL.lombok */
    private static class MarkingScanner extends TreeScanner {
        private final JavacNode source;

        MarkingScanner(JavacNode source) {
            this.source = source;
        }

        public void scan(JCTree tree) {
            if (tree == null) {
                return;
            }
            JavacHandlerUtil.setGeneratedBy(tree, this.source);
            super.scan(tree);
        }
    }

    public static boolean inNetbeansEditor(JavacNode node) {
        return inNetbeansEditor(node.getContext());
    }

    public static boolean inNetbeansEditor(Context context) {
        Options options = Options.instance(context);
        return options.keySet().contains("ide") && !options.keySet().contains("backgroundCompilation");
    }

    public static boolean inNetbeansCompileOnSave(Context context) {
        Options options = Options.instance(context);
        return options.keySet().contains("ide") && options.keySet().contains("backgroundCompilation");
    }

    public static JCTree getGeneratedBy(JCTree node) {
        return JavacAugments.JCTree_generatedNode.get(node);
    }

    public static boolean isGenerated(JCTree node) {
        return getGeneratedBy(node) != null;
    }

    public static <T extends JCTree> T recursiveSetGeneratedBy(T node, JavacNode source) {
        if (node == null) {
            return null;
        }
        setGeneratedBy(node, source);
        node.accept(new MarkingScanner(source));
        return node;
    }

    public static <T extends JCTree> T setGeneratedBy(T node, JavacNode sourceNode) {
        if (node == null) {
            return null;
        }
        if (sourceNode == null) {
            JavacAugments.JCTree_generatedNode.clear(node);
            return node;
        }
        JavacAugments.JCTree_generatedNode.set(node, sourceNode.get());
        if (!inNetbeansEditor(sourceNode.getContext()) || isParameter(node)) {
            ((JCTree) node).pos = sourceNode.getStartPos();
            Javac.storeEnd(node, sourceNode.getEndPosition(), sourceNode.top().get());
        }
        return node;
    }

    public static boolean isParameter(JCTree node) {
        return (node instanceof JCTree.JCVariableDecl) && (((JCTree.JCVariableDecl) node).mods.flags & 8589934592L) != 0;
    }

    public static boolean hasAnnotation(String type, JavacNode node) {
        return hasAnnotation(type, node, false);
    }

    public static boolean hasAnnotation(Class<? extends Annotation> type, JavacNode node) {
        return hasAnnotation(type, node, false);
    }

    public static boolean hasAnnotationAndDeleteIfNeccessary(Class<? extends Annotation> type, JavacNode node) {
        return hasAnnotation(type, node, true);
    }

    private static boolean hasAnnotation(Class<? extends Annotation> type, JavacNode node, boolean delete) {
        if (node == null || type == null) {
            return false;
        }
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
                for (JavacNode child : node.down()) {
                    if (annotationTypeMatches(type, child)) {
                        if (delete) {
                            deleteAnnotationIfNeccessary(child, type);
                            return true;
                        }
                        return true;
                    }
                }
                return false;
            case 4:
            case 6:
            default:
                return false;
        }
    }

    private static boolean hasAnnotation(String type, JavacNode node, boolean delete) {
        if (node == null || type == null) {
            return false;
        }
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
                for (JavacNode child : node.down()) {
                    if (annotationTypeMatches(type, child)) {
                        if (delete) {
                            deleteAnnotationIfNeccessary(child, type);
                            return true;
                        }
                        return true;
                    }
                }
                return false;
            case 4:
            case 6:
            default:
                return false;
        }
    }

    public static JavacNode findInnerClass(JavacNode parent, String name) {
        for (JavacNode child : parent.down()) {
            if (child.getKind() == AST.Kind.TYPE) {
                JCTree.JCClassDecl td = child.get();
                if (td.name.contentEquals(name)) {
                    return child;
                }
            }
        }
        return null;
    }

    public static JavacNode findAnnotation(Class<? extends Annotation> type, JavacNode node) {
        return findAnnotation(type, node, false);
    }

    public static JavacNode findAnnotation(Class<? extends Annotation> type, JavacNode node, boolean delete) {
        if (node == null || type == null) {
            return null;
        }
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
                for (JavacNode child : node.down()) {
                    if (annotationTypeMatches(type, child)) {
                        if (delete) {
                            deleteAnnotationIfNeccessary(child, type);
                        }
                        return child;
                    }
                }
                return null;
            case 4:
            case 6:
            default:
                return null;
        }
    }

    public static boolean annotationTypeMatches(Class<? extends Annotation> type, JavacNode node) {
        if (node.getKind() != AST.Kind.ANNOTATION) {
            return false;
        }
        return typeMatches(type, node, node.get().annotationType);
    }

    public static boolean annotationTypeMatches(String type, JavacNode node) {
        if (node.getKind() != AST.Kind.ANNOTATION) {
            return false;
        }
        return typeMatches(type, node, node.get().annotationType);
    }

    public static boolean typeMatches(Class<?> type, JavacNode node, JCTree typeNode) {
        return typeMatches(type.getName(), node, typeNode);
    }

    public static boolean typeMatches(String type, JavacNode node, JCTree typeNode) {
        String typeName = typeNode == null ? null : typeNode.toString();
        if (typeName == null || typeName.length() == 0) {
            return false;
        }
        int lastIndexA = typeName.lastIndexOf(46) + 1;
        int lastIndexB = Math.max(type.lastIndexOf(46), type.lastIndexOf(36)) + 1;
        int len = typeName.length() - lastIndexA;
        if (len != type.length() - lastIndexB) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (typeName.charAt(i + lastIndexA) != type.charAt(i + lastIndexB)) {
                return false;
            }
        }
        TypeResolver resolver = node.getImportListAsTypeResolver();
        return resolver.typeMatches(node, type, typeName);
    }

    public static boolean isFieldDeprecated(JavacNode field) {
        if (!(field.get() instanceof JCTree.JCVariableDecl)) {
            return false;
        }
        JCTree.JCVariableDecl fieldNode = field.get();
        if ((fieldNode.mods.flags & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) != 0) {
            return true;
        }
        for (JavacNode child : field.down()) {
            if (annotationTypeMatches((Class<? extends Annotation>) Deprecated.class, child)) {
                return true;
            }
        }
        return false;
    }

    public static CheckerFrameworkVersion getCheckerFrameworkVersion(JavacNode node) {
        CheckerFrameworkVersion cfv = (CheckerFrameworkVersion) node.getAst().readConfiguration(ConfigurationKeys.CHECKER_FRAMEWORK);
        return cfv == null ? CheckerFrameworkVersion.NONE : cfv;
    }

    public static boolean nodeHasDeprecatedFlag(JCTree node) {
        if (node instanceof JCTree.JCVariableDecl) {
            return (((JCTree.JCVariableDecl) node).mods.flags & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) != 0;
        }
        if (node instanceof JCTree.JCMethodDecl) {
            return (((JCTree.JCMethodDecl) node).mods.flags & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) != 0;
        }
        return (node instanceof JCTree.JCClassDecl) && (((JCTree.JCClassDecl) node).mods.flags & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) != 0;
    }

    public static <A extends Annotation> AnnotationValues<A> createAnnotation(Class<A> type, JavacNode node) {
        return createAnnotation(type, node.get(), node);
    }

    public static <A extends Annotation> AnnotationValues<A> createAnnotation(Class<A> type, JCTree.JCAnnotation anno, final JavacNode node) {
        JCTree.JCExpression rhs;
        String mName;
        Map<String, AnnotationValues.AnnotationValue> values = new HashMap<>();
        List<JCTree.JCExpression> arguments = anno.getArguments();
        for (JCTree.JCExpression arg : arguments) {
            java.util.List<String> raws = new ArrayList<>();
            java.util.List<Object> guesses = new ArrayList<>();
            java.util.List<Object> expressions = new ArrayList<>();
            final java.util.List<JCDiagnostic.DiagnosticPosition> positions = new ArrayList<>();
            if (arg instanceof JCTree.JCAssign) {
                JCTree.JCAssign assign = (JCTree.JCAssign) arg;
                mName = assign.lhs.toString();
                rhs = assign.rhs;
            } else {
                rhs = arg;
                mName = "value";
            }
            if (rhs instanceof JCTree.JCNewArray) {
                List<JCTree.JCExpression> elems = ((JCTree.JCNewArray) rhs).elems;
                Iterator it = elems.iterator();
                while (it.hasNext()) {
                    JCTree.JCAnnotation jCAnnotation = (JCTree.JCExpression) it.next();
                    raws.add(jCAnnotation.toString());
                    expressions.add(jCAnnotation);
                    if (jCAnnotation instanceof JCTree.JCAnnotation) {
                        try {
                            guesses.add(createAnnotation(Class.forName(((JCTree.JCExpression) jCAnnotation).type.toString()), jCAnnotation, node));
                        } catch (ClassNotFoundException unused) {
                            guesses.add(Javac.calculateGuess(jCAnnotation));
                        }
                    } else {
                        guesses.add(Javac.calculateGuess(jCAnnotation));
                    }
                    positions.add(jCAnnotation.pos());
                }
            } else {
                raws.add(rhs.toString());
                expressions.add(rhs);
                if (rhs instanceof JCTree.JCAnnotation) {
                    try {
                        guesses.add(createAnnotation(Class.forName(rhs.type.toString()), (JCTree.JCAnnotation) rhs, node));
                    } catch (ClassNotFoundException unused2) {
                        guesses.add(Javac.calculateGuess(rhs));
                    }
                } else {
                    guesses.add(Javac.calculateGuess(rhs));
                }
                positions.add(rhs.pos());
            }
            values.put(mName, new AnnotationValues.AnnotationValue(node, raws, expressions, guesses, true) { // from class: lombok.javac.handlers.JavacHandlerUtil.1
                @Override // lombok.core.AnnotationValues.AnnotationValue
                public void setError(String message, int valueIdx) {
                    if (valueIdx >= 0) {
                        node.addError(message, (JCDiagnostic.DiagnosticPosition) positions.get(valueIdx));
                    } else {
                        node.addError(message);
                    }
                }

                @Override // lombok.core.AnnotationValues.AnnotationValue
                public void setWarning(String message, int valueIdx) {
                    if (valueIdx >= 0) {
                        node.addWarning(message, (JCDiagnostic.DiagnosticPosition) positions.get(valueIdx));
                    } else {
                        node.addWarning(message);
                    }
                }
            });
        }
        for (Method m : type.getDeclaredMethods()) {
            if (Modifier.isPublic(m.getModifiers())) {
                String name = m.getName();
                if (!values.containsKey(name)) {
                    values.put(name, new AnnotationValues.AnnotationValue(node, new ArrayList(), new ArrayList(), new ArrayList(), false) { // from class: lombok.javac.handlers.JavacHandlerUtil.2
                        @Override // lombok.core.AnnotationValues.AnnotationValue
                        public void setError(String message, int valueIdx) {
                            node.addError(message);
                        }

                        @Override // lombok.core.AnnotationValues.AnnotationValue
                        public void setWarning(String message, int valueIdx) {
                            node.addWarning(message);
                        }
                    });
                }
            }
        }
        return new AnnotationValues<>(type, values, node);
    }

    public static void deleteAnnotationIfNeccessary(JavacNode annotation, String annotationType) {
        deleteAnnotationIfNeccessary0(annotation, annotationType);
    }

    public static void deleteAnnotationIfNeccessary(JavacNode annotation, Class<? extends Annotation> annotationType) {
        deleteAnnotationIfNeccessary0(annotation, annotationType.getName());
    }

    public static void deleteAnnotationIfNeccessary(JavacNode annotation, Class<? extends Annotation> annotationType1, Class<? extends Annotation> annotationType2) {
        deleteAnnotationIfNeccessary0(annotation, annotationType1.getName(), annotationType2.getName());
    }

    public static void deleteAnnotationIfNeccessary(JavacNode annotation, Class<? extends Annotation> annotationType1, String annotationType2) {
        deleteAnnotationIfNeccessary0(annotation, annotationType1.getName(), annotationType2);
    }

    private static void deleteAnnotationIfNeccessary0(JavacNode annotation, String... annotationTypes) {
        if (!inNetbeansEditor(annotation) && annotation.shouldDeleteLombokAnnotations()) {
            JavacNode parentNode = annotation.directUp();
            switch ($SWITCH_TABLE$lombok$core$AST$Kind()[parentNode.getKind().ordinal()]) {
                case 2:
                    try {
                        JCTree.JCClassDecl type = parentNode.get();
                        type.mods.annotations = filterList(type.mods.annotations, annotation.get());
                    } catch (ClassCastException unused) {
                    }
                    break;
                case 3:
                case 7:
                case 8:
                    JCTree.JCVariableDecl variable = parentNode.get();
                    variable.mods.annotations = filterList(variable.mods.annotations, annotation.get());
                    break;
                case 4:
                case 6:
                default:
                    return;
                case 5:
                    JCTree.JCMethodDecl method = parentNode.get();
                    method.mods.annotations = filterList(method.mods.annotations, annotation.get());
                    break;
            }
            parentNode.getAst().setChanged();
            for (String annotationType : annotationTypes) {
                deleteImportFromCompilationUnit(annotation, annotationType);
            }
        }
    }

    public static void deleteImportFromCompilationUnit(JavacNode node, String name) {
        if (!inNetbeansEditor(node) && node.shouldDeleteLombokAnnotations()) {
            JCTree.JCCompilationUnit unit = node.top().get();
            for (JCTree.JCImport jCImport : unit.defs) {
                if (jCImport instanceof JCTree.JCImport) {
                    JCTree.JCImport imp0rt = jCImport;
                    if (!imp0rt.staticImport && imp0rt.qualid.toString().equals(name)) {
                        JavacAugments.JCImport_deletable.set(imp0rt, true);
                    }
                }
            }
        }
    }

    private static List<JCTree.JCAnnotation> filterList(List<JCTree.JCAnnotation> annotations, JCTree jcTree) {
        ListBuffer<JCTree.JCAnnotation> newAnnotations = new ListBuffer<>();
        for (JCTree.JCAnnotation ann : annotations) {
            if (jcTree != ann) {
                newAnnotations.append(ann);
            }
        }
        return newAnnotations.toList();
    }

    public static java.util.List<String> toAllGetterNames(JavacNode field) {
        return HandlerUtil.toAllGetterNames(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static java.util.List<String> toAllGetterNames(JavacNode field, AnnotationValues<Accessors> accessors) {
        return HandlerUtil.toAllGetterNames(field.getAst(), accessors, field.getName(), isBoolean(field));
    }

    public static String toGetterName(JavacNode field) {
        return HandlerUtil.toGetterName(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static String toGetterName(JavacNode field, AnnotationValues<Accessors> accessors) {
        return HandlerUtil.toGetterName(field.getAst(), accessors, field.getName(), isBoolean(field));
    }

    public static java.util.List<String> toAllSetterNames(JavacNode field) {
        return HandlerUtil.toAllSetterNames(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static java.util.List<String> toAllSetterNames(JavacNode field, AnnotationValues<Accessors> accessors) {
        return HandlerUtil.toAllSetterNames(field.getAst(), accessors, field.getName(), isBoolean(field));
    }

    public static String toSetterName(JavacNode field) {
        return HandlerUtil.toSetterName(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static String toSetterName(JavacNode field, AnnotationValues<Accessors> accessors) {
        return HandlerUtil.toSetterName(field.getAst(), accessors, field.getName(), isBoolean(field));
    }

    public static java.util.List<String> toAllWithNames(JavacNode field) {
        return HandlerUtil.toAllWithNames(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static java.util.List<String> toAllWithNames(JavacNode field, AnnotationValues<Accessors> accessors) {
        return HandlerUtil.toAllWithNames(field.getAst(), accessors, field.getName(), isBoolean(field));
    }

    public static java.util.List<String> toAllWithByNames(JavacNode field) {
        return HandlerUtil.toAllWithByNames(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static java.util.List<String> toAllWithByNames(JavacNode field, AnnotationValues<Accessors> accessors) {
        return HandlerUtil.toAllWithByNames(field.getAst(), accessors, field.getName(), isBoolean(field));
    }

    public static String toWithName(JavacNode field) {
        return HandlerUtil.toWithName(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static String toWithName(JavacNode field, AnnotationValues<Accessors> accessors) {
        return HandlerUtil.toWithName(field.getAst(), accessors, field.getName(), isBoolean(field));
    }

    public static String toWithByName(JavacNode field) {
        return HandlerUtil.toWithByName(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean(field));
    }

    public static String toWithByName(JavacNode field, AnnotationValues<Accessors> accessors) {
        return HandlerUtil.toWithByName(field.getAst(), accessors, field.getName(), isBoolean(field));
    }

    public static boolean shouldReturnThis(JavacNode field, AnnotationValues<Accessors> accessors) {
        if ((field.get().mods.flags & 8) != 0) {
            return false;
        }
        return HandlerUtil.shouldReturnThis0(accessors, field.getAst());
    }

    public static boolean shouldMakeFinal(JavacNode field, AnnotationValues<Accessors> accessors) {
        if ((field.get().mods.flags & 8) != 0) {
            return false;
        }
        return HandlerUtil.shouldMakeFinal0(accessors, field.getAst());
    }

    public static JCTree.JCExpression cloneSelfType(JavacNode childOfType) {
        JavacNode typeNode = childOfType;
        JavacTreeMaker maker = childOfType.getTreeMaker();
        while (typeNode != null && typeNode.getKind() != AST.Kind.TYPE) {
            typeNode = typeNode.up();
        }
        return namePlusTypeParamsToTypeReference(maker, typeNode, typeNode.get().typarams);
    }

    public static boolean isBoolean(JavacNode field) {
        JCTree.JCExpression varType = field.get().vartype;
        return isBoolean(varType);
    }

    public static boolean isBoolean(JCTree.JCExpression varType) {
        return varType != null && varType.toString().equals("boolean");
    }

    public static Name removePrefixFromField(JavacNode field) {
        CharSequence newName;
        java.util.List<String> prefixes = null;
        for (JavacNode node : field.down()) {
            if (annotationTypeMatches((Class<? extends Annotation>) Accessors.class, node)) {
                AnnotationValues<Accessors> ann = createAnnotation(Accessors.class, node);
                if (!ann.isExplicit("prefix")) {
                    break;
                }
                prefixes = Arrays.asList(ann.getInstance().prefix());
                break;
            }
        }
        if (prefixes == null) {
            JavacNode javacNodeUp = field.up();
            loop1: while (true) {
                JavacNode current = javacNodeUp;
                if (current == null) {
                    break;
                }
                for (JavacNode node2 : current.down()) {
                    if (annotationTypeMatches((Class<? extends Annotation>) Accessors.class, node2)) {
                        AnnotationValues<Accessors> ann2 = createAnnotation(Accessors.class, node2);
                        if (!ann2.isExplicit("prefix")) {
                            break loop1;
                        }
                        prefixes = Arrays.asList(ann2.getInstance().prefix());
                        break loop1;
                    }
                }
                javacNodeUp = current.up();
            }
        }
        if (prefixes == null) {
            prefixes = (java.util.List) field.getAst().readConfiguration(ConfigurationKeys.ACCESSORS_PREFIX);
        }
        return (prefixes.isEmpty() || (newName = HandlerUtil.removePrefix(field.getName(), prefixes)) == null) ? field.get().name : field.toName(newName.toString());
    }

    public static AnnotationValues<Accessors> getAccessorsForField(JavacNode field) {
        AnnotationValues<Accessors> values = null;
        for (JavacNode node : field.down()) {
            if (annotationTypeMatches((Class<? extends Annotation>) Accessors.class, node)) {
                values = createAnnotation(Accessors.class, node);
                break;
            }
        }
        JavacNode javacNodeUp = field.up();
        while (true) {
            JavacNode current = javacNodeUp;
            if (current == null) {
                break;
            }
            for (JavacNode node2 : current.down()) {
                if (annotationTypeMatches((Class<? extends Annotation>) Accessors.class, node2)) {
                    AnnotationValues<Accessors> onType = createAnnotation(Accessors.class, node2);
                    values = values == null ? onType : values.integrate(onType);
                    break;
                }
            }
            javacNodeUp = current.up();
        }
        return values == null ? AnnotationValues.of(Accessors.class, field) : values;
    }

    public static MemberExistsResult fieldExists(String fieldName, JavacNode node) {
        JavacNode node2 = upToTypeNode(node);
        if (node2 != null && (node2.get() instanceof JCTree.JCClassDecl)) {
            for (JCTree.JCVariableDecl jCVariableDecl : node2.get().defs) {
                if ((jCVariableDecl instanceof JCTree.JCVariableDecl) && jCVariableDecl.name.contentEquals(fieldName)) {
                    return getGeneratedBy(jCVariableDecl) == null ? MemberExistsResult.EXISTS_BY_USER : MemberExistsResult.EXISTS_BY_LOMBOK;
                }
            }
        }
        return MemberExistsResult.NOT_EXISTS;
    }

    public static MemberExistsResult methodExists(String methodName, JavacNode node, int params) {
        return methodExists(methodName, node, true, params);
    }

    public static MemberExistsResult methodExists(String methodName, JavacNode node, boolean caseSensitive, int params) {
        JavacNode node2 = upToTypeNode(node);
        if (node2 != null && (node2.get() instanceof JCTree.JCClassDecl)) {
            for (JCTree.JCMethodDecl jCMethodDecl : node2.get().defs) {
                if (jCMethodDecl instanceof JCTree.JCMethodDecl) {
                    JCTree.JCMethodDecl md = jCMethodDecl;
                    String name = md.name.toString();
                    boolean matches = caseSensitive ? name.equals(methodName) : name.equalsIgnoreCase(methodName);
                    if (matches) {
                        if (params > -1) {
                            List<JCTree.JCVariableDecl> ps = md.params;
                            int minArgs = 0;
                            int maxArgs = 0;
                            if (ps != null && ps.length() > 0) {
                                minArgs = ps.length();
                                if ((((JCTree.JCVariableDecl) ps.last()).mods.flags & 17179869184L) != 0) {
                                    maxArgs = Integer.MAX_VALUE;
                                    minArgs--;
                                } else {
                                    maxArgs = minArgs;
                                }
                            }
                            if (params < minArgs || params > maxArgs) {
                            }
                        }
                        if (!isTolerate(node2, md)) {
                            return getGeneratedBy(jCMethodDecl) == null ? MemberExistsResult.EXISTS_BY_USER : MemberExistsResult.EXISTS_BY_LOMBOK;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return MemberExistsResult.NOT_EXISTS;
    }

    public static boolean isTolerate(JavacNode node, JCTree.JCMethodDecl md) {
        List<JCTree.JCAnnotation> annotations = md.getModifiers().getAnnotations();
        if (annotations != null) {
            for (JCTree.JCAnnotation anno : annotations) {
                if (typeMatches((Class<?>) Tolerate.class, node, anno.getAnnotationType())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static MemberExistsResult constructorExists(JavacNode node) {
        JavacNode node2 = upToTypeNode(node);
        if (node2 != null && (node2.get() instanceof JCTree.JCClassDecl)) {
            for (JCTree.JCMethodDecl jCMethodDecl : node2.get().defs) {
                if (jCMethodDecl instanceof JCTree.JCMethodDecl) {
                    JCTree.JCMethodDecl md = jCMethodDecl;
                    if (md.name.contentEquals("<init>") && (md.mods.flags & 68719476736L) == 0 && !isTolerate(node2, md)) {
                        return getGeneratedBy(jCMethodDecl) == null ? MemberExistsResult.EXISTS_BY_USER : MemberExistsResult.EXISTS_BY_LOMBOK;
                    }
                }
            }
        }
        return MemberExistsResult.NOT_EXISTS;
    }

    public static boolean isConstructorCall(JCTree.JCStatement statement) {
        String name;
        if (!(statement instanceof JCTree.JCExpressionStatement)) {
            return false;
        }
        JCTree.JCMethodInvocation jCMethodInvocation = ((JCTree.JCExpressionStatement) statement).expr;
        if (!(jCMethodInvocation instanceof JCTree.JCMethodInvocation)) {
            return false;
        }
        JCTree.JCFieldAccess jCFieldAccess = jCMethodInvocation.meth;
        if (jCFieldAccess instanceof JCTree.JCFieldAccess) {
            name = jCFieldAccess.name.toString();
        } else if (jCFieldAccess instanceof JCTree.JCIdent) {
            name = ((JCTree.JCIdent) jCFieldAccess).name.toString();
        } else {
            name = Constants.STR_EMPTY;
        }
        return "super".equals(name) || "this".equals(name);
    }

    public static int toJavacModifier(AccessLevel accessLevel) {
        switch ($SWITCH_TABLE$lombok$AccessLevel()[accessLevel.ordinal()]) {
            case 1:
            default:
                return 1;
            case 2:
            case 4:
                return 0;
            case 3:
                return 4;
            case 5:
            case 6:
                return 2;
        }
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/javac/handlers/JavacHandlerUtil$GetterMethod.SCL.lombok */
    private static class GetterMethod {
        private final Name name;
        private final JCTree.JCExpression type;

        GetterMethod(Name name, JCTree.JCExpression type) {
            this.name = name;
            this.type = type;
        }
    }

    private static GetterMethod findGetter(JavacNode field) {
        String getterName;
        JavacNode containingType;
        JCTree.JCVariableDecl decl = field.get();
        JavacNode typeNode = field.up();
        for (String potentialGetterName : toAllGetterNames(field)) {
            for (JavacNode potentialGetter : typeNode.down()) {
                if (potentialGetter.getKind() == AST.Kind.METHOD) {
                    JCTree.JCMethodDecl method = potentialGetter.get();
                    if (method.name.toString().equalsIgnoreCase(potentialGetterName) && (method.mods.flags & 8) == 0 && (method.params == null || method.params.size() <= 0)) {
                        return new GetterMethod(method.name, method.restype);
                    }
                }
            }
        }
        boolean hasGetterAnnotation = false;
        for (JavacNode child : field.down()) {
            if (child.getKind() == AST.Kind.ANNOTATION && annotationTypeMatches((Class<? extends Annotation>) Getter.class, child)) {
                AnnotationValues<Getter> ann = createAnnotation(Getter.class, child);
                if (ann.getInstance().value() == AccessLevel.NONE) {
                    return null;
                }
                hasGetterAnnotation = true;
            }
        }
        if (!hasGetterAnnotation && HandleGetter.fieldQualifiesForGetterGeneration(field) && (containingType = field.up()) != null) {
            for (JavacNode child2 : containingType.down()) {
                if (child2.getKind() == AST.Kind.ANNOTATION && annotationTypeMatches((Class<? extends Annotation>) Data.class, child2)) {
                    hasGetterAnnotation = true;
                }
                if (child2.getKind() == AST.Kind.ANNOTATION && annotationTypeMatches((Class<? extends Annotation>) Getter.class, child2)) {
                    AnnotationValues<Getter> ann2 = createAnnotation(Getter.class, child2);
                    if (ann2.getInstance().value() == AccessLevel.NONE) {
                        return null;
                    }
                    hasGetterAnnotation = true;
                }
            }
        }
        if (!hasGetterAnnotation || (getterName = toGetterName(field)) == null) {
            return null;
        }
        return new GetterMethod(field.toName(getterName), decl.vartype);
    }

    static boolean lookForGetter(JavacNode field, HandlerUtil.FieldAccess fieldAccess) {
        if (fieldAccess == HandlerUtil.FieldAccess.GETTER) {
            return true;
        }
        if (fieldAccess == HandlerUtil.FieldAccess.ALWAYS_FIELD) {
            return false;
        }
        for (JavacNode child : field.down()) {
            if (child.getKind() == AST.Kind.ANNOTATION && annotationTypeMatches((Class<? extends Annotation>) Getter.class, child)) {
                AnnotationValues<Getter> ann = createAnnotation(Getter.class, child);
                if (ann.getInstance().lazy()) {
                    return true;
                }
            }
        }
        return false;
    }

    static JCTree.JCExpression getFieldType(JavacNode field, HandlerUtil.FieldAccess fieldAccess) {
        if (field.getKind() == AST.Kind.METHOD) {
            return field.get().restype;
        }
        boolean lookForGetter = lookForGetter(field, fieldAccess);
        GetterMethod getter = lookForGetter ? findGetter(field) : null;
        if (getter != null) {
            return getter.type;
        }
        return field.get().vartype;
    }

    static JCTree.JCExpression createFieldAccessor(JavacTreeMaker maker, JavacNode field, HandlerUtil.FieldAccess fieldAccess) {
        return createFieldAccessor(maker, field, fieldAccess, null);
    }

    static JCTree.JCExpression createFieldAccessor(JavacTreeMaker maker, JavacNode field, HandlerUtil.FieldAccess fieldAccess, JCTree.JCExpression receiver) {
        boolean lookForGetter = lookForGetter(field, fieldAccess);
        GetterMethod getter = lookForGetter ? findGetter(field) : null;
        JCTree.JCVariableDecl fieldDecl = field.get();
        if (getter == null) {
            if (receiver == null) {
                if ((fieldDecl.mods.flags & 8) == 0) {
                    receiver = maker.Ident(field.toName("this"));
                } else {
                    JavacNode containerNode = field.up();
                    if (containerNode != null && (containerNode.get() instanceof JCTree.JCClassDecl)) {
                        JCTree.JCClassDecl container = field.up().get();
                        receiver = maker.Ident(container.name);
                    }
                }
            }
            return receiver == null ? maker.Ident(fieldDecl.name) : maker.Select(receiver, fieldDecl.name);
        }
        if (receiver == null) {
            receiver = maker.Ident(field.toName("this"));
        }
        JCTree.JCMethodInvocation call = maker.Apply(List.nil(), maker.Select(receiver, getter.name), List.nil());
        return call;
    }

    static JCTree.JCExpression createMethodAccessor(JavacTreeMaker maker, JavacNode method) {
        return createMethodAccessor(maker, method, null);
    }

    static JCTree.JCExpression createMethodAccessor(JavacTreeMaker maker, JavacNode method, JCTree.JCExpression receiver) {
        JavacNode containerNode;
        JCTree.JCMethodDecl methodDecl = method.get();
        if (receiver == null && (methodDecl.mods.flags & 8) == 0) {
            receiver = maker.Ident(method.toName("this"));
        } else if (receiver == null && (containerNode = method.up()) != null && (containerNode.get() instanceof JCTree.JCClassDecl)) {
            JCTree.JCClassDecl container = method.up().get();
            receiver = maker.Ident(container.name);
        }
        JCTree.JCMethodInvocation call = maker.Apply(List.nil(), receiver == null ? maker.Ident(methodDecl.name) : maker.Select(receiver, methodDecl.name), List.nil());
        return call;
    }

    public static JavacNode injectFieldAndMarkGenerated(JavacNode typeNode, JCTree.JCVariableDecl field) {
        return injectField(typeNode, field, true);
    }

    public static JavacNode injectField(JavacNode typeNode, JCTree.JCVariableDecl field) {
        return injectField(typeNode, field, false);
    }

    public static JavacNode injectField(JavacNode typeNode, JCTree.JCVariableDecl field, boolean addGenerated) {
        return injectField(typeNode, field, addGenerated, false);
    }

    public static JavacNode injectField(JavacNode typeNode, JCTree.JCVariableDecl field, boolean addGenerated, boolean specialEnumHandling) {
        List<JCTree> insertBefore;
        JCTree.JCClassDecl type = typeNode.get();
        if (addGenerated) {
            addSuppressWarningsAll(field.mods, typeNode, typeNode.getNodeFor(getGeneratedBy(field)), typeNode.getContext());
            addGenerated(field.mods, typeNode, typeNode.getNodeFor(getGeneratedBy(field)), typeNode.getContext());
        }
        List<JCTree> insertAfter = null;
        List<JCTree> list = type.defs;
        while (true) {
            insertBefore = list;
            boolean skip = false;
            if (insertBefore.head instanceof JCTree.JCVariableDecl) {
                JCTree.JCVariableDecl f = (JCTree.JCVariableDecl) insertBefore.head;
                if ((!specialEnumHandling && isEnumConstant(f)) || isGenerated(f)) {
                    skip = true;
                }
            } else if ((insertBefore.head instanceof JCTree.JCMethodDecl) && (((JCTree.JCMethodDecl) insertBefore.head).mods.flags & 68719476736L) != 0) {
                skip = true;
            }
            if (!skip) {
                break;
            }
            insertAfter = insertBefore;
            list = insertBefore.tail;
        }
        List<JCTree> fieldEntry = List.of(field);
        fieldEntry.tail = insertBefore;
        if (insertAfter == null) {
            type.defs = fieldEntry;
        } else {
            insertAfter.tail = fieldEntry;
        }
        EnterReflect.memberEnter(field, typeNode);
        return typeNode.add(field, AST.Kind.FIELD);
    }

    public static boolean isEnumConstant(JCTree.JCVariableDecl field) {
        return (field.mods.flags & PlaybackStateCompat.ACTION_PREPARE) != 0;
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/javac/handlers/JavacHandlerUtil$JCAnnotatedTypeReflect.SCL.lombok */
    static class JCAnnotatedTypeReflect {
        private static Class<?> TYPE;
        private static Constructor<?> CONSTRUCTOR;
        private static Field ANNOTATIONS;
        private static Field UNDERLYING_TYPE;

        JCAnnotatedTypeReflect() {
        }

        private static void initByLoader(ClassLoader classLoader) {
            if (TYPE != null) {
                return;
            }
            try {
                Class<?> c = classLoader.loadClass("com.sun.tools.javac.tree.JCTree$JCAnnotatedType");
                init(c);
            } catch (Exception unused) {
            }
        }

        private static void init(Class<?> in) {
            if (TYPE == null && in.getName().equals("com.sun.tools.javac.tree.JCTree$JCAnnotatedType")) {
                try {
                    CONSTRUCTOR = Permit.getConstructor(in, List.class, JCTree.JCExpression.class);
                    ANNOTATIONS = Permit.getField(in, "annotations");
                    UNDERLYING_TYPE = Permit.getField(in, "underlyingType");
                    TYPE = in;
                } catch (Exception unused) {
                }
            }
        }

        static boolean is(JCTree obj) {
            if (obj == null) {
                return false;
            }
            init(obj.getClass());
            return obj.getClass() == TYPE;
        }

        static List<JCTree.JCAnnotation> getAnnotations(JCTree obj) {
            init(obj.getClass());
            try {
                return (List) ANNOTATIONS.get(obj);
            } catch (Exception unused) {
                return List.nil();
            }
        }

        static void setAnnotations(JCTree obj, List<JCTree.JCAnnotation> anns) {
            init(obj.getClass());
            try {
                ANNOTATIONS.set(obj, anns);
            } catch (Exception unused) {
            }
        }

        static JCTree.JCExpression getUnderlyingType(JCTree obj) {
            init(obj.getClass());
            try {
                return (JCTree.JCExpression) UNDERLYING_TYPE.get(obj);
            } catch (Exception unused) {
                return null;
            }
        }

        static JCTree.JCExpression create(List<JCTree.JCAnnotation> annotations, JCTree.JCExpression underlyingType) {
            initByLoader(underlyingType.getClass().getClassLoader());
            try {
                return (JCTree.JCExpression) CONSTRUCTOR.newInstance(annotations, underlyingType);
            } catch (Exception unused) {
                return underlyingType;
            }
        }
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/javac/handlers/JavacHandlerUtil$JCAnnotationReflect.SCL.lombok */
    static class JCAnnotationReflect {
        private static final Field ATTRIBUTE = Permit.permissiveGetField(JCTree.JCAnnotation.class, "attribute");

        JCAnnotationReflect() {
        }

        static Attribute.Compound getAttribute(JCTree.JCAnnotation jcAnnotation) {
            if (ATTRIBUTE != null) {
                try {
                    return (Attribute.Compound) ATTRIBUTE.get(jcAnnotation);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }

        static void setAttribute(JCTree.JCAnnotation jcAnnotation, Attribute.Compound attribute) {
            if (ATTRIBUTE != null) {
                try {
                    Permit.set(ATTRIBUTE, jcAnnotation, attribute);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/javac/handlers/JavacHandlerUtil$ClassSymbolMembersField.SCL.lombok */
    static class ClassSymbolMembersField {
        private static final Field membersField;
        private static final Method removeMethod;
        private static final Method enterMethod;

        ClassSymbolMembersField() {
        }

        static {
            Field f = null;
            Method r = null;
            Method e = null;
            try {
                f = Permit.getField(Symbol.ClassSymbol.class, "members_field");
                r = Permit.getMethod(f.getType(), "remove", Symbol.class);
                e = Permit.getMethod(f.getType(), "enter", Symbol.class);
            } catch (Exception unused) {
            }
            membersField = f;
            removeMethod = r;
            enterMethod = e;
        }

        static void remove(Symbol.ClassSymbol from, Symbol toRemove) {
            if (from == null) {
                return;
            }
            try {
                Scope scope = (Scope) membersField.get(from);
                if (scope == null) {
                    return;
                }
                Permit.invoke(removeMethod, scope, toRemove);
            } catch (Exception unused) {
            }
        }

        static void enter(Symbol.ClassSymbol from, Symbol toEnter) {
            if (from == null) {
                return;
            }
            try {
                Scope scope = (Scope) membersField.get(from);
                if (scope == null) {
                    return;
                }
                Permit.invoke(enterMethod, scope, toEnter);
            } catch (Exception unused) {
            }
        }
    }

    public static void injectMethod(JavacNode typeNode, JCTree.JCMethodDecl method) {
        JCTree.JCClassDecl type = typeNode.get();
        if (method.getName().contentEquals("<init>")) {
            int idx = 0;
            for (JCTree.JCMethodDecl jCMethodDecl : type.defs) {
                if ((jCMethodDecl instanceof JCTree.JCMethodDecl) && (jCMethodDecl.mods.flags & 68719476736L) != 0) {
                    JavacNode tossMe = typeNode.getNodeFor(jCMethodDecl);
                    if (tossMe != null) {
                        tossMe.up().removeChild(tossMe);
                    }
                    type.defs = addAllButOne(type.defs, idx);
                    ClassSymbolMembersField.remove(type.sym, jCMethodDecl.sym);
                    break;
                }
                idx++;
            }
        }
        addSuppressWarningsAll(method.mods, typeNode, typeNode.getNodeFor(getGeneratedBy(method)), typeNode.getContext());
        addGenerated(method.mods, typeNode, typeNode.getNodeFor(getGeneratedBy(method)), typeNode.getContext());
        type.defs = type.defs.append(method);
        EnterReflect.memberEnter(method, typeNode);
        typeNode.add(method, AST.Kind.METHOD);
    }

    public static JavacNode injectType(JavacNode typeNode, JCTree.JCClassDecl type) {
        JCTree.JCClassDecl typeDecl = typeNode.get();
        addSuppressWarningsAll(type.mods, typeNode, typeNode.getNodeFor(getGeneratedBy(type)), typeNode.getContext());
        addGenerated(type.mods, typeNode, typeNode.getNodeFor(getGeneratedBy(type)), typeNode.getContext());
        typeDecl.defs = typeDecl.defs.append(type);
        EnterReflect.classEnter(type, typeNode);
        return typeNode.add(type, AST.Kind.TYPE);
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/javac/handlers/JavacHandlerUtil$EnterReflect.SCL.lombok */
    static class EnterReflect {
        private static final Method classEnter = Permit.permissiveGetMethod(Enter.class, "classEnter", JCTree.class, Env.class);
        private static final Method memberEnter = Permit.permissiveGetMethod(MemberEnter.class, "memberEnter", JCTree.class, Env.class);
        private static final Method blockAnnotations;
        private static final Method unblockAnnotations;

        EnterReflect() {
        }

        static {
            Method block = Permit.permissiveGetMethod(Annotate.class, "blockAnnotations", new Class[0]);
            if (block == null) {
                block = Permit.permissiveGetMethod(Annotate.class, "enterStart", new Class[0]);
            }
            blockAnnotations = block;
            Method unblock = Permit.permissiveGetMethod(Annotate.class, "unblockAnnotations", new Class[0]);
            if (unblock == null) {
                unblock = Permit.permissiveGetMethod(Annotate.class, "enterDone", new Class[0]);
            }
            unblockAnnotations = unblock;
        }

        static Type classEnter(JCTree tree, JavacNode parent) {
            Type type;
            Enter enter = Enter.instance(parent.getContext());
            Env<AttrContext> classEnv = enter.getEnv(parent.getElement());
            if (classEnv == null || (type = (Type) Permit.invokeSneaky(classEnter, enter, tree, classEnv)) == null) {
                return null;
            }
            type.complete();
            return type;
        }

        static void memberEnter(JCTree tree, JavacNode parent) {
            Context context = parent.getContext();
            MemberEnter me = MemberEnter.instance(context);
            Annotate annotate = Annotate.instance(context);
            Enter enter = Enter.instance(context);
            Env<AttrContext> classEnv = enter.getEnv(parent.getElement());
            if (classEnv == null) {
                return;
            }
            Permit.invokeSneaky(blockAnnotations, annotate, new Object[0]);
            Permit.invokeSneaky(memberEnter, me, tree, classEnv);
            Permit.invokeSneaky(unblockAnnotations, annotate, new Object[0]);
        }
    }

    public static long addFinalIfNeeded(long flags, Context context) {
        boolean addFinal = LombokOptionsFactory.getDelombokOptions(context).getFormatPreferences().generateFinalParams();
        if (addFinal) {
            flags |= 16;
        }
        return flags;
    }

    public static JCTree.JCExpression genTypeRef(JavacNode node, String complexName) {
        String[] parts = complexName.split("\\.");
        if (parts.length > 2 && parts[0].equals("java") && parts[1].equals("lang")) {
            String[] subParts = new String[parts.length - 2];
            System.arraycopy(parts, 2, subParts, 0, subParts.length);
            return genJavaLangTypeRef(node, subParts);
        }
        return chainDots(node, parts);
    }

    public static JCTree.JCExpression genJavaLangTypeRef(JavacNode node, String... simpleNames) {
        if (LombokOptionsFactory.getDelombokOptions(node.getContext()).getFormatPreferences().javaLangAsFqn()) {
            return chainDots(node, "java", "lang", simpleNames);
        }
        return chainDots(node, null, null, simpleNames);
    }

    public static JCTree.JCExpression genJavaLangTypeRef(JavacNode node, int pos, String... simpleNames) {
        if (LombokOptionsFactory.getDelombokOptions(node.getContext()).getFormatPreferences().javaLangAsFqn()) {
            return chainDots(node, pos, "java", "lang", simpleNames);
        }
        return chainDots(node, pos, null, null, simpleNames);
    }

    public static void addSuppressWarningsAll(JCTree.JCModifiers mods, JavacNode node, JavacNode source, Context context) {
        if (LombokOptionsFactory.getDelombokOptions(context).getFormatPreferences().generateSuppressWarnings()) {
            boolean addJLSuppress = !Boolean.FALSE.equals(node.getAst().readConfiguration(ConfigurationKeys.ADD_SUPPRESSWARNINGS_ANNOTATIONS));
            if (addJLSuppress) {
                for (JCTree.JCAnnotation ann : mods.annotations) {
                    JCTree.JCIdent annotationType = ann.getAnnotationType();
                    Name n = null;
                    if (annotationType instanceof JCTree.JCIdent) {
                        n = annotationType.name;
                    } else if (annotationType instanceof JCTree.JCFieldAccess) {
                        n = ((JCTree.JCFieldAccess) annotationType).name;
                    }
                    if (n != null && n.contentEquals("SuppressWarnings")) {
                        addJLSuppress = false;
                    }
                }
            }
            if (addJLSuppress) {
                addAnnotation(mods, node, source, "java.lang.SuppressWarnings", node.getTreeMaker().Literal("all"));
            }
            if (Boolean.TRUE.equals(node.getAst().readConfiguration(ConfigurationKeys.ADD_FINDBUGS_SUPPRESSWARNINGS_ANNOTATIONS))) {
                JavacTreeMaker maker = node.getTreeMaker();
                addAnnotation(mods, node, source, "edu.umd.cs.findbugs.annotations.SuppressFBWarnings", maker.Assign(maker.Ident(node.toName("justification")), maker.Literal("generated code")));
            }
        }
    }

    public static void addGenerated(JCTree.JCModifiers mods, JavacNode node, JavacNode source, Context context) {
        if (LombokOptionsFactory.getDelombokOptions(context).getFormatPreferences().generateGenerated()) {
            if (HandlerUtil.shouldAddGenerated(node)) {
                addAnnotation(mods, node, source, "javax.annotation.Generated", node.getTreeMaker().Literal("lombok"));
            }
            if (Boolean.TRUE.equals(node.getAst().readConfiguration(ConfigurationKeys.ADD_LOMBOK_GENERATED_ANNOTATIONS))) {
                addAnnotation(mods, node, source, "lombok.Generated", null);
            }
        }
    }

    public static void addAnnotation(JCTree.JCModifiers mods, JavacNode node, JavacNode source, String annotationTypeFqn, JCTree.JCExpression arg) {
        int idx = annotationTypeFqn.lastIndexOf(46);
        String simpleName = idx == -1 ? annotationTypeFqn : annotationTypeFqn.substring(idx + 1);
        boolean isJavaLangBased = idx == 9 && annotationTypeFqn.regionMatches(0, "java.lang.", 0, 10);
        for (JCTree.JCAnnotation ann : mods.annotations) {
            JCTree.JCIdent annotationType = ann.getAnnotationType();
            if (annotationType instanceof JCTree.JCIdent) {
                Name lastPart = annotationType.name;
                if (lastPart.contentEquals(simpleName)) {
                    return;
                }
            }
            if ((annotationType instanceof JCTree.JCFieldAccess) && annotationType.toString().equals(annotationTypeFqn)) {
                return;
            }
        }
        JavacTreeMaker maker = node.getTreeMaker();
        JCTree.JCExpression annType = isJavaLangBased ? genJavaLangTypeRef(node, simpleName) : chainDotsString(node, annotationTypeFqn);
        List<JCTree.JCExpression> argList = arg != null ? List.of(arg) : List.nil();
        JCTree.JCAnnotation annotation = recursiveSetGeneratedBy(maker.Annotation(annType, argList), source);
        mods.annotations = mods.annotations.append(annotation);
    }

    static JCTree.JCExpression addCheckerFrameworkReturnsReceiver(JCTree.JCExpression returnType, JavacTreeMaker maker, JavacNode typeNode, CheckerFrameworkVersion cfv) {
        if (cfv.generateReturnsReceiver()) {
            JCTree.JCAnnotation rrAnnotation = maker.Annotation(genTypeRef(typeNode, CheckerFrameworkVersion.NAME__RETURNS_RECEIVER), List.nil());
            returnType = maker.AnnotatedType(List.of(rrAnnotation), returnType);
        }
        return returnType;
    }

    private static List<JCTree> addAllButOne(List<JCTree> defs, int idx) {
        ListBuffer<JCTree> out = new ListBuffer<>();
        int i = 0;
        for (JCTree def : defs) {
            int i2 = i;
            i++;
            if (i2 != idx) {
                out.append(def);
            }
        }
        return out.toList();
    }

    public static JCTree.JCExpression chainDots(JavacNode node, String elem1, String elem2, String... elems) {
        return chainDots(node, -1, elem1, elem2, elems);
    }

    public static JCTree.JCExpression chainDots(JavacNode node, String[] elems) {
        return chainDots(node, -1, null, null, elems);
    }

    public static JCTree.JCExpression chainDots(JavacNode node, LombokImmutableList<String> elems) {
        if (!$assertionsDisabled && elems == null) {
            throw new AssertionError();
        }
        JavacTreeMaker maker = node.getTreeMaker();
        JCTree.JCFieldAccess jCFieldAccessIdent = null;
        for (String elem : elems) {
            jCFieldAccessIdent = jCFieldAccessIdent == null ? maker.Ident(node.toName(elem)) : maker.Select(jCFieldAccessIdent, node.toName(elem));
        }
        return jCFieldAccessIdent;
    }

    public static JCTree.JCExpression chainDots(JavacNode node, int pos, String elem1, String elem2, String... elems) {
        if (!$assertionsDisabled && elems == null) {
            throw new AssertionError();
        }
        JavacTreeMaker maker = node.getTreeMaker();
        if (pos != -1) {
            maker = maker.at(pos);
        }
        JCTree.JCIdent jCIdentIdent = elem1 != null ? maker.Ident(node.toName(elem1)) : null;
        if (elem2 != null) {
            jCIdentIdent = jCIdentIdent == null ? maker.Ident(node.toName(elem2)) : maker.Select(jCIdentIdent, node.toName(elem2));
        }
        for (int i = 0; i < elems.length; i++) {
            jCIdentIdent = jCIdentIdent == null ? maker.Ident(node.toName(elems[i])) : maker.Select(jCIdentIdent, node.toName(elems[i]));
        }
        if ($assertionsDisabled || jCIdentIdent != null) {
            return jCIdentIdent;
        }
        throw new AssertionError();
    }

    public static JCTree.JCExpression chainDotsString(JavacNode node, String elems) {
        return chainDots(node, null, null, elems.split("\\."));
    }

    public static List<JCTree.JCAnnotation> findAnnotations(JavacNode fieldNode, Pattern namePattern) {
        ListBuffer<JCTree.JCAnnotation> result = new ListBuffer<>();
        for (JavacNode child : fieldNode.down()) {
            if (child.getKind() == AST.Kind.ANNOTATION) {
                JCTree.JCAnnotation annotation = child.get();
                String name = annotation.annotationType.toString();
                int idx = name.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR);
                String suspect = idx == -1 ? name : name.substring(idx + 1);
                if (namePattern.matcher(suspect).matches()) {
                    result.append(annotation);
                }
            }
        }
        return result.toList();
    }

    public static String scanForNearestAnnotation(JavacNode node, String... anns) {
        while (node != null) {
            for (JavacNode ann : node.down()) {
                if (ann.getKind() == AST.Kind.ANNOTATION) {
                    JCTree.JCAnnotation a = ann.get();
                    for (String annToFind : anns) {
                        if (typeMatches(annToFind, node, a.annotationType)) {
                            return annToFind;
                        }
                    }
                }
            }
            node = node.up();
        }
        return null;
    }

    public static boolean hasNonNullAnnotations(JavacNode node) {
        for (JavacNode child : node.down()) {
            if (child.getKind() == AST.Kind.ANNOTATION) {
                JCTree.JCAnnotation annotation = child.get();
                for (String nn : HandlerUtil.NONNULL_ANNOTATIONS) {
                    if (typeMatches(nn, node, annotation.annotationType)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean hasNonNullAnnotations(JavacNode node, List<JCTree.JCAnnotation> anns) {
        if (anns == null) {
            return false;
        }
        for (JCTree.JCAnnotation ann : anns) {
            for (String nn : HandlerUtil.NONNULL_ANNOTATIONS) {
                if (typeMatches(nn, node, (JCTree) ann)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<JCTree.JCAnnotation> findCopyableAnnotations(JavacNode node) {
        JCTree.JCAnnotation anno = null;
        String annoName = null;
        for (JavacNode child : node.down()) {
            if (child.getKind() == AST.Kind.ANNOTATION) {
                if (anno != null) {
                    annoName = Constants.STR_EMPTY;
                    break;
                }
                JCTree.JCAnnotation annotation = (JCTree.JCAnnotation) child.get();
                annoName = annotation.annotationType.toString();
                anno = annotation;
            }
        }
        if (annoName == null) {
            return List.nil();
        }
        java.util.List<TypeName> configuredCopyable = (java.util.List) node.getAst().readConfiguration(ConfigurationKeys.COPYABLE_ANNOTATIONS);
        if (!annoName.isEmpty()) {
            for (TypeName cn2 : configuredCopyable) {
                if (cn2 != null && typeMatches(cn2.toString(), node, anno.annotationType)) {
                    return List.of(anno);
                }
            }
            for (String bn : HandlerUtil.BASE_COPYABLE_ANNOTATIONS) {
                if (typeMatches(bn, node, anno.annotationType)) {
                    return List.of(anno);
                }
            }
        }
        ListBuffer<JCTree.JCAnnotation> result = new ListBuffer<>();
        for (JavacNode child2 : node.down()) {
            if (child2.getKind() == AST.Kind.ANNOTATION) {
                JCTree.JCAnnotation annotation2 = child2.get();
                boolean match = false;
                for (TypeName cn3 : configuredCopyable) {
                    if (cn3 != null && typeMatches(cn3.toString(), node, annotation2.annotationType)) {
                        result.append(annotation2);
                        match = true;
                        break;
                    }
                }
                if (!match) {
                    for (String bn2 : HandlerUtil.BASE_COPYABLE_ANNOTATIONS) {
                        if (typeMatches(bn2, node, annotation2.annotationType)) {
                            result.append(annotation2);
                            break;
                        }
                    }
                }
            }
        }
        return result.toList();
    }

    public static List<JCTree.JCAnnotation> findCopyableToSetterAnnotations(JavacNode node) {
        return findAnnotationsInList(node, HandlerUtil.COPY_TO_SETTER_ANNOTATIONS);
    }

    public static List<JCTree.JCAnnotation> findCopyableToBuilderSingularSetterAnnotations(JavacNode node) {
        return findAnnotationsInList(node, HandlerUtil.COPY_TO_BUILDER_SINGULAR_SETTER_ANNOTATIONS);
    }

    private static List<JCTree.JCAnnotation> findAnnotationsInList(JavacNode node, java.util.List<String> annotationsToFind) {
        JCTree.JCAnnotation anno = null;
        String annoName = null;
        for (JavacNode child : node.down()) {
            if (child.getKind() == AST.Kind.ANNOTATION) {
                if (anno != null) {
                    annoName = Constants.STR_EMPTY;
                    break;
                }
                JCTree.JCAnnotation annotation = (JCTree.JCAnnotation) child.get();
                annoName = annotation.annotationType.toString();
                anno = annotation;
            }
        }
        if (annoName == null) {
            return List.nil();
        }
        if (!annoName.isEmpty()) {
            for (String bn : annotationsToFind) {
                if (typeMatches(bn, node, anno.annotationType)) {
                    return List.of(anno);
                }
            }
        }
        ListBuffer<JCTree.JCAnnotation> result = new ListBuffer<>();
        for (JavacNode child2 : node.down()) {
            if (child2.getKind() == AST.Kind.ANNOTATION) {
                JCTree.JCAnnotation annotation2 = child2.get();
                if (0 == 0) {
                    for (String bn2 : annotationsToFind) {
                        if (typeMatches(bn2, node, annotation2.annotationType)) {
                            result.append(annotation2);
                            break;
                        }
                    }
                }
            }
        }
        return result.toList();
    }

    public static JCTree.JCStatement generateNullCheck(JavacTreeMaker maker, JavacNode variable, JavacNode source) {
        return generateNullCheck(maker, variable.get(), source);
    }

    public static JCTree.JCStatement generateNullCheck(JavacTreeMaker maker, JCTree.JCExpression typeNode, Name varName, JavacNode source, String customMessage) {
        NullCheckExceptionType exceptionType = (NullCheckExceptionType) source.getAst().readConfiguration(ConfigurationKeys.NON_NULL_EXCEPTION_TYPE);
        if (exceptionType == null) {
            exceptionType = NullCheckExceptionType.NULL_POINTER_EXCEPTION;
        }
        if (typeNode != null && Javac.isPrimitive(typeNode)) {
            return null;
        }
        JCTree.JCLiteral message = maker.Literal(exceptionType.toExceptionMessage(varName.toString(), customMessage));
        LombokImmutableList<String> method = exceptionType.getMethod();
        if (method != null) {
            return maker.Exec(maker.Apply(List.nil(), chainDots(source, method), List.of(maker.Ident(varName), message)));
        }
        if (exceptionType == NullCheckExceptionType.ASSERTION) {
            return maker.Assert(maker.Binary(Javac.CTC_NOT_EQUAL, maker.Ident(varName), maker.Literal(Javac.CTC_BOT, null)), message);
        }
        JCTree.JCExpression exType = genTypeRef(source, exceptionType.getExceptionType());
        JCTree.JCBlock throwBlock = maker.Block(0L, List.of(maker.Throw(maker.NewClass(null, List.nil(), exType, List.of(message), null))));
        return maker.If(maker.Binary(Javac.CTC_EQUAL, maker.Ident(varName), maker.Literal(Javac.CTC_BOT, null)), throwBlock, null);
    }

    public static JCTree.JCStatement generateNullCheck(JavacTreeMaker maker, JCTree.JCVariableDecl varDecl, JavacNode source) {
        return generateNullCheck(maker, varDecl.vartype, varDecl.name, source, null);
    }

    public static List<Integer> createListOfNonExistentFields(List<String> list, JavacNode type, boolean excludeStandard, boolean excludeTransient) {
        boolean[] matched = new boolean[list.size()];
        for (JavacNode child : type.down()) {
            if (list.isEmpty()) {
                break;
            }
            if (child.getKind() == AST.Kind.FIELD) {
                JCTree.JCVariableDecl field = child.get();
                if (!excludeStandard || ((field.mods.flags & 8) == 0 && !field.name.toString().startsWith("$"))) {
                    if (!excludeTransient || (field.mods.flags & 128) == 0) {
                        int idx = list.indexOf(child.getName());
                        if (idx > -1) {
                            matched[idx] = true;
                        }
                    }
                }
            }
        }
        ListBuffer<Integer> problematic = new ListBuffer<>();
        for (int i = 0; i < list.size(); i++) {
            if (!matched[i]) {
                problematic.append(Integer.valueOf(i));
            }
        }
        return problematic.toList();
    }

    static List<JCTree.JCAnnotation> unboxAndRemoveAnnotationParameter(JCTree.JCAnnotation ast, String parameterName, String errorName, JavacNode annotationNode) {
        ListBuffer<JCTree.JCExpression> params = new ListBuffer<>();
        ListBuffer<JCTree.JCAnnotation> result = new ListBuffer<>();
        for (JCTree.JCAssign jCAssign : ast.args) {
            String nameOfParam = "value";
            JCTree.JCExpression valueOfParam = null;
            if (jCAssign instanceof JCTree.JCAssign) {
                JCTree.JCAssign assign = jCAssign;
                if (assign.lhs instanceof JCTree.JCIdent) {
                    JCTree.JCIdent ident = assign.lhs;
                    nameOfParam = ident.name.toString();
                }
                valueOfParam = assign.rhs;
            }
            int lastIdx = nameOfParam.length();
            while (lastIdx > 0 && nameOfParam.charAt(lastIdx - 1) == '_') {
                lastIdx--;
            }
            boolean allowRaw = lastIdx < nameOfParam.length();
            if (!parameterName.equals(nameOfParam.substring(0, lastIdx))) {
                params.append(jCAssign);
            } else {
                int endPos = Javac.getEndPosition(jCAssign.pos(), annotationNode.top().get());
                annotationNode.getAst().removeFromDeferredDiagnostics(((JCTree.JCExpression) jCAssign).pos, endPos);
                if (valueOfParam instanceof JCTree.JCAnnotation) {
                    String dummyAnnotationName = ((JCTree.JCAnnotation) valueOfParam).annotationType.toString();
                    if (dummyAnnotationName.replace("_", Constants.STR_EMPTY).replace("$", Constants.STR_EMPTY).replace("x", Constants.STR_EMPTY).replace("X", Constants.STR_EMPTY).length() > 0) {
                        if (allowRaw) {
                            result.append((JCTree.JCAnnotation) valueOfParam);
                        } else {
                            addError(errorName, annotationNode);
                        }
                    } else {
                        for (JCTree.JCExpression expr : ((JCTree.JCAnnotation) valueOfParam).args) {
                            if ((expr instanceof JCTree.JCAssign) && (((JCTree.JCAssign) expr).lhs instanceof JCTree.JCIdent)) {
                                JCTree.JCIdent id = ((JCTree.JCAssign) expr).lhs;
                                if ("value".equals(id.name.toString())) {
                                    expr = ((JCTree.JCAssign) expr).rhs;
                                } else {
                                    addError(errorName, annotationNode);
                                }
                            }
                            if (expr instanceof JCTree.JCAnnotation) {
                                result.append((JCTree.JCAnnotation) expr);
                            } else if (expr instanceof JCTree.JCNewArray) {
                                for (JCTree.JCAnnotation jCAnnotation : ((JCTree.JCNewArray) expr).elems) {
                                    if (jCAnnotation instanceof JCTree.JCAnnotation) {
                                        result.append(jCAnnotation);
                                    } else {
                                        addError(errorName, annotationNode);
                                        break;
                                    }
                                }
                            } else {
                                addError(errorName, annotationNode);
                                break;
                            }
                        }
                    }
                } else if (valueOfParam instanceof JCTree.JCNewArray) {
                    JCTree.JCNewArray arr = (JCTree.JCNewArray) valueOfParam;
                    if (!arr.elems.isEmpty()) {
                        if (allowRaw) {
                            for (JCTree.JCAnnotation jCAnnotation2 : arr.elems) {
                                if (jCAnnotation2 instanceof JCTree.JCAnnotation) {
                                    result.append(jCAnnotation2);
                                } else {
                                    addError(errorName, annotationNode);
                                }
                            }
                        } else {
                            addError(errorName, annotationNode);
                        }
                    }
                } else {
                    addError(errorName, annotationNode);
                }
            }
        }
        for (JCTree.JCAnnotation annotation : result) {
            clearTypes(annotation);
        }
        ast.args = params.toList();
        return result.toList();
    }

    private static void clearTypes(JCTree tree) {
        tree.accept(new TreeScanner() { // from class: lombok.javac.handlers.JavacHandlerUtil.3
            public void scan(JCTree tree2) {
                if (tree2 == null) {
                    return;
                }
                tree2.type = null;
                super.scan(tree2);
            }

            public void visitClassDef(JCTree.JCClassDecl tree2) {
                tree2.sym = null;
                super.visitClassDef(tree2);
            }

            public void visitMethodDef(JCTree.JCMethodDecl tree2) {
                tree2.sym = null;
                super.visitMethodDef(tree2);
            }

            public void visitVarDef(JCTree.JCVariableDecl tree2) {
                tree2.sym = null;
                super.visitVarDef(tree2);
            }

            public void visitSelect(JCTree.JCFieldAccess tree2) {
                tree2.sym = null;
                super.visitSelect(tree2);
            }

            public void visitIdent(JCTree.JCIdent tree2) {
                tree2.sym = null;
                super.visitIdent(tree2);
            }

            public void visitAnnotation(JCTree.JCAnnotation tree2) {
                JCAnnotationReflect.setAttribute(tree2, null);
                super.visitAnnotation(tree2);
            }
        });
    }

    private static void addError(String errorName, JavacNode node) {
        if (node.getLatestJavaSpecSupported() < 8) {
            node.addError("The correct format up to JDK7 is " + errorName + "=@__({@SomeAnnotation, @SomeOtherAnnotation}))");
        } else {
            node.addError("The correct format for JDK8+ is " + errorName + "_={@SomeAnnotation, @SomeOtherAnnotation})");
        }
    }

    public static List<JCTree.JCTypeParameter> copyTypeParams(JavacNode source, List<JCTree.JCTypeParameter> params) {
        if (params == null || params.isEmpty()) {
            return params;
        }
        ListBuffer<JCTree.JCTypeParameter> out = new ListBuffer<>();
        JavacTreeMaker maker = source.getTreeMaker();
        for (JCTree.JCTypeParameter tp : params) {
            List<JCTree.JCExpression> bounds = tp.bounds;
            if (bounds != null && !bounds.isEmpty()) {
                ListBuffer<JCTree.JCExpression> boundsCopy = new ListBuffer<>();
                for (JCTree.JCExpression expr : tp.bounds) {
                    boundsCopy.append(cloneType(maker, expr, source));
                }
                bounds = boundsCopy.toList();
            }
            out.append(maker.TypeParameter(tp.name, bounds));
        }
        return out.toList();
    }

    public static List<JCTree.JCAnnotation> getTypeUseAnnotations(JCTree.JCExpression from) {
        return !JCAnnotatedTypeReflect.is(from) ? List.nil() : JCAnnotatedTypeReflect.getAnnotations(from);
    }

    public static JCTree.JCExpression removeTypeUseAnnotations(JCTree.JCExpression from) {
        return !JCAnnotatedTypeReflect.is(from) ? from : JCAnnotatedTypeReflect.getUnderlyingType(from);
    }

    public static JCTree.JCExpression namePlusTypeParamsToTypeReference(JavacTreeMaker maker, JavacNode type, List<JCTree.JCTypeParameter> params) {
        JCTree.JCClassDecl td = type.get();
        boolean instance = (td.mods.flags & 8) == 0;
        return namePlusTypeParamsToTypeReference(maker, type.up(), td.name, instance, params, List.nil());
    }

    public static JCTree.JCExpression namePlusTypeParamsToTypeReference(JavacTreeMaker maker, JavacNode type, List<JCTree.JCTypeParameter> params, List<JCTree.JCAnnotation> annotations) {
        JCTree.JCClassDecl td = type.get();
        boolean instance = (td.mods.flags & 8) == 0;
        return namePlusTypeParamsToTypeReference(maker, type.up(), td.name, instance, params, annotations);
    }

    public static JCTree.JCExpression namePlusTypeParamsToTypeReference(JavacTreeMaker maker, JavacNode parentType, Name typeName, boolean instance, List<JCTree.JCTypeParameter> params) {
        return namePlusTypeParamsToTypeReference(maker, parentType, typeName, instance, params, List.nil());
    }

    public static JCTree.JCExpression namePlusTypeParamsToTypeReference(JavacTreeMaker maker, JavacNode parentType, Name typeName, boolean instance, List<JCTree.JCTypeParameter> params, List<JCTree.JCAnnotation> annotations) {
        JCTree.JCExpression r = null;
        if (parentType != null && parentType.getKind() == AST.Kind.TYPE && !parentType.getName().isEmpty()) {
            JCTree.JCClassDecl td = parentType.get();
            boolean outerInstance = instance && (td.mods.flags & 8) == 0;
            List<JCTree.JCTypeParameter> outerParams = instance ? td.typarams : List.nil();
            r = namePlusTypeParamsToTypeReference(maker, parentType.up(), td.name, outerInstance, outerParams, List.nil());
        }
        JCTree.JCIdent jCIdentIdent = r == null ? maker.Ident(typeName) : maker.Select(r, typeName);
        if (!annotations.isEmpty()) {
            jCIdentIdent = JCAnnotatedTypeReflect.create(annotations, jCIdentIdent);
        }
        if (!params.isEmpty()) {
            jCIdentIdent = maker.TypeApply(jCIdentIdent, typeParameterNames(maker, params));
        }
        return jCIdentIdent;
    }

    public static List<JCTree.JCExpression> typeParameterNames(JavacTreeMaker maker, List<JCTree.JCTypeParameter> params) {
        ListBuffer<JCTree.JCExpression> typeArgs = new ListBuffer<>();
        for (JCTree.JCTypeParameter param : params) {
            typeArgs.append(maker.Ident(param.name));
        }
        return typeArgs.toList();
    }

    public static void sanityCheckForMethodGeneratingAnnotationsOnBuilderClass(JavacNode typeNode, JavacNode errorNode) {
        List<String> disallowed = List.nil();
        for (JavacNode child : typeNode.down()) {
            for (String annType : HandlerUtil.INVALID_ON_BUILDERS) {
                if (annotationTypeMatches(annType, child)) {
                    int lastIndex = annType.lastIndexOf(46);
                    disallowed = disallowed.append(lastIndex == -1 ? annType : annType.substring(lastIndex + 1));
                }
            }
        }
        int size = disallowed.size();
        if (size == 0) {
            return;
        }
        if (size == 1) {
            errorNode.addError("@" + ((String) disallowed.head) + " is not allowed on builder classes.");
            return;
        }
        StringBuilder out = new StringBuilder();
        for (String a : disallowed) {
            out.append("@").append(a).append(", ");
        }
        out.setLength(out.length() - 2);
        errorNode.addError(out.append(" are not allowed on builder classes.").toString());
    }

    static List<JCTree.JCAnnotation> copyAnnotations(List<? extends JCTree.JCExpression> in) {
        ListBuffer<JCTree.JCAnnotation> out = new ListBuffer<>();
        for (JCTree.JCExpression expr : in) {
            if (expr instanceof JCTree.JCAnnotation) {
                out.append((JCTree.JCAnnotation) expr.clone());
            }
        }
        return out.toList();
    }

    static List<JCTree.JCAnnotation> mergeAnnotations(List<JCTree.JCAnnotation> a, List<JCTree.JCAnnotation> b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        ListBuffer<JCTree.JCAnnotation> out = new ListBuffer<>();
        for (JCTree.JCAnnotation ann : a) {
            out.append(ann);
        }
        for (JCTree.JCAnnotation ann2 : b) {
            out.append(ann2);
        }
        return out.toList();
    }

    public static boolean isClass(JavacNode typeNode) {
        return isClassAndDoesNotHaveFlags(typeNode, 2305843009213719040L);
    }

    public static boolean isClassOrEnum(JavacNode typeNode) {
        return isClassAndDoesNotHaveFlags(typeNode, 2305843009213702656L);
    }

    public static boolean isClassOrEnumOrInterface(JavacNode typeNode) {
        return isClassAndDoesNotHaveFlags(typeNode, 2305843009213702144L);
    }

    public static boolean isClassEnumOrRecord(JavacNode typeNode) {
        return isClassAndDoesNotHaveFlags(typeNode, 8704L);
    }

    public static boolean isRecord(JavacNode typeNode) {
        return typeNode.getKind() == AST.Kind.TYPE && (typeNode.get().mods.flags & 2305843009213693952L) != 0;
    }

    public static boolean isClassAndDoesNotHaveFlags(JavacNode typeNode, long flags) {
        if (!(typeNode.get() instanceof JCTree.JCClassDecl)) {
            return false;
        }
        JCTree.JCClassDecl typeDecl = typeNode.get();
        long typeDeclflags = typeDecl == null ? 0L : typeDecl.mods.flags;
        return (typeDeclflags & flags) == 0;
    }

    public static boolean isStaticAllowed(JavacNode typeNode) {
        return typeNode.isStatic() || typeNode.up() == null || typeNode.up().getKind() == AST.Kind.COMPILATION_UNIT || isRecord(typeNode);
    }

    public static JavacNode upToTypeNode(JavacNode node) {
        if (node == null) {
            throw new NullPointerException("node");
        }
        while (node != null && !(node.get() instanceof JCTree.JCClassDecl)) {
            node = node.up();
        }
        return node;
    }

    public static List<JCTree.JCExpression> cloneTypes(JavacTreeMaker maker, List<JCTree.JCExpression> in, JavacNode source) {
        if (in.isEmpty()) {
            return List.nil();
        }
        if (in.size() == 1) {
            return List.of(cloneType(maker, (JCTree.JCExpression) in.get(0), source));
        }
        ListBuffer<JCTree.JCExpression> lb = new ListBuffer<>();
        for (JCTree.JCExpression expr : in) {
            lb.append(cloneType(maker, expr, source));
        }
        return lb.toList();
    }

    public static JCTree.JCExpression cloneType(JavacTreeMaker maker, JCTree.JCExpression in, JavacNode source) {
        JCTree.JCExpression out = cloneType0(maker, in);
        if (out != null) {
            recursiveSetGeneratedBy(out, source);
        }
        return out;
    }

    private static JCTree.JCExpression cloneType0(JavacTreeMaker maker, JCTree in) {
        JCTree.TypeBoundKind newKind;
        if (in == null) {
            return null;
        }
        if (in instanceof JCTree.JCPrimitiveTypeTree) {
            return maker.TypeIdent(JavacTreeMaker.TypeTag.typeTag(in));
        }
        if (in instanceof JCTree.JCIdent) {
            return maker.Ident(((JCTree.JCIdent) in).name);
        }
        if (in instanceof JCTree.JCFieldAccess) {
            JCTree.JCFieldAccess fa = (JCTree.JCFieldAccess) in;
            return maker.Select(cloneType0(maker, fa.selected), fa.name);
        }
        if (in instanceof JCTree.JCArrayTypeTree) {
            JCTree.JCArrayTypeTree att = (JCTree.JCArrayTypeTree) in;
            return maker.TypeArray(cloneType0(maker, att.elemtype));
        }
        if (in instanceof JCTree.JCTypeApply) {
            JCTree.JCTypeApply ta = (JCTree.JCTypeApply) in;
            ListBuffer<JCTree.JCExpression> lb = new ListBuffer<>();
            for (JCTree.JCExpression typeArg : ta.arguments) {
                lb.append(cloneType0(maker, typeArg));
            }
            return maker.TypeApply(cloneType0(maker, ta.clazz), lb.toList());
        }
        if (in instanceof JCTree.JCWildcard) {
            JCTree.JCWildcard w = (JCTree.JCWildcard) in;
            JCTree.JCExpression newInner = cloneType0(maker, w.inner);
            switch ($SWITCH_TABLE$com$sun$source$tree$Tree$Kind()[w.getKind().ordinal()]) {
                case 88:
                default:
                    newKind = maker.TypeBoundKind(BoundKind.UNBOUND);
                    break;
                case 89:
                    newKind = maker.TypeBoundKind(BoundKind.EXTENDS);
                    break;
                case 90:
                    newKind = maker.TypeBoundKind(BoundKind.SUPER);
                    break;
            }
            return maker.Wildcard(newKind, newInner);
        }
        if (JCAnnotatedTypeReflect.is(in)) {
            JCTree.JCExpression underlyingType = cloneType0(maker, JCAnnotatedTypeReflect.getUnderlyingType(in));
            List<JCTree.JCAnnotation> anns = copyAnnotations(JCAnnotatedTypeReflect.getAnnotations(in));
            return JCAnnotatedTypeReflect.create(anns, underlyingType);
        }
        return (JCTree.JCExpression) in;
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/javac/handlers/JavacHandlerUtil$CopyJavadoc.SCL.lombok */
    public enum CopyJavadoc {
        VERBATIM { // from class: lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc.1
            @Override // lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc
            public String apply(JCTree.JCCompilationUnit cu, JavacNode node) {
                return Javac.getDocComment(cu, node.get());
            }
        },
        GETTER { // from class: lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc.2
            @Override // lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc
            public String apply(final JCTree.JCCompilationUnit cu, JavacNode node) {
                final JCTree n = node.get();
                String javadoc = Javac.getDocComment(cu, n);
                String out = HandlerUtil.getJavadocSection(javadoc, "GETTER");
                final boolean sectionBased = out != null;
                if (!sectionBased) {
                    out = HandlerUtil.stripLinesWithTagFromJavadoc(HandlerUtil.stripSectionsFromJavadoc(javadoc), HandlerUtil.JavadocTag.PARAM);
                }
                node.getAst().cleanupTask("javadocfilter-getter", n, new CleanupTask() { // from class: lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc.2.1
                    @Override // lombok.core.CleanupTask
                    public void cleanup() {
                        String javadoc2 = Javac.getDocComment(cu, n);
                        if (javadoc2 == null || javadoc2.isEmpty()) {
                            return;
                        }
                        String javadoc3 = HandlerUtil.stripSectionsFromJavadoc(javadoc2);
                        if (!sectionBased) {
                            javadoc3 = HandlerUtil.stripLinesWithTagFromJavadoc(HandlerUtil.stripSectionsFromJavadoc(javadoc3), HandlerUtil.JavadocTag.RETURN);
                        }
                        Javac.setDocComment(cu, n, javadoc3);
                    }
                });
                return out;
            }
        },
        SETTER { // from class: lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc.3
            @Override // lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc
            public String apply(JCTree.JCCompilationUnit cu, JavacNode node) {
                return CopyJavadoc.applySetter(cu, node, "SETTER");
            }
        },
        WITH { // from class: lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc.4
            @Override // lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc
            public String apply(JCTree.JCCompilationUnit cu, JavacNode node) {
                return HandlerUtil.addReturnsUpdatedSelfIfNeeded(CopyJavadoc.applySetter(cu, node, "WITH|WITHER"));
            }
        },
        WITH_BY { // from class: lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc.5
            @Override // lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc
            public String apply(JCTree.JCCompilationUnit cu, JavacNode node) {
                return CopyJavadoc.applySetter(cu, node, "WITHBY|WITH_BY");
            }
        };

        public abstract String apply(JCTree.JCCompilationUnit jCCompilationUnit, JavacNode javacNode);

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static CopyJavadoc[] valuesCustom() {
            CopyJavadoc[] copyJavadocArrValuesCustom = values();
            int length = copyJavadocArrValuesCustom.length;
            CopyJavadoc[] copyJavadocArr = new CopyJavadoc[length];
            System.arraycopy(copyJavadocArrValuesCustom, 0, copyJavadocArr, 0, length);
            return copyJavadocArr;
        }

        /* synthetic */ CopyJavadoc(CopyJavadoc copyJavadoc) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String applySetter(final JCTree.JCCompilationUnit cu, JavacNode node, String sectionName) {
            final JCTree n = node.get();
            String javadoc = Javac.getDocComment(cu, n);
            String out = HandlerUtil.getJavadocSection(javadoc, sectionName);
            final boolean sectionBased = out != null;
            if (!sectionBased) {
                out = HandlerUtil.stripLinesWithTagFromJavadoc(HandlerUtil.stripSectionsFromJavadoc(javadoc), HandlerUtil.JavadocTag.RETURN);
            }
            node.getAst().cleanupTask("javadocfilter-setter", n, new CleanupTask() { // from class: lombok.javac.handlers.JavacHandlerUtil.CopyJavadoc.6
                @Override // lombok.core.CleanupTask
                public void cleanup() {
                    String javadoc2 = Javac.getDocComment(cu, n);
                    if (javadoc2 == null || javadoc2.isEmpty()) {
                        return;
                    }
                    String javadoc3 = HandlerUtil.stripSectionsFromJavadoc(javadoc2);
                    if (!sectionBased) {
                        javadoc3 = HandlerUtil.stripLinesWithTagFromJavadoc(HandlerUtil.stripSectionsFromJavadoc(javadoc3), HandlerUtil.JavadocTag.PARAM);
                    }
                    Javac.setDocComment(cu, n, javadoc3);
                }
            });
            return JavacHandlerUtil.shouldReturnThis(node, JavacHandlerUtil.getAccessorsForField(node)) ? HandlerUtil.addReturnsThisIfNeeded(out) : out;
        }
    }

    public static void copyJavadoc(JavacNode from, JCTree to, CopyJavadoc copyMode) {
        copyJavadoc(from, to, copyMode, false);
    }

    public static void copyJavadoc(JavacNode from, JCTree to, CopyJavadoc copyMode, boolean forceAddReturn) {
        if (copyMode == null) {
            copyMode = CopyJavadoc.VERBATIM;
        }
        try {
            JCTree.JCCompilationUnit cu = (JCTree.JCCompilationUnit) from.top().get();
            String newJavadoc = copyMode.apply(cu, from);
            if (forceAddReturn) {
                newJavadoc = HandlerUtil.addReturnsThisIfNeeded(newJavadoc);
            }
            Javac.setDocComment(cu, to, newJavadoc);
        } catch (Exception unused) {
        }
    }

    public static boolean isDirectDescendantOfObject(JavacNode typeNode) {
        if (!(typeNode.get() instanceof JCTree.JCClassDecl)) {
            throw new IllegalArgumentException("not a type node");
        }
        JCTree extending = Javac.getExtendsClause(typeNode.get());
        if (extending == null) {
            return true;
        }
        String p = extending.toString();
        return p.equals("Object") || p.equals("java.lang.Object");
    }

    public static void createRelevantNullableAnnotation(JavacNode typeNode, JCTree.JCMethodDecl mth) {
        NullAnnotationLibrary lib = (NullAnnotationLibrary) typeNode.getAst().readConfiguration(ConfigurationKeys.ADD_NULL_ANNOTATIONS);
        if (lib == null) {
            return;
        }
        applyAnnotationToMethodDecl(typeNode, mth, lib.getNullableAnnotation(), lib.isTypeUse());
    }

    public static void createRelevantNonNullAnnotation(JavacNode typeNode, JCTree.JCMethodDecl mth) {
        NullAnnotationLibrary lib = (NullAnnotationLibrary) typeNode.getAst().readConfiguration(ConfigurationKeys.ADD_NULL_ANNOTATIONS);
        if (lib == null) {
            return;
        }
        applyAnnotationToMethodDecl(typeNode, mth, lib.getNonNullAnnotation(), lib.isTypeUse());
    }

    public static void createRelevantNonNullAnnotation(JavacNode typeNode, JCTree.JCVariableDecl arg) {
        NullAnnotationLibrary lib = (NullAnnotationLibrary) typeNode.getAst().readConfiguration(ConfigurationKeys.ADD_NULL_ANNOTATIONS);
        if (lib == null) {
            return;
        }
        applyAnnotationToVarDecl(typeNode, arg, lib.getNonNullAnnotation(), lib.isTypeUse());
    }

    public static void createRelevantNullableAnnotation(JavacNode typeNode, JCTree.JCVariableDecl arg) {
        NullAnnotationLibrary lib = (NullAnnotationLibrary) typeNode.getAst().readConfiguration(ConfigurationKeys.ADD_NULL_ANNOTATIONS);
        if (lib == null) {
            return;
        }
        applyAnnotationToVarDecl(typeNode, arg, lib.getNullableAnnotation(), lib.isTypeUse());
    }

    private static void applyAnnotationToMethodDecl(JavacNode typeNode, JCTree.JCMethodDecl mth, String annType, boolean typeUse) {
        if (annType == null) {
            return;
        }
        JavacTreeMaker maker = typeNode.getTreeMaker();
        JCTree.JCAnnotation m = maker.Annotation(genTypeRef(typeNode, annType), List.nil());
        if (typeUse) {
            JCTree.JCExpression resType = mth.restype;
            if (resType instanceof JCTree.JCTypeApply) {
                JCTree.JCTypeApply ta = (JCTree.JCTypeApply) resType;
                if (ta.clazz instanceof JCTree.JCFieldAccess) {
                    mth.restype = maker.TypeApply(maker.AnnotatedType(List.of(m), ta.clazz), ta.arguments);
                    return;
                }
                resType = ta.clazz;
            }
            if ((resType instanceof JCTree.JCFieldAccess) || (resType instanceof JCTree.JCArrayTypeTree)) {
                mth.restype = maker.AnnotatedType(List.of(m), resType);
                return;
            }
            if (JCAnnotatedTypeReflect.is(resType)) {
                List<JCTree.JCAnnotation> annotations = JCAnnotatedTypeReflect.getAnnotations(resType);
                JCAnnotatedTypeReflect.setAnnotations(resType, annotations.prepend(m));
                return;
            } else {
                if ((resType instanceof JCTree.JCPrimitiveTypeTree) || (resType instanceof JCTree.JCIdent)) {
                    mth.mods.annotations = mth.mods.annotations == null ? List.of(m) : mth.mods.annotations.prepend(m);
                    return;
                }
                return;
            }
        }
        mth.mods.annotations = mth.mods.annotations == null ? List.of(m) : mth.mods.annotations.prepend(m);
    }

    private static void applyAnnotationToVarDecl(JavacNode typeNode, JCTree.JCVariableDecl arg, String annType, boolean typeUse) {
        if (annType == null) {
            return;
        }
        JavacTreeMaker maker = typeNode.getTreeMaker();
        JCTree.JCAnnotation m = maker.Annotation(genTypeRef(typeNode, annType), List.nil());
        if (typeUse) {
            JCTree.JCExpression varType = arg.vartype;
            JCTree.JCTypeApply ta = null;
            if (varType instanceof JCTree.JCTypeApply) {
                ta = (JCTree.JCTypeApply) varType;
                varType = ta.clazz;
            }
            if ((varType instanceof JCTree.JCFieldAccess) || (varType instanceof JCTree.JCArrayTypeTree)) {
                JCTree.JCExpression varType2 = maker.AnnotatedType(List.of(m), varType);
                if (ta == null) {
                    arg.vartype = varType2;
                    return;
                } else {
                    ta.clazz = varType2;
                    return;
                }
            }
            if (JCAnnotatedTypeReflect.is(varType)) {
                List<JCTree.JCAnnotation> annotations = JCAnnotatedTypeReflect.getAnnotations(varType);
                JCAnnotatedTypeReflect.setAnnotations(varType, annotations.prepend(m));
                return;
            } else {
                if ((varType instanceof JCTree.JCPrimitiveTypeTree) || (varType instanceof JCTree.JCIdent)) {
                    arg.mods.annotations = arg.mods.annotations == null ? List.of(m) : arg.mods.annotations.prepend(m);
                    return;
                }
                return;
            }
        }
        arg.mods.annotations = arg.mods.annotations == null ? List.of(m) : arg.mods.annotations.prepend(m);
    }
}
