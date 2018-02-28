package com.github.xiaobenhai.keyword.matcher;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则匹配器
 * @author xiaobenhai
 * Date: 2016/12/29
 * Time: 17:04
 *
 */
public class RegexMatcher implements Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegexMatcher.class);
    private final List<Pattern> patterns = Lists.newArrayList();

    private RegexMatcher() {
        //no-op
    }

    public static RegexMatcher build(List<String> regexList) {
        LOGGER.info("RegexMatcher build start....");
        RegexMatcher matcher = new RegexMatcher();
        if (regexList == null || regexList.size() <= 0) {
            LOGGER.warn("Build RegexMatcher error. regex list={}", regexList);
            return matcher;
        }
        for (String regex : regexList) {
            Pattern pattern = Pattern.compile(regex);
            matcher.patterns.add(pattern);
        }
        LOGGER.info("RegexMatcher build end....");
        return matcher;
    }

    /**
     * 正则匹配字符串
     *
     * @param text
     * @return 匹配的结果
     */
    public List<String> match(String text) {
        List<String> results = Lists.newArrayList();
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                String result = matcher.group();
                results.add(result);
            }
        }
        return results;
    }
}
