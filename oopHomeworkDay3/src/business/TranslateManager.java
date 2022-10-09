package business;

public class TranslateManager {



    public TranslateManager() {
    }


    public final String TurkishToEnglish(String data) {

        String result = "";
        char[] oldLetter = new char[]{'İ', 'ı', 'ü', 'Ü', 'ç', 'Ç', 'Ğ', 'ğ', 'Ş', 'ş', 'ö', 'Ö'};
        char[] newLetter = new char[]{'I', 'i', 'u', 'U', 'c', 'C', 'G', 'g', 'S', 's', 'o', 'O',};

        for (int i = 0; i < oldLetter.length; i++) {
            data = data.replace(oldLetter[i], newLetter[i]);
        }

        result = data;
        return result;
    }
}
