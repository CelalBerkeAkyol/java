/*
 * Banka Uygulaması - CheckingAccount Sınıfı
 */
package basicbankapp;

/**
 * Vadesiz hesap sınıfı - Account sınıfından türemiştir
 * @author celalberkeakyol
 */
public class CheckingAccount extends Account {
    private double overdraftLimit; // Hesap eksi bakiyeye düşebilir (kredi limiti)
    
    // Standart Constructor
    public CheckingAccount(String accountNumber, Customer owner) {
        super(accountNumber, owner);
        this.overdraftLimit = 0; // Varsayılan olarak kredi limiti yok
    }
    
    // Kredi limiti olan hesap için Constructor
    public CheckingAccount(String accountNumber, Customer owner, double overdraftLimit) {
        super(accountNumber, owner);
        this.overdraftLimit = Math.max(0, overdraftLimit); // Kredi limiti 0 veya pozitif olmalı
    }
    
    // Kredi limiti getter
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
    
    // Kredi limiti setter
    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = Math.max(0, overdraftLimit); // Kredi limiti 0 veya pozitif olmalı
    }
    
    // Para çekme işlemini kredi limitini de göz önünde bulundurarak override ediyoruz
    @Override
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Çekilecek miktar 0'dan büyük olmalıdır");
        }
        
        double totalAvailableFunds = getBalance() + overdraftLimit;
        
        if (amount > totalAvailableFunds) {
            throw new InsufficientFundsException("Yetersiz bakiye ve kredi limiti. " +
                    "Bakiye: " + getBalance() + " TL, " +
                    "Kredi limiti: " + overdraftLimit + " TL, " +
                    "Çekilmek istenen: " + amount + " TL");
        }
        
        setBalance(getBalance() - amount);
        
        if (getBalance() < 0) {
            System.out.println(amount + " TL hesabınızdan çekildi. " +
                    "Yeni bakiye: " + getBalance() + " TL (Kredi limitiniz kullanılıyor)");
        } else {
            System.out.println(amount + " TL hesabınızdan çekildi. Yeni bakiye: " + getBalance() + " TL");
        }
    }
    
    // Hesap bilgilerini özelleştirilmiş string olarak döndüren metod
    @Override
    public String toString() {
        return "CheckingAccount{" +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", balance=" + getBalance() + " TL" +
                ", overdraftLimit=" + overdraftLimit + " TL" +
                ", owner=" + getOwner().getName() +
                '}';
    }
} 