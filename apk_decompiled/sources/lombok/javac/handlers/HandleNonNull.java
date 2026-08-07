package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.NonNull;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/javac/handlers/HandleNonNull.SCL.lombok */
@HandlerPriority(512)
public class HandleNonNull extends JavacAnnotationHandler<NonNull> {
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

    private JCTree.JCMethodDecl createRecordArgslessConstructor(JavacNode typeNode, JavacNode source, JCTree.JCMethodDecl existingCtr) {
        JavacTreeMaker maker = typeNode.getTreeMaker();
        List<JCTree.JCVariableDecl> fields = new ArrayList<>();
        for (JavacNode child : typeNode.down()) {
            if (child.getKind() == AST.Kind.FIELD) {
                JCTree.JCVariableDecl v = child.get();
                if ((v.mods.flags & 2305843009213693952L) != 0) {
                    fields.add(v);
                }
            }
        }
        ListBuffer<JCTree.JCVariableDecl> params = new ListBuffer<>();
        for (int i = 0; i < fields.size(); i++) {
            JCTree.JCVariableDecl arg = fields.get(i);
            params.append(maker.VarDef(maker.Modifiers(8606711808L, arg.mods.annotations), arg.name, arg.vartype, null));
        }
        JCTree.JCModifiers mods = maker.Modifiers(((long) JavacHandlerUtil.toJavacModifier(AccessLevel.PUBLIC)) | 2251799813685248L, com.sun.tools.javac.util.List.nil());
        JCTree.JCBlock body = maker.Block(0L, com.sun.tools.javac.util.List.nil());
        if (existingCtr == null) {
            JCTree.JCMethodDecl constr = maker.MethodDef(mods, typeNode.toName("<init>"), null, com.sun.tools.javac.util.List.nil(), params.toList(), com.sun.tools.javac.util.List.nil(), body, null);
            return JavacHandlerUtil.recursiveSetGeneratedBy(constr, source);
        }
        existingCtr.mods = mods;
        existingCtr.body = body;
        JCTree.JCMethodDecl existingCtr2 = JavacHandlerUtil.recursiveSetGeneratedBy(existingCtr, source);
        JavacHandlerUtil.addSuppressWarningsAll(existingCtr2.mods, typeNode, typeNode.getNodeFor(JavacHandlerUtil.getGeneratedBy(existingCtr2)), typeNode.getContext());
        JavacHandlerUtil.addGenerated(existingCtr2.mods, typeNode, typeNode.getNodeFor(JavacHandlerUtil.getGeneratedBy(existingCtr2)), typeNode.getContext());
        return existingCtr2;
    }

    private com.sun.tools.javac.util.List<JCTree.JCMethodDecl> addCompactConstructorIfNeeded(JavacNode typeNode, JavacNode source) {
        JCTree.JCMethodDecl ctr;
        com.sun.tools.javac.util.List<JCTree.JCMethodDecl> answer = com.sun.tools.javac.util.List.nil();
        if (typeNode == null || !(typeNode.get() instanceof JCTree.JCClassDecl)) {
            return answer;
        }
        JCTree.JCClassDecl cDecl = typeNode.get();
        if ((cDecl.mods.flags & 2305843009213693952L) == 0) {
            return answer;
        }
        boolean generateConstructor = false;
        JCTree.JCMethodDecl existingCtr = null;
        for (JCTree def : cDecl.defs) {
            if (def instanceof JCTree.JCMethodDecl) {
                JCTree.JCMethodDecl md = (JCTree.JCMethodDecl) def;
                if (md.name.contentEquals("<init>")) {
                    if ((md.mods.flags & 68719476736L) != 0) {
                        existingCtr = md;
                        existingCtr.mods.flags &= -68719476737L;
                        generateConstructor = true;
                    } else if (!JavacHandlerUtil.isTolerate(typeNode, md) && (md.mods.flags & 2251799813685248L) != 0) {
                        generateConstructor = false;
                        answer = answer.prepend(md);
                    }
                }
            }
        }
        if (generateConstructor) {
            if (existingCtr != null) {
                ctr = createRecordArgslessConstructor(typeNode, source, existingCtr);
            } else {
                ctr = createRecordArgslessConstructor(typeNode, source, null);
                JavacHandlerUtil.injectMethod(typeNode, ctr);
            }
            answer = answer.prepend(ctr);
        }
        return answer;
    }

