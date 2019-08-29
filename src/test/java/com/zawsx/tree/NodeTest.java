package com.zawsx.tree;

import com.zawsx.tree.domain.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * Created by David Useche on 28/08/2019.
 */
public class NodeTest {

    @Test
    public void givenANode_ShouldBeItsParent() {
        Node underTest = new Node(0);

        Set<Node> result = underTest.parentOf(new Node(0), new Node(0));

        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.contains(underTest));
    }

    @Test
    public void givenANodeWithNoNodes_ShouldNotBeParent() {
        Node underTest = new Node(0);

        Set<Node> result = underTest.parentOf(new Node(1), new Node(2));

        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void givenANodeWithChildrenWhenLookingForParentOfOneChildren_ShouldBeParent() {
        Node underTest = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);

        underTest.add(one);
        underTest.add(two);

        Set<Node> result = underTest.parentOf(new Node(1), new Node(3));

        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.contains(one));
    }

    @Test
    public void givenANodeWithChildrenWhenLookingForParentOfBothChildren_ShouldBeParent() {
        Node underTest = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);

        underTest.add(one);
        underTest.add(two);

        Set<Node> result = underTest.parentOf(new Node(1), new Node(2));

        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(one));
        Assert.assertTrue(result.contains(two));
    }

    @Test
    public void givenANodeWithChildrenWhenLookingForParentOfNodeInChildrenOne_ShouldBeParent() {
        Node underTest = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        one.add(three);
        underTest.add(one);
        underTest.add(two);

        Set<Node> result = underTest.parentOf(new Node(1), new Node(3));

        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(one));
        Assert.assertTrue(result.contains(three));
    }

    @Test
    public void givenANodeWithChildrenWhenLookingForParentOfNodeInChildrenTwo_ShouldBeParent() {
        Node underTest = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        one.add(three);
        underTest.add(one);
        underTest.add(two);

        Set<Node> result = underTest.parentOf(new Node(2), new Node(3));

        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(two));
        Assert.assertTrue(result.contains(three));
    }
}
