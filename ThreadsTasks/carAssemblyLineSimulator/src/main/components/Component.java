package main.components;

import java.util.Objects;

public abstract class Component {
    private static int id = 0;
    private final String name;
    private final int componentId;

    Component(String name) {
        this.name = name;
        componentId = id++;
    }

    String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return componentId == component.componentId && Objects.equals(name, component.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, componentId);
    }

    public abstract int getBuildTime();
    public abstract void showComponent();
}
