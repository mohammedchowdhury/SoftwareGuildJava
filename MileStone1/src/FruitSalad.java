public class FruitSalad {
    public static void main(String[] args) {
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
        String[] fruitSalad;
        fruitSalad = new String[12];
        int fruitSaladIndex =0;
        int apples = 0,orange = 0;
        for(int a = 0;a<fruit.length; a++){
            if(fruit[a].contains("Tomato")==false){
                if(fruitSaladIndex==12){
                    break;
                }
                String tempFruit = fruit[a];
                if(tempFruit.contains("Apple")){
                    if(apples<3){
                        fruitSalad[fruitSaladIndex] = tempFruit;
                        fruitSaladIndex++;
                        apples++;
                    }
                    continue;
                }
                else if(tempFruit.contains("Orange")){
                    if(orange<2){
                        fruitSalad[fruitSaladIndex] = tempFruit;
                        fruitSaladIndex++;
                        orange++;
                    }
                    continue;
                }
                else{
                    fruitSalad[fruitSaladIndex] = tempFruit;
                    fruitSaladIndex++;
                }
            }
        }
        System.out.println("Fruit salad is ready!!!");
        for(int a=0 ; a<fruitSalad.length;a++){
            System.out.println(fruitSalad[a]+"  ");
        }
    }
}
//    As many berries as possible
//        No more than three kinds of apples
//        No more than two kinds of orange
//        Definitely no tomatoes
//        No more than twelve kinds of fruit