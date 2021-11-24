package com.example.springboot.service;

import com.example.springboot.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Restaurantservice {
   private static List<Restaurant> restaurantList=new ArrayList<>();

    static {
restaurantList.add(new Restaurant(101,"Kundan","Mr.Bhatiya"));
restaurantList.add(new Restaurant(102,"Sai","Mr.Bora"));

    }
    public List<Restaurant>getAllRestaurant()
    {
        return restaurantList;
    }
    public Restaurant getRestaurantById(int id)
    {
        Restaurant restaurant=null;
        try {
            restaurant = restaurantList.stream().filter(e -> e.getId() == id).findFirst().get();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return restaurant;
    }
    public Restaurant addRestaurant(Restaurant r)
    {
        restaurantList.add(r);
        return r;
    }
    public void deleteRestaurant(int id)
    {
        restaurantList.stream().filter(r->{if(r.getId()!=id){return true;} else return false;}).collect(Collectors.toList());
    }
    public void updateRestaurant(Restaurant restaurant,int id)
    {
        restaurantList= restaurantList.stream().map(r->{ if(r.getId()==id){r.setName(restaurant.getName());r.setOwnerName(restaurant.getOwnerName());}return r;}).collect(Collectors.toList());
    }

}







