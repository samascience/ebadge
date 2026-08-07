package lombok.javac.handlers;

import android.support.v4.media.session.PlaybackStateCompat;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.List;
import java.lang.annotation.Annotation;
import lombok.ConfigurationKeys;
import lombok.Synchronized;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/javac/handlers/HandleSynchronized.SCL.lombok */
@HandlerPriority(1024)
public class HandleSynchronized extends JavacAnnotationHandler<Synchronized> {
    private static final String INSTANCE_LOCK_NAME = "$lock";
    private static final String STATIC_LOCK_NAME = "$LOCK";

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Synchronized> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        JCTree.JCExpression lockNode;
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.SYNCHRONIZED_FLAG_USAGE, "@Synchronized");
        if (JavacHandlerUtil.inNetbeansEditor(annotationNode)) {
            return;
        }
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) Synchronized.class);
        JavacNode methodNode = annotationNode.up();
        if (methodNode == null || methodNode.getKind() != AST.Kind.METHOD || !(methodNode.get() instanceof JCTree.JCMethodDecl)) {
            annotationNode.addError("@Synchronized is legal only on methods.");
            return;
        }
        JCTree.JCMethodDecl method = methodNode.get();
        if ((method.mods.flags & PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) != 0) {
            annotationNode.addError("@Synchronized is legal only on concrete methods.");
            return;
        }
        JavacNode typeNode = JavacHandlerUtil.upToTypeNode(annotationNode);
        if (!JavacHandlerUtil.isClassOrEnum(typeNode)) {
            annotationNode.addError("@Synchronized is legal only on methods in classes and enums.");
            return;
        }
        boolean[] isStatic = new boolean[1];
        isStatic[0] = (method.mods.flags & 8) != 0;
        String lockName = annotation.getInstance().value();
        boolean autoMake = false;
        if (lockName.length() == 0) {
            autoMake = true;
            lockName = isStatic[0] ? STATIC_LOCK_NAME : INSTANCE_LOCK_NAME;
        }
        JavacTreeMaker maker = methodNode.getTreeMaker().at(ast.pos);
        JavacHandlerUtil.MemberExistsResult exists = JavacHandlerUtil.MemberExistsResult.NOT_EXISTS;
        if (typeNode != null && (typeNode.get() instanceof JCTree.JCClassDecl)) {
            for (JCTree.JCVariableDecl jCVariableDecl : typeNode.get().defs) {
                if ((jCVariableDecl instanceof JCTree.JCVariableDecl) && jCVariableDecl.name.contentEquals(lockName)) {
                    exists = JavacHandlerUtil.getGeneratedBy(jCVariableDecl) == null ? JavacHandlerUtil.MemberExistsResult.EXISTS_BY_USER : JavacHandlerUtil.MemberExistsResult.EXISTS_BY_LOMBOK;
                    boolean st = (jCVariableDecl.mods.flags & 8) != 0;
                    if (isStatic[0] && !st) {
                        annotationNode.addError("The field " + lockName + " is non-static and this cannot be used on this static method");
                        return;
                    }
                    isStatic[0] = st;
                }
            }
        }
        if (exists == JavacHandlerUtil.MemberExistsResult.NOT_EXISTS) {
            if (!autoMake) {
                annotationNode.addError("The field " + lockName + " does not exist.");
                return;
            }
            JCTree.JCExpression objectType = JavacHandlerUtil.genJavaLangTypeRef(methodNode, ast.pos, "Object");
            JCTree.JCNewArray newObjectArray = maker.NewArray(JavacHandlerUtil.genJavaLangTypeRef(methodNode, ast.pos, "Object"), List.of(maker.Literal(Javac.CTC_INT, 0)), null);
            JCTree.JCVariableDecl fieldDecl = JavacHandlerUtil.recursiveSetGeneratedBy(maker.VarDef(maker.Modifiers(18 | (isStatic[0] ? 8 : 0)), methodNode.toName(lockName), objectType, newObjectArray), annotationNode);
            JavacHandlerUtil.injectFieldAndMarkGenerated(methodNode.up(), fieldDecl);
        }
        if (method.body == null) {
            return;
        }
        if (isStatic[0]) {
            lockNode = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, typeNode, methodNode.toName(lockName), false, List.nil());
        } else {
            lockNode = maker.Select(maker.Ident(methodNode.toName("this")), methodNode.toName(lockName));
        }
        JavacHandlerUtil.recursiveSetGeneratedBy(lockNode, annotationNode);
        method.body = JavacHandlerUtil.setGeneratedBy(maker.Block(0L, List.of(JavacHandlerUtil.setGeneratedBy(maker.Synchronized(lockNode, method.body), annotationNode))), annotationNode);
        methodNode.rebuild();
    }
}
