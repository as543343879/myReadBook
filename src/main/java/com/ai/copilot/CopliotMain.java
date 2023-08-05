package com.ai.copilot;

import cn.hutool.core.util.ZipUtil;
import com.google.common.io.Files;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * CopliotMain class
 *
 * @author 谢小平
 * @date 2023/6/19
 */
public class CopliotMain {
    public static void main(String[] args) {
        File unzip = null;
        try {
//            File tempFile = File.createTempFile ("prefix", "suffix");
            File tempFile2 = File.createTempFile ("prefix", "");
            // 创建临时文件夹
            File tempDir = Files.createTempDir();
            unzip = ZipUtil.unzip(new File("C:\\Users\\lizhi\\Downloads\\sp_ludo_reset_boom.zip"), tempDir);
            File[] files = unzip.listFiles();
            System.out.println(unzip);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                FileUtils.deleteDirectory(unzip);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            unzip.deleteOnExit();
        }
        System.out.println("Hello World!");


    }

    public static void deleteDirectory(File directoryToDelete) throws Exception {
        File[] files = directoryToDelete.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    if (!file.delete()) {
                        throw new Exception("Failed to delete file: " + file);
                    }
                }
            }
        }

        if (!directoryToDelete.delete()) {
            throw new Exception("Failed to delete directory: " + directoryToDelete);
        }
    }
}
