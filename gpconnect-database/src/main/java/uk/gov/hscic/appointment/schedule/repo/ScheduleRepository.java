package uk.gov.hscic.appointment.schedule.repo;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import uk.gov.hscic.appointment.schedule.model.ScheduleEntity;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
    
    List<ScheduleEntity> findByLocationIdAndEndDateTimeAfterAndStartDateTimeBefore(Long locationId, Date startDate, Date endDate);
    
}
