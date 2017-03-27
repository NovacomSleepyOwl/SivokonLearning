package com.novacom.mouse.classes;

/**
 * Created by A.Sivakon on 10.02.2017.
 */
public class WheelButton extends Button{

    private int value;

    public WheelButton(){
        setDefinition(ButtonDefinitions.CENTER_BUTTON);
        this.value = 0;
    }

    public void DoRollUp(){
        if(value == 5){
            value = 0;
        }
        else value++;
    }

    public void DoRollDown(){
        if(value == 0){
            value = 5;
        }
        else value--;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
