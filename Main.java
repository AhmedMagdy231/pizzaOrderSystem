package com.company;
import  java.util.Scanner;
public class Main {
    public static String[] Order=new String[10];
    public static int[] Order_amount=new int[10];
    public static int count=0;
    public static double price=0;


    public  static  String Name="User";
    // name of pizza
   public static String[] nameOfPizza={
            "KFC CHICKEN PIZZA",
            "SUPER SUPREME    ",
            "MARGHERITA       ",
            "SEA FOOD LOVERS  ",
            "HOT N SPICY      ",
            "CLASSIC PEPPERONI",
            "CHEESE LOVERS    ",
            "PRAWN            ",
    };
    //price of pizza small size
    public static  double[]  price_small_pizza={
            66.00,
            60.9,
            34.5,
            78.5,
            49.0,
            49.0,
            74.5,
            74.5,
    };
    //price of pizza Medium size
    public static  double[] price_Medium_Pizza={
            102.0,
            92.55,
            64.55,
            114.5,
            78.55,
            78.55,
            107.0,
            107.0,
    };
    //price of pizza Big size
    public static  double[] price_Big_Pizza={
            137.00,
            122.00,
            122.00,
            122.00,
            122.00,
            122.00,
            122.00,
            122.00,
    };

    ////////////////////////////////////////////////////////////////function That Display List Of Prices/////////////////////////////////////////////////
    public  static void List_Prices(){

        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("                                     LIST PRICE OF PIZZA ");
        System.out.println("_________________________________________________________________________________________________"); //20  11  14  11
        System.out.println("|                    |                  |                   |                |                  |");
        System.out.println("|     Name(PIZZA)    |   Price(Small)   |   Price(Medium)   |   Price(Big)   |  Code Of Pizza   |");
        System.out.println("|____________________|__________________|___________________|________________|__________________|");
        for(int i=0;i<nameOfPizza.length;i++)
        {
            System.out.printf("|%21s",nameOfPizza[i]+" |");
            for(int j=0;j<3;j++)
            {
                if(j==0)
                System.out.printf("    "+price_small_pizza[i]+" EGP      |");
                else if(j==1)
                    System.out.printf("    "+price_Medium_Pizza[i]+" EGP      |");
                else if(j==2)
                    System.out.printf("   "+price_Big_Pizza[i]+" EGP    |         "+(i+1)+"        |");


            }
            System.out.println();
            System.out.println("|____________________|__________________|___________________|________________|__________________|");//20  11  14  11


        }
        System.out.println("\n-------------------------------------------------------------------------------------------------");

    }
    ////////////////////////////////////////////////////////////////Function Place Order////////////////////////////////////////////////
    public  static  void Place_Order()
    {
        Scanner input =new Scanner(System.in);
        System.out.println("\n-------------------------------------------------------------------------------------------------");
        for(int i=0; i<nameOfPizza.length;i++)
        {
            System.out.println(i+1+". "+nameOfPizza[i]);
        }
        System.out.println("-------------------------------------------------------------------------------------------------\n");

        boolean wrong;
        String answer;
        String ans;
        int Size;
        String Size_of_Pizza;
        int amount;
        do {
            do {
                System.out.print("PLease Enter Number Of Pizza That You Want To Order : ");
                answer = input.next();
                if (!((int) answer.charAt(0) > 48 && (int) answer.charAt(0) < 57 && answer.length() < 2)) {
                    System.out.println("|* Your Input is not Valid Please Enter Number From (1 To 8) *|");
                    wrong = true;

                } else {
                    wrong = false;
                }

            } while (wrong);

            int index = Integer.parseInt(answer);
            System.out.println("You Choose Number (" + index + ". " + nameOfPizza[index - 1] + ")");
            do {
                System.out.print("What Do You Want Size Of Pizza (1.Small  2.Medium  3.Big) : ");
                answer = input.next();
                if (!((int) answer.charAt(0) > 48 && (int) answer.charAt(0) < 52 && answer.length() < 2)) {
                    System.out.println("|* Your Input is not Valid Please Input Number From (1,2,3) *|");
                    wrong = true;


                } else {

                    wrong = false;

                }
            }while (wrong);
            Size=Integer.parseInt(answer);
            do {
                System.out.print("Please Enter The Number How Many Pizza Do You Want MAX is(10) : ");
                amount = input.nextInt();
                if (amount>10) {
                    System.out.println("|* Your Input is not Valid Max amount you can Enter is 10 *|");
                    wrong = true;

                } else {
                    wrong = false;
                }
            }while (wrong);

            if(Size==1) {
                Size_of_Pizza = "Small";
                price+=price_small_pizza[index-1]*(1.0*amount);
            }
            else if(Size==2) {
                Size_of_Pizza = "Medium";
                price+=price_Medium_Pizza[index-1]*(1.0*amount);
            }
            else {
                Size_of_Pizza = "Big";
                price+=price_Big_Pizza[index-1]*(1.0*amount);

            }
            Add_To_List(nameOfPizza[index-1],Size,amount,Size_of_Pizza);




            System.out.print("Do You Want to Order Some Thing Else (Y/N) : ");
            ans=input.next();
        }while (ans.equals("Y") || ans.equals("y"));

    }
    /////////////////////////////////////////////////function That Add Order To List////////////////////////////////////////////////////////////
    public  static void  Add_To_List(String name,int Size,int amount,String Size_Pizza)
    {
        String Acual=name+"--> "+Size_Pizza;
        //String amount=String.valueOf(a);
        if(count==0)
        {
            Order[count++]=name+"--> "+Size_Pizza;
            Order_amount[count-1]=amount;
        }
        else {
            boolean fount =false;
            for(int i=0;i<Order.length;i++)
            {
                if(Acual.equals(Order[i]))
                {
                    Order_amount[i]+=amount;
                    fount=true;
                    break;
                }

            }
            if(!fount)
            {
                Order[count++]=name+"--> "+Size_Pizza;
                Order_amount[count-1]=amount;

            }
        }
    }
    ////////////////////////////////////////////////////////////////Function Display Receipt////////////////////////////////////////////////

public static void  Display_Receipt()
{
    System.out.println("\n-------------------------------------------------------------------------------------------------");

    for(int i=0; i< count;i++)
    {
        System.out.println("You Order "+ Order_amount[i]+" "+Order[i]);
        System.out.println("----------------------------------------------------");

    }
    System.out.println("\nYour Total Price is ("+price+" EGP)\n");
    System.out.println("-----------------------------------------------------------------------------");

}



