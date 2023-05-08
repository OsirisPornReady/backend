package org.osiris.backend.utils;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayConvertUtils {
    public static List<Integer> string2list(String source) {
        if (source != null) {
            return Arrays.stream(source.split(","))
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } else {
            return null;
        }

    }

    public static String list2string(List<Integer> source) {
        if (source != null) {
            List<String> list = source.stream()
                    .map(String::valueOf)
                    .collect(Collectors.toList());
            return String.join(",", list);
        } else {
            return null;
        }
    }
}
