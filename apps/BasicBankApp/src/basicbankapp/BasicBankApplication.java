/*
 * Banka Uygulaması - Main Sınıfı
 */
package basicbankapp;

/**
 * Banka uygulamasını test eden ana sınıf
 * @author celalberkeakyol
 */
public class BasicBankApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Banka oluştur
            Bank bank = new Bank("Java Bankası");
            System.out.println("====== " + bank.getName() + " Hoş Geldiniz! ======");
            System.out.println();
            
            // Müşteriler oluştur
            Customer ahmet = bank.createCustomer("1", "Ahmet Yılmaz", "ahmet@email.com");
            Customer ayse = bank.createCustomer("2", "Ayşe Demir", "ayse@email.com");
            System.out.println();
            
            // Hesaplar oluştur
            CheckingAccount ahmetVadesiz = bank.createCheckingAccount("C001", ahmet, 1000);
            SavingsAccount ahmetVadeli = bank.createSavingsAccount("S001", ahmet, 15.5);
            CheckingAccount ayseVadesiz = bank.createCheckingAccount("C002", ayse, 500);
            System.out.println();
            
            // Para yatırma işlemleri
            System.out.println("===== Para Yatırma İşlemleri =====");
            ahmetVadesiz.deposit(5000);
            ahmetVadeli.deposit(10000);
            ayseVadesiz.deposit(3000);
            System.out.println();
            
            // Para çekme işlemleri
            System.out.println("===== Para Çekme İşlemleri =====");
            ahmetVadesiz.withdraw(2000);
            try {
                ahmetVadesiz.withdraw(5000); // Bakiye yetersiz, kredi limitini kullanacak
            } catch (InsufficientFundsException e) {
                System.out.println("Hata: " + e.getMessage());
            }
            System.out.println();
            
            // Transfer işlemleri
            System.out.println("===== Transfer İşlemleri =====");
            bank.transferMoney("C001", "C002", 1500);
            System.out.println();
            
            // Vadeli hesap faiz işlemi
            System.out.println("===== Faiz İşlemleri =====");
            ahmetVadeli.addInterest(6); // 6 aylık faiz uygula
            System.out.println();
            
            // Hesap özeti
            System.out.println("===== Hesap Özetleri =====");
            System.out.println(ahmetVadesiz);
            System.out.println(ahmetVadeli);
            System.out.println(ayseVadesiz);
            
        } catch (Exception e) {
            System.out.println("Beklenmeyen hata: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 