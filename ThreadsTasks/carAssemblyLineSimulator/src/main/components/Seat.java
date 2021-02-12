package main.components;

public class Seat extends Component {
    public Seat() {
        super("Seat");
    }

    @Override
    public int getBuildTime() {
        return 3000;
    }

    @Override
    public void showComponent() {
        System.out.println(super.getName() + " component was created!");
    }
}
