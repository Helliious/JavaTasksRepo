package main.Vignette;

import java.time.LocalDate;

public abstract class Vignette {
    private LocalDate dateOfCreation;
    private final VignetteKind color;
    private LocalDate expireDate;
    private VignetteType type;

    Vignette(VignetteKind color,
             VignetteType type) {
        this.dateOfCreation = LocalDate.now();
        this.color = color;
        this.type = type;
        switch (type) {
            case WEEK:
                this.expireDate = dateOfCreation.plusWeeks(1);
            case MONTH:
                this.expireDate = dateOfCreation.plusMonths(1);
            default:
                this.expireDate = dateOfCreation.plusYears(1);
        }
    }

    //Used for testing the method which shows all expired vignettes
    public void changeValidity(LocalDate dateOfCreation,
                               VignetteType type) {
        this.dateOfCreation = dateOfCreation;
        this.type = type;
        switch (type) {
            case WEEK:
                this.expireDate = dateOfCreation.plusWeeks(1);
            case MONTH:
                this.expireDate = dateOfCreation.plusMonths(1);
            default:
                this.expireDate = dateOfCreation.plusYears(1);
        }
    }

    @Override
    public String toString() {
        return "\nVignette type: " + type +
                "\nVignette kind: " + color +
                "\nDate of creation: " + dateOfCreation +
                "\nExpire date: " + expireDate + "\n";
    }

    public VignetteType getType() {
        return type;
    }

    public VignetteKind getColor() {
        return color;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public abstract int getPrice();
    public abstract void glueUp();
    //Future improvement
    public abstract VignetteKind getKind();
}
