package barcante.condominiummanager.domain.user.mapper;

import barcante.condominiummanager.infraestructure.repository.user.model.UserEntity;
import condominiummanager.model.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class UserMapper {

    public abstract UserEntity toEntity(UserRequest userRequest);

}
