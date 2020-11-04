package pl.kondzio.converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class NumeralConverter {


    public String decimalToBinary(int decimal) {
//        int binaryResult = 0;
//        int counter = 0;

//        while (decimal!=0) {
//            int reminder = decimal % 2;
//            double temp = Math.pow(10,counter);
//            binaryResult += reminder * temp;
//            decimal /= 2;
//            counter++;
//        }
//        return binaryResult;
        String binaryStorage = "";
        while (decimal > 0) {
            binaryStorage += String.valueOf(Math.floorMod(decimal, 2));
            decimal = Math.floorDiv(decimal, 2);
        }

        String result = StringFormatter.reverseString(binaryStorage);
        return result;
    }

    public int binaryToDecimal(int binary) {
        int result = 0;
        int powBase = 1;

        int tempBinary = binary;

        while (tempBinary > 0) {
            int lastDigitOfNumber = Math.floorMod(tempBinary, 10);
            tempBinary = Math.floorDiv(tempBinary, 10);

            result += lastDigitOfNumber * powBase;
            powBase *= 2;
        }
        return result;
    }

    public String decimalToHex(int decimal) {
        List<Character> result = new ArrayList<>();
        String outputResult = "";
        int tempDecimal = decimal;

        while (tempDecimal > 0) {

            int reminder = Math.floorMod(tempDecimal, 16);
            if (reminder < 10) {
                result.add((char) (reminder + 48));
            } else {
                result.add((char) (reminder + 55));
            }

            tempDecimal = Math.floorDiv(tempDecimal, 16);
        }

        for (Character character : result) {
            outputResult += character.toString().toUpperCase();
        }
        outputResult = StringFormatter.reverseString(outputResult);

        return outputResult;
    }

    public int hexToDecimal(String hex) {
        int pow = 1;
        int result = 0;

        for (int i = hex.length() - 1; i >= 0; i--) {
            if (hex.charAt(i) >= '0' && hex.charAt(i) <= '9') {
                result += (hex.charAt(i) - 48) * pow;
                pow = pow * 16;
            }
            else if (hex.charAt(i) >= 'A' && hex.charAt(i) <= 'F') {
                result += (hex.charAt(i) - 55) * pow;
                pow = pow * 16;
            }
            else {
                throw new IllegalArgumentException("Wrong input.");
            }
        }

        return result;
    }

    public String binaryToHex(int binary) {
        int decimalTemp = binaryToDecimal(binary);
        return decimalToHex(decimalTemp);
    }

    public String hexToBinary(String hex) {
        int decimalTemp = hexToDecimal(hex);
        return decimalToBinary(decimalTemp);
    }

}
