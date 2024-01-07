package uni.pu.fmi.travelagency.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.pu.fmi.travelagency.dto.CreateHolidayDTO;
import uni.pu.fmi.travelagency.dto.ResponseHolidayDTO;
import uni.pu.fmi.travelagency.dto.UpdateHolidayDTO;
import uni.pu.fmi.travelagency.entity.Holiday;
import uni.pu.fmi.travelagency.entity.Location;
import uni.pu.fmi.travelagency.mapper.HolidayMapper;
import uni.pu.fmi.travelagency.repository.HolidayRepository;
import uni.pu.fmi.travelagency.repository.LocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HolidayService {

    private final HolidayRepository holidayRepository;
    private final HolidayMapper holidayMapper;
    private final LocationRepository locationRepository;

    @Autowired
    public HolidayService(HolidayRepository holidayRepository, HolidayMapper holidayMapper, LocationRepository locationRepository) {
        this.holidayRepository = holidayRepository;
        this.holidayMapper = holidayMapper;
        this.locationRepository = locationRepository;
    }

    public List<ResponseHolidayDTO> getAllHolidays() {

        List<Holiday> holidays = holidayRepository.findAll();

        List<ResponseHolidayDTO> mappedHolidays = holidays
                .stream()
                .map(holidayMapper::holidayToResponse)
                .toList();

        return mappedHolidays;
    }

    public ResponseHolidayDTO getHolidaysById(Long id){
        Holiday holiday = holidayRepository.getReferenceById(id);
        ResponseHolidayDTO mappedHoliday = holidayMapper.holidayToResponse(holiday);
        return mappedHoliday;
    }

    public boolean deleteById(Long id){
        holidayRepository.deleteById(id);
        return true;
    }

    @Transactional
    public ResponseHolidayDTO createHoliday(CreateHolidayDTO holidayRequest) {
        Holiday holiday = new Holiday();
        holiday.setTitle(holidayRequest.getTitle());
        holiday.setPrice(holidayRequest.getPrice());
        holiday.setFreeSlots(holidayRequest.getFreeSlots());
        Location location = locationRepository
                .findById(holidayRequest.getLocation())
                .orElseThrow();
        holiday.setLocation(location);
        holiday.setDuration(holidayRequest.getDuration());
        holiday.setStartDate(holidayRequest.getStartDate());
        holidayRepository.save(holiday);
        return holidayMapper.holidayToResponse(holiday);
    }

    @Transactional
    public ResponseHolidayDTO updateHoliday(UpdateHolidayDTO holidayRequest){
        Holiday holiday = holidayRepository.findById(holidayRequest.getId()).orElseThrow();
        holiday.setStartDate(holidayRequest.getStartDate());
        holiday.setTitle(holidayRequest.getTitle());
        holiday.setPrice(holidayRequest.getPrice());
        holiday.setDuration(holidayRequest.getDuration());
        Location location = locationRepository
                .findById(holidayRequest.getLocation())
                .orElseThrow();
        holiday.setLocation(location);
        holiday.setFreeSlots(holidayRequest.getFreeSlots());
        holidayRepository.save(holiday);
        return holidayMapper.holidayToResponse(holiday);
    }
}
