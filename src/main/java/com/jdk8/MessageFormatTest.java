package com.jdk8;

import com.google.common.base.Joiner;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * MessageFormatTest class
 *
 * @author 格林
 * @date 2022-01-17
 */
public class MessageFormatTest {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>(){
            {
                add("id={0}");
                add("id={0}");
            }
        };
        MessageFormat messageFormat = new MessageFormat("(" + Joiner.on(",").join(strList) + ")");

        System.out.println(messageFormat.format(new Integer[]{1000}));
    }
}
