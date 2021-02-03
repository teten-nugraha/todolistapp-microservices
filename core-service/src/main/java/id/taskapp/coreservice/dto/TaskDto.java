package id.taskapp.coreservice.dto;

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
    private String createdDate;

}
