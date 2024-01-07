package uni.pu.fmi.travelagency.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.pu.fmi.travelagency.dto.CreateHolidayDTO;
import uni.pu.fmi.travelagency.dto.ResponseHolidayDTO;
import uni.pu.fmi.travelagency.dto.UpdateHolidayDTO;
import uni.pu.fmi.travelagency.service.HolidayService;

import java.util.List;

@RestController
@RequestMapping("holidays")
public class HolidayController {

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseHolidayDTO>> getAllHolidays(){
        List<ResponseHolidayDTO> holidays = holidayService.getAllHolidays();

        return new ResponseEntity<>(holidays, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseHolidayDTO> getHolidayById(@PathVariable Long id){
        ResponseHolidayDTO holiday = holidayService.getHolidaysById(id);

        return new ResponseEntity<>(holiday, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseHolidayDTO> createHoliday(@RequestBody CreateHolidayDTO createHolidayDTO){
        ResponseHolidayDTO createHoliday = holidayService.createHoliday(createHolidayDTO);
        return new ResponseEntity<>(createHoliday, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseHolidayDTO> updateHoliday(@RequestBody UpdateHolidayDTO updateHolidayDTO){
        ResponseHolidayDTO updateHoliday = holidayService.updateHoliday(updateHolidayDTO);
        return new ResponseEntity<>(updateHoliday, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<Boolean> deleteHoliday(@PathVariable Long id){
        holidayService.deleteById(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }
}
