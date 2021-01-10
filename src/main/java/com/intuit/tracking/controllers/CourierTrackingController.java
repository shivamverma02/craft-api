package com.intuit.tracking.controllers;

import com.intuit.tracking.models.CreateStatusRequest;
import com.intuit.tracking.models.GenericResponse;
import com.intuit.tracking.models.UpdateStatusRequest;
import com.intuit.tracking.service.CourierTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CourierTrackingController {

    @Autowired
    private CourierTrackingService courierTrackingService;

    @PostMapping("/tracking/courier/status")
    public ResponseEntity<GenericResponse> createCourierTrackingRecord(@RequestBody @Valid CreateStatusRequest
                                                                       createStatusRequest) throws Exception{
        return new ResponseEntity<GenericResponse>
                (new GenericResponse("status created successfully "
                        , courierTrackingService.createStatus(createStatusRequest)), HttpStatus.OK);

    }

    @PutMapping("/tracking/courier/status")
    public ResponseEntity<GenericResponse>  updateCourierTrackingRecord(@RequestBody @Valid UpdateStatusRequest
                                                                                    updateStatusRequest)
            throws Exception{

        return new ResponseEntity<GenericResponse>
                (new GenericResponse("status  updated successfully for id : "+updateStatusRequest.getTrackingId()
                        ,     courierTrackingService.updateStatus(updateStatusRequest)), HttpStatus.OK);

    }

    @GetMapping("/tracking/courier/status")
    public ResponseEntity<GenericResponse>  getCourierTrackingStatus(@RequestParam("tracking_id") long id)
            throws Exception{
        return new ResponseEntity<GenericResponse>
                (new GenericResponse("fetched courier by Id successfully :: "+id
                        , courierTrackingService.getStatus(id)), HttpStatus.OK);

    }

    @GetMapping("/tracking/courier/status/logs")
    public ResponseEntity<GenericResponse>  getCourierTrackingStatusLogs(@RequestParam("tracking_id") long id)
            throws Exception{
        return new ResponseEntity<GenericResponse>
                (new GenericResponse("fetched courier by Id successfully :: "+id
                        , courierTrackingService.getStatusLogs(id)), HttpStatus.OK);

    }
}
