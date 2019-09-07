package com.zawsx.tree.domain;

import com.zawsx.tree.domain.Flag;
import com.zawsx.tree.domain.Node;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by David Useche on 28/08/2019.
 */
public class NodeTest {

    @Test
    public void givenAnEmptyNodeWhenAskForLCAOfTwoUnknownNodes_ShouldReturnFalseFlag() {
        Node node = new Node(1);

        Flag flag = new Flag();

        Node LCA = Node.lowestCommonAncestor(node, new Node(2), new Node(3), flag);

        Assert.assertFalse(flag.foundBoth());
    }

    @Test
    public void givenAnEmptyNodeWhenAskForLCAOfOneKnownNodeAndOneUnknownNode_ShouldReturnFalseFlag() {
        Node node = new Node(1);

        Flag flag = new Flag();

        Node LCA = Node.lowestCommonAncestor(node, new Node(1), new Node(3), flag);

        Assert.assertFalse(flag.foundBoth());
    }

    @Test
    public void givenANodeWithChildrenWhenAskForLCAOfKnownChildren_ShouldReturnParent() {
        Node childOne = new Node(2);
        Node childTwo = new Node(3);
        Node parent = new Node(1, childOne, childTwo);

        Flag flag = new Flag();

        Node LCA = Node.lowestCommonAncestor(parent, new Node(2), new Node(3), flag);

        Assert.assertTrue(flag.foundBoth());
        Assert.assertEquals(parent, LCA);
    }

    @Test
    public void givenANodeWithChildrenAndGrandChildrenWhenAskForLCAOfKnownGrandChildrenChildren_ShouldReturnChild() {
        Node grandChildOne = new Node(6);
        Node grandChildTwo = new Node(5);
        Node grandChildThree = new Node(4);
        Node grandChildFour = new Node(3);

        Node childOne = new Node(2, grandChildOne, grandChildTwo);
        Node childTwo = new Node(1, grandChildThree, grandChildFour);

        Node parent = new Node(0, childOne, childTwo);

        Flag flag = new Flag();

        Node LCA = Node.lowestCommonAncestor(parent, new Node(6), new Node(5), flag);

        Assert.assertTrue(flag.foundBoth());
        Assert.assertEquals(childOne, LCA);
    }

    @Test
    public void givenANodeWithChildrenAndGrandChildrenWhenAskForLCAOfKnownGrandChildrenChildren_ShouldReturnParent() {
        Node grandChildOne = new Node(6);
        Node grandChildTwo = new Node(5);
        Node grandChildThree = new Node(4);
        Node grandChildFour = new Node(3);

        Node childOne = new Node(2, grandChildOne, grandChildTwo);
        Node childTwo = new Node(1, grandChildThree, grandChildFour);

        Node parent = new Node(0, childOne, childTwo);

        Flag flag = new Flag();

        Node LCA = Node.lowestCommonAncestor(parent, new Node(6), new Node(3), flag);

        Assert.assertTrue(flag.foundBoth());
        Assert.assertEquals(parent, LCA);
    }
}
