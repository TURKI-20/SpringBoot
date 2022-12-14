package com.example.day3bankaccount;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class Controller {
    ArrayList<Customer> customers = new ArrayList<>();


@GetMapping("/customer")
public ArrayList<Customer> getCustomers() {
        return customers;
        }


@PostMapping("/add")
public String addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return "customer added";
        }


@DeleteMapping("/delete/{index}")
public String deleteCustomer(@PathVariable int index) {
        customers.remove(index);
        return "customer delete!";
        }

@PutMapping("/update/{index}")
public String updateCustomer(@PathVariable int index, @RequestBody Customer customer) {
        customers.set(index, customer);
        return "Customer Updated";
        }

@PutMapping("/dep/{index}/{amount}")
public ApiResponse DepositCustomer(@PathVariable int index, @PathVariable int amount) {
        for(int i =0 ; i <customers.size();i++){
        if(customers.get(i).getID()==index){
        customers.get(i).setBalance(customers.get(i).getBalance()+ amount);
        return new ApiResponse("amount add!");
        }
        }
        return new ApiResponse("we can found this customer");
        }

@PutMapping("with/{index}/{amount}")
public ApiResponse withDrawCustomer(@PathVariable int index , @RequestBody int amount){
        for (int i =0 ;i<customers.size();i++) {
        if (customers.get(i).getID()==i){
        if (customers.get(i).getBalance()-amount>=0) {
        customers.get(i).setBalance(customers.get(i).getBalance()-amount);
        return new ApiResponse("withdraw was done");
        }
        else return new ApiResponse("not enough");
        }
        }
        return new ApiResponse("we can found this customer");
        }
}