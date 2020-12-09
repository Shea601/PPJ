package edu.cdu.ppj.chapter8.one;

import java.io.File;

public class FindFile {
    public static void main(String[] args) {
        File file = new File("D:\\IdeaProjects");
        int level = 0;
        System.out.println(printLevel(level)+file.getName());
        printListFiles(file,level+1);
    }

    private static  String printLevel(int level){
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (int i = 0; i<level;i++){
            sb.append("————");
        }
        return sb.toString();
    }

    private static void printListFiles(File file, int level){
        //file 有可能是目录，文件
        if(file.isDirectory()){
            //列出当前目录下所有文件（目录，文件）
            File[] files = file.listFiles();
            if(files !=null){
                //System.out.println("1111");
                for(File f:files){
                    System.out.println(printLevel(level)+f.getName());
                    printListFiles(f,level+1);
                }
            }
        }
    }
}