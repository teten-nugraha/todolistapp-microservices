package id.todolistapp.masterservice.web;

import io.swagger.v3.oas.annotations.media.Content;
import id.todolistapp.masterservice.domain.Master;
import id.todolistapp.masterservice.service.MasterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Master API", description = "Untuk load data dari master service")
@RestController
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService masterService;

    @Operation(summary = "Endpoint ini untuk mengambil semua data master")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Sukses fetch",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Tidak ada data",
                    content = @Content)
    })
    @GetMapping()
    public ResponseEntity<List<Master>> findAll() {
        List<Master> masters = masterService.findAllMasters();
        if (masters.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(masterService.findAllMasters(), HttpStatus.OK);
    }

}
