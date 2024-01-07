package uni.pu.fmi.travelagency.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "holiday")
@Getter
@Setter
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "price", nullable = false, length = 6, precision = 2)
    private Double price;

    @Column(name = "free_slots", nullable = false)
    private int freeSlots;

    @ManyToOne(targetEntity = Location.class)
    @JoinColumn(name = "location")
    private Location location;

    @OneToMany(mappedBy = "holiday", cascade = CascadeType.REMOVE)
    private Set<Reservation> reservations;
}
