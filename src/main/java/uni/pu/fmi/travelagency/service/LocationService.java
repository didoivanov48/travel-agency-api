package uni.pu.fmi.travelagency.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.pu.fmi.travelagency.dto.CreateLocationDTO;
import uni.pu.fmi.travelagency.dto.ResponseLocationDTO;
import uni.pu.fmi.travelagency.dto.UpdateLocationDTO;
import uni.pu.fmi.travelagency.entity.Location;
import uni.pu.fmi.travelagency.mapper.LocationMapper;
import uni.pu.fmi.travelagency.repository.LocationRepository;

import java.util.List;

@Service
public class LocationService {

    private LocationRepository locationRepository;
    private LocationMapper locationMapper;

    @Autowired
    public LocationService(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    public List<ResponseLocationDTO> getLocations(){
        List<Location> locations = locationRepository.findAll();
        List<ResponseLocationDTO> mappedLocations = locations
                .stream()
                .map(locationMapper::locationToResponse)
                .toList();
        return mappedLocations;
    }

    public ResponseLocationDTO getLocationById(Long id){
        Location location = locationRepository.getReferenceById(id);
        ResponseLocationDTO mappedLocation = locationMapper.locationToResponse(location);
        return mappedLocation;
    }

    public boolean deleteById(Long id){
        locationRepository.deleteById(id);
        return true;
    }

    public ResponseLocationDTO createLocation(CreateLocationDTO createLocationRequest){
        Location location = new Location();
        location.setCity(createLocationRequest.getCity());
        location.setStreet(createLocationRequest.getStreet());
        location.setNumber(createLocationRequest.getNumber());
        location.setCountry(createLocationRequest.getCountry());
        location.setImageUrl(createLocationRequest.getImageUrl());
        locationRepository.save(location);
        return  locationMapper.locationToResponse(location);
    }

    public ResponseLocationDTO updateLocation(UpdateLocationDTO updateLocationRequest){
        Location location = locationRepository
                .findById(updateLocationRequest.getId())
                .orElseThrow();
        location.setImageUrl(updateLocationRequest.getImageUrl());
        location.setCity(updateLocationRequest.getCity());
        location.setStreet(updateLocationRequest.getStreet());
        location.setNumber(updateLocationRequest.getNumber());
        location.setCountry(updateLocationRequest.getCountry());
        locationRepository.save(location);
        return  locationMapper.locationToResponse(location);
    }
}
