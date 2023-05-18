package org.osiris.backend.utils;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ArrayConvertUtils {
    public static List<Integer> string2list(String source) {
        if (source != null) {
             if (Objects.equals(source, "")){
                 return null;
             } else {
                 return Arrays.stream(source.split(","))
                         .map(String::trim)
                         .map(Integer::valueOf)
                         .collect(Collectors.toList());
             }
        } else {
            return null;
        }
    }

    public static List<String> string2stringlist(String source) {
        if (source != null) {
            if (Objects.equals(source, "")){
                return null;
            } else {
                return Arrays.stream(source.split(","))
                        .map(String::trim)
                        .collect(Collectors.toList());
            }
        } else {
            return null;
        }
    }

    public static String list2string(List<Integer> source) {
        if (source != null) {
            if (source.size() == 0) {
                return "";
            } else {
                List<String> list = source.stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList());
                return String.join(",", list);
            }
        } else {
            return null;
        }
    }

    public static String liststring2string(List<String> source) {
        if (source != null) {
            if (source.size() == 0) {
                return "";
            } else {
                return String.join(",", source);
            }
        } else {
            return null;
        }
    }
}
