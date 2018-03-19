package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String DRIVING_TASK = "Driving task";
    public static final String PAINTING_TASK = "Painting task";
    public static final String SHOPPING_TASK = "Shopping task";

    public final Task makeTask(final String taskClass){
        switch(taskClass) {
            case DRIVING_TASK:
                return new DrivingTask("Driving task", "AnyDestination", "Car");
            case PAINTING_TASK:
                return new PaintingTask("Painting task", "White", "AnyPlaceToBePainted");
            case SHOPPING_TASK:
                return new ShoppingTask("Shopping task", "AnythingWhatYouWantToBuy", 1);
             default:
                 return null;
        }
    }
}
