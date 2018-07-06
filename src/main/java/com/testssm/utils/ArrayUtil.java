package com.testssm.utils;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组工具类
 * @since 1.0.0
 */
public final class ArrayUtil {

    private ArrayUtil() {
    }

    /**
     * 判断数组是否为空
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }

    /**
     * 判断数组是否非空
     */
    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    /**
     * Array 转 List
     */
    public static <T> List<T> toList(T[] array) {
        if (isEmpty(array)) {
            return new ArrayList<>();
        }
        return Arrays.asList(array);
    }
    
    
    public static Object[] subArry(Object[] src, int begin, int count) {  
    	Object[] object = new Object[count];  
        System.arraycopy(src, begin, object, 0, count);  
        return object;  
    }  
}
