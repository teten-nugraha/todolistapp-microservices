package id.taskapp.analyticservice.web;

import id.taskapp.analyticservice.dto.AnalyticReportDto;
import id.taskapp.analyticservice.dto.CountReportDto;
import id.taskapp.analyticservice.dto.TaskDto;
import id.taskapp.analyticservice.model.Task;
import id.taskapp.analyticservice.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Project Name     : workspace-services
 * Date Time        : 9/8/2020
 *
 * @author Teten Nugraha
 */

@Tag(name = "Analytic API", description = "Untuk load data-data analyic")
@RestController
@RequestMapping("/analytic")
public class AnalyticController {

    @Autowired
    private TaskService taskService;

    @Operation(summary = "Endpoint ini untuk mengambil semua data todo yang sudah beres")
    @GetMapping("/getList")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Sukses fetch",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Tidak ada data",
                    content = @Content)
    })
    public ResponseEntity<List<AnalyticReportDto>> getList() {
        try {
            List<AnalyticReportDto> taskList = taskService.findAll();
            return new ResponseEntity<>(taskList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Endpoint ini untuk menyimpan data todo yang sudah beres")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Sukses fetch",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "501",
                    description = "Server Error",
                    content = @Content)
    })
    @PostMapping("/createFinishedTask")
    public ResponseEntity<String> createTutorial(@RequestBody TaskDto taskDto) {
        try {
            Task _task = taskService.createFinishedTask(taskDto);
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Endpoint ini untuk mengambil berapa data todo yang sudah beres")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Sukses fetch",
                    content = {@Content(mediaType = "application/json")})
    })
    @GetMapping("/countReport")
    public ResponseEntity<CountReportDto> getCountReport() {
        final CountReportDto dto = taskService.getReport();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
