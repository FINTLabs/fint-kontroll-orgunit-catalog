package no.fintlabs.orgunit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetaildOrgUnit {
    private Long id;
    private String name;
    private String shortName;
    private String parentRef;
    private List<String> childrenRef = new ArrayList<>();
}
