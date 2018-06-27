package com.unisys.microservices.helloworld;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.unisys.microservices.helloworld.api.Api;
import com.unisys.microservices.helloworld.model.Customer;

public class APITest {

    @Test
    public void check_findAll() {
        Api api= new Api();
        List<Customer> customers = api.findAll();
        int expectedCustomerCnt = 4;
        Assert.assertEquals("Verifying Default customers cretated by APi",expectedCustomerCnt , customers.size());;
        // make sure pesel IDs are not null
        for(Customer cu: customers){
        	Assert.assertNotNull("Found null Pussel ID for customer ID", cu.getPesel());
        }
    }
    
    
    
}
