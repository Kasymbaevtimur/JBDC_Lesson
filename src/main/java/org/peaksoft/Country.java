package org.peaksoft;

public class Country {
        private int id;
        private String name;
        private String square;
        private int population;

        public Country() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSquare() {
            return square;
        }

        public void setSquare(String square) {
            this.square = square;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        @Override
        public String toString() {
            return "Country:"+" id: "+id+"\n"+
                    "name: "+name+"\n"+
                    "square: "+square+"\n"+
                    "population: "+population+"\n"+
                    "___________________________\n";

        }
    }

