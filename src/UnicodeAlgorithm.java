public class UnicodeAlgorithm implements Algorithm {

    @Override
    public String cipher(String mode, String text, int key) {
        if ("enc".equals(mode)) {
            char[] charArray = text.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = (char) (charArray[i] + key);
            }
            return String.valueOf(charArray);
        } else {
            char[] charArray = text.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = (char) (charArray[i] - key);
            }
            return String.valueOf(charArray);
        }

    }
}
