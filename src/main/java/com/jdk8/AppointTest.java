package com.jdk8;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * AppointTest class
 *
 * @author 谢小平
 * @date 2021/7/27
 */
@Slf4j
public class AppointTest {
    @Test
    public void test() {
        User user = new User();
        user.setId(1111111111111111111L);

        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());

        log.info("user.id: {} userInfo.id: {}",user.getId(),userInfo.getId());


    }
}

@Data
class User {
    private Long id;
    private String name;
}
@Data
class UserInfo {
    private Long id;
}