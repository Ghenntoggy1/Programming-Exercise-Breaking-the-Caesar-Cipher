import edu.duke.FileResource;

public class WordLengths {
    public void countWordLengths (FileResource fr, int[] counts) {
        for (String word : fr.words()) {
            int wordLength = word.length();
            if (!Character.isLetter(word.charAt(0)) || (!Character.isLetter(word.charAt(word.length() - 1)) && word.length() != 1)) {
                wordLength--;
            }
            if (wordLength >= 30) {
                wordLength = 30;
            }
            counts[wordLength]++;
        }
        for (int i = 1; i < counts.length; i++) {
            System.out.println((i) + " : " + counts[i]);
        }
    }
    
    public int indexOfMax (int[] values) {
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
    
    public void testCountWordLengths () {
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        countWordLengths(fr, counts);
        System.out.println("Most commong word length in file: " + indexOfMax(counts));
    }
}
