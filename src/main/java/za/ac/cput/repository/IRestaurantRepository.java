/*
IRestaurantRepository.java
Author Demi Alexis Farquhar (220322104)
Date: 7 April 2022
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Restaurant;



@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant,String> {
//create, read, update, delete



}
