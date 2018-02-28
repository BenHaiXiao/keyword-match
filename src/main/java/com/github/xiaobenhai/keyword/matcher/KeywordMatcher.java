package com.github.xiaobenhai.keyword.matcher;

import com.google.common.collect.Lists;
import com.hankcs.algorithm.AhoCorasickDoubleArrayTrie;
import com.github.xiaobenhai.keyword.filter.EmptyWordsFilter;
import com.github.xiaobenhai.keyword.filter.WordsFilter;
import com.github.xiaobenhai.keyword.keyword.Dict;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.*;

/**
 * 关键词AC匹配器。
 *
 * @see <a href="http://www.hankcs.com/program/algorithm/aho-corasick-double-array-trie.html">AhoCorasickDoubleArrayTrie</a>
 *
 *@author xiaobenhai
 */
public class KeywordMatcher implements Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(KeywordMatcher.class);
    private AhoCorasickDoubleArrayTrie<String> trie = null;
    private WordsFilter filter;
    private Map<String, String> wordsMap = new HashMap<String, String>();

    private KeywordMatcher() {
        //no-op
    }

    public static KeywordMatcher build(Dict dict) {
        LOGGER.info("KeywordMatcher start...");
        KeywordMatcher matcher = build(dict.getKeywords(), new EmptyWordsFilter());
        LOGGER.info("KeywordMatcher end...");
        return matcher;

    }

    public static KeywordMatcher build(List<Dict> dict) {
        List<String> total = new ArrayList();
        for (Dict d : dict) {
            total.addAll(d.getKeywords());
        }
        return build(total, new EmptyWordsFilter());
    }

    private static KeywordMatcher build(List<String> words, WordsFilter wf) {
        Map<String, String> wordsMap = new HashMap<String, String>();
        List<String> wordsFilter = getFiltered(words, wf, wordsMap);
        Collections.sort(wordsFilter);

        // Collect test data set
        TreeMap<String, String> map = new TreeMap<String, String>();
        for (String key : wordsFilter) {
            map.put(key, key);
        }
        // Build an AhoCorasickDoubleArrayTrie
        AhoCorasickDoubleArrayTrie<String> acdat = new AhoCorasickDoubleArrayTrie<String>();
        acdat.build(map);

        KeywordMatcher ks = new KeywordMatcher();
        ks.trie = acdat;
        ks.filter = wf;
        ks.wordsMap = wordsMap;
        return ks;
    }

    private static List<String> getFiltered(List<String> words, WordsFilter wf, Map<String, String> wordsMap2) {
        List<String> list = Lists.newArrayList();
        for (String w : words) {
            String w2 = wf.filter(w, 1);
            if (w2 == null || w2.length() < 2)
                continue;
            if (!list.contains(w2)) {
                list.add(w2);
                wordsMap2.put(w2, w);
            }
        }
        return list;
    }

    /**
     * 关键词查询，查询结果返回匹配到的关键词
     *
     * @param text 待检测文本
     * @return 命中的关键词列表
     */
    public List<String> match(String text) {
        List<String> list = Lists.newArrayList();
        try {
            String filteredText = filter.filter(text, 2);
            List<AhoCorasickDoubleArrayTrie<String>.Hit<String>> wordList = trie.parseText(filteredText);
            for (AhoCorasickDoubleArrayTrie<String>.Hit<String> hit : wordList) {
                String hitKey = wordsMap.get(hit.value);
                if (hitKey == null)
                    hitKey = hit.value;
                if (!list.contains(hitKey)) {
                    list.add(hitKey);
                }
            }
        } catch (Exception e) {
            LOGGER.warn("match error", e);
        }
        return list;
    }

}
