package pl.kondzio.converter;

public class StringFormatter {
    public static String reverseString(String string) {
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.reverse();
        return stringBuffer.toString();
    }
}
