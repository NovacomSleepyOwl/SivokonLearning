package com.novacom.classes;
import java.util.ArrayList;

/**
 * Created by A.Sivakon on 24.01.2017.
 */
public class Parse {

    private String name;
    private String age;

    public String FindName(ArrayList<String> data) {
        String nm = "";

        for (int i = 0; i < data.size(); i++) {
            String dataString = data.get(i);
            char[] charString = dataString.toCharArray();
            char[] charName = new char[charString.length];
            char c = ' ';
            boolean flag = true;
            for(int x = 0; x < charString.length; x++){
                if(flag == true
                        && charString[x] == '<'
                        && charString[x+1] == 'n'
                        && charString[x+2] == 'a'
                        && charString[x+3] == 'm'
                        && charString[x+4] == 'e'
                        && charString[x+5] == '>'){

                    for(int k = x+6; charString[k] != '<'; k++){
                        c = charString[k];
                        charName[k] = c;
                    }
                    flag = false;
                }
            }
            for(int j = 0; j < charName.length; j++){
                nm += charName[j];
            }
        }
        setName(nm);


        return name;
    }


    public String FindAge(ArrayList<String> data) {
        String nm = "";

        for (int i = 0; i < data.size(); i++) {
            String dataString = data.get(i);
            char[] charString = dataString.toCharArray();
            char[] charName = new char[charString.length];
            char c = ' ';
            boolean flag = true;
            for(int x = 0; x < charString.length; x++){
                if(flag == true
                        && charString[x] == '<'
                        && charString[x+1] == 'a'
                        && charString[x+2] == 'g'
                        && charString[x+3] == 'e'
                        && charString[x+4] == '>'){

                    for(int k = x+5; charString[k] != '<'; k++){
                        c = charString[k];
                        charName[k] = c;
                    }
                    flag = false;
                }
            }
            for(int j = 0; j < charName.length; j++){
                nm += charName[j];
            }
        }
        setName(nm);


        return name;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
