package demo.ssm.pojo;

public class User {

    private Integer id;
    private String password;
    private String username;
    private String adminflag;

    public User() {
    }

    public User(Integer id, String password, String username, String adminflag) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.adminflag = adminflag;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getAdminflag() {
        return adminflag;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAdminflag(String adminflag) {
        this.adminflag = adminflag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", adminflag='" + adminflag + '\'' +
                '}';
    }
}
