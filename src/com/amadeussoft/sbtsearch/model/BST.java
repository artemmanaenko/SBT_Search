package com.amadeussoft.sbtsearch.model;

/**
 * Created by Artem on 20.04.2015.
 */
public class BST {

    private Node root;

    public BST(int[] valuesArray) {
        if (valuesArray != null && valuesArray.length > 0) {
            root = new Node(valuesArray[0]);
            if (valuesArray.length > 1) {
                for (int index = 1; index < valuesArray.length; index++) {
                    insert(valuesArray[index]);
                }
            }
        } else {
            throw new IllegalArgumentException("Values array cannot be empty or null");
        }
    }

    private int compare(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }

    private void insert(Integer data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int valueToInsert) {
        if (node == null)
            return new Node(valueToInsert);

        if (compare(valueToInsert, node.getValue()) == 0)
            return node;

        if (compare(valueToInsert, node.getValue()) < 0)
            node.setLeft(insert(node.getLeft(), valueToInsert));
        else
            node.setRight(insert(node.getRight(), valueToInsert));

        return node;
    }

    public Node getRoot() {
        return root;
    }
}