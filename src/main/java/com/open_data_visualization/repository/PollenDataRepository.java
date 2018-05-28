package com.open_data_visualization.repository;

import com.open_data_visualization.model.PollenWeeklyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("pollenRepository")
public interface PollenDataRepository extends JpaRepository<PollenWeeklyData, Integer> {

}
