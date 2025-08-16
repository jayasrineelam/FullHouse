//Calculate the movie price with movie name, no of people,and based on membership
//There are 4 movies and each movie has a price, movie 1 = 12$, movie2 = 15$, movie3 = 10$, movie4 = 12$
// Select the movie name
//calculate the TotalBillAmount = priceofthemovie * numberofpeople
// Calculate discount based on number of people
// Calculate discount based on membership
// Calculate Salestax

// English not here !!
//
// Update from Ayman: This single line is my change
// Update from Vivek: This single line is my change

import java.util.Scanner;

public class MovieCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (;;) {           

            System.out.println("Enter the number of people");
            int NumberofPeople = scanner.nextInt();
            scanner.nextLine();
            
            System.out.println("Enter the movie number (1 to 4):");
            int MovieName = scanner.nextInt();
            scanner.nextLine();
            
            System.out.println("Are you a member? Yes/No: ");
            String isMemberInput = scanner.nextLine();
            boolean isMember = isMemberInput.equalsIgnoreCase("Yes");

            int MoviePrice = FindMoviePrice(MovieName);
            double TotalBillAmount = CalculateBillAmount(NumberofPeople, MoviePrice);
            TotalBillAmount = AddDiscountBasedOnNumberOfPeople(TotalBillAmount, NumberofPeople);
            TotalBillAmount = AddDiscountBasedOnMembership(TotalBillAmount, isMember);
            TotalBillAmount = AddSalestax(TotalBillAmount);

            System.out.println("The total bill amount with salestax " + TotalBillAmount);
            System.out.println (" ");
            System.out.println ("===============NEW BOOKING======================= ");


            System.out.println("Do you want to continue? Yes/No");
            if (!scanner.nextLine().equalsIgnoreCase("Yes")) {
                scanner.close(); // Close once after loop ends      
                break; // Exit loop if user says No
            }
        }
    }


    public static int FindMoviePrice(int MovieName) {

        switch (MovieName) {
            case 1:
                return 12;
            case 2:
                return 15;
            case 3:
                return 10;
            case 4:
                return 12;
            default:
                System.out.println("Invalid Movie name");
                return 0;
        }
    }

    public static double CalculateBillAmount(int NumberofPeople, int MoviePrice) {
        return NumberofPeople * MoviePrice;
    }

    public static double AddDiscountBasedOnNumberOfPeople(double TotalBillAmount, int NumberofPeople) {
        if (NumberofPeople > 6) {
            return TotalBillAmount *= 0.9;
        }
        return TotalBillAmount;
    }

    public static double AddDiscountBasedOnMembership(double TotalBillAmount, boolean isMember) {
        if (isMember) {
            return TotalBillAmount *= 0.85;
        }
        return TotalBillAmount;
    }

    public static double AddSalestax(double TotalBillAmount) {
        return TotalBillAmount *= 1.09;
    }

}

// Test cases not written !!
