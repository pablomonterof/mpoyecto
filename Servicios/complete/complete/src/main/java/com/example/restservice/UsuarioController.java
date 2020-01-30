package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;
import java.net.URL;
import java.util.Scanner; // Import the Scanner class to read text files
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UsuarioController {

    @GetMapping("/login")
    public boolean login(@RequestParam(value = "user", defaultValue = "") String usuario,
            @RequestParam(value = "pass", defaultValue = "") String pass) {
        try {
            File myObj = new File("C:\\\\Archivos\\Usuarios.txt"); //COLOCAR AQUÍ LA RUTA DEL ARCHIVO
            Scanner myReader = new Scanner(myObj);
            String[] data;
            boolean autenticado = false;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine().split(",");
                if (data[0].equals(usuario) && data[1].equals(pass)) {
                    autenticado = true;
                }
            }
            myReader.close();
            return autenticado;
        } catch (FileNotFoundException e) {
            return false;
        }
    }
}
