/*
IRestaurantRepository.java
Author Demi Alexis Farquhar (220322104)
Date: 7 April 2022
 */
package za.ac.cput.repository;

import za.ac.cput.entity.Restaurant;

import java.util.Set;

public interface IRestaurantRepository extends IRepository<Restaurant,String>  {
//create, read, update, delete
public Set<Restaurant> getAll();


}
