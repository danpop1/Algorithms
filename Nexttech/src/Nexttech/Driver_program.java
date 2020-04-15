package Nexttech;

import javafx.application.Application;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;

public class Driver_program {
    //Companies;


    public void output_list(List<Invoice> list) {
        for (Invoice i : list) {
            System.out.println(i.toString());
        }
    }

    public void output_productnames(Invoice i,List<Invoice>list){
       // Product e;
        for (Invoice x:list) {
            for (Product e:x.getProducts()) {
                System.out.print(e.getName()+" ");
            }
        }
    }

    public static void main(String[] args) {
        List<Invoice> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Invoice invoice = new Invoice();
            if (invoice.getCompany() != null) {
                System.out.println(invoice.toString());
                list.add(invoice);
            }
        }
        int option = -1;
        System.out.println("What will you choose to do? \n 1 to Add an invoice \n 2 to Edit! \n 3 to Search an Invoice \n 0 to Exit");
        Scanner sc = new Scanner(System.in);
        option = sc.nextInt();
        switch (option) {
            case 1: {
                int ok = 1;
                int inv = sc.nextInt();
                for (Invoice i : list) {
                    if (i.getInvoicenumber() == inv) {
                        ok = 0;
                    }
                }
                if (ok == 0) {
                    System.out.println("Found an invoice with the same invoice number!");
                } else {
                    sc.nextLine();
                    System.out.println("Due date: ");
                    String s = sc.nextLine();
                    System.out.println("Pay date: ");
                    String p = sc.nextLine();
//                    System.out.println("Total price: ");
//                   sc.nextLine();
//                    float total = sc.nextFloat();
                    System.out.println("Number of products: (not greater than 3)");
                    int nrprod = sc.nextInt();
                    List<Product> products = new ArrayList<>();
                    sc.nextLine();
                    for (int x = 0; x < nrprod; x++) {
                        System.out.println("Product number: ");
                        int prodnumber = sc.nextInt();
                        System.out.println("Product name: ");
                        sc.nextLine();
                        String prodname = sc.nextLine();
                        System.out.println("Product price: ");
                        float prodprice = sc.nextFloat();
                        sc.nextLine();
                        Product product = new Product(prodnumber, prodname, prodprice);
                        products.add(product);
                    }
                    float total = 0;
                    for (Product prod : products) {
                        total = total + prod.getPrice();
                    }
                    System.out.println("Name of the company: ");
                    String c = sc.nextLine();
                    System.out.println("Phone number: ");
                    String ph = sc.nextLine();
                    // System.out.println(total);
                    Company comp = new Company(c, ph);

                    Invoice invoice1 = new Invoice(inv, s, total, products, p, comp);
                    // list.add(invoice1);
                    sc.close();
                    ok = 0;
                    Driver_program dp = new Driver_program();
                    dp.output_list(list);
                    for (Invoice iv : list) {
                        if (iv.equals(invoice1)) {
                            ok = 1;
                            System.out.println("Found duplicate!");
                        }
                    }
                    if (ok == 0) {
                        System.out.println("No duplicate found!");
                        list.add(invoice1);
                        dp.output_list(list);
                    } else {
                        String nstr = invoice1.getCompany().getName() + "_Duplicate";
                        invoice1.getCompany().setName(nstr);
                        list.add(invoice1);
                        dp.output_list(list);
                    }

                }
            }
            break;
            case 2:{
                int search=0;
                System.out.println("Please insert the invoice's number you wish to mark as paid..");
                int inv=sc.nextInt();
                Driver_program driver_program=new Driver_program();
                for (Invoice iv:list) {
                    if(inv==iv.getInvoicenumber()){
                        System.out.println("Before");
                        System.out.println(iv.getPaydate());
                        search=1;
                        Calendar calendar=Calendar.getInstance();
                        calendar.add(Calendar.DATE,0);
                        iv.setPaydate(calendar.getTime().toString());
                        System.out.println("After");
                        System.out.println(iv.getPaydate());
                       // driver_program.output_list(list);
                    }
                }
                if(search==0)
                    System.out.println("Invoice not found!");

            }break;

            case 3:{
                //temporary List
                Driver_program driver_program=new Driver_program();

                List<Invoice> temporaryList=new ArrayList<>(10);
                System.out.println("Insert a string with atleast 3 characters");
                String x=sc.next();
                if(x.length()>3){
                    for (Invoice i:list) {
                       List<String> L =new ArrayList<>(Arrays.asList(i.getCompany().getName().split(" ")));
                        for (String s:L) {
                            int e=0;
                            if(x.equals(s) && e<1){
                                temporaryList.add(i);
                                e=1;
                            }
                        }
                    }
                    for (Invoice inv:temporaryList) {
                        System.out.println(inv.getCompany().getName()+" "+inv.getPaydate()+" "+inv.getDuedate()+" "+ inv.getProducts());
                       // driver_program.output_productnames(inv,list);
                        //System.out.println();
                    }
                }
                else{
                    System.out.println("Please insert a valid string");
                }

            }break;

            case 0: {
                System.out.println("Exit..");
            }
            break;
            default: {
                System.out.println("Please insert a valid number!");
            }
            break;
        }
    }
}
