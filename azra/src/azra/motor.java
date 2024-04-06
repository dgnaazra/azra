package azra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class motor {
    public static int tekliyorumSatirSayisi(String dosyaYolu) {
        int tekliyorumSatirSayisi = 0;
        int cokluYorumSatirSayisi = 0;
        int javadocYorumSatirSayisi = 0;
        boolean yorumIcinde = false;
dosyaYolu="motor.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                satir = satir.trim();
                if (satir.startsWith("//")) {
                    tekliyorumSatirSayisi++;
                } else if (satir.startsWith("/*")&& satir.endsWith("*/")) {
                    yorumIcinde = true;
                    cokluYorumSatirSayisi++;
                } else if (satir.startsWith("/**")&& satir.endsWith("*/")) {
                    yorumIcinde = true;
                    javadocYorumSatirSayisi++;
                 
                } else if (yorumIcinde) {
                    tekliyorumSatirSayisi++;
                    cokluYorumSatirSayisi++;
                    javadocYorumSatirSayisi++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tekliyorumSatirSayisi;
    }

    public static int cokluYorumSatirSayisi(String dosyaYolu) {
        int cokluYorumSatirSayisi = 0;
        boolean yorumIcinde = false;

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                satir = satir.trim();
                if (satir.startsWith("/*") && satir.endsWith("*/")) {
                    cokluYorumSatirSayisi++;
                 
                } else if (yorumIcinde) {
                    cokluYorumSatirSayisi++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cokluYorumSatirSayisi;
    }
    public static int javadocYorumSatirSayisi(String dosyaYolu) {
        int javadocYorumSatirSayisi = 0;
        boolean yorumIcinde = false;

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                satir = satir.trim();
                if (satir.startsWith("/**") && satir.endsWith("*/")) {
                    javadocYorumSatirSayisi++;
                 
                } else if (yorumIcinde) {
                    javadocYorumSatirSayisi++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return javadocYorumSatirSayisi;
    }

    public static void main(String[] args) {
        int tekliyorumSayisi = motor.tekliyorumSatirSayisi("teksatir.txt");
        int cokluYorumSayisi = motor.cokluYorumSatirSayisi("coksatir.txt");
        int javadocyorumSayisi = motor.tekliyorumSatirSayisi("javadoc.txt");
        System.out.println("Dosyadaki çoklu yorum satir sayisi: " + cokluYorumSayisi);
        System.out.println("Dosyadaki tekli yorum satırı sayısı: " + tekliyorumSayisi);
        System.out.println("Dosyadaki javadoc yorum satırı sayısı: " + javadocyorumSayisi);
    }

}
