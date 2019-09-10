package com.zawsx.tree.persistence;

import com.zawsx.tree.domain.Tree;
import com.zawsx.tree.exception.TreeNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Useche on 3/09/2019.
 */
@Component
public class MemoryPersistence implements Persistence{

    /**
     * Memory save
     */
    private List<Tree> trees;

    /**
     * Init the memory persistence
     */
    public MemoryPersistence() {
        trees = new ArrayList<>();
    }

    @Override
    public Tree save(final Tree tree) {
        tree.id = trees.size();
        trees.add(tree);
        return tree;
    }

    @Override
    public Tree getTree(final long id) {
        return trees
                .stream()
                .filter(tree -> tree.id == id)
                .findFirst()
                .orElseThrow(() -> new TreeNotFoundException("Given tree does not exist"));
    }
}
