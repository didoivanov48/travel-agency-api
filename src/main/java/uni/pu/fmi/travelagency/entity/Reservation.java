package uni.pu.fmi.travelagency.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "contact_name", nullable = false)
    private String contactName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @ManyToOne(targetEntity = Holiday.class)
    @JoinColumn(name = "holiday")
    private Holiday holiday;
}
