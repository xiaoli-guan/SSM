package demo.ssm.pojo;

import org.springframework.stereotype.Service;


public class Student {
    private Integer Sno;
    private String Sname;
    private Integer Sage;
    private String Ssex;
    private String Sdept;

    public Student() {
    }

    public Student(Integer sno, String sname, Integer sage, String ssex, String sdept) {
        Sno = sno;
        Sname = sname;
        Sage = sage;
        Ssex = ssex;
        Sdept = sdept;
    }

    public Integer getSno() {
        return Sno;
    }

    public void setSno(Integer sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public Integer getSage() {
        return Sage;
    }

    public void setSage(Integer sage) {
        Sage = sage;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public String getSdept() {
        return Sdept;
    }

    public void setSdept(String sdept) {
        Sdept = sdept;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Sno=" + Sno +
                ", Sname='" + Sname + '\'' +
                ", Sage=" + Sage +
                ", Ssex='" + Ssex + '\'' +
                ", Sdept='" + Sdept + '\'' +
                '}';
    }
}
