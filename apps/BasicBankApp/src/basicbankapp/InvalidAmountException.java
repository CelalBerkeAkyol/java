/*
 * Banka Uygulaması - InvalidAmountException Sınıfı
 */
package basicbankapp;

/**
 * Geçersiz para miktarı durumlarında kullanılan exception sınıfı
 * @author celalberkeakyol
 */
public class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
} 