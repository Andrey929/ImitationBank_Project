package org.example;

import Data.DbConnection;
import Data.WorkWithData;
import Front.WorkProgramme;
import Sourse.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DbConnection connection = new DbConnection();
        WorkProgramme.startProgramme();
    }
}