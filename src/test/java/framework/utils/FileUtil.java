package framework.utils;

import framework.logger.Log;

import java.io.File;
import java.nio.file.FileSystemNotFoundException;

public class FileUtil {
    public static final String DOWNLOAD_DIRECTORY = System.getProperty("user.dir") + File.separator + "downloadFiles";
    private static File directory = new File(DOWNLOAD_DIRECTORY);

    public static void deleteDownloadDirectory() {
        Log.debug("FileUtil: удаление временного каталога загрузок с всеми файлами");
        if (directory.exists()) {
            String[] entries = directory.list();
            for (String s : entries) {
                File currentFile = new File(directory.getPath(), s);
                currentFile.delete();
            }
            directory.delete();
        }
    }

    public static void waitAllFilesDownloaded() {
        Log.debug("FileUtil: ожидание загрузки всех файлов");
        WaitUtil.getWait().until((x) -> isAllFilesDownloaded());
    }

    private static boolean isAllFilesDownloaded() {
        Log.debug("FileUtil: проверка недозагруженых файлов в директории загрузок");
        File[] files = directory.listFiles(File::isFile);
        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(".crdownload") || file.getName().endsWith(".part")) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public static File getLastDownloadedFile() {
        Log.debug("FileUtil: получение последнего скачаного файла");
        File[] files = directory.listFiles(File::isFile);
        long lastModifiedTime = Long.MIN_VALUE;
        File chosenFile = null;
        if (files != null) {
            for (File file : files) {
                if (file.lastModified() > lastModifiedTime) {
                    chosenFile = file;
                    lastModifiedTime = file.lastModified();
                }
            }
        } else {
            throw new FileSystemNotFoundException("Каталог " + DOWNLOAD_DIRECTORY + " пуст");
        }
        return chosenFile;
    }
}
