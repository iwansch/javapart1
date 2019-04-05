package com.telesens.academy.lesson07;

import com.telesens.academy.lesson07.model.Button;
import com.telesens.academy.lesson07.model.Component;
import com.telesens.academy.lesson07.model.Label;

public class ComponentDemo {
    public static void main(String[] args) {

        Component btn = new Button();
        btn.draw();

        System.out.println("***components***");
        Component[] components = new Component[] {
                new Label(),
                new Button(),
                new Label(),
                new Button(),
        };

        for (int i = 0; i < components.length; i++){
            if (components[i] instanceof Component)
            components[i].draw();
        }
    }
}
