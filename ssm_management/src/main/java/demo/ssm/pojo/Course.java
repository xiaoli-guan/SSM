package demo.ssm.pojo;

public class Course {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.Cno
     *
     * @mbggenerated Sun Nov 06 23:39:07 CST 2022
     */
    private Integer cno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.Cname
     *
     * @mbggenerated Sun Nov 06 23:39:07 CST 2022
     */
    private String cname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.Cpno
     *
     * @mbggenerated Sun Nov 06 23:39:07 CST 2022
     */
    private Integer cpno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.Ccredit
     *
     * @mbggenerated Sun Nov 06 23:39:07 CST 2022
     */
    private Integer ccredit;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.Cno
     *
     * @return the value of course.Cno
     *
     * @mbggenerated Sun Nov 06 23:39:07 CST 2022
     */
    public Integer getCno() {
        return cno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.Cno
     *
     * @param cno the value for course.Cno
     *
     * @mbggenerated Sun Nov 06 23:39:07 CST 2022
     */
    public void setCno(Integer cno) {
        this.cno = cno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.Cname
     *
     * @return the value of course.Cname
     *
     * @mbggenerated Sun Nov 06 23:39:07 CST 2022
     */
    public String getCname() {
        return cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.Cname
     *
     * @param cname the value for course.Cname
     *
     * @mbggenerated Sun Nov 06 23:39:07 CST 2022
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.Cpno
     *
     * @return the value of course.Cpno
     *
     * @mbggenerated Sun Nov 06 23:39:07 CST 2022
     */
    public Integer getCpno() {
        return cpno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.Cpno
     *
     * @param cpno the value for course.Cpno
     *
     * @mbggenerated Sun Nov 06 23:39:07 CST 2022
     */
    public void setCpno(Integer cpno) {
        this.cpno = cpno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.Ccredit
     *
     * @return the value of course.Ccredit
     *
     * @mbggenerated Sun Nov 06 23:39:07 CST 2022
     */
    public Integer getCcredit() {
        return ccredit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.Ccredit
     *
     * @param ccredit the value for course.Ccredit
     *
     * @mbggenerated Sun Nov 06 23:39:07 CST 2022
     */
    public void setCcredit(Integer ccredit) {
        this.ccredit = ccredit;
    }
}