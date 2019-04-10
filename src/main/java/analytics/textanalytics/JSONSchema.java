package analytics.textanalytics;

public class JSONSchema {
    private String text;
    private int capitalCount;

    public String[] splitToWords() {
        String[] wordArray = this.text.split("\\s");
        return wordArray;
    }

    public int capitalFirstCount() {
        String[] wordArray = this.text.split("\\s");
        for (int i = 0; i < wordArray.length; i++) {
            if (Character.isUpperCase(wordArray[i].charAt(0))) {
                capitalCount++;
            }
        }
        return capitalCount;
    }

    

    
        
}