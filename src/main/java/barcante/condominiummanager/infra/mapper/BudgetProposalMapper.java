package barcante.condominiummanager.infra.mapper;

import barcante.condominiummanager.infra.repository.budget.model.BudgetProposalsEntity;
import condominiummanager.model.BudgetRequest;
import condominiummanager.model.BudgetsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BudgetProposalMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "budgetValue", source = "value")
    BudgetProposalsEntity toEnity(BudgetRequest request);

    List<BudgetsResponse> toResponses(List<BudgetProposalsEntity> entities);

    @Mapping(target = "value", source = "budgetValue")
    @Mapping(target = "approved", source = "checked")
    @Mapping(target = "descprition", source = "description")
    BudgetsResponse toResponse(BudgetProposalsEntity entity);
}

