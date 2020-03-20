package com.mg.task;

import java.io.File;

/**
 * FileRename class
 *  传智播客 image 多了个名称
 * @author 谢小平
 * @date 2019-12-02
 */
public class FileRename {
    public static void main(String[] args) {
        String filePath = "E:\\BaiduYunDownload\\【瑞客论坛 www.ruike1.com】黑马 - 大数据转型 必备课程-Hadoop3\\01-Hadoop介绍和环境搭建\\assets\\";
        File file = new File(filePath);
        String name = "";
        String newName = "" ;
        for(File aFile :file.listFiles() ) {
            name = aFile.getName();
            newName = name.substring(0,name.indexOf("【")).trim() + name.substring( name.lastIndexOf(".") ,name.length()).trim();
            System.out.println(newName);
            File file1 = new File(filePath + newName);
            aFile.renameTo(file1);
        }
    }
}
