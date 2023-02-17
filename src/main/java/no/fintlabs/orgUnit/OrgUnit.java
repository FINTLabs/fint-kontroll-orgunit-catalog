package no.fintlabs.orgUnit;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "public")
public class OrgUnit {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceId;
    private String organisationUnitId;
    private String name;
    private String shortName;
    private String parentRef;
    @ElementCollection
    private List<String> childrenRef = new ArrayList<>();
    private String managerRef;


    public SimpleOrgUnit simpleOrgUnit() {
        return SimpleOrgUnit
                .builder()
                .id(id)
                .name(name)
                .build();
    }

    public DetaildOrgUnit detaildOrgUnit() {
        return DetaildOrgUnit
                .builder()
                .id(id)
                .name(name)
                .shortName(shortName)
                .parentRef(parentRef)
                .childrenRef(childrenRef)
                .build();

    }
}
