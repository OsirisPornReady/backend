package org.osiris.backend.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringManipUtils {
    public static List<String> splitSort(String source) {
        String delimeter = "\\.";  // 指定分割字符 //小数点是一个regular-expression的匹配模式而非一个简单的String
        return Arrays.stream(source.split(delimeter)).toList(); // 分割字符串
    }
}
