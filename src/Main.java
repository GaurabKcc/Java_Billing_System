// USER ID: USER
// PASSWORD: 1111

import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> my_list = new ArrayList<>();
        ArrayList<Double> my_price = new ArrayList<>();
        double total = 0.0;

        System.out.println("Enter User ID");

        while (true) {
            String userID = sc.nextLine();
            if (userID.equalsIgnoreCase("Quit")) {
                System.exit(0);
            }
            if (!userID.equalsIgnoreCase("User")) {
                System.out.println("Wrong ID");
            }
            if (userID.equalsIgnoreCase("User")) {
                System.out.println("Enter Password");
                break;
            }
        }

        while (true) {
            String password = sc.nextLine();
            if (password.equalsIgnoreCase("Quit")) {
                System.exit(0);
            }
            if (!password.equalsIgnoreCase("1111")) {
                System.out.println("Wrong Password");
            }
            if (password.equalsIgnoreCase("1111")) {
                System.out.println("Enter Items (Type 'Stop' if you are done.)");
                break;
            }
        }

        while (true) {
            String items = sc.nextLine();
            if (items.equalsIgnoreCase("Quit")) {
                System.exit(0);
            }
            if (items.equalsIgnoreCase("Stop")) {
                System.out.println("Enter Price");
                break;
            }
            else{
                my_list.add(items);
                continue;
            }
        }

        while (true) {
            for (int i = 0; i < my_list.size(); i++) {
                String price = sc.nextLine();
                if (price.equalsIgnoreCase("Quit")) {
                    System.exit(0);
                }
                my_price.add(Double.parseDouble(price));
            }
            System.out.println("Charge VAT? (Yes/No)");
            break;
        }

        while (true) {
            String VAT_ans = sc.nextLine();
            if (VAT_ans.equalsIgnoreCase("Quit")) {
                System.exit(0);
            }
            if (VAT_ans.equalsIgnoreCase("Yes")) {
                for (int i = 0; i < my_price.size(); i++) {
                    double Init_price = my_price.get(i);
                    double VAT = Init_price + (Init_price*0.13);
                    my_price.set(i,(VAT));

                }
            }
            else if (VAT_ans.equalsIgnoreCase("No")) {
                System.out.println("No VAT Charged.");;}

            System.out.println("Enter Discount Percentage");
            break;

        }

        while (true) {
            String dis_per = sc.nextLine();
            if (dis_per.equalsIgnoreCase("Quit")) {
                System.exit(0);
            }
            else {
                for (int i = 0; i < my_price.size(); i++) {
                    double Before_Dis = my_price.get(i);
                    double Discount = Before_Dis * (1-Double.parseDouble(dis_per)/100.0);
                    my_price.set(i,(Discount));
                }
                for (Double i: my_price){
                    total += i;
                }
                System.out.println("Your total sum is "+total);
                System.out.println("Enter Your Payment Amount");
                break;
            }
        }
        
        int highestDenomination = 0;

        while (true) {
            String pay = sc.nextLine();
            Double user_change = Double.parseDouble(pay) - total;
            
            int[] my_deno = {1000,500,100,50,20,10,5};
            for (int i = 0; i < my_deno.length; i++) {
                if (user_change>= my_deno[i]) {
                    highestDenomination = my_deno[i];
                    break;
                }
            }
            System.out.println("Your Change is: " + user_change);
            System.out.println("Highest denomination is "+ highestDenomination +"x"+ (int) (user_change/highestDenomination));
            break;
        }

        


    }

}






