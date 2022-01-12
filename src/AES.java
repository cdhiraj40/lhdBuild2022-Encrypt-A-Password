import java.security.Key;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.commons.codec.binary.Base64;



public class AES {
	
	private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "1234567891234567".getBytes();
    
    public static void main(String[] args) throws Exception {
        Key key = generateKey();
        String password;
        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter a password to encrypt: ");
        password = scanner.nextLine();
        String encryptValue = encrypt(password,key);
        System.out.print("Encrypted password is " + encryptValue);
   }
 
    private static Key generateKey() {
        return new SecretKeySpec(keyValue, ALGORITHM);
    }
    
    public static String encrypt(String valueToEnc, Key key) throws Exception {
    	 
        
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
  
        byte[] encryptionVal = cipher.doFinal(valueToEnc.getBytes());
        byte[] encryptedByteValue = new Base64().encode(encryptionVal);

        return new String(encryptedByteValue);
    }
}
