package management;

import client.Customer;

import java.util.ArrayList;
import java.util.List;


import static useful.Useful.*;

public class Data {



    public static List<Customer> customerList() {

        List<Customer> customers = new ArrayList<>();
        int count = 0;
        while (count < 3) {

            String customerName = readString("Please enter the customer name");
            int customerId = readInt("Please enter the customer's Id");
            int customerBalance = readInt("Please enter the customer's balance");

            Customer client = new Customer(customerName, customerId, customerBalance);
            customers.add(client);
            count++;
        }

        return customers;
    }
}

