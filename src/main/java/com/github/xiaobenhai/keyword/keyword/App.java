package com.github.xiaobenhai.keyword.keyword;

import java.io.Serializable;

/**
 * @author xiaobenhai
 * Date: 2016/12/30
 * Time: 9:53
 */
public class App implements Serializable {
    private Integer id;
    private String secret;
    private boolean useCommonDict;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public boolean isUseCommonDict() {
        return useCommonDict;
    }

    public void setUseCommonDict(boolean useCommonDict) {
        this.useCommonDict = useCommonDict;
    }
}
