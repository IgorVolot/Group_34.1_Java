package ait.pomegranate.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Box implements Iterable<Pomegranate>{
    private String name;
    private List<Pomegranate> granates;

    public Box(String name) {
        this.name = name;
        granates = new ArrayList<>();
    }

    public Box(String name, List<Pomegranate> granates) {
        this.name = name;
        this.granates = granates;
    }

    public String getName() {
        return name;
    }

    public List<Pomegranate> getGranates() {
        return granates;
    }

    public void setGranates(List<Pomegranate> granates) {
        this.granates = granates;
    }
    public int quantity(){
        return granates.size();
    }
    public int countSeeds(){
        return granates.stream()
                .mapToInt(g -> g.quantity())
                .sum();
    }
    public double weigth(){
        return granates.stream()
                .mapToDouble(g -> g.weight())
                .sum();
    }

    @Override
    public Iterator<Pomegranate> iterator() {
        return granates.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Box that = (Box) o;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Box{");
        sb.append("name= '").append(name).append('\'');
        sb.append(", seeds= ").append(countSeeds());
        sb.append('}');
        return sb.toString();
    }
}
