package com.tugonn.controller;

import com.tugonn.entity.User;
import com.tugonn.service.UserService;
import com.tugonn.util.HTTPResponse;
import com.tugonn.util.HttpConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Chhavi Priya Tanwar
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    HTTPResponse httpResponse;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String index(){
        return "User Service get started : {}";
    }

    @GetMapping("/user/list")
    public Map<String,Object> getAllUser(){
        List<User> userList = userService.getAllUser();
        if (userList.size()>0){
            return httpResponse.getHttpResponse(userList, HttpConstants.SUCCESS,HttpConstants.SUCCESS_STATUS_CODE);
        }else {
            return httpResponse.getHttpResponse(null, HttpConstants.DATA_NOT_FOUND,HttpConstants.BAD_REQUEST_STATUS_CODE);
        }
    }

    @GetMapping("/user")
    public Map<String,Object> getUserById(@RequestParam(value = "id")int id){
        Optional<User> userOptional = userService.getUserById(id);
        if (userOptional.isPresent()){
            return httpResponse.getHttpResponse(userOptional, HttpConstants.SUCCESS,HttpConstants.SUCCESS_STATUS_CODE);
        }else {
            return httpResponse.getHttpResponse(null,HttpConstants.DATA_NOT_FOUND,HttpConstants.BAD_REQUEST_STATUS_CODE);
        }
    }

    @GetMapping("/user/v1/{id}")
    public Map<String,Object> getUserByIdV1(@PathVariable int id){
        Optional<User> userList = userService.getUserById(id);
        if (userList.isPresent()){
            return httpResponse.getHttpResponse(userList, HttpConstants.SUCCESS,HttpConstants.SUCCESS_STATUS_CODE);
        }else {
            return httpResponse.getHttpResponse(null,HttpConstants.DATA_NOT_FOUND,HttpConstants.BAD_REQUEST_STATUS_CODE);
        }
    }


    @PostMapping("/user")
    public Map<String,Object> createUser(@RequestParam(value = "email") String email,
                                         @RequestParam(value = "phone") String phone,
                                         @RequestParam(value = "username") String username,
                                         @RequestParam(value = "password") String password,
                                         @RequestParam(value = "country_code") String countryCode,
                                         @RequestParam(value = "type") String type,
                                         @RequestParam(value = "device_id") String deviceId,
                                         @RequestParam(value = "otp") String otp,
                                         @RequestParam(value = "device_token") String deviceToken,
                                         @RequestParam(value = "first_name") String firstName,
                                         @RequestParam(value = "last_name") String lastName,
                                         @RequestParam(value = "about") String about,
                                         @RequestParam(value = "artist_band_name") String artistBandName,
                                         @RequestParam(value = "gender") String gender,
                                         @RequestParam(value = "photo_url") String photoUrl,
                                         @RequestParam(value = "login_type") String loginType,
                                         @RequestParam(value = "category") String category,
                                         @RequestParam(value = "instrument") String instrument,
                                         @RequestParam(value = "genre") String genre,
                                         @RequestParam(value = "social_urls") String socialUrls,
                                         @RequestParam(value = "services") String services,
                                         @RequestParam(value = "creation_ts") String creationTs,
                                         @RequestParam(value = "modified_ts") String modifiedTs
    ){


        User user = new User();
//        user.setId(userDTO.getId());
        user.setEmail(email);
        user.setPhone(phone);
        user.setUsername(username);
        user.setCountryCode(countryCode);

        String passwordEncoded = passwordEncoder.encode(password);
        user.setPassword(passwordEncoded);

        user.setType(type);
        user.setDeviceId(deviceId);
        user.setOtp(otp);
        user.setDeviceToken(deviceToken);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAbout(about);
        user.setArtistBandName(artistBandName);
        user.setGender(gender);
        user.setPhotoUrl(photoUrl);
        user.setLoginType(loginType);
        user.setCategory(category);
        user.setInstrument(instrument);
        user.setGenre(genre);
        user.setSocialUrls(socialUrls);
        user.setServices(services);
        user.setCreationTs(System.currentTimeMillis() / 1000);
        user.setModifiedTs(0);

        userService.createUser(user);


        return httpResponse.getHttpResponse(user, HttpConstants.DATA_CREATED_SUCCESS,HttpConstants.SUCCESS_STATUS_CODE);

    }


    @PutMapping("/user")
    public Map<String,Object> updateUser(@RequestParam(value = "id") int id,
                                         @RequestParam(value = "email") String email,
                                         @RequestParam(value = "phone") String phone,
                                         @RequestParam(value = "username") String username,
                                         @RequestParam(value = "password") String password,
                                         @RequestParam(value = "country_code") String countryCode,
                                         @RequestParam(value = "type") String type,
                                         @RequestParam(value = "device_id") String deviceId,
                                         @RequestParam(value = "otp") String otp,
                                         @RequestParam(value = "device_token") String deviceToken,
                                         @RequestParam(value = "first_name") String firstName,
                                         @RequestParam(value = "last_name") String lastName,
                                         @RequestParam(value = "about") String about,
                                         @RequestParam(value = "artist_band_name") String artistBandName,
                                         @RequestParam(value = "gender") String gender,
                                         @RequestParam(value = "photo_url") String photoUrl,
                                         @RequestParam(value = "login_type") String loginType,
                                         @RequestParam(value = "category") String category,
                                         @RequestParam(value = "instrument") String instrument,
                                         @RequestParam(value = "genre") String genre,
                                         @RequestParam(value = "social_urls") String socialUrls,
                                         @RequestParam(value = "services") String services,
                                         @RequestParam(value = "creation_ts") String creationTs,
                                         @RequestParam(value = "modified_ts") String modifiedTs


    ){

        if (id <=0){
            return httpResponse.getHttpResponse(null,HttpConstants.INVALID_INPUT,HttpConstants.BAD_REQUEST_STATUS_CODE);
        }

       Optional<User> userOptional = userService.getUserById(id);

        if (!userOptional.isPresent()){
            return httpResponse.getHttpResponse(null,HttpConstants.DATA_NOT_FOUND,HttpConstants.BAD_REQUEST_STATUS_CODE);
        }

        User user = userOptional.get(); // Get the existing user from Optional

        user.setId(id);
        user.setEmail(email);
        user.setPhone(phone);
        user.setUsername(username);
        user.setCountryCode(countryCode);

        String passwordEncoded = passwordEncoder.encode(password);
        user.setPassword(passwordEncoded);

        user.setType(type);
        user.setDeviceId(deviceId);
        user.setOtp(otp);
        user.setDeviceToken(deviceToken);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAbout(about);
        user.setArtistBandName(artistBandName);
        user.setGender(gender);
        user.setPhotoUrl(photoUrl);
        user.setLoginType(loginType);
        user.setCategory(category);
        user.setInstrument(instrument);
        user.setGenre(genre);
        user.setSocialUrls(socialUrls);
        user.setServices(services);
        user.setCreationTs(user.getCreationTs());
        user.setModifiedTs(System.currentTimeMillis()/1000);


        userService.updateUser(user);

        return httpResponse.getHttpResponse(user, HttpConstants.DATA_UPDATED_SUCCESS,HttpConstants.SUCCESS_STATUS_CODE);

    }

    @DeleteMapping("/user")
    public Map<String,Object> deleteUserById(@RequestParam(value = "id")int id){
        Optional<User> userOptional = userService.getUserById(id);
        if (userOptional.isPresent()){
            userService.deleteUserById(id);
            return httpResponse.getHttpResponse(null, HttpConstants.DATA_DELETED_SUCCESS,HttpConstants.SUCCESS_STATUS_CODE);
        }else {
            return httpResponse.getHttpResponse(null,HttpConstants.DATA_NOT_FOUND,HttpConstants.BAD_REQUEST_STATUS_CODE);
        }
    }

//    private String encryptPassword(String plainPassword) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder.encode(plainPassword);
//    }

}
