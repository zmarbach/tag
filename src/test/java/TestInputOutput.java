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
        this.lastText= text;
    }

    @Override
    public void displayPrompt(String prompt) {

    }
}
