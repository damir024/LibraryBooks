package com.example.web;

import com.example.domain.Reward;
import com.example.service.RewardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RewardController {

    private final RewardService rewardService;
    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @PostMapping("/reward")
    @ResponseStatus(HttpStatus.CREATED)
    public Reward saveReward(@RequestBody Reward reward) {
        return rewardService.saveReward(reward);
    }

    @PostMapping("/rewards")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Reward> saveAllRewards (@RequestBody List <Reward> rewards) {
        return rewardService.saveAllRewards(rewards);
    }
    @PostMapping("/reward/{reward_id}/author/{author_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Reward addAuthorToReward (@PathVariable Long reward_id, @PathVariable Long author_id) {
        return rewardService.addAuthorToReward(author_id,reward_id);
    }

    @PostMapping("/reward/{reward_id}/book/{book_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Reward addBookToReward (@PathVariable Long reward_id, @PathVariable Long book_id) {
        return rewardService.addBookToReward(book_id,reward_id);
    }

    @PostMapping("/reward/{reward_id}/publisher/{publisher_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Reward addPublisherToReward (@PathVariable Long reward_id, @PathVariable Long publisher_id) {
        return rewardService.addPublisherToReward(publisher_id,reward_id);
    }

    @GetMapping("/rewards")
    @ResponseStatus(HttpStatus.OK)
    public List<Reward> getAllRewards() {
        return rewardService.getAllRewards();
    }

    @GetMapping("/reward/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Reward getRewardById(@PathVariable Long id) {
        return rewardService.getRewardById(id);
    }

    @PutMapping("/reward/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Reward updateReward(@PathVariable("id") Long id, @RequestBody Reward reward) {
        return rewardService.updateReward(id,reward);
    }

    @DeleteMapping("/reward/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteReward(@PathVariable Long id) {
        return rewardService.deleteReward(id);

    }
    }
