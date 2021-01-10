package com.intuit.tracking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.intuit.tracking.entities.CourierStatusLogs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStatusRequest {

    @NotNull(message = "tracking id can't be null")
    @Min(value = 1000,message = "not a valid tracking id")
    private long trackingId;

    @NotBlank(message = "updated by cant' be null or empty")
    private String updatedBy;

    @NotBlank(message = "status can't be null or empty")
    private String status;

    @NotBlank(message = "From location can't be null or empty")
    private String fromLocation;

    @NotBlank(message = "destination location can't be empty")
    private String destinationLocation;

    public CourierStatusLogs toCourierUpdate() {
        CourierStatusLogs courierStatus = new CourierStatusLogs();
        courierStatus.setUpdatedAt(LocalDateTime.now());
        courierStatus.setStatus(this.status);
        courierStatus.setCourierId(this.trackingId);
        courierStatus.setUpdatedBy(this.updatedBy);
        courierStatus.setFromLocation(this.fromLocation);
        courierStatus.setDestinationLocation(this.destinationLocation);
        return courierStatus;
    }
}
