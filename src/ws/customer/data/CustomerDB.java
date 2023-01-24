package ws.customer.data;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
public class CustomerDB {
    
    //Here we define a collection for customers.
   private static Hashtable<Integer, Customer> customers = new Hashtable<Integer, Customer>();
    
    public static String addCustomer(Customer customer) {
        
        String result="Current number of entries: ";
        if(customer !=null)
           customers.put(customer.getCustomerID(), customer);
        
        return result + customers.size();
    }
    
     public static Customer getCustomer(int id) {
          return  customers.get(id);
        
     }
     
     public static Customer[] getCustomerInterval(float min, float max) {
    	 ArrayList<Customer> temp = new ArrayList<Customer>();
         Enumeration<Integer> e = customers.keys();
         while (e.hasMoreElements()) {
        	 int key = e.nextElement();
        	 if(customers.get(key).getShoppingAmount()>min && customers.get(key).getShoppingAmount()<max) {
        		 temp.add(customers.get(key));
        	 }
         }
         Customer[] customerInt = new Customer[temp.size()];
         for(int i=0; i<temp.size();i++) {
        	 customerInt[i] = temp.get(i);
         }
    	 return  customerInt; 
    }
     
     public static void deleteById(int id) {
    	 customers.remove(id);
     }
          
     public static void updateById(int id, String name, float shoppingAmount, Boolean privileged, Integer discountPercentage) {
    	 Customer customer = customers.get(id);
    	 Float fObj = shoppingAmount;
         if(name != null && !name.isEmpty()) {
        	 customer.setCustomerName(name);
         }
         if(fObj != null) {
        	 customer.setShoppingAmount(discountPercentage);;
         }
         if(privileged != null) {
        	 customer.setPrivileged(privileged);
         }
         if(discountPercentage != null) {
        	 customer.setDiscountPercentage(discountPercentage);
         }
         customers.put(id, customer);
     }
}