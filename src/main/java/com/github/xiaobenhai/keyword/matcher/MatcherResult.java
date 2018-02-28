package com.github.xiaobenhai.keyword.matcher;

import java.util.List;

/**
 * 匹配结果
 * @author xiaobenhai
 * Date: 2016/12/29
 * Time: 17:45
 *
 */
public class MatcherResult {
    private List<String> matchedWords;

    public List<String> getMatchedWords() {
        return matchedWords;
    }

    public void setMatchedWords(List<String> matchedWords) {
        this.matchedWords = matchedWords;
    }

    @Override
    public String toString() {
        return "MatcherResult{" +
                "matchedWords=" + matchedWords +
                '}';
    }
}
