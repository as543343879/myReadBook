package com;

import java.text.MessageFormat;

/**
 * MessageFormatTest class
 *
 * @author 谢小平
 * @date 2021/7/28
 */
public class MessageFormatTest   {

    public static void main(String[] args) {
//        MessageFormat messageFormat = new MessageFormat("{0}--{1}");
//        String format = messageFormat.format(new Object[]{String.valueOf(1000), 2});

        String str = "{0,number,#}";//需要被替换的值
        String format = MessageFormat.format(str, 1000);
        System.out.println(format);
    }
}
