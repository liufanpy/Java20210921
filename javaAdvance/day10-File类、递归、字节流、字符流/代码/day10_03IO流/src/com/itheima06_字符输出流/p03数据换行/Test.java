package com.itheima06_字符输出流.p03数据换行;

import java.io.FileWriter;
import java.io.IOException;

/*
换行:在指定数据之后换行，可以按照如下方式操作
回车符\r和换行符\n ：
      回车符：回到一行的开头（return）。
      换行符：下一行（newline）。
系统中的换行：
      Windows系统里，每行结尾是 回车+换行 ，即\r\n；
      Unix系统里，每行结尾只有 换行 ，即\n；
      Mac系统里，每行结尾是 回车 ，即\r。从 Mac OS X开始与Linux统一。
 */
public class Test {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("day10_03IO流\\a7.txt", true);
        char[] chs = {'黑', '马', '程', '序', '员'};
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            fw.write(ch);
            fw.write("\r\n");
        }
        fw.close();
    }
}
