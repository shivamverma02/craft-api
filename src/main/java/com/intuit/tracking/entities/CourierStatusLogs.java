package com.intuit.tracking.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "courier_status_updates")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourierStatusLogs {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name ="log_id")
    private Long logId;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "courier_id")
    private Long courierId;

    @Column(name = "status")
    private String status;

    @Column(name = "from_location")
    private String fromLocation;

    @Column(name = "destination_location")
    private String destinationLocation;

}
