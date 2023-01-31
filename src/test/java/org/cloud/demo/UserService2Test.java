package org.cloud.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserService2Test {

    @Test
    public void testIsNotSuperUser() throws Exception {
        Long userId = 1L;
        boolean expected = false;
        UserService2 userService = PowerMockito.spy(new UserService2());
        PowerMockito.when(userService, "isSuperUser", userId).thenReturn(!expected);
        boolean actual = userService.isNotSuperUser(userId);
        Assert.assertEquals("返回值不相等", expected, actual);
    }
}
