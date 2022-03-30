package com.jason.file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class MyFileUtils {
     /**
      * 修改文件内容：字符串逐行替换
      *
      * @param file：待处理的文件
      * @param oldstr：需要替换的旧字符串
      * @param newStr：用于替换的新字符串
      */
     public static boolean modifyFileContent(File file, String oldstr, String newStr) {
         List<String> list = null;
         try {
             list = FileUtils.readLines(file, "UTF-8");
             for (int i = 0; i < list.size(); i++) {
                 String temp = list.get(i).replaceAll(oldstr, newStr);
                 list.remove(i);
                 list.add(i, temp);
             }
             FileUtils.writeLines(file, "UTF-8", list, false);
         } catch (IOException e) {
             e.printStackTrace();
         }
 
         return true;
     }
 
     public static boolean modifyFileContent(String filePath, String oldstr, String newStr) {
         return modifyFileContent(new File(filePath), oldstr, newStr);
     }
     
     public static void getFileList(String dirPath, String oldstr, String newStr) {
         File dir = new File(dirPath);
         File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
         if (files != null) {
             for (int i = 0; i < files.length; i++) {
                 if (files[i].isDirectory()) { // 判断是文件还是文件夹
                     getFileList(files[i].getAbsolutePath(), oldstr, newStr); // 获取文件夹绝对路径
                 } else {
                     String strFileName = files[i].getAbsolutePath();// 获取文件绝对路径
                     System.out.println(strFileName);
                     MyFileUtils.modifyFileContent(strFileName, oldstr, newStr);
                 }
             }

         }
     }

     
     /**
      * 判断文件夹是否存在
      *   存在，无操作
      *   不存在，创建
      * @param path
      */
     private static void isExist(String path) {
 		File folder = new File(path);
 		if (!folder.exists() && !folder.isDirectory()) {
 			folder.mkdirs();
 		}
 	}
     
     public static void main(String[] args) {
    	 MyFileUtils.getFileList("", "", "");
	}
 
 }