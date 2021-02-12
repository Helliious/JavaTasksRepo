package main.components;

public class Frame extends Component {
    public Frame() {
        super("Frame");
    }

    @Override
    public int getBuildTime() {
        return 5000;
    }

    @Override
    public void showComponent() {
        System.out.println(super.getName() + " component was created!");
    }
}
