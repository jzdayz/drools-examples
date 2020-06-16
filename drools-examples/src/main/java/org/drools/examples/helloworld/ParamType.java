package org.drools.examples.helloworld;

public enum ParamType {
    PROJECT_PROCUREMENT(1,"项目采购"),
    NONE_PROJECT_PROCUREMENT(2,"非项目采购");
    private int code;
    private String desc;

    ParamType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
