import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RPNCalculator implements RPN {
  
    private ArrayList<String> expression;

    //You must use the provided LinkedList stack in this assessment any other data structure is not valid
    LinkedListStack<Double> expressionStack;
  List<String> validTerms = Arrays.asList("+", "-", "*", "/", "^");

    /**Run
     * Create a constructor for the class that initialises the fields
     */
    public RPNCalculator() {
        expression = new ArrayList<>();
        expressionStack = new LinkedListStack<>();
    }
  
    /**
     * Create a method that checks that a String is a valid double
     * @param num
     * @return either null or the actual double
     */
  public Double validDouble(String numStr) { 
        Double numValue = null; 
    Pattern pattern = Pattern.compile("[0-9]+[.]{0,1}[0-9]*[dD]{0,1}");
        Matcher isNum = pattern.matcher(numStr);
        if (isNum.matches()) {
            numValue = Double.valueOf(numStr);
        }
        return numValue; 
    
      } 
  
  public static void main(String[]args){
    RPNCalculator rpn = new RPNCalculator();
    System.out.println(rpn.validDouble("1.1"));
  }
    /**
     * Create a method that checks if an expression is valid.
     * A valid expression only contains doubles and the validTerms listed above separated by space characters
     *
     * @param expressionArray
     * @return
     */

 public boolean checkValidExpression(String[] expressionArray) {
        boolean expressionOK = true;
        if (expressionArray == null || expressionArray.length < 3) {
            return false;
        }
        if (validDouble(expressionArray[0]) == null
                || validDouble(expressionArray[1]) == null
                || !validTerms.contains(expressionArray[2])) {
            return false;
        }
        if (!validTerms.contains(expressionArray[expressionArray.length-1])){
            return false;
        }
        for (int i = 1; i < expressionArray.length-1; i++) {
            if (validDouble(expressionArray[i])!=null){
                if (validDouble(expressionArray[i-1])!=null&&validDouble(expressionArray[i+1])!=null){
                    return false;
                }
            }else if (validTerms.contains(expressionArray[i])){
                if (validTerms.contains(expressionArray[i-1])&&validTerms.contains(expressionArray[i+1])){
                    return false;
                }
            }else {
                return false;
            }
        }
        return expressionOK;
    }

    /**
     * Create a method that prints out the text String
     * "Enter a valid expression in RPNCalculator, uses spaces to split the terms"
     * If the expression is valid (tested using checkValidExpression) then add it to the ArrayList expression
     * If the expression is not valid loop until it is
     */
    public void getExpression() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] exs = str.split(" ");
        if (checkValidExpression(exs)) {
            Collections.addAll(expression, exs);
        } else {
            System.out.println("Expression is not valid, please enter again！");
            getExpression();
        }
    }

    /**
     * Write the main method to perform the calculation of the RPNCalculator expression using the LinkedListStack
     *
     * @return the final result of the calculation
     */
    public double evaluateExpression() {
        double result = 0.0;
        for (String ex : expression){
            if (validDouble(ex)!=null){
                expressionStack.push(Double.valueOf(ex));
            }
            if (validTerms.contains(ex)){
                double termTwo = expressionStack.pop();
                double termOne = expressionStack.pop();
                if ("+".equals(ex)){
                    result = termOne+termTwo;
                }else if ("-".equals(ex)){
                    result = termOne-termTwo;
                }else if ("*".equals(ex)){
                    result = termOne*termTwo;
                }else if ("/".equals(ex)){
                    result = termOne/termTwo;
                }else if ("^".equals(ex)){
                    result = Math.pow(termOne,termTwo);
                }
                expressionStack.push(result);
            }
        }
        return expressionStack.pop();
    }

    /**
     * Use this method for the main menu
     *
     * @return
     */
    public boolean calculate() {
        System.out.println("Select 1 to enter an expression or 0 to quit");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            getExpression();
            System.out.println(evaluateExpression());
        } else if (choice.equals("0")) {
            return false;
        } else {
            System.out.println(choice + " is not a valid choice!");
        }
        return true;
    }

    /**
     * Main loop
     */
    public void calculateRPN() {
        boolean calculating = true;
        while (calculating) {
            calculating = calculate();
        }
    }

    public double testExpression(String expressionStr) {
        String[] expressionArray = expressionStr.split(" ");
        Collections.addAll(expression, expressionArray);
        return evaluateExpression();
    }
}
