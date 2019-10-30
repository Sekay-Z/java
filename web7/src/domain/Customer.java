package domain;

public class Customer {
    public Customer() {
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", gender='" + gender + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    private  String cid;
    private String cname;
    private String gender;
    private String  cellphone;
    private String email;
}
