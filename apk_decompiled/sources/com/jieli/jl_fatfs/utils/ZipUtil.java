package com.jieli.jl_fatfs.utils;

import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.WatchFileUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ZipUtil {
    public static final String a = "ZipUtil";

    public static void a(String str, String str2, ZipOutputStream zipOutputStream) throws Exception {
        if (zipOutputStream == null) {
            return;
        }
        File file = new File(str + str2);
        if (!file.isFile()) {
            String[] list = file.list();
            if (list != null) {
                if (list.length <= 0) {
                    zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                    zipOutputStream.closeEntry();
                }
                for (String str3 : list) {
                    a(str, str2 + File.separator + str3, zipOutputStream);
                }
                return;
            }
            return;
        }
        ZipEntry zipEntry = new ZipEntry(str2);
        FileInputStream fileInputStream = new FileInputStream(file);
        zipOutputStream.putNextEntry(zipEntry);
        byte[] bArr = new byte[4096];
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                zipOutputStream.closeEntry();
                return;
            }
            zipOutputStream.write(bArr, 0, i);
        }
    }

    public static List<File> getFileList(String str, boolean z, boolean z2) throws Exception {
        ArrayList arrayList = new ArrayList();
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipInputStream.close();
                return arrayList;
            }
            String name = nextEntry.getName();
            if (nextEntry.isDirectory()) {
                File file = new File(name.substring(0, name.length() - 1));
                if (z) {
                    arrayList.add(file);
                }
            } else {
                File file2 = new File(name);
                if (z2) {
                    arrayList.add(file2);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0117  */
    /* JADX WARN: Code duplicated, block: B:45:0x0127 A[LOOP:1: B:43:0x0120->B:45:0x0127, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:60:0x0133 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x012e A[EDGE_INSN: B:69:0x012e->B:46:0x012e BREAK  A[LOOP:1: B:43:0x0120->B:45:0x0127], SYNTHETIC] */
    public static void unZipFolder(String str, String str2) throws Exception {
        String canonicalPath;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        int i;
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipInputStream.close();
                return;
            }
            String name = nextEntry.getName();
            if (name.contains("../")) {
                throw new SecurityException("unZipFolder : Invalid path." + name);
            }
            if (nextEntry.isDirectory()) {
                String str3 = str2 + File.separator + name.substring(0, name.length() - 1);
                File file = new File(str3);
                if (file.exists()) {
                    if (!WatchFileUtil.deleteFile(str3)) {
                        JL_Log.d(a, "unZipFolder", "Failed to delete folder. " + str3);
                    }
                } else if (!file.mkdirs()) {
                    JL_Log.d(a, "unZipFolder", "mkdirs failed." + str3);
                }
                String canonicalPath2 = file.getCanonicalPath();
                if (!canonicalPath2.startsWith(str2)) {
                    throw new SecurityException("unZipFolder : mkdir failed." + canonicalPath2);
                }
            } else {
                String str4 = str2 + File.separator + name;
                JL_Log.d(a, "unZipFolder", "path : " + str4);
                File file2 = new File(str4);
                if (!file2.exists()) {
                    for (File parentFile = file2.getParentFile(); parentFile != null && (parentFile.exists() || parentFile.mkdirs()); parentFile = parentFile.getParentFile()) {
                    }
                    if (file2.createNewFile()) {
                        canonicalPath = file2.getCanonicalPath();
                        if (canonicalPath.startsWith(str2)) {
                            throw new SecurityException("unZipFolder : create file failed." + canonicalPath);
                        }
                        fileOutputStream = new FileOutputStream(file2);
                        bArr = new byte[1024];
                        while (true) {
                            i = zipInputStream.read(bArr);
                            if (i != -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i);
                            fileOutputStream.flush();
                        }
                        fileOutputStream.close();
                    } else {
                        continue;
                    }
                } else if (!file2.delete() || file2.createNewFile()) {
                    canonicalPath = file2.getCanonicalPath();
                    if (canonicalPath.startsWith(str2)) {
                        throw new SecurityException("unZipFolder : create file failed." + canonicalPath);
                    }
                    fileOutputStream = new FileOutputStream(file2);
                    bArr = new byte[1024];
                    while (true) {
                        i = zipInputStream.read(bArr);
                        if (i != -1) {
                            break;
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i);
                            fileOutputStream.flush();
                        }
                    }
                    fileOutputStream.close();
                }
            }
        }
    }

    public static InputStream upZip(String str, String str2) throws Exception {
        ZipFile zipFile = new ZipFile(str);
        return zipFile.getInputStream(zipFile.getEntry(str2));
    }

    public static void zipFolder(String str, String str2) throws Exception {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
        File file = new File(str);
        a(file.getParent() + File.separator, file.getName(), zipOutputStream);
        zipOutputStream.finish();
        zipOutputStream.close();
    }

    public static void unZipFolder(String str, String str2, String str3) throws Exception {
        File file = new File(str2, str3);
        if (file.exists()) {
            WatchFileUtil.deleteFile(file.getPath());
        }
        if (file.mkdirs()) {
            str2 = file.getPath();
        }
        unZipFolder(str, str2);
    }
}
