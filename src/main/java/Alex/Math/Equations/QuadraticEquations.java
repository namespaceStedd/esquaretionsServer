package Alex.Math.Equations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Math")
public class QuadraticEquations {

    @GetMapping("/QuadraticEquations")
    public String Solution(@RequestParam String equation) {
        String answer = "";

        int a = 0, i = 0;
        String[] ax = equation.split("x\\^2");
        if (ax.length > 1) {
            if (ax[0] != null && ax[0] != "") {
                if (ax[0].equals("-"))
                    a = -1;
                else if (ax[0].equals("+"))
                    a = 1;
                else
                    a = Integer.parseInt(ax[0]);
            }
            else
                a = 1;
            i = 1;
        }

        int b = 0, j = 0, c = 0, d = 0;
        String[] bx = ax[i].split("x");
        if (bx.length > 1) {
            if (bx[0] != null && bx[0] != "") {
                if (bx[0].equals("-"))
                    b = -1;
                else if (bx[0].equals("+"))
                    b = 1;
                else
                    b = Integer.parseInt(bx[0]);
            }
            else
                b = 1;
            j = 1;
        }
        else if (ax[i].equals(bx[0] + "x")) {
            b = Integer.parseInt(bx[0]);
            j = -1;
        }

        if (j != -1) {
            String[] cx = bx[j].split("=");
            if (cx[0] != null && cx[0] != "")
                c = Integer.parseInt(cx[0]);
            if (cx.length > 1)
                if (cx[1] != null && cx[1] != "")
                    d = Integer.parseInt(cx[1]);
        }

        answer = "Ваши коэффициенты: <br>a = " + a + ",   b = " + b + ",   c = " + c + ",   d = " + d + ".";
        if (a != 0 && b != 0)
            answer += fullEquations(a, b, c, d);
        else if (a != 0)
            answer += aEquations(a, c, d);
        else if (b != 0)
            answer += bEquations(b, c, d);
        else
            answer += expression(c, d);

        return answer;
    }

    public String fullEquations(int a, int b, int c, int d) {
        String equation = "<br>Уравнение вида ax^2 + bx + c = d.<br>Перенесём все коэффициенты в левую часть, приравняв её к нулю:<br>";

        double cd = c - d, b2 = Math.pow(b, 2), ac4 = 4 * a * cd, D = b2 - ac4;
        equation += a + "x^2 " + (b >= 0 ? "+ " + b : "- " + Math.abs(b)) + "x " + (cd >= 0 ? "+ " + cd : "- " + Math.abs(cd)) + " = 0." +
                "<br>Затем найдём дискриминант по формуле D = b^2 - 4ac : " +
                "<br>D = " + b2 + (ac4 >= 0 ? " - " + ac4 : " + " + Math.abs(ac4)) + " = " + D;

        if (D > 0) {
            double sqrtD = Math.sqrt(D), numerator1 = -b - sqrtD, numerator2 = -b + sqrtD, denominator = 2 * a,
                    x1 = numerator1 / denominator, x2 = numerator2 / denominator;
            equation += "<br>Дискриминант положительный, поэтому данное уравнение имеет два корня, которые ищутся по формуле: " +
                    "<br>x1,2 = (-b ± sqrt(D))/2a, поэтому: " +
                    "<br>x1 = (" + -b + " - " + (double) Math.round(sqrtD * 100) / 100 + ")/" + denominator + ", x2 = (" + -b + " + " + (double) Math.round(sqrtD * 100) / 100 + ")/" + denominator +
                    "<br>x1 = " + (double) Math.round(numerator1 * 100) / 100 + "/" + denominator + ", x2 = " + (double) Math.round(numerator2 * 100) / 100 + "/" + denominator +
                    "<br>x1 = " + (double) Math.round(x1 * 100) / 100 + ", x2 = " + (double) Math.round(x2 * 100) / 100;
        }
        else if (D == 0) {
            double denominator = 2 * a, x = -b / denominator;
            equation += "<br>Дискриминант равен нулю, поэтому данное уравнение имеет один корень, который ищется по формуле: " +
                    "<br>x = -b/2a, поэтому: " +
                    "<br>x = " + -b + "/" + denominator +
                    "<br>x = " + x;
        }
        else {
            double sqrtD = Math.sqrt(Math.abs(D)), denominator = 2 * a,
                    ba = (double) Math.round(-b / denominator * 100) / 100, Da = (double) Math.round(sqrtD / denominator * 100) / 100;
            equation += "<br>Дискриминант отрицательный, поэтому данное уравнение не имеет корней в вещественных числах, " +
                    "<br>однако корни можно найти в комплексных числах по формуле: " +
                    "<br>x1,2 = (-b ± sqrt(|D|)*i)/2a = -b/4ac ± sqrt(|D|)*i/2a, поэтому: " +
                    "<br>x1 = " + -b + "/" + denominator + " - " + (double) Math.round(sqrtD * 100) / 100 + "i/" + denominator + ", x2 = " + -b + "/" + denominator + " + " + (double) Math.round(sqrtD * 100) / 100 + "i/" + denominator +
                    "<br>x1 = " + ba + " - " + Da + "i, x2 = " + ba + " + " + Da + "i";
        }

        return equation;
    }

    public String aEquations(int a, int c, int d) {
        String equation = "<br>Уравнение вида ax^2 + c = d.<br>Перенесём все коэффициенты без x в правую часть:<br>";
        double cd = d - c, cda = cd / a;
        equation += a + "x^2 = " + cd + "<br>Затем разделим обе части выражения на " + a + " и получим: <br>x^2 = " + cda + "<br>Теперь осталось только взять корень из правой части уравнения. <br>Поскольку правая часть ";
        if (cda > 0)
            equation += "положительная, то возьмём положительный и отрицательный корни из этого числа, и получим, что: <br>x = ±" + (double) Math.round(Math.sqrt(cda) * 100) / 100;
        else if (cda == 0)
            equation += "равна нулю, то соответственно: <br>x = " + cda;
        else
            equation += "отрицательная, то найдём решение в комплексных числах, <br>а именно взяв положительный и отрицательный корни из данного числа и домножив на i: <br>x = ±" + (double) Math.round(Math.sqrt(Math.abs(cda)) * 100) / 100 + "i";

        return equation;
    }

    public String bEquations(int b, int c, int d) {
        String equation = "<br>Уравнение вида bx + c = d.<br>Перенесём все коэффициенты без x в правую часть:<br>";
        double cd = d - c;
        equation += b + "x = " + cd + "<br>Затем разделим обе части выражения на " + b + " и получим: <br>x = " + (double) Math.round(cd / b * 100) / 100;
        return equation;
    }

    public String expression(int c, int d) {
        String equation = "<br>Уравнение вида c = d.<br>Поэтому требуется проверить истинность утверждения.<br>Поскольку c = " + c + ", а d = " + d + ", => <br>" + c + " = " + d;
        if (c == d)
            equation += " - верно, => <br>Верное утверждение. #";
        else
            equation += " - неверно, => <br>Неверное утверждение. #";
        return equation;
    }
}
