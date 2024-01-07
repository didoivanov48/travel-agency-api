package uni.pu.fmi.travelagency.dto;

import lombok.Getter;
import lombok.Setter;
import uni.pu.fmi.travelagency.entity.Holiday;

@Getter
@Setter
public class CreateReservationDTO {

    private String contactName;
    private String phoneNumber;
    private Long holiday;
}
