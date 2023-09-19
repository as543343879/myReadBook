package com.feishu;

import com.lark.oapi.Client;
import com.lark.oapi.service.im.v1.enums.CreateMessageReceiveIdTypeEnum;
import com.lark.oapi.service.im.v1.enums.MsgTypeEnum;
import com.lark.oapi.service.im.v1.model.*;
import com.lark.oapi.service.im.v1.model.ext.*;
import com.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SendMessage class
 *SendMessageOld.java
 * @author 谢小平
 * @date 2023/6/28
 */
@Slf4j
public class SendMessageOld {
    // 发给个人
    @Test
    public void testOwner() {
        Map<String, Object> map = new HashMap();
        map.put("type", "template");
        Map<String, Object> data = new HashMap();
        map.put("data", data);
        Map<String, String> template_variable = new HashMap();
        template_variable.put("title", "title");
        template_variable.put("id", "id");
        template_variable.put("band", "band");
        template_variable.put("name", "name");
        template_variable.put("phone", "phone");
        template_variable.put("feiShuuserId", "3362163");
        data.put("template_variable", template_variable);
        data.put("template_id", "ctp_AA6G5sg9eh7J");

        Client cli_a40001de2d3c500e = Client.newBuilder("cli_a40001de2d3c500e", "5rmAqxJ1pKPCACdHtQWDMepkOJoTlTSd").build();
        try {
            CreateMessageResp createMessageResp = cli_a40001de2d3c500e.im().message().create(CreateMessageReq.newBuilder()
                    .receiveIdType(CreateMessageReceiveIdTypeEnum.USER_ID)
                    .createMessageReqBody(CreateMessageReqBody.newBuilder()
                            .msgType(MsgTypeEnum.MSG_TYPE_INTERACTIVE.getValue())
                            .receiveId("3362163")
                            .content(JsonUtil.dumps(map))
                            .build())
                    .build() );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test() {
        Client cli_a40001de2d3c500e = Client.newBuilder("cli_a40001de2d3c500e", "5rmAqxJ1pKPCACdHtQWDMepkOJoTlTSd").build();
        try {
//            InternalTenantAccessTokenResp cli_a40001de2d3c500e1 = cli_a40001de2d3c500e.auth().tenantAccessToken().internal(InternalTenantAccessTokenReq.newBuilder().internalTenantAccessTokenReqBody(InternalTenantAccessTokenReqBody.newBuilder()
//                    .appId("cli_a40001de2d3c500e").appSecret("5rmAqxJ1pKPCACdHtQWDMepkOJoTlTSd").build()).build());
//
//            log.info("handle code={}, message={}, error ={}",  cli_a40001de2d3c500e1.getCode(), cli_a40001de2d3c500e1.getMsg(), JsonUtil.dumps(cli_a40001de2d3c500e1.getError()));
//
//           String tenant_access_token = (String) JsonUtil.loads(new String(cli_a40001de2d3c500e1.getRawResponse().getBody()), Map.class).get("tenant_access_token");
//
           String tenant_access_token = "Bearer t-g1046sfOUI6LOZ6R372EGHMHD4W4X2NWRGCHC6HT";
            String tenantKey = "2c973bdcfa8d9758";
            CreateMessageResp createMessageResp = cli_a40001de2d3c500e.im().message().create(CreateMessageReq.newBuilder()
                            .receiveIdType(CreateMessageReceiveIdTypeEnum.CHAT_ID)
                            .createMessageReqBody(CreateMessageReqBody.newBuilder()
                            .msgType(MsgTypeEnum.MSG_TYPE_TEXT.getValue())
                            .receiveId("oc_68aa183333267ea5fbb5c74f74381702")
                            .content(MessageText.newBuilder().text("hello").build())
                            .build())
                            .build()
//                    , RequestOptions.newBuilder()
//                            .tenantAccessToken(tenant_access_token)
//                            .build()
            );
            log.info("handle tenant_access_token ={},code={}, message={}, error ={}", tenant_access_token,  createMessageResp.getCode(), createMessageResp.getMsg(), JsonUtil.dumps(createMessageResp.getError()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        Client cli_a40001de2d3c500e = Client.newBuilder("cli_a40001de2d3c500e", "5rmAqxJ1pKPCACdHtQWDMepkOJoTlTSd").build();
        try {

            ReplyMessageResp hello = cli_a40001de2d3c500e.im().message().reply(ReplyMessageReq.newBuilder().
                            messageId("om_cd07594a26669f3878ee6b0d74e32ac3").
                    replyMessageReqBody(
                    ReplyMessageReqBody.newBuilder()
                            .msgType(MsgTypeEnum.MSG_TYPE_POST.getValue())
                            .content(MessageText.newBuilder().atUser("3362163", "憨批") .text("hello").build())
                            .build()
            ).build());


            log.info("code={}, message={}, error ={}",   hello.getCode(), hello.getMsg(), JsonUtil.dumps(hello.getError()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test4() {
        Client cli_a40001de2d3c500e = Client.newBuilder("cli_a40001de2d3c500e", "5rmAqxJ1pKPCACdHtQWDMepkOJoTlTSd").build();
        try {

            Map<String, Object> map = new HashMap();
            map.put("type", "template");
            Map<String, Object> data = new HashMap();
            map.put("data", data);
            Map<String, String> template_variable = new HashMap();
            template_variable.put("title", "title");
            template_variable.put("id", "id");
            template_variable.put("band", "band");
            template_variable.put("name", "name");
            template_variable.put("phone", "phone");
            template_variable.put("feiShuuserId", "3362163");
            data.put("template_variable", template_variable);
            data.put("template_id", "ctp_AA6G5sg9eh7J");

            ReplyMessageResp hello = cli_a40001de2d3c500e.im().message().reply(ReplyMessageReq.newBuilder().
                    messageId("om_cd07594a26669f3878ee6b0d74e32ac3").
                    replyMessageReqBody(
                            ReplyMessageReqBody.newBuilder()
                                    .msgType(MsgTypeEnum.MSG_TYPE_INTERACTIVE.getValue())
                                    .content(JsonUtil.dumps(map))
                                    .build()
                    ).build());


            log.info("code={}, message={}, error ={}",   hello.getCode(), hello.getMsg(), JsonUtil.dumps(hello.getError()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        Client cli_a40001de2d3c500e = Client.newBuilder("cli_a40001de2d3c500e", "5rmAqxJ1pKPCACdHtQWDMepkOJoTlTSd").build();
        try {

            MessagePostAt at = MessagePostAt.newBuilder()
                    .userName("ou_c245b0a7dff2725cfa2fb104f8b48b9d")
                    .userId("3362163")
                    .build();
            List<MessagePostElement> segment1 = MessagePostSegment
                    .newBuilder()
                    .element(MessagePostText.newBuilder().text("手机：\t86-17811111111\t用户名：\tuser3864077" + "\n").build())
                    .element(MessagePostText.newBuilder().text("手机：\t86-17811111213123111\t用户名：\tuser3864077" + "\n").build())
                    .element(MessagePostText.newBuilder().text("手机：\t86-17811111111\t用户名：\tuser3864077" + "\n").build())
                    .build();
            List<MessagePostElement> segment2 = MessagePostSegment
                    .newBuilder()
                    .element(at)
                    .build();

            List<MessagePostElement> segment3 = MessagePostSegment
                    .newBuilder()
                    .element(MessagePostText.newBuilder() .text("<table>\n" +
                            "    <tr>\n" +
                            "        <th>属性：</th>\n" +
                            "        <th>值</th>\n" +
                            "        <th>属性：</th>\n" +
                            "        <th>值</th>\n" +
                            "    </tr>\n" +
                            "    <tr>\n" +
                            "        <td>张三</td>\n" +
                            "        <td>25</td>\n" +
                            "        <td>男</td>\n" +
                            "        <td>男</td>\n" +
                            "    </tr>\n" +
                            "    <tr>\n" +
                            "        <td>李四</td>\n" +
                            "        <td>30</td>\n" +
                            "        <td>女</td>\n" +
                            "        <td>女</td>\n" +
                            "    </tr>\n" +
                            "</table>").build())
                    .build();

            String post = MessagePost.newBuilder()
                    .zhCn(MessagePostContent.newBuilder()
                            .title("用户信息：")
                            .segment(segment1)
                            .segment(segment2)
                            .segment(segment3)
                            .build())
                    .build();
            post = "<table>\n" +
                    "    <tr>\n" +
                    "        <th>属性：</th>\n" +
                    "        <th>值</th>\n" +
                    "        <th>属性：</th>\n" +
                    "        <th>值</th>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "        <td>张三</td>\n" +
                    "        <td>25</td>\n" +
                    "        <td>男</td>\n" +
                    "        <td>男</td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "        <td>李四</td>\n" +
                    "        <td>30</td>\n" +
                    "        <td>女</td>\n" +
                    "        <td>女</td>\n" +
                    "    </tr>\n" +
                    "</table>";
            ReplyMessageResp hello = cli_a40001de2d3c500e.im().message().reply(ReplyMessageReq.newBuilder().
                    messageId("om_cd07594a26669f3878ee6b0d74e32ac3").
                    replyMessageReqBody(
                            ReplyMessageReqBody.newBuilder()
                                    .msgType(MsgTypeEnum.MSG_TYPE_POST.getValue())
                                    .content(post)
                                    .build()
                    ).build());


            log.info("code={}, message={}, error ={}",   hello.getCode(), hello.getMsg(), JsonUtil.dumps(hello.getError()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
