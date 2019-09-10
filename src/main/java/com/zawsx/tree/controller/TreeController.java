package com.zawsx.tree.controller;

import com.zawsx.tree.domain.Node;
import com.zawsx.tree.domain.Tree;
import com.zawsx.tree.persistence.MemoryPersistence;
import com.zawsx.tree.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by David Useche on 3/09/2019.
 *
 * Offers a REST Controller to access the Tree logic
 */
@RestController
@RequestMapping("/trees")
public class TreeController {

    /**
     * The persistence this MS has, currently only by memory, but it is scalable by defining a new type of persistence
     * and injecting it
     */
    private final Persistence persistence;

    @Autowired
    public TreeController(MemoryPersistence persistence) {
        this.persistence = persistence;
    }

    /**
     * Save a new Tree
     *
     * @param tree to save
     * @return saved Tree with an ID
     */
    @PostMapping()
    public Tree createTree(@RequestBody Tree tree) {
        return persistence.save(tree);
    }

    /**
     * Given Nodes with value p and q, calculate the Lowest Common Ancestor of the Tree with id X
     *
     * @param firstNode to search
     * @param secondNode to search
     * @param treeId of the Tree
     * @return
     */
    @GetMapping(value = "/{treeId}/lowest-common-ancestor")
    public Integer getMinimumAncestor(@RequestParam("p") int firstNode, @RequestParam("q") int secondNode,
                                      @PathVariable long treeId) {
        return persistence.getTree(treeId).lowestCommonAncestor(new Node(firstNode), new Node(secondNode)).getValue();
    }
}
