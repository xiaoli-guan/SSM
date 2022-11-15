package demo.ssm.pojo;

public class TC extends TCKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tc.progress
     *
     * @mbggenerated Fri Nov 11 14:07:51 CST 2022
     */
    private String progress;

    public TC(){}
    public TC(Integer cno, Integer teaId, String progress) {
        super(cno, teaId);
        this.progress = progress;
    }

    public TC(String progress) {
        this.progress = progress;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tc.progress
     *
     * @return the value of tc.progress
     *
     * @mbggenerated Fri Nov 11 14:07:51 CST 2022
     */
    public String getProgress() {
        return progress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tc.progress
     *
     * @param progress the value for tc.progress
     *
     * @mbggenerated Fri Nov 11 14:07:51 CST 2022
     */
    public void setProgress(String progress) {
        this.progress = progress == null ? null : progress.trim();
    }

}