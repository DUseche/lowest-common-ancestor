package com.zawsx.tree.domain;

/**
 * Created by David Useche on 3/09/2019.
 */
public class Flag {

    Boolean foundFirst;

    Boolean foundSecond;

    public Flag() {
        foundFirst = false;
        foundSecond = false;
    }

    public void findFirst() {
        foundFirst = true;
    }

    public void findSecond() {
        foundSecond = true;
    }

    public boolean foundBoth() {
        return foundFirst && foundSecond;
    }
}
