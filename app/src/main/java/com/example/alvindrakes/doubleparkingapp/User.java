package com.example.alvindrakes.doubleparkingapp;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int phoneNumber;
    private List<String> carNumber;


    public User(int phoneNumber, List<String> carNumber) {
        this.phoneNumber = phoneNumber;
        this.carNumber = carNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCarNumber(List<String> carNumber) {
        this.carNumber = carNumber;
    }

    public static void insertCar(List<String> carNumber){
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        Map<String,Object> updates = new HashMap<>();
        updates.put(firebaseUser.getPhoneNumber(), carNumber);

        int carIndex = 1;
        while (!carNumber.isEmpty()) {
            updates.put(firebaseUser.getPhoneNumber() + "/car " + carIndex + "/", carNumber.remove(0));
            carIndex++;
        }
        databaseReference.updateChildren(updates);
    }
}
