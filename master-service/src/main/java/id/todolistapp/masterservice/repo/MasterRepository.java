package id.todolistapp.masterservice.repo;

import id.todolistapp.masterservice.domain.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends JpaRepository<Master, String> {
}
