package com.xuesran.genericity;

public class Demo01 {

    public static void main(String[] args) {
        Box<String> name = new Box<>("cron");
        System.out.println("name:" + name.getData());
    }
}
