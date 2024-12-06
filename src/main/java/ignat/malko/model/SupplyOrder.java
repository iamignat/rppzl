package ignat.malko.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
@Data
@Table(name = "supply_orders")
public class SupplyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "purchase_request_id")
    private PurchaseRequest purchaseRequest;

    @ManyToOne()
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private LocalDate orderDate;

    private String status; // PENDING, COMPLETED, CANCELLED

}

