package id.taskapp.coreservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project Name     : workspace-services
 * Date Time        : 9/8/2020
 *
 * @author Teten Nugraha
 */


@Data
@NoArgsConstructor
public class TaskDto {

    private String id;
    private String kategori;
    private String nama;
    private boolean finished;

    @JsonFormat(pattern="yyyy-MM-dd")
    private String createdDate;

}
