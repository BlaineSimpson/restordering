/*
RestaurantRepository.java
Author Demi Alexis Farquhar (220322104)
Date: 7 April 2022
 */
package za.ac.cput.repository;

import za.ac.cput.entity.Restaurant;

import java.util.HashSet;
import java.util.Set;

public class RestaurantRepository  implements IRestaurantRepository{
    private static RestaurantRepository repository=null;
    private Set<Restaurant> restaurantDB=null;

    private RestaurantRepository(){
        restaurantDB=new HashSet<Restaurant>();
    }
    public static RestaurantRepository getRepository(){
        if(repository==null){
            repository= new RestaurantRepository();
        }
        return repository;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
    boolean success= restaurantDB.add(restaurant);
    if(!success)
    return null;
    return restaurant;
    }

    @Override
    public Restaurant read(String restaurantId) {
    Restaurant restaurant= restaurantDB.stream()
                .filter(r->r.getRestaurantId().equals(restaurantId))
                .findAny()
                .orElse(null);
    return restaurant;
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
    Restaurant oldRestaurant= read(restaurant.getRestaurantId());
    if(oldRestaurant != null){
            restaurantDB.remove(oldRestaurant);
            restaurantDB.add(restaurant);
            return restaurant;
        }
        return null;
    }

    @Override
    public boolean delete(String restaurantId) {
    Restaurant restaurantToDelete=read(restaurantId);
        if(restaurantToDelete== null)
            return false;
    restaurantDB.remove(restaurantToDelete);
        return true;
    }

    @Override
    public Set<Restaurant> getAll() {
        return restaurantDB;
    }
}
