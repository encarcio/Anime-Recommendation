package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
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

    private static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("postgres://rlrbwnwrimhkrf:2b9d9f64a5bdeb6329c0dc378664bb5562991623386aa9b6bd45d8d447fa757d@ec2-50-17-21-170.compute-1.amazonaws.com:5432/dlg747a1gkdl8"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath()
                + "?sslmode=require";

        return DriverManager.getConnection(dbUrl, username, password);
    }

    public void jdbc() {
        String str = "select * from anime where code=?";
        int id = ThreadLocalRandom.current().nextInt(100, 119 + 1);

        try (Connection conn = getConnection();

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