import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static void nhapTK(Account tk) {
        System.out.println("Nhập số tài khoản: ");
        tk.setSoTaiKhoan(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhập tên tài khoản: ");
        tk.setTenTaiKhoan(sc.nextLine());
        tk.setSoTienTrongTaiKhoan(50);
    }
    public static void main(String[] args) {
        Account a[] = null;
        int k, b, n = 0;
        long s, d, c, f;
        boolean flag = true;
        do {
            System.out.println("Bạn chọn làm gì: ");
            System.out.println("1.Nhập thông tin của các khách hàng");
            System.out.println("2.Xuất danh sách thông tin của các khách hàng" ); 
            System.out.println("3.Nạp tiền");
            System.out.println("4.Rút tiền");
            System.out.println("5.Đáo hạn");
            System.out.println ("6.Chuyển khoản")  ;
            System.out.println("Số khác để thoát");
            b = sc.nextInt();
            switch (b) {
                case 1 -> {
                    System.out.println("Nhập số lượng khách hàng bạn muốn nhập: ");
                    n = sc.nextInt();
                    a = new Account[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Khách hàng số: " + (i+1));
                        a[i] = new Account();
                        nhapTK(a[i]);
                    }
                }
                case 2 -> {
                    System.out.printf("%-10s %-20s %-20s", "Số TK", "Tên TK", "Số tiền trong TK");
                    for (int i = 0; i < n; i++) {
                        a[i].inTK();
                    }
                }
                case 3 -> {
                    System.out.println("Nhập số tài khoản khách hàng cần nạp tiền: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTaiKhoan();
                        if (s == d) {
                            System.out.println("Bạn chọn tài khoản: " + d);
                            a[i].napTien();
                        } else {
                            System.out.println("");
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Nhập số tài khoản khách hàng cần rút tiền: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTaiKhoan();
                        if (s == d) {
                            System.out.println("Bạn chọn tài khoản: " + d);
                            a[i].rutTien();
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Nhập số tài khoản khách hàng cần đáo hạn: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTaiKhoan();
                        if (s == d) {
                            System.out.println("Bạn chọn tài khoản: " + d);
                            a[i].daoHan();
                        } else {
                            System.out.println("");
                        }
                    }
                }
                case 6 -> {
                    double chuyen,
                            nhan,
                            tienChuyen;
                    System.out.print("Nhập số tài khoản khách hàng chuyển tiền: ");
                    s = sc.nextLong();
                    System.out.print("Nhập số tài khoản khách hàng nhận tiền: ");
                    c = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTaiKhoan();
                        if (s == d) {
                            chuyen = a[i].getSoTienTrongTaiKhoan();
                            for (int j = 0; j < n; j++) {
                                f = a[j].getSoTaiKhoan();
                                if (c == f) {
                                    nhan = a[j].getSoTienTrongTaiKhoan();
                                    System.out.println("Nhập số tiền cần chuyển");
                                    tienChuyen = sc.nextDouble();
                                    if (tienChuyen <= chuyen) {
                                        chuyen = chuyen - tienChuyen;
                                        nhan = nhan + tienChuyen;
                                        a[i].setSoTienTrongTaiKhoan(chuyen);
                                        a[j].setSoTienTrongTaiKhoan(nhan);
                                        System.out.println("Tài khoản số " + d + " vừa chuyển: $" + tienChuyen);
                                        System.out.println("Tài khoản số " + f + " vừa nhận: $" + tienChuyen);
                                    } else {
                                        System.out.println("Số tiền nhập không hợp lệ!");
                                    }
                                } else {
                                    System.out.println("");
                                }
                            }
                        } else {
                            System.out.println("");
                        }
                    }
                }
                default -> {
                    System.out.println("Bye!!");
                    flag = false;
                }
            }
        } while (flag);
    }
}
