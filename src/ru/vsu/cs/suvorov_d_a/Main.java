package ru.vsu.cs.suvorov_d_a;

import java.util.Scanner;
import java.util.Locale;

class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        int n = readIntNumber();
        double x = readDoubleNumbers("x");
        double e = readDoubleNumbers("e");

        double sumOfSequence = calculateSumOfSequence(x, n);
        double sumOfSequenceMoreThanEpsilon = calculateSumOfSequenceMoreThanEpsilon(x, e, n);
        double sumOfSequenceMoreThanPartOfEpsilon = calculateSumOfSequenceMoreThanEpsilon(x, e/10, n);
        double valueOfFunction = calculateValueOfFunction(e, x);

        printAnswer(sumOfSequence, sumOfSequenceMoreThanEpsilon, sumOfSequenceMoreThanPartOfEpsilon, valueOfFunction);
    }

    private static double readDoubleNumbers(String text) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter %s: ", text);

        return scan.nextDouble();
        }

    private static int readIntNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n: ");

        int enterData = scan.nextInt();

        if (enterData <= 0) {
            System.out.println("Error. Value of n can't be less or equal 0");
            System.exit(1);
        }
        return enterData;
    }

    private static int getFactorial(int fact) {
        int result = 1;
        for (int i = 1; i <= fact; i++) {
            result = result * i;
        }
        return result;
    }

    private static double calculateSumOfSequence(double x, int n) {
        double intermediateResult = 1;
        double sum = 0;

        for(int i = 0; i < n; i++) {
            sum += intermediateResult;
            intermediateResult *= x/(i+1);
        }
        return sum;
    }

    private static double getMemberOfSequence(double x, int n) {
        return (Math.pow(x, n - 1)) / getFactorial(n - 1);
    }

    private static double calculateSumOfSequenceMoreThanEpsilon(double x, double e, int n) {
        double sum = 0;

        for (int i = 1; i <= n; i++) {
            double MemberOfSequence = getMemberOfSequence(x, i);
            if (MemberOfSequence > e) {
                sum += getMemberOfSequence(x, i);
            }
        }
        if (sum == 0) {
            System.out.println("No found members of sequence that are more than epsilon in absolute value");
        }
        return sum;
    }

    private static double calculateValueOfFunction(double e, double x) {
        return Math.pow(e, x);
    }

    private static void printAnswer(double a, double b, double c, double d) {
        System.out.println("1)The sum of the terms of the sequence = " + a);
        System.out.println("2)The sum of the terms of the sequence that are more than epsilon = " + b);
        System.out.println("3)The sum of the terms of the sequence that are more than epsilon divided by 10 = " + c);
        System.out.println("4)The value of the function = " + d);
    }
}