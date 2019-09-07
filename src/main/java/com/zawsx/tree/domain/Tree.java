package com.zawsx.tree.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.zawsx.tree.exception.NodeNotFoundException;

/**
 * Created by David Useche on 28/08/2019.
 *
 * The Tree contains the initial node and carries the logic of the minimum ancestor
 */
public class Tree {

    @JsonProperty
    public long id;

    @JsonProperty
    private Node root;

    public Tree(Node initialNode) {
        root = initialNode;
    }

    /**
     * Given two nodes determines the Lowest Common Ancestor of them, using as parent the root node of the tree
     * @param p first node
     * @param q second node
     * @return the lowest common ancestor
     */
    public Node lowestCommonAncestor(Node p, Node q) {
        Flag flag = new Flag();
        Node LCA = Node.lowestCommonAncestor(root, p, q, flag);

        if(!flag.foundBoth()) throw new NodeNotFoundException("One or more nodes were not found");

        return LCA;
    }
}
