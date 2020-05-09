package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import org.junit.Ignore;

import java.sql.*;

public class CrudSteps {

    private Connection connection;


    @BindingPriority(1)
    @Given("Create database connection")
    public void create_database_connection() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.04:1521:coretest", "ftptest", "ftptest611");
        } catch (ClassNotFoundException e) {
            System.out.println("some problems occurred when trying to have connection to database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    @BindingPriority(2)
    @When(("Post req comes to cucumber application"))
    public void post_req_comes_to_cucumber_application() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into beyki_test(id, name, surname)values(2, 'tina', 'beyki')");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("saved successfully");

        } catch (SQLException e) {
            //System.out.println("sorry some problems occurred while trying to insert");
            e.printStackTrace();
        }
    }

    @Ignore
    @BindingPriority(3)
    @Then("Close connection")
    public void close_connection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("exception occurred while trying to close database connection");
        }

    }

}
