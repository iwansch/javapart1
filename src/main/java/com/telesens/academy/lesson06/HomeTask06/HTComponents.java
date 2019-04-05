package com.telesens.academy.lesson06.HomeTask06;

public class HTComponents {

    public static void main(String[] args) {

        Component[] components = new Component[10];
        Button button = new Button();
        Label label = new Label();
        RoundButton roundButton = new RoundButton();
        CheckBox checkBox = new CheckBox();
        components[0] = button;
        components[1] = button;
        components[2] = label;
        components[3] = label;
        components[4] = label;
        components[5] = roundButton;
        components[6] = roundButton;
        components[7] = checkBox;
        components[8] = checkBox;
        components[9] = checkBox;

        System.out.println("All components:");
        for (int i = 0; i < components.length; i++)
        components[i].draw();

        System.out.println();
        System.out.println("\"Button\" and its children:");
        for (int j = 0; j < components.length; j++)
            if (components[j] instanceof Button)
                components[j].draw();
    }
}
