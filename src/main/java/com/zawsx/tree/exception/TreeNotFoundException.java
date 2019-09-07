package com.zawsx.tree.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by David Useche on 3/09/2019.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TreeNotFoundException extends RuntimeException{

    public TreeNotFoundException(String message) {
        super(message);
    }
}
