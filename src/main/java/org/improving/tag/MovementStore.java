package org.improving.tag;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class MovementStore {
    private Stack<Location> locationStack = new Stack<>();
    private String movementStoreName = "movementStoreName";

    public Stack<Location> getLocationStack() {
        return locationStack;
    }

    public String getMovementStoreName() {
        return movementStoreName;
    }

    public void setLocStack(Stack<Location> prevlocStack) {
        this.locationStack = locationStack;
    }
}



