package com.core.java.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestVisa {
    public static void main(String[] args) {
        List<Employee> empList = Arrays.asList(new Employee(5,1,202301),
                new Employee(6,2,202301),
                new Employee(25,3,202301),
                new Employee(15,1,202202),
                new Employee(20,2,202202),
                new Employee(25,3,202202));


        Map<Integer,Employee> map = new HashMap<>();
        for (Employee employee:empList){
            System.out.println(employee.getId()+"  "+employee.hashCode());
            if(map.get(getKey(employee)) == null){
                map.put(getKey(employee), employee);
            }else{
                if(employee.getSalary() >= map.get(getKey(employee)).getSalary()){
                    map.put(getKey(employee),employee);
                }
            }
        }

        System.out.println(map);

    }

    private static int getKey(Employee employee) {
        return employee.getId();
    }
}

/**
 * emp_id, salary_month, salary_amount
 * 1, Jan 2023, 5
 * 2, Jan, 6
 * 3,Jan, 7
 *  1, Feb 2023, 15
 *  2, Feb, 61
 *  3,feb, 71
 *
 *
 *  1, 15
 *  2, 61
 *  3, 71
 *
 *
 *  select emp_id, max(salary_amount) from table t1 group by emp_id;
 *  select salary_month, max(salary_amount) from table t1 group by salary_month;
 *
 *  Jan 2023, 7
 *  feb 71
 *
 *    1,feb, 15
 *   2, feb, 61
 *   3, feb, 71
 *
 */
