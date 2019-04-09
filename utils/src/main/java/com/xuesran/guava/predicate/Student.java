package com.xuesran.guava.predicate;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Student {

    private int id;
    private String name;
    private boolean sex;
    private double score;

    public Student(int id, String name, boolean sex, double score) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.score = score;
    }

    public Student() {
    }

    /**
     * 获取id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取sex
     *
     * @return sex
     */
    public boolean isSex() {
        return sex;
    }

    /**
     * 设置sex
     *
     * @param sex sex
     */
    public void setSex(boolean sex) {
        this.sex = sex;
    }

    /**
     * 获取score
     *
     * @return score
     */
    public double getScore() {
        return score;
    }

    /**
     * 设置score
     *
     * @param score score
     */
    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
