package com.company.khang;

public class student {
    String hoten;
    int toan,ly,hoa;

    public student() {
    }

    public student(String hoten, int toan, int ly, int hoa) {
        this.hoten = hoten;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getToan() {
        return toan;
    }

    public void setToan(int toan) {
        this.toan = toan;
    }

    public int getLy() {
        return ly;
    }

    public void setLy(int ly) {
        this.ly = ly;
    }

    public int getHoa() {
        return hoa;
    }

    public void setHoa(int hoa) {
        this.hoa = hoa;
    }

    public String toxml(){
        return "<student>\n" +
                " <hoten>"+hoten+"</hoten>\n" +
                "  <toan>"+toan+"</toan>\n" +
                "  <ly>"+ly+"</ly>\n" +
                "  <hoa>"+hoa+"</hoa>\n" +
                "</student>\n";
    }

    @Override
    public String toString() {
        return "student{" +
                "hoten='" + hoten + '\'' +
                ", toan=" + toan +
                ", ly=" + ly +
                ", hoa=" + hoa +
                '}';
    }
}
