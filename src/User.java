public class User {
    String nama;
    String email;
    String noTelp;
    String password;
    double saldo = 0;

    User(String nama, String email, String noTelp, String password) {
        this.nama = nama;
        this.email = email;
        this.noTelp = noTelp;
        this.password = password;
    }

    void showProfile() {
        System.out.println("Nama : " + this.nama);
        System.out.println("email : " + this.email);
        System.out.println("Nomor Telepon : " + this.noTelp);
        System.out.println("Jumlah saldo : " + this.saldo);
    }

    void topUp(double jumlahTopUp) {
        this.saldo += jumlahTopUp;
    }

    void transfer(User to, double transfer) {
        this.saldo -= transfer;
        to.saldo += transfer;
    }

}

