package com.github.xiaobenhai.keyword.filter;

/**
 * @author xiaobenhai
 * Date: 2016/12/30
 * Time: 11:33
 */
public class EmptyWordsFilter implements WordsFilter {
    @Override
    public String filter(String word, int type) {
        return word.toLowerCase();
    }
}
