package ru.eternalgreed.algsds2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {

    // base^exponent = n^m in task
    public static int pow(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        } else {
            return base * pow(base, exponent - 1);
        }
    }

    public static int sumDigitsOfNumber(int number) {
        return number < 10 ? number : (number % 10) + sumDigitsOfNumber(number / 10);
    }

    public static int countListLength(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        } else {
            list.remove(0);
            return 1 + countListLength(list);
        }
    }

    public static boolean isPalindrome(String checkingString) {
        if (checkingString.length() < 2) {
            return true;
        } else if (checkingString.charAt(0) == checkingString.charAt(checkingString.length() - 1)) {
            return isPalindrome(checkingString.substring(1, checkingString.length() - 1));
        } else {
            return false;
        }
    }

    public static void printOnlyEvenValuesInList(List<Integer> list) {
        if (!list.isEmpty()) {
            Integer firstElement = list.get(0);
            if (firstElement % 2 == 0) {
                System.out.print(firstElement + " ");
            }
            list.remove(0);
            printOnlyEvenValuesInList(list);
        }
    }

    public static void printOnlyEvenIndexValuesInList(List<Integer> list) {
        if (!list.isEmpty()) {
            System.out.print(list.get(0) + " ");
            iterate(1, list);
        }
    }

    public static int findSecondMaximum(List<Integer> list) {
        if (list.size() < 2) {
            throw new IllegalArgumentException("List size must be > 2");
        }
        int firstMax = list.get(0);
        int secondMax = list.get(1);
        if (firstMax < secondMax) {
            firstMax = list.get(1);
            secondMax = list.get(0);
        }
        return findSecondMaximum(list, 2, firstMax, secondMax);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> resultParenthesisList = new ArrayList<>();
        generateParenthesis(n, "", 0, 0, resultParenthesisList);
        return resultParenthesisList;
    }


    public static List<File> getAllFilesInsideDir(String path) {
        List<File> files = new ArrayList<>();
        getAllFilesInsideDir(path, files);
        return files;
    }

    public static void getAllFilesInsideDir(String path, List<File> resultList) {
        File pathFile = new File(path);
        if (pathFile.isDirectory()) {
            File[] files = pathFile.listFiles();
            for (File file : files) {
                getAllFilesInsideDir(file.getPath(), resultList);
            }
        } else {
            resultList.add(pathFile);
        }
    }

    private static void generateParenthesis(int n, String combinationAccumulator, int opened, int closed, List<String> result) {
        if (opened == n && closed == n) {
            result.add(combinationAccumulator);
            return;
        }
        if (opened < n) {
            generateParenthesis(n, combinationAccumulator.concat("("), opened + 1, closed, result);
        }
        if (closed < n && opened > closed) {
            generateParenthesis(n, combinationAccumulator.concat(")"), opened, closed + 1, result);
        }
    }

    private static int findSecondMaximum(List<Integer> list, int index, int firstMax, int secondMax) {
        if (index >= list.size()) {
            return secondMax;
        }
        Integer tempMax = list.get(index);
        if (tempMax >= firstMax) {
            return findSecondMaximum(list, index + 1, tempMax, firstMax);
        } else if (tempMax >= secondMax) {
            return findSecondMaximum(list, index + 1, firstMax, tempMax);
        }
        return findSecondMaximum(list, index + 1, firstMax, secondMax);

    }

    private static void iterate(int index, List<Integer> list) {
        if (index >= list.size()) {
            return;
        }
        if (index % 2 == 0) {
            System.out.print(list.get(index) + " ");
        }
        iterate(index + 1, list);
    }

}
