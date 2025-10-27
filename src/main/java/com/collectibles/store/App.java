package com.collectibles.store;

import static spark.Spark.*;
import com.google.gson.*;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    static Logger logger = LoggerFactory.getLogger(App.class);
    static Map<Integer, User> users = new HashMap<>();
    static Gson gson = new Gson();

    public static void main(String[] args) {
        port(4567);
        logger.info("🚀 Starting Spark Collectibles API...");

        // GET /users → Obtiene lista de usuarios
        get("/users", (req, res) -> {
            res.type("application/json");
            return gson.toJson(users.values());
        });

        // GET /users/:id → Obtiene un usuario
        get("/users/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            User user = users.get(id);
            if (user == null) {
                res.status(404);
                return gson.toJson(Map.of("message", "User not found"));
            }
            return gson.toJson(user);
        });

        // POST /users/:id → Crea usuario
        post("/users/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            User newUser = gson.fromJson(req.body(), User.class);
            users.put(id, newUser);
            res.status(201);
            return gson.toJson(Map.of("message", "User created", "user", newUser));
        });

        // PUT /users/:id → Actualiza usuario
        put("/users/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            if (!users.containsKey(id)) {
                res.status(404);
                return gson.toJson(Map.of("message", "User not found"));
            }
            User updatedUser = gson.fromJson(req.body(), User.class);
            users.put(id, updatedUser);
            return gson.toJson(Map.of("message", "User updated", "user", updatedUser));
        });

        // OPTIONS /users/:id → Verifica existencia
        options("/users/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            boolean exists = users.containsKey(id);
            res.type("application/json");
            return gson.toJson(Map.of("exists", exists));
        });

        // DELETE /users/:id → Elimina usuario
        delete("/users/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            User removed = users.remove(id);
            if (removed == null) {
                res.status(404);
                return gson.toJson(Map.of("message", "User not found"));
            }
            return gson.toJson(Map.of("message", "User deleted"));
        });

        logger.info("✅ API running on: http://localhost:4567");
    }

    static class User {
        int id;
        String name;
        String email;
    }
}