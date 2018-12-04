/*
 * Classname:EmiCalculator
*
 * Version info:0.01
 *
 * Copyright notice
 */
package com.demo.training;
import java.util.Scanner;

//Emi calculator
public class EmiCalculator {
public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
				System.out.println("****Run program to calculate EMI for*****");
				System.out.println("Original Loan Principal Amount:" + "Rs");
				// LOAN AMOUNT SHOULD BE CONSTANT
				final float LOAN_AMOUNT = sc.nextFloat();
				System.out.println("Rate of interest:");
				float rateofInterest = sc.nextFloat();
				System.out.println("Loan Tenure:");
				//Tenure should not be negative
				float tenure = sc.nextFloat();
				if(tenure<0){
					System.out.println("Tenure should not be negative");
					System.exit(0);
				}
				System.out.println(" No of Installments");
				float NoofInstallments = sc.nextFloat();
				//No of installments should not be greater than tenure
				if(tenure>=NoofInstallments){
					System.out.println("No of installments should not be greater than tenure");
					System.exit(0);
				}
				EmiCalculator mi = new EmiCalculator();
		        float emi = EmiCalculator.getEMI(LOAN_AMOUNT, rateofInterest, tenure,NoofInstallments);
				System.out.println("the Installment Amount of a loan :  Rs " + emi);
				mi.repaymentSchedule(emi, LOAN_AMOUNT, rateofInterest, tenure, NoofInstallments);
		
			}
	// the Installment Amount of a loan	
	//Calculates the EMI for a given Loan
	static float getEMI(float loanAmount, float rateofInterest, float tenure, float NoofInstallments) {
		rateofInterest = rateofInterest / 100;
		float emiNumerator = loanAmount * rateofInterest / NoofInstallments;
	    float emidenominator1 = (float) Math.pow((1 + ((rateofInterest / NoofInstallments))), tenure);
		float emidenominator2 = 1 / emidenominator1;
		float emi = (float) Math.round((emiNumerator / (1 - emidenominator2)) * 100 / 100);
		return emi;
	}


	//calculates The Repayment Schedule for the entire loan period
	void repaymentSchedule(float emi  , float loanAmount, float rateofInterest, float tenure, float NoofInstallments) {
		// Loops for each installment.
		// outstanding principle should be change each time.
		System.out.println("******The Repayment Schedule for the entire loan period************");
		int j;
		float outstandingPrincipal[] = new float[100];
		float principalComponent[] = new float[100];
		float interestRate[] = new float[100];
		outstandingPrincipal[1] = loanAmount;
		System.out.println("#.no\tOutstandingPrinciple\tInterest\t" + "Principal\t" + "EMI");
		for (j = 1; j <= NoofInstallments; j++) {
			interestRate[j] = (outstandingPrincipal[j] * (rateofInterest / (NoofInstallments * 100)));
			principalComponent[j] = emi - interestRate[j];
			outstandingPrincipal[j + 1] = outstandingPrincipal[j] - principalComponent[j];
			System.out.println(j + "\t" +  Math.round(outstandingPrincipal[j]*100)/100+ "\t\t\t" +Math.round (interestRate[j]*100)/100 + "\t\t"
					+ Math.round(principalComponent[j]*100)/100 + "\t\t" + Math.round(emi*100)/100);
		}
//		calulate the Principal and Interest component of an Installment given1
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Installmentnumber");
		int output = sc.nextInt();
		int g = output;
		if (g == output) {
			System.out.println("#.no\tOutstandingPrinciple\tInterest\t" + "Principal\t" + "EMI");
			System.out.println(g + "\t" +  Math.round(outstandingPrincipal[g]*100)/100+ "\t\t\t" +Math.round (interestRate[g]*100)/100 + "\t\t"
					+ Math.round(principalComponent[g]*100)/100 + "\t\t" + Math.round(emi*100)/100);
			System.out.println("****THANKYOU*****");
		}
	}
}
		