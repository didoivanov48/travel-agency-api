package uni.pu.fmi.travelagency.mapper;

import org.mapstruct.Mapper;
import uni.pu.fmi.travelagency.dto.ResponseHolidayDTO;
import uni.pu.fmi.travelagency.entity.Holiday;

@Mapper(componentModel = "spring")
public interface HolidayMapper {

    ResponseHolidayDTO holidayToResponse (Holiday holiday);

}
