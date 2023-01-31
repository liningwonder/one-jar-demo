package org.cloud.demo;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.AdditionalMatchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    @Test
    public void testSize() {
        Integer expected = 100;
        List list = PowerMockito.mock(List.class);
        PowerMockito.when(list.size()).thenReturn(expected);
        Integer actual = list.size();
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    //返回期望值
    @Test
    public void testGet() {
        int index = 0;
        Integer expected = 100;
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.when(mockList.get(index)).thenReturn(expected);
        Integer actual = mockList.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    //返回期望异常
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetV2() {
        int index = -1;
        Integer expected = 100;
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.when(mockList.get(index)).thenThrow(new IndexOutOfBoundsException());
        Integer actual = mockList.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    //返回期望应答
    @Test
    public void testGetV3() {
        int index = 1;
        Integer expected = 100;
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.when(mockList.get(index)).thenAnswer(invocation -> {
            Integer value = invocation.getArgument(0);
            return value * 100;
        });
        Integer actual = mockList.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    //调用真实方法
    @Test
    public void testGetV4() {
        int index = 0;
        Integer expected = 100;
        List<Integer> oldList = new ArrayList<>();
        oldList.add(expected);
        List<Integer> spylist = PowerMockito.spy(oldList);
        PowerMockito.when(spylist.get(index)).thenCallRealMethod();
        Integer actual = spylist.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }


    //参数匹配器Mockito提供Mockito.anyInt()、Mockito.anyString、Mockito.any(Class<T> clazz)等来表示任意值。
    @Test
    public void testGetV5() {
        int index = 1;
        Integer expected = 100;
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.when(mockList.get(Mockito.anyInt())).thenReturn(expected);
        Integer actual = mockList.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    //Mockito的AdditionalMatchers类提供了一些很少使用的参数匹配器，我们可以进行参数大于(gt)、小于(lt)、大于等于(geq)、小于等于(leq)等比较操作，
    // 也可以进行参数与(and)、或(or)、非(not)等逻辑计算等。
    @Test
    public void testGetV6() {
        int index = 1;
        Integer expected = 100;
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.when(mockList.get(AdditionalMatchers.geq(0))).thenReturn(expected);
        PowerMockito.when(mockList.get(AdditionalMatchers.lt(0))).thenThrow(new IndexOutOfBoundsException());
        Integer actual = mockList.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }


    //验证调用方法
    @Test
    public void testGetV7() {
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.doNothing().when(mockList).clear();
        mockList.clear();
        Mockito.verify(mockList).clear();
    }

    //验证调用次数
    @Test
    public void testGetV8() {
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.doNothing().when(mockList).clear();
        mockList.clear();
        //除times外，Mockito还支持atLeastOnce、atLeast、only、atMostOnce、atMost等次数验证器。
        Mockito.verify(mockList, Mockito.times(1)).clear();
    }

}
