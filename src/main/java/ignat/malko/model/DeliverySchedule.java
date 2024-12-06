package ignat.malko.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
@Data
@Table(name = "delivery_schedules")
public class DeliverySchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "supply_order_id")
    private SupplyOrder supplyOrder;

    private LocalDate deliveryDate;
    private Integer priority;
    private Integer deliveryTime;

    private String status;

    private Double supplierRating;

}
