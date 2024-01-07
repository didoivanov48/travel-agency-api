package uni.pu.fmi.travelagency.mapper;

import org.mapstruct.Mapper;
import uni.pu.fmi.travelagency.dto.ResponseReservationDTO;
import uni.pu.fmi.travelagency.entity.Reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    ResponseReservationDTO reservationToResponse(Reservation reservation);
}
