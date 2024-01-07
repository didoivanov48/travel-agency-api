package uni.pu.fmi.travelagency.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLocationDTO {

    private String street;
    private String number;
    private String city;
    private String country;
    private String imageUrl;
}
