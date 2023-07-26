import edu.duke.FileResource;

public class CaesarCipher {
    public String encrypt (String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if (idx != -1) {
                if (Character.isUpperCase(currChar)) {
                    char newChar = shiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
                else {
                    char newChar = shiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }
            }
        }
        return encrypted.toString(); 
    }
    
    public String encryptTwoKeys (String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if (idx != -1) {
                if (Character.isUpperCase(currChar)) {
                    if (i % 2 == 0) {
                        char newChar = shiftedAlphabet1.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                    else {
                        char newChar = shiftedAlphabet2.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                }
                else {
                    if (i % 2 == 0) {
                        char newChar = shiftedAlphabet1.charAt(idx);
                        encrypted.setCharAt(i, Character.toLowerCase(newChar));
                    }
                    else {
                        char newChar = shiftedAlphabet2.charAt(idx);
                        encrypted.setCharAt(i, Character.toLowerCase(newChar));
                    }
                }
            }
        }
        return encrypted.toString();
    }
    
    public void testCaesar () {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
    
    public void testTwoKeys () {
        int key1 = 8;
        int key2 = 21;
        FileResource fr = new FileResource();
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        String encrypted = encryptTwoKeys(message, key1, key2);
        System.out.println(encrypted);
        String decrypted = encryptTwoKeys(encrypted, 26-key1, 26-key2);
        System.out.println(decrypted);
    }
}
