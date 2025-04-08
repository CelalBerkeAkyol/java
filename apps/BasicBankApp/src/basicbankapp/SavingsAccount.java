/*
 * Banka Uygulaması - SavingsAccount Sınıfı
 */
package basicbankapp;

/**
 * Vadeli hesap sınıfı - Account sınıfından türemiştir
 * Faiz oranı içerir ve faiz hesaplaması yapabilir
 * @author celalberkeakyol
 */
public class SavingsAccount extends Account {
    private double interestRate; // Faiz oranı (yüzde olarak)
    
    // Constructor
    public SavingsAccount(String accountNumber, Customer owner, double interestRate) {
        super(accountNumber, owner);
        setInterestRate(interestRate);
    }
    
    // Faiz oranı getter
    public double getInterestRate() {
        return interestRate;
    }
    
    // Faiz oranı setter
    public void setInterestRate(double interestRate) {
        this.interestRate = Math.max(0, interestRate); // Faiz oranı negatif olamaz
    }
    
    /**
     * Hesaba faiz uygular
     * @param months Faiz uygulanacak ay sayısı
     */
    public void addInterest(int months) throws InvalidAmountException {
        if (months <= 0) {
            throw new InvalidAmountException("Ay sayısı 0'dan büyük olmalıdır");
        }
        
        double currentBalance = getBalance();
        // Aylık faiz hesaplama (yıllık faizin 1/12'si)
        double monthlyRate = interestRate / 12.0 / 100.0;
        double interest = 0;
        
        // Bileşik faiz hesabı
        for (int i = 0; i < months; i++) {
            interest += currentBalance * monthlyRate;
            currentBalance += currentBalance * monthlyRate;
        }
        
        // Faizi hesaba ekle
        setBalance(getBalance() + interest);
        System.out.println("Hesabınıza " + months + " aylık faiz uygulandı: " + 
                String.format("%.2f", interest) + " TL. Yeni bakiye: " + 
                String.format("%.2f", getBalance()) + " TL");
    }
    
    // Para çekme işlemini sınırlandırıyoruz (vadeli hesaplar için para çekme kısıtlaması)
    @Override
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        // Faiz kaybı uyarısı
        System.out.println("UYARI: Vadeli hesaptan para çekerseniz, faiz kaybı yaşayabilirsiniz!");
        super.withdraw(amount);
    }
    
    // Hesap bilgilerini özelleştirilmiş string olarak döndüren metod
    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", balance=" + getBalance() + " TL" +
                ", interestRate=" + interestRate + "%" +
                ", owner=" + getOwner().getName() +
                '}';
    }
} 