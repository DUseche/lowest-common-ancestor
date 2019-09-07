package com.zawsx.tree.domain;

import com.zawsx.tree.domain.Node;
import com.zawsx.tree.domain.Tree;
import com.zawsx.tree.exception.NodeNotFoundException;
import org.junit.Test;

/**
 * Created by David Useche on 3/09/2019.
 */
public class TreeTest {

    @Test(expected = NodeNotFoundException.class)
    public void givenTreeWhenAskForLCAOfInExistentNode_ShouldFailWithNotFound() {
        Node root = new Node(1);

        Tree tree = new Tree(root);

        tree.lowestCommonAncestor(new Node(2), new Node(3));
    }
}
