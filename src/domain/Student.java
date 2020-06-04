package domain;

public class Student {
    private String s_id;
    private String s_college;
    private String s_department;
    private String s_class;
    private String s_name;
    private String s_sex;
    private String s_age;
    private String s_address;
    private String s_phone;
    private String s_email;
    private String s_password;

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_college() {
        return s_college;
    }

    public void setS_college(String s_college) {
        this.s_college = s_college;
    }

    public String getS_department() {
        return s_department;
    }

    public void setS_department(String s_department) {
        this.s_department = s_department;
    }

    public String getS_class() {
        return s_class;
    }

    public void setS_class(String s_class) {
        this.s_class = s_class;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public String getS_age() {
        return s_age;
    }

    public void setS_age(String s_age) {
        this.s_age = s_age;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public String getS_phone() {
        return s_phone;
    }

    public void setS_phone(String s_phone) {
        this.s_phone = s_phone;
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email;
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id='" + s_id + '\'' +
                ", s_college='" + s_college + '\'' +
                ", s_department='" + s_department + '\'' +
                ", s_class='" + s_class + '\'' +
                ", s_name='" + s_name + '\'' +
                ", s_sex='" + s_sex + '\'' +
                ", s_age=" + s_age +
                ", s_address='" + s_address + '\'' +
                ", s_phone='" + s_phone + '\'' +
                ", s_email='" + s_email + '\'' +
                ", s_password='" + s_password + '\'' +
                '}';
    }
}
