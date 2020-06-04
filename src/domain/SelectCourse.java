package domain;

public class SelectCourse {
    private String s_id;
    private String s_name;
    private String c_id;
    private String c_name;
    private String c_info;
    private String t_id;
    private String t_name;
    private String score;

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_info() {
        return c_info;
    }

    public void setC_info(String c_info) {
        this.c_info = c_info;
    }

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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "SelectCourse{" +
                "s_id='" + s_id + '\'' +
                ", s_name='" + s_name + '\'' +
                ", c_id='" + c_id + '\'' +
                ", c_name='" + c_name + '\'' +
                ", c_info='" + c_info + '\'' +
                ", t_id='" + t_id + '\'' +
                ", t_name='" + t_name + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
