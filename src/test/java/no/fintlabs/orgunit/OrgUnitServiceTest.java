package no.fintlabs.orgunit;

import no.fintlabs.opa.AuthorizationClient;
import no.fintlabs.opa.model.Scope;
import no.fintlabs.repository.OrgUnitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class OrgUnitServiceTest {

    @InjectMocks
    private OrgUnitService orgUnitService;

    @Mock
    private AuthorizationClient authorizationClient;

    @Mock
    private OrgUnitRepository orgUnitRepository;

    @Test
    void shouldGetOrgUnitNameByOrgUnitId() {
        List<Scope> scopes = createUserScopes();
        OrgUnit orgUnit = OrgUnit.builder()
                .id(1L)
                .organisationUnitId("198")
                .name("Org unit name")
                .build();

        when(authorizationClient.getUserScopes()).thenReturn(scopes);
        when(orgUnitRepository.findByOrganisationUnitIdIgnoreCase("198")).thenReturn(Optional.of(orgUnit));

        String orgUnitNameByOrgUnitId = orgUnitService.getOrgUnitNameByOrgUnitId("198");

        assertThat(orgUnitNameByOrgUnitId).isEqualTo(orgUnit.getName());
    }

    @Test
    void shouldGetEmptyOrgUnitNameWhenIllegalOrgUnitId() {
        List<Scope> scopes = createUserScopes();
        OrgUnit orgUnit = OrgUnit.builder()
                .id(1L)
                .organisationUnitId("123")
                .name("Org unit name 123")
                .build();

        when(authorizationClient.getUserScopes()).thenReturn(scopes);
        when(orgUnitRepository.findByOrganisationUnitIdIgnoreCase("123")).thenReturn(Optional.of(orgUnit));

        String orgUnitNameByOrgUnitId = orgUnitService.getOrgUnitNameByOrgUnitId("123");

        assertThat(orgUnitNameByOrgUnitId).isEmpty();
    }

    @Test
    void searchOrgUnits() {
        String orgUnitName = "org unit name";
        List<Scope> scopes = createUserScopes();
        OrgUnit orgUnit = OrgUnit.builder()
                .id(1L)
                .organisationUnitId("123")
                .name(orgUnitName)
                .build();

        when(authorizationClient.getUserScopes()).thenReturn(scopes);
        when(orgUnitRepository.findOrgUnitsByOrgUnitName(orgUnitName, Set.of("198", "2", "3"))).thenReturn(List.of(orgUnit));

        List<OrgUnit> orgUnits = orgUnitService.searchOrgUnits(orgUnitName);

        assertThat(orgUnits).hasSize(1);
        assertThat(orgUnits.get(0).getName()).isEqualTo(orgUnitName);
    }

    private static List<Scope> createUserScopes() {
        Scope scope1 = Scope.builder()
                .id("1")
                .objectType("orgunit")
                .orgUnits(List.of("198", "2", "3"))
                .build();

        Scope scope2 = Scope.builder()
                .id("2")
                .objectType("role")
                .orgUnits(List.of("198", "2", "3"))
                .build();

        List<Scope> scopes = List.of(scope1, scope2);
        return scopes;
    }
}
