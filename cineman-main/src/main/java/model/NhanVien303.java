package model;

public class NhanVien303 extends NguoiDung303 {
    private String viTriCongViec;

    // Constructor
    public NhanVien303() {
        super();
    }

    // Getter và Setter cho viTriCongViec
    public String getViTriCongViec() {
        return viTriCongViec;
    }

    public void setViTriCongViec(String viTriCongViec) {
        this.viTriCongViec = viTriCongViec;
    }
}