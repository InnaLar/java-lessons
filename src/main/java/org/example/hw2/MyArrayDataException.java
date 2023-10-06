package org.example.hw2;

public class MyArrayDataException extends ClassCastException{
    private final int row;
    private final int column;
    public MyArrayDataException(int row, int column){
        this.row = row;
        this.column = column;
    }
    @Override
    public void printStackTrace(){
        String stringConsole = String.format("Ошибка приведения типов в ячейке [%d, %d]",row, column);
        System.out.println(stringConsole);
    }
}
