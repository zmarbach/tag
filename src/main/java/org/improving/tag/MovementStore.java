package org.improving.tag;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class MovementStore {
    private Stack<Location> locationStack = new Stack<>();

    public Stack<Location> getLocationStack() {
        return locationStack;
    }

    //REMOVED setter because don't want people to be able to set entire stack, only add and remove
    // public void setLocationStackn(Stack<Location> locationStack) {
        //this.locationStack = locationStack;
    //}
}



