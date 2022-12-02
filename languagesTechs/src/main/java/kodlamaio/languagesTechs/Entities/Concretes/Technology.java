package kodlamaio.languagesTechs.Entities.Concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "Technologies")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Technology {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "name")
        private String name;


        @ManyToOne()
        @JoinColumn(name="language_id")
        private Language language;

}
