import java.text.NumberFormat;
import java.util.Scanner;
 
public class Account {
    private long SoTaiKhoan;
    private String TenTaiKhoan;
    private double SoTienTrongTaiKhoan;
 
    Scanner sc = new Scanner(System.in);
 
    public Account() {
    }
    public Account(long SoTaiKhoan, String TenTaiKhoan, double SoTienTrongTaikhoan) {
        this.SoTaiKhoan = SoTaiKhoan;
        this.TenTaiKhoan = TenTaiKhoan;
        this.SoTienTrongTaiKhoan = SoTienTrongTaiKhoan;
    }
    public long getSoTaiKhoan() {
        return this.SoTaiKhoan;
    }
 
    public void setSoTaiKhoan(long SoTaiKhoan) {
        this.SoTaiKhoan = SoTaiKhoan;
    }
    
    public String getTenTaiKhoan() {
        return this.TenTaiKhoan;
    }
 
    public void setTenTaiKhoan(String TenTaiKhoan) {
        this.TenTaiKhoan = TenTaiKhoan;
    }
 
    public double getSoTienTrongTaiKhoan() {
        return this.SoTienTrongTaiKhoan;
    }
 
    public void setSoTienTrongTaiKhoan(double SoTienTrongTaiKhoan) {
        this.SoTienTrongTaiKhoan = SoTienTrongTaiKhoan;
    }
    @Override
    public String toString() {
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance();
        String str1 = currencyVN.format(SoTienTrongTaiKhoan);
        return SoTaiKhoan + "-" + SoTaiKhoan + "-" + str1;
    }
    public double napTien() {
        double nap;
        System.out.print("Nhập số tiền bạn cần nạp: ");
        nap = sc.nextDouble();
        if (nap >= 0) {
            SoTienTrongTaiKhoan = nap + SoTienTrongTaiKhoan;
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance();
            String str1 = currencyVN.format(nap);
            System.out.println("bạn vừa nạp " + str1 + " vào tài khoản.");
        } else {
            System.out.println("Số tiền nạp vào không hợp lệ!");
        }
        return nap;
    }
 
    public double rutTien() {
        double phi = 5;
        double rut;
        System.out.print("Nhập số tiền bạn cần rút: ");
        rut = sc.nextDouble();
        if (rut <= (SoTienTrongTaiKhoan - phi)) {
            SoTienTrongTaiKhoan = SoTienTrongTaiKhoan - (rut + phi);
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance();
            String str1 = currencyVN.format(rut);
            System.out.println("Bạn vừa rút " + str1 + "Đ từ tài khoản. Phí là $5.");
        } else {
            System.out.println("Số tiền muốn rút không hợp lệ!");
            return rutTien();
        }
        return rut;
    }
    public double daoHan() {
        double laiSuat = 0.035;
        SoTienTrongTaiKhoan = SoTienTrongTaiKhoan + SoTienTrongTaiKhoan * laiSuat;
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance();
        String str1 = currencyVN.format(SoTienTrongTaiKhoan);
        System.out.println("Bạn vừa được " + str1 + " từ đáo hạn 1 tháng");
        return SoTienTrongTaiKhoan;
    }
 
    void inTK() {
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance();
        String str1 = currencyVN.format(SoTienTrongTaiKhoan);
        System.out.printf("%-10d %-20s %-20s ", SoTaiKhoan, TenTaiKhoan, str1);
    }
}
