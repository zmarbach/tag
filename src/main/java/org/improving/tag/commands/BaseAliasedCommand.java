package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseAliasedCommand implements Command {//abstract because exclusively exists to be extended upon by children
    protected final InputOutput io;
    private List<String> aliases = new ArrayList<>();///always do this...initialize value so it avoids null pointer exception


    public BaseAliasedCommand(InputOutput io, String...aliases) {//hand me as many aliases as you want
        this.io = io;
        this.aliases.addAll(Arrays.asList(aliases));
    }

    @Override
    public boolean isValid(String input, Game game) {
        try {
            var trimmedInput = getCommandPart(input).trim();
            return aliases.stream().anyMatch(trimmedInput::equalsIgnoreCase);
        }
        catch (UnsupportedOperationException ex) {
            return false; //catch exception from move command and make isValid false, so it goes to loop in Game.run and says "huh? I don't understand."
        }
    }

    public void childExecute (String input, Game game) throws IOException { }

    public String getErrorMessage(){
        return "Huh? I don't understand.";
    }

    @Override
    public void execute(String input, Game game) {
        try {
            childExecute(input, game);
        } catch (UnsupportedOperationException | FileNotFoundException ex) {
            io.displayText(getErrorMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCommandPart (String input) {
        return input;
        }

    //we have ArrayList aliases, give me stream version, filter stream, passing each member through equals ignore case of input, if true, give us the first one.
    //conveyor belt example, pass aliases and leave TRUE results (input that is a valid alias) on the conveyor belt. at the end of the conveyor belt, give me the first one
    //is Present - if not - return false, if valid alias IS PRESENT - return TRUE

        //could just do a FOR LOOP, instead
        //for (var a : aliases) {
          //  if (input.equalsIgnoreCase(a)) {
            //    return true;}
            //return false;
    }

        //do NOT need execute method...leave that to child class because execute may not be same for each command
    //      (Ex: LOOK might want you to look around, but in future HEAL might want you to do something diff, but HEAL still extends BaseAliasedCommand).)
