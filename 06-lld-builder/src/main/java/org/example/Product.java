package org.example;

public class Product {
    private String name;
    private String description;
    private double price;
    private int rating;
    private float weight;
    private int ram;
    private String processor;

    private Product(final ProductBuilder builder) {
        this.name = builder._name;
        this.description = builder._description;
        this.price = builder._price;
        this.rating = builder._rating;
        this.weight = builder._weight;
        this.ram = builder._ram;
        this.processor = builder._processor;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private String _name;
        private String _description;
        private double _price;
        private int _rating;
        private float _weight;
        private int _ram;
        private String _processor;

        public ProductBuilder name(String name) {
            this._name = name;
            return this;
        }

        public ProductBuilder description(String description) {
            this._description = description;
            return this;
        }

        public ProductBuilder price(double price) {
            this._price = price;
            return this;
        }

        public ProductBuilder rating(int rating) {
            this._rating = rating;
            return this;
        }

        public ProductBuilder weight(float weight) {
            this._weight = weight;
            return this;
        }

        public ProductBuilder ram(int ram) {
            this._ram = ram;
            return this;
        }

        public ProductBuilder processor(String processor) {
            this._processor = processor;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", weight=" + weight +
                ", ram=" + ram +
                ", processor='" + processor + '\'' +
                '}';
    }
}
