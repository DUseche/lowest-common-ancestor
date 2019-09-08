package com.zawsx.tree.persistence;

import com.zawsx.tree.domain.Tree;

/**
 * Created by David Useche on 3/09/2019.
 */
public interface Persistence {

    Tree save(final Tree tree);

    Tree getTree(long id);
}
