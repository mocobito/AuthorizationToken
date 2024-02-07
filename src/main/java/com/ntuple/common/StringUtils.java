package com.ntuple.common;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StringUtils {
    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static String getJSON(Object obj) {
        try {
            return (null == obj) ? "NULL" : new ObjectMapper().writeValueAsString(obj);
            //return (null == obj) ? "NULL" : new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(obj);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
