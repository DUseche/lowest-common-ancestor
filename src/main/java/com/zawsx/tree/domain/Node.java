package com.zawsx.tree.domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by David Useche on 27/08/2019.
 *
 * Represents a Node of the Tree
 */
public class Node {

    /**
     * The value assigned to this node
     */
    private Integer value;

    /**
     * The children nodes of this node
     */
    private List<Node> nodes;

    /**
     * Constructor of the node
     *
     * @param value to assign
     */
    public Node(Integer value) {
        this.value = value;
        nodes = new ArrayList<>();
    }

    /**
     * Adds a new node to the children nodes
     *
     * @param node to add
     */
    public void add(Node node) {
        nodes.add(node);
    }

    /**
     * Verifies if two nodes are children of this node
     *
     * @param p first node to evaluate
     * @param q second node to evaluate
     * @return the children nodes of the node
     */
    public Set<Node> parentOf(final Node p, final Node q) {
        Set<Node> children = new HashSet<>();
        if(this.equals(p)) children.add(p);
        if(this.equals(q)) children.add(q);

        children.addAll(nodes
                .stream()
                .map(node -> node.parentOf(p, q))
                .flatMap(Set::stream)
                .collect(Collectors.toSet()));

        return children;
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
