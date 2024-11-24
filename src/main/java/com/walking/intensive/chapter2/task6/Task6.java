package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе

        // Пример использования методов
        int m = 12;
        int n = 15;

        int lcm = getLcm(m, n);
        int gcd = getGcd(m, n);
        int gcdEuclidean = getGcdByEuclideanAlgorithm(m, n);

        System.out.println("НОК для " + m + " и " + n + " равен " + lcm);
        System.out.println("НОД для " + m + " и " + n + " равен " + gcd);
        System.out.println("НОД (алгоритм Евклида) для " + m + " и " + n + " равен " + gcdEuclidean);
    }

    static boolean isValidInput(int m, int n) {
        return m <= 0 || n <= 0;
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {

        // Проверка корректности входных данных
        if (isValidInput(m, n)) {
            return -1; // Некорректные данные
        }

        // Вычисление НОД
        int gcd = getGcd(m, n);

        // Вычисление НОК
        return (m / gcd) * n; // Используем (m / gcd) чтобы избежать переполнения
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {

        // Проверка корректности входных данных
        if (isValidInput(m, n)) {
            return -1; // Некорректные данные
        }

        // Метод простого деления для нахождения НОД
        int gcd = 1; // Начальное значение НОД
        for (int i = 1; i <= Math.min(m, n); i++) {
            if (m % i == 0 && n % i == 0) {
                gcd = i; // Обновляем НОД, если i делит оба числа
            }
        }
        return gcd;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     * Расчет должен производиться с помощью рекурсивной версии алгоритма Евклида.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcdByEuclideanAlgorithm(int m, int n) {

        // Проверка корректности входных данных
        if (isValidInput(m, n)) {
            return -1; // Некорректные данные
        }

        // Алгоритм Евклида
        while (n != 0) {
            int valuePreserving = n;
            n = m % n;
            m = valuePreserving;
        }
        return m;
    }
}
