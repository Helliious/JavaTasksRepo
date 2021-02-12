package main.components;

public class Tire extends Component {
    public Tire() {
        super("Tire");
    }

    @Override
    public int getBuildTime() {
        return 2000;
    }

    @Override
    public void showComponent() {
        System.out.println(super.getName() + " component was created!");
    }
}
