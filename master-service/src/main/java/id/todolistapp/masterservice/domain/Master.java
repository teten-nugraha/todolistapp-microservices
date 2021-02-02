package id.todolistapp.masterservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tb_master")
@Data
@ToString
@NoArgsConstructor
public class Master {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

    @Column(name = "name")
    private String name;

}
