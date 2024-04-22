package lets_get_certified.lambdas.stacks;

import java.util.Stack;

public class TestCollections {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Andrea");
        stack.push("Barbara");
        stack.push("Caroline");
        System.out.println(stack);//Andrea, Barbara, Caroline

        System.out.println(String.format("Top of stack: %s", stack.peek()));//prend le top seulement
        System.out.println(String.format("Popped: %s", stack.pop()));//prend le top et le remove
        System.out.println(stack);//Andrea, Barbara
        stack.push("Helen");
        System.out.println(stack);//Andrea, Barbara, Helen
        System.out.println(String.format("Top of stack: %s", stack.peek()));//Helen
        Integer x = 2;
        x.compareTo(5);
    }
}
