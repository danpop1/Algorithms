package Nexttech;

import org.w3c.dom.ls.LSOutput;

import java.util.*;


public class Company {
    private String name = "";
    private String phonenumber = "";

    public static List<String> list = new ArrayList<String>();

    public boolean validate(String a, String b) {
        String aux1, aux2;

        List<String> list1 = new ArrayList<>(Arrays.asList(a.split("")));
        Collections.sort(list1);
        aux1 = list1.toString();
        if (list.isEmpty()) {
            list.add(a);
        } else {
            int ok = 1;
            for (String s : list) {
                List<String> list2 = new ArrayList<>(Arrays.asList(s.split("")));
                Collections.sort(list2);
                aux2 = list2.toString();
                if (aux1.equals(aux2)) {
                    ok = 0;
                }
            }
            if (ok == 0)
                return false;
            else
                list.add(a);
        }
        return true;
    }

    public Company(String name,String phonenumber){
        this.name=name;
        this.phonenumber=phonenumber;
    }


    public Company() {
        String[] a = {"European", "Food", "Electricity", "Incorporated", "Automation", "Enterprise", "Romanian", "OneMan"};
        String number = "0123456789";
        String x = null, y = null;

        int i = (int) (Math.random() * (a.length));
        int j = (int) (Math.random() * (a.length));
        int k = (int) (Math.random() * (a.length));
        while (a[i].equals(a[j]) || a[i].equals(a[k]) || a[j].equals(a[k])) {
            i = (int) (Math.random() * (a.length));
            j = (int) (Math.random() * (a.length));
            k = (int) (Math.random() * (a.length));
        }

        int ok = 1;
        StringBuilder sb = new StringBuilder(14);
        for (int l = 0; l < 14; l++) {
            int index = (int) (Math.random() * number.length());
            sb.append(number.charAt(index));
        }

        y = sb.toString();
        x = a[i] + " " + a[j] + " " + a[k];
        if (validate(x, y)) {
            name = x;
            phonenumber = y;
        } else {
            name = "";
            phonenumber = "";
        }

    }



    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
