package our.company;

import java.util.Arrays;

public class Main {
    /*3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException, и вывести результат расчета.*/
    public static void main(String[] args) {
        String[][] arr2 = {{"1", "2"},{"1","2","3", "4"}};
        String[][] arr = {{"1","2","3","4"}, {"5","6","7","8"}, {"nine","10","11"," "}, {"13","14","15","16"}};
        try {
            countArrayValues(arr);
        } catch (MyArrayDataException ex){
            ex.printStackTrace();
            System.out.println("Просчитанная сумма элементов массива равна: " + ex.getCountArr());
        } catch (MyArraySizeException e){
            e.printStackTrace();
        }


        int[][] spiralArr = spiralOutput(new int[5][5]);
        int multiSize = spiralArr[0].length * spiralArr.length;
        for (int i = 0; i < spiralArr.length; i++){
            for (int j = 0; j < spiralArr[i].length; j++){
                System.out.printf("%0" + (multiSize + "").length() +"d ", spiralArr[i][j]);
            }
            System.out.println();
        }
    }

    /*1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
    при подаче массива другого размера необходимо бросить исключение MyArraySizeException.*/
    public static void countArrayValues(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int lengthArr = arr[0].length * arr.length;
        int countArr = 0;
        if (lengthArr == 16){
            for (int i = 0; i < arr.length; i++){
                for (int j = 0; j < arr[i].length; j++){
                    try {
                    countArr += Integer.parseInt(arr[i][j]);
                    }catch (Exception ex){

                        /*2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
                        Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
                        должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.*/
                        throw new MyArrayDataException("Не удалось преобразовать строку в число по индексам: [" + i + ":" + j + "]", countArr);
                    }
                }
            }
        } else {
            throw new MyArraySizeException("Общий размер массива не равен 16");
        }
    }
    /*Дополнительное задание для практики:
    Требуется написать метод, принимающий на вход размеры двумерного массива и выводящий массив в виде инкременированной цепочки чисел, идущих по спирали против часовой стрелки.*/
    public static int[][] spiralOutput(int[][] arr){
        int x = 0;
        int y = 0;
        int value = 1;
        int multiSize = arr[0].length * arr.length;
        int maxColumn = arr[0].length - 1;
        int maxRow = arr.length - 1;
        int rowSide = 0;
        int columnSide = 0;

        while (true){
            if (maxRow == rowSide && maxColumn == columnSide || value >= multiSize){
                if (arr[x][y] == 0){
                    arr[x][y] = value;
                    return arr;
                }
                return arr;
            }
            for (;x < maxRow; x++){
                if (value <= multiSize){
                    arr[x][y] = value;
                    value++;
                } else {
                    return arr;
                }
            }
            for (; y < maxColumn; y++){
                if (value <= multiSize){
                    arr[x][y] = value;
                    value++;
                } else {
                    return arr;
                }
            }
            for (; x - 1 >= rowSide; x--){
                if (value <= multiSize){
                    arr[x][y] = value;
                    value++;
                } else {
                    return arr;
                }
            }
            for (; y - 1 >= columnSide; y--){
                if (value <= multiSize){
                    arr[x][y] = value;
                    value++;
                } else {
                    return arr;
                }
            }
            columnSide++;
            rowSide++;
            maxRow--;
            maxColumn--;
            x = rowSide;
            y = columnSide;

        }

    }
}
