package com.example.springboot.controller;

import com.example.springboot.model.Restaurant;
import com.example.springboot.service.Restaurantservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private Restaurantservice restaurantservice;


    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Restaurant>> getAllRestaurant()
    {
        List<Restaurant>list=restaurantservice.getAllRestaurant();
        if (list.size()<=0)
        {
            ResponseEntity.status((HttpStatus.NOT_FOUND)).build();
        }
       return ResponseEntity.of(Optional.of(list));
    }


    @RequestMapping(value = "/restaurant/{id}",method = RequestMethod.GET)
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int id)
    {
       Restaurant restaurant=restaurantservice.getRestaurantById(id);
       if(restaurant==null)
       {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       return ResponseEntity.of(Optional.of(restaurant));

    }


    @RequestMapping(value = "/restaurants",method = RequestMethod.POST)
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant rest)
    {
        Restaurant re=null;
        try {
            re = this.restaurantservice.addRestaurant(rest);
            return ResponseEntity.of(Optional.of(re));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @RequestMapping(value = "/restaurant/{restaurantId}",method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteRestaurant(@PathVariable int id)
    {
        try {
            this.restaurantservice.deleteRestaurant(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/rest/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Restaurant> updateResturant(@RequestBody Restaurant restaurant,@PathVariable int id) {
        try {
            this.restaurantservice.updateRestaurant(restaurant, id);
            return ResponseEntity.ok().body(restaurant);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
}