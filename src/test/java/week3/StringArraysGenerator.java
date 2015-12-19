package week3;

/**
 * Created by Matija Vižintin
 * Date: 19. 12. 2015
 * Time: 21:39
 */
public class StringArraysGenerator {

    public static String[] generate(int arrayLength, int stringLength) {
        return generate(arrayLength, stringLength, stringLength);
    }

    public static String[] generate(int arrayLength, int stringLengthMin, int stringLengthMax) {
        // 65 = A, 90 = Z
        String[] result = new String[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            int len = (int)(Math.random() * (stringLengthMax - stringLengthMin)) + stringLengthMin;
            result[i] = computeString(len);
        }
        return result;
    }

    private static String computeString(int len) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < len; j++) {
            sb.append((char)((int)(Math.random() * 25) + 65));
        }
        return sb.toString();
    }
}
