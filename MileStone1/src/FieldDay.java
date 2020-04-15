import java.util.Scanner;

public class FieldDay {
    public static void main(String[] args) {
        String a = "D";
        String team = "";
        String name = getUserInputString("What's your last name? :");

        if("Baggins".compareTo(name)>=0){
            team = "Red Dragons";
            System.out.println(team);
        }else if("Baggins".compareTo(name)<0 && "Dresden".compareTo(name)>0){
            team = "Dark Wizards";
            System.out.println(team);
        }
        else if("Dresden".compareTo(name)<0 && "Howl".compareTo(name)>0){
            team = "Moving Castles";
            System.out.println(team);
        }
        else if("Howl".compareTo(name)<0 && "Potter".compareTo(name)>0){
            team = "Golden Snitches";
            System.out.println(team);
        }
        else if("Potter".compareTo(name)<0 && "Vimes".compareTo(name)>0){
            team = "Night Guards";
            System.out.println(team);
        }
        else if("Vimes".compareTo(name)<0){
            team =  "Black Holes";
            System.out.println(team);
        }


        System.out.println("Aha! You're on the team "+team +"! \nGood luck in the games!");
    }

    public static String getUserInputString(String message) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        String ans = "";
        do {
            try {
                System.out.print(message);
                String input = myScanner.nextLine();// getting a user String
                input = input.toUpperCase();
                if (input.isBlank()==false && input.isEmpty()==false) {
                    ans = input;
                    isValid = true;
                    break;
                }
            } catch (NullPointerException ex) {
                System.out.println("That was not a String!  " + ex);
                // ex.printStackTrace();
            }

        } while (isValid == false);
        return ans;
    }
}