    private void addNullCheckIfNeeded(JCTree.JCMethodDecl method, JavacNode paramNode, JavacNode source) {
        JCTree.JCStatement nullCheck = JavacHandlerUtil.recursiveSetGeneratedBy(JavacHandlerUtil.generateNullCheck(source.getTreeMaker(), paramNode, source), source);
        if (nullCheck == null) {
            source.addWarning("@NonNull is meaningless on a primitive.");
            return;
        }
        com.sun.tools.javac.util.List<JCTree.JCStatement> statements = method.body.stats;
        String expectedName = paramNode.getName();
        com.sun.tools.javac.util.List<JCTree.JCStatement> stats = statements;
        int idx = 0;
        while (stats.size() > idx) {
            int i = idx;
            idx++;
            JCTree.JCSynchronized jCSynchronized = (JCTree.JCStatement) stats.get(i);
            if (!JavacHandlerUtil.isConstructorCall(jCSynchronized)) {
                if (jCSynchronized instanceof JCTree.JCTry) {
                    stats = ((JCTree.JCTry) jCSynchronized).body.stats;
                    idx = 0;
                } else if (jCSynchronized instanceof JCTree.JCSynchronized) {
                    stats = jCSynchronized.body.stats;
                    idx = 0;
                } else {
                    String varNameOfNullCheck = returnVarNameIfNullCheck(jCSynchronized);
                    if (varNameOfNullCheck == null) {
                        break;
                    } else if (varNameOfNullCheck.equals(expectedName)) {
                        return;
                    }
                }
            }
        }
        com.sun.tools.javac.util.List<JCTree.JCStatement> tail = statements;
        com.sun.tools.javac.util.List<JCTree.JCStatement> head = com.sun.tools.javac.util.List.nil();
        for (JCTree.JCStatement stat : statements) {
            if (!JavacHandlerUtil.isConstructorCall(stat) && (!JavacHandlerUtil.isGenerated(stat) || !isNullCheck(stat))) {
                break;
            }
            tail = tail.tail;
            head = head.prepend(stat);
        }
        com.sun.tools.javac.util.List<JCTree.JCStatement> newList = tail.prepend(nullCheck);
        Iterator it = head.iterator();
        while (it.hasNext()) {
            newList = newList.prepend((JCTree.JCStatement) it.next());
        }
        method.body.stats = newList;
        source.getAst().setChanged();
    }

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<NonNull> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        JavacNode paramNode;
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.NON_NULL_FLAG_USAGE, "@NonNull");
        if (annotationNode.up().getKind() == AST.Kind.FIELD) {
            try {
                if (Javac.isPrimitive(annotationNode.up().get().vartype)) {
                    annotationNode.addWarning("@NonNull is meaningless on a primitive.");
                }
            } catch (Exception unused) {
            }
            JCTree.JCVariableDecl fDecl = annotationNode.up().get();
            if ((fDecl.mods.flags & 2305843009213693952L) != 0) {
                com.sun.tools.javac.util.List<JCTree.JCMethodDecl> compactConstructors = addCompactConstructorIfNeeded(annotationNode.up().up(), annotationNode);
                for (JCTree.JCMethodDecl ctr : compactConstructors) {
                    addNullCheckIfNeeded(ctr, annotationNode.up(), annotationNode);
                }
                return;
            }
            return;
        }
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[annotationNode.up().getKind().ordinal()]) {
            case 7:
                paramNode = annotationNode.up();
                break;
            case 8:
            case 9:
            default:
                return;
            case 10:
                JavacNode typeNode = annotationNode.directUp();
                paramNode = typeNode.directUp();
                break;
        }
        if (paramNode.getKind() != AST.Kind.ARGUMENT) {
            return;
        }
        try {
            JCTree.JCMethodDecl declaration = (JCTree.JCMethodDecl) paramNode.up().get();
            if (declaration.body == null || (declaration.mods.flags & 2251799830462464L) != 0) {
                return;
            }
            addNullCheckIfNeeded(declaration, paramNode, annotationNode);
        } catch (Exception unused2) {
        }
    }

    public boolean isNullCheck(JCTree.JCStatement stat) {
        return returnVarNameIfNullCheck(stat) != null;
    }

    public String returnVarNameIfNullCheck(JCTree.JCStatement stat) {
        JCTree.JCExpression cond;
        boolean isIf = stat instanceof JCTree.JCIf;
        boolean isExpression = stat instanceof JCTree.JCExpressionStatement;
        if (!isIf && !(stat instanceof JCTree.JCAssert) && !isExpression) {
            return null;
        }
        if (isExpression) {
            JCTree.JCExpression expression = ((JCTree.JCExpressionStatement) stat).expr;
            if (expression instanceof JCTree.JCAssign) {
                expression = ((JCTree.JCAssign) expression).rhs;
            }
            if (!(expression instanceof JCTree.JCMethodInvocation)) {
                return null;
            }
            JCTree.JCMethodInvocation invocation = (JCTree.JCMethodInvocation) expression;
            JCTree.JCFieldAccess jCFieldAccess = invocation.meth;
            Name name = null;
            if (jCFieldAccess instanceof JCTree.JCFieldAccess) {
                name = jCFieldAccess.name;
            } else if (jCFieldAccess instanceof JCTree.JCIdent) {
                name = ((JCTree.JCIdent) jCFieldAccess).name;
            }
            if (name == null) {
                return null;
            }
            if ((!name.contentEquals("checkNotNull") && !name.contentEquals("requireNonNull")) || invocation.args.isEmpty()) {
                return null;
            }
            JCTree.JCIdent jCIdent = (JCTree.JCExpression) invocation.args.head;
            if (jCIdent instanceof JCTree.JCIdent) {
                return jCIdent.toString();
            }
            return null;
        }
        if (isIf) {
            JCTree.JCStatement then = ((JCTree.JCIf) stat).thenpart;
            if (then instanceof JCTree.JCBlock) {
                com.sun.tools.javac.util.List<JCTree.JCStatement> stats = ((JCTree.JCBlock) then).stats;
                if (stats.length() == 0) {
                    return null;
                }
                then = (JCTree.JCStatement) stats.get(0);
            }
            if (!(then instanceof JCTree.JCThrow)) {
                return null;
            }
        }
        JCTree.JCExpression jCExpression = isIf ? ((JCTree.JCIf) stat).cond : ((JCTree.JCAssert) stat).cond;
        while (true) {
            cond = jCExpression;
            if (!(cond instanceof JCTree.JCParens)) {
                break;
            }
            jCExpression = ((JCTree.JCParens) cond).expr;
        }
        if (!(cond instanceof JCTree.JCBinary)) {
            return null;
        }
        JCTree.JCBinary bin = (JCTree.JCBinary) cond;
        if (isIf) {
            if (!Javac.CTC_EQUAL.equals(JavacTreeMaker.TreeTag.treeTag((JCTree) bin))) {
                return null;
            }
        } else if (!Javac.CTC_NOT_EQUAL.equals(JavacTreeMaker.TreeTag.treeTag((JCTree) bin))) {
            return null;
        }
        if ((bin.lhs instanceof JCTree.JCIdent) && (bin.rhs instanceof JCTree.JCLiteral) && Javac.CTC_BOT.equals(JavacTreeMaker.TypeTag.typeTag((JCTree) bin.rhs))) {
            return bin.lhs.name.toString();
        }
        return null;
    }
}
