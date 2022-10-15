package com.shebogholo.springbootdocker;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "test", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" })})
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    private String name;
}