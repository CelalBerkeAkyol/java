/*
 * Banka Uygulaması - Account Sınıfı
 */
package basicbankapp;

/**
 * Banka hesapları için abstract temel sınıf
 * @author celalberkeakyol
 */
public abstract class Account {
    private String accountNumber;    // Hesap numarası
    private double balance;          // Hesap bakiyesi
    private Customer owner;          // Hesap sahibi

    // Constructor
    public Account(String accountNumber, Customer owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0.0;
        owner.addAccount(this); // Hesap oluşturulduğunda müşterinin hesap listesine eklenir
    }

    // Para yatırma metodu
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Yatırılan miktar 0'dan büyük olmalıdır");
        }
        balance += amount;
        System.out.println(amount + " TL hesabınıza yatırıldı. Yeni bakiye: " + balance + " TL");
    }

    // Para çekme metodu
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Çekilecek miktar 0'dan büyük olmalıdır");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Yetersiz bakiye: " + balance + " TL. Çekilmek istenen: " + amount + " TL");
        }
        balance -= amount;
        System.out.println(amount + " TL hesabınızdan çekildi. Yeni bakiye: " + balance + " TL");
    }

    // Getter metodları
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public Customer getOwner() { return owner; }
    
    // Bakiyeyi güncellemek için protected metod (alt sınıflarda kullanılacak)
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Hesap bilgilerini string olarak döndüren metod
    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", owner=" + owner.getName() +
                '}';
    }
} 