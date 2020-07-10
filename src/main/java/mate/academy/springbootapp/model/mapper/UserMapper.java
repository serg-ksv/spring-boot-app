package mate.academy.springbootapp.model.mapper;

import mate.academy.springbootapp.model.User;
import mate.academy.springbootapp.model.dto.ReviewDto;

public class UserMapper {
    public User getUserFromReviewDto(ReviewDto reviewDto) {
        User user = new User();
        user.setId(reviewDto.getUserId());
        user.setProfileName(reviewDto.getProfileName());
        return user;
    }
}
