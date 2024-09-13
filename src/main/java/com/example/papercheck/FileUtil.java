package com.example.papercheck;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 此工具类用于读取和写入文件
 */
public class FileUtil {
    /**
     * 该函数为读取文件并返回文件内容字符串，可能抛出文件不存在，记得try/catch处理
     *
     * @param filePath 要读取的文件的绝对路径
     * @return 返回该文件的读取到的字符串
     */
    public static String readFile(String filePath) throws IOException, FileIsNotTxtException {
        //1.读取文件转换为byte数组
        if (!filePath.endsWith(".txt"))
            throw new FileIsNotTxtException();
        File file = new File(filePath);
        String s;
        FileInputStream fis = new FileInputStream(file);
        int size = fis.available();
        if (size < 500) System.out.println("文件偏小，测试结果可能不太准确");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

        char[] chatBuffer = new char[size];
        isr.read(chatBuffer);
        s = new String(chatBuffer);
        fis.close();//记得关闭输入流
        return s;
    }

    public static void writeFile(String path, String content) throws IOException {
        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);
        if (!file.exists()) {
            file.createNewFile();
        }
        byte[] contentInBytes = content.getBytes();
        fos.write(contentInBytes);
        fos.flush();
        fos.close();
    }
}

