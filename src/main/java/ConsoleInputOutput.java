import java.util.Scanner;

public class ConsoleInputOutput implements InputOutput {

    Scanner scanner = new Scanner(System.in);

    public void display(String message) {
        System.out.println(message);
    }

    public String getInput() {
        return scanner.nextLine();
    }
}
