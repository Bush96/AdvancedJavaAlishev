import org.w3c.dom.Node;

import java.util.Arrays;

public class MyLinkedList {
    private Node head;
    private int size;

    public void add(int value) {
        //если первое добавление в список :
        if (head == null) {
            this.head = new Node(value);    //создаем узел и подаем в него чтото
        } else {
            Node temp = head;      //создаем временную ссылку для хранения последующих элементов

            while (temp.getNext() != null) {   //таким образом эта временная ссылка будет принмать новые значение и двигаться вместе с ними
                temp = temp.getNext();         //и выйдем мы из этого узла только на последнем подавленном элементе
            }

            temp.setNext(new Node(value));

        }
        size++;
    }

    public String toString() {
        int[] result = new int[size];    //создаем массив в котором хранится информация каждой ячейки массива

        int idx = 0;  //тут будет хранится каждая ячейка
        Node temp = head;   //снова обявляем ссылочную переменную которая служит каждый раз следующим узлом в вычислениях

        while (temp != null) {
            result[idx] = temp.getValue();   //цикл дает ссылке темп следующее звено, та принимает значение и записывает его в массив для их храниния
            temp = temp.getNext();
            idx++;
        }
        return Arrays.toString(result);     //возвращаем все что кинули в массив
    }

    public int get(int index) {
        int currentIndex = 0;   //создаем переменную хранящую номер нынешнего звена
        Node temp = head;    //снова создаем переменную которая принимает значение следующего звена

        while (temp != null) {
            if (currentIndex == index) {        //если запрашиваемый номер совпадает с тем на котором сейас мы находимся
                return temp.getValue();    //мы нашил то нужно и цикл прекращается
            } else {
                temp = temp.getNext();   //если не нашли - ищем дальше
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();   //надо выбрасить исклчение
    }

    public void remove(int index) {

        int currentIndex = 0;
        Node temp = head;

        if (index == 0) {                 //этот блок нужен только для удаления первого элемента массива
            head = head.getNext();
            size--;
            return;
        }

        while (temp != null) {          //этот для остальных
            if (currentIndex == index - 1) {
                temp.setNext(temp.getNext().getNext());    //temp.setNext(temp.getNext().getNext()); - пропускаем зввено что нужно далить переопредел ссылку с него на следующий элемент
                size--;    //обязательно
                return;
                //((currentIndex== index-1) - чтобы удалить элемент мы должны находится на звене до нужного, потому синтаксисс таков
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        size--;    //обязательно
    }


    private static class Node {
        private int value;         //знаение хранящееся в текущем узле
        private Node next;        //ссылка на следующий узел

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
