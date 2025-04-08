/*
 * Banka Uygulaması - InsufficientFundsException Sınıfı
 */
package basicbankapp;

/**
 * Yetersiz bakiye durumlarında kullanılan exception sınıfı
 * @author celalberkeakyol
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
} 