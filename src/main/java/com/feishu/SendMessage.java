package com.feishu;

import com.lark.oapi.Client;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.service.drive.v1.enums.UploadAllFileParentTypeEnum;
import com.lark.oapi.service.drive.v1.model.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;

/**
 * SendMessage class
 *
 * @author 谢小平
 * @date 2023/6/28
 */
@Slf4j
public class SendMessage {

    @Test
    public void testUpload() {
        try{
            Client client = Client.newBuilder("cli_a58865ede539100e", "DdAutpaA3xyOe3z6xYzgtcHi0BMcub2u").build();
            File file = new File("C:\\Users\\lizhi\\Downloads\\新建文件夹\\");
            if(file.exists()) {
                File[] files = file.listFiles();
                for(File temp :  files) {
                    try{
                        // 创建请求对象
                        UploadAllFileReq req = UploadAllFileReq.newBuilder()
                                .uploadAllFileReqBody(UploadAllFileReqBody.newBuilder()
                                        .fileName(temp.getName())
                                        .parentType("explorer")
                                        .parentNode("HNTrfBJ3Jl8UrmdjofNceHttnMd")
                                        .size((int)temp.length())
                                        .file(temp)
                                        .build())
                                .build();
                        // 发起请求
                        UploadAllFileResp resp = client.drive().file().uploadAll(req, RequestOptions.newBuilder()
                                .userAccessToken("u-fFJwMMhXt0L8F9fwf_J_hb10imSl00Xzgq000l20243U")
                                .build());
                        if(!resp.success()) {
                            log.info("error" + resp.getMsg());
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void upFile(File file, String parentNode, Client client, String userAccessToken) {
        if(file.exists()) {
            File[] files = file.listFiles();
            for(File temp :  files) {
                if(!temp.isDirectory()) {
                    try{
                        // 创建请求对象
                        UploadAllFileReq req = UploadAllFileReq.newBuilder()
                                .uploadAllFileReqBody(UploadAllFileReqBody.newBuilder()
                                        .fileName(temp.getName())
                                        .parentType("explorer")
                                        .parentNode(parentNode)
                                        .size((int)temp.length())
                                        .file(temp)
                                        .build())
                                .build();
                        // 发起请求
                        UploadAllFileResp resp = client.drive().file().uploadAll(req, RequestOptions.newBuilder()
                                .userAccessToken(userAccessToken)
                                .build());
                        if(!resp.success()) {
                            log.info("error" + resp.getMsg());
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try{
                        // 创建请求对象
                        CreateFolderFileReq req = CreateFolderFileReq.newBuilder()
                                .createFolderFileReqBody(CreateFolderFileReqBody.newBuilder()
                                        .name(temp.getName())
                                        .folderToken(parentNode)
                                        .build())
                                .build();
                        // 发起请求
                        CreateFolderFileResp resp = client.drive().file().createFolder(req, RequestOptions.newBuilder()
                                .userAccessToken(userAccessToken)
                                .build());

                        // 处理服务端错误
                        if(!resp.success()) {
                            System.out.println(String.format("code:%s,msg:%s,reqId:%s", resp.getCode(), resp.getMsg(), resp.getRequestId()));
                            return;
                        } else {
                            String token = resp.getData().getToken();
                            upFile(temp,token,client,userAccessToken);
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    @Test
    public void testUpload2() {
        try{
            Client client = Client.newBuilder("cli_a58865ede539100e", "DdAutpaA3xyOe3z6xYzgtcHi0BMcub2u").build();
            // 创建请求对象
            File file = new File("C:\\Users\\lizhi\\Downloads\\新建文件夹\\新建 Microsoft Word 文档.docx");
            UploadAllFileReq req = UploadAllFileReq.newBuilder()
                    .uploadAllFileReqBody(UploadAllFileReqBody.newBuilder()
                            .fileName("xxx")
                            .parentType("explorer")
//                            .parentNode("HNTrfBJ3Jl8UrmdjofNceHttnMd")
                            .parentType("R8BjbTvyaosKQ3x03h4c68jonCf")
                            .size((int)file.length())
                            .file(file)
                            .build())
                    .build();
            // 发起请求
            UploadAllFileResp resp = client.drive().file().uploadAll(req, RequestOptions.newBuilder()
                    .userAccessToken("u-f8SHjJ.QBdI8vWum1tyV4n10gkul00pHVq001gm0216Z")
                    .build());
            if(!resp.success()) {
                log.info("error" + resp.getMsg());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
