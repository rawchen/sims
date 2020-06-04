package domain;

public class Notify {

    private String id;
    private String notifyInfo;
    private String notifyDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotifyInfo() {
        return notifyInfo;
    }

    public void setNotifyInfo(String notifyInfo) {
        this.notifyInfo = notifyInfo;
    }

    public String getNotifyDate() {
        return notifyDate;
    }

    public void setNotifyDate(String notifyDate) {
        this.notifyDate = notifyDate;
    }

    @Override
    public String toString() {
        return "Notify{" +
                "id='" + id + '\'' +
                ", notifyInfo='" + notifyInfo + '\'' +
                ", notifyDate='" + notifyDate + '\'' +
                '}';
    }
}
