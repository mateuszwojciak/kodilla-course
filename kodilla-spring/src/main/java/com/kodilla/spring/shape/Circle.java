package com.kodilla.spring.shape;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") //Ctrl + Space -> wywołanie opcji do wyboru dla Scope
public class Circle implements Shape {

    @Override
    public String getShapeName() {
        return "This is a circle.";
    }
}
