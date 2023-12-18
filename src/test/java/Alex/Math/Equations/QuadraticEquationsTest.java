package Alex.Math.Equations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// AAA: Arrange Act Assert
public class QuadraticEquationsTest {

    private QuadraticEquations quadraticEquations = new QuadraticEquations();

    /* Метод тестирует программу по решению уравнений в случаях, когда коэффициенты a,b - ненулевые,
       и решение представлено в виде x1 = n, x2 = m. */
    @Test
    public void FullEquationTest() {

        // given - предустановки, данные, переменные
        String equation2 = "2x^2 + 5x - 2 = 1".replaceAll("\\s+", "");
        String correctAnswer2 = "x1 = -3.0, x2 = 0.5";
        String equation1 = "2x^2 - 4x - 2 = -4".replaceAll("\\s+", "");
        String correctAnswer1 = "x = 1.0";
        String equation0 = "2x^2 - 4x + 9 = -1".replaceAll("\\s+", "");
        String correctAnswer0 = "x1 = 1.0 - 2.0i, x2 = 1.0 + 2.0i";

        // when - вызов тестируемого кода
        String[] answer2 = quadraticEquations.Solution(equation2).split("<br>");
        String[] answer1 = quadraticEquations.Solution(equation1).split("<br>");
        String[] answer0 = quadraticEquations.Solution(equation0).split("<br>");

        // then - проверка результатов кода
        Assertions.assertNotNull(answer2);
        Assertions.assertEquals(correctAnswer2, answer2[answer2.length - 1]);
        Assertions.assertNotNull(answer1);
        Assertions.assertEquals(correctAnswer1, answer1[answer1.length - 1]);
        Assertions.assertNotNull(answer0);
        Assertions.assertEquals(correctAnswer0, answer0[answer0.length - 1]);
    }

    /* Метод тестирует программу по решению уравнений в случаях, когда коэффициент b = 0,
       и решение представлено в виде x = ±n. */
    @Test
    public void AEquationsTest() {

        // given - предустановки, данные, переменные
        String equation2 = "2x^2 - 1 = 1".replaceAll("\\s+", "");
        String correctAnswer2 = "x = ±1.0";
        String equation1 = "2x^2 + 1 = 1".replaceAll("\\s+", "");
        String correctAnswer1 = "x = 0.0";
        String equation0 = "2x^2 + 1 = -1".replaceAll("\\s+", "");
        String correctAnswer0 = "x = ±1.0i";

        // when - вызов тестируемого кода
        String[] answer2 = quadraticEquations.Solution(equation2).split("<br>");
        String[] answer1 = quadraticEquations.Solution(equation1).split("<br>");
        String[] answer0 = quadraticEquations.Solution(equation0).split("<br>");

        // then - проверка результатов кода
        Assertions.assertNotNull(answer2);
        Assertions.assertEquals(correctAnswer2, answer2[answer2.length - 1]);
        Assertions.assertNotNull(answer1);
        Assertions.assertEquals(correctAnswer1, answer1[answer1.length - 1]);
        Assertions.assertNotNull(answer0);
        Assertions.assertEquals(correctAnswer0, answer0[answer0.length - 1]);
    }

    /* Метод тестирует программу по решению уравнений в случаях, когда коэффициент a = 0,
       и решение представлено в виде x = n. */
    @Test
    public void BEquationsTest() {

        // given - предустановки, данные, переменные
        String equation2 = "2x + 1 = -1".replaceAll("\\s+", "");
        String correctAnswer2 = "x = -1.0";
        String equation1 = "x + 2 = 3".replaceAll("\\s+", "");
        String correctAnswer1 = "x = 1.0";

        // when - вызов тестируемого кода
        String[] answer2 = quadraticEquations.Solution(equation2).split("<br>");
        String[] answer1 = quadraticEquations.Solution(equation1).split("<br>");

        // then - проверка результатов кода
        Assertions.assertNotNull(answer2);
        Assertions.assertEquals(correctAnswer2, answer2[answer2.length - 1]);
        Assertions.assertNotNull(answer1);
        Assertions.assertEquals(correctAnswer1, answer1[answer1.length - 1]);
    }

