package uni.pu.fmi.travelagency.mapper;

import org.mapstruct.Mapper;
import uni.pu.fmi.travelagency.dto.ResponseLocationDTO;
import uni.pu.fmi.travelagency.entity.Location;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    ResponseLocationDTO locationToResponse (Location location);
}
