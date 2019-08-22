package com.company;

// BillingAddress Class 'is-a' Address so we extend the Address class.
public class BillingAddress extends Address{

    public BillingAddress(String street1, String street2, String city, String state, String zip) {
        super(street1, street2, city, state, zip);
    }

    // no need to define toString() method as the parent class Address already defined toString().
}
