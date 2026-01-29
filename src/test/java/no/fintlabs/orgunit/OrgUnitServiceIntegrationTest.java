package no.fintlabs.orgunit;

import no.fintlabs.opa.AuthorizationClient;
import no.fintlabs.opa.OpaApiClient;
import no.fintlabs.repository.OrgUnitRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@DataJpaTest()
@Import({OrgUnitService.class})
@Testcontainers
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.test.database.replace=none",
        "spring.datasource.url=jdbc:tc:postgres:15-alpine:///test"
})
public class OrgUnitServiceIntegrationTest extends DatabaseIntegrationTest{
    private static final Logger log = LoggerFactory.getLogger(OrgUnitServiceIntegrationTest.class);
    @Autowired
    private OrgUnitService orgUnitService;
    @Autowired
    private OrgUnitRepository orgUnitRepository;
    @MockBean
    private AuthorizationClient authorizationClient;
    @MockBean
    private OpaApiClient opaApiClient;


    @DisplayName("Get child org units when checking top org unit should return all org units")
    @Test
    public void getChildrenOrgUnits_WhenCheckingTopOrgUnit_ShouldReturnAllOrgUnits(){
        Long orgUnitId = 10L;
        List<OrgUnit> orgUnits = orgUnitService.getChildrenOrgUnits(orgUnitId);
        assertThat(orgUnits.isEmpty()).isFalse();
        assertThat(orgUnits.size()).isEqualTo(7);
    }

    @DisplayName("Get child org units when checking an org unit should return all sub org units")
    @Test
    public void getChildrenOrgUnits_WhenCheckingOrgUnit_ShouldReturnAllSubOrgUnits(){
        Long orgUnitId = 3L;
        List<OrgUnit> orgUnits = orgUnitService.getChildrenOrgUnits(orgUnitId);
        Set<Long> orgUnitIds = orgUnits.stream().map(OrgUnit::getId).collect(Collectors.toSet());
        assertThat(orgUnitIds).containsExactlyInAnyOrder(3L,17L, 35L);
    }

    @DisplayName("Get parent org units when checking an org unit should return all parents")
    @Test
    public void getParentsOrgUnits_WhenCheckingOrgUnit_ShouldReturnAllParents(){
        Long orgUnitId = 28L;
        List<OrgUnit> orgUnits = orgUnitService.getParentOrgUnits(orgUnitId);
        Set<Long> orgUnitIds = orgUnits.stream().map(OrgUnit::getId).collect(Collectors.toSet());
        assertThat(orgUnitIds).containsExactlyInAnyOrder(10L, 28L, 19L, 13L);
    }

    @DisplayName("Get parent org units when checking the top org unit should return itself as parent")
    @Test
    public void getParentsOrgUnits_WhenCheckingTopOrgUnit_ShouldReturnItselfAsParent(){
        Long orgUnitId = 10L;
        List<OrgUnit> orgUnits = orgUnitService.getParentOrgUnits(orgUnitId);
        Set<Long> orgUnitIds = orgUnits.stream().map(OrgUnit::getId).collect(Collectors.toSet());
        assertThat(orgUnitIds).containsExactlyInAnyOrder(10L);
    }
}
