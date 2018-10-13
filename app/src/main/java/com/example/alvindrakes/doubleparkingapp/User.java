package com.example.alvindrakes.doubleparkingapp;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int phoneNumber;
    private List<String> carNumber;

    public User(String name, int phoneNumber, List<String> carNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.carNumber = carNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(List<String> carNumber) {
        this.carNumber = carNumber;
    }

    public static void insertCar(User user){
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        Map<String,Object> updates = new HashMap<>();
        updates.put(firebaseUser.getPhoneNumber(), user.carNumber);

        int carIndex = 1;
        while (!user.carNumber.isEmpty()) {
            updates.put(firebaseUser.getPhoneNumber() + "/car " + carIndex + "/", user.carNumber.remove(0));
            carIndex++;
        }
        databaseReference.updateChildren(updates);
    }
}
