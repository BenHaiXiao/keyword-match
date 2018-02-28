package com.github.xiaobenhai.keyword;

import com.github.xiaobenhai.keyword.matcher.MatcherResult;

/**
 * @author xiaobenhai
 * Date: 2016/12/29
 * Time: 17:45
 */
public interface Matcher {
    MatcherResult match(String text);
}
