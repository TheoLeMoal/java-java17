package java17.ex07;

import java.util.function.IntBinaryOperator;

import org.junit.Test;

/**
 * Exercice 07 - java.util.function.IntBinaryOperator
 */
public class Function_07_Test {

    // tag::format[]
    // Compléter la méthode pour qu'elle renvoie une chaîne de caractères de la forme "(<nb1><symbol><nb2>)=<resultat>"
    // ex. "(10+11)=21", "(5-2)=3"
    String format(int nb1, int nb2, String symbol, IntBinaryOperator operator) {
        int result = operator.applyAsInt(nb1, nb2);
        return "(" + nb1 + symbol + nb2 + ")=" + result;
    }
    // end::format[]

    // Définir sum pour que le test test_format_sum() soit passant
    IntBinaryOperator sum = (a, b) -> a + b;

    @Test
    public void test_format_sum() throws Exception {
        String result = format(12, 13, "+", sum);
        assert result.equals("(12+13)=25");
    }

    // Définir subtract afin que le test test_format_subtract() soit passant
    IntBinaryOperator subtract = (a, b) -> a - b;

    @Test
    public void test_format_subtract() throws Exception {
        String result = format(2, 3, "-", subtract);
        assert result.equals("(2-3)=-1");
    }
}