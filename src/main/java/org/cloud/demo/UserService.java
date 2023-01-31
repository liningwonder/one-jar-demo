package org.cloud.demo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Slf4j
public class UserService {

    public long getUserCount() {
        log.info("调用获取用户数量方法");
        return 0L;
    }

    public static void main(String[] args) {
        MDC.put("REQUEST_ID", "1");
        UserService userService = new UserService();
        userService.getUserCount();
    }
}
