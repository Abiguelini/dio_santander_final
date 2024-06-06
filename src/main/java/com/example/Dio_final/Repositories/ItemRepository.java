package com.example.Dio_final.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Dio_final.Model.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
