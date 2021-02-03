package id.taskapp.analyticservice.repository;

import id.taskapp.analyticservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project Name     : workspace-services
 * Date Time        : 9/8/2020
 *
 * @author Teten Nugraha
 */

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    List<Task> findAllByFinished(boolean finished);

    List<Task> findAllByKategori(String kategori);

}
