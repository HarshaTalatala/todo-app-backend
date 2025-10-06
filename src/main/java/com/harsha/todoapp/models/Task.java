package com.harsha.todoapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter @Getter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String task;
    private boolean completed;

}
