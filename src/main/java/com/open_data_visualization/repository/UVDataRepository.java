package com.open_data_visualization.repository;
import com.open_data_visualization.model.UVData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository("uvRepository")
public interface UVDataRepository extends JpaRepository<UVData, Integer> {
//    String FIND_PROJECTS = "SELECT * from open_data";
//    @Query(value = FIND_PROJECTS, nativeQuery = true)
//    List<UVData> findAll();
}
