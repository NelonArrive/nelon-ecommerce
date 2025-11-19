package ru.nelon.demo.ecommerce.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.nelon.demo.ecommerce.dto.user.RegisterUserDto;
import ru.nelon.demo.ecommerce.dto.user.UserDto;
import ru.nelon.demo.ecommerce.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserDto toDto(User user);
	
	User toEntity(RegisterUserDto dto);
	
	@BeanMapping(
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
	)
	void updateUserFromDto(RegisterUserDto dto, @MappingTarget User user);
}
