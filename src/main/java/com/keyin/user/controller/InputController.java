package com.keyin.user.controller;

import com.keyin.tree.BinarySearchTree;
import com.keyin.user.User;
//import com.keyin.user.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InputController {

    private final UserRepository userRepository;

    public InputController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/enter-numbers")
    public String inputPage() {
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    public String processInput(@RequestParam("numbers") String numbersEntered, Model model) {
        try {
            BinarySearchTree bsTree = new BinarySearchTree();
            String[] numbersList = numbersEntered.split("[,\\s]+");

            for (String number : numbersList) {
                int num = Integer.parseInt(number.trim());
                bsTree.insert(num);
            }

            String jsonFormatTree = bsTree.JsonFormat();
            User user = new User();
            user.setInput(numbersEntered);
            user.setTree(jsonFormatTree);
            userRepository.save(user);

            model.addAttribute("jsonData", jsonFormatTree);
            return "process-numbers";
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Invalid number format. Please enter valid integers.");
            return "enter-numbers";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while processing the numbers.");
            return "enter-numbers";
        }
    }

    @GetMapping("/previous-trees")
    public String previousTrees(Model model) {
        try {
            List<User> userInputList = userRepository.findAll();
            List<String> jsonFormatTreeList = convertToJsonFormat(userInputList);
            model.addAttribute("jsonFormatTreeList", jsonFormatTreeList);
            return "previous-trees";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while retrieving previous trees.");
            return "previous-trees";
        }
    }

    private List<String> convertToJsonFormat(List<User> userInputList) {
        List<String> jsonFormatTreeList = new ArrayList<>();
        for (User userInput : userInputList) {
            BinarySearchTree bst = new BinarySearchTree();
            String[] numbersList = userInput.getInput().split("[,\\s]+");
            for (String number : numbersList) {
                int num = Integer.parseInt(number.trim());
                bst.insert(num);
            }
            String jsonFormatTree = bst.JsonFormat();
            jsonFormatTreeList.add(jsonFormatTree);
        }
        return jsonFormatTreeList;
    }
}
