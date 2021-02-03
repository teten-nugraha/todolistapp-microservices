package id.taskapp.coreservice.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_task")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "kategori")
    private String kategori;

    @Column(name = "nama")
    private String nama;

    @Column(name = "is_finished")
    private boolean finished;

    @CreatedDate
    @Column(name = "created_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate createdDate;


}
