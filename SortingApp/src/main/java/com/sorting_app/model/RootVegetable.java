package com.sorting_app.model;


import java.util.Comparator;

public class RootVegetable implements Comparable<RootVegetable> {
    private final String type;
    private final int weight;
    private final String color;

    public RootVegetable(RootVegetableBuilder vegetableBuilder) {
        this.type = vegetableBuilder.type;
        this.weight = vegetableBuilder.weight;
        this.color = vegetableBuilder.color;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int compareTo(RootVegetable o) {
        return Comparator.nullsLast(
                Comparator.comparing(RootVegetable::getType, Comparator.nullsLast(Comparator.naturalOrder())))
                    .thenComparingInt(RootVegetable::getWeight)
                    .thenComparing(Comparator.nullsLast(Comparator.comparing(RootVegetable::getColor)))
                    .compare(this, o);
    }

    @Override
    public String toString() {
        return String.format("Корнеплод - Тип корнеплода: %s; Вес: %d; Цвет: %s",
                type, weight, color);
    }

    public static class RootVegetableBuilder {
        private String type;
        private int weight;
        private String color;

        public RootVegetableBuilder() {
        }

        public RootVegetableBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public RootVegetableBuilder setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public RootVegetableBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public RootVegetable build() {
            return new RootVegetable(this);
        }
    }
}