    /* Метод тестирует программу по решению уравнений в случаях, когда коэффициенты a = b = 0,
       и решение сводится к утверждению истинности выражения. */
    @Test
    public void ExpressionTest() {

        // given - предустановки, данные, переменные
        String equation1 = "5 = 5".replaceAll("\\s+", "");
        String correctAnswer1 = "Верное утверждение. #";
        String equation0 = "2 = -1".replaceAll("\\s+", "");
        String correctAnswer0 = "Неверное утверждение. #";

        // when - вызов тестируемого кода
        String[] answer1 = quadraticEquations.Solution(equation1).split("<br>");
        String[] answer0 = quadraticEquations.Solution(equation0).split("<br>");

        // then - проверка результатов кода
        Assertions.assertNotNull(answer1);
        Assertions.assertEquals(correctAnswer1, answer1[answer1.length - 1]);
        Assertions.assertNotNull(answer0);
        Assertions.assertEquals(correctAnswer0, answer0[answer0.length - 1]);
    }

    /* Метод тестирует нестандартные случаи, когда коэффициенты a, b могут указываться неявно,
       а коэффициенты c,d - опускаться и знак "=" не ставиться. */
    @Test
    public void NonStandardTest() {

        // given - предустановки, данные, переменные
        String abEquation = "x^2 + x - 14 = -2".replaceAll("\\s+", "");
        String abCorrectAnswer = "x1 = -4.0, x2 = 3.0";
        String aEquation = "x^2 + 4x - 13 = -1".replaceAll("\\s+", "");
        String aCorrectAnswer = "x1 = -6.0, x2 = 2.0";
        String bEquation = "3x^2 + x + 7 = 11".replaceAll("\\s+", "");
        String bCorrectAnswer = "x1 = -1.33, x2 = 1.0";
        String cdEquation = "-4x^2 + 2x".replaceAll("\\s+", "");
        String cdCorrectAnswer = "x1 = 0.5, x2 = 0.0";
        String cEquation = "-5x^2 + 9x = -2".replaceAll("\\s+", "");
        String cCorrectAnswer = "x1 = 2.0, x2 = -0.2";
        String dEquation = "-3x^2 + 9x + 12 = ".replaceAll("\\s+", "");
        String dCorrectAnswer = "x1 = 4.0, x2 = -1.0";

        // when - вызов тестируемого кода
        String[] abAnswer = quadraticEquations.Solution(abEquation).split("<br>");
        String[] aAnswer = quadraticEquations.Solution(aEquation).split("<br>");
        String[] bAnswer = quadraticEquations.Solution(bEquation).split("<br>");
        String[] cdAnswer = quadraticEquations.Solution(cdEquation).split("<br>");
        String[] cAnswer = quadraticEquations.Solution(cEquation).split("<br>");
        String[] dAnswer = quadraticEquations.Solution(dEquation).split("<br>");

        // then - проверка результатов кода
        Assertions.assertNotNull(abAnswer);
        Assertions.assertEquals(abCorrectAnswer, abAnswer[abAnswer.length - 1]);
        Assertions.assertNotNull(aAnswer);
        Assertions.assertEquals(aCorrectAnswer, aAnswer[aAnswer.length - 1]);
        Assertions.assertNotNull(bAnswer);
        Assertions.assertEquals(bCorrectAnswer, bAnswer[bAnswer.length - 1]);
        Assertions.assertNotNull(cdAnswer);
        Assertions.assertEquals(cdCorrectAnswer, cdAnswer[cdAnswer.length - 1]);
        Assertions.assertNotNull(cAnswer);
        Assertions.assertEquals(cCorrectAnswer, cAnswer[cAnswer.length - 1]);
        Assertions.assertNotNull(dAnswer);
        Assertions.assertEquals(dCorrectAnswer, dAnswer[dAnswer.length - 1]);
    }
}