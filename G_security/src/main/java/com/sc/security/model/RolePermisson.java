package com.sc.security.model;

import java.io.Serializable;

/**
 * @Description
 * @Author Gthree
 * @Date 2019-12-25 15:15
 */
public class RolePermisson implements Serializable {
    private String url;
    private String roleName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
