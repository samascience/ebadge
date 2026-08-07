package lombok.javac;

import com.sun.source.tree.LabeledStatementTree;
import com.sun.source.tree.VariableTree;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeCopier;
import com.sun.tools.javac.tree.TreeScanner;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/javac/TreeMirrorMaker.SCL.lombok */
public class TreeMirrorMaker extends TreeCopier<Void> {
    private final IdentityHashMap<JCTree, JCTree> originalToCopy;

    public TreeMirrorMaker(JavacTreeMaker maker, Context context) {
        super(maker.getUnderlyingTreeMaker());
        this.originalToCopy = new IdentityHashMap<>();
    }

    public <T extends JCTree> T copy(T t) {
        T t2 = (T) super.copy(t);
        putIfAbsent(this.originalToCopy, t, t2);
        return t2;
    }

    public <T extends JCTree> T copy(T t, Void r7) {
        T t2 = (T) super.copy(t, r7);
        putIfAbsent(this.originalToCopy, t, t2);
        return t2;
    }

    public <T extends JCTree> List<T> copy(List<T> originals) {
        List<T> copies = super.copy(originals);
        if (originals != null) {
            Iterator<T> it1 = originals.iterator();
            Iterator<T> it2 = copies.iterator();
            while (it1.hasNext()) {
                putIfAbsent(this.originalToCopy, it1.next(), it2.next());
            }
        }
        return copies;
    }

    public <T extends JCTree> List<T> copy(List<T> originals, Void p) {
        List<T> copies = super.copy(originals, p);
        if (originals != null) {
            Iterator<T> it1 = originals.iterator();
            Iterator<T> it2 = copies.iterator();
            while (it1.hasNext()) {
                putIfAbsent(this.originalToCopy, it1.next(), it2.next());
            }
        }
        return copies;
    }

    public Map<JCTree, JCTree> getOriginalToCopyMap() {
        return Collections.unmodifiableMap(this.originalToCopy);
    }

    public JCTree visitVariable(VariableTree node, Void p) {
        JCTree.JCVariableDecl original = node instanceof JCTree.JCVariableDecl ? (JCTree.JCVariableDecl) node : null;
        JCTree.JCVariableDecl copy = super.visitVariable(node, p);
        if (original == null) {
            return copy;
        }
        copy.sym = original.sym;
        if (copy.sym != null) {
            copy.type = original.type;
        }
        if (copy.type != null) {
            boolean wipeSymAndType = copy.type.isErroneous();
            if (!wipeSymAndType) {
                JavacTreeMaker.TypeTag typeTag = JavacTreeMaker.TypeTag.typeTag(copy.type);
                wipeSymAndType = Javac.CTC_NONE.equals(typeTag) || Javac.CTC_ERROR.equals(typeTag) || Javac.CTC_UNKNOWN.equals(typeTag) || Javac.CTC_UNDETVAR.equals(typeTag);
            }
            if (wipeSymAndType) {
                copy.sym = null;
                copy.type = null;
            } else if (original.vartype != null) {
                copy.vartype.type = original.vartype.type;
                original.vartype.accept(new TreeScanner() { // from class: lombok.javac.TreeMirrorMaker.1
                    public void scan(JCTree tree) {
                        super.scan(tree);
                        ((JCTree) TreeMirrorMaker.this.originalToCopy.get(tree)).type = tree.type;
                    }

                    public void visitSelect(JCTree.JCFieldAccess tree) {
                        super.visitSelect(tree);
                        ((JCTree.JCFieldAccess) TreeMirrorMaker.this.originalToCopy.get(tree)).sym = tree.sym;
                    }
                });
            }
        }
        return copy;
    }

    public JCTree visitLabeledStatement(LabeledStatementTree node, Void p) {
        return (JCTree) node.getStatement().accept(this, p);
    }

    private <K, V> void putIfAbsent(Map<K, V> map, K key, V value) {
        if (!map.containsKey(key)) {
            map.put(key, value);
        }
    }
}
