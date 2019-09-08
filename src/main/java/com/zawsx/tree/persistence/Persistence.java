package com.zawsx.tree.persistence;

import com.zawsx.tree.domain.Tree;

/**
 * Created by David Useche on 3/09/2019.
 *
 * Represents the persistence of the Trees
 * @see Tree
 */
public interface Persistence {

    /**
     * Saves a Tree
     * @param tree to save
     * @return saved Tree with assigned ID
     */
    Tree save(final Tree tree);

    /**
     * Retrieves a Tree given its ID
     * @param id of the Tree
     * @return found Tree
     * @throws com.zawsx.tree.exception.TreeNotFoundException if Tree does not exist
     */
    Tree getTree(long id);
}
