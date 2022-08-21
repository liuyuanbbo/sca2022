package spring5source.b.pojo;

public class BUser {
    private String name;
    private int age;

    BUser(){

    }

    public BUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}