/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modularcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author joshuadorsett
 */
public class ModularCalculatorFXMLController {

    @FXML
    private Label display;
//    attributes for calculations
    private int operand1 = 0;
    private int operand2 = 0;
    private char operator = '@';
    private int result = 0;
    private boolean newOperandAvailable = false;
    private boolean emptyNumberString = true;
    private int messageCounter = 0;
        
//    int signature for setDisplay()
    public void setDisplay(int num){
        display.setText(Integer.toString(num));
    }
    
//    String signature for setDisplay()
    public void setDisplay(String string){
        display.setText(string);
    }
    
//    concatanetes numbers
    public int numberBuilder(int oldNumber, int newNumber) {
        return Integer.valueOf(String.valueOf(oldNumber) 
                + String.valueOf(newNumber));
    }
    
//    sets either num1 or num2 depending on when num is typed
    public void setOperand(int num){
//      if the operator hasn't changed from initial value '@', operand1 is being set
        if(operator == '@'){
//            if operand1 is empty it starts a new number
            if (emptyNumberString){
               operand1 = num;
               emptyNumberString = false;
               setDisplay(operand1); 
            } 
//            if operand1 is not empty it concatenates to the right
            else {
                operand1 = numberBuilder(operand1, num);
                setDisplay(operand1); 
            }
            newOperandAvailable = false;
        }
//      if operator does not equal initial value '@', operand2 is being set
        else {
//            if operand2 is empty it starts a new number
            if (emptyNumberString){
               operand2 = num;
               emptyNumberString = false;
               setDisplay(operand2); 
            } 
//            if operand2 is not empty it concatenates to the right
            else {
                operand2 = numberBuilder(operand2, num);
                setDisplay(operand2);               
            }
//            now that operand2 has been set we calculate a result
            calculateResult();
        }
    }
    
//    resets values for new operation
    public void reset() {
        operand1 = 0;
        operand2 = 0;
        operator = '@';
        emptyNumberString = true;
    }
    
//    factorial method
    static int factorial(int n) 
    { 
        if (n == 0) 
          return 1; 
        return n*factorial(n-1); 
    } 
    
//    calcualations
    public void calculateResult(){
        switch(operator){
            case '+': result = operand1 + operand2;
                break;
            case '-': result = operand1 - operand2;
                break;
            case '*': result = operand1 * operand2;
                break;
            case '/': result = operand1 / operand2;
                break;
            case '%': result = operand1 % operand2;
                break;
            case '!': result = factorial(operand1);
                break;     
        }
//      result is set to operand1
        newOperandAvailable = true;
    }
    
//    return/clear buttons
    @FXML
    public void equals(ActionEvent event) {
        calculateResult();
        setDisplay("is " + Integer.toString(result));
        reset();
    }
    
    @FXML
    public void clear(ActionEvent event) {
        reset();
        result = 0;
        setDisplay(messageGenerator());
    }
    
    public String messageGenerator(){
        String[] messages = {"hi","nice","beep","boop","math","good job","incredible"};
        if (messageCounter > 6){
            messageCounter = 0;
        }
        return messages[messageCounter++];      
    }
    
//    operator buttons
//    these set emptyNumberString to true to restart numberBuilder
    @FXML
    public void multiply(ActionEvent event) {
        operator = '*';
        emptyNumberString = true;
        if (newOperandAvailable){
            operand1 = result;
        }
        setDisplay("times");
        
    }

    @FXML
    public void subtract(ActionEvent event) {
        operator = '-';
        emptyNumberString = true;
        if (newOperandAvailable){
            operand1 = result;
        }
        setDisplay("minus");
    }

    @FXML
    public void addition(ActionEvent event) {
        operator = '+';
        emptyNumberString = true;
        if (newOperandAvailable){
            operand1 = result;
        }
        setDisplay("plus");
    }
    
    @FXML
    public void divide(ActionEvent event) {
        operator = '/';
        emptyNumberString = true;
        if (newOperandAvailable){
            operand1 = result;
        }
        setDisplay("divides");
    }

    @FXML
    public void modulo(ActionEvent event) {
        operator = '%';
        emptyNumberString = true;
        if (newOperandAvailable){
            operand1 = result;
        }
        setDisplay("modulo");
        
    }
    
    @FXML
    public void factorial(ActionEvent event) {
        operator = '!';
        emptyNumberString = true;
        if (newOperandAvailable){
            operand1 = result;
        }
        setDisplay("factorial"); 
    }
    
//    number buttons call setOperand() with its own number as arg
    @FXML
    public void zero(ActionEvent event) {
        setOperand(0);
    }
    
    @FXML
    public void one(ActionEvent event) {
        setOperand(1);
    }
    
    @FXML
    public void two(ActionEvent event) {
        setOperand(2);
    }

    @FXML
    public void three(ActionEvent event) {
        setOperand(3);
    }

    @FXML
    public void four(ActionEvent event) {
        setOperand(4);
    }

    @FXML
    public void five(ActionEvent event) {
        setOperand(5);
    }

    @FXML
    public void six(ActionEvent event) {
        setOperand(6);
    }

    @FXML
    public void seven(ActionEvent event) {
        setOperand(7);
    }

    @FXML
    public void eight(ActionEvent event) {
        setOperand(8);
    }

    @FXML
    public void nine(ActionEvent event) {
        setOperand(9);
    }
}