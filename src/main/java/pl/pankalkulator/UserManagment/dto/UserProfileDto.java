package pl.pankalkulator.UserManagment.dto;

import lombok.Data;

@Data
public class UserProfileDto {

    private String firstName;

    private String lastName;

    private String biography;

    private String photo;

    //private List<Review> reviews;
}
