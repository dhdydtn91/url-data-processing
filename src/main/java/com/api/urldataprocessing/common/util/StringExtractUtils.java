package com.api.urldataprocessing.common.util;

public class StringExtractUtils {

    private static final String ONLY_NUMBER_REG_EXP = "[^0-9]*";
    private static final String ONLY_ENGLISH_REG_EXP = "[^a-zA-Z]*";
    private static final String REMOVE_HTML_TAG_REG_EXP = "<[^>]*>";


    public static String extractNumbers(String html) {
        return html.replaceAll(ONLY_NUMBER_REG_EXP, "");
    }

    public static String extractEnglish(String html) {
        return html.replaceAll(ONLY_ENGLISH_REG_EXP, "");
    }

    public static String extractNonHtmlTag(String html) {
        return html.replaceAll(REMOVE_HTML_TAG_REG_EXP, "");
    }
}