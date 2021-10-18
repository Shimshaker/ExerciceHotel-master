package com.technobel2021.exercicehotel.exception;

import java.sql.SQLDataException;
import java.sql.SQLException;

public class SqlGeneralException extends SQLDataException {

   public SqlGeneralException(){
       super("Il y a une erreur d'entrer e de donnée inconus veuillez essayer plus tard..");
   }
}
