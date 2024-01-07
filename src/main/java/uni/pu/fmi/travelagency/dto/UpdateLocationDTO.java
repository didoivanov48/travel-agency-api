package uni.pu.fmi.travelagency.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLocationDTO {

    private Long id;
    private String street;
    private String number;
    private String city;
    private String country;
    private String imageUrl;
}
