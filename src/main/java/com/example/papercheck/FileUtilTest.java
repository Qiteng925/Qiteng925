package com.example.papercheck;

import org.junit.Test;

import java.io.IOException;

public class FileUtilTest {
    @Test
    public void test01(){
        try {
            FileUtil.readFile("/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/aaa.txt");
        } catch (IOException e) {
            System.out.println("文件不存在");
        }catch (FileIsNotTxtException e){
            System.out.println("文件格式不对");
        }
    }

    @Test
    public void test02(){
        try {
            FileUtil.readFile("/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/orig.doc");
        } catch (IOException e) {
            System.out.println("文件不存在");
        }catch (FileIsNotTxtException e){
            System.out.println("文件格式错误");
        }
    }

}
