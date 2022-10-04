/*
TableRepository.java
Author Demi Alexis Farquhar (220322104)
Date: 5 August 2022
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Tablee;


@Repository
public interface ITableRepository extends JpaRepository <Tablee, String> {
}
