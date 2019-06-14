package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.entity.ScratchCard;
import com.example.demo.repository.CardRepository;
import com.example.demo.repository.EmployeeRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.USER_AGENT;

/**
 * Anita
 * 6/12/2019
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;



    @GetMapping("/getEmployee")
    public void getEmployees() throws IOException, JSONException {
        JSONArray json = readJsonFromUrl("http://dummy.restapiexample.com/api/v1/employees");
        System.out.println(json.toString());

        //Write JSON file
        try (FileWriter file = new FileWriter("A://employees.json")) {

            file.write(json.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(json.get("id"));

    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = new JSONArray(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    // insert new employee into database
    @PostMapping("addEmployee")
    public Employee addEmployee(@RequestBody Employee emp) {

        return employeeRepository.save(emp);
    }
    // HTTP POST request
    private void sendPost() throws Exception {

        String url = "http://dummy.restapiexample.com/api/v1/create";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    // insert new employee into database
    @PutMapping("/updateEmp")
    public Employee updateEmployee(@RequestBody Employee emp) {
        emp.setDateCreated(new java.sql.Timestamp(new java.util.Date()
                .getTime()));
        return employeeRepository.save(emp);
    }

    @PostMapping("/{empId}")
    public Optional<Employee> getEmployeeById(@PathVariable("empId") int empId) {

        return employeeRepository.findById(empId);
    }


}
