package ru.vsu.cs.ostroverkhov;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        double x = readDouble('x');
        x = checkBelongingToTheRange(x);
        int n = readN();
        double e = readDouble('e');

        double sumOfNTerms = calcSumOfNTermsThisSequence(x, n);
        double sumOfTermsGreaterThanE = calcSumOfTermsGreaterThanE(x, e);
        double sumOfTermsGreaterThanEDividedByTen = calcSumOfTermsGreaterThanE(x, e / 10);
        double functionValue = calcValueOfFunction(x);

        printResult(sumOfNTerms, sumOfTermsGreaterThanE, sumOfTermsGreaterThanEDividedByTen, functionValue);
    }

    static void printResult(double sumOfNTerms,
                            double sumOfTermsGreaterThanE,
                            double sumOfTermsGreaterThanEDividedByTen,
                            double functionValue) {
        System.out.println("Results of calculations performed: \n1) The sum of n terms of a given form: "
                + sumOfNTerms + "\n2) The sum of those terms that are greater than e in absolute value: "
                + sumOfTermsGreaterThanE + "\n3) The sum of those terms that are greater than e/10 in absolute value: "
                + sumOfTermsGreaterThanEDividedByTen + "\n4) Function value: " + functionValue);
    }

    static double calcValueOfFunction(double x) {
        return 1 / (1 - x);
    }

    static double calcSumOfTermsGreaterThanE(double x, double e) {
        double sum = 0;
        int n = 0;
        while (Math.abs(getNNumberOfSequence(x, n)) > e) {
            sum += getNNumberOfSequence(x, n);
            n++;
        }
        return sum;
    }

    static double calcSumOfNTermsThisSequence(double x, int n) {
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += getNNumberOfSequence(x, i);
        }
        return sum;
    }

    static double getNNumberOfSequence(double x, int n) {
        return Math.pow(x, n);
    }

    static void printErrorCheckResult() {
        System.out.println("Error! X must belong to the range (-1; 1). Try again!");
    }

    static double checkBelongingToTheRange(double x) {
        while (x <= -1 || x >= 1) {
            printErrorCheckResult();
            x = readDouble('x');
        }
        return x;
    }

    static double readDouble(char name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %s: ", name);
        return scanner.nextDouble();
    }

    static int readN() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        return scanner.nextInt();
    }
}
