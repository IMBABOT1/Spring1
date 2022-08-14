package ru.geekbrains.lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static void addOreDeleteProduct(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.geekbrains.lesson2");

        Cart cart = context.getBean(Cart.class);

        while (true) {
            System.out.println("set number to add product");
            System.out.println("press /end to exit");

            String line = scanner.nextLine();
            if (line.equals("/end")) {
                break;
            } else if (line.equals("/add1")) {
                cart.addProductByID(1l);
                System.out.println(cart);
            } else if (line.equals("/add2")) {
                cart.addProductByID(2l);
                System.out.println(cart);
            } else if (line.equals("/add3")) {
                cart.addProductByID(3l);
                System.out.println(cart);
            } else if (line.equals("/add4")) {
                cart.addProductByID(4l);
                System.out.println(cart);
            } else if (line.equals("/add5")) {
                cart.addProductByID(5l);
                System.out.println(cart);
            } else if (line.equals("/dell1")) {
                cart.deleteProductByID(1l);
                System.out.println(cart);
            } else if (line.equals("/dell2")) {
                cart.deleteProductByID(2l);
                System.out.println(cart);
            } else if (line.equals("/dell3")) {
                cart.deleteProductByID(3l);
                System.out.println(cart);
            } else if (line.equals("/dell4")) {
                cart.deleteProductByID(4l);
                System.out.println(cart);
            } else if (line.equals("/dell5")) {
                cart.deleteProductByID(5l);
                System.out.println(cart);
            } else {
                addOreDeleteProduct();
            }
        }
    }


    public static void main(String[] args) {
        addOreDeleteProduct();

    }
}
