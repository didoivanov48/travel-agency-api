package uni.pu.fmi.travelagency.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.pu.fmi.travelagency.dto.CreateReservationDTO;
import uni.pu.fmi.travelagency.dto.ResponseReservationDTO;
import uni.pu.fmi.travelagency.dto.UpdateReservationDTO;
import uni.pu.fmi.travelagency.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseReservationDTO>> getAllReservations() {
        List<ResponseReservationDTO> allReservations = reservationService.getAllReservations();

        return new ResponseEntity<>(allReservations, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseReservationDTO> getReservationById(@PathVariable Long id) {
        ResponseReservationDTO reservation = reservationService.getReservationById(id);

        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteReservation(@PathVariable Long id) {
        reservationService.deleteById(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseReservationDTO> createReservation(@RequestBody CreateReservationDTO createReservation) {
        ResponseReservationDTO createNewReservation = reservationService.createReservation(createReservation);
        return new ResponseEntity<>(createNewReservation, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseReservationDTO> updateReservation(@RequestBody UpdateReservationDTO updateReservationDTO){
        ResponseReservationDTO updateReservation = reservationService.updateReservation(updateReservationDTO);
        return new ResponseEntity<>(updateReservation, HttpStatus.OK);
    }
}
