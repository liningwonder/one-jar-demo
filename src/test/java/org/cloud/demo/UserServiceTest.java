package org.cloud.demo;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

public class UserServiceTest {

    @Test
    public void testGetUserCount() {
        Long expected = 1000L;
        UserService userService = PowerMockito.spy(new UserService());
        //在spy实例下使用时，when().thenReturn()模式会执行原方法，而doReturn().when()模式不会执行原方法。
        PowerMockito.when(userService.getUserCount()).thenReturn(expected);
        Long actual = userService.getUserCount();
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    @Test
    public void testGetUserCountV2() {
        Long expected = 1000L;
        //在spy实例下使用时，when().thenReturn()模式会执行原方法，而doReturn().when()模式不会执行原方法。
        UserService userService = PowerMockito.spy(new UserService());
        PowerMockito.doReturn(expected).when(userService).getUserCount();
        Long actual = userService.getUserCount();
        Assert.assertEquals("返回值不相等", expected, actual);
    }
}
