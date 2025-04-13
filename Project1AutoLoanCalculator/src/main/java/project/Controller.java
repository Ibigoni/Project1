package project;

import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * Name: Ibigoni Inye-Tam
 * Username: Inyetp01
 */

public class Controller {

    @FXML
    private TextField bspriceTxt; //base price text field

    @FXML
    private TextField dpayTxt; //Dwwn payment text field

    @FXML
    private Label monthlyPay; // Monthly payment text field

    @FXML
    private RadioButton radioBtnfour; // Radio button for 48 months of loan term

    @FXML
    private RadioButton radioBtnsixty; //Radio button for 60 months of loan term

    @FXML
    private RadioButton radioBtnthree; //Radio button for 36 months of loan term

    @FXML
    private RadioButton radioBtntwo; // Radio button for 24 months of loan term

    @FXML
    private CheckBox rearCam; // Extra option: Rear camera for $340

    @FXML
    private TextField salestxTxt; // Financing information: sales tax percentage (7.0).

    @FXML
    private CheckBox sunrfChkBx; //Extra options: Sun roof for $1510

    @FXML
    private CheckBox tchScreen; // Extra options: Touch screen for $470

    @FXML
    private Label ttlPay; // Total payment

    @FXML
    private Label ttlloanAmnt; // Total loan amount
    
    @FXML
    private Label errorLbl; //Error Label

    
    // This DecimalFormat object would be used to round the formatted currency values to two decimal places.
    private final DecimalFormat df = new DecimalFormat("#.##"); 
  
    
    @FXML
    // Calculate button which solves the numbers added to the text fields
    void calculateBtn(ActionEvent event) {
    	calculate();
    }

    @FXML
    // Resets the calculator
    void resetBtn(ActionEvent event) {
    	reset();
    }

    
    public void initialize() {
    	//Setting the default values/options here
    	salestxTxt.setText("7.0");
    	radioBtntwo.setSelected(true);
    	rearCam.setSelected(true);
    }
    
    
    public void calculate() {
    	try {
    		double basePrice = Double.parseDouble(bspriceTxt.getText());
    		double downPayment = Double.parseDouble(dpayTxt.getText());
    		double taxRate = Double.parseDouble(salestxTxt.getText())/100;
    		
    		
    		//Calculating the Extra option cost
    		double optionCosts = 0;
    		if(sunrfChkBx.isSelected()) optionCosts += 1510;
    		if(tchScreen.isSelected()) optionCosts += 470;
    		if(rearCam.isSelected()) optionCosts += 340;
    		
    		//Calculating the subtotal
    		double subtotal = basePrice + optionCosts;
    		
    		//calculating the tax amount
    		double tax = subtotal * taxRate;
    		
    		//calculating the Total Loan
    		double totalLoan = subtotal + tax - downPayment;
    		
    		
    		//Determining the interest rate and Loan terms
    		
    		double annualInterestRate = 0;
    		int months = 0;
    		
    		if(radioBtntwo.isSelected()) {
    			annualInterestRate = 0.07;
    			months = 24;
    		}
    		
    		if(radioBtnthree.isSelected()) {
    			annualInterestRate = 0.06;
    			months = 36;
    		}
    		
    		if(radioBtnfour.isSelected()) {
    			annualInterestRate = 0.055;
    			months = 48;
    		}
    		
    		if(radioBtnsixty.isSelected()) {
    			annualInterestRate = 0.05;
    			months = 60;
    		}
    		
    		//calculate monthly payments
    		double monthlyInterest = annualInterestRate/12;
    		double monthScale = Math.pow(1 + monthlyInterest, months);
    		double monthlyPayment = totalLoan * monthlyInterest * monthScale/(monthScale - 1);
    		
    		
    		//Calculate the Total Payment
    		double totalPayment = monthlyPayment * months;
    		
    		//Update UI of the total loan, monthly payment, and total payment.
    		ttlloanAmnt.setText("$" + df.format(totalLoan));
    		monthlyPay.setText("$" + df.format(monthlyPayment));
    		ttlPay.setText("$" + df.format(totalPayment));
    		
    	}catch (NumberFormatException e) {
    		//This handles any invalid input that may not be a number
    	}
    	
	}

    
    
    public void reset() {
    	salestxTxt.setText("7.0");
    	radioBtntwo.setSelected(true);
    	rearCam.setSelected(true);
    	bspriceTxt.setText("");
    	dpayTxt.setText("");
    	radioBtnthree.setSelected(false);
    	radioBtnfour.setSelected(false);
    	radioBtnsixty.setSelected(false);
    	tchScreen.setSelected(false);
    	sunrfChkBx.setSelected(false);
    	monthlyPay.setText("0.0");
    	ttlPay.setText("0.0");
    	ttlloanAmnt.setText("0.0");
    	
    	
    }
    

}



