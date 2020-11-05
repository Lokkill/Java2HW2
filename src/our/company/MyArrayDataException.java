package our.company;

public class MyArrayDataException extends Exception{
    int countArr;
    int getCountArr(){ return countArr;}
    MyArrayDataException(String message, int countArr){
        super(message);
        this.countArr = countArr;

    }
}
