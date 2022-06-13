public interface RPN {
    String[] validTerms= {"+", "-","*","/", "^"};
  
   
    /**
     * Create a method that checks that a String is a valid double
     * @param num
     * @return either null or the actual double
     */
    Double validDouble(String num);
     
    /**
     * Create a method that checks if an expression is valid.
     * A valid expression only contains doubles and the validTerms listed above separated by space characters
     * @param expressionArray
     * @return
     */
    boolean checkValidExpression(String[] expressionArray);

    /**
     * Create a method that prints out the text String
     * "Enter a valid expression in RPNCalculator, uses spaces to split the terms"
     * If the expression is valid (tested using checkValidExpression) then add it to the ArrayList expression
     * If the expression is not valid loop until it is
     */
    void getExpression();

    /**
     * Write the main method to perform the calculation of the RPNCalculator expression using the LinkedListStack
     * @return the final result of the calculation
     */
    double evaluateExpression();

    /**
     * Use this method for the main menu
     * @return
     */
    boolean calculate();

    /**
     * Main loop
     */
    void calculateRPN();
}
