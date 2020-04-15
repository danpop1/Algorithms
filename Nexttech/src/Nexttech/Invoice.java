package Nexttech;

import java.util.*;

public class Invoice {
    private int invoicenumber;
    private String duedate;
    private float total;
    private List<Product> products = new ArrayList<>();
    private String paydate;
    private Company company;
    public static Company[] cp = new Company[48];

    public void getproductnames(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return  Float.compare(invoice.total, this.total) == 0 &&
                this.getDuedate().equals(invoice.getDuedate()) &&
               this.getProducts().equals(invoice.getProducts())&&
                this.getPaydate().equals(invoice.getPaydate()) &&
                this.getCompany().getName().equals(invoice.getCompany().getName()) &&
                this.getCompany().getPhonenumber().equals(invoice.getCompany().getPhonenumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoicenumber(), getDuedate(), total, getProducts(), getPaydate(), getCompany());
    }

    public void output() {
        for (int i = 0; i < cp.length; i++) {
            System.out.println(cp[i]);
        }
    }
    public Invoice(int invoicenumber,String dd,float t,List<Product> products,String pd,Company comp){
       this.products=products;
       setInvoicenumber(invoicenumber);
       this.duedate=dd;
       this.paydate=pd;
       this.company=comp;
       this.total=t;
    }

    public Invoice() {
        this.invoicenumber=(int)(Math.random()*10000);
        int pd = 0, dd = 0;

        for (int i = 0; i < cp.length; i++) {
            Company comp = new Company();
            if (!comp.getPhonenumber().equals("") && !comp.getName().equals("")) {
                cp[i] = comp;
            }
        }

        int x = (int) (Math.random() * cp.length);
        company = cp[x];

        int j = (int) (Math.random() * (3 - 1) + 1);
        for (int i = 1; i <= j; i++) {
            Product product = new Product();
            //assert products != null;
            products.add(product);
            total = product.getPrice() + total;
        }

        Calendar calendardd = Calendar.getInstance();
        dd = (int) (Math.random() * 5);
        calendardd.add(Calendar.DATE, dd);
        duedate = calendardd.getTime().toString();

        Calendar calendarpd = Calendar.getInstance();
        pd = -(int) (Math.random() * 5);
        calendarpd.add(Calendar.DATE, pd);
        paydate = calendarpd.getTime().toString();

    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Invoice{" + "invoice number= " + invoicenumber +
                ", duedate='" + duedate + '\'' +
                ", total=" + total +
                ", products=" + products +
                ", paydate='" + paydate + '\'' +
                ", company=" + company +
                '}';
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public static Company[] getCp() {
        return cp;
    }

    public static void setCp(Company[] cp) {
        Invoice.cp = cp;
    }

    public int getInvoicenumber() {
        return invoicenumber;
    }

    public void setInvoicenumber(int invoicenumber) {
        this.invoicenumber = invoicenumber;
    }
}
