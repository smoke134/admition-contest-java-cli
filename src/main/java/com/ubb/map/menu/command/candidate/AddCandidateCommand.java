package com.ubb.map.menu.command.candidate;

import com.ubb.map.services.CandidateCrudService;
import com.ubb.map.domain.Candidate;
import com.ubb.map.exception.DuplicateEntryException;
import com.ubb.map.exception.InvalidObjectException;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by marius on 10/13/16.
 */
public class AddCandidateCommand extends BaseCandidateCommand {

    /**
     * @param key                 The key which identifies the com.ubb.map.menu.command
     * @param text                Short description for the com.ubb.map.menu.command
     * @param candidateCrudService The com.ubb.map.services which handles candidates
     */
    public AddCandidateCommand(String key, String text, CandidateCrudService candidateCrudService) {
        super(key, text, candidateCrudService);
    }

    /**
     * Executes the current com.ubb.map.menu.command
     * @param scanner
     * @param out
     */
    @Override
    public void execute(Scanner scanner, PrintStream out) {
        String name;
        String phone;
        String address;

        out.print("Enter the name of the candidate: ");
        name = scanner.nextLine();
        out.print("Enter the phone of the candidate: ");
        phone = scanner.nextLine();
        out.print("Enter the address of the candidate: ");
        address = scanner.nextLine();

        try {
            Candidate cand = this.candidateCrudService.create(name, phone, address);
            out.println("Added " + cand);
        } catch (InvalidObjectException | DuplicateEntryException e) {
            out.println(e.getMessage());
        }
    }
}
