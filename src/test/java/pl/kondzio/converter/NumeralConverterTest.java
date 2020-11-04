package pl.kondzio.converter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumeralConverterTest {
    private static NumeralConverter numeralConverter;
    @Before
    public void setUp() throws Exception {
        numeralConverter = new NumeralConverter();
    }

    @Test
    public void testDecimalToBinaryWithCorrectInput() {
        int digit = 3;

        String result = numeralConverter.decimalToBinary(digit);

        assertEquals("11",result);
    }
    @Test
    public void testBinaryToDecimalWithCorrectInput() {
        int binary = 101111;

        int result = numeralConverter.binaryToDecimal(binary);

        assertEquals(47,result);
    }
    @Test
    public void testDecimalToHexWithCorrectInput() {
        int decimal = 12;

        String result = numeralConverter.decimalToHex(decimal);

        assertEquals("C",result);
    }

    @Test
    public void testHexToDecimalWithCorrectInput() {
        String hex = "1A";

        int result = numeralConverter.hexToDecimal(hex);

        assertEquals(26,result);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testHexToDecimalWithIncorrectInput() {
        String hex = "1Z";

        int result = numeralConverter.hexToDecimal(hex);

        assertEquals(26, result);
    }

    @Test
    public void testHexToBinaryWithCorrectInput() {
        String hex = "2F";

        String result = numeralConverter.hexToBinary(hex);

        assertEquals("101111",result);
    }
@Test (expected = IllegalArgumentException.class)
    public void testHexToBinaryWithIncorrectInput() {
        String hex = "2Z";

        String result = numeralConverter.hexToBinary(hex);

        assertEquals("101111",result);
    }


    @Test
    public void testBinaryToHexWithCorrectInput() {
        int binary = 1100;

        String result = numeralConverter.binaryToHex(binary);

        assertEquals("C",result);
    }
}
