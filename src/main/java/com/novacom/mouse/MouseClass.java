package com.novacom.mouse;

import com.novacom.mouse.classes.Button;
import com.novacom.mouse.classes.ButtonDefinitions;
import com.novacom.mouse.classes.WheelButton;

/**
 * Created by A.Sivakon on 07.02.2017.
 */
public class MouseClass {

    private int pointColumn;
    private int pointRow;

    public MouseClass(){
        this.pointColumn = 2;
        this.pointRow = 2;
        Button leftButton = new Button(ButtonDefinitions.LEFT_BUTTON);
        Button rightButton = new Button(ButtonDefinitions.RIGHT_BUTTON);
        WheelButton wheel = new WheelButton();

    }

    public void MoveUp(){
        if(pointRow == 4){
            pointRow = 0;
        }
        else pointRow--;
    }

    public void MoveDown(){
        if(pointRow == 0){
            pointRow = 4;
        }
        else pointRow++;
    }

    public void MoveLeft(){
        if(pointColumn == 0){
            pointColumn = 4;
        }
        else pointColumn--;
    }

    public void MoveRigth(){
        if(pointColumn == 4){
            pointColumn = 0;
        }
        else pointColumn++;
    }

    public int getPointRow() {
        return pointRow;
    }

    public void setPointRow(int pointRow) {
        this.pointRow = pointRow;
    }



    public int getPointColumn() {
        return pointColumn;
    }

    public void setPointColumn(int pointColumn) {
        this.pointColumn = pointColumn;
    }


}
