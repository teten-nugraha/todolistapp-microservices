package id.taskapp.coreservice.repo;

import id.taskapp.coreservice.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, String> {

    @Query(
            nativeQuery = true,
            value = "select * from tb_task where is_finished = ?1"
    )
    List<Task> findByIsAndFinished(boolean finished);

    @Query(
            nativeQuery = true,
            value = "select * from tb_task where nama  like %?1% and  is_finished = false"
    )
    List<Task> findByNamaContaining(String nama);

    @Query(
            nativeQuery = true,
            value = "select * from tb_task "
    )
    List<Task> getAllTasks();
}
