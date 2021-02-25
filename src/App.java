import java.util.*;

public class App {

    static User register(String nama, String email, String noTelp, String password, ArrayList<User> allUser) {
        User curUser = new User(nama, email, noTelp, password);
        allUser.add(curUser);
        return curUser;
    }

    static User login(ArrayList<User> allUser, String noTelp, String pass, ListUser listUser) {
        User curUser = listUser.findUserByPhone(allUser, noTelp);
        if(curUser.password.equals(pass)) {
            return curUser;
        }
        else return null;
    }

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ListUser allUser = new ListUser();
        allUser.allUser.add(new User("Ariana", "arianagrande@grande.com", "1111010111", "password"));
        allUser.allUser.add(new User("Shawn", "shawn@grande.com", "2220003333", "itsshawnmendes"));
        allUser.allUser.add(new User("Sel", "sel@grande.com", "1010101010", "misselenag"));
        User currentUser = null;

        boolean loggedIn = false;

        while(true) {
            while(!loggedIn) {
                System.out.println("Selamat Datang");
                System.out.println("Sudah punya akun? ('sudah' / 'belum')");
                System.out.println("(tekan enter untuk keluar)");
                String val = scan.nextLine();

                switch (val) {
                    case "sudah":
                        while (currentUser == null) {
                            System.out.print("Nomor telepon kamu:");
                            String no = scan.nextLine();
                            System.out.print("Password:");
                            String pass = scan.nextLine();
                            if(login(allUser.allUser, no, pass, allUser) == null) continue;
                            else {
                                currentUser = login(allUser.allUser, no, pass, allUser);
                                loggedIn = true;
                            }
                            break;
                        }
                    case "belum":
                        while (currentUser == null) {
                            System.out.print("Nama kamu: ");
                            String nama = scan.nextLine();
                            System.out.print("Email kamu: ");
                            String email = scan.nextLine();
                            System.out.print("Nomor telepon kamu: ");
                            String phone = scan.nextLine();
                            System.out.print("Password: ");
                            String password = scan.nextLine();
                            currentUser = register(nama, email, phone, password, allUser.allUser);
                            allUser.allUser.add(register(nama, email, phone, password, allUser.allUser));
                            loggedIn = true;
                        }
                        break;
                    default:
                        System.exit(0);
                }

                while(loggedIn) {
                    System.out.println("Hai " + currentUser.nama + " !");
                    System.out.println("Mau apa hari ini?");
                    System.out.println("1       Top Up");
                    System.out.println("2       Transfer");
                    System.out.println("3       Lihat profil");
                    System.out.println("4       Log out");
                    System.out.println("Enter   Keluar");
                    System.out.println();
                    System.out.print("Pilihanmu: ");

                    String userPick = scan.nextLine();
                    switch (userPick) {
                        case "1":
                            System.out.println("Mau top up berapa?");
                            double jumlahTopUp = scan.nextDouble();
                            currentUser.topUp(jumlahTopUp);
                            System.out.println("Kamu berhasil Top Up sejumlah " + jumlahTopUp + ".");
                            System.out.println("Saldo akun kamu sekarang " + currentUser.saldo + ".");
                            scan.nextLine();
                            System.out.println();
                            break;
                        case "2":
                            System.out.print("Masukkan nomor telepon yang kamu tuju: ");
                            String no = scan.nextLine();
                            if (allUser.findUserByPhone(allUser.allUser, no) != null) {
                                System.out.print("Mau transfer berapa?");
                                double jumlahTransfer = scan.nextDouble();
                                if(currentUser.saldo < jumlahTransfer) System.out.println("Saldo kamu tidak mencukupi untuk melakukan transfer ini. \n");
                                else {
                                    currentUser.transfer(allUser.findUserByPhone(allUser.allUser, no), jumlahTransfer);
                                    System.out.println("Transfer sejumlah " + jumlahTransfer + "Berhasil.");
                                    System.out.println(" Sisa saldo kamu " + currentUser.saldo + ".");
                                    System.out.println();
                                }
                            } else {
                                System.out.println("Nomor yang kamu tuju tidak terdaftar.\n");
                            }
                            break;
                        case "3":
                            currentUser.showProfile();
                            System.out.println();
                            break;
                        case "4":
                            currentUser = null;
                            loggedIn = false;
                            break;
                        default:
                            System.exit(0);
                            break;
                    }
                }

            }
        }

    }
}