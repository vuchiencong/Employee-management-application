package quanlinhanvien;

import java.util.Scanner;

public class NhanVienTiepThi extends NhanVien {

    private double doanhSo;
    private double hoaHong;

    public NhanVienTiepThi(String ma, String hoTen, double luong, double doanhSo, double hoaHong) {

        super(ma, hoTen, "Tiep Thi", luong);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }

    public NhanVienTiepThi() {
        super(null, null, "Nhan vien Tiep Thi", 0);
    }

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public double getHoaHong() {
        return hoaHong;
    }

    public void setHoaHong(double hoaHong) {
        this.hoaHong = hoaHong;
    }

    public void nhap(Scanner scanner) {
        super.nhap(scanner);
        System.out.println("Doanh So: ");
        doanhSo = scanner.nextDouble();

        System.out.println("Hoa Hong: ");
        hoaHong = scanner.nextDouble();
        scanner.nextLine();
    }

    public void xuat() {

        super.xuat();
        System.out.printf("- Doanh so: %f - Hoa Hong: %f", doanhSo, hoaHong);
    }

    @Override
    public double getThuNhap() {
        return getLuong() + doanhSo * hoaHong / 100;
    }

}
