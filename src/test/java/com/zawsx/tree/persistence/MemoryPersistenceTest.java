package com.zawsx.tree.persistence;

import com.zawsx.tree.domain.Node;
import com.zawsx.tree.domain.Tree;
import com.zawsx.tree.exception.TreeNotFoundException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by David Useche on 8/09/2019.
 */
@SpringBootTest
public class MemoryPersistenceTest {

    @Autowired
    private MemoryPersistence underTest;

    @Test
    @DirtiesContext
    public void givenTree_ShouldSaveAndReturnTreeWithIdZero() {
        Node root = new Node(1);

        Tree tree = new Tree(root);

        Tree saved = underTest.save(tree);

        Assert.assertEquals(tree.getRoot(), saved.getRoot());
        Assert.assertEquals(0, saved.id);
    }

    @Test
    @DirtiesContext
    public void givenExistingId_ShouldGetTree() {
        Node root = new Node(1);

        Tree tree = new Tree(root);

        underTest.save(tree);

        Tree obtained = underTest.getTree(0);

        Assert.assertEquals(tree.getRoot(), obtained.getRoot());
        Assert.assertEquals(0, obtained.id);
    }

    @Test
    public void givenUnExistingId_ShouldThrowException() {
        assertThrows(TreeNotFoundException.class, () -> underTest.getTree(0));
    }
}
