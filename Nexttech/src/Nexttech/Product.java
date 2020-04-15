package Nexttech;

import java.util.*;

public class Product {
    private int productnumber = 0;
    private String name;
    private float price;
    public static List<String> names = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return this.getProductnumber() == product.getProductnumber() &&
                Float.compare(product.getPrice(), this.getPrice()) == 0 &&
                this.getName().equals(product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductnumber(), getName(), getPrice());
    }

    public boolean validate(String string) {
        for (String s : names) {
            if (s.equals(string))
                return false;
        }
        return true;
    }

    public String sort_chars(String aux) {
        char[] chars = aux.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public Product(int productnumber,String name,float price){
        setProductnumber(productnumber);
        this.name=name;
        this.price=price;
}

    public Product() {
        productnumber=(int)(Math.random()*10000);
        float generated = 0;
        String abc = "ABCDEFGHIJKLMNOPQRESTUVWXYZ";
        StringBuilder sb = new StringBuilder(5);
        String e = null;
        int i = 0, x = 0;
        while (i < 5) {
            x = (int) (Math.random() * abc.length());
            sb.append(abc.charAt(x));
            i++;
        }
        e = sb.toString();
        e = sort_chars(e);

        generated = (float) (Math.random() * (999.9 - 0.1) + 0.1);
        price = generated;

        if (validate(e)) {
            name = e;
            names.add(e);
        } else {
            name = "";
            productnumber = -1;
            price = -1;
        }

    }

    public int getProductnumber() {
        return productnumber;
    }

    public void setProductnumber(int productnumber) {
        this.productnumber = productnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<String> getNames() {
        return names;
    }

    public static void setNames(List<String> names) {
        Product.names = names;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productnumber=" + productnumber +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
