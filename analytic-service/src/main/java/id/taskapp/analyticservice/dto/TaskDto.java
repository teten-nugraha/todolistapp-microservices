package id.taskapp.analyticservice.dto;

import lombok.Data;

/**
 * Project Name     : workspace-services
 * Date Time        : 9/8/2020
 *
 * @author Teten Nugraha
 */

@Data
public class TaskDto {

    private String id;
    private String kategori;
    private String nama;
    private boolean finished;
    private String createdDate;


}
