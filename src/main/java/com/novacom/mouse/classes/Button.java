package com.novacom.mouse.classes;

import com.novacom.mouse.interfaces.IButton;

/**
 * Created by A.Sivakon on 10.02.2017.
 */
public class Button implements IButton {



    protected ButtonDefinitions definition;

    public Button(ButtonDefinitions def){
        this.definition = def;
    }
    protected Button(){} //!

    public void click() {
        System.out.println("Click");
    }

    public ButtonDefinitions getDefenition() {
        return definition;
    }
    protected void setDefinition(ButtonDefinitions definition) {
        this.definition = definition;
    }

}
