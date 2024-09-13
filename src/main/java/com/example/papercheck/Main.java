package com.example.papercheck;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        String simHash0;
        String simHash1;
        String str0;
        String str1;
        if (args.length < 3) return;
        try {
            str0 = FileUtil.readFile(args[0]);
            str1 = FileUtil.readFile(args[1]);
        } catch (IOException e) {
            System.out.println("找不到指定文件");
            return;
        } catch (FileIsNotTxtException e) {
            System.out.println("文件格式错误");
            return;
        }

        simHash0 = SimHashUtil.getSimHash(str0);
        simHash1 = SimHashUtil.getSimHash(str1);

        double similarity = SimHashUtil.getSimilarity(simHash0, simHash1);
        System.out.print("相似度: ");
        System.out.println(similarity);
        try {
            FileUtil.writeFile(args[2], String.valueOf(similarity));
            System.out.println("结果写入文件 "+args[2]+" 完成");
        } catch (IOException e) {
        }
        System.out.println("计算结束，程序自动退出");
        return;
    }

}
