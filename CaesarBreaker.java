import edu.duke.FileResource;

public class CaesarBreaker {
    public int[] countLetters (String message) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                counts[dex]++;
            }
        }
        return counts;
    }
    
    public int maxIndex (int[] values) {
        int indexMax = 0;
        int mostCommon = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > mostCommon) {
                mostCommon = values[i];
                indexMax = i;
            }
        }
        return indexMax;
    }
    
    public String[] separateString (String message) {
        String[] halves = new String[2];
        for (int i = 0; i < message.length(); i++) {
            if (i % 2 == 0) {
                halves[0] = halves[0] + message.charAt(i);
            }
            else {
                halves[1] = halves[1] + message.charAt(i);
            }
        }
        return halves;
    }
    
    public int findKey (String messsage) {
        int[] freqs = countLetters(messsage);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }
    
    public String decryptOneKey (String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int dkey = findKey(encrypted);
        return cc.encrypt(encrypted, 26 - dkey);
    }
    
    public String decryptTwoKeys (String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        String[] halves = separateString(encrypted);
        int key1 = findKey(halves[0]);
        int key2 = findKey(halves[1]);
        System.out.println("Key 1: " + key1 + "\nKey 2: " + key2);
        return cc.encryptTwoKeys(encrypted, 26 - key1, 26 - key2);
    }
    
    public void testDecryptOneKey () {
        FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println(decryptOneKey(message));
    }
    
    public void testDecryptTwoKeys () {
        FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println(decryptTwoKeys(message));
    }
}
