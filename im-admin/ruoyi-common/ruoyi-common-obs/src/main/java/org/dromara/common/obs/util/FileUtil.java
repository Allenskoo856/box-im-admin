package org.dromara.common.obs.util;

public final class FileUtil {

    private FileUtil() {
    }

    /**
     * 获取文件后缀
     *
     * @param fileName 文件名
     * @return 后缀
     */
    public static String getFileExtension(String fileName) {
        if (fileName == null || fileName.lastIndexOf(".") < 0) {
            return "";
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * 去除文件扩展名
     *
     * @param fileName 文件名
     * @return 无后缀文件名
     */
    public static String excludeExtension(String fileName) {
        if (fileName == null || fileName.lastIndexOf(".") < 0) {
            return fileName;
        }
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    /**
     * 判断文件是否图片类型
     *
     * @param fileName 文件名
     * @return boolean
     */
    public static boolean isImage(String fileName) {
        if (fileName == null) {
            return false;
        }
        String extension = getFileExtension(fileName);
        String[] imageExtension = new String[]{"jpeg", "jpg", "bmp", "png", "webp", "gif"};
        for (String e : imageExtension) {
            if (extension.equalsIgnoreCase(e)) {
                return true;
            }
        }
        return false;
    }
}
