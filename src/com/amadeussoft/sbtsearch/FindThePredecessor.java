package com.amadeussoft.sbtsearch;

import com.amadeussoft.sbtsearch.managers.AlgorithmTestRunner;
import com.amadeussoft.sbtsearch.managers.InputHelper;
import com.amadeussoft.sbtsearch.managers.PredecessorFinder;
import com.amadeussoft.sbtsearch.model.BST;
import com.amadeussoft.sbtsearch.model.Node;

/**
 * Created by Artem on 20.04.2015.
 */
public class FindThePredecessor {

    private enum RunMode {
        AUTO_TEST_MODE, MANUAL_TEST_MODE, CONSOLE_MODE
    }

    /**
     * Here you can change input data for manual testing. Data must be correct.
     */
    private static final int[] MANUALLY_ENTERED_ARRAY = new int[]{11, 3, 54, 6, 42, 60, -5, 80, 95, 2, 45, 24, 23, 34, 150, 25};
    private static final int MANUALLY_ENTERED_PASSED_VALUE = 25;
    private static final int MANUALLY_ENTERED_CORRECT_RESULT = 3;

    public static void main(String[] args) {
        //Please choose the run mode for application
        RunMode selectedMode = RunMode.MANUAL_TEST_MODE;

        switch (selectedMode) {
            case CONSOLE_MODE:
                calcPredecessorFromConsoleInput();
                break;
            case AUTO_TEST_MODE:
                new AlgorithmTestRunner().runAutoTests();
                break;
            case MANUAL_TEST_MODE:
                new AlgorithmTestRunner().makeCorrectTest(MANUALLY_ENTERED_ARRAY, MANUALLY_ENTERED_PASSED_VALUE, MANUALLY_ENTERED_CORRECT_RESULT);
                break;
        }
    }

    private static void calcPredecessorFromConsoleInput() {
        InputHelper inputHelper = new InputHelper();
        System.out.print("Please, enter the array of integer values with ',' separator\n");
        int[] values = null;
        while (values == null) {
            values = inputHelper.readIntValuesArray();
        }

        System.out.print("Please, enter the value for which we need to find predecessor\n");

        Integer passedValue = null;
        while (passedValue == null) {
            passedValue = inputHelper.readIntValue();
        }

        BST bst = new BST(values);
        PredecessorFinder predecessorFinder = new PredecessorFinder(bst);
        Node predecessorNode = predecessorFinder.findPredecessorNodeForValue(passedValue);
        if (predecessorNode == null) {
            System.out.print("Tree doesn't contain predecessor for this value");
        } else {
            System.out.print("Predecessor = " + predecessorNode.getValue());
        }
    }

}
