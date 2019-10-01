import org.improving.tag.InputOutput;

public class TestInputOutput implements InputOutput {
    ///wrote this to satisfy dependency. Dance Command requires an io. this class exists only so we can test.
    public String lastText;

    @Override
    public String receiveInput() {
        return null;
    }

    @Override
    public void displayText(Object text) {//played with this to demonstrate toString (making Object text to a string)
        this.lastText= text.toString();//displayText method receives (as a parameter) the response we want printed to the screen...instead just save that response here as a class level variable of TestInputOutput
    }

    @Override
    public void displayNewLine() {    }

    @Override
    public void displayPrompt(String prompt) {

    }
}
