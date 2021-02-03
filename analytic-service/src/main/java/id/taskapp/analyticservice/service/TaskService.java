package id.taskapp.analyticservice.service;

import id.taskapp.analyticservice.dto.AnalyticReportDto;
import id.taskapp.analyticservice.dto.CountReportDto;
import id.taskapp.analyticservice.dto.TaskDto;
import id.taskapp.analyticservice.model.Task;

import java.util.List;

/**
 * Project Name     : workspace-services
 * Date Time        : 9/8/2020
 *
 * @author Teten Nugraha
 */

public interface TaskService {

    Task createFinishedTask(TaskDto task);

    List<Task> findAllByFinished(boolean finished);

    List<Task> findAllByKategori(String kategori);

    List<AnalyticReportDto> findAll();

    CountReportDto getReport();

}
