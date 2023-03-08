package org.dolezel.monetatest.numberManipulation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;


class NumberProcessorTest {


    @Test
    void processNumber() {
        BigInteger expectedResult = new BigInteger("11331545");
        BigInteger result = new NumberProcessor().processNumber(new BigInteger("43256791"));
        assertTrue(expectedResult.equals(result),
                String.format("Unexpected result. Expected: %s, returned: %s", expectedResult.toString(), result.toString()));
    }
}