package com.intuit.tracking.service;

import com.intuit.tracking.entities.CourierStatus;
import com.intuit.tracking.entities.CourierStatusLogs;
import com.intuit.tracking.exception.NotValidTrackingId;
import com.intuit.tracking.models.CreateStatusRequest;
import com.intuit.tracking.models.UpdateStatusRequest;
import com.intuit.tracking.repo.CourierStatusRepository;
import com.intuit.tracking.repo.CourierStatusUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CourierTrackingService {

    @Autowired
    private CourierStatusRepository courierStatusRepository;

    @Autowired
    private CourierStatusUpdateRepository courierStatusUpdateRepository;

    @Transactional
    public CourierStatus createStatus(CreateStatusRequest createStatusRequest){
        CourierStatus courierStatus =
                courierStatusRepository.save(createStatusRequest.toCourierStatus());
         courierStatusUpdateRepository.save(createStatusRequest
                .toCourierUpdate(courierStatus.getCourierId()));
         return courierStatus;

    }

    @Transactional
    public CourierStatus updateStatus(UpdateStatusRequest updateStatusRequest)
            throws Exception{
        courierStatusRepository.updateStatusById(updateStatusRequest.getTrackingId(),
                updateStatusRequest.getStatus());
        courierStatusUpdateRepository.save(updateStatusRequest.toCourierUpdate());
        return getStatus(updateStatusRequest.getTrackingId());
    }

    public CourierStatus getStatus(long id) throws Exception{
       Optional<CourierStatus> status = courierStatusRepository.findById(id);
       if(!status.isPresent()) {
           throw new NotValidTrackingId("its not a valid Id ::  "+ id);
       }
       return status.get();
    }

    public List<CourierStatusLogs> getStatusLogs(long id) throws Exception{
        List<CourierStatusLogs> statusLogs =courierStatusUpdateRepository.findByCourierId(id);
        return statusLogs;
    }
}
