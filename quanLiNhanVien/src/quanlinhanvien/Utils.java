package quanlinhanvien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * nơi chứa các hàm thao tác công việc
 */
public class Utils {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<NhanVien> list = new ArrayList<>();


    /**
     * hàm nhập dữ liệu cho nhân viên
     */
    public static void nhap() {

        Scanner scanner = new Scanner(System.in);
        list.clear();

        do {
            System.out.println("nhap loai nhan vien");
            System.out.println("  1. Hanh Chinh    ");
            System.out.println("  2. Truong Phong  ");
            System.out.println("  3. Tiep Thi      ");
            System.out.println("   space+enter để kết thúc");

            String loai = scanner.nextLine();
            if (loai == null || loai.equals(" "))
                break;
            int choice = Integer.parseInt(loai);

            switch (choice) {
                case 1:
                    NhanVienHanhChinh nvhc = new NhanVienHanhChinh();
                    nvhc.nhap(scanner);
                    list.add(nvhc);
                    break;
                case 2:
                    TruongPhong tp = new TruongPhong();
                    tp.nhap(scanner);
                    list.add(tp);
                    break;
                case 3:
                    NhanVienTiepThi nvtt = new NhanVienTiepThi();
                    nvtt.nhap(scanner);
                    list.add(nvtt);
                    break;

            }
        } while (true);
    }


    /**
     * hàm hiển thị dữ liệu, danh sách nhân viên
     */
    public static void xuat() {
        System.out.println("Danh sach nhan vien: ");
        for (NhanVien nv : list) {
            if (nv instanceof NhanVienHanhChinh) {
                ((NhanVienHanhChinh) nv).xuat();
            } else if (nv instanceof NhanVienTiepThi) {
                ((NhanVienTiepThi) nv).xuat();
            } else if (nv instanceof TruongPhong) {
                ((TruongPhong) nv).xuat();
            }
            System.out.println("\n----------------------------");
        }
    }


    /**
     * hàm tìm kiếm thông tin 1 nhân viên theo mã
     *
     * @param scanner
     */
    public static void timVaHienThiTheoMa(Scanner scanner) {

        System.out.println("Nhap ma nhan vien can tim: ");
        String ma = scanner.nextLine();
        NhanVien nvFound = null;
        for (NhanVien nv : list) {
            if (nv.getMa().equalsIgnoreCase(ma)) {
                nvFound = nv;
                break;
            }
        }
        if (nvFound != null) {
            System.out.println("Thong Tin Nhan Vien : ");
            nvFound.xuat();
        } else {
            System.out.println("Khong tim thay nhan vien theo ma: ");
        }
    }


    /**
     * hàm xóa 1 nhân viên theo mã của nhân viên
     *
     * @param scanner
     */
    public static void xoaNhanVienTheoMa(Scanner scanner) {
        System.out.println("Xoa nhan vien theo ma ");
        System.out.println("Nhap nhan vien theo ma ");
        String ma = scanner.nextLine();
        NhanVien nvFound = null;
        for (NhanVien nv : list) {
            if (nv.getMa().equalsIgnoreCase(ma)) {
                nvFound = nv;
                break;
            }
        }
        if (nvFound != null) {
            list.remove(nvFound);
            System.out.println(" Da xoa Nhan vien: ");

        } else {
            System.out.printf("Nhan vien co ma %s khong tim thay trong danh sach: ", ma);
        }
    }


    /**
     * hàm cập nhật lại thông tin nhân viên theo mã của nhân viên
     *
     * @param scanner
     */
    public static void capNhatTheoMa(Scanner scanner) {
        System.out.println("cap nhat thong tin nhan vien theo ma");
        System.out.println("Nhap ma nhan vien: ");
        String ma = scanner.nextLine();
        NhanVien nvFound = null;

        for (NhanVien item : list) {
            if (item.getMa().equalsIgnoreCase(ma)) {
                nvFound = item;
                break;
            }
        }
        if (nvFound != null) {
            System.out.println("Nhap thong tin cap nhat cho nhan vien: ");
            if (nvFound instanceof NhanVienHanhChinh) {
                ((NhanVienHanhChinh) nvFound).nhap(scanner);
            } else if (nvFound instanceof NhanVienTiepThi) {
                ((NhanVienTiepThi) nvFound).nhap(scanner);
            } else if (nvFound instanceof TruongPhong) {
                ((TruongPhong) nvFound).nhap(scanner);
            }
        }
    }


