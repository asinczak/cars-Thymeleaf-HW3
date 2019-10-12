package pl.akademiaspring.cars.model;

public enum Colour {
    BLACK("Black"),
    SILVER("Silver"),
    RED("Red"),
    GREEN("Green"),
    ORANGE("Orange"),
    WHITE("White"),
    STEEL("Steel"),
    BROWN("Brown");

    private final String displayValue;

    Colour(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
