import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest {

    @Test
    public void employeeNameTest() {
        Employee employee = new Employee();
        employee.setName("Martins");
        Assert.assertEquals(employee.getName(), "Martins");
    }

    @Test
    public void employeeSurnameTest() {
        Employee employee = new Employee();
        employee.setSurname("Rudevics");
        Assert.assertEquals(employee.getSurname(), "Rudevics");
    }

    @Test
    public void employeeAge() {
        Employee employee = new Employee();
        employee.setAge(34);
        Assert.assertEquals(employee.getAge(), 34);
    }

    @Test
    public void employeeRole() {
        Employee employee = new Employee();
        employee.setRole("Technican");
        Assert.assertEquals(employee.getRole(), "Technican");
    }

    @Test
    public void testAllArguments() {
        Employee newEmployee = new Employee("Pete", "Pen", 30, "Janitor");
        Assert.assertEquals(newEmployee.getName(), "Pete");
        Assert.assertEquals(newEmployee.getSurname(), "Pen");
        Assert.assertEquals(newEmployee.getAge(), 30);
        Assert.assertEquals(newEmployee.getRole(), "Janitor");
    }
}
