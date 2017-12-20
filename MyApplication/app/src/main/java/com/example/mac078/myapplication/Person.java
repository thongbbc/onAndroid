package com.example.mac078.myapplication;

/**
 * Created by mac078 on 12/20/17.
 */

public class Person {
    private String name;
    private String age;



    private boolean selected ;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override

    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Person(String name, String age) {
        this.selected=false;
        this.name = name;
        this.age = age;
    }
    public Person(String name, String age,boolean selected) {
        this.selected=selected;
        this.name = name;
        this.age = age;
    }
}
