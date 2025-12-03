import java.util.Stack;
import java.util.Scanner;

public class RPNCalculator {

    public static double evaluateRPN(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                // Операция
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Недостаточно операндов для операции: " + token);
                }
                double b = stack.pop();
                double a = stack.pop();
                double result = applyOperation(a, b, token);
                stack.push(result);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Некорректное выражение");
        }

        return stack.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static double applyOperation(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Деление на ноль");
                return a / b;
            case "^": return Math.pow(a, b);
            default: throw new IllegalArgumentException("Неизвестная операция: " + op);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Калькулятор обратной польской записи (RPN)");
        System.out.println("Пример ввода: 2 3 + 4 *");
        System.out.print("Введите выражение: ");
        String expression = scanner.nextLine();

        try {
            double result = evaluateRPN(expression);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }
}