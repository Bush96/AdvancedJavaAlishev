import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsackProblem {
    public static void main(String[] args) {
        final Item item1 = new Item(4, 5);
        final Item item2 = new Item(3, 8);
        final Item item3 = new Item(2, 14);

        final Item[] items = {item1, item2, item3};  //Борщевой набор

        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());   //сортировка, reversed()) - обратная

        System.out.println(Arrays.toString(items));

        final int W = 7;       //размер корзины

        int weightSoFar = 0;   //для аккумуляции текущего веса
        double valueSoFar = 0;    //аккумуляция текущей ценности
        int currentItem = 0;      //Индекс текущего предмета

        while (currentItem < items.length && weightSoFar != W) {         //пока в рюкзаке есть место мы чтото делаем
            if (weightSoFar + items[currentItem].getWeight() < W) {        //если накопленный вес и вес очередного предмета меньше рюкзака, тогда:
                //береме обьект целиком
                valueSoFar += items[currentItem].getValue();
                weightSoFar += items[currentItem].getWeight();
            } else {
                //берем только часть
                valueSoFar += ((W - weightSoFar) / (double) items[currentItem].getWeight())
                        * items[currentItem].getValue();
                weightSoFar = W;   //на этом этапе рюкзак юудет полным
            }
            currentItem++;
        }
        System.out.println("Ценность найлучшего набора: " + valueSoFar);
    }
}

class Item {
    private int weight;
    private int value;

    public double valuePerUnitOfWeight() {
        return value / (double) weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "weight=" + weight +
                ", value=" + value +
                '}';
    }
}
