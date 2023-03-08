package org.dolezel.monetatest.numberManipulation;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class NumberProcessor {


    public BigInteger processNumber(BigInteger inputNumber) {
        StringBuilder processableNumber = new StringBuilder(inputNumber.toString());
        return processDigits(processableNumber);
    }


    private BigInteger processDigits(StringBuilder inputDigits) {
        DigitUtils.shiftRightLowerThanSpecifiedAction(3).accept(inputDigits);
        DigitUtils.doubleSubstiuteForDigitAction('8', '9').accept(inputDigits);
        DigitUtils.removeDigitAction(7).accept(inputDigits);
        return DigitUtils.evenCountDivision(inputDigits);
    }
}
