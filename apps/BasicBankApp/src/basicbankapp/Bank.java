/*
 * Banka Uygulaması - Bank Sınıfı
 */
package basicbankapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Banka işlemlerini yöneten merkezi sınıf
 * @author celalberkeakyol
 */
public class Bank {
    private String name;
    private List<Customer> customers;
    private Map<String, Account> accounts;
    
    // Constructor
    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
        this.accounts = new HashMap<>();
    }
    
    // Müşteri ekleme metodu
    public Customer createCustomer(String id, String name, String email) {
        // Aynı ID'li müşteri var mı kontrolü
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                System.out.println("HATA: Bu ID'ye sahip müşteri zaten var: " + id);
                return null;
            }
        }
        
        Customer customer = new Customer(id, name, email);
        customers.add(customer);
        System.out.println("Yeni müşteri oluşturuldu: " + customer.getName());
        return customer;
    }
    
    // Vadesiz hesap açma metodu
    public CheckingAccount createCheckingAccount(String accountNumber, Customer owner, double overdraftLimit) {
        // Hesap numarası kontrolü
        if (accounts.containsKey(accountNumber)) {
            System.out.println("HATA: Bu hesap numarası zaten kullanılıyor: " + accountNumber);
            return null;
        }
        
        CheckingAccount account = new CheckingAccount(accountNumber, owner, overdraftLimit);
        accounts.put(accountNumber, account);
        System.out.println("Yeni vadesiz hesap oluşturuldu: " + accountNumber + 
                " (Sahip: " + owner.getName() + ", Kredi Limiti: " + overdraftLimit + " TL)");
        return account;
    }
    
    // Vadeli hesap açma metodu
    public SavingsAccount createSavingsAccount(String accountNumber, Customer owner, double interestRate) {
        // Hesap numarası kontrolü
        if (accounts.containsKey(accountNumber)) {
            System.out.println("HATA: Bu hesap numarası zaten kullanılıyor: " + accountNumber);
            return null;
        }
        
        SavingsAccount account = new SavingsAccount(accountNumber, owner, interestRate);
        accounts.put(accountNumber, account);
        System.out.println("Yeni vadeli hesap oluşturuldu: " + accountNumber + 
                " (Sahip: " + owner.getName() + ", Faiz Oranı: " + interestRate + "%)");
        return account;
    }
    
    // Hesaplar arası para transferi
    public boolean transferMoney(String fromAccountNumber, String toAccountNumber, double amount) {
        try {
            // Hesapları bul
            Account fromAccount = accounts.get(fromAccountNumber);
            Account toAccount = accounts.get(toAccountNumber);
            
            if (fromAccount == null || toAccount == null) {
                System.out.println("HATA: Hesap bulunamadı.");
                return false;
            }
            
            // Para çek
            fromAccount.withdraw(amount);
            
            // Para yatır
            toAccount.deposit(amount);
            
            System.out.println(amount + " TL " + fromAccountNumber + " hesabından " + 
                    toAccountNumber + " hesabına aktarıldı.");
            return true;
            
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Transfer hatası: " + e.getMessage());
            return false;
        }
    }
    
    // Hesap bilgisi getirme
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
    
    // Müşteri bilgisi getirme
    public Customer getCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
    
    // Banka adı getter
    public String getName() {
        return name;
    }
    
    // Tüm müşterileri listeleme
    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }
    
    // Tüm hesapları listeleme
    public List<Account> getAccounts() {
        return new ArrayList<>(accounts.values());
    }
} 