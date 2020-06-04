package domain;

public class Teacher {
    private String t_id;
    private String t_name;
    private String t_sex;
    private String t_education;
    private String t_title;
    private String t_password;

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_sex() {
        return t_sex;
    }

    public void setT_sex(String t_sex) {
        this.t_sex = t_sex;
    }

    public String getT_education() {
        return t_education;
    }

    public void setT_education(String t_education) {
        this.t_education = t_education;
    }

    public String getT_title() {
        return t_title;
    }

    public void setT_title(String t_title) {
        this.t_title = t_title;
    }

    public String getT_password() {
        return t_password;
    }

    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "t_id='" + t_id + '\'' +
                ", t_name='" + t_name + '\'' +
                ", t_sex='" + t_sex + '\'' +
                ", t_education='" + t_education + '\'' +
                ", t_title='" + t_title + '\'' +
                ", t_password='" + t_password + '\'' +
                '}';
    }
}
