import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {
        String [] quotes = {"Those aren't the droids you're looking for.",
                "Never go in against a Sicilian when death is on the line!",
                "Goonies never say die.",
                "With great power, there must also come — great responsibility.",
                "Never argue with the data.",
                "Try not. Do, or do not. There is no try.",
                "You are a leaf on the wind, watch how you soar.",
                "Do absolutely nothing, and it will be everything that you thought it could be.",
                "Kneel before Zod.", "Make it so."};
        Random rand = new Random();
        int index = rand.nextInt(quotes.length);
        System.out.println(">Your Geek Fortune: " +quotes[index]);

    }
}
//    Write a program named FortuneCookie that randomly prints a quote to the screen.
//
//        Use the following list to inspire you, but can use your own favorite quotes,
//        as long as you include at least ten options to randomly choose between for your display.
//
//        "Those aren't the droids you're looking for." "Never go in against a Sicilian when " +
//        "death is on the line!" "Goonies never say die."
//        "With great power, there must also come — great responsibility."
//        "Never argue with the data." "Try not. Do, or do not." +
//        " There is no try." "You are a leaf on the wind, watch how you soar."
//        "Do absolutely nothing, and it will be everything that you thought it could be."
//        "Kneel before Zod." "Make it so."
//
//        The code and other output are up to you. Here are some examples of possible outcomes.
//
//        What You Should See (Example 1)
//        >Your Geek Fortune: Try not. Do, or do not. There is no try.
//        What You Should See (Example 2)
//        >Your Geek Fortune: Those aren't the droids you're looking for.