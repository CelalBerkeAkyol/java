/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.basicinterestcalculator;
import java.util.Scanner;
/**
 *
 * @author celalberkeakyol
 */
public class BasicInterestCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double anaPara;
        double faizOrani;
        int dönemSayisi;
        int yil;
        double toplamTutar;

        System.out.println("Ana para miktarını giriniz: ");
        anaPara = scanner.nextDouble();

        System.out.println("Bankamızın faiz oranını giriniz: ");
        faizOrani = scanner.nextDouble() / 100;

        System.out.println("1 yılda kaç kere faiz alacaksınız  giriniz: ");
        dönemSayisi = scanner.nextInt();

        System.out.println("Kaç yıllık faiz alacaksınız giriniz: ");
        yil = scanner.nextInt();

        toplamTutar = anaPara * Math.pow(1 + faizOrani / dönemSayisi, dönemSayisi * yil);

        System.out.println("Girdiğiniz bilgiler: ");
        System.out.println("Ana para: " + anaPara);
        System.out.println("Faiz oranı: " + faizOrani);
        System.out.println("1 yılda kaç kere faiz alacaksınız: " + dönemSayisi);
        System.out.println("Kaç yıllık faiz alacaksınız: " + yil);

        System.out.println("Toplam tutar: " + toplamTutar);
        
      

    }
}
