package id.taskapp.coreservice.service;

import id.taskapp.coreservice.domain.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    Task findById(final String id);

    Task saveOrUpdateTask(final Task task);

    void deleteById(final String id);

    void deleteAll();

    List<Task> findByIsFinished(boolean finished);

    List<Task> findByName(final String name);
}
