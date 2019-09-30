import org.improving.tag.InputOutput;

public class TestInputOutput implements InputOutput {
    ///wrote this to satisfy dependency. Dance Command requires an io. this class exists only so we can test.
    public String lastText;

    @Override
    public String receiveInput() {
        return null;
    }

    @Override
    public void displayText(String text) {
        this.lastText= text;//displayText method receives (as a parameter) the response we want printed to the screen...instead just save that response here as a class level variable of TestInputOutput
    }

    @Override
    public void displayPrompt(String prompt) {

    }
}
