package cn.hlq.sqlitestudy.entity;

/**
 * Created by HLQ on 2017/4/7 0007.
 */

public class Student {

    private String stuName;
    private int stuAge;
    private String stuAddress;

    public Student() {
    }

    public Student(String stuName, int stuAge, String stuAddress) {
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuAddress = stuAddress;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }
}
