package com.zawsx.tree.domain;

/**
 * Created by David Useche on 3/09/2019.
 *
 * Represents the Flag to know if both Nodes have been found
 * @see Node
 */
public class Flag {

    /**
     * The first node have been found
     */
    private Boolean foundFirst;

    /**
     * The second node have been found
     */
    private Boolean foundSecond;

    /**
     * Init both nodes as not found
     */
    public Flag() {
        foundFirst = false;
        foundSecond = false;
    }

    /**
     * Mark the first node as found
     */
    public void findFirst() {
        foundFirst = true;
    }

    /**
     * Mark the second Node as found
     */
    public void findSecond() {
        foundSecond = true;
    }

    /**
     * Checks if both nodes have been found
     * @return true if both nodes were found, false otherwise
     */
    public boolean foundBoth() {
        return foundFirst && foundSecond;
    }
}
