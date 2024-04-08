package com.meteo.repositories;

import com.meteo.models.Selection;
import com.meteo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectionRepository extends JpaRepository<Selection, Integer> {
    List<Selection> findAllByUser(User user);
}
