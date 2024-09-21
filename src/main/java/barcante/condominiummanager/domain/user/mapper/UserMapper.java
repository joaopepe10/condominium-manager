package barcante.condominiummanager.domain.user.mapper;

import barcante.condominiummanager.infra.repository.user.model.UserEntity;
import condominiummanager.model.UserRequest;
import condominiummanager.model.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserEntity toEntity(UserRequest userRequest);

    @Mapping(target = "apartmentNumber", source = "apartment.apartmentNumber")
    UserResponse toResponse(UserEntity entity);
}
