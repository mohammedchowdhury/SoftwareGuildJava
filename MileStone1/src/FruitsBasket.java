public class FruitsBasket {
    public static void main(String[] args) {
        String[] fruitBasket = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple",
                "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange",
                "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple",
                "Orange", "Orange", "Apple", "Apple", "Apple", "Banana", "Apple", "Orange",
                "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple",
                "Apple", "Apple", "Apple", "Orange", "Orange", "PawPaw", "Apple", "Orange",
                "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange",
                "Apple", "Orange", "Apple", "Kiwi", "Orange", "Apple", "Orange",
                "Dragonfruit", "Apple", "Orange", "Orange"};

        int numOranges = 0;
        int numApples = 0;
        int numOtherFruit = 0;

        // Fruit counting code goes here!

        for(int a=0; a<fruitBasket.length; a++){
            if(fruitBasket[a].equals("Apple")){
                numApples++;
            }else if(fruitBasket[a].equals("Orange")){
                numOranges++;
            }
            else{
                numOtherFruit++;
            }
        }

        // Print The Results!
            System.out.println("Total# of Fruit in Basket: "+fruitBasket.length);
        System.out.println("Number of Apples: "+numApples+"\n"+
        "Number of Oranges: "+numOranges+"\n"+
        "Number of Other Fruit: "+numOtherFruit);
    }
}
