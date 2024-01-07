package uni.pu.fmi.travelagency.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ResponseHolidayDTO {

    private Long id;
    private String title;
    private LocalDate startDate;
    private int duration;
    private Double price;
    private int freeSlots;
    private ResponseLocationDTO location;
}
