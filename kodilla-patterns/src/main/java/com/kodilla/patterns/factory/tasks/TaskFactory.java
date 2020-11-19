package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task executeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Zakup", "bluza", 4);
            case PAINTING:
                return new PaintingTask("Malowanie", "biały", "pomaluj ścinę");
            case DRIVING:
                return new DrivingTask("Przejazd", "Do centrum miasta", "autobus");
            default:
                return null;
        }
    }
}
