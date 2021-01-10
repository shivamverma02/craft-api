package com.intuit.tracking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.intuit.tracking.entities.CourierStatus;
import com.intuit.tracking.entities.CourierStatusLogs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class CreateStatusRequest {

    @NotBlank(message = "updated by can't be null or empty")
    private String updatedBy;
    @NotBlank(message = "status by can't be null or empty")
    private String status;
    @NotBlank(message = "salesforce courier id can't be null or empty")
    private String salesforceCourierId;

    public CourierStatus toCourierStatus() {
        CourierStatus courierStatus = new CourierStatus();
        courierStatus.setCreatedAt(LocalDateTime.now());
        courierStatus.setStatus(this.status);
        courierStatus.setSalesforceCourierId(this.salesforceCourierId);
        return courierStatus;
    }

    public CourierStatusLogs toCourierUpdate(Long courierId) {
        CourierStatusLogs courierStatus = new CourierStatusLogs();
        courierStatus.setUpdatedAt(LocalDateTime.now());
        courierStatus.setStatus(this.status);
        courierStatus.setCourierId(courierId);
        courierStatus.setUpdatedBy(this.updatedBy);
        return courierStatus;
    }
}

