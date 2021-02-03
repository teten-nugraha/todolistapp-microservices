package id.taskapp.coreservice.web;

import id.taskapp.coreservice.domain.Task;
import id.taskapp.coreservice.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Tag(name = "Core API", description = "Untuk load data dari master service")
@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Operation(summary = "Endpoint ini untuk mengambil semua data todo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Sukses fetch",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Tidak ada data",
                    content = @Content)
    })
    @GetMapping()
    public ResponseEntity<List<Task>> findAll(@RequestParam(required = false)String nama) {
        List<Task> tasks = new ArrayList<>();
        if (StringUtils.isEmpty(nama)) {
            tasks = taskService.findAll();
        }else{
            tasks = taskService.findByName(nama);
        }


        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @Operation(summary = "Endpoint ini untuk mengambil data todolist by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Sukses fetch",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Tidak ada data",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") String id) {
        Task task = taskService.findById(id);
        if (Objects.nonNull(task)) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Endpoint save atau update data todo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Sukses fetch",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Tidak ada data",
                    content = @Content)
    })
    @PostMapping()
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task newTask = taskService.saveOrUpdateTask(task);
        return new ResponseEntity<>(newTask, HttpStatus.OK);
    }

    @Operation(summary = "Mengupdate data todo by ID")
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") String id, @RequestBody Task newTask) {
        Task task = taskService.findById(id);
        if (Objects.nonNull(task)) {
            Task _task = task;
            _task.setKategori(newTask.getKategori());
            _task.setNama(newTask.getNama());
            _task.setFinished(newTask.isFinished());
            return new ResponseEntity<>(taskService.saveOrUpdateTask(_task), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Delete data todo by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable("id") String id) {
        Task task = taskService.findById(id);
        if (Objects.nonNull(task)) {
            taskService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Menghapus semua data todo")
    @DeleteMapping("/all")
    public ResponseEntity<HttpStatus> deleteAllTask() {
        try {
            taskService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Mencari data todo yang sudah beres")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Sukses fetch",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Tidak ada data",
                    content = @Content)
    })
    @GetMapping("/finished")
    public ResponseEntity<List<Task>> getFinishedTask() {
        List<Task> task = taskService.findByIsFinished(true);
        if (task.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(task, HttpStatus.OK);
        }
    }



}
