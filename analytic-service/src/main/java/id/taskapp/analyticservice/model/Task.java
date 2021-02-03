package id.taskapp.analyticservice.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Project Name     : workspace-services
 * Date Time        : 9/8/2020
 *
 * @author Teten Nugraha
 */

@Entity
@Table(name = "task_analyze")
@Data
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String kategori;
    private String nama;
    private boolean finished;
    private LocalDate createdDate;
    private LocalDate finishedDate;

}
