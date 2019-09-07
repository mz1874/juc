package com.mz.countDownLatch;

public enum  ResponseEnum {
    ONE(1,"张三","男"),TWO(2,"李四","女");


    private Integer code;

    private String name;

    private String sex;

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

    public static ResponseEnum ResponseEnumForeach(Integer code){
        for (ResponseEnum responseEnum:values()){
            if (responseEnum.getCode()==code){
                return responseEnum;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ResponseEnum responseEnum = ResponseEnum.ResponseEnumForeach(1);
        System.out.println(responseEnum.getSex());
        System.out.println(responseEnum.getCode());
        System.out.println(responseEnum.getName());
    }
}
