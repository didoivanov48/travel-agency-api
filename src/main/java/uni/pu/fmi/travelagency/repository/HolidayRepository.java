package uni.pu.fmi.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.pu.fmi.travelagency.entity.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {
}
