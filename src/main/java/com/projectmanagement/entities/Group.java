package com.projectmanagement.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString(exclude = {"allEmployeesInGroup"})
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GROUP_DETAILS")
public class Group {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "group_sequence")
    @SequenceGenerator(name = "group_sequence", sequenceName = "group_sequence", allocationSize = 100)
    @Column(name = "GROUP_ID")
    private long groupId;
    @Column (name = "GROUP_NAME")
    private String groupName;
    @JsonManagedReference
    @OneToMany(mappedBy = "empGroup")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Employee> allEmployeesInGroup = new ArrayList<>();
}
