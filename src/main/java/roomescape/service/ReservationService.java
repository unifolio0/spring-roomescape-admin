package roomescape.service;

import java.util.List;
import org.springframework.stereotype.Service;
import roomescape.Reservation;
import roomescape.dao.ReservationDao;
import roomescape.dto.ReservationRequest;
import roomescape.dto.ReservationResponse;

@Service
public class ReservationService {

    private final ReservationDao reservationDao;

    public ReservationService(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    public List<ReservationResponse> findAll() {
        List<Reservation> reservations = reservationDao.findAll();
        return reservations.stream()
                .map(ReservationResponse::of)
                .toList();
    }

    public ReservationResponse findById(long id) {
        Reservation reservation = reservationDao.findById(id);
        return ReservationResponse.of(reservation);
    }

    public long save(ReservationRequest reservationRequest) {
        return reservationDao.save(reservationRequest);
    }

    public void deleteById(long id) {
        reservationDao.deleteById(id);
    }
}
