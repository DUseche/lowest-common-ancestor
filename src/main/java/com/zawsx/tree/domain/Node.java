package com.zawsx.tree.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Created by David Useche on 27/08/2019.
 *
 * Represents a Node of the Tree
 */
public class Node {

    /**
     * Finds the Lowest Common Ancestor for two nodes given an initial node
     *
     * @param parent to initiate the evaluation
     * @param p first node to search
     * @param q second node to search
     * @param flag represents if both nodes have been found
     * @return The Lowest Common Ancestor of Nodes p,q
     */
    public static Node lowestCommonAncestor(final Node parent, final Node p, final Node q,
                                            final Flag flag) {
        if(Objects.isNull(parent)) return null;

        if(Objects.equals(parent, p)) {
            flag.findFirst();
            return parent;
        }
        if(Objects.equals(parent, q)) {
            flag.findSecond();
            return parent;
        }

        Node left = lowestCommonAncestor(parent.nodeOne, p, q, flag);
        Node right = lowestCommonAncestor(parent.nodeTwo, p, q, flag);

        if(flag.foundBoth()) return parent;

        return Objects.nonNull(left) ? left : right;
    }

    /**
     * The value assigned to this node
     */
    @JsonProperty
    private Integer value;

    /**
     * First node
     */
    @JsonProperty
    private Node nodeOne;

    /**
     * Second node
     */
    @JsonProperty
    private Node nodeTwo;


    /**
     * Constructor of the Node
     *
     * @param value of the node
     * @param one node
     * @param two node
     */
    public Node(Integer value, Node one, Node two) {
        this.value = value;
        nodeOne = one;
        nodeTwo = two;
    }

    /**
     * Constructor of the Node
     *
     * @param value of the node
     */
    public Node(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
