package uni.pu.fmi.travelagency.dto;

import lombok.Getter;
import lombok.Setter;
import uni.pu.fmi.travelagency.entity.Location;

import java.time.LocalDate;

@Getter
@Setter
public class CreateHolidayDTO {
    private String title;
    private LocalDate startDate;
    private int duration;
    private Double price;
    private int freeSlots;
    private Long location;
}