    /**
     * hàm tìm nhân viên theo khoảng lương yêu cầu có sẵn
     *
     * @param scanner
     */
    public static void timTheoKhoangLuong(Scanner scanner) {
        System.out.println("tim nhan vien theo khoang luong");
        System.out.println("Nhap khoang luong thap nhat: ");
        double min = scanner.nextDouble();

        System.out.println("Nhap khoang cao nhat: ");
        double max = scanner.nextDouble();
        boolean found = false;
        for (NhanVien nhanVien : list) {
            if (min <= nhanVien.getLuong() && nhanVien.getLuong() <= max) {
                nhanVien.xuat();
                System.out.println();
                found = true;
            }
        }
        if (found == false) {
            System.out.println("khong co nhan vien nao trong khoang luong nay");
        }
    }


    /**
     * hàm sắp xếp danh sách nhân viên theo tên từ a->z
     */
    public static void sapXepTheoTen() {
        Collections.sort(list, (a, b) -> a.getHoTen().compareTo(b.getHoTen()));
    }


    /**
     * hàm sắp xếp nhân viên theo thu nhập từ thấp đến cao
     */
    public static void sapXepTheoThuNhap() {
        Collections.sort(list, (a, b) -> (int) (a.getThuNhap() - b.getThuNhap()));
    }


    /**
     * hàm hiển thị top 5 nhân viên có thu nhập cao nhất
     */
    public static void hienThiTop5() {
        Collections.sort(list, (a, b) -> (int) (b.getThuNhap() - a.getThuNhap()));
        for (int i = 0; i < 5 && i < list.size(); i++) {
            list.get(i).xuat();
        }
    }


    /**
     * set up menu giao diện
     */
    public static void showMenu() {
        System.out.println("**********Quản Lí Nhân Viên Công Ty**********");
        System.out.println("Chon 1: Nhap danh sách nhân viên ");
        System.out.println("Chon 2: Hien thi danh sach nhân viên");
        System.out.println("Chon 3: tìm và hiển thị nhân viên theo mã số");
        System.out.println("Chon 4: Xóa nhân viên ");
        System.out.println("Chon 5: Cập nhật lại thông tin nhân viên");
        System.out.println("Chon 6: Tìm nhân viên theo khoảng lương ");
        System.out.println("Chon 7: Sắp xếp nhân viên theo họ tên ");
        System.out.println("Chon 8: Sắp xếp nhân viên theo thu nhập ");
        System.out.println("Chon 9: Hiển thị 5 nhân viên có thu nhập cao nhất ");
        System.out.println("Chon 10: Thoát chương trình ");

    }


    /**
     * Hàm để lựa chọn các case theo danh mục
     */
    public static void choose() {
        int numberChoose;
        do {
            showMenu();
            System.out.println("\n<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
            System.out.println("Nhap lua chon");
            numberChoose = scanner.nextInt();
            switch (numberChoose) {
                case 1:
                    System.out.println("Nhập danh sách nhân viên");
                    nhap();
                    break;
                case 2:
                    xuat();
                    break;
                case 3:
                    scanner.nextLine();
                    timVaHienThiTheoMa(scanner);
                    break;
                case 4:
                    scanner.nextLine();
                    xoaNhanVienTheoMa(scanner);
                    xuat();
                    break;
                case 5:
                    scanner.nextLine();
                    capNhatTheoMa(scanner);
                    xuat();
                    break;
                case 6:
                    scanner.nextLine();
                    timTheoKhoangLuong(scanner);
                    xuat();
                    break;
                case 7:
                    sapXepTheoTen();
                    xuat();
                    break;
                case 8:
                    sapXepTheoThuNhap();
                    xuat();
                    break;
                case 9:
                    hienThiTop5();
                    xuat();
                    break;
                default:
                    System.out.println("Nhap lai lua chon !");
            }
        } while (numberChoose != 10);
    }
}
