import java.util.*;

public class App {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ListUser allUser = new ListUser();
        allUser.allUser.add(new User("Ariana", "arianagrande@grande.com", "10000000", "password"));
        allUser.allUser.add(new User("Shawn", "shawn@grande.com", "20000000", "itsshawnmendes"));
        allUser.allUser.add(new User("Sel", "sel@grande.com", "30000000", "misselenag"));
        User currentUser = null;

        boolean loggedIn = false;

        while(true) {
            while(!loggedIn) {
                System.out.println("Selamat Datang");
                System.out.println("Apakah anda sudah mempunyai akun? ('sudah' / 'belum')");
                System.out.println("(tekan enter untuk keluar)");
                String val = scan.nextLine();

                switch (val) {
                    case "sudah":
                        while (currentUser == null) {
                            System.out.println("Masukkan nomor telepon anda");
                            String no = scan.nextLine();
                            System.out.println("Masukkan password anda");
                            String pass = scan.nextLine();
                            if(allUser.login(allUser.allUser, no, pass) == null) continue;
                            else {
                                currentUser = allUser.login(allUser.allUser, no, pass);
                                loggedIn = true;
                            }
                            break;
                        }
                    case "belum":
                        while (currentUser == null) {
                            System.out.println("Masukkan nama anda");
                            String nama = scan.nextLine();
                            System.out.println("Masukkan email anda");
                            String email = scan.nextLine();
                            System.out.println("Masukkan nomor telepon anda");
                            String phone = scan.nextLine();
                            System.out.println("Masukkan password");
                            String password = scan.nextLine();
                            currentUser = allUser.register(nama, email, phone, password, allUser.allUser);
                            allUser.allUser.add(allUser.register(nama, email, phone, password, allUser.allUser));
                            loggedIn = true;
                        }
                        break;
                    default:
                        System.exit(0);
                }

                while(loggedIn) {
                    System.out.println("Hai " + currentUser.nama + " !");
                    System.out.println("Mau apa hari ini?");
                    System.out.println("1 Top Up");
                    System.out.println("2 Transfer");
                    System.out.println("3 Lihat profil");
                    System.out.println("4 Log out");
                    System.out.println("Enter Keluar");

                    String userPick = scan.nextLine();
                    switch (userPick) {
                        case "1":
                            System.out.println("Mau top up berapa?");
                            double jumlahTopUp = scan.nextDouble();
                            currentUser.topUp(jumlahTopUp);
                            System.out.println("Kamu berhasil Top Up sejumlah " + jumlahTopUp + ".");
                            System.out.println("Saldo akun kamu sekarang " + currentUser.saldo + ".");
                            scan.nextLine();
                            break;
                        case "2":
                            System.out.println("Masukkan nomor telepom");
                            String no = scan.nextLine();
                            if (allUser.findUserByPhone(allUser.allUser, no) != null) {
                                System.out.println("Mau transfer berapa?");
                                double jumlahTransfer = scan.nextDouble();
                                if(currentUser.saldo < jumlahTransfer) System.out.println("Saldo anda tidak mencukupi untuk melakukan transfer ini.");
                                else {
                                    currentUser.transfer(allUser.findUserByPhone(allUser.allUser, no), jumlahTransfer);
                                    System.out.println("Transfer Berhasil. Sisa saldo anda " + currentUser.saldo);
                                }
                            } else {
                                System.out.println("Nomor yang kamu tuju tidak terdaftar.");
                            }
                            break;
                        case "3":
                            currentUser.showProfile();
                            break;
                        case "4":
                            currentUser = null;
                            loggedIn = false;
                            break;
                        case "5":
                            System.exit(0);
                            break;
                        default:
                            continue;
                    }
                }

            }
        }

    }
}

