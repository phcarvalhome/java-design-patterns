package com.phcarvalhome.pattern.adapter;

import com.phcarvalhome.pattern.adapter.core.UserDAOObjectAdapter;
import com.phcarvalhome.pattern.adapter.core.client.Client;
import com.phcarvalhome.pattern.privatedataclass.core.User;

public class Main {

    public static void main(String[] args) {
        doCRUDWithUserDAOObjectAdapter();
    }

    private static void doCRUDWithUserDAOObjectAdapter() {
        System.out.println(">>> TEST BEGINNING >>> doCRUDWithUserDAOObjectAdapter");

        UserDAOObjectAdapter adapter = new UserDAOObjectAdapter();
        Client client = new Client(adapter);
        User newUser = new User("phcarvalhome@gmail.com",
                "123456",
                "0675-0",
                "48889-5");

        System.out.println("--- Built user: " + newUser);

        User savedUser = client.save(newUser);

        System.out.println("--- Saved user: " + savedUser);
        savedUser.setEmail("phcarvalhome@outlook.com");

        User updatedUser = client.update(savedUser);

        System.out.println("--- Updated user: " + updatedUser);
        client.delete(updatedUser);

        User user = client.get(updatedUser.getId());

        System.out.println("--- Deleted user: " + user);
        System.out.println(">>> TEST END >>> doCRUDWithUserDAOObjectAdapter");
    }
}
