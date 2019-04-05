package com.telesens.academy.lesson07;

import com.telesens.academy.lesson07.model.Button;
import com.telesens.academy.lesson07.model.Component;
import com.telesens.academy.lesson07.model.Label;
import com.telesens.academy.lesson07.model.VisualComponent;

public class HT1 {

    public static void main(String[] args) {

        VisualComponent[] vComponents = new VisualComponent[]{

                new Button(),
                new Label(),
                new Component(),
                new VisualComponent() {
                    @Override
                    public void draw() {
                        System.out.println("Anonymous component");
                    }

                    @Override
                    public void draw3D() {

                    }
                }
        };

        for (VisualComponent element : vComponents)
            element.draw();
        for (VisualComponent element : vComponents)
            element.draw3D();
    }
}

