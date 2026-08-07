package lombok.javac;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.List;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import lombok.core.ImportList;
import lombok.core.LombokInternalAliasing;
import org.slf4j.Marker;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/javac/JavacImportList.SCL.lombok */
public class JavacImportList implements ImportList {
    private final String pkgStr;
    private final List<JCTree> defs;

    public JavacImportList(JCTree.JCCompilationUnit cud) {
        this.pkgStr = PackageName.getPackageName(cud);
        this.defs = cud.defs;
    }

    @Override // lombok.core.ImportList
    public String getFullyQualifiedNameForSimpleName(String unqualified) {
        String q2 = getFullyQualifiedNameForSimpleNameNoAliasing(unqualified);
        if (q2 == null) {
            return null;
        }
        return LombokInternalAliasing.processAliases(q2);
    }

    @Override // lombok.core.ImportList
    public String getFullyQualifiedNameForSimpleNameNoAliasing(String unqualified) {
        Iterator it = this.defs.iterator();
        while (it.hasNext()) {
            JCTree.JCImport jCImport = (JCTree) it.next();
            if (jCImport instanceof JCTree.JCImport) {
                JCTree.JCFieldAccess jCFieldAccess = jCImport.qualid;
                if (jCFieldAccess instanceof JCTree.JCFieldAccess) {
                    String simpleName = jCFieldAccess.name.toString();
                    if (simpleName.equals(unqualified)) {
                        return jCFieldAccess.toString();
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    @Override // lombok.core.ImportList
    public boolean hasStarImport(String packageName) {
        if ((this.pkgStr != null && this.pkgStr.equals(packageName)) || "java.lang".equals(packageName)) {
            return true;
        }
        Iterator it = this.defs.iterator();
        while (it.hasNext()) {
            JCTree.JCImport jCImport = (JCTree) it.next();
            if ((jCImport instanceof JCTree.JCImport) && !jCImport.staticImport) {
                JCTree.JCFieldAccess jCFieldAccess = jCImport.qualid;
                if (jCFieldAccess instanceof JCTree.JCFieldAccess) {
                    String simpleName = jCFieldAccess.name.toString();
                    if (Marker.ANY_MARKER.equals(simpleName)) {
                        String starImport = jCFieldAccess.selected.toString();
                        if (packageName.equals(starImport)) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    @Override // lombok.core.ImportList
    public Collection<String> applyNameToStarImports(String startsWith, String name) {
        ArrayList<String> out = new ArrayList<>();
        if (this.pkgStr != null && topLevelName(this.pkgStr).equals(startsWith)) {
            out.add(String.valueOf(this.pkgStr) + FileUtils.FILE_EXTENSION_SEPARATOR + name);
        }
        Iterator it = this.defs.iterator();
        while (it.hasNext()) {
            JCTree.JCImport jCImport = (JCTree) it.next();
            if ((jCImport instanceof JCTree.JCImport) && !jCImport.staticImport) {
                JCTree.JCFieldAccess jCFieldAccess = jCImport.qualid;
                if (jCFieldAccess instanceof JCTree.JCFieldAccess) {
                    String simpleName = jCFieldAccess.name.toString();
                    if (Marker.ANY_MARKER.equals(simpleName)) {
                        String topLevelName = topLevelName((JCTree) jCFieldAccess);
                        if (topLevelName.equals(startsWith)) {
                            out.add(String.valueOf(jCFieldAccess.selected.toString()) + FileUtils.FILE_EXTENSION_SEPARATOR + name);
                        }
                    }
                }
            }
        }
        return out;
    }

    private String topLevelName(JCTree tree) {
        while (tree instanceof JCTree.JCFieldAccess) {
            tree = ((JCTree.JCFieldAccess) tree).selected;
        }
        return tree.toString();
    }

    private String topLevelName(String packageName) {
        int idx = packageName.indexOf(FileUtils.FILE_EXTENSION_SEPARATOR);
        return idx == -1 ? packageName : packageName.substring(0, idx);
    }

    @Override // lombok.core.ImportList
    public String applyUnqualifiedNameToPackage(String unqualified) {
        return this.pkgStr == null ? unqualified : String.valueOf(this.pkgStr) + FileUtils.FILE_EXTENSION_SEPARATOR + unqualified;
    }
}
