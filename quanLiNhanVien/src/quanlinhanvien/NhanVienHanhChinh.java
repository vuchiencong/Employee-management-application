package quanlinhanvien;

public class NhanVienHanhChinh extends NhanVien {

    public NhanVienHanhChinh(String ma, String hoTen, double luong) {
        super(ma, hoTen, "Hanh Chinh", luong);
    }

    public NhanVienHanhChinh() {
        super(null, null, "Hanh Chinh", 0);
    }

    @Override
    public double getThuNhap() {
        return getLuong();
    }
}
