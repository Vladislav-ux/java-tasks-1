package ru.mail.polis.homework.simple;

import java.util.function.ToDoubleFunction;

public class HomeworkTask {

    /**
     * Нужно численно посчитать интеграл от a до b с шагом delta от функции function
     * Для того, что бы получить значение по Y для точки X, надо просто написать function.applyAsDouble(t)
     * Считаем, что функция определена на всем пространстве от a до b
     */
    public static double calcIntegral(double a, double b, ToDoubleFunction<Double> function, double delta) {
        double sum = 0;
        for (double doubleCounter = a; doubleCounter < b; doubleCounter += delta) {
            sum += delta * function.applyAsDouble(doubleCounter);
        }
        return sum;
    }

    /**
     * Вывести номер максимальной цифры. Счет начинается слева направо,
     * выводим номер первой максимальной цифры (если их несколько)
     */
    public static byte maxNumber(long a) {
        byte maxFigure = 0;
        int numberOfDigits = 0;
        int index = 0;
        long number = a;

        if (number == 0) {
            numberOfDigits = 1;
        } else {
            while (number > 0) {
                if (maxFigure <= number % 10) {
                    maxFigure = (byte) (number % 10);
                    index = numberOfDigits;
                }
                numberOfDigits = numberOfDigits + 1;
                number /= 10;
            }
        }
        return (byte) (numberOfDigits - index);
    }

    /**
     * Даны две точки в пространстве (x1, y1) и (x2, y2). Вам нужно найти Y координату третьей точки (x3, y3),
     * которая находится на той же прямой что и первые две.
     */
    public static double lineFunction(int x1, int y1, int x2, int y2, int x3) {
        double a = (double) (y1 - y2) / (x1 - x2);
        return (a * x3 + y1 - a * x1);
    }

    /**
     * Даны 4 точки в пространстве A(x1, y1), B(x2, y2), C(x3, y3), D(x4, y4). Найдите площадь выпуклого
     * четырехуголька ABCD.
     * Это дополнительное задание, необязательное для выполнения
     */
    public static double square(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        double det = x1 * y2 + x2 * y3 + x3 * y4 + x4 * y1 - x2 * y1 - x3 * y2 - x4 * y3 - x1 * y4;
        return Math.abs(det * 0.5);
    }

}
