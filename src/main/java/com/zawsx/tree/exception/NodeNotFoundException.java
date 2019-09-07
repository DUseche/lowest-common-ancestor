package com.zawsx.tree.exception;

/**
 * Created by David Useche on 31/08/2019.
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NodeNotFoundException extends RuntimeException{

    public NodeNotFoundException(String message) {
        super(message);
    }
}
