package com.ubb.map.menu.command.department;

import com.ubb.map.services.DepartmentCrudService;
import com.ubb.map.domain.Department;

import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by marius on 10/13/16.
 */
public class DeleteDepartmentCommand extends BaseDepartmentCommand {
    /**
     * @param key                  The key which identifies the com.ubb.map.menu.command
     * @param text                 Short description for the com.ubb.map.menu.command
     * @param departmentCrudService The com.ubb.map.services which handles departments
     */
    public DeleteDepartmentCommand(String key, String text, DepartmentCrudService departmentCrudService) {
        super(key, text, departmentCrudService);
    }

    /**
     * Executes the current com.ubb.map.menu.command
     * @param scanner
     * @param out
     */
    @Override
    public void execute(Scanner scanner, PrintStream out) {
        String id;

        out.print("Enter the id of the department you with to delete: ");
        id = scanner.nextLine();
        scanner.nextLine();
        try {
            Department department = this.departmentCrudService.delete(id);
            out.println("Deleted: " + department);
        } catch (NoSuchElementException ex) {
            out.println("Could not find the department with id " + id);
        }
    }
}
