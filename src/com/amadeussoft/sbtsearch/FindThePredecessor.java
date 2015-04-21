package com.amadeussoft.sbtsearch;

import com.amadeussoft.sbtsearch.model.BinarySearchTree;
import com.amadeussoft.sbtsearch.model.Node;

import java.util.Arrays;

/**
 * Created by Artem on 20.04.2015.
 */
public class FindThePredecessor {

    private enum RunMode {
        AUTO_TEST_MODE, MANUAL_TEST_MODE
    }

    public static void main(String[] args) {
        //Please choose the run mode for application
        RunMode selectedMode = RunMode.MANUAL_TEST_MODE;

        switch (selectedMode) {
            case MANUAL_TEST_MODE:
                calcPredecessorWithTestData();
                break;
            case AUTO_TEST_MODE:
                new TestRunner().runAutoTests();
                break;
        }
    }

    private static void calcPredecessorWithTestData() {
        //Please, enter here your test data
        final int[] treeValues = new int[]{11, 3, 54, 6, 42, 95, 2, 45, 24, 23, 34};
        int enteredValue = 45;

        System.out.print("values=" + Arrays.toString(treeValues));
        System.out.print("\nenteredValue=" + enteredValue);

        BinarySearchTree bst = new BinarySearchTree(treeValues);

        PredecessorFinder predecessorFinder = new PredecessorFinder(bst);
        Node predecessorNode = predecessorFinder.findPredecessorNodeForValue(enteredValue);
        System.out.print("\n---------------------\n");
        if (predecessorNode == null) {
            System.out.print("Tree doesn't contain predecessor for this value");
        } else {
            System.out.print("Predecessor = " + predecessorNode.getValue());
        }
    }

}
