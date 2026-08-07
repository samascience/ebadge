package defpackage;

import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes4.dex */
class pn2 extends ClassLoader {
    private static final ConcurrentMap l = new ConcurrentHashMap();
    private static final Map m = new WeakHashMap();
    private static final Map n = new WeakHashMap();
    private final String a;
    private final File b;
    private final int c;
    private final List d;
    private final String e;
    private final List f;
    private final List g;
    private final Set h;
    private final Map i;
    private Map j;
    private Map k;

    /* JADX WARN: Code duplicated, block: B:56:0x0174  */
    pn2(ClassLoader classLoader, String str, String str2, List list, List list2) {
        super(classLoader);
        this.d = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = Collections.newSetFromMap(new IdentityHashMap());
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = new HashMap();
        this.e = str;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String strReplace = ((String) it.next()).replace(FileUtils.FILE_EXTENSION_SEPARATOR, WatchConstant.FAT_FS_ROOT);
                if (!strReplace.endsWith(WatchConstant.FAT_FS_ROOT)) {
                    strReplace = strReplace + WatchConstant.FAT_FS_ROOT;
                }
                this.f.add(strReplace);
            }
        }
        if (list2 != null) {
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                this.g.add((String) it2.next());
            }
        }
        if (str2 != null) {
            this.a = str2;
            this.c = str2.length();
        } else {
            URL resource = pn2.class.getResource("ShadowClassLoader.class");
            String string = resource == null ? null : resource.toString();
            if (string == null || !string.endsWith("lombok/launch/ShadowClassLoader.class")) {
                ClassLoader classLoader2 = pn2.class.getClassLoader();
                StringBuilder sb = new StringBuilder("ShadowLoader can't find itself. SCL loader type: ");
                sb.append(classLoader2 == null ? "*NULL*" : classLoader2.getClass().toString());
                throw new RuntimeException(sb.toString());
            }
            int length = string.length() - 37;
            this.c = length;
            this.a = o(string.substring(0, length));
        }
        if (this.a.startsWith("jar:file:") && this.a.endsWith("!/")) {
            String str3 = this.a;
            this.b = new File(str3.substring(9, str3.length() - 2));
        } else if (this.a.startsWith("file:")) {
            this.b = new File(this.a.substring(5));
        } else {
            this.b = new File(this.a);
        }
        String property = System.getProperty("shadow.override." + str);
        if (property == null || property.isEmpty()) {
            return;
        }
        StringBuilder sb2 = new StringBuilder("\\s*");
        sb2.append(File.pathSeparatorChar == ';' ? ";" : ":");
        sb2.append("\\s*");
        for (String str4 : property.split(sb2.toString())) {
            if (str4.endsWith("/*")) {
                b(str4.substring(0, str4.length() - 2));
            } else {
                if (str4.endsWith(String.valueOf(File.separator) + Marker.ANY_MARKER)) {
                    b(str4.substring(0, str4.length() - 2));
                } else {
                    a(str4);
                }
            }
        }
    }

    private boolean c(String str) {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            if (str.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private Set d(String str) {
        try {
            JarFile jarFile = new JarFile(str);
            int iHighestOneBit = Integer.highestOneBit(jarFile.size());
            if (iHighestOneBit != jarFile.size()) {
                iHighestOneBit <<= 1;
            }
            if (iHighestOneBit == 0) {
                iHighestOneBit = 1;
            }
            HashSet hashSet = new HashSet(iHighestOneBit >> 1, 2);
            try {
                Enumeration<JarEntry> enumerationEntries = jarFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                    if (!jarEntryNextElement.isDirectory()) {
                        hashSet.add(jarEntryNextElement.getName());
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                jarFile.close();
                throw th;
            }
            jarFile.close();
            return hashSet;
        } catch (Exception unused2) {
            return Collections.emptySet();
        }
    }

    private Set e(String str) {
        Map map = m;
        synchronized (map) {
            try {
                Object obj = this.i.get(str);
                if (obj != null) {
                    return (Set) n.get(obj);
                }
                for (Map.Entry entry : map.entrySet()) {
                    if (((String) entry.getValue()).equals(str)) {
                        Object key = entry.getKey();
                        this.i.put(str, key);
                        return (Set) n.get(key);
                    }
                }
                Object obj2 = new Object();
                Set setD = d(str);
                n.put(obj2, setD);
                m.put(obj2, str);
                this.i.put(str, obj2);
                return setD;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private URL f(String str, String str2, File file) {
        File absoluteFile;
        File file2;
        if (file.isDirectory()) {
            if (str2 != null) {
                try {
                    File file3 = new File(file, str2);
                    if (file3.isFile() && file3.canRead()) {
                        return file3.toURI().toURL();
                    }
                    file2 = new File(file, str);
                    if (file2.isFile() && file2.canRead()) {
                        return file2.toURI().toURL();
                    }
                } catch (MalformedURLException unused) {
                }
            } else {
                file2 = new File(file, str);
                if (file2.isFile()) {
                    return file2.toURI().toURL();
                }
            }
            return null;
        }
        if (file.isFile() && file.canRead()) {
            try {
                absoluteFile = file.getCanonicalFile();
            } catch (Exception unused2) {
                absoluteFile = file.getAbsoluteFile();
            }
            Set setE = e(absoluteFile.getAbsolutePath());
            String string = absoluteFile.toURI().toString();
            try {
                if (setE.contains(str2)) {
                    return new URI("jar:" + string + "!/" + str2).toURL();
                }
            } catch (Exception unused3) {
            }
            try {
                if (setE.contains(str)) {
                    return new URI("jar:" + string + "!/" + str).toURL();
                }
            } catch (Exception unused4) {
            }
        }
        return null;
    }

    private URL g(String str) throws IOException {
        URL resource = super.getResource(str);
        if (resource == null) {
            return null;
        }
        if (!m(resource.toString(), str)) {
            return resource;
        }
        Enumeration<URL> resources = super.getResources(str);
        while (resources.hasMoreElements()) {
            URL urlNextElement = resources.nextElement();
            if (!m(urlNextElement.toString(), str)) {
                return urlNextElement;
            }
        }
        return null;
    }

    private URL h(String str, boolean z) {
        String str2;
        URL resource;
        if (str.endsWith(".class")) {
            str2 = String.valueOf(str.substring(0, str.length() - 6)) + ".SCL." + this.e;
        } else {
            str2 = null;
        }
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            URL urlF = f(str, str2, (File) it.next());
            if (urlF != null) {
                return urlF;
            }
        }
        if (!this.d.isEmpty()) {
            if (z) {
                return null;
            }
            if (str2 != null) {
                try {
                    URL urlG = g(str2);
                    if (urlG != null) {
                        return urlG;
                    }
                } catch (IOException unused) {
                }
            }
            try {
                return g(str);
            } catch (IOException unused2) {
                return null;
            }
        }
        URL urlF2 = f(str, str2, this.b);
        if (urlF2 != null) {
            return urlF2;
        }
        if (str2 != null && (resource = super.getResource(str2)) != null && (!z || m(resource.toString(), str2))) {
            return resource;
        }
        URL resource2 = super.getResource(str);
        if (resource2 == null || (z && !m(resource2.toString(), str))) {
            return null;
        }
        return resource2;
    }

    private boolean i(String str, String str2) {
        return str != null && str.length() == this.c + str2.length() && this.a.regionMatches(0, str, 0, this.c);
    }

    private boolean j(String str, String str2, String str3) {
        int iIndexOf;
        if (str == null) {
            return false;
        }
        if (!str.startsWith("file:/")) {
            if (!str.startsWith("jar:") || (iIndexOf = str.indexOf(33)) == -1) {
                return false;
            }
            return l(str.substring(4, iIndexOf), str3);
        }
        String strO = o(str.substring(5));
        if (strO.length() > str2.length() && strO.endsWith(str2) && strO.charAt((strO.length() - str2.length()) - 1) == '/') {
            return k(strO.substring(0, (strO.length() - str2.length()) - 1), str3);
        }
        return false;
    }

    private boolean k(String str, String str2) {
        String str3 = String.valueOf(str) + "::" + str2;
        Boolean bool = (Boolean) this.j.get(str3);
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(String.valueOf(str) + "/META-INF/ShadowClassLoader"));
            try {
                boolean zN = n(fileInputStream, str2);
                this.j.put(str3, Boolean.valueOf(zN));
                return zN;
            } finally {
                fileInputStream.close();
            }
        } catch (FileNotFoundException unused) {
            this.j.put(str3, Boolean.FALSE);
            return false;
        } catch (IOException unused2) {
            this.j.put(str3, Boolean.FALSE);
            return false;
        }
    }

    private boolean l(String str, String str2) {
        ZipEntry nextEntry;
        String str3 = String.valueOf(str) + "::" + str2;
        Boolean bool = (Boolean) this.k.get(str3);
        if (bool != null) {
            return bool.booleanValue();
        }
        if (str.startsWith("file:/")) {
            str = o(str.substring(5));
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
                do {
                    try {
                        nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            this.k.put(str3, Boolean.FALSE);
                            zipInputStream.close();
                            fileInputStream.close();
                            return false;
                        }
                    } catch (Throwable th) {
                        zipInputStream.close();
                        throw th;
                    }
                } while (!"META-INF/ShadowClassLoader".equals(nextEntry.getName()));
                boolean zN = n(zipInputStream, str2);
                this.k.put(str3, Boolean.valueOf(zN));
                zipInputStream.close();
                fileInputStream.close();
                return zN;
            } catch (Throwable th2) {
                fileInputStream.close();
                throw th2;
            }
        } catch (FileNotFoundException unused) {
            this.k.put(str3, Boolean.FALSE);
            return false;
        } catch (IOException unused2) {
            this.k.put(str3, Boolean.FALSE);
            return false;
        }
    }

    private boolean m(String str, String str2) {
        if (str2.startsWith("java/") || str2.startsWith("sun/")) {
            return false;
        }
        return i(str, str2) || j(str, str2, this.e);
    }

    private static boolean n(InputStream inputStream, String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Constants.ENC_UTF_8));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return false;
            }
            String strTrim = line.trim();
            if (!strTrim.isEmpty() && strTrim.charAt(0) != '#' && strTrim.equals(str)) {
                return true;
            }
        }
    }

    private static String o(String str) {
        try {
            return URLDecoder.decode(str.replaceAll("\\+", "%2B"), Constants.ENC_UTF_8);
        } catch (UnsupportedEncodingException unused) {
            throw new InternalError("UTF-8 not supported");
        }
    }

    private Class p(String str, URL url, boolean z) throws ClassNotFoundException {
        Class<?> clsDefineClass;
        Class cls;
        Class<?> cls2;
        try {
            InputStream inputStreamOpenStream = url.openStream();
            try {
                byte[] bArr = new byte[65536];
                int i = 0;
                while (true) {
                    int i2 = inputStreamOpenStream.read(bArr, i, bArr.length - i);
                    if (i2 == -1) {
                        break;
                    }
                    i += i2;
                    if (i == bArr.length) {
                        byte[] bArr2 = new byte[bArr.length * 2];
                        System.arraycopy(bArr, 0, bArr2, 0, i);
                        bArr = bArr2;
                    }
                }
                inputStreamOpenStream.close();
                try {
                    clsDefineClass = defineClass(str, bArr, 0, i);
                } catch (LinkageError e) {
                    if (this.g.contains(str) && (cls = (Class) l.get(str)) != null) {
                        return cls;
                    }
                    try {
                        Class<?> clsFindLoadedClass = findLoadedClass(str);
                        if (clsFindLoadedClass == null) {
                            throw e;
                        }
                        clsDefineClass = clsFindLoadedClass;
                    } catch (LinkageError unused) {
                        throw e;
                    }
                }
                if (this.g.contains(str) && (cls2 = (Class) l.putIfAbsent(str, clsDefineClass)) != null) {
                    clsDefineClass = cls2;
                }
                if (z) {
                    resolveClass(clsDefineClass);
                }
                return clsDefineClass;
            } catch (Throwable th) {
                inputStreamOpenStream.close();
                throw th;
            }
        } catch (IOException e2) {
            throw new ClassNotFoundException("I/O exception reading class " + str, e2);
        }
    }

    public void a(String str) {
        this.d.add(new File(str));
    }

    public void b(String str) {
        for (File file : new File(str).listFiles()) {
            if (file.getName().toLowerCase().endsWith(".jar") && file.canRead() && file.isFile()) {
                this.d.add(file);
            }
        }
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String str) {
        return h(str, false);
    }

    @Override // java.lang.ClassLoader
    public Enumeration getResources(String str) throws IOException {
        String str2;
        URL urlF;
        if (str.endsWith(".class")) {
            str2 = String.valueOf(str.substring(0, str.length() - 6)) + ".SCL." + this.e;
        } else {
            str2 = null;
        }
        Vector vector = new Vector();
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            URL urlF2 = f(str, str2, (File) it.next());
            if (urlF2 != null) {
                vector.add(urlF2);
            }
        }
        if (this.d.isEmpty() && (urlF = f(str, str2, this.b)) != null) {
            vector.add(urlF);
        }
        Enumeration<URL> resources = super.getResources(str);
        while (resources.hasMoreElements()) {
            URL urlNextElement = resources.nextElement();
            if (j(urlNextElement.toString(), str, this.e)) {
                vector.add(urlNextElement);
            }
        }
        if (str2 != null) {
            Enumeration<URL> resources2 = super.getResources(str2);
            while (resources2.hasMoreElements()) {
                URL urlNextElement2 = resources2.nextElement();
                if (j(urlNextElement2.toString(), str2, this.e)) {
                    vector.add(urlNextElement2);
                }
            }
        }
        return vector.elements();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Class] */
    @Override // java.lang.ClassLoader
    public Class loadClass(String str, boolean z) throws ClassNotFoundException {
        Class cls;
        Class<?> clsFindLoadedClass = findLoadedClass(str);
        if (clsFindLoadedClass != null) {
            return clsFindLoadedClass;
        }
        if (this.g.contains(str) && (cls = (Class) l.get(str)) != null) {
            return cls;
        }
        String str2 = String.valueOf(str.replace(FileUtils.FILE_EXTENSION_SEPARATOR, WatchConstant.FAT_FS_ROOT)) + ".class";
        URL urlH = h(str2, true);
        String str3 = str;
        if (urlH == null && !c(str2)) {
            try {
                str3 = str;
                Iterator it = this.h.iterator();
                while (it.hasNext()) {
                    Class<?> clsLoadClass = ((ClassLoader) it.next()).loadClass(str);
                    if (clsLoadClass != null) {
                        return clsLoadClass;
                    }
                }
                str = super.loadClass(str, z);
                return str;
            } catch (ClassNotFoundException e) {
                urlH = h("secondaryLoading.SCL." + this.e + WatchConstant.FAT_FS_ROOT + str.replace(FileUtils.FILE_EXTENSION_SEPARATOR, WatchConstant.FAT_FS_ROOT) + ".SCL." + this.e, true);
                str3 = str;
                if (urlH == null) {
                    throw e;
                }
            }
        }
        if (urlH != null) {
            return p(str3, urlH, z);
        }
        throw new ClassNotFoundException(str3);
    }
}
