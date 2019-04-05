package com.telesens.academy.lesson07.model;

import java.sql.SQLOutput;

public class Component implements VisualComponent {

    public void draw() {
        System.out.println("Component");
    }
    public void draw3D() {
        System.out.println("Component 3D");
    }

}

