package model;

import java.util.Iterator;
import java.util.List;

public class AnimalIterator implements Iterator<Animal> {
        private int index;
        private List<Animal> registry;

        public AnimalIterator(List<Animal> registry) {
            this.registry = registry;
        }

        @Override
        public boolean hasNext() {
            return index < registry.size();
        }

        @Override
        public Animal next() {
            return registry.get(index++);
        }
}
