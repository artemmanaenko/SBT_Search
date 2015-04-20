package com.amadeussoft.sbtsearch.managers;

import com.amadeussoft.sbtsearch.model.BST;
import com.amadeussoft.sbtsearch.model.Node;

import java.util.Arrays;

/**
 * Created by Artem on 20.04.2015.
 */
public class AlgorithmTestRunner {

    public void runAutoTests() {
        drawDashLine();
        testManualEnteredValuesArray();

        drawDashLine();
        testManualEnteredArrayWithValueFromArray();

        drawDashLine();
        testArrayWithSingleItem();

        drawDashLine();
        testArrayWithSingleItemAndSameValue();

        drawDashLine();
        testWrongFoundItem();
    }

    private void testManualEnteredValuesArray() {
        System.out.print("testManualEnteredValuesArray started...\n");
        int[] values = new int[]{11, 3, 54, 6, 42, 95, 2, 45, 24, 23, 34};
        int passedValue = 255;
        int correctPredecessor = 95;
        makeCorrectTest(values, passedValue, correctPredecessor);
    }

    private void testManualEnteredArrayWithValueFromArray() {
        System.out.print("testManualEnteredArrayWithValueFromArray started...\n");
        int[] values = new int[]{11, 3, 54, 6, 42, 95, 2, 45, 24, 23, 34};
        int passedValue = 6;
        int correctPredecessor = 3;
        makeCorrectTest(values, passedValue, correctPredecessor);
    }

    private void testArrayWithSingleItemAndSameValue() {
        System.out.print("testArrayWithSingleItemAndSameValue started...\n");
        int[] values = new int[]{5};
        int passedValue = 5;
        makeNotFoundTest(values, passedValue);
    }

    private void testWrongFoundItem() {
        System.out.print("testWrongFoundItem started...\n");
        int[] values = new int[]{11, 3, 54, 6, 42, 95, 2, 45, 24, 23, 34};
        int passedValue = 4;
        int notCorrectPredecessor = 2;
        makeNotCorrectTest(values, passedValue, notCorrectPredecessor);
    }

    private void testArrayWithSingleItem() {
        System.out.print("testArrayWithSingleItem started...\n");
        int[] values = new int[]{3};
        int passedValue = 5;
        int correctPredecessor = 3;
        makeCorrectTest(values, passedValue, correctPredecessor);
    }

    public void makeCorrectTest(int[] values, int passedValue, int correctPredecessor) {
        System.out.print("values=" + Arrays.toString(values) + "\npassedValue=" + passedValue + " expectedPredecessor=" + correctPredecessor);

        BST tree = new BST(values);
        PredecessorFinder predecessorFinder = new PredecessorFinder(tree);
        Node predecessorNode = predecessorFinder.findPredecessorNodeForValue(passedValue);
        if(predecessorNode != null){
            int foundPredecessor = predecessorNode.getValue();
            boolean isCorrect = (correctPredecessor == foundPredecessor);
            System.out.print("\nfoundPredecessor=" + foundPredecessor + "\nTest passed:" + isCorrect);
            if(!isCorrect)
                System.out.print("\n<Please, check input data, maybe it is incorrect>");
        } else {
            System.out.print("\nYou entered not corrected input data");
        }
    }

    public void makeNotFoundTest(int[] values, int passedValue) {
        System.out.print("values=" + Arrays.toString(values) + " passedValue=" + passedValue);

        BST tree = new BST(values);
        PredecessorFinder predecessorFinder = new PredecessorFinder(tree);
        Node predecessorNode = predecessorFinder.findPredecessorNodeForValue(passedValue);
        boolean isCorrect = (predecessorNode == null);
        System.out.print("\nTest passed:" + isCorrect);
    }

    public void makeNotCorrectTest(int[] values, int passedValue, int notcorrectPredecessor) {
        System.out.print("values=" + Arrays.toString(values) + " passedValue=" + passedValue + " expectedPredecessor=" + notcorrectPredecessor);

        BST tree = new BST(values);
        PredecessorFinder predecessorFinder = new PredecessorFinder(tree);

        Node predecessorNode = predecessorFinder.findPredecessorNodeForValue(passedValue);
        if (predecessorNode != null) {
            int foundPredecessor = predecessorNode.getValue();
            boolean isCorrect = notcorrectPredecessor != predecessorNode.getValue();
            System.out.print("\nfoundPredecessor=" + foundPredecessor + "\nTest passed:" + isCorrect);
        } else {
            System.out.print("\nTree doesn't contain passed item");
        }
    }

    private void drawDashLine() {
        System.out.print("\n------------------------\n");
    }

}
