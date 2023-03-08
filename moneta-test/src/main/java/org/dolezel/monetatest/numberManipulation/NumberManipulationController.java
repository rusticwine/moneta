package org.dolezel.monetatest.numberManipulation;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping(path="someNumber")
@RestControllerAdvice
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Validated
public class NumberManipulationController {


    NumberProcessor numberProcessor;


    @GetMapping
    public BigInteger processNumber(@RequestParam @Valid @PositiveOrZero BigInteger inputNumber) {
        return numberProcessor.processNumber(inputNumber);
    }


    @ExceptionHandler
    public ProblemDetail handleConstraintViolationException(ConstraintViolationException ex) {
        var pd = ProblemDetail.forStatus(HttpStatusCode.valueOf(406));
        pd.setDetail(ex.getMessage());
        pd.setTitle("Constraint validation");
        return pd;
    }
}
