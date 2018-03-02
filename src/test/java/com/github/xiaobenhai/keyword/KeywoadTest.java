package com.github.xiaobenhai.keyword;

import com.google.common.collect.Lists;
import com.github.xiaobenhai.keyword.keyword.Dict;
import com.github.xiaobenhai.keyword.matcher.KeywordMatcher;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * @author xiaobenhai
 * Date: 2016/12/29
 * Time: 16:01
 * 关键字匹配测试
 */
public class KeywoadTest {
    @Test
    public void testGetHitList() {
        List<String> words = Lists.newArrayList("hers", "his", "she", "he");
        Dict dict = new Dict();
        dict.setKeywords(words);
        String text = "she";
        KeywordMatcher service = KeywordMatcher.build(dict);
        List<String> hits = service.match(text);
        System.out.println(hits);
    }

    @Test
    public void testPerformance() {
        List<String> words = Lists.newArrayList("hers", "his", "she", "he");
        Dict dict = new Dict();
        dict.setKeywords(words);
        String text = words.get(new Random(words.size()).nextInt());
        KeywordMatcher service = KeywordMatcher.build(dict);
        List<String> hits = service.match(text);
        System.out.println(hits);
    }
}
