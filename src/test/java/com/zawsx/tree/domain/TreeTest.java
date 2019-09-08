package com.zawsx.tree.domain;

import com.zawsx.tree.exception.NodeNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by David Useche on 3/09/2019.
 */
public class TreeTest {

    @Test
    public void givenTreeWhenAskForLCAOfInExistentNode_ShouldFailWithNotFound() {
        Node root = new Node(1);

        Tree tree = new Tree(root);

        assertThrows(NodeNotFoundException.class, () -> tree.lowestCommonAncestor(new Node(2), new Node(3)));
    }
}
