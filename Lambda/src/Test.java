interface Executable {
    int execute();
}

class Runner {
    public void run(Executable e) {
        int a = e.execute();
        System.out.println(a);
    }
}
/*
class ExecutableImplementation implements Executable {

    @Override
    public void execute() {
        System.out.println("Hello");
    }
}

 */

public class Test {
    public static void main(String[] args) {
        Runner runner = new Runner();
        //три способа реализации интерфейса:

        /*
        runner.run(new ExecutableImplementation());   //1 - самый долгий, с реалзацией классов вверху
         */
        runner.run(new Executable() {          //2 - так мы уже делали, анонимный класс
            @Override
            public int execute() {
                return 1;
            }
        });

        final int a = 2;        //чтобы использовать это в лямбда, она должна быть финал
        runner.run(() -> 1 + a);          //3- самый локаничный варинат, лямбда

        //второй пример упрощения:
        /*
         runner.run(new Executable() {          //2 - так мы уже делали, анонимный класс
            @Override
            public int execute(int x) {

                return x+1;
            }
        });

        runner.run(x -> x+1);          //3- самый локаничный варинат, лямбда
         */
    }
}

