package com.solve_problem.lz;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * NumberOfPeople class
 *
 * @author 格林
 * @date 2022-01-22
 */
public class NumberOfPeople {

    public static final String REPLACEMENT = "，";

    public static int numberOfPeople()  {
        String path = "C:\\Users\\admin\\Desktop\\1.txt";
        String path4 = "C:\\Users\\admin\\Desktop\\4.txt";
        File file = new File(path);
        try(InputStream inputStream = new FileInputStream(file)){
            byte[] res = new byte[inputStream.available()];
            inputStream.read(res,0,inputStream.available());
            String resStr = new String(res);
            String lastStr = resStr.replace("加入了会议", REPLACEMENT);
            String[] splitRes = lastStr.split(REPLACEMENT);
            System.out.println(splitRes.length);
            Set<String> resSet = new HashSet<>();
            Arrays.stream(splitRes).forEach(key->
            {
                if(key.indexOf('(') != -1) {
                    resSet.add(key);
                } else {
                    System.out.println(key);
                }
            });
            System.out.println(resSet.size());

            // 写入
            try(FileOutputStream fo = new FileOutputStream(path4)) {
                StringBuilder stringBuilder = new StringBuilder();
                for(String str: resSet) {
                    stringBuilder.append(str).append("\r\n");
                }
                fo.write(stringBuilder.toString().getBytes());
            }


        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return 0;
    }
    public static void main(String[] args) {
        numberOfPeople();
    }
}
