package org.example.hw2;

@SuppressWarnings("PMD.SystemPrintln")
public class MyArrayDataException extends RuntimeException {

    private final int row;
    private final int column;

    public MyArrayDataException(final int row, final int column, final Throwable throwable) {
        super(throwable);
        this.row = row;
        this.column = column;
    }

    @Override
    public void printStackTrace() {
        final String stringConsole = String.format("Ошибка приведения типов в ячейке [%d, %d]", row, column);
        System.out.println(stringConsole);
    }
}
