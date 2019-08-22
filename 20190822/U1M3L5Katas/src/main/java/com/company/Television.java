package com.company;

import com.opencsv.bean.CsvBindByName;


public class Television {
        @CsvBindByName(column = "brand")
        private String brand;
        @CsvBindByName(column = "model")
        private String model;
        @CsvBindByName(column = "price")
        private int price;
        @CsvBindByName(column = "screenSize")
        private int screenSize;


        public Television(String brand, String model, int price, int screenSize) {
            this.brand = brand;
            this.model = model;
            this.price = price;
            this.screenSize = screenSize;
        }

        public Television() {
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getScreenSize() {
            return screenSize;
        }

        public void setScreenSize(int screenSize) {
            this.screenSize = screenSize;
        }
}
