/*
 * Banka Uygulaması - Customer Sınıfı
 */
package basicbankapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Banka müşterisi bilgilerini tutan sınıf
 * @author celalberkeakyol
 */
public class Customer {
    private String id;          // Müşteri ID'si
    private String name;        // Müşteri adı
    private String email;       // Müşteri email adresi
    private List<Account> accounts; // Müşterinin hesaplarını tutan liste

    // Constructor - Yeni bir müşteri oluşturulduğunda çağrılır
    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.accounts = new ArrayList<>(); // Boş bir hesap listesi ile başlar
    }

    // Getter metodları - private değişkenlere güvenli erişim sağlar
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    // Müşteriye yeni hesap ekleme metodu
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Müşterinin hesaplarını güvenli bir şekilde döndüren metod
    public List<Account> getAccounts() {
        return new ArrayList<>(accounts); // Orijinal listeyi korumak için kopya döndürüyoruz
    }

    // Müşteri bilgilerini string olarak döndüren metod
    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", number of accounts=" + accounts.size() +
                '}';
    }
} 