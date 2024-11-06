package model;

public class PhongChieu303 {
    private int id;
    private String tenPhong;
    private int quanLyId;
    private int soluongghe ;
    private String mota ;

    // Getter và Setter cho từng thuộc tính
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }
    public int getQuanLyId() {
        return quanLyId;
    }

    public void setQuanLyId(int quanLyId) {
        this.quanLyId = quanLyId;
    }
    public int getSoluongghe() {
        return soluongghe;
    }

    public void setSoluongghe(int soluongghe) {
        this.soluongghe = soluongghe;
    }

    // Thêm getter và setter cho mota
    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
}