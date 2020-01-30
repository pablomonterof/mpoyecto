/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ProductoController {
    
    @GetMapping("/consultar")
    public Producto consultar(@RequestParam(value = "codigo", defaultValue = "") String codigo) {
        try {
            File myObj = new File("C:\\\\Archivos\\Productos.txt"); //COLOCAR AQUÍ LA RUTA DEL ARCHIVO
            Scanner myReader = new Scanner(myObj);
            String[] data;
            Producto Pro = new Producto("", "", 0, 0, 0);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine().split(",");
                if (data[0].equals(codigo)) {
                    Pro = new Producto(data[0], data[1], Float.parseFloat(data[2]), Integer.parseInt(data[3]), Float.parseFloat(data[4]));
                }
            }
            myReader.close();
            return Pro;
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
