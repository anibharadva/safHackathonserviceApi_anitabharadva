package com.example.demo.repository;

import com.example.demo.entity.ScratchCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


/**
 * Anita
 * 6/12/2019
 */
public interface CardRepository  extends CrudRepository<ScratchCard, Long> {

    List<ScratchCard> fetchBySerialNo(@Param("serialNo") String  serialNo);
    @Transactional
    @Modifying
   void deleteInactiveCards(@Param("status") String  status);
}
