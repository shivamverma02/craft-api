package com.intuit.tracking.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "courier_status")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourierStatus {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long courierId;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // we can add other values here like address and start point and all
}
