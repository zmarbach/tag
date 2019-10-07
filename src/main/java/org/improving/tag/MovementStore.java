package org.improving.tag;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Stack;

@Component
public class MovementStore implements Serializable {
    private Stack<Location> locationStack = new Stack<>();

    public Stack<Location> getLocationStack() {
        return locationStack;
    }

    public void setLocStack(Stack<Location> prevlocStack) {
        this.locationStack = locationStack;
    }
}