    public static void main(String[] args){
        String continuee;
        String ans;
        int answer;

        Main ahmed=new Main();
        Scanner input =new Scanner(System.in);
        System.out.printf("%120s","------- WELCOME TO OUR PIZZA ONLINE STORE -------");
        System.out.print("\n Please First Enter Your Name : ");
        Name=input.next();
        do{
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("What Do You Want "+Name);
            System.out.println("1. List Prices");
            System.out.println("2. Place Order");
            System.out.println("3. Display Receipt");
            System.out.println("4. Quit\n");
            boolean wrong;
            do {

                System.out.print("Please Enter number from 1 to 4 : ");
                ans=input.next();
                if(!((int)ans.charAt(0)>48 && (int)ans.charAt(0)<53))
                {
                    System.out.println("|* Your Input is not Valid Please Enter Number From (1,2,3,4) *|");
                    wrong=true;

                }
                else
                {
                    if(ans.length()>=2)
                    {
                        System.out.println("|* Your Input is not Valid Please Enter Number From (1,2,3,4) *|");
                        wrong=true;

                    }
                    else
                    wrong=false;
                }
            }while (wrong);
            //     if User Choose number 1
            answer= Integer.parseInt(String.valueOf(ans.charAt(0)));
            if(answer==1)
            {
                List_Prices();

            }
            else if(answer==2)
            {
                Place_Order();
            }
            else if(answer==3)
            {
                Display_Receipt();

            }
            else {
                System.exit(0);
            }

            do {
                System.out.print("Do You Want Back To Main Menu(Y/N) : ");
                continuee=input.next();
                if(continuee.equals("Y") || continuee.equals("y") || continuee.equals("N") || continuee.equals("n"))
                {
                    wrong=false;
                }
                else {
                    wrong =true;
                    System.out.println("Please Enter Write Value From(Y|N)");
                }

            }while (wrong);

        }while (continuee.equals("Y") || continuee.equals("y"));

    }
}


































