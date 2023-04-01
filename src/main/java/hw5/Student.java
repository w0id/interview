package hw5;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private Long mark;

    public Student(final String name, final Long mark) {
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "\nid=" + id +
                ", name='" + name + '\'' +
                ", mark=" + mark;
    }
}
