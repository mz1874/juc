package com.mz.countDownLatch;

public enum  ResponseEnum {
    ONE(0,"张三","男"),TWO(1,"李四","女");


    private Integer code;

    private String name;

    private String sex;

    /**
     * 可以构造方法重载 提供多种实例
     * @param code
     * @param name
     * @param sex
     */
    ResponseEnum(Integer code, String name, String sex) {
        this.code = code;
        this.name = name;
        this.sex = sex;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    /**
     * 遍历
     * @param code
     * @return 枚举值
     */
    public static ResponseEnum ResponseEnumForeach(Integer code){
        for (ResponseEnum responseEnum:values()){
            if (responseEnum.getCode()==code){
                return responseEnum;
            }
        }
        return null;
    }
}
