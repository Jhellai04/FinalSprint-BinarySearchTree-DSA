package com.keyin.user;

public class UserTest {

    public static void main(String[] args) {
        // Create an instance of User using the default constructor
        User user = new User();

        // Set values using setters
        user.setId(1L);
        user.setTree("sample tree");
        user.setInput("updated input");

        // Retrieve values using getters
        Long userId = user.getId();
        String userTree = user.getTree();
        String userInput = user.getInput();

        // Print values to verify
        System.out.println("User ID: " + userId);
        System.out.println("User Tree: " + userTree);
        System.out.println("User Input: " + userInput);

        // Optional: Add additional tests or assertions to validate behavior
        assert userId.equals(1L) : "User ID should be 1L";
        assert "sample tree".equals(userTree) : "User Tree should be 'sample tree'";
        assert "updated input".equals(userInput) : "User Input should be 'updated input'";
    }
}
