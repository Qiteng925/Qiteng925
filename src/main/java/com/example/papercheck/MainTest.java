package com.example.papercheck;

import org.junit.Test;

import java.io.IOException;

public class MainTest {

    @Test
    public void test01() {
        String[] example = new String[3];
        example[0] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/orig.txt";
        example[1] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/orig_0.8_add.txt";
        example[2] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/ans.txt";
        mainTest(example);
    }

    @Test
    public void test02() {
        String[] example = new String[3];
        example[0] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/orig.txt";
        example[1] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/orig_0.8_del.txt";
        example[2] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/ans.txt";
        mainTest(example);
    }

    @Test
    public void test03() {
        String[] example = new String[3];
        example[0] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/orig.txt";
        example[1] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/orig_0.8_dis_1.txt";
        example[2] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/ans.txt";
        mainTest(example);
    }

    @Test
    public void test04() {
        String[] example = new String[3];
        example[0] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/orig.txt";
        example[1] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/orig_0.8_dis_1.txt";
        example[2] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/ans.txt";
        mainTest(example);
    }

    @Test
    public void test05() {
        String[] example = new String[3];
        example[0] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/orig.txt";
        example[1] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/orig_0.8_dis_10.txt";
        example[2] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/ans.txt";
        mainTest(example);
    }

    @Test
    public void test06() {
        String[] example = new String[3];
        example[0] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/orig.txt";
        example[1] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/orig_0.8_dis_15.txt";
        example[2] = "/Users/yiyan/Desktop/3122004761/src/main/java/com/example/papercheck/测试文本/ans.txt";
        mainTest(example);
    }

    public void mainTest(String[] example) {
        String[] s = example;
        String simHash0;
        String simHash1;
        String str0;
        String str1;
        //if (args.length < 3) return;
        try {
            str0 = FileUtil.readFile(s[0]);
            str1 = FileUtil.readFile(s[1]);
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
            FileUtil.writeFile(s[2], String.valueOf(similarity));
            System.out.println("结果写入文件 "+s[2]+" 完成");
        } catch (IOException e) {
        }
        System.out.println("计算结束，程序自动退出");
    }
}
