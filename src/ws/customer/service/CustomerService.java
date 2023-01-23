package ws.customer.service;
import ws.customer.data.Customer;
import ws.customer.data.CustomerDB;
public class CustomerService {
    public void setCustomer(String customerName, Integer customerID, float shoppingAmount, boolean privileged, int discountPercentage ) {
        Customer customer = new Customer(customerName, customerID, shoppingAmount, privileged, discountPercentage);
        CustomerDB.addCustomer(customer);
    }
    public String getCustomer(int id) {
        Customer customer = CustomerDB.getCustomer(id);
        if (customer == null) {
            customer = new Customer();
            customer.setCustomerID(id);
        }
        return customer.toString();
    }
    
    public void updateCustomer(int id, String name, Float shoppingAmount, Boolean privileged, Integer discountPercentage) {
    	Customer customer = CustomerDB.getCustomer(id);
        if (customer == null) {
            customer = new Customer();
            customer.setCustomerID(id);
        } else {
            CustomerDB.updateById(id, name, shoppingAmount, privileged, discountPercentage);
        }
    }
    
    public void deleteCustomer(int id) {
    	CustomerDB.deleteById(id);
    }
}