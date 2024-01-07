package uni.pu.fmi.travelagency.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.pu.fmi.travelagency.dto.CreateReservationDTO;
import uni.pu.fmi.travelagency.dto.ResponseReservationDTO;
import uni.pu.fmi.travelagency.dto.UpdateReservationDTO;
import uni.pu.fmi.travelagency.entity.Holiday;
import uni.pu.fmi.travelagency.entity.Reservation;
import uni.pu.fmi.travelagency.mapper.ReservationMapper;
import uni.pu.fmi.travelagency.repository.HolidayRepository;
import uni.pu.fmi.travelagency.repository.ReservationRepository;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final HolidayRepository holidayRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper, HolidayRepository holidayRepository) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.holidayRepository = holidayRepository;
    }

    public List<ResponseReservationDTO> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();

        List<ResponseReservationDTO> mappedReservations = reservations
                .stream()
                .map(reservationMapper::reservationToResponse)
                .toList();
        return mappedReservations;
    }

    public ResponseReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.getReferenceById(id);
        ResponseReservationDTO mappedReservation = reservationMapper.reservationToResponse(reservation);
        return mappedReservation;
    }

    public boolean deleteById(Long id) {
        reservationRepository.deleteById(id);
        return true;
    }

    @Transactional
    public ResponseReservationDTO createReservation(CreateReservationDTO createReservationRequest) {
        Reservation reservation = new Reservation();
        reservation.setContactName(createReservationRequest.getContactName());
        reservation.setPhoneNumber(createReservationRequest.getPhoneNumber());
        Holiday holiday = holidayRepository
                .findById(createReservationRequest.getHoliday())
                .orElseThrow();
        reservation.setHoliday(holiday);
        reservationRepository.save(reservation);
        return reservationMapper.reservationToResponse(reservation);
    }

    @Transactional
    public ResponseReservationDTO updateReservation(UpdateReservationDTO updateReservationRequest){
        Reservation reservation = reservationRepository
                .findById(updateReservationRequest.getHoliday())
                .orElseThrow();
        reservation.setContactName(updateReservationRequest.getContactName());
        reservation.setPhoneNumber(updateReservationRequest.getPhoneNumber());
        Holiday holiday = holidayRepository
                .findById(updateReservationRequest.getHoliday())
                .orElseThrow();
        reservation.setHoliday(holiday);
        reservationRepository.save(reservation);
        return reservationMapper.reservationToResponse(reservation);
    }
}
