package interpret;

/**
 * leetCode-1678: ��� Goal ������
 */
public class Interpret {

    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }

    public static void main(String[] args) {
        Interpret interpret = new Interpret();
        String command = "G()(al)";
        System.out.println(interpret.interpret(command));
    }

}
