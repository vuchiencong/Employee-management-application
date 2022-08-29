package quanlinhanvien;

import java.util.Scanner;

public abstract  class NhanVien {

    String ma;
    String hoTen;
    String loai;
    double luong;

    public NhanVien(String ma, String hoTen, String loai, double luong) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.loai = loai;
        this.luong = luong;
    }

    public NhanVien() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public void nhap(Scanner scanner){

        System.out.println("Ma : ");
        this.ma = scanner.nextLine();

        System.out.println("Ho ten: ");
        this.hoTen = scanner.nextLine();

        System.out.println("Luong: ");
        this.luong = scanner.nextDouble();
        scanner.nextLine();
    }

    public void xuat(){
        System.out.printf("Ma: %s - Ho ten: %s - loai: %s - Luong: %s - Thu Nhap: %f\n" , ma, hoTen, loai, luong, getThuNhap());
    }

    public abstract double getThuNhap();
}
