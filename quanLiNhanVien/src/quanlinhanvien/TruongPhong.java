package quanlinhanvien;

import java.util.Scanner;

public class TruongPhong extends NhanVien {

    private double luongTrachNhiem;

    public TruongPhong(String ma, String hoTen, double luong, double luongTrachNhiem) {
        super(ma, hoTen, "Truong Phong", luong);
        this.luongTrachNhiem = luongTrachNhiem;
    }

    public TruongPhong() {
        super(null, null, "Truong Phong", 0);
    }

    public double getLuongTrachNhiem() {
        return luongTrachNhiem;
    }

    public void setLuongTrachNhiem(double luongTrachNhiem) {
        this.luongTrachNhiem = luongTrachNhiem;
    }

    public void nhap(Scanner scanner) {

        super.nhap(scanner);
        System.out.println("Luong trach nhiem: ");
        luongTrachNhiem = scanner.nextDouble();
        scanner.nextLine();
    }

    public void xuat() {

        super.xuat();
        System.out.printf("- Luong Trach Nhiem: %f", luongTrachNhiem);
    }

    @Override
    public double getThuNhap() {
        return getLuong() + luongTrachNhiem;
    }

}
