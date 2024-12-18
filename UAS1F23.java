//Nama : Rafi Adrian Prasetya
//NIM : 244107020026
//Nomor Absen : 23

import java.util.Scanner;

public class UAS1F23 {

    //variable global
    static int jumlahTim23 = (26 % 3) + 4;
    static int maxTim23 = jumlahTim23;
    static int maxLevel23 = 2;
    static String namaTim23[] = new String[jumlahTim23];
    static int skor23[][] = new int[jumlahTim23][maxLevel23];
    static int totalSkor23[] = new int[jumlahTim23];

    //fungsi main
    public static void main(String[] args) {
        Scanner input23 = new Scanner(System.in);

        boolean isRun23 = true;
        //loop akan berjalan terus, hanya akan berhenti jika user input 4
        while (isRun23) {
            header();
            int pilih23 = input23.nextInt();
            switch (pilih23) {
                case 1:
                    inputData();
                    break;
                case 2:
                    tampilkanTabel();
                    break;
                case 3:
                    tentukanJuara();
                    break;
                case 4:
                    System.out.println("Program Selesai!");
                    System.out.println("Terima Kasih!");
                    isRun23 = false;
                    break;
                default:
                    break;
            }
        }
    }

    //fungsi header
    public static void header() {
        System.out.println("\n=== MENU UTAMA ===");
        System.out.println("1. Input Data Skor Tim");
        System.out.println("2. Tampilkan Tabel Skor");
        System.out.println("3. Tentukan Juara");
        System.out.println("4. Keluar");
        System.out.print("Pilih Menu : ");
    }

    //fungsi tambah data tim & skor
    public static void inputData() {
        Scanner input23 = new Scanner(System.in);

        System.out.println("\n--- Tambah Data Tim ---");

        for (int i = 0; i < maxTim23; i++) {
            System.out.print("\nMasukkan nama tim ke-" + (i + 1) + " : ");
            namaTim23[i] = input23.nextLine();

            for (int j = 0; j < maxLevel23; j++) {
                System.out.print("Masukkan skor " + namaTim23[i] + " untuk level " + (j +1) + " : ");
                skor23[i][j] = input23.nextInt();
                input23.nextLine();
                if (j == 0 && skor23[i][j] < 35) {
                    skor23[i][j] = 0;
                }
            }
        }
    }

    //fungsi tampilkan tabel
    public static void tampilkanTabel() {
        System.out.println("\nNamaTim\t\t\tLevel 1\t\t\tLevel 2\t\t\tTotal Skor");
        for (int i = 0; i < jumlahTim23; i++) {
            if (namaTim23[i] == null) {
                System.out.println("Belum ada data.");
            }
            totalSkor23[i] = skor23[i][0] + skor23[i][1];
            if (totalSkor23[i] % 2 == 0) {
                totalSkor23[i] -= 15;
            }

            if (skor23[i][0] > 50 && skor23[i][1] > 50) {
                totalSkor23[i] += 23;
            }
            System.out.println(namaTim23[i] + "\t\t\t" + skor23[i][0] + "\t\t\t" + skor23[i][1] + "\t\t\t" + totalSkor23[i]);
        }
    }

    //fungsi tentukan juara
    public static void tentukanJuara() {
        String juara23 = " ";
        int skorTertinggi23 = 0;
        boolean seri = false;
        
        for (int i = 0; i < jumlahTim23; i++) {
            if (namaTim23[i] == null) {
                System.out.println("Belum ada data.");
            }
            if (totalSkor23[i] > skorTertinggi23) {
                skorTertinggi23 = totalSkor23[i];
                juara23 = namaTim23[i];
                seri = false;
            } else if (totalSkor23[i] == skorTertinggi23) {
                if (skor23[i][1] == skor23[jumlahTim23 - 1][1]) {
                    seri = true;
                }
            }
        }

        if (seri) {
            System.out.println("Turnamen berakhir seri. Tim terbaik anda adalah");
        } else {
            System.out.println("Selamat kepada Tim " + juara23 + "yang telah memenangkan kompetisi");
        }
    }
}
