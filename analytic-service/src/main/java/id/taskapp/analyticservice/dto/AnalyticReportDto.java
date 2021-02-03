package id.taskapp.analyticservice.dto;

import lombok.Data;

/**
 * Project Name     : workspace-services
 * Date Time        : 9/10/2020
 *
 * @author Teten Nugraha
 */

@Data
public class AnalyticReportDto {

    private String uuid;
    private String kategori;
    private String nama;
    private Long countDays;

}
