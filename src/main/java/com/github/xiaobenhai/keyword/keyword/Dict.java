package com.github.xiaobenhai.keyword.keyword;

import java.io.Serializable;
import java.util.List;

/**
 * @author xiaobenhai
 * Date: 2016/12/29
 * Time: 18:05
 * 关键词词库
 */
public class Dict implements Serializable {
    /**
     * 所属的APP ID
     */
    private Integer appid;
    /**
     * 词库名称
     */
    private String name;
    /**
     * 关键词列表
     */
    private List<String> keywords;

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Dict{" +
                "appid=" + appid +
                ", name='" + name + '\'' +
                ", keywords=" + keywords +
                '}';
    }
}
