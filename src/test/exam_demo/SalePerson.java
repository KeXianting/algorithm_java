package test.exam_demo;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2017/11/12.
 */
public class SalePerson {
    public static void main(String[] args) throws IOException{

        Scanner input = new Scanner( System.in );
        // sales array holds data on number of each product sold
        // by each salesman
        double[][] sales = new double[ 5 ][ 4 ];

        System.out.print( "Enter sales person number (-1 to end): " );
        int person = input.nextInt();

        while ( person != -1 )
        {
            System.out.print( "Enter product number: " );
            int product = input.nextInt();
            System.out.print( "Enter sales amount: " );
            double amount = input.nextDouble();

            // error-check the input
            if ( person >= 1 && person < 5 &&
                    product >= 1 && product < 6 && amount >= 0 )
                sales[ product - 1 ][ person - 1 ] += amount;
            else
                System.out.println( "Invalid input!" );

            System.out.print( "Enter sales person number (-1 to end): " );
            person = input.nextInt();
        } // end while

        // total for each salesperson
        double salesPersonTotal[] = new double[ 5 ];

        // display the table
        for ( int column = 0; column < 4; column++ )
            salesPersonTotal[ column ] = 0;

        System.out.printf( "%7s%14s%14s%14s%14s%10s\n",
                "Product", "Salesperson 1", "Salesperson 2",
                "Salesperson 3", "Salesperson 4", "Total" );


        for ( int row = 0; row < 5; row++ )
        {
            double productTotal = 0.0;
            System.out.printf( "%7d", ( row + 1 ) );

            for ( int column = 0; column < 4; column++ ) {
                System.out.printf( "%14.2f", sales[ row ][ column ] );
                productTotal += sales[ row ][ column ];
                salesPersonTotal[ column ] += sales[ row ][ column ];
            }

            System.out.printf( "%10.2f\n", productTotal );
        }

        System.out.printf( "%7s", "Total" );

        for ( int column = 0; column < 4; column++ )
            System.out.printf( "%14.2f", salesPersonTotal[ column ] );

        System.out.println();
    }
}


/*
Enter sales person number (-1 to end): 1
Enter product number: 4
Enter sales amount: 1082
Enter sales person number (-1 to end): 2
Enter product number: 3
Enter sales amount: 998
Enter sales person number (-1 to end): 3
Enter product number: 1
Enter sales amount: 678
Enter sales person number (-1 to end): 4
Enter product number: 1
Enter sales amount: 1554
Enter sales person number (-1 to end): -1
Product Salesperson 1 Salesperson 2 Salesperson 3 Salesperson 4     Total
      1          0.00          0.00        678.00       1554.00   2232.00
      2          0.00          0.00          0.00          0.00      0.00
      3          0.00        998.00          0.00          0.00    998.00
      4       1082.00          0.00          0.00          0.00   1082.00
      5          0.00          0.00          0.00          0.00      0.00
  Total       1082.00        998.00        678.00       1554.00


 */