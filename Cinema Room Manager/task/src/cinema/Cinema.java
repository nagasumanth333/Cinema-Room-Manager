package cinema;

import java.util.Scanner;

public class Cinema {


    public static String[][] arr = new String[10][10];
    static int count=0;
    static int currentIncome=0;
    static int totalIncome=0;

    public static void initialise(int r, int c){
        for (int i = 1; i <= r; i++) {

            for (int j = 1; j <=c; j++) {
                Cinema.arr[i][j]="S";
            }


        }
    }

    public static void display(int r, int c) {




        System.out.println("Cinema:");

        System.out.print("  ");
        for (int i = 1; i <=c; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= r; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <=c; j++) {

                    System.out.print(Cinema.arr[i][j]+ " ");
                }
            System.out.println();
            }


        }

    public static void findIncome(int r, int c){
        int total=0;
         int n1=0;
        int n2=0;

        if((r*c)<60) {
            total =10*r*c;
        } else if ((r*c)>60){

            if(r%2==0){
                n1=10*(r/2)*c;
                n2=8*(r/2)*c;
            }else {
                n1=((r-1)/2)*10*c;
                n2=((r+1)/2)*8*c;
            }

            total= n1+n2;
        }
       // System.out.println("total income:");
       // System.out.println("$"+ total);
        totalIncome=total;

    }

    public static void tPrice(int r, int c, int row, int col) {



        int price = 8;
        if ((r * c) < 60) {
            price = 10;
        } else if ((r * c) > 60) {

            if (r % 2 == 0) {
                for (int i = 1; i <= (r / 2); i++) {
                    if (i == row) {
                        price = 10;
                    }
                }
            } else if (r % 2 != 0) {
                for (int i = 1; i <= ((r - 1) / 2); i++) {
                    if (i == row) {
                        price = 10;
                    }

                }
            }
        }
        System.out.println("Ticket Price: $" +price);
        currentIncome+=price;
    }

    public static void editMatrix(int r, int c, int row, int col){




        System.out.println("Cinema:");

        System.out.print("  ");
        for (int i = 1; i <=c; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= r; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <=c; j++) {
                if(i==row && j==col){
                    System.out.print("B ");

                }else
                System.out.print("S" + " ");
            }
            System.out.println();

        }

    }

    public static void tester(int r, int c, int row, int col){


        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <=c; j++) {
                if(i==row && j==col){
                    Cinema.arr[i][j]="B";

                }

            }

        }
        System.out.println("Cinema:");

        System.out.print("  ");
        for (int i = 1; i <=c; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= r; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <=c; j++) {
                if(i==row && j==col){
                    System.out.print(Cinema.arr[i][j]+ " ");
                }else
                    System.out.print(Cinema.arr[i][j]+ " ");
            }
            System.out.println();

        }




    }
    public static void temp(int r, int c, int row, int col){
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <=c; j++) {
                if(i==row && j==col){
                    Cinema.arr[i][j]="B";

                }

            }

        }
    }

    public static void statistics(float r, float c){

        System.out.println("Number of purchased tickets: "+ count);
        float percentage= (float)(count/(r*c))*100;
        System.out.printf("Percentage: %.2f%c", percentage,'%');
        System.out.println();

        System.out.println("Current income: $" +currentIncome);
        System.out.println("Total income: $" +totalIncome);




    }
    public static boolean checkAvailable(int r, int c, int row, int col){
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <=c; j++) {
                if(i==row && j==col){
                    if("B".equals(Cinema.arr[i][j])) {
                        System.out.println("That ticket has already been purchased!");
                        return false;

                    }



                }

            }

        }
           return true;
    }


    public static void main(String[] args) {
        // Write your code here


        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int r= sc.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int c= sc.nextInt();
        initialise(r,c);

        findIncome(r,c);

        int row=0;
        int col=0;
        int flag=10;

        while(flag!=0) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n"+
                    "0. Exit");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    if(row==0 && col==0)
                    display(r,c);
                    else {

                        tester(r, c, row, col);
                    }
                    break;
                case 2:
                    int flag1=0;
                    boolean b1=false;
                    while(flag1==0) {
                        System.out.println("Enter a row number:");

                        row = sc.nextInt();

                        System.out.println("Enter a seat number in that row:");
                        col = sc.nextInt();

                        b1=checkAvailable(r,c,row,col);
                        if ((row < 0 || row > 9) || (col < 0 || col > 9))
                            System.out.println("Wrong Input!");
                        else if(!b1)
                            continue;
                        else
                            flag1 = 1;
                    }
                    tPrice(r,c, row, col);
                    temp(r,c,row,col);
                    count++;
                    break;
                case 3:
                    statistics(r,c);
                    break;
                case 0:
                    flag=0;
                    break;
                default:
                    System.out.println("Enter a correct number");

            }
        }

       //  display(r,c);


      // tPrice(r,c, row, col);

       // editMatrix(r,c);







    }
}