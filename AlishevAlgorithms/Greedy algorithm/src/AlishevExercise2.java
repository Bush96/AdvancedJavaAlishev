public class AlishevExercise2 {
    //нужно вычислить оптимальное количество остановок для прохода расстояния
    public static void main(String[] args) {
        int[] stations = {0, 200, 375, 550, 750, 950};           //заправки
        System.out.println(minStops(stations, 400));     //capacity - запас хода
    }

    public static int minStops(int[] stations, int capacity) {
        int result = 0;  //оптимальное колчество остановок
        int currentStop = 0;   //место нынешней остановки

        while (currentStop < stations.length - 1) {               //мы будем в цикле пока нынешнее положение не дойдет до последней остановки
            int nextStop = currentStop;

            while (nextStop < stations.length - 1 &&                       //проверяем можем ли мы доехать до следующей заправки (сперва делаем так чтобы не выйти за размер массива
                    stations[nextStop + 1] - stations[currentStop] <= capacity) {    // потом проверяем (к примеру переходя с 0 на 200) этим полем stations[nextStop + 1] - stations[currentStop] <= capacity)
                                                                          //что расстояние между заправками меньше 400км
                nextStop++;

                if (currentStop == nextStop)
                    //return -1 if its impossible to get from A to B
                    return -1;

                if (nextStop < stations.length - 1) {
                    result++;

                    currentStop = nextStop;
                }
            }
        }
        return result;
    }
}



