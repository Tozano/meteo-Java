package com.meteo.repositories;

import com.meteo.models.Selection;
import com.meteo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SelectionRepository extends JpaRepository<Selection, Integer> {
    List<Selection> findAllByUser(User user);
}
