package org.dolezel.monetatest.numberManipulation;

import lombok.experimental.UtilityClass;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@UtilityClass
public class DigitUtils {


    record Substitute(char searched, String substitue) {
    }


    public static Consumer<StringBuilder> shiftRightLowerThanSpecifiedAction(int threshold) {
        return inputDigits -> lowerThanSpecified(inputDigits, threshold);
    }


    /**
     * nahradi cislice nasobkem dvou
     *
     * @param digits
     * @return
     */
    public static Consumer<StringBuilder> doubleSubstiuteForDigitAction(char... digits) {

        //vytvori strukturu s characterem a jeho nahradou
        List<Substitute> substitutes = new ArrayList<>();
        for (char digit : digits) {
            int digitValue = digit - '0';
            substitutes.add(new Substitute(digit, String.valueOf(digitValue * 2)));
        }

        return inputDigits -> substitute(inputDigits, substitutes);
    }



    public static Consumer<StringBuilder> removeDigitAction(int digit) {
        return inputDigits -> removeSpecified(inputDigits, String.valueOf(digit));
    }


    public static BigInteger evenCountDivision(StringBuilder processableNumber) {
        long evenCount = processableNumber.toString().chars()
                .filter(ch -> ch == '0' || ch == '2' || ch == '4' || ch == '6' || ch == '8')
                .count();

        BigInteger newNumber = new BigInteger(processableNumber.toString());
        BigInteger result = newNumber.divide(BigInteger.valueOf(evenCount));
        return result;
    }


    private static void lowerThanSpecified(StringBuilder inputDigits, int threshold) {
        char currentChar;
        int thresholdAscii = threshold + '0';
        for (int i = inputDigits.length() - 2; i >= 0; i--) {
            if ((currentChar = inputDigits.charAt(i)) <= thresholdAscii) {
                inputDigits.deleteCharAt(i);
                inputDigits.insert(i + 1, currentChar);
            }
        }
    }


    /**
     * Pro dane vstupni cislice nalezne a nahradi specifikovane cislice
     *
     * @param inputDigits vstupni cislice
     * @param substitutes Co cim nahradit
     */
    public static void substitute(StringBuilder inputDigits, List<Substitute> substitutes) {
        for (int i = inputDigits.length() - 1; i >= 0; i--) {
            for (Substitute substitute : substitutes) {
                if (inputDigits.charAt(i) == substitute.searched) {
                    inputDigits.deleteCharAt(i);
                    inputDigits.insert(i, substitute.substitue);
                    break;
                }
            }
        }
    }


    private static void removeSpecified(StringBuilder inputDigits, String digit) {
        for (int tempIndex = inputDigits.lastIndexOf(digit); tempIndex > 0; tempIndex = inputDigits.lastIndexOf("7", tempIndex)) {
            inputDigits.deleteCharAt(tempIndex);
        }
    }
}
