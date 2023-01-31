package org.cloud.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

// 当模拟final类或final方法时，必须使用@RunWith和@PrepareForTest
@RunWith(PowerMockRunner.class)
@PrepareForTest({Circle.class})
public class CircleTest {

    @Test
    public void testGetArea() {
        double expectArea = 3.14D;
        Circle circle = PowerMockito.mock(Circle.class);
        PowerMockito.when(circle.getArea()).thenReturn(expectArea);
        double actualArea = circle.getArea();
        Assert.assertEquals("返回值不相等", expectArea, actualArea, 1E-6D);
    }
}
