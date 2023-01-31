package org.cloud.demo;

import java.util.Objects;

public class UserService2 {
    private Long superUserId;
    public boolean isNotSuperUser(Long userId) {
        return !isSuperUser(userId);
    }
    private boolean isSuperUser(Long userId) {
        return Objects.equals(userId, superUserId);
    }

}
