package datastructures.tree.narrytree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonManager {

    static class Employee {
        int id;
        List<Employee> reports;

        Employee(int id) {
            this.id = id;
            this.reports = new ArrayList<>();
        }
    }

    private static int lowestCommonManager(Employee ceo, Employee emp1, Employee emp2) {
        Employee common = lowestCommonManagerHelper(ceo, emp1, emp2);
        return common == null ? -1 : common.id;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    private static Employee lowestCommonManagerHelper(Employee ceo, Employee emp1, Employee emp2) {
        if (ceo == null)
            return null;
        if (ceo == emp1 || ceo == emp2)
            return ceo;

        int count = 0;
        Employee common = null;

        for (Employee report : ceo.reports) {
            Employee temp = lowestCommonManagerHelper(report, emp1, emp2);
            if (temp != null) {
                count++;
                common = temp;
            }
            // If we have found both the employees in the hierarchy
            if (count == 2)
                return ceo;
        }
        return common;
    }

    private static int lowestCommonManager2(Employee ceo, Employee emp1, Employee emp2) {
        Employee common = lowestCommonManagerHelper2(ceo, emp1, emp2);
        return common == null ? -1 : common.id;
    }

    private static Employee lowestCommonManagerHelper2(Employee ceo, Employee emp1, Employee emp2) {
        if (ceo == null)
            return null;
        if (ceo == emp1 || ceo == emp2)
            return ceo;

        Employee foundFirst = null;
        Employee foundSecond = null;

        for (Employee report : ceo.reports) {
            Employee temp = lowestCommonManagerHelper2(report, emp1, emp2);
            if (temp != null) {
                if (foundFirst == null) {
                    foundFirst = temp;
                } else {
                    foundSecond = temp;
                    break;
                }
            }
        }
        // If both the employees are found in different subtrees, current employee is the common manager
        if (foundFirst != null && foundSecond != null)
            return ceo;
        // If only one employee is found, return that employee
        return foundFirst != null ? foundFirst : foundSecond;
    }

    public static void main(String[] args) {

        //      CEO
        //     /   \
        //  Manager1 Manager2
        //   /   \     \
        // Emp1 Emp2   Emp3

        Employee ceo = new Employee(1);
        Employee manager1 = new Employee(2);
        Employee manager2 = new Employee(3);
        Employee emp1 = new Employee(4);
        Employee emp2 = new Employee(5);
        Employee emp3 = new Employee(6);

        // Build the hierarchy
        ceo.reports.add(manager1);
        ceo.reports.add(manager2);
        manager1.reports.add(emp1);
        manager1.reports.add(emp2);
        manager2.reports.add(emp3);

        System.out.println(lowestCommonManager(ceo, emp1, emp3)); // 1
        System.out.println(lowestCommonManager(ceo, emp1, emp2)); // 2
        System.out.println(lowestCommonManager(ceo, emp2, emp3)); // 1

        System.out.println(lowestCommonManager2(ceo, emp1, emp3)); // 1
        System.out.println(lowestCommonManager2(ceo, emp1, emp2)); // 2
        System.out.println(lowestCommonManager2(ceo, emp2, emp3)); // 1

        System.out.println(lowestCommonManager(ceo, emp1, manager1)); // 1
        System.out.println(lowestCommonManager2(ceo, emp2, manager1)); // 1

        System.out.println(lowestCommonManager(ceo, emp1, new Employee(7))); // -1
    }
}
