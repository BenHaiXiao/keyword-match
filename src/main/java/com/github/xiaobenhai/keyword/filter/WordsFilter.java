package com.github.xiaobenhai.keyword.filter;

import java.io.Serializable;
/**
 * @author xiaobenhai
 * Date: 2016/12/30
 * Time: 9:59
 */
public interface WordsFilter extends Serializable {
    /**
     * 接口
     *
     * @param word 内容
     * @param type 内容类型，1输入关键词， 2输入内容
     */
    String filter(String word, int type);
}
