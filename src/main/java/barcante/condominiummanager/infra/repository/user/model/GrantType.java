package barcante.condominiummanager.infra.repository.user.model;

import lombok.Getter;

@Getter
public enum GrantType {

    TENANT("INQUILINO"),
    TRUSTEE("SINDICO");

    private final String description;


    GrantType(String description) {
        this.description = description;
    }
}
