package mate.academy.springbootapp.model.mapper;

import mate.academy.springbootapp.model.User;
import mate.academy.springbootapp.model.dto.ReviewDto;
import mate.academy.springbootapp.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User getUserFromReviewDto(ReviewDto reviewDto) {
        return new User()
                .setId(reviewDto.getUserId())
                .setProfileName(reviewDto.getProfileName());
    }

    public UserResponseDto getDtoFromUser(User user) {
        return new UserResponseDto()
                .setProfileName(user.getProfileName())
                .setNumberOfReviews(user.getReviews().size());
    }
}
