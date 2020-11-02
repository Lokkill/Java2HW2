package our.company;

public class Main {
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
    }

    public static void countArrayValues(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int lengthArr = arr[0].length * arr.length;
        int countArr = 0;
        if (lengthArr == 16){
            for (int i = 0; i < arr.length; i++){
                for (int j = 0; j < arr[i].length; j++){
                    try {
                    countArr += Integer.parseInt(arr[i][j]);
                    }catch (Exception ex){
                        throw new MyArrayDataException("Не удалось преобразовать строку в число по индексам: [" + i + ":" + j + "]", countArr);
                    }
                }
            }
        } else {
            throw new MyArraySizeException("Общий размер массива не равен 16");
        }
    }
}
