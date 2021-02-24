package com.watayouxiang.androidutils;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/08/13
 *     desc   : File 工具
 * </pre>
 */
public class FileUtils {
    /**
     * 列出 "目录" 下的所有 "文件和目录"
     *
     * @param dir 目录
     */
    @Nullable
    public static File[] listFiles(@NonNull File dir) {
        return listFiles(dir, null, null);
    }

    /**
     * 列出 "目录" 下的所有 "文件和目录"
     *
     * @param dir            目录
     * @param filenameFilter {@link FilenameFilter}
     */
    @Nullable
    public static File[] listFiles(@NonNull File dir, @Nullable FilenameFilter filenameFilter) {
        return listFiles(dir, filenameFilter, null);
    }

    /**
     * 列出 "目录" 下的所有 "文件和目录"
     *
     * @param dir        目录
     * @param fileFilter {@link FileFilter}
     */
    @Nullable
    public static File[] listFiles(@NonNull File dir, @Nullable FileFilter fileFilter) {
        return listFiles(dir, null, fileFilter);
    }

    /**
     * 列出 "目录" 下的所有 "文件和目录"
     *
     * @param dir            目录
     * @param filenameFilter {@link FilenameFilter}
     * @param fileFilter     {@link FileFilter}
     */
    @Nullable
    private static File[] listFiles(@NonNull File dir, @Nullable FilenameFilter filenameFilter, @Nullable FileFilter fileFilter) {
        File[] files;
        if (filenameFilter != null) {
            files = dir.listFiles(filenameFilter);
        } else if (fileFilter != null) {
            files = dir.listFiles(fileFilter);
        } else {
            files = dir.listFiles();
        }
        return files;
    }

    /**
     * 列出 "目录" 下的所有 "文件名/目录名"
     *
     * @param dir 目录
     */
    @Nullable
    public static String[] list(@NonNull File dir) {
        return list(dir, null);
    }

    /**
     * 列出 "目录" 下的所有 "文件名/目录名"
     *
     * @param dir            目录
     * @param filenameFilter {@link FilenameFilter}
     */
    @Nullable
    public static String[] list(@NonNull File dir, @Nullable final FilenameFilter filenameFilter) {
        String[] list;
        if (filenameFilter != null) {
            list = dir.list(filenameFilter);
        } else {
            list = dir.list();
        }
        return list;
    }

    /**
     * 文件/目录 是否存在
     */
    public static boolean exists(@NonNull File file) {
        return file.exists();
    }

    /**
     * 是否为 文件
     */
    public static boolean isFile(@NonNull File file) {
        return file.isFile();
    }

    /**
     * 是否为 目录
     */
    public static boolean isDirectory(@NonNull File file) {
        return file.isDirectory();
    }

    /**
     * 获取 相对路径
     */
    @NonNull
    public static String getPath(@NonNull File file) {
        return file.getPath();
    }

    /**
     * 获取 绝对路径
     */
    @NonNull
    public static String getAbsolutePath(@NonNull File file) {
        return file.getAbsolutePath();
    }

    /**
     * 修改 文件/目录
     * <p>
     * 修改文件：文件 --> 文件
     * 修改目录：目录 --> 目录
     * <p>
     * 修改失败情况：dest 已经存在
     *
     * @return 是否修改成功
     */
    public static boolean renameTo(@NonNull File src, @NonNull File dest) {
        return src.renameTo(dest);
    }

    /**
     * 创建 文件
     *
     * @param file 文件
     * @return 是否创建成功
     */
    public static boolean createNewFile(@NonNull File file) {
        boolean ok = false;
        try {
            ok = file.createNewFile();
        } catch (IOException e) {
            LogUtils.e(e);
        }
        return ok;
    }

    /**
     * 创建 目录
     *
     * @param dir 目录
     * @return 是否创建成功
     */
    public static boolean mkdirs(@NonNull File dir) {
        return dir.mkdirs();
    }

    /**
     * 删除 文件/目录
     * <p>
     * 删除失败情况：文件正在使用中
     *
     * @return 是否删除成功
     */
    public static boolean delete(@NonNull File file) {
        boolean isDelete = false;
        if (file.isFile()) {
            isDelete = file.delete();
        } else if (file.isDirectory()) {
            // 先删除 目录内的 "文件/目录"
            File[] fs = file.listFiles();
            if (fs != null) {
                for (File f : fs) {
                    delete(f);
                }
            }
            // 再删除 目录自己
            isDelete = file.delete();
        }
        return isDelete;
    }

    /**
     * 将 srcFile 的目录结构保存到 destFile 中
     *
     * @param srcFile  源 文件/目录
     * @param destFile 目标 文件/目录
     * @param symbol   层级符号
     */
    public static void saveStructures(@NonNull File srcFile, @NonNull File destFile, @NonNull String symbol) {
        PrintStream printStream = null;
        try {
            // 获取 srcFile 的目录结构
            List<String> structures = getStructures(srcFile, symbol);
            // 将目录结构输出到 destFile
            printStream = new PrintStream(new BufferedOutputStream(new FileOutputStream(destFile)));
            for (String structure : structures) {
                printStream.println(structure);
            }
        } catch (FileNotFoundException e) {
            LogUtils.e(e);
        } finally {
            if (printStream != null) {
                printStream.close();
            }
        }
    }

    /**
     * 打印目录结构
     *
     * @param file   文件/目录
     * @param symbol 层级符号
     */
    public static void printlnStructures(@NonNull File file, @NonNull String symbol) {
        List<String> structure = getStructures(file, symbol);
        CollectionUtils.println(structure);
    }

    /**
     * 获取目录结构
     *
     * @param file   文件/目录
     * @param symbol 层级符号
     */
    @NonNull
    public static List<String> getStructures(@NonNull File file, @NonNull String symbol) {
        List<String> list = new ArrayList<>();
        getStructures(file, symbol, 0, list);
        return list;
    }

    /**
     * 获取目录结构
     *
     * @param file          文件/目录
     * @param symbol        层级符号
     * @param level         层级数
     * @param fileStructure 文件结构
     * @throws SecurityException 如果文件不可访问，则报 SecurityException
     */
    private static void getStructures(@NonNull File file, @NonNull String symbol, int level,
                                      @NonNull List<String> fileStructure) throws SecurityException {
        fileStructure.add(getSymbol(symbol, level) + file.getName());
        level++;

        // 目录为空、此抽象路径名不表示目录、出现I/O错误，返回为null
        // 如果该目录不可访问，则报 SecurityException
        File[] files = file.listFiles();
        if (files == null) return;

        for (File f : files) {
            // 如果目录下还有目录，那么递归遍历
            getStructures(f, symbol, level, fileStructure);
        }
    }

    /**
     * 获取标签
     *
     * @param symbol 层级符号
     * @param level  层级数
     */
    @NonNull
    private static String getSymbol(@NonNull String symbol, @IntRange(from = 0) int level) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < level; i++) {
            builder.append(symbol);
        }
        return builder.toString();
    }

    /**
     * 判断文件是否存在，不存在创建，然后则判断是否创建成功
     */
    public static boolean createOrExistsFile(@NonNull File file) {
        // 文件存在性 判断
        if (file.exists()) return file.isFile();
        // 确保 文件目录存在
        if (!createOrExistsDir(file.getParentFile())) return false;
        // 创建文件
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断目录是否存在，不存在创建，然后则判断是否创建成功
     */
    public static boolean createOrExistsDir(@NonNull final File dir) {
        return dir.exists() ? dir.isDirectory() : dir.mkdirs();
    }
}
