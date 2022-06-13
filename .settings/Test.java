public class Test {
    public static void evaluateExpressionOne() {
        RPNCalculator rpnCalculator = new RPNCalculator();
        String inputStr = "3 4 +";
        double result = rpnCalculator.testExpression(inputStr);
        double expected = 7.0;
        if (result == expected) {
            System.out.println("Expression One test passed");
        } else {
            System.out.println("Expression One test failed");
        }
    }

    public static void evaluateExpressionTwo() {
        RPNCalculator rpnCalculator = new RPNCalculator();
        String inputStr = "5 6 + 3 *";
        double result = rpnCalculator.testExpression(inputStr);
        double expected = 33.0;
        if (result == expected) {
            System.out.println("Expression Two test passed");
        } else {
            System.out.println("Expression Two test failed");
        }
    }

    public static void evaluateExpressionThree() {
        RPNCalculator rpnCalculator = new RPNCalculator();
        String inputStr = "2 4 / 5 6 - *";
        double result = rpnCalculator.testExpression(inputStr);
        double expected = -0.5;
        if (result == expected) {
            System.out.println("Expression Three test passed");
        } else {
            System.out.println("Expression Three test failed");
        }
    }

    public static void evaluateExpressionFour() {
        RPNCalculator rpnCalculator = new RPNCalculator();
        String inputStr = "2 3 ^";
        double result = rpnCalculator.testExpression(inputStr);
        double expected = 8.0;
        if (result == expected) {
            System.out.println("Expression Four test passed");
        } else {
            System.out.println("Expression Four test failed");
        }
    }
}