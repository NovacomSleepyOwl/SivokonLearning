package com.novacom.mouse.classes;

/**
 * Created by A.Sivakon on 10.02.2017.
 */
public class Table {

    private int mouseCol;
    private int mouseRow;
    private char[][] pointMap = new char[5][5];

    public Table(int row, int col){
        this.mouseRow = row;
        this.mouseCol = col;

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                pointMap[i][j] = '-';
            }
        }

        pointMap[mouseRow][mouseCol] = '+';

    }

    public void RecalculateMap(int row, int col){
        this.mouseRow = row;
        this.mouseCol = col;

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                pointMap[i][j] = '-';
            }
        }
        pointMap[mouseRow][mouseCol] = '+';
    }

    public void DrawTable(int row, int col){
        RecalculateMap(row, col);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
               System.out.print(pointMap[i][j]);
            }
            System.out.print("\n");
        }
    }


    public int getMouseCol() {
        return mouseCol;
    }

/*
    public void setMouseCol(int mouseCol) {
        this.mouseCol = mouseCol;
    }
*/

    public int getMouseRow() {
        return mouseRow;
    }

/*
    public void setMouseRow(int mouseRow) {
        this.mouseRow = mouseRow;
    }
*/



}