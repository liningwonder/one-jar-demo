package org.cloud;

import org.cloud.demo.UserService;
import org.slf4j.MDC;

public class Main {

    public static void main(String[] args) {
        MDC.put("REQUEST_ID", "1");
        UserService userService = new UserService();
        userService.getUserCount();
    }
}
