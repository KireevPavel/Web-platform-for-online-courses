package com.course.project.WebPlatformForOnlineCourses.controller;

import com.course.project.WebPlatformForOnlineCourses.model.User;
import com.course.project.WebPlatformForOnlineCourses.service.friend.FriendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class FriendController {

    private final FriendService friendService;

    @PutMapping("/{id}/friends/{friendId}")
    public void add(@PathVariable long id, @PathVariable long friendId) {
        friendService.addFriend(id, friendId);
    }

    @GetMapping("/{id}/friends")
    public List<User> get(@PathVariable long id) {
        return friendService.getFriends(id);
    }

    @GetMapping("/{id}/friends/common/{secondId}")
    public List<User> getMutualUsersFriends(@PathVariable long id, @PathVariable long secondId) {
        return friendService.getMutualFriends(id, secondId);
    }

    @DeleteMapping("/{id}/friends/{friendId}")
    public void delete(@PathVariable long id, @PathVariable long friendId) {
        friendService.removeFriendById(id, friendId);
    }

}
