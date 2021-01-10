package com.intuit.tracking.repo;

import com.intuit.tracking.entities.CourierStatusLogs;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourierStatusUpdateRepository extends CrudRepository<CourierStatusLogs,Long> {
    List<CourierStatusLogs> findByCourierId(long courierId);
}
