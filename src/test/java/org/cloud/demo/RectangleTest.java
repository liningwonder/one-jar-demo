package org.cloud.demo;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

//当模拟非final类（接口、普通类、虚基类）的非final方法时，不必使用@RunWith和@PrepareForTest注解。
public class RectangleTest {

    @Test
    public void testGetArea() {
        double expectArea = 100.0D;
        Rectangle rectangle = PowerMockito.mock(Rectangle.class);
        PowerMockito.when(rectangle.getArea()).thenReturn(expectArea);
        double actualArea = rectangle.getArea();
        Assert.assertEquals("返回值不相等", expectArea, actualArea, 1E-6D);
    }

}
