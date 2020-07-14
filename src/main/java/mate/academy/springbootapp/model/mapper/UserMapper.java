package mate.academy.springbootapp.model.mapper;

import mate.academy.springbootapp.model.User;
import mate.academy.springbootapp.model.dto.ReviewDto;
import mate.academy.springbootapp.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User getUserFromReviewDto(ReviewDto reviewDto) {
        User user = new User();
        user.setId(reviewDto.getUserId());
        user.setProfileName(reviewDto.getProfileName());
        return user;
    }

    public UserResponseDto getDtoFromUser(User user) {
        var responseDto = new UserResponseDto();
        responseDto.setProfileName(user.getProfileName());
        responseDto.setNumberOfReviews(user.getReviews().size());
        return responseDto;
    }
}
