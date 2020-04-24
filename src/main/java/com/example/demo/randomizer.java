package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class randomizer {
    Map<String, String> outrand = new HashMap<String, String>();

    public randomizer() {
        jdbc();
    }

    public Map<String, String> getOutrand() {
        return outrand;
    }

    public void setOutrand(Map<String, String> outrand) {
        this.outrand = outrand;
    }

    public void jdbc() {
        String str = "select * from anime where code=?";
        int id = ThreadLocalRandom.current().nextInt(100, 119 + 1);

        try (Connection conn = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/postgres",
            "postgres", "xxxx");

                Statement stmt = conn.createStatement();) {

            PreparedStatement pre = conn.prepareStatement(str);
            pre.setInt(1, id);
            ResultSet se = pre.executeQuery();
            se.next();
            String s1 = se.getString(2);
            String s2 = se.getString(6);
            System.out.println(s1 + " " + s2);
            outrand.put(s1, s2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}