package com.intuit.tracking.repo;

import com.intuit.tracking.entities.CourierStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CourierStatusRepository extends CrudRepository<CourierStatus,Long> {

    @Modifying
    @Transactional
    @Query("Update CourierStatus cs set cs.status = :status where cs.courierId = :id")
    void updateStatusById(@Param("id") long id , @Param("status") String status);

    @Query("Select cs from CourierStatus cs where cs.courierId = :id")
    List<CourierStatus> getCourierStatus(@Param("id") long id);
}
