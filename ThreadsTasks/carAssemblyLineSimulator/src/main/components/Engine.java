package main.components;

public class Engine extends Component {
    public Engine() {
        super("Engine");
    }

    @Override
    public int getBuildTime() {
        return 7000;
    }

    @Override
    public void showComponent() {
        System.out.println(super.getName() + " component was created!");
    }
}
