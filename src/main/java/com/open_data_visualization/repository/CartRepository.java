package com.open_data_visualization.repository;

import com.open_data_visualization.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


@Repository("cartRepo")
public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query("select u from Cart u where u.username = ?1")
    List<Cart> findByUsername(String username);
}
