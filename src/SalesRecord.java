import java.util.Scanner;

/** This is a sales record application
 * @author Soulyana Lakew
 */

public class SalesRecord {
    public static void main(String[] args) {
        // Variables to be used in application
        int customerID;
        String customerName, taxCode, ans;
        double salesAmt;

        // Created to capture user input
        Scanner scan = new Scanner(System.in);

        do {
            // Prompt user for customer id
            System.out.println("What is the customer ID?");
            customerID = scan.nextInt();

            scan.nextLine();

            // Prompt user for customer name
            System.out.println("What is the customer's name?");
            customerName = scan.nextLine();

            // Prompt user for sales amount
            System.out.println("What is the sales amount?");
            salesAmt = scan.nextDouble();

            // Validates proper tax code
            do {
                // Prompt user for tax code
                System.out.println("What is the tax code?");
                taxCode = scan.next();
                if (!taxCode.equalsIgnoreCase("NRM") && !taxCode.equalsIgnoreCase("NPF")
                        && !taxCode.equalsIgnoreCase("BIZ")) {
                    System.out.println("Invalid tax code. Please enter correct tax code.");
                }
            }while(!taxCode.equalsIgnoreCase("NRM") && !taxCode.equalsIgnoreCase("NPF")
                    && !taxCode.equalsIgnoreCase("BIZ"));

            // Validates proper entry to continue or end application
            do {
                // Prompt user to continue or end entering user information
                System.out.println("Do you want to enter another record? (Y/N)");
                ans = scan.next();
                System.out.println();
                if (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")) {
                    System.out.println("Invalid entry. Please enter Y for Yes or N for No.");
                }
                if (ans.equalsIgnoreCase("n") || ans.equalsIgnoreCase("y")) {
                    System.out.println("Thank you!");
                    displayDetails(customerID, customerName, Math.round(salesAmt * 100d) / 100d,
                            taxCode.toUpperCase(), totalAmtDue(salesAmt, taxCode));
                }
            }while(!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n"));
        } while (!ans.equalsIgnoreCase("n"));
    }

    // Method displays customer information on console
    private static void displayDetails(int customerIDIn, String customerNameIn, double salesAmtIn, String taxCodeIn,
                                      double totalAmtDueIn) {
        System.out.println("Customer ID: " + customerIDIn + "\n" + "Customer Name: " + customerNameIn + "\n"
        + "Sales Amount: $" + salesAmtIn +  "\n" + "Tax Code: " + taxCodeIn + "\n" + "Total Amount Due: $"
                + totalAmtDueIn + "\n");
    }

    // Method calculates total amount due by utilizing correct tax based on user entered tax code
    private static double totalAmtDue(double salesAmtIn, String taxCodeIn) {
        double subtotal, totalAmt, tax = 0.00;

            switch (taxCodeIn.toUpperCase()) {
                case "NRM": tax = 0.06;
                    break;
                case "NPF": tax = 0.00;
                    break;
                case "BIZ": tax = 0.045;
                    break;
                default: System.out.println("Invalid tax code. Please enter correct tax code.");
                    break;
            }

        subtotal = salesAmtIn * tax;
        totalAmt = salesAmtIn + subtotal;
        return Math.round(totalAmt * 100d) /100d;
    }
}
