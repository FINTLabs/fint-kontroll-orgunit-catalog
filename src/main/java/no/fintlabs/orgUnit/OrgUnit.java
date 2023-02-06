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

}
