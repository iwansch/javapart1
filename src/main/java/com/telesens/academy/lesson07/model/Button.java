package com.telesens.academy.lesson07.model;

public class Button extends Component {

    @Override
    public void draw() {
        System.out.println("Button");

        //super.draw();
    }

    @Override
    public void draw3D() {
        System.out.println("Button 3D");

        //super.draw3D();
    }
}
