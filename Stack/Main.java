package Stack;
import java.util.Stack;

class WebPage {

    String url;

    String timestamp;

    public WebPage(String url, String timestamp) {

        this.url = url;

        this.timestamp = timestamp;
    }

}



class WebPageStack {

    private Stack<WebPage> stack;

    public WebPageStack() {
        stack = new Stack<>();
    }

    public void push(WebPage webPage) {
        stack.push(webPage);
    }

    public WebPage pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public WebPage peek() {
        return stack.peek();
    }
}


public class Main {

    public static void main(String[] args) {

        WebPageStack webPageStack = new WebPageStack();

        // Pushing WebPages to the stack

        WebPage webPage1 = new WebPage("https://www.google.com", "1234");

        WebPage webPage2 = new WebPage("https://www.linkedin.com/", "45678");

        webPageStack.push(webPage1);

        webPageStack.push(webPage2);

        System.out.println("Stack size: " + webPageStack.size());

        // Popping a WebPage from the stack

        WebPage poppedWebPage = webPageStack.pop();

        System.out.println("Popped WebPage: " + poppedWebPage.url);

        System.out.println("Stack size: " + webPageStack.size());

        WebPage topWebPage = webPageStack.peek();

        System.out.println("Top WebPage: " + topWebPage.url);

        System.out.println("Is stack empty? " + webPageStack.isEmpty());
    }

}