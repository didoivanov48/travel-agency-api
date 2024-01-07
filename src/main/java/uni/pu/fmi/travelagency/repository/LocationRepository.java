package uni.pu.fmi.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.pu.fmi.travelagency.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
