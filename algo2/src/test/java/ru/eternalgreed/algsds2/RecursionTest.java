package ru.eternalgreed.algsds2;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecursionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final PrintStream originalOut = System.out;


    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void powTest() {
        assertEquals(8, Recursion.pow(2, 3));
        assertEquals(9, Recursion.pow(3, 2));
        assertEquals(27, Recursion.pow(3, 3));
        assertEquals(65536, Recursion.pow(2, 16));
        assertEquals(1, Recursion.pow(2, 0));
    }

    @Test
    void sumDigitsOfNumberTest() {
        assertEquals(6, Recursion.sumDigitsOfNumber(123));
        assertEquals(6, Recursion.sumDigitsOfNumber(111111));
        assertEquals(14, Recursion.sumDigitsOfNumber(2345));
        assertEquals(1, Recursion.sumDigitsOfNumber(1));
        assertEquals(0, Recursion.sumDigitsOfNumber(0));
    }

    @Test
    void countListLengthTest() {
        assertEquals(0, Recursion.countListLength(generateList(0)));
        assertEquals(1, Recursion.countListLength(generateList(1)));
        assertEquals(3, Recursion.countListLength(generateList(3)));
        assertEquals(100, Recursion.countListLength(generateList(100)));
        assertEquals(1000, Recursion.countListLength(generateList(1000)));
    }

    @Test
    void isPalindromeTest() {
        assertTrue(Recursion.isPalindrome("ababa"));
        assertTrue(Recursion.isPalindrome("avavava"));
        assertTrue(Recursion.isPalindrome("abba"));

        assertTrue(Recursion.isPalindrome("aa"));
        assertTrue(Recursion.isPalindrome("a"));
        assertFalse(Recursion.isPalindrome("avav"));
    }

    @Test
    void printOnlyEvenValuesInListTest() {
        Recursion.printOnlyEvenValuesInList(generateList(5));
        assertEquals("0 2 4 ", outContent.toString());
    }

    @Test
    void printOnlyEvenIndexValuesInListTest() {
        Recursion.printOnlyEvenIndexValuesInList(generateList(6));
        assertEquals("0 2 4 ", outContent.toString());
    }

    @Test
    void findSecondMaximumTest() {
        List<Integer> testList1 = generateList(5);
        assertEquals(3, Recursion.findSecondMaximum(testList1));
        List<Integer> testList2 = new ArrayList<>(Arrays.asList(2,2,1));
        assertEquals(2, Recursion.findSecondMaximum(testList2));
        List<Integer> testList3 = new ArrayList<>(Arrays.asList(5,2,3,4));
        assertEquals(4, Recursion.findSecondMaximum(testList3));
        List<Integer> testList4 = new ArrayList<>(Arrays.asList(5,2,3,6));
        assertEquals(5, Recursion.findSecondMaximum(testList4));
        List<Integer> testList5 = new ArrayList<>(Arrays.asList(3,3));
        assertEquals(3, Recursion.findSecondMaximum(testList5));
        List<Integer> testList6 = new ArrayList<>(Arrays.asList(4,3));
        assertEquals(3, Recursion.findSecondMaximum(testList6));
    }

    @Test
    void generateParenthesisTest() {
        List<String> strings = Recursion.generateParenthesis(2);
        assertEquals(2, strings.size());
        List<String> strings2 = Recursion.generateParenthesis(3);
        assertEquals(5, strings2.size());
    }

    @Test
    void getAllFilesInsideDirTest() {
        List<File> allFilesInsideDir = Recursion.getAllFilesInsideDir("src/test/resources/rootDir");
        assertEquals(5, allFilesInsideDir.size());
       // List<File> allFilesInsideDir1 = Recursion.getAllFilesInsideDir("C:\\Users");
    }

    private List<Integer> generateList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }
}