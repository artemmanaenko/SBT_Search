package com.amadeussoft.sbtsearch.managers;

import com.amadeussoft.sbtsearch.model.BST;
import com.amadeussoft.sbtsearch.model.Node;

/**
 * Created by Artem on 20.04.2015.
 */
public class PredecessorFinder {

    private BST tree;

    public PredecessorFinder(BST tree) {
        this.tree = tree;
    }

    public Node findPredecessorNodeForValue(int enteredValue) throws IllegalArgumentException {
        Node predecessor = null;
        Node currentNode = tree.getRoot();
        while (currentNode != null) {
            if (currentNode.getValue() == enteredValue) {
                Node leftNode = currentNode.getLeft();
                //probably predecessor is located in left node cause there are children less then enteredValue
                if (leftNode != null) {
                    Node maxChildFromNode = getMaximumChildFromNode(leftNode);
                    if (maxChildFromNode == null)
                        predecessor = leftNode;
                }
                //otherwise stay predecessor unchanged
                break;
            }
            //we save current value as a predecessor cause it also satisfies a condition
            //and continue to go right until value of current node is less than enteredValue
            else if (enteredValue > currentNode.getValue()) {
                predecessor = currentNode;
                currentNode = currentNode.getRight();
            }
            //if current value is more than enteredValue, we need to find predecessor in left node
            else {
                currentNode = currentNode.getLeft();
            }
        }
        return predecessor;
    }

    private Node getMaximumChildFromNode(Node node) {
        Node maxValueChild = node.getRight();
        if (maxValueChild != null) {
            while (maxValueChild.getRight() != null) {
                maxValueChild = maxValueChild.getRight();
            }
        }
        return maxValueChild;
    }

}
