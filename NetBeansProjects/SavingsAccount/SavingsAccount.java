/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package savingsaccount;

/**
 *
 * @author Reddogg
 */
public class SavingsAccount {

    public static double annualInterestRate;
    
    private double savingsBalance;
    
    private double getSavingsBalance(){
        return savingsBalance;
    }
    
    private void setSavingsBalance(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }
    
    private void calculateMonthlyInterest(){
        // multiply savingsBalance by annualInterestRate / 12
        double monthlyInterestRate = (savingsBalance * annualInterestRate) / 12.0;
//        System.out.printf("Monthly interest rate saver 1 is %.2f%n", monthlyInterestRate);
        savingsBalance += monthlyInterestRate;
    }
    
    public static void modifyInterestRate(double interestRate){
        //set annualInterestRate to new value
        annualInterestRate = interestRate;
    }
    
    public static void main(String[] args) {
        
        // test SavingsAccount
        //instantiate two savingsAccount objects
        SavingsAccount saver1 = new SavingsAccount();
        saver1.setSavingsBalance(2000.00);
        SavingsAccount saver2 = new SavingsAccount();
        saver2.setSavingsBalance(3000.00);

        //set annualInterestRate to 4%
        SavingsAccount.modifyInterestRate(.04);
        
        //calculate monthly interest for each of 12 months and print balance both savers
        for (int i=1; i <= 12; i++) {
            saver1.calculateMonthlyInterest();
        }
        System.out.println("The interest rate is: " + SavingsAccount.annualInterestRate);
        System.out.printf("Saver1 new balance is %.2f%n", saver1.getSavingsBalance());

        for (int i=1; i <= 12; i++) {
            saver2.calculateMonthlyInterest();
        }
        System.out.printf("Saver2 new balance is %.2f%n", saver2.getSavingsBalance());
        System.out.println();
        
        //set annualInterestRate to 5%
        SavingsAccount.modifyInterestRate(.05);
        
        //print new balances for both savers
        for (int i=1; i <= 12; i++) {
            saver1.calculateMonthlyInterest();
        }
        System.out.println("The interest rate is: " + SavingsAccount.annualInterestRate);
        System.out.printf("Saver1 new balance is %.2f%n", saver1.getSavingsBalance());
        
        for (int i=1; i <= 12; i++) {
            saver2.calculateMonthlyInterest();
        }
        System.out.printf("Saver2 new balance is %.2f%n", saver2.getSavingsBalance());
        System.out.println();
    }
}
