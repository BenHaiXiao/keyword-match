# keyword-match

## 背景

关键字索引和匹配是自然语言NLP领域使用广泛，例如**中文分词**，**关键字提取**，**敏感词汇过滤**等等；
关键字匹配最核心的痛点就是性能，如果在最短的时间内找出匹配到的关键字。

## 简介
 Aho–Corasick算法
 在计算机科学中，Aho–Corasick算法是由Alfred V. Aho和Margaret J.Corasick 发明的字符串搜索算法，[1]用于在输入的一串字符串中匹配有限组“字典”中的子串。它与普通字符串匹配的不同点在于同时与所有字典串进行匹配。算法均摊情况下具有近似于线性的时间复杂度，约为字符串的长度加所有匹配的数量。然而由于需要找到所有匹配数，如果每个子串互相匹配（如字典为a，aa，aaa，aaaa，输入的字符串为aaaa），算法的时间复杂度会近似于匹配的二次函数。
 该算法主要依靠构造一个有限状态机（类似于在一个trie树中添加失配指针）来实现。这些额外的失配指针允许在查找字符串失败时进行回退（例如设Trie树的单词cat匹配失败，但是在Trie树中存在另一个单词cart，失配指针就会指向前缀ca），转向某前缀的其他分支，免于重复匹配前缀，提高算法效率。
 当一个字典串集合是已知的(例如一个计算机病毒库), 就可以以离线方式先将自动机求出并储存以供日后使用，在这种情况下，算法的时间复杂度为输入字符串长度和匹配数量之和。
 维基百科：<https://zh.wikipedia.org/wiki/AC%E8%87%AA%E5%8A%A8%E6%9C%BA%E7%AE%97%E6%B3%95>
 Aho Corasick自动机结合DoubleArrayTrie极速多模式匹配，性能高
 详细说明见：<http://www.hankcs.com/program/algorithm/aho-corasick-double-array-trie.html>

keyword-match 提供了对AC自动机的包装。方便调用简洁使用。

## 使用方法


    ```
      List<String> words = Lists.newArrayList("hers", "his", "she", "he");
            Dict dict = new Dict();
            dict.setKeywords(words);
            String text = "she";
            KeywordMatcher service = KeywordMatcher.build(dict);
            List<String> hits = service.match(text);
            System.out.println(hits);
    ```